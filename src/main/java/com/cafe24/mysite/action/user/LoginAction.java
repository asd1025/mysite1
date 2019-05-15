package com.cafe24.mysite.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cafe24.mysite.dao.UserDao;
import com.cafe24.mysite.vo.UserVo;
import com.cafe24.web.WebUtil;
import com.cafe24.web.mvc.Action;

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//HttpSession session= request.getSession(true); 
		// 최초로 생성할때 (처음에 로그인 할 떈 없음) 
		// 있으면 주고 없으면 null return 
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		UserVo authUser= new UserDao().get(email, password);
		if(authUser==null) { //다시 인증
			request.setAttribute("result", "fail");
			WebUtil.forward(request, response, "/WEB-INF/views/user/loginform.jsp");
			return; // 이걸 안하면 밑 코드까지 내려가기 때문에 return!
		} 
		//로그인 처리
		HttpSession session= request.getSession(true); 
		session.setAttribute("authUser", authUser);
		WebUtil.redirect(request, response,request.getContextPath());
		
	}

}
