/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BugTracker;

import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class GenReportedBugUI {
    public void generateReportButtonActionPerformed()
    {
        AssignBugUI ABU = new AssignBugUI();
        ABU.displayGPage();
    }
    
    public void ReportButtonActionPerformed()
    {
         AssignBugUI ABU = new AssignBugUI();
         ABU.genReport();
    }
    
    public void showMessageDialog()
    {
        JOptionPane.showMessageDialog(null, "Invalid Report Type!","Unsuccessful", JOptionPane.ERROR_MESSAGE);
    }
}
