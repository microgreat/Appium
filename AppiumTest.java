package com.appium.test;

import static org.junit.Assert.*;

//import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.Set;

import io.appium.java_client.android.AndroidDriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;


public class AppiumTest {
	 private AndroidDriver<?> driver;
	  
	    @Before
	    public void setUp() throws Exception {
	        // set up appium
	        //File classpathRoot = new File(System.getProperty("user.dir"));
	        //File appDir = new File(classpathRoot, "apps");
	        //File app = new File(appDir, "ContactManager-selendroid.apk");
	        //File app = new File(appDir, "xiaomishop.apk");
	        DesiredCapabilities capabilities = new DesiredCapabilities();
	        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
	        capabilities.setCapability("platformName", "Android");
	        capabilities.setCapability("deviceName","d1a7738c");//小米3TD
	        //capabilities.setCapability("deviceName","dfdc1350");//红米1S
	        //capabilities.setCapability("platformVersion", "5.0");
	        capabilities.setCapability("platformVersion", "4.4");
	        //capabilities.setCapability("app", app.getAbsolutePath());
	        //capabilities.setCapability("appPackage", "com.example.android.contactmanager");
	        capabilities.setCapability("appPackage", "com.xiaomi.shop");
	        //capabilities.setCapability("appActivity", ".ContactManager");
	        capabilities.setCapability("appActivity", ".activity.MainTabActivity");

	        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	    }
	  
	    @After
	    public void tearDown() throws Exception {
	        driver.quit();
	    }
	  
	    @Test
	    /*
	    public void addContact(){
	        WebElement el = driver.findElement(By.name("Add Contact"));
	        el.click();
	        List<WebElement> textFieldsList = driver.findElementsByClassName("android.widget.EditText");
	        textFieldsList.get(0).sendKeys("Some Name");
	        textFieldsList.get(1).sendKeys("13800138000");
	        //driver.swipe(100, 500, 100, 100, 2);
	        driver.findElementByName("Save").click();
	    }
	    */	    
	    public void testShop001() throws Exception{
	    	Thread.sleep(1000);
	        WebElement el = driver.findElement(By.id("com.xiaomi.shop:id/skip"));
	        el.click();
	        Thread.sleep(3000);//进程休眠3s
	    	//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);//等待加载3s
	        Set<String> context = driver.getContextHandles();
	        for (String contextName : context) {
	            System.out.println(contextName);//遍历当前所有NATIVE和WEBVIEW
	            //用于返回被测APP是NATIVE_APP还是WEBVIEW，如果两者都有就是混合型APP
	        }
	        List<?> ids= driver.findElements(By.id("com.xiaomi.shop:id/main_bottom_tab_text"));
	        for(int i = 0;i<ids.size();i++){
	        	//System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+ids.get(i));
	        	((WebElement) ids.get(i)).click();//依次点击商城、分类、精选、服务TAB
	        	}
	        ((WebElement) ids.get(0)).click();	        
	        boolean expected = true;
	        boolean actual = driver.findElementByName("分类").isDisplayed();	        
	        //System.out.println(">>>>>>>>>>>>>>>>>>>>>actual:" + actual);
			assertEquals("首页 are not found", expected, actual);
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>第1条用例执行结束！");
	    }
	    @Test
	    public void testShop002() throws Exception{
	    	Thread.sleep(1000);
	        WebElement el = driver.findElement(By.id("com.xiaomi.shop:id/skip"));
	        el.click();
	        Thread.sleep(3000);
	        //driver.tap(1, 450, 580, 0);//720p点击小米移动
	        //driver.tap(1, 600,800, 0);//1080p点击小米移动
	        List<?> iv=driver.findElementsByClassName("android.widget.ImageView");	
	        /*
	        for(int i = 0;i<iv.size();i++){
	        	//遍历出所有小米商城首页所有的ImageView
	        	System.out.println("ImageView:"+i+":"+((WebElement) iv.get(i)).getLocation());
	        	}
	        */      
	        ((WebElement) iv.get(4)).click();
	        Thread.sleep(3000);
	        Set<String> context = driver.getContextHandles();
	        for (String contextName : context) {
	            System.out.println(contextName);//遍历当前所有NATIVE和WEBVIEW
	            //用于返回被测APP是NATIVE_APP还是WEBVIEW，如果两者都有就是混合型APP
	        }
	        driver.context("WEBVIEW_com.xiaomi.shop");//切换到WEBVIEW模式
	        Thread.sleep(3000);
	        //System.out.println(driver.getPageSource());//打印当前WEBVIEW的HTML信息
	        String expected = "精彩通信，从小米开始!";
	        String actual = driver.findElement(By.className("footer")).getText();
			assertEquals("小米移动页面:精彩通信，从小米开始! are not found", expected, actual);
	        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>第2条用例执行结束！");
	    }
	    @Test
	    public void testShop003() throws Exception{
	    	Thread.sleep(1000);
	        //WebElement el = driver.findElement(By.id("com.xiaomi.shop:id/skip"));
	        //el.click();
	        Thread.sleep(6000);
	        //driver.tap(1, 450, 580, 0);//720p点击小米移动
	        //driver.tap(1, 600,800, 0);//1080p点击小米移动
	        //通过点击第4个ImageView实现点击小米移动
	        List<?> iv=driver.findElementsByClassName("android.widget.ImageView");    
	        ((WebElement) iv.get(4)).click();
	        Thread.sleep(3000);
	        Set<String> context = driver.getContextHandles();
	        for (String contextName : context) {
	            System.out.println(contextName);//遍历当前所有NATIVE和WEBVIEW
	            //用于返回被测APP是NATIVE_APP还是WEBVIEW，如果两者都有就是混合型APP
	        }
	        driver.context("WEBVIEW_com.xiaomi.shop");//切换到WEBVIEW模式
	        Thread.sleep(3000);
	        //System.out.println(driver.getPageSource());//打印当前WEBVIEW的HTML信息
	        driver.findElement(By.className("banner-main")).click();//点击banner1
	        Thread.sleep(3000);
	        driver.findElementsByXPath("//*[@id=\"wrapper\"]/div/div[2]/div[2]/div[2]").get(0).click();//点击“吃到饱”卡
	        Thread.sleep(3000);
	        driver.context("NATIVE_APP");//切换到NATIVE模式
	        driver.findElementByAccessibilityId("下一步").click();
	        Thread.sleep(3000);
	        driver.findElementByAccessibilityId("北京").click();
	        Thread.sleep(3000);
	        driver.findElementByAccessibilityId("北京市").click();
	        Thread.sleep(3000);
	        driver.context("WEBVIEW_com.xiaomi.shop");//切换到WEBVIEW模式
	        driver.findElementsByXPath("//*[@id=\"wrapper\"]/div/div[2]/ul/li[1]").get(0).click();//点击第一个电话号码	      
	        Thread.sleep(3000);
	        driver.context("NATIVE_APP");//切换到NATIVE模式
	        driver.findElementByAccessibilityId("立即购买").click();
	        Thread.sleep(3000);
	        //点击第1个EditText
	        List<?> et=driver.findElementsByClassName("android.widget.EditText");
	        ((WebElement) et.get(0)).sendKeys("李小伟");
	        Thread.sleep(3000);
	        ((WebElement) et.get(1)).sendKeys("412726198605084515");
	        Thread.sleep(3000);
	        driver.findElementByAccessibilityId("我已阅读并同意").click();
	        Thread.sleep(3000);
	        driver.findElementByAccessibilityId("提交").click();
	        Thread.sleep(3000);
	        
	        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>第3条用例执行结束！");
	    }
}

