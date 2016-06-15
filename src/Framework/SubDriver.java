/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Framework;

import java.io.File;

import Libraries.Configuration;
import Libraries.ProjectSpecific;
import TestScripts.TC1_SPManager_Access;
import TestScripts.TC2_SPManager_Division_Selection;
import TestScripts.TC3_SPManager_Store_Selection;
import TestScripts.TC4_SPManager_Back_to_Front;
import TestScripts.TC5_SPManaer_FOB_Selection;
import jxl.Sheet;
import jxl.Workbook;

public class SubDriver {

	ProjectSpecific ps = new ProjectSpecific();
	public SubDriver ()throws Exception{
		//Constructor	
		}
	public void GetTestScriptName() throws Exception {

		String CSpath = Configuration.ControlScriptPath;
		Workbook w = Workbook.getWorkbook(new File(CSpath));
		Sheet s = w.getSheet(Main.testSuite);
	

		int rc = s.getRows();
		ps.rowCount = rc-1;
		System.out.println("Control Script row count : " + rc);
		try {
			for (int i = 1; i < rc; i++) {
				String executionstatus = s.getCell(2, i).getContents();
				String TestScriptid = s.getCell(0, i).getContents();
				String TestScriptName = s.getCell(1, i).getContents();
				int Tid = Integer.parseInt(TestScriptid);

				System.out.println(Tid);

				if (executionstatus.equalsIgnoreCase("Run")) {
					switch (Tid) {
					case 1:
						System.out.println("*******--TC1 SubDriver--*******");
						Main.Tname = TestScriptName;
						Main.StartSeleniumWD();
						TC1_SPManager_Access ts1 = new TC1_SPManager_Access();
						ts1.TC1_SPManager_Access();
						Main.StopSeleniumWD();
						break;
						
					case 2:
						System.out.println("*******--TC2 SubDriver--*******");
						Main.Tname = TestScriptName;
						Main.StartSeleniumWD();
						//TC1_SPManager_Access2 ts0 = new TC1_SPManager_Access2();
						//ts0.TC1_SPManager_Access();
						TC2_SPManager_Division_Selection ts2 = new TC2_SPManager_Division_Selection();
						ts2.TC2_SPManager_Access();
						Main.StopSeleniumWD();;
						break;
						
					case 3:									
						
					   System.out.println("*******--TC3 SubDriver--*******");
					    Main.Tname = TestScriptName;
						Main.StartSeleniumWD();
						TC3_SPManager_Store_Selection ts3 = new TC3_SPManager_Store_Selection();
					    ts3.TC3_SPManaer_Store_Selection1();
						Main.StopSeleniumWD();;
					   break;
					   
					case 4:									
						
						   System.out.println("*******--TC3 SubDriver--*******");
						    Main.Tname = TestScriptName;
							Main.StartSeleniumWD();
							TC4_SPManager_Back_to_Front ts4 = new TC4_SPManager_Back_to_Front();
						    ts4.TC3_SPManaer_Store_Selection1();
							Main.StopSeleniumWD();;
						   break;
						   
					case 5:									
						
						   System.out.println("*******--TC3 SubDriver--*******");
						    Main.Tname = TestScriptName;
							Main.StartSeleniumWD();
							TC5_SPManaer_FOB_Selection ts5 = new TC5_SPManaer_FOB_Selection();
						    ts5.TC3_SPManaer_Store_Selection1();
							Main.StopSeleniumWD();;
						   break;
//										
//				
					}
					
					
				} else if (executionstatus.equalsIgnoreCase("Ignore")) {
					System.out.println("Execution not started for the TestScript id : "+ Tid);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		w.close();
	}
}