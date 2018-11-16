package com.sg.irm.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.sg.irm.vo.UserVO;

@Entity
@Table(name = "USER")
@SequenceGenerator(name = "user_seq", sequenceName = "USER_SEQ")
public class UserEntity {
	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
	private Integer userId;
	@Column(name = "USER_NAME")
	private String userName;
	private String password;
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "USER_ROLES", joinColumns = { @JoinColumn(name = "USER_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "ROLE_ID") })
	private Set<UserRoleEntity> userRoles;

	public UserEntity() {
	}

	public UserEntity(UserVO userVO) {
		if(userVO != null){
			this.userId = userVO.getUserId();
			this.userName = userVO.getUserName();
			this.password = userVO.getPassword();
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

	public Set<UserRoleEntity> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRoleEntity> userRoles) {
		this.userRoles = userRoles;
	}
}
