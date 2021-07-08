/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BugTracker;

/**
 *
 * @author malla
 */
public class SetInvalidUI {
    public void DisplayHomePage()
    {
        AssignBugUI ABU = new AssignBugUI();
        ABU.displayHP();
    }
    
    public void SetInvalidButtonActionPerformed()
    {
        AssignBugUI ABU = new AssignBugUI();
        ABU.setInvalidButton();
    }
}
