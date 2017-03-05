package cn.ssm.service;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import cn.ssm.dao.MySQLAlbum;
import cn.ssm.po.Album;

public class SpiderPic {
	public String getContent(String url) {
		System.out.println(url);
		String content = "";
		try {
			Document doc = Jsoup.connect(url).data("query", "Java") // 请求参数
					.userAgent("I ’ m jsoup") // 设置 User-Agent
					.cookie("auth", "token") // 设置 cookie
					.timeout(3000) // 设置连接超时时间
					.get(); // 访问url
			content = doc.toString(); // 获取新闻事件网页的静态源代码
		} catch (IOException e) {
			e.printStackTrace();
		}
//		System.out.println("content:"+content);
		rwFile(content, "D:/javaEE/workspace/springmvcfirst/content.txt");

		return content;
	}
	
//	public String getContent(String url) {
//		String result = "";
//		BufferedReader bf = null;
//		try {
//
//			URL realUrl = new URL(url);
//			URLConnection connection = realUrl.openConnection();
//			connection.connect();
//			InputStream is = connection.getInputStream();
//			InputStreamReader isr = new InputStreamReader(is,"utf-8");
//			bf = new BufferedReader(isr);
//			String line;
//			while ((line = bf.readLine()) != null) {
//				result += line;
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			if (bf != null) {
//				try {
//					bf.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
////		System.out.println("content"+result);
////		rwFile(result, "D:/javaEE/workspace/springmvcfirst/content.txt");
//
//		return result;
//	}

	public void rwFile(String data, String address) {
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(address);
			bw = new BufferedWriter(fw);
			bw.write(data);
			bw.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public Map<String, String> getPic(String content) {
		Map<String, String> map = new HashMap<String, String>();
		String picUrlNameReg = "<img class=\"cover\" src=\"(http://.*?)\".*?class=\"albumName\".*?title=\"(.*?)\">";
		Pattern picUrlNamePattern = Pattern.compile(picUrlNameReg,Pattern.MULTILINE | Pattern.DOTALL);
		Matcher picUrlName = picUrlNamePattern.matcher(content);
		StringBuffer sbPicUrlName = new StringBuffer();
		while (picUrlName.find()) {
			String urlName = picUrlName.group(2) + " " + picUrlName.group(1);
			System.out.println(urlName);
			map.put(picUrlName.group(2), picUrlName.group(1));
			sbPicUrlName.append(urlName + "\r\n");
		}
		return map;
	}

	public Map<String, String> mainGetImg(String singerName) {
		System.out.println("222222");
		String url = "http://baike.baidu.com/item/" + singerName; // 网址
		Map<String, String> urlNameMap = null;
		try {
			String content = getContent(url);
			System.out.println("这里"+content);
			urlNameMap = getPic(content);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return urlNameMap;

	}

	public void saveAlbumPic(String singerName) {
		List<Album> listAlbum = new ArrayList<Album>();
		Map<String,String> urlNameMap = mainGetImg(singerName);
		Set<String> set = urlNameMap.keySet();
		MySQLAlbum dbhelper = new MySQLAlbum();
		singerName = URLDecoderEncoder.toCharacter(singerName);
		for (String obj : set) {
			System.out.println(obj + "-->" + urlNameMap.get(obj));
			String picName = (String) obj;	
			System.out.println("1 "+picName);
			System.out.println("2 "+singerName);
			listAlbum.add(new Album(picName, singerName, "/Img1/" + singerName+"/"+picName+".jpg"));
		}
		DownloadPic.mainGetImg(singerName,urlNameMap);

		dbhelper.insertAlbum(listAlbum);
	}
	
public static void main(String[] args) {
	new SpiderPic().saveAlbumPic("品冠");
//	new SpiderPic().getContent("http://baike.baidu.com/item/\u5f20\u6770");
}

}
