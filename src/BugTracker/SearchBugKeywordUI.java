
import BugTracker.BugReport;
import BugTracker.SearchBugKeywordController;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class SearchBugKeywordUI {
    public String [] SearchButtonActionPerform(ArrayList <BugReport> bugReportList, String searchParam, String searchText){

        SearchBugKeywordController SBK = new SearchBugKeywordController();
        String [] array = SBK.getSearchData(bugReportList, searchParam, searchText);
        return array;
    }
}
