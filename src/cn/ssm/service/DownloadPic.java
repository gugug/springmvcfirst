package cn.ssm.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import cn.ssm.po.Album;

public class DownloadPic {

	public static void downloadImgByNet(String imgSrc, String filePath,
			String fileName) {
		BufferedOutputStream bos = null;
		BufferedInputStream bis = null;
		InputStream is = null;
		FileOutputStream fos = null;
		try {
			URL url = new URL(imgSrc);
			URLConnection conn = url.openConnection();
			conn.setConnectTimeout(3 * 1000);
			conn.setRequestProperty("User-Agent",
					"Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
			is = conn.getInputStream();
			bis = new BufferedInputStream(is);
			byte[] bs = new byte[1024];
			int len = 0;
			File saveDir = new File(filePath);
			if (!saveDir.exists()) {
				saveDir.mkdir();
			}
			File file = new File(saveDir + File.separator + fileName);
			fos = new FileOutputStream(file);
			bos = new BufferedOutputStream(fos);
			while ((len = bis.read(bs)) != -1) {
				bos.write(bs, 0, len);
				bos.flush();

			}
			System.out.println("下载成功");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e) {

					e.printStackTrace();
				}

			}
			if (bis != null) {
				try {
					is.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		}
	}

	public static String illegalSymbol(String str) {
		if (str.contains("/") || str.contains("\\") || str.contains("?")
				|| str.contains(":") || str.contains("*") || str.contains("\"")
				|| str.contains("<") || str.contains(">")) {
			str = str.replace("/", " ");
			str = str.replace("\\", " ");
			str = str.replace("?", " ");
			str = str.replace(":", " ");
			str = str.replace("*", " ");
			str = str.replace("\"", " ");
			str = str.replace("<", " ");
			str = str.replace(">", " ");
			return str;
		} else {
			return str;
		}
	}

	public static Map<String, String> mainGetImg(String singerName, Map<String, String> urlNameMap) {
		try {
			Set<String> set = urlNameMap.keySet();
			for (String obj : set) {

				System.out.println(obj + "-->" + urlNameMap.get(obj));
				String picName = (String) obj;
				String picUrl = (String) urlNameMap.get(obj);
				picName = illegalSymbol(picName);
				downloadImgByNet(picUrl, "D:/javaEE/Img/Img1/" + singerName, picName
						+ ".jpg");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return urlNameMap;

	}


	public static void main(String[] args) {
		Map<String, String> urlNameMap = new HashMap<String, String>();
		urlNameMap.put("不能说的秘密电影原声带", "http://e.hiphotos.baidu.com/baike/w%3D137/sign=2f4a1bdff71fbe091c5ec7175c610c30/cb8065380cd79123c35cb0dda8345982b3b780de.jpg"
			);
		mainGetImg("品冠",urlNameMap);
		
		
	}

}


