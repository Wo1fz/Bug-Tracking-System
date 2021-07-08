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
public class GenReportedBugController {
    public boolean getReporterReport(File file, Date u1, Date u2){
        Report dr = new Report();
        boolean success = dr.generateReporterReport(file, u1, u2);
        return success;
    }
}
