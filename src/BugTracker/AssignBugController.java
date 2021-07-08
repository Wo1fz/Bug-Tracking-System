/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BugTracker;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class AssignBugController {
    //for assign function
    public boolean AssignButtonActionPerformed(ArrayList <String> bugReports,  String [] changeDataLine,  String [] tempData) { 
        BugReport b1 = new BugReport();
        boolean success = b1.UpdateBugReport(bugReports, changeDataLine, tempData);
        
        return success;
    }
    
    public String[] getDevArray()
    {
        Developer d1 = new Developer();
        String [] devNameArr = d1.getDevName();
        return devNameArr;
    }
}
