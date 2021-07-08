/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BugTracker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author malla
 */
public class User {
    
    private String [][] userData = new String[100][3];
    private DefaultTableModel model = new DefaultTableModel();
    private ArrayList<BugReport>bugReports = new ArrayList<>();
    private String [] array = new String[100];
    private String filename = "";
    private String filepath = "";
    private String searchParam = "";
    private String searchText = "";
    
    public User()
    {
        
    }
    
    public boolean ValidateFields(String[] array)
    {
        boolean isValid = true;
        if(array[1].equals("") || array[2].equals("") || array[4].equals("") || array[5].equals(""))
        {
            isValid = false;
        }
        return isValid;
    }
    public boolean updateCommentsData(String filename, String [] array)
    {
        BugReport br = new BugReport();
        br.storeNewComment(filename, array);
        return true;
    }
    public void loadComments(String filepath, DefaultTableModel model)
    {
        ProvideCommentsController br = new ProvideCommentsController();
        br.loadComments(filepath, model);
    }

    public String [][] getAccountsData(String [][] userData)
    {
        int currentLineNo = 0;
        String readLine = "";
        String [] splitLine = new String [3];
        try
	{	
            File myObj = new File("accounts.txt");
            Scanner myReader = new Scanner(myObj);
			
            // Read files
            while (myReader.hasNextLine()) 
            {
		readLine = myReader.nextLine();
		splitLine = readLine.split(":");
		userData [currentLineNo][0] = splitLine[0];
		userData [currentLineNo][1] = splitLine[1];
                userData [currentLineNo][2] = splitLine[2];
		currentLineNo++;
            }
			
            myReader.close();
	} 
		
	// Catch error
	catch (FileNotFoundException e) 
	{
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return userData;
    }
}
