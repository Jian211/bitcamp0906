package util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

// 클래스의 용도 : 현재 사용하는 시점의 요청에 있는 쿠키 값들을 저장하고 관리하는 기능
// 쿠키 생성, 쿠키 제공, 쿠키 값 제공, 쿠키 존재 유무 확인

public class CookieBox {
	// 쿠키 값을 저장한다 : 간단한 코드로 빠르게 참조하고자 한다. 
	// => hashMap<String, Cookie>에 저장
	
	// 상위타입으로 선언
	private Map<String, Cookie > cookieMap = new HashMap<String, Cookie>();
	
	// 생성자를 통해서 값을 초기화 : map에 cookie객체들을 저장
	public CookieBox(HttpServletRequest request) {
		Cookie [] cookies = request.getCookies();
		
		if(cookies != null) {
			for(Cookie cookie: cookies) {
				cookieMap.put(cookie.getName(), cookie);
			}
		}
	}
	
	// 쿠키 생성 메서드 : 인스턴스 생성 없이 사용 가능하도록 한다. static
	// 쿠키 생성시에는 필요한 데이터 : 쿠키 이름, 값, 패스, 유효시간 , 도메인
	// 오버로딩으로 같은 이름의 메서드를 정의 
	public static Cookie createCookie(String name, String value) throws UnsupportedEncodingException {
		return new Cookie(name,URLEncoder.encode(value, "utf-8"));
	}

	public static Cookie createCookie(String name, String value, int maxAge) 
			throws UnsupportedEncodingException {
		Cookie c = new Cookie(name,URLEncoder.encode(value, "utf-8"));
		c.setMaxAge(maxAge);
		return c;
	}

	public static Cookie createCookie(String name, String value, int maxAge,String path) 
			throws UnsupportedEncodingException {
		Cookie c = new Cookie(name,URLEncoder.encode(value, "utf-8"));
		c.setMaxAge(maxAge);
		c.setPath(path);
		return c;
	}

	public static Cookie createCookie(String name, String value, int maxAge,String path,String domain) 
			throws UnsupportedEncodingException {
		Cookie c = new Cookie(name,URLEncoder.encode(value, "utf-8"));
		c.setMaxAge(maxAge);
		c.setPath(path);
		c.setDomain(domain);
		return c;
	}
	
	// 쿠키 객체를 제공하는 메소드 
	public Cookie getCookie(String cookieName) {
		return cookieMap.get(cookieName);
	}
	 
	// 쿠키 저장값 반환 : String
	public String getValue(String cookieName) throws UnsupportedEncodingException {
		Cookie c = cookieMap.get(cookieName);
		return c == null ? null : URLDecoder.decode(c.getValue(), "utf-8");
	}
	
	// 쿠기 존재 유무 확인
	public boolean exists(String cookieName) {
		return cookieMap.get(cookieName) != null;
	}
	
}
