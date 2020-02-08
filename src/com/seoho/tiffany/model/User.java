package com.seoho.tiffany.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class User {
	int userno;
	int admin;
	String userid;
	String username;
	String password;
	String email;
	String address;
	int tel;
	Timestamp createTime;
	
}
