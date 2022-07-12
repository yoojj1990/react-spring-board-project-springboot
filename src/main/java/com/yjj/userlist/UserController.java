package com.yjj.userlist;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yjj.userlist.dao.IDao;
import com.yjj.userlist.dto.UserDto;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	IDao dao;
	
	@GetMapping
	public ArrayList<UserDto> userList() {
		
		System.out.println(dao.userList());
		System.out.println("회원리스트 출력 성공");
				
		return dao.userList();		
	}
	
	@PostMapping
	public void insertUser(@RequestBody UserDto user) {
		dao.insertUser(user);
		System.out.println("새로운 회원 정보 입력 성공");
	}
	
	@GetMapping("/{id}")
	public UserDto userById(@PathVariable int id) {
		
		UserDto userBySearch = dao.userById(id);
		System.out.println("회원 정보 가져오기 성공");
		System.out.println(dao.userById(id));
		
		return userBySearch;
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable int id) {
		dao.deleteUser(id);
		System.out.println("회원 삭제 성공");
	}
	
	@PutMapping("/{id}")
	public void updateUser(@PathVariable int id, @RequestBody UserDto user) {
		
		System.out.println("회원정보 업데이트 실행");
		
		dao.updateUser(user);
		
		
	}
	

}
