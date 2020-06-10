package com.tt.utility;


import org.seleniumhq.jetty9.http.HttpGenerator.Result;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.tt.utility.BaseTest;

public class ListenerTest implements ITestListener
{

	@Override
	public void onTestStart(ITestResult result) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result)
	{
		System.out.println("The name of the testcase passed is :"+result.getName());
		BaseTest.test.log(Status.PASS, result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		System.out.println("The name of the testcase failed is :"+result.getName());
		
	
		BaseTest.test.log(Status.FAIL, result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		System.out.println("The name of the testcase Passed is :"+result.getName());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
