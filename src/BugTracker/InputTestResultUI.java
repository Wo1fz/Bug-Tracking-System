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
public class InputTestResultUI {
    
    public void BugsWithPatchesActionPerformed()
    {
        ReviewerUI RU = new ReviewerUI();
        RU.patchedBugs();
    }
    
    public void TestPatchButtonActionPerformed()
    {
        ReviewerUI RU = new ReviewerUI();
        RU.testPatchButton();
    }
    
    public void PatchTestPageSubmitButtonActionPerformed()
    {
        ReviewerUI RU = new ReviewerUI();
        RU.submitButton();
    }
    
    public void DisplayHomePage()
    {
        ReviewerUI RU = new ReviewerUI();
        RU.displayHP();
    }
}
