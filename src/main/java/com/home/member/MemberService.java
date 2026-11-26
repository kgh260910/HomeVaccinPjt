package com.home.member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MemberService {
	
	final private MemberDao memberDao;
	
	public MemberService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public int signupConfirm(HttpServletRequest request, HttpServletResponse response) {
		
		// ID 중복체크
		String admin_id = request.getParameter("admin_id");
		String admin_pw = request.getParameter("admin_pw");
		String admin_mail = request.getParameter("admin_mail");
		String admin_phone = request.getParameter("admin_phone");
		
		boolean isMember = memberDao.isMember(admin_id);
		
		return 0;
	}

}
