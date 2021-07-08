/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BugTracker;

import java.util.ArrayList;

/**
 *
 * @author malla
 */
public class SetInvalidController {
    
    public boolean setInvalidBug(String bugid, ArrayList<BugReport>bugReportList)
    {   
        BugReport br = new BugReport();
        boolean success = br.updateInvalidBug(bugid, bugReportList);
        return success;
    }
}
