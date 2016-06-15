/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TestScripts;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Framework.Main;
import Libraries.Genericscripts;
import Libraries.ProjectSpecific;
import Libraries.Resultsummary;
import reports.CustomReporter;

import com.thoughtworks.selenium.SeleniumException;

public class TC1_SPManager_Access {
	
	ProjectSpecific ps = new ProjectSpecific();
	Resultsummary rs = new Resultsummary();
	Logger APPLICATION_LOGS = Logger.getLogger("ApplicationLog");
	
	Genericscripts gs = new Genericscripts(getClass().getSimpleName());
	public static Xpath xp;
	WebDriver driver;
	
	public TC1_SPManager_Access()throws Exception{
		
		xp = Main.xpath;	
		driver=Main.driver;
	}
     
     public void TC1_SPManager_Access()throws Exception{
    	 
    	 try
 		{	
        APPLICATION_LOGS.debug("*** Test Script 1 Begins ***");
    	System.out.println("*******----- TC1_SPManager_Access -----*******");	
    	Genericscripts gs = new Genericscripts(getClass().getSimpleName());
    
    	String actalTitle = driver.getTitle();
    	String expectedTitle = "Sign In";
    	
    	if(actalTitle.contains(expectedTitle))
    	{
    		gs.writePassLog("Title of the page - Matched");
    	}
    	else
    	{
    		gs.writeFailLog("Title of the page - Did not Matched");
    	}
    //	ps.loginPage();
    	gs.typeIntoEditBoxWD("//*[@id='ContentPlaceHolder1_UsernameTextBox']", "BC02584");
    	gs.typeIntoEditBoxWD("//*[@id='ContentPlaceHolder1_PasswordTextBox']", "Mouni@1605");
    
    	
    	//driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_SubmitButton']")).click();
    	gs.clickButtonWD("//*[@id='ContentPlaceHolder1_SubmitButton']");
    	
    	APPLICATION_LOGS.debug("*** Test Script 1 Ends ***");
    		
    	
    	
        if(rs.failcounter>0){       
        	CustomReporter.startParent("SPManager Access", "Verifying credentials");
        	CustomReporter.reportParent("fail", "Verification of credentials failed");
        	CustomReporter.endParentTest();
        	CustomReporter.end();
            rs.writeFailSummary(getClass().getSimpleName(), "FAIL");
            Main.fail++; 
            Main.failTestScript.add(getClass().getSimpleName()); 
        }
        else{
        	CustomReporter.startParent("SPManager Access", "Verifying credentials");
        	CustomReporter.reportParent("pass", "Verification of credentials passes");
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
 			APPLICATION_LOGS.debug("*** Test Script 1 Error ***"+e.getMessage());
 		}
     }     
 }