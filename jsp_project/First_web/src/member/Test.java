package member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/Test", "/test" })
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Test() {
        super();
    }

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String uId = request.getParameter("userId");
    	String uPw = request.getParameter("userPw");
    	String uPwCk = request.getParameter("userPwCk");
    	String uName = request.getParameter("userName");
    	
    	PrintWriter out = response.getWriter();
    	out.println("<html>");
		out.println("<head><title>Test</title></head>");
		out.println("<body>");
		out.println("<h1> User ID   : "+ uId + "</h1>");
		out.println("<h1> User PW   : "+ uPw + "</h1>");
		out.println("<h1> User NAME : "+ uName + "</h1>");
		out.println("</body>");
		
		out.println("</html>");
    	
//    	response.getWriter().append("Served at: ").append(request.getContextPath());
	}

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
