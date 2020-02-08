package com.seoho.tiffany.action.product;

import com.seoho.tiffany.action.Action;

public class ProductFactory {
	// ?cmd=list&type=ring
	public static Action route(String cmd) {
		if (cmd.equals("list")) {
			return new ProductListAction();
		} else if (cmd.equals("detail")) {
			return new ProductDetailAction();
		} else if (cmd.equals("write")) {
			return new ProductWriteAction();
		}else if (cmd.equals("writeProc")) {
			return new ProductWriteProcAction();
		} else if (cmd.equals("modify")) {
			return new ProductModifyAction();
		}else if (cmd.equals("modifyProc")) {
			return new ProductModifyProcAction();
		}else if (cmd.equals("delete")) {
			return new ProductDeleteAction();
		}
		return null;
	}
}
