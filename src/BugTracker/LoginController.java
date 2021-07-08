/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BugTracker;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author malla
 */
public class LoginController extends javax.swing.JFrame {
    
    public String [][] getUserDetails(String [][] userData, String [] userDetails, String username, String password)
    {
        userDetails[0] = username;
        userDetails[1] = password;
        User user1 = new User();
        return user1.getAccountsData(userData);
    }
	
	// check user account validity
    public String checkValidity(String accountData [][], String [] userDetails)
    {
	// Initialisation 
	String validUser = "";
		
	for(int i = 0; i < accountData.length; i++)
	{
            if(accountData[i][0] != null)
            {
		if(accountData[i][0].equals(userDetails[0]) && accountData[i][1].equals(userDetails[1]))
		{
                    validUser = "Valid User"+accountData[i][2];
                    break;
		}
		else
		{
                    validUser = "Invalid User";
		}
            }
	}	
	return validUser;
    }
	
}