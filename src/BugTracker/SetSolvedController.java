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
public class SetSolvedController {
    public boolean setBugSolved(String bugid, ArrayList<BugReport>bugReportList)
    {
        BugReport br = new BugReport();
        boolean success = br.updateSolvedBug(bugid, bugReportList);
        return success;
    }
}
