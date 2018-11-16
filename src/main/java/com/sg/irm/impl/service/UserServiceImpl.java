package com.sg.irm.impl.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sg.irm.api.dao.UserDAO;
import com.sg.irm.api.service.UserService;
import com.sg.irm.entity.UserEntity;
import com.sg.irm.vo.UserVO;

@Service(value = "userService")
@Transactional
public class UserServiceImpl implements UserDetailsService, UserService {

	@Autowired
	private UserDAO userDAO;

	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		UserVO userVO = getUser(userName);
		if (userVO == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new User(userVO.getUserName(), userVO.getPassword(), getAuthority(userVO.getUserRoles()));
	}

	private List<SimpleGrantedAuthority> getAuthority(List<String> userRoles) {
		return userRoles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
	}

	@Override
	public UserVO getUser(String userName) {
		return new UserVO(userDAO.getUser(userName));
	}

	@Override
	public UserVO saveUser(UserVO userVO) {
		return new UserVO(userDAO.saveUser(new UserEntity(userVO)));
	}

	@Override
	public List<UserVO> getAllUsers() {
		List<UserVO> userVOs = new ArrayList<UserVO>();
		for(UserEntity userEntity : userDAO.getAllUsers()){
			userVOs.add(new UserVO(userEntity));
		}
		return userVOs;
	}
}
