package com.seoho.tiffany.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Product {
	int productno;
	String type;
	String productname;
	String madeof;
	String content;
	String detail;
	String images;
	
}
