package com.bwf.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bwf.dao.UserMapper;
import com.bwf.entity.Menu;
import com.bwf.entity.User;
import com.bwf.service.IUserService;
import com.bwf.utils.StringUtils;

@Controller
@RequestMapping("user")
public class UserController {
	
	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	IUserService userService;

	
	// 显示登录页面
	@GetMapping("login")
	public String login( Integer error , ModelMap modelMap ){
		modelMap.addAttribute("error", error);
		return "user/login";
	}
	
	// 进行登录
	@PostMapping("doLogin")
	public String doLogin( User user , HttpSession session ){
		logger.info("{}, {}" , user.getUsername() , user.getPassword());
		
		// 把密码进行加密：
		user.setPassword( StringUtils.md5( user.getPassword() ) );
		
		logger.info( "password : {}" , user.getPassword() );
		
		// 执行登录 功能 
		// 登录失败， 返回null , 登录成功， 返回 带有 menu 的 user 对象
		User loginUser = userService.login( user );
		
		if ( loginUser == null ) {
			// 登录失败
			logger.info("登录失败，用户名或密码错误");
			
			// 带着错误信息， 跳转到 登录页面
			return "redirect:/user/login?error=1";
			
		} else {
			// 登录成功
			logger.info("登录成功");
			
			//logger.warn(  loginUser.getUserId() + "" );
			
			// 查询 菜单集合
			//User userWithMenus = userService.getMenusByUserId( loginUser.getUserId() );
//
//			
//			logger.warn(
//					"{} , {} , {} , {}" ,
//					userWithMenus.getUserId() ,
//					userWithMenus.getUsername() , 
//					userWithMenus.getNickname() ,
//					userWithMenus.getAvater()
//			);
			
			// 写入 session 
			session.setAttribute("user", loginUser );

			// 跳转到 首页
			return "redirect:/index";
		}
		
	}


	// 退出登录
	@GetMapping("logout")
	public String logout( HttpSession session ){
		session.removeAttribute("user");
		return "redirect:/user/login";
	}

	
	//员工管理show 方法
	@GetMapping("show")
	public String show(Integer page,Integer pagesize,ModelMap modelMap){
		//List<User>allUsers=userService.getAllUser();
		if(page==null){
			page=1;
		}
		pagesize=10;
		
		modelMap.addAttribute("page",page);
		
		Integer allCount=userService.getAllUserCount();
		
		Integer allPages=(int)Math.ceil(allCount*1.0/pagesize);
		
		modelMap.addAttribute("allPages",allPages);
				
		List<User>allUsersByPage=userService.getAllUserByPage(page,pagesize);
		
		modelMap.addAttribute("allUsersByPage",allUsersByPage);
		
		return "user/show";
	}
	
	@GetMapping("delete/{id}")
	public String delete(@PathVariable Integer id){
		userService.delete(id);
		return "redirect:/user/show";
	}
	
	
	
	
	
	
}
