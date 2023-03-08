package co.dev.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.common.Control;
import co.dev.service.NoticeService;
import co.dev.service.NoticeServiceMybatis;
import co.dev.vo.NoticeVO;

public class NoticeRemoveControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		int num = Integer.parseInt(req.getParameter("num"));
		NoticeVO vo = new NoticeVO();
		vo.setNoticeId(num);
		
		NoticeService service = new NoticeServiceMybatis();
	}

}
