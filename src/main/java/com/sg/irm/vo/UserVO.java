package com.sg.irm.vo;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sg.irm.entity.UserEntity;
import com.sg.irm.entity.UserRoleEntity;

public class UserVO {
	private Integer userId;
	private String userName;
	@JsonIgnore
	private String password;
	private List<String> userRoles;

	public UserVO() {
	}

	public UserVO(UserEntity userEntity) {
		if (userEntity != null) {
			this.userId = userEntity.getUserId();
			this.userName = userEntity.getUserName();
			this.password = userEntity.getPassword();
			Set<UserRoleEntity> roleEntities = userEntity.getUserRoles();
			if (roleEntities != null && roleEntities.size() > 0) {
				this.userRoles = roleEntities.stream().map(UserRoleEntity::getRoleName).collect(Collectors.toList());
			}
		}
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<String> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<String> userRoles) {
		this.userRoles = userRoles;
	}
}
