/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BugTracker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author malla
 */
public class Reviewer extends User
{
    private String [] ReviewerName = new String[10];
    private String [] ReviewerID = new String[10];
    private String tr = "";
    private String bugid = "";
    public Reviewer()
    {
        
    }
    public String [] getReviewerName()
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
                    if(splitLine[0].contains("R"))
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
            String [] ReviewerName = new String[Reviewer.size()];
            for(int i = 0; i < Reviewer.size(); i++)
            {
                ReviewerName[i] = Reviewer.get(i);
            }
            return ReviewerName;
    }
    public String [] getReviewerID()
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
                    if(splitLine[0].contains("R"))
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
            String [] ReviewerID = new String[Reviewer.size()];
            for(int i = 0; i < Reviewer.size(); i++)
            {
                ReviewerID[i] = Reviewer.get(i);
            }
            return ReviewerID;
    }
    public void updateTestResult(TestResult tr, String bugid)
    {
        BugReport br = new BugReport();
        br.saveTestResultData(tr, bugid);
    }
}
