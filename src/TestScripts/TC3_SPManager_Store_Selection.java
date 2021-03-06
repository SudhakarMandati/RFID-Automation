/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TestScripts;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.internal.thread.ThreadTimeoutException;

import Framework.Main;
import Libraries.Genericscripts;
import Libraries.ProjectSpecific;
import Libraries.Resultsummary;
import jxl.Sheet;
import jxl.Workbook;
import reports.CustomReporter;

import com.sun.org.apache.bcel.internal.generic.Select;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import com.thoughtworks.selenium.SeleniumException;

public class TC3_SPManager_Store_Selection {
	
	ProjectSpecific ps = new ProjectSpecific();
	Resultsummary rs = new Resultsummary();
	Logger APPLICATION_LOGS = Logger.getLogger("ApplicationLog");
	
	Genericscripts gs = new Genericscripts(getClass().getSimpleName());
	public static Xpath xp;
	WebDriver driver;
	
	public TC3_SPManager_Store_Selection()throws Exception{
		
		xp = Main.xpath;	
		driver=Main.driver;
	}
     
     public void TC3_SPManaer_Store_Selection1()throws Exception{
    	 try
 		{	
        APPLICATION_LOGS.debug("*** Test Script 3 Begins ***");
    	System.out.println("*******----- TC3_SPManaer_Store_Selection -----*******");	
    	Genericscripts gs = new Genericscripts(getClass().getSimpleName());
    
//    	String actalTitle = driver.getTitle();
//    	String expectedTitle = "SP Manager";
//    	
//    	if(actalTitle.contains(expectedTitle))
//    	{
//    		gs.writePassLog("Title of the page - Matched");
//    	}
//    	else
//    	{
//    		gs.writeFailLog("Title of the page - Did not Matched");
//    	}
    	gs.typeIntoEditBoxWD("//*[@id='ContentPlaceHolder1_UsernameTextBox']", "BC02584");
    	gs.typeIntoEditBoxWD("//*[@id='ContentPlaceHolder1_PasswordTextBox']", "Mouni@1605");
    	gs.clickButtonWD("//*[@id='ContentPlaceHolder1_SubmitButton']");
    	
    	
    	//driver.findElement(By.id("WORKLOAD")).click();
    	gs.clickButtonWD("//*[@id='WORKLOAD']/a");
    	
    	Thread.sleep(5000);
    	
    	//driver.findElement(By.id("anchChangeLocation")).wait(50);
    	System.out.println("The Output of the IsDisplayed " + driver.findElement(By.id("anchChangeLocation")).isDisplayed());
    	System.out.println("running");
    	driver.findElement(By.id("anchChangeLocation")).click();
    	String value;
    	Workbook w = Workbook.getWorkbook(new File(System.getProperty("user.dir")+"\\TestData\\TestData.xls"));
        Sheet s=w.getSheet("Store_number");
        value=s.getCell(0,1).getContents();
        System.out.println(value);
    
    	
    	gs.typeIntoEditBoxWD("//*[@id='searchText']", value);
      //  driver.findElement(By.id("searchText")).sendKeys(value);
    	Thread.sleep(5000);
    	
    	System.out.println("The Output of the IsDisplayed " + driver.findElement(By.id("ui-id-1")).isDisplayed());
    	
    //	driver.findElement(By.id("ui-id-1")).click();
    	gs.clickButtonWD("//*[@id='ui-id-1']");
    	
    	Thread.sleep(5000);
    	System.out.println("The Output of the IsDisplayed " + driver.findElement(By.id("btnSubmitLocation")).isDisplayed());
    	
    	gs.clickButtonWD("//*[@id='btnSubmitLocation']");
    //	driver.findElement(By.id("btnSubmitLocation")).click();  
    	Thread.sleep(2000);
    	gs.clickButtonWD("//*[@id='wrapper']/div[2]/div[1]/div[2]/div[3]/div[3]/a");
    	//driver.findElement(By.xpath("//*[@id='wrapper']/div[2]/div[1]/div[2]/div[3]/div[3]/a")).click();
    	Thread.sleep(8000);
    	System.out.println("running2");
    	gs.switchIframe("iframeExternal");
    	
    	Thread.sleep(3000);
    	
    	gs.clickLinkWD("//table[@id='B2Fgrid']//tr[2]/td[2]");
    	
    	
//    	gs.clickLinkWD("//html/body/div[1]/div/div[2]/div[3]/div[3]/div/table/tbody/tr[2]/td[2]/div");
    	
    	Thread.sleep(16000);
//    	gs.clickButtonWD("//*[@id='btnSelectAllRows']").click();
    	gs.clickLinkWD("//*[@id='btnSelectAllRows']");
    	Thread.sleep(1000);
    	gs.writePassLog(gs.getText("//*[@id='btnSelectAllRows']"));
    	
    	
    	
    	if(gs.isSelected("//*[@id='cb_PicklistB2Fgrid']"))
    	gs.writePassLog("All are checked");
    	else
    	gs.writeFailLog("All are not checked ");
    	
    	    	gs.clickLinkWD("//*[@id='btnSelectAllRows']");
    	    	gs.writePassLog(gs.getText("//*[@id='btnSelectAllRows']"));
//    	
        String data = driver.findElement(By.xpath("//html/body/div[2]/div/div[3]/div[3]/div[4]/div/table/tbody/tr[2]/td[3]")).getText(); 
        		//gs.getText("html/body/div[2]/div/div[3]/div[3]/div[4]/div/table/tbody/tr[2]/td[3]");
       	System.out.println(data);    	    	
    	gs.typeIntoEditBoxWD("//*[@id='gs_FOB_hash']",data);

    	Thread.sleep(2000);
  //  	gs.switchIframe("iframeExternal");
    
    	
//    	if(data.equalsIgnoreCase(data))
//    	{
//    		gs.writePassLog("Filtered accordingly");
//    		System.out.println("Filtered accordingly");
//    	}
//    	else
//    	{
//    		gs.writePassLog("Not Filtered accordingly");
//    		System.out.println("Not Filtered accordingly");	
//    	}
    	
//    	gs.switchIframe("iframeExternal");
    	
    	gs.clickLinkWD("//*[@id='PicklistB2FGridWrapper']/div/div[1]/span[2]/i");

    	
    	Thread.sleep(3000);
    	gs.writePassLog(gs.getText("//*[@id='B2FGridWrapper']/div/div[1]/a"));
    	
    	System.out.println(gs.getText("//*[@id='B2FGridWrapper']/div/div[1]/a"));
    	
    	
        APPLICATION_LOGS.debug("*** Test Script 3 Ends ***");
    		
    	
    	
        if(rs.failcounter>0){        	
        	CustomReporter.startParent("SPManager Store Selection", "Verifying store selection");
        	CustomReporter.reportParent("fail", "Verification of store selection failed");
        	CustomReporter.endParentTest();
        	CustomReporter.end();
            rs.writeFailSummary(getClass().getSimpleName(), "FAIL");
            Main.fail++; 
            Main.failTestScript.add(getClass().getSimpleName()); 
        }
        else{
        	CustomReporter.startParent("SPManager Store Selection", "Verifying store selection");
        	CustomReporter.reportParent("pass", "Verification of store selection passed");
        	CustomReporter.endParentTest();
        	CustomReporter.end();
        	 rs.writePassSummary(getClass().getSimpleName(), "PASS");
        	 Main.pass++;
        }
      }
    	 catch(SeleniumException e){
 			System.out.println(e);
 			StringWriter sw = new StringWriter();
 			e.printStackTrace(new PrintWriter(sw));
 			String st=sw.toString();
 			gs.writeFailLog(st);
 			rs.writeFailSummary(getClass().getSimpleName(), "FAIL");
 			APPLICATION_LOGS.debug("*** Test Script 2 Error ***"+e.getMessage());
 		}
          
     
 }

	
}