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

public class Notice {
	private int noticeno;
	private int userno;
	private String title;
	private String content;
	private Timestamp noticeCreateTime;
	private int pageno;
}
