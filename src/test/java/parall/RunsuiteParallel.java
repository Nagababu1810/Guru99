package parall;

import java.util.Arrays;

import org.testng.TestNG;

import com.impTest.BaseTest;

public class RunsuiteParallel  extends BaseTest{

	public static void main(String[] args) {
		
		
		TestNG t=new TestNG();
		
		t.setTestSuites(Arrays.asList(new String[] {Projectpath+ "//testngmegasuit.xml"}));
		t.setSuiteThreadPoolSize(2);
		t.run();

	}

}
