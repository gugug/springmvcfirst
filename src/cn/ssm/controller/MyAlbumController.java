package cn.ssm.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.ssm.controller.validation.ValidGroup1;
import cn.ssm.dao.MySQLAlbum;
import cn.ssm.exception.CustomException;
import cn.ssm.po.Album;
import cn.ssm.po.AlbumVo;

@Controller
@RequestMapping("/items")
public class MyAlbumController{
	
	//歌手分类
	//ModelAttribute("itemtypes")itemtypes指定方法的返回值放到request中的key
	@ModelAttribute("itemtypes")
	public Map<String,String> getItemTypes(){
		Map<String,String> itemTypes = new HashMap<String,String>();
		itemTypes.put("101", "粤语");
		itemTypes.put("102", "国语");
		
		return itemTypes;
	}
	
	
	
	@RequestMapping("/queryAlbum")
	 public ModelAndView queryAlbum(HttpServletRequest request) throws Exception {
		System.out.println(request.getParameter("id"));
		
		List<Album> albumList = new MySQLAlbum().getInfo();
		ModelAndView modelAndView = null;
		modelAndView = new ModelAndView();
		modelAndView.addObject("albumList", albumList);
		modelAndView.setViewName("items/albumList");
		return modelAndView;
	}
	
	/**
	 * 修改专辑信息
	 * @param request
	 * @param model
	 * @param id
	 * @param album_name
	 * @param album_id
	 * @param album11
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/editAlbum",method={RequestMethod.POST,RequestMethod.GET})
	public String editAlbum(HttpServletRequest request,Model model,String id,String album_name,@RequestParam(value="id",required=true) String album_id,Album album11) throws Exception{
		System.out.println("修改时页面："+album_name);
		System.out.println("修改时页面参数绑定id："+id);
		System.out.println("修改时页面：");
		System.out.println(request.getParameter("id"));//只有这个可以获得
		System.out.println(request.getParameter("album_name"));
		System.out.println(request.getParameter("singer"));
		Album album = new MySQLAlbum().selectAlbum(album_id);
		
//		//判断是否有为空，根据id查询，抛出异常，提示用户不存在该id
//		if(album == null){
//			throw new CustomException("修改的专辑信息不存在");
//		}
		
		model.addAttribute("album",album);
		return "items/editAlbum";
	}
	
	//REST查询信息，输出json
	///itemsView/{id} 里的{id}表示将这个位置的参数，传到@PathVariable("id")指定的“id”中
	@RequestMapping("/itemsView/{id}")
	public @ResponseBody Album itemsView(@PathVariable("id") String id) throws Exception{
		
		//调用service查询
		Album album = new MySQLAlbum().selectAlbum(id);
		
		return album;
	}
	
	
	/**
	 * 修改信息提交
	 * @param request
	 * @param album_name
	 * @param album_id
	 * @param album11
	 * @param bindingResult
	 * @return
	 * @throws Exception
	 */
	//在需要检验的pojo前边添加@Validated，在需要检验的pojo后边添加BindingResult bindingResult接收检验出错信息
	//注意：@Validated和BindingResult bindingResult是配对出现，并且前后顺序不变
	//value={ValidGroup1.class}指定使用ValidGroup1分组的校验
	@RequestMapping(value="/editAlbumSubmit")
	public String editAlbumSubmit(Model model,HttpServletRequest request,String album_name,@RequestParam(value="id",required=true) String album_id,
			@Validated(value={ValidGroup1.class}) Album album11, BindingResult bindingResult, MultipartFile file) throws Exception{
		System.out.println("提交修改页面参数绑定："+album_name);
		System.out.println("修改内容");
		String id = request.getParameter("id");
		String album_name1= request.getParameter("album_name");
		String singer = request.getParameter("singer");
//		String album_url = request.getParameter("album_url");
		
		
		//获取检验错误信息
		if(bindingResult.hasErrors()){
			//输出错误信息
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			for(ObjectError objectError:allErrors){
				
				System.out.println("错误信息"+objectError.getDefaultMessage());
			}
			//将错误信息传输到页面
			model.addAttribute("allErrors", allErrors);
			return "items/editAlbum";
		}
		
		//上传图片
		String fileName = null;
		if (file != null){
			//存储图片的路径
			String path = request.getSession().getServletContext().getRealPath("upload");
			String picPath = "D:\\javaEE\\Img";
			//获取原始的图片名称
			fileName = file.getOriginalFilename();
			System.out.println(path);
			//生成新的文件名称
			File targetFile = new File(picPath, fileName);
			if (!targetFile.exists()) {
				targetFile.mkdirs();
			}
			// 保存
			try {
				file.transferTo(targetFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		Album album = new Album(id, album_name1, singer, fileName);
		new MySQLAlbum().updateAlbum(album_id, album);
		return "forward:queryAlbum.action";
	}
	
	
	@RequestMapping(value="/addAlbum",method={RequestMethod.POST,RequestMethod.GET})
	public String addAlbum(HttpServletRequest request,Model model) throws Exception{
		System.out.println("add"+request.getParameter("id"));
		System.out.println(request.getParameter("album_name"));
		System.out.println(request.getParameter("singer"));
		return "items/addAlbum";
		
	}
	
	
	@RequestMapping(value="/addAlbumSubmit")
	public String addAlbumSubmit(HttpServletRequest request,Model model) throws Exception{
		System.out.println("增加内容");
		String album_name= request.getParameter("album_name");
		String singer = request.getParameter("singer");
		String album_url = request.getParameter("album_url");
		Album album = new Album(album_name, singer, album_url);
		new MySQLAlbum().insertAlbum(album);
		return "forward:queryAlbum.action";
		
	}
	
	/**
	 * 删除单个
	 * @param request
	 * @param album_name
	 * @param album_id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/deleteAlbum",method={RequestMethod.POST,RequestMethod.GET})
	public String deleteAlbum(HttpServletRequest request,String album_name,@RequestParam(value="id",required=true) String album_id) throws Exception{
		System.out.println("删除内容");
		System.out.println(request.getParameter("id"));
		System.out.println(request.getParameter("album_name"));
		System.out.println(request.getParameter("singer"));
		new MySQLAlbum().deleteAlbum(album_id);
		System.out.println("参数绑定："+album_name);
		return "forward:queryAlbum.action";
	}
	
	/**
	 * 批量删除多个,数组接收
	 */
	@RequestMapping("/deleteItems")
	public String deleteItems(Integer[] items_id) throws Exception{
		//调用service 
		//...
		return "success";
	}
	
	/**
	 * 批量修改提交    list接收
	 * @param request
	 * @param model
	 * @param searchContent
	 * @param search
	 * @return
	 * @throws Exception
	 */
	//批量修改商品页面，将商品信息查询出来，在页面中可以编辑商品信息
	@RequestMapping(value="/editItemsQuery",method={RequestMethod.POST,RequestMethod.GET})
	public String editItemsQuery(HttpServletRequest request,Model model,String searchContent,@RequestParam(value="searchContent",required=true) String search) throws Exception{
		List<Album> albumList = new MySQLAlbum().searchAlbum(searchContent);
		model.addAttribute("albumList", albumList);
		return "items/editItemsQuery";
	}
	
	//批量修改商品的提交
	//通过AlbumVo接收批量提交的信息，将提交的信息存储到itemsVo的albumItemsList属性中
	@RequestMapping("/editItemsAllSubmit")
	public String editItemsAllSubmit(AlbumVo itemsVo) throws Exception{
		return "success";
	}
	
	/**
	 * map 参数绑定
	 */
	//显示增加名字的页面
	@RequestMapping("/addName")
	public String addName() throws Exception{
		return "items/addName";
	}
	
	//通过AlbumVo接收批量提交的信息，将提交的信息存储到itemsVo的itemInfo属性中
	@RequestMapping("/addNameSubmit")
	public String addNameSubmit(AlbumVo itemsVo) throws Exception{
		System.out.println(itemsVo.getItemInfo());
		return "success";
	}
	
	
	/**
	 * 根据条件查询查询
	 * @param request
	 * @param model
	 * @param searchContent
	 * @param search
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/searchAlbum",method={RequestMethod.POST,RequestMethod.GET})
	public String searchAlbum(HttpServletRequest request,Model model,String searchContent,@RequestParam(value="searchContent",required=true) String search) throws Exception{
		System.out.println("request方法："+request.getParameter("searchContent"));
		List<Album> albumList = new MySQLAlbum().searchAlbum(searchContent);
		System.out.println("参数绑定："+searchContent);
		System.out.println("注解绑定："+search);
		model.addAttribute("albumList", albumList);
		return "items/searchAlbum";
	}
	
	@RequestMapping(value = "/showUpload")
	public String showUpload() {
		return "items/upload";
	}
	
	
	@RequestMapping(value = "/upload")
	public String upload(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request,
			ModelMap model) {

		System.out.println("开始");
		//存储图片的路径
		String path = request.getSession().getServletContext().getRealPath("upload");
		String picPath = "D:\\javaEE\\Img";
		//获取原始的图片名称
		String fileName = file.getOriginalFilename();
		// String fileName = new Date().getTime()+".jpg";
		System.out.println(path);
		//生成新的文件名称
		
		File targetFile = new File(picPath, fileName);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		// 保存
		try {
			file.transferTo(targetFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
//		model.addAttribute("fileUrl", request.getContextPath() + "/upload/" + fileName);
		model.addAttribute("fileUrl", fileName);

		return "items/result";
	}


}
