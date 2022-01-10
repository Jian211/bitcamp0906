package com.bitcamp.cal;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalTest {

	Calculator cal;
	
	// 테스트 코드 작성 전 -> 테스트 케이스 정의
	
	@Before //: @Test 실행 전
	public void setup() {
		System.out.println("@Before 메소드 실행");  	// 실행 시점 확인
		//cal = new Calculator();
	}
	
	@After	// : @Test 실행 후
	public void tearDown() {
		System.out.println("@After 메소드 실행");
	}
	
	@BeforeClass // : 테스트 객체 생성 전
	public static void setupForClass() {
		System.out.println("@BeforeClass 메소드 실행");
	}
	
	@AfterClass //: 테스트 객체 소멸 전
	public static void tearDownForClass () {
		System.out.println("@AfterClass 메소드 실행");
	}
	
	@Test
	public void calTest1() {
		System.out.println("@Test 단위테스트 메소드 실행");
		
		int num1 = 20;
		int num2 = 10;
		
		//add 메서드의 테스트 케이스는 20, 10 값을 전달하면 30을 반환해야 성공
		assertEquals("add(20,10)", 30, cal.add(num1, num2));

		// substract 메서드의 테스트 케이스는 20, 10 값을 전달하면 30을 반환해야 성공
		assertEquals("substract(20,10)", 10, cal.substract(num1, num2));
		
		//fail("무조건 실패!");
	
		// 논리 값을 가지고 비교 결과
		assertTrue(true);
		
		// null 값을 비교 : null 이면 참 
		assertNull(null);
		//assertNull("is null?",cal);
		
		// not null 비교 : null이 아니면 성공 
		assertNotNull("is not null?",cal);
		
		
	}
	
}
