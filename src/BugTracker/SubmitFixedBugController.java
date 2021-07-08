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
public class SubmitFixedBugController {
    private String file = "";
    private String bugid = "";
    
    public void saveUploadFile(String file, String bugid)
    {
        Patch patch = new Patch();
        patch.SetPatch(file);
        BugReport b1 = new BugReport();
        b1.savePatchData(patch, bugid);
    }
}
