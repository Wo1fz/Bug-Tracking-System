/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BugTracker;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class SearchBugTitleController {
    public String [] getSearchData(ArrayList<BugReport>bugReports, String searchParam, String searchText)
    {
        BugReport br = new BugReport();
        String [] array = br.getSearchBugs(bugReports, searchParam, searchText);
        return array;
    }
}
