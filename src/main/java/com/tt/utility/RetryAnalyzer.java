package com.tt.utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
	
	int startcount=0;
	int retrylimit=1;
	
	public boolean retry(ITestResult result) {
        if (startcount < retrylimit) {
            System.out.println("Retrying test " + result.getName() + " with status "
                    + getResultStatusName(result.getStatus()) + " for the " + (startcount+1) + " time(s).");
            startcount++;
            return true;
        }
        return false;
    }

	public String getResultStatusName(int status) {
    	String resultName = null;
    	if(status==1)
    		resultName = "SUCCESS";
    	if(status==2)
    		resultName = "SKIP";	
    	if(status==3)
    		 resultName = "FAILURE";
		return resultName;
    }
}
