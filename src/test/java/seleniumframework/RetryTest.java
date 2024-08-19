package seleniumframework;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryTest implements IRetryAnalyzer {
	int max=1, count=0;
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		
		if (count<max)
		{
			count++;
			return true;

		}
				
		return false;
	}
	
}
