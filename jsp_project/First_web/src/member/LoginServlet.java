package member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




// 어노테이션 웹서블렛을 이용하면 굳이 web.xml에 클래스를 추가해줄 필요가 없다.
@WebServlet({ "/Login", "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
		//	사용자가 입력한userId, pw를 받아서 응답 메시지에 포함해서 처리
		String uId = request.getParameter("userId");	// input의 name속성 
		String uPw = request.getParameter("userPw");	// 
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>파라미터 데이터 받기</title></head>");
		out.println("<body>");
		out.println("<h1>");
		out.println(" userId : "+uId + "<br>");
		out.println(" pw : "+uPw + "<br>");
		out.println("</h1>");
		out.println("</body>");
		
		out.println("</html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
