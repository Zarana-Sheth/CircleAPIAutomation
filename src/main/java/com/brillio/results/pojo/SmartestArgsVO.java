package com.brillio.results.pojo;


public class SmartestArgsVO {

	String testCaseIds;
	String jenkinsURL;
	String jenkinsJob;
	String testCaseNames;
	String testExecutionId;
	
	public String getJenkinsURL() {
		return jenkinsURL;
	}


	public void setJenkinsURL(String jenkinsURL) {
		this.jenkinsURL = jenkinsURL;
	}


	public String getJenkinsJob() {
		return jenkinsJob;
	}


	public void setJenkinsJob(String jenkinsJob) {
		this.jenkinsJob = jenkinsJob;
	}


	public String getTestCaseIds() {
		return testCaseIds;
	}


	public void setTestCaseIds(String testCaseIds) {
		this.testCaseIds = testCaseIds;
	}


	public String getTestCaseNames() {
		return testCaseNames;
	}


	public void setTestCaseNames(String testCaseNames) {
		this.testCaseNames = testCaseNames;
	}


	public String getTestExecutionId() {
		return testExecutionId;
	}


	public void setTestExecutionId(String testExecutionId) {
		this.testExecutionId = testExecutionId;
	}



	@Override
	public String toString() {
		return "SmartestArgsVO [testCaseIds=" + testCaseIds + ", jenkinsURL=" + jenkinsURL + ", jenkinsJob="
				+ jenkinsJob + ", testCaseNames=" + testCaseNames + ", testExecutionId=" + testExecutionId + "]";
	}
	
}
