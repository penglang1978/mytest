package com.pl.mytest.view;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pl.mytest.entity.User;
import com.pl.mytest.service.AddressService;
import com.pl.mytest.service.UserService;

@Controller
public class UserController{
	private UserService userService;
	private AddressService addressService;
//	{
//		System.out.println("init UserController");
//	}
	
	@RequestMapping("listUser")
	public String listUser(HttpServletRequest req){
		System.out.println("user count");
		List<User> users = userService.getAllUser(null, null);
		
		System.out.println("user count : "+users.size());
		req.setAttribute("users", users);
		System.out.println("listUser method was invoked..."+new Date());
		return "listUser";
	}
	
	@RequestMapping(value="addUser", method=RequestMethod.GET)
	public String addUser(){
		System.out.println("addUser method was invoked...");
		return "addUser";
	}
	
	@RequestMapping(value="addUserFirstStep", method=RequestMethod.POST)
	public String addUserFirstStep(HttpServletRequest req) {
//		System.out.println(req.getParameter("user").getClass().getName()+"~~~~~~~~~~~");
//		System.out.println(user.getName()+"======"+user.getPasswd());
		User user = initUser(req);
		req.getSession().setAttribute("user", user);
//		System.out.println(user.getName()+"---"+user.getPhone());
		return "addAddress";
	}

	@RequestMapping(value="toUpdateUser", method=RequestMethod.GET)
	public String toUpdateUser(@RequestParam Long uid, HttpServletRequest req){
		User user = userService.getOneUser(uid);
		req.setAttribute("user", user);
		return "updateUser";
	}
	
	@RequestMapping(value="updateUser", method=RequestMethod.POST)
	public String updateUser(HttpServletRequest req){
		User user = initUser(req);
		userService.updateUser(user);
		return "redirect:listUser.do";
	}
	
	@RequestMapping(value="deleteUser", method=RequestMethod.GET)
	public String deleteUser(@RequestParam Long uid){
		userService.deleteUser(uid);
		return "redirect:listUser.do";//重定向到listUser.do
	}
	
	/**
	 * 获得Ajax异步请求，并将请求数据以JSON格式响应�?
	 * @param name Reuqest中的name参数�?
	 * @param age Reuqest中的age参数�?
	 * @param phone Reuqest中的phone参数�?
	 * @return List<User> 返回的包含User对象的集合对象在标注的作用下生成JSON字符串响应�?
	 */
	@RequestMapping(value="ajaxGetUser", method=RequestMethod.GET)
	public @ResponseBody List<User> ajaxGetUser(@RequestParam String name, @RequestParam Integer age, @RequestParam String phone){
		Map<String,Object> likeCondition = new HashMap<String, Object>();
		if(name != null && name.length()>0){
			likeCondition.put("name", "%"+name+"%");
		}
		if(age != null ){
			likeCondition.put("age", age);
		}
		if(phone != null && phone.length()>0){
			likeCondition.put("phone", "%"+phone+"%");
		}
		List<User> users = userService.getUserNeeded(likeCondition);
		System.out.println(users.size()+"=========="+name+"==="+age+"==="+phone+"==="+likeCondition.size());
		return users;
	}
	
	//由于在applicationContext-mvc.xml中配置了SimpleMappingExceptionResolver，则此处不再起作用�?
	@ExceptionHandler(RuntimeException.class)
	public String exceptionHandler(){
		System.out.println("The UserController throws an Exception...");
		return "errorPage";
	}
	
	private User initUser(HttpServletRequest req){
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		String age = req.getParameter("age");
		String passwd = req.getParameter("passwd");
		System.out.println(name+"---"+phone+"---"+age+"---"+passwd);
		User user = new User(name, Integer.parseInt(age), phone, passwd);
		String uid = req.getParameter("uid");
		if(uid!=null){
			user.setUid(Long.parseLong(uid));
		}
		return user;
	}
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public AddressService getAddressService() {
		return addressService;
	}

	public void setAddressService(AddressService addressService) {
		this.addressService = addressService;
	}
	
}
