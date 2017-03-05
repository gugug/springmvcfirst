package cn.ssm.po;

import java.util.HashMap;
/**
 * 包装类型pojo 
 */
import java.util.List;
import java.util.Map;

public class AlbumVo {
	//Album信息
	private Album album;
	
	//为了系统的扩展性，对原始的生成的po 进行扩展
	private AlbumCustom albumCustom;
	
	//批量专辑信息
	private List<AlbumCustom> albumItemsList;
	
	//map类型属性
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
