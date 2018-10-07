package com.bwf.entity;



/**
 * 最基础的实体类
 * @author admin
 *
 */
public class User {
	
	
	
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", gender=" + gender + ", score=" + score + "]";
	}
	public User() {
		super();
	}
	
	private Integer userId;
	private String username;
	private String gender;
	private Integer score;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
}
