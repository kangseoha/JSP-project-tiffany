package com.seoho.tiffany.action.notice;

import com.seoho.tiffany.action.Action;

public class NoticeFactory {
	// ?cmd=notice
	public static Action route(String cmd) {
		if (cmd.equals("list")) {
			return new NoticeListAction();
		} else if(cmd.equals("detail")) {
			return new NoticeDetailAction();
		}else if(cmd.equals("write")) {
			return new NoticeWriteAction();
		}else if(cmd.equals("writeProc")) {
			return new NoticeWriteProcAction();
		}else if(cmd.equals("modify")) {
			return new NoticeModifyAction();
		}else if(cmd.equals("modifyProc")) {
			return new NoticeModifyProcAction();
		}else if(cmd.equals("delete")) {
			return new NoticeDeleteAction();
		}else if(cmd.equals("commentWrite")) {
			return new NoticeCommentWriteAction();
		}else if(cmd.equals("commentdelete")) {
			return new NoticeCommentDeleteAction();
		}
		return null;
	}
}


