/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BugTracker;

/**
 *
 * @author User
 */
public class ViewBugReportUI {
    public void ViewBugButtonActionPerformed() { 
        ReportBugUI RBU = new ReportBugUI();
        RBU.ViewBugReport();
    }
    
    public void DisplayDetailPage()
    {
        ReportBugUI RBU = new ReportBugUI();
        RBU.DisplayDetailPages();
    }
}
