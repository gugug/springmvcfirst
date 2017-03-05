package cn.ssm.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.ssm.exception.CustomException;
import cn.ssm.po.Album;
import cn.ssm.service.URLDecoderEncoder;

public class MySQLAlbum {

	DBhelper dbhelper = new DBhelper();

	public List<Album> getInfo() {
		List<Album> albumList = new ArrayList<Album>();
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			conn = dbhelper.getConnection();
			String sql = "SELECT * FROM album ";
			preStmt = conn.prepareStatement(sql);
			rs = preStmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("album_name");
				String singer = rs.getString("singer");
				String url = rs.getString("album_url");
				albumList.add(new Album(id, name, singer, url));
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbhelper.closeAll(conn, preStmt, rs);
		}
		return albumList;
	}

	public Album selectAlbum(String album_id) throws Exception {
		Album album = null;
		Connection conn = null;
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		try {
			conn = dbhelper.getConnection();
			String sql = "SELECT * FROM album WHERE id = " + album_id;
			preStmt = conn.prepareStatement(sql);
			rs = preStmt.executeQuery();
			
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("album_name");
				String singer = rs.getString("singer");
				String url = rs.getString("album_url");
				album = new Album(id, name, singer, url);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbhelper.closeAll(conn, preStmt, rs);
		}
		
		//�ж��Ƿ���Ϊ�գ�����id��ѯ���׳��쳣����ʾ�û������ڸ�id
		if(album == null){
			throw new CustomException("�޸ĵ�ר����Ϣ������");
		}
		return album;
	}

	public int updateAlbum(String album_id, Album album) {
		Connection conn = null;
		PreparedStatement preStmt = null;
		int rs = 0;
		try {
			conn = dbhelper.getConnection();
			String sql = "update album set  album_name=?,singer=?,album_url=? where id=?";// ע��Ҫ��where����
			preStmt = conn.prepareStatement(sql);
			preStmt.setString(1, (album.getAlbum_name()));
			preStmt.setString(2, (album.getSinger()));// ���ߣ�preStmt.setInt(1,ֵ);
			preStmt.setString(3, (album.getAlbum_url()));
			preStmt.setString(4, album.getId());
			rs = preStmt.executeUpdate();

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbhelper.closeAll(conn, preStmt, null);
		}
		return rs;
	}

	public int insertAlbum(Album album) {
		Connection conn = null;
		PreparedStatement preStmt = null;
		int rs = 0;
		try {
			conn = dbhelper.getConnection();
			String sql = "insert into album (album_name,singer,album_url) values(?,?,?)";
			preStmt = conn.prepareStatement(sql);
			preStmt.setString(1, album.getAlbum_name());
			preStmt.setString(2, album.getSinger());
			preStmt.setString(3, album.getAlbum_url());
			rs = preStmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbhelper.closeAll(conn, preStmt, null);
		}
		return rs;
	}
	
	public int insertAlbum(List<Album> listAlbum) {
		
		Connection conn = null;
		PreparedStatement preStmt = null;
		int rs = 0;
		try {
			conn = dbhelper.getConnection();
			for (Album album : listAlbum){
				String sql = "insert into album (album_name,singer,album_url) values(?,?,?)";
				preStmt = conn.prepareStatement(sql);
				preStmt.setString(1, album.getAlbum_name());
				preStmt.setString(2, album.getSinger());
				preStmt.setString(3, album.getAlbum_url());
				rs = preStmt.executeUpdate();
				if(rs!=0){
					System.out.println("����ɹ�");
				}
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbhelper.closeAll(conn, preStmt, null);
		}
		return rs;
	}
	

	public int deleteAlbum(String album_id) {
		Connection conn = null;
		PreparedStatement preStmt = null;
		int rs = 0;
		try {
			conn = dbhelper.getConnection();
			String sql = "delete from album where id = ?";
			preStmt = conn.prepareStatement(sql);
			preStmt.setString(1, album_id);
			rs = preStmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbhelper.closeAll(conn, preStmt, null);
		}
		return rs;
	}

	public List<Album> searchAlbum(String searchContent) {
		List<Album> albumList = new ArrayList<Album>();
		Connection conn = null;
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		try {

			conn = dbhelper.getConnection();
			String sql;
			sql = "SELECT * FROM album WHERE album_name LIKE ?";
			preStmt = conn.prepareStatement(sql);
			preStmt.setString(1, "%" + searchContent + "%");
			rs = preStmt.executeQuery();
			System.out.println(preStmt.toString());
			while (rs.next()) {
				
				String id = rs.getString("id");
				System.out.println(id);
				String name = rs.getString("album_name");
				String singer = rs.getString("singer");
				String url = rs.getString("album_url");
				albumList.add(new Album(id, name, singer, url));
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbhelper.closeAll(conn, preStmt, rs);
		}
		return albumList;
	}
	
	
	public static void main(String[] args) {
		new MySQLAlbum().searchAlbum("ר��");
	}

}
