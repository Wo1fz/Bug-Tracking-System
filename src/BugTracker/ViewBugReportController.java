/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BugTracker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class ViewBugReportController {
    public void readBugList(DefaultTableModel model, ArrayList<BugReport>bugReports)
    {
        //testing to load file data to jtable
        bugReports.clear();
        model.setRowCount(0);
        try {
            FileReader in = new FileReader("BugReport.txt");
            BufferedReader br = new BufferedReader(in);
            
            String readLine = "";
            while ((readLine = br.readLine()) != null) 
            {
                String [] row = readLine.split(":");
                BugReport bug = new BugReport();
                bug.setBugData(row);
                bugReports.add(bug);
                model.addRow(bug.getBugData());
            }
        } catch (IOException ex) {
            Logger.getLogger(ReportBugUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
