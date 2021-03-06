package com.sullay.web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sullay.domain.User;

@RestController
//通过这里配置使下面的映射都在/users下 
@RequestMapping(value="/users")
public class UserController {
	static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());
	@RequestMapping(value="/", method=RequestMethod.GET)
	public List<User> getUserList(){
		List<User> r = new ArrayList<User>(users.values()); 
        return r; 
	}
	@RequestMapping(value="/", method=RequestMethod.POST) 
    public String postUser(User user) { 
        
        users.put(user.getId(), user); 
        return "success"; 
    }
	@RequestMapping(value="/{id}", method=RequestMethod.GET) 
    public User getUser(@PathVariable Long id) { 
        // url中的id可通过@PathVariable绑定到函数的参数中 
        return users.get(id); 
    }
	 @RequestMapping(value="/{id}", method=RequestMethod.PUT) 
	    public String putUser(@PathVariable Long id, @ModelAttribute User user) { 
	        // 处理"/users/{id}"的PUT请求，用来更新User信息 
	        User u = users.get(id); 
	        u.setName(user.getName()); 
	        u.setAge(user.getAge()); 
	        users.put(id, u); 
	        return "success"; 
	    }
	 @RequestMapping(value="/{id}", method=RequestMethod.DELETE) 
	    public String deleteUser(@PathVariable Long id) { 
	        // 处理"/users/{id}"的DELETE请求，用来删除User 
	        users.remove(id); 
	        return "success"; 
	    } 
}
