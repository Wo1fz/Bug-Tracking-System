/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BugTracker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 *
 * @author malla
 */
public class Report 
{
    public Report()
    {
    
    }
    public boolean generateReporterReport(File file, Date u1, Date u2)
    {
        try 
	{
            FileReader in = new FileReader("BugReport.txt");
            BufferedReader br = new BufferedReader(in);
            ArrayList<String>bugReports = new ArrayList<String>();
            String [] allReport = new String [1000];
            int i = 0;
            
            String readLine = "";
            while ((readLine = br.readLine()) != null) 
            {
                allReport[i] = readLine;
                bugReports.add(readLine);
		i++;
            }
            String [][] afterSplit = new String [bugReports.size()][15];
            for(int z = 0; z < allReport.length; z++)
            {
		if(allReport[z] != null)
		{
                    afterSplit[z] = allReport[z].split(":");
		}
            }
			
            try
            {
                int reportNo = 1;
		ArrayList <String> reporters = new ArrayList <String> ();
		ArrayList <String> repNum = new ArrayList <String> ();
                SimpleDateFormat sdformat = new SimpleDateFormat("dd/MM/yyyy");

                // append to file
		try 
		{
                    file.createNewFile();
                    FileWriter write2File = new FileWriter(file);
                    write2File.write("======================================\n");
                    write2File.write("       Report for Bugs Reporter\n");
                    write2File.write("======================================\n");
                    write2File.write("Time Period: " + sdformat.format(u1) + " - " + sdformat.format(u2) + "\n\n");
                    write2File.close();
					
                    for(int r = 0; r < afterSplit.length; r++)
                    {
			if((reporters.contains(afterSplit[r][6])) == false)
			{
                            reporters.add(afterSplit[r][6]);
			}
                    }
					
                    int [] reporterTotal = new int [reporters.size()];
                    Arrays.fill(reporterTotal, 0);
					
                    for(int y = 0; y < afterSplit.length; y++)
                    {
			Date rep = sdformat.parse(afterSplit[y][3]);
					
                        if((rep.compareTo(u1) >= 0) && (rep.compareTo(u2) <= 0))
			{
                            for(int k = 0; k < reporters.size(); k++)
                            {
				if(afterSplit[y][6].equals(reporters.get(k)))
				{
                                    reporterTotal[k] = reporterTotal[k] + 1;
				}
                            }
			}
                    }
					
                    for(int h = 0; h < reporters.size(); h++)
                    {
			FileWriter writers = new FileWriter(file, true);
			writers.write("Reporter Name: " + reporters.get(h) + "\n");
			writers.write("Reported Bugs: " + reporterTotal[h] + "\n\n");
			writers.close();
                    }
					
                    for(int f = 0; f < afterSplit.length; f++)
                    {
                        Date reported = sdformat.parse(afterSplit[f][3]);
						
			if((reported.compareTo(u1) >= 0) && (reported.compareTo(u2) <= 0))
                        {
                            FileWriter myWriter = new FileWriter(file, true);
                            myWriter.write("----------------------------------\n");
                            myWriter.write("           Bug report " + (reportNo++) + "\n");
                            myWriter.write("----------------------------------\n");
                            myWriter.write("Bug ID: " + afterSplit[f][0] + "\n");
                            myWriter.write("Bug Title: " + afterSplit[f][1] + "\n");
                            myWriter.write("Keyword: " + afterSplit[f][2] + "\n");
                            myWriter.write("Reported Date: " + afterSplit[f][3] + "\n");
                            myWriter.write("Description: " + afterSplit[f][4] + "\n");
                            myWriter.write("Summary: " + afterSplit[f][5] + "\n");
                            myWriter.write("Reporter: " + afterSplit[f][6] + "\n");
                            myWriter.write("Assignee: " + afterSplit[f][7] + "\n");
                            myWriter.write("Developer: " + afterSplit[f][8] + "\n");
                            myWriter.write("Current Status: " + afterSplit[f][9] + "\n");
                            myWriter.write("Priority: " + afterSplit[f][10] + "\n");
                            myWriter.write("Severity: " + afterSplit[f][11] + "\n");
                            myWriter.write("Patch Submission: " + afterSplit[f][12] + "\n");
                            myWriter.write("Reviewer: " + afterSplit[f][13] + "\n");
                            myWriter.write("Test Result: " + afterSplit[f][14] + "\n\n");
                            myWriter.close();
			}
                    }
		}
				
                catch (IOException e) 
                {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
            }
		
            catch(ParseException ex)
            {
                System.out.println("Parse error");
            }
        } 	
        catch (IOException ex) 
	{
            System.out.println("File not found");
        }
        return true;
    }
    
    public boolean generateDeveloperReport(File file, Date u1, Date u2)
    {
        try 
	{
            FileReader in = new FileReader("BugReport.txt");
            BufferedReader br = new BufferedReader(in);
            ArrayList<String>bugReports = new ArrayList<String>();
            String [] allReport = new String [1000];
            int i = 0;
            
            String readLine = "";
            while ((readLine = br.readLine()) != null) 
            {
                allReport[i] = readLine;
                bugReports.add(readLine);
		i++;
            }
            String [][] afterSplit = new String [bugReports.size()][15];
            for(int z = 0; z < allReport.length; z++)
            {
		if(allReport[z] != null)
		{
                    afterSplit[z] = allReport[z].split(":");
		}
            }
			
            try
            {
                int reportNo = 1;
		ArrayList <String> developers = new ArrayList <String> ();
		ArrayList <String> devNum = new ArrayList <String> ();
                SimpleDateFormat sdformat = new SimpleDateFormat("dd/MM/yyyy");

                // append to file
		try 
		{
                    file.createNewFile();
                    FileWriter write2File = new FileWriter(file);
                    write2File.write("======================================\n");
                    write2File.write("       Report for Bugs Developer\n");
                    write2File.write("======================================\n");
                    write2File.write("Time Period: " + sdformat.format(u1) + " - " + sdformat.format(u2) + "\n\n");
                    write2File.close();
					
                    Developer dev = new Developer();
                    String [] devArr = dev.getDevName();
                    for(int de = 0; de < devArr.length; de++)
                    {
                        developers.add(devArr[de]);
                    }
					
                    int [] developerTotal = new int [developers.size()];
                    Arrays.fill(developerTotal, 0);
					
                    for(int y = 0; y < afterSplit.length; y++)
                    {
			Date rep = sdformat.parse(afterSplit[y][3]);
					
                        if((rep.compareTo(u1) >= 0) && (rep.compareTo(u2) <= 0))
			{
                            for(int k = 0; k < developers.size(); k++)
                            {
				if(afterSplit[y][8].equals(developers.get(k)))
				{
                                    developerTotal[k] = developerTotal[k] + 1;
				}
                            }
			}
                    }
					
                    for(int h = 0; h < developers.size(); h++)
                    {
			FileWriter writers = new FileWriter(file, true);
			writers.write("Developer Name: " + developers.get(h) + "\n");
			writers.write("Total Bugs: " + developerTotal[h] + "\n\n");
			writers.close();
                    }
					
                    for(int f = 0; f < afterSplit.length; f++)
                    {
                        Date reported = sdformat.parse(afterSplit[f][3]);
						
			if((reported.compareTo(u1) >= 0) && (reported.compareTo(u2) <= 0))
                        {
                            FileWriter myWriter = new FileWriter(file, true);
                            myWriter.write("----------------------------------\n");
                            myWriter.write("           Bug report " + (reportNo++) + "\n");
                            myWriter.write("----------------------------------\n");
                            myWriter.write("Bug ID: " + afterSplit[f][0] + "\n");
                            myWriter.write("Bug Title: " + afterSplit[f][1] + "\n");
                            myWriter.write("Keyword: " + afterSplit[f][2] + "\n");
                            myWriter.write("Reported Date: " + afterSplit[f][3] + "\n");
                            myWriter.write("Description: " + afterSplit[f][4] + "\n");
                            myWriter.write("Summary: " + afterSplit[f][5] + "\n");
                            myWriter.write("Reporter: " + afterSplit[f][6] + "\n");
                            myWriter.write("Assignee: " + afterSplit[f][7] + "\n");
                            myWriter.write("Developer: " + afterSplit[f][8] + "\n");
                            myWriter.write("Current Status: " + afterSplit[f][9] + "\n");
                            myWriter.write("Priority: " + afterSplit[f][10] + "\n");
                            myWriter.write("Severity: " + afterSplit[f][11] + "\n");
                            myWriter.write("Patch Submission: " + afterSplit[f][12] + "\n");
                            myWriter.write("Reviewer: " + afterSplit[f][13] + "\n");
                            myWriter.write("Test Result: " + afterSplit[f][14] + "\n\n");
                            myWriter.close();
			}
                    }
		}
				
                catch (IOException e) 
                {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
            }
		
            catch(ParseException ex)
            {
                System.out.println("Parse error");
            }
        } 	
        catch (IOException ex) 
	{
            System.out.println("File not found");
        }
        return true;
    }
}
