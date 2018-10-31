package kh.mybatis.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.mybatis.dao.UsersDAO;
import kh.mybatis.dto.UsersDTO;
import kh.mybatis.factory.MyBatisSqlSessionFactory;


@WebServlet("*.do")
public class FrontController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		
		boolean isRedirect = true;
		String dst = "null";
		
		
		System.out.println(command);
		
		if(command.equals("/login.do")) {
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			
			Map<String, String> map = new HashMap<>();
			map.put("id", id);
			map.put("pw", pw);
			
			UsersDAO dao = new UsersDAO();
			boolean result = dao.idPwCheck(MyBatisSqlSessionFactory.getSqlSession(),map);
			
			if(result) {
				request.getSession().setAttribute("loginId", id);
				
				isRedirect=false;
				dst="mypage.jsp";
			}
			
			
			
		}else if(command.equals("/signup.do")) {
			String id=request.getParameter("id");
			String pw=request.getParameter("pw");
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			

			
			UsersDTO dto = new UsersDTO("0",id,pw,name,email);
			UsersDAO dao = new UsersDAO();
			int result = dao.insert(MyBatisSqlSessionFactory.getSqlSession(), dto);

			
			isRedirect = false;
			dst = "mypage.jsp";
			
		}else if(command.equals("/delete.do")) {
			String id=(String)request.getSession().getAttribute("loginId");
			
			UsersDAO dao = new UsersDAO();
			int result = dao.delete(MyBatisSqlSessionFactory.getSqlSession(), id);
			
			
			isRedirect=false;
			dst = "index.html";
					
		}else if(command.equals("/select.do")) {
			String id=(String)request.getSession().getAttribute("loginId");
			
			UsersDAO dao = new UsersDAO();
			List<UsersDTO> result = dao.select(MyBatisSqlSessionFactory.getSqlSession(), id);
			
			System.out.println(result.get(0).getUser_id());
			System.out.println(result.get(0).getName());
		}
		
		
		
		
		
		if(isRedirect) {
			response.sendRedirect(dst);
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher(dst);
			rd.forward(request, response);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
