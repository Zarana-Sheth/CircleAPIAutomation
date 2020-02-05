package com.brillio.utilities;

import org.openqa.selenium.WebDriver;

public class CucumberDriver {
	public static WebDriver driver ;
	public static TestDriver testDriver ;
/*	public static void waitForElementToLoad(By by) {
		waitForElementToLoad(by,0);
	}
	public static void waitForElementToLoad(By by,int maxWait) {
		if(maxWait==0){
			maxWait=Integer.parseInt(CucumberDriver.testDriver.getGlobalParamMap().get("wait.medium"));
		}
		Wait<WebDriver> wait = new FluentWait<WebDriver>(testDriver.getWebDriver()).withTimeout(maxWait, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class).ignoring(ElementNotVisibleException.class);
			wait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return testDriver.getWebDriver().findElement(by);
				}
			});
	}*/
	}
	

