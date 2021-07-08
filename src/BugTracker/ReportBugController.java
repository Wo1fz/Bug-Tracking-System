/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BugTracker;

/**
 *
 * @author User
 */
public class ReportBugController {
    public boolean ValidateFields(String[] array)
    {
        boolean isValid = true;
        if(array[1].equals("") || array[2].equals("") || array[4].equals("") || array[5].equals(""))
        {
            isValid = false;
        }
        return isValid;
    }
}
