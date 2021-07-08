/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BugTracker;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author malla
 */
public class ProvideCommentsController {
    
    public void loadComments(String filepath, DefaultTableModel model)
    {
        BugReport br = new BugReport();
        br.getComments(filepath, model);
    }
    
    public boolean updateCommentsData(String filename, String [] array)
    {
        BugReport br = new BugReport();
        br.storeNewComment(filename, array);
        return true;
    }
}
