/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BugTracker;

import java.io.File;
import java.util.Date;

/**
 *
 * @author User
 */
public class GenResolvedBugController {
    public boolean getDeveloperReport(File file, Date u1, Date u2){
        Report rp = new Report();
        boolean success = rp.generateDeveloperReport(file, u1, u2);
        return success;
    }
}
