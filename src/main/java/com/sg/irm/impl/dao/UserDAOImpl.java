package com.sg.irm.impl.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sg.irm.api.dao.UserDAO;
import com.sg.irm.entity.UserEntity;
import com.sg.irm.repository.UserRepository;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserEntity getUser(String userName) {
		return userRepository.findByUserName(userName);
	}

	@Override
	public UserEntity saveUser(UserEntity userEntity) {
		return userRepository.saveAndFlush(userEntity);
	}

	@Override
	public List<UserEntity> getAllUsers() {
		return userRepository.findAll();
	}
}
