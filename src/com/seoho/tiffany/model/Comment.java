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
public class Comment {
	private int commentno;
	private int userno;
	private int noticeno;
	private String content;
	private Timestamp commentCreateTime;
	private String username;
}
