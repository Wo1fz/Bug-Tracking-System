/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BugTracker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author malla/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author malla
 */
public class Developer extends User
{
    private String [] devName = new String[10];
    private String [] DeveloperID = new String[10];
    Patch file = new Patch();
    String bugid = "";
    
    public Developer()
    {
        
    }
    public String [] getDevName()
    {
        ArrayList<String> dev = new ArrayList<String>();
        try
            {
                File myObj = new File("accounts.txt");
                Scanner myReader = new Scanner(myObj);

                // Read files
                while (myReader.hasNextLine())
                {
                    String readLine = myReader.nextLine();
                    String [] splitLine = readLine.split(":");
                    if(splitLine[0].contains("D"))
                        dev.add(splitLine[2]+" - "+splitLine[0]);
                }
                myReader.close();
            }
            // Catch error
            catch (FileNotFoundException e)
            {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            String [] devName = new String[dev.size()];
            for(int i = 0; i < dev.size(); i++)
            {
                devName[i] = dev.get(i);
            }
            return devName;
    }
    public String [] getDeveloperID()
    {
        ArrayList<String> Reviewer = new ArrayList<String>();
        try
            {
                File myObj = new File("accounts.txt");
                Scanner myReader = new Scanner(myObj);

                // Read files
                while (myReader.hasNextLine())
                {
                    String readLine = myReader.nextLine();
                    String [] splitLine = readLine.split(":");
                    if(splitLine[0].contains("D"))
                        Reviewer.add(splitLine[2]+" - "+splitLine[0]);
                }
                myReader.close();
            }
            // Catch error
            catch (FileNotFoundException e)
            {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            String [] DeveloperID = new String[Reviewer.size()];
            for(int i = 0; i < Reviewer.size(); i++)
            {
                DeveloperID[i] = Reviewer.get(i);
            }
            return DeveloperID;
    }
    public void saveUploadFile(String file, String bugid)
    {
        Patch patch = new Patch();
        patch.SetPatch(file);
        BugReport b1 = new BugReport();
        b1.savePatchData(patch, bugid);
    }
}
