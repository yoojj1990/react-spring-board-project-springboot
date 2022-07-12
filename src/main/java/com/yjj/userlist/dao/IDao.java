package com.yjj.userlist.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.yjj.userlist.dto.UserDto;

@Mapper
public interface IDao {
	
	ArrayList<UserDto> userList(); // 모든 유저 회원 리스트 불러오기
	
	UserDto userById(int id); // id로 특정 유저 정보 불러오기
	
	void insertUser(UserDto user); // 새로운 회원 정보 입력하기
	
	void updateUser(UserDto user); // 회원 정보 수정
	
	void deleteUser(int id); // id로 특정 회원 삭제학시
	
}
