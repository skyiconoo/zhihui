package com.duihao.spring_boot_quartz.controller;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.duihao.spring_boot_quartz.aop.UserAccess;
import com.duihao.spring_boot_quartz.entity.User;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 
 * @author lichenlin
 * @datetime 2018年6月25日下午9:44:03
 */
@RestController
public class UserController {


	/**
	 * 用户信息
	 * @author lichenglin
	 * @datetime 2018年6月25日下午9:47:55
	 * @return
	 */
	@ApiIgnore
	@RequestMapping("/user")
	@UserAccess(desc = "second2222") 
	public Map<String, Object> user(){
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("user", "1");
		return map;
	}
	
	/**
	 * 获取用户信息
	 * @author lichenglin
	 * @datetime 2018年6月29日上午10:28:55
	 * @return
	 */
	@ApiOperation(value="获取用户信息",notes="根据用户主键获取user信息")
	@RequestMapping(value="/getuser",method=RequestMethod.GET)
	public User getuser() {
		User user=new User();
		user.setId("10");
		user.setName("李成林");
		user.setPassword("22277");
		return user;
	}
	
	/**
	 * getuser
	 * @author lichenglin
	 * @datetime 2018年6月29日上午11:07:10
	 * @param user
	 * @return
	 */
	@ApiOperation(value="获取用户信息POST",notes="POST根据用户主键获取user信息")
	@ApiImplicitParam(name = "user", value = "用户", required = true, dataType = "User")
	@RequestMapping(value="getuser",method=RequestMethod.POST)
	public User getuserpost(@RequestBody User user) {
		return user;
	}
	
	@RequestMapping(value="getpath",method=RequestMethod.GET)
	public Map<String, Object> getpath(){
		Map<String, Object> map=new HashMap<String, Object>();
		//获取跟目录
		File path;
		try {
			path = new File(ResourceUtils.getURL("classpath:").getPath());
			if(!path.exists()) path = new File("");
			System.out.println("path:"+path.getAbsolutePath());

			//如果上传目录为/static/images/upload/，则可以如下获取：
			File upload = new File(path.getAbsolutePath(),"static/images/upload/");
			if(!upload.exists()) upload.mkdirs();
			System.out.println("upload url:"+upload.getAbsolutePath());
			//在开发测试模式时，得到的地址为：{项目跟目录}/target/static/images/upload/
			//在打包成jar正式发布时，得到的地址为：{发布jar包目录}/static/images/upload/
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		map.put("path", "2222");
		return map;
	}
}
