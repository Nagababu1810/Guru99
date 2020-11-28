package parall;

import org.testng.annotations.Test;

public class TestMethods {
	
	@Test
	public void simpletest1() {
		
		System.out.println("sample Test1 :" + Thread.currentThread().getId());
	}
	
	@Test
	public void simpletest2() {
		
		System.out.println("sample Test2 :" +Thread.currentThread().getId());
	}
	
}
