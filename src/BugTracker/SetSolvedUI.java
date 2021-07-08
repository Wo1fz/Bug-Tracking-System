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
public class SetSolvedUI {
    public void DisplaHomePage()
    {
        AssignBugUI ABU = new AssignBugUI();
        ABU.displayHP();
    }
    
    public void SetSolvedButtonActionPerformed()
    {
        AssignBugUI ABU = new AssignBugUI();
        ABU.setSolveButton();
    }
}
