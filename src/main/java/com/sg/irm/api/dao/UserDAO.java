package com.sg.irm.api.dao;

import java.util.List;

import com.sg.irm.entity.UserEntity;

public interface UserDAO {
	public UserEntity getUser(String userName);

	public UserEntity saveUser(UserEntity userVO);

	public List<UserEntity> getAllUsers();
}
