package config;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class ExecutaTeste {
	
	public static void main(String[] asd){
		try {
			if(ConfigProperties.getProperty("runner.test").equalsIgnoreCase("RunnerTestJunit")) {
				Result result = JUnitCore.runClasses(RunnerTestJunit.class);
				for(Failure failure : result.getFailures()) {
					System.out.println(failure.toString());
					failure.getException().printStackTrace();
				}
				System.out.println(result.wasSuccessful());
			}else {
				Result result = JUnitCore.runClasses(RunnerTestCucumber.class);
				for(Failure failure : result.getFailures()) {
					System.out.println(failure.toString());
					failure.getException().printStackTrace();
				}
				System.out.println(result.wasSuccessful());	
			}
		} catch (Exception e) {
			System.out.println(">>>>>>>>>>>>>>> ERROR ExecutaTeste <<<<<<<<<<<<<<<<<<");
			e.printStackTrace();
		}
    	
    	/*
		 * try { WebDriver driver = null; TC_001_PesquisarRoupa tc_001_PesquisarRoupa =
		 * new TC_001_PesquisarRoupa(); tc_001_PesquisarRoupa.cenarioTesteLogin(driver);
		 * } catch (Exception e) { System.out.println("Error ExecutaTeste => "
		 * +e.getMessage()); }
		 */
    } 

}
