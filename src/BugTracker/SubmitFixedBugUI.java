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
public class SubmitFixedBugUI {

    public void SubmitPatchButtonActionPerformed()
    {
        DeveloperUI DU = new DeveloperUI();
        DU.submitPButton();
    }
    
    public void PatchPageSubmitButtonActionPerformed()
    {
        DeveloperUI DU = new DeveloperUI();
        DU.ppSubmitButton();
    }
    
    public void DisplayHomePage()
    {
        DeveloperUI DU = new DeveloperUI();
        DU.displayHP();
    }
}
