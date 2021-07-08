/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BugTracker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author malla
 */
public class Triager extends User
{
    private String bugid = "";
    private ArrayList<BugReport>bugReportList = new ArrayList<>();
    private File file = new File("");
    private Date u1 = new Date();
    private Date u2 = new Date();
    private String [] TriagerName = new String[15];
    private String [] TriagerID = new String[15];
    
    public Triager()
    {
    
    }
    public String[] getDevArray()
    {
        Developer d1 = new Developer();
        String [] devNameArr = d1.getDevName();
        return devNameArr;
    }
    public boolean setInvalidBug(String bugid, ArrayList<BugReport>bugReportList)
    {   
        BugReport br = new BugReport();
        boolean success = br.updateInvalidBug(bugid, bugReportList);
        return success;
    }
    public boolean setBugSolved(String bugid, ArrayList<BugReport>bugReportList)
    {
        BugReport br = new BugReport();
        boolean success = br.updateSolvedBug(bugid, bugReportList);
        return success;
    }
    public boolean getReporterReport(File file, Date u1, Date u2)
    {
        Report rp = new Report();
        boolean success = rp.generateReporterReport(file, u1, u2);
        return success;
    }
    public boolean getDeveloperReport(File file, Date u1, Date u2)
    {
        Report dr = new Report();
        boolean success = dr.generateDeveloperReport(file, u1, u2);
        return success;
    }
    public String [] getTriagerName()
    {
        ArrayList<String> Triager = new ArrayList<String>();
        try
            {
                File myObj = new File("accounts.txt");
                Scanner myReader = new Scanner(myObj);

                // Read files
                while (myReader.hasNextLine())
                {
                    String readLine = myReader.nextLine();
                    String [] splitLine = readLine.split(":");
                    if(splitLine[0].contains("T"))
                        Triager.add(splitLine[2]+" - "+splitLine[0]);
                }
                myReader.close();
            }
            // Catch error
            catch (FileNotFoundException e)
            {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            String [] TriagerName = new String[Triager.size()];
            for(int i = 0; i < Triager.size(); i++)
            {
                TriagerName[i] = Triager.get(i);
            }
            return TriagerName;
    }
    public String [] getTriagerID()
    {
        ArrayList<String> Triager = new ArrayList<String>();
        try
            {
                File myObj = new File("accounts.txt");
                Scanner myReader = new Scanner(myObj);

                // Read files
                while (myReader.hasNextLine())
                {
                    String readLine = myReader.nextLine();
                    String [] splitLine = readLine.split(":");
                    if(splitLine[0].contains("T"))
                        Triager.add(splitLine[2]+" - "+splitLine[0]);
                }
                myReader.close();
            }
            // Catch error
            catch (FileNotFoundException e)
            {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            String [] TriagerID = new String[Triager.size()];
            for(int i = 0; i < Triager.size(); i++)
            {
                TriagerID[i] = Triager.get(i);
            }
            return TriagerID;
    }
    
}
