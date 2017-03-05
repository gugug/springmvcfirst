package cn.ssm.po;

import java.util.HashMap;
/**
 * ��װ����pojo 
 */
import java.util.List;
import java.util.Map;

public class AlbumVo {
	//Album��Ϣ
	private Album album;
	
	//Ϊ��ϵͳ����չ�ԣ���ԭʼ�����ɵ�po ������չ
	private AlbumCustom albumCustom;
	
	//����ר����Ϣ
	private List<AlbumCustom> albumItemsList;
	
	//map��������
	private Map<String,Object> itemInfo = new HashMap<String,Object>();

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public AlbumCustom getAlbumCustom() {
		return albumCustom;
	}

	public void setAlbumCustom(AlbumCustom albumCustom) {
		this.albumCustom = albumCustom;
	}

	public List<AlbumCustom> getAlbumItemsList() {
		return albumItemsList;
	}

	public void setAlbumItemsList(List<AlbumCustom> albumItemsList) {
		this.albumItemsList = albumItemsList;
	}

	public Map<String, Object> getItemInfo() {
		return itemInfo;
	}

	public void setItemInfo(Map<String, Object> itemInfo) {
		this.itemInfo = itemInfo;
	}
	

}
