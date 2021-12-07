package member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String uId = request.getParameter("userId");
    	String uPw = request.getParameter("userPw");
    	String uPwCk = request.getParameter("userPwCk");
    	String uName = request.getParameter("userName");
    	String comment = request.getParameter("comment");
    	String gender = request.getParameter("gender");
    	String [] interests = request.getParameterValues("interest");
    	String byear = request.getParameter("byear");
    	
    	response.setContentType("text/html;  charset=utf-8"); 
    	PrintWriter out = response.getWriter();
    	out.println("<html>");
		out.println("<head><title>Test</title></head>");
		out.println("<body>");
		out.println("<h1> User ID   : "+ uId + "</h1>");
		out.println("<h1> User PW   : "+ uPw + "</h1>");
		out.println("<h1> User NAME : "+ uName + "</h1>");
		out.println("<h1> Comment : "+ comment + "</h1>");
		out.println("<h1> gender : "+ gender + "</h1>");
	
		if(interests != null) {
			for(int i=0; i < interests.length ;i++) {
				out.println("<h1> interest : "+ interests[i] + "</h1>");
			}
		}else {
			out.println("선택된 관심사가 없습니다.");
		}
		out.println("<h1> byear : "+ byear + "</h1>");
		
		out.println("</body>");
		
		out.println("</html>");
		
		//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
