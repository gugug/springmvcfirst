package cn.ssm.po;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import cn.ssm.controller.validation.ValidGroup1;

public class Album {
	
	private String id;
	
	//校验名称1到30字符之间
	//message是校验出错误信息显示的信息,在properties文件中写
	//group:此校验属于哪个分组，group可以定义多个分组
	@Size(min=1,max=30,message="{album.album_name.length.error}",groups={ValidGroup1.class})
	private String album_name;
	
	//@NotNull(message="{album.singer.isNull}")
	@Size(min=1,max=10,message="{album.album_name.length.error}")
	private String singer;
	
	private String album_url;
	

	public Album() {
		super();
	}


	public Album(String album_name, String singer, String album_url) {
		super();
		this.album_name = album_name;
		this.singer = singer;
		this.album_url = album_url;
	}


	public Album(String id, String album_name, String singer, String album_url) {
		super();
		this.id = id;
		this.album_name = album_name;
		this.singer = singer;
		this.album_url = album_url;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getAlbum_name() {
		return album_name;
	}
	public void setAlbum_name(String album_name) {
		this.album_name = album_name;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public String getAlbum_url() {
		return album_url;
	}
	public void setAlbum_url(String album_url) {
		this.album_url = album_url;
	}
	
	

}
