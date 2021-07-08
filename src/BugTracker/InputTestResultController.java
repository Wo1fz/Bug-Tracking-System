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
public class InputTestResultController {
    
    public void updateTestResult(TestResult tr, String bugid)
    {
        BugReport br = new BugReport();
        br.saveTestResultData(tr, bugid);
    }
}
