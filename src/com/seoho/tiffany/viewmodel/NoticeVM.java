package com.seoho.tiffany.viewmodel;

import java.util.List;

import com.seoho.tiffany.model.Comment;
import com.seoho.tiffany.model.Notice;
import com.seoho.tiffany.model.User;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder

public class NoticeVM {
	private Notice notice;
	private User user;
	private List<Comment> comment;
		
	@Builder
	public NoticeVM(Notice notice, User user, List<Comment> comment) {
		super();
		this.notice = notice;
		this.user = user;
		this.comment = comment;
	}
	
	
}
