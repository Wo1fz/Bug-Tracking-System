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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author malla
 */
public class BugReport {
    private String [] data = new String[15];
    
    public BugReport()
    {
        
    }
    
    public void setBugData(String [] data)
    {
        for(int i = 0; i < data.length; i++)
            this.data[i] = data[i];
    }
    public String [] getBugData()
    {
        return data;
    }

    public boolean SaveReportedBug(String[] array)
    {
        String line = "";
            for(int i = 0; i < array.length; i++)
            {
                line += array[i];
                if(i < array.length - 1)
                    line += ":";
            }
            //write the data to text file
            try(FileWriter fw = new FileWriter("BugReport.txt", true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter out = new PrintWriter(bw))
            {
                out.write(line+"\n");
            } 
            catch (IOException e) 
            {
		System.out.println("An error occurred.");
                e.printStackTrace();
            }
         
        return true;
    }

    public boolean UpdateBugReport(ArrayList<String>bugReports, String [] changeData, String [] Data)
    {
        // read and store in array
        try
	    {	
            FileReader in = new FileReader("BugReport.txt");
            BufferedReader br = new BufferedReader(in);
            // Read files
            String readLine = "";
            while ((readLine = br.readLine()) != null) 
            {
                bugReports.add(readLine);
		String [] splitLine = readLine.split(":");
                if(splitLine[0].equals(Data[5]))
                    changeData = splitLine;
            }	
            br.close();
            in.close();
	    } 
	// Catch error
	catch (IOException ex) {
            Logger.getLogger(DeveloperUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        //make change in array
        changeData[7] = Data[4];
        changeData[8] = Data[0];
        changeData[9] = Data[1];
        changeData[10] = Data[2];
        changeData[11] = Data[3];
        //make line
        String line = "";
        for(int i = 0; i < changeData.length; i++)
        {
            line += changeData[i];
            if(i < changeData.length - 1)
                line += ":";
        }
        //update in arrayList
        for(int i = 0; i < bugReports.size(); i++)
        {
            String [] splitLine = bugReports.get(i).split(":");
            if(splitLine[0].equals(changeData[0]))
                bugReports.set(i, line);
        }
        
        // write to file
            try(FileWriter fw = new FileWriter("BugReport.txt", false);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter out = new PrintWriter(bw))
            {
                for(int i = 0; i < bugReports.size(); i++)
                {
                    out.write(bugReports.get(i)+"\n");
                }
            } 
            catch (IOException e) 
            {
		System.out.println("An error occurred.");
                e.printStackTrace();
            }
        return true;
    }
    
    public void saveTestResultData(TestResult tr, String bugid)
    {
        ArrayList<String>data = new ArrayList<String>();
        String [] array = new String[15];
        //readfile
        // read and store in array
        try
	{	
	    FileReader in = new FileReader("BugReport.txt");
            BufferedReader br = new BufferedReader(in);
            // Read files
            String readLine = "";
            while ((readLine = br.readLine()) != null) 
            {
                data.add(readLine);
		String [] splitLine = readLine.split(":");
                if(splitLine[0].equals(bugid))
                    array = splitLine;
            }	
            br.close();
            in.close();
	} 
	catch (IOException ex) {
            Logger.getLogger(DeveloperUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        //update 
        String line = "";
        array[13] = tr.getTester();
        array[14] = tr.GetTestResult();
        for(int i = 0; i < array.length; i++)
        {
            line += array[i];
            if(i < array.length - 1)
                line+=":";
        }
        for(int i = 0; i < data.size(); i++)
        {
            String [] splitLine = data.get(i).split(":");
            if(splitLine[0].equals(array[0]))
                data.set(i, line);
        }
        // write to file
            try(FileWriter fw = new FileWriter("BugReport.txt", false);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter out = new PrintWriter(bw))
            {
                for(int i = 0; i < data.size(); i++)
                {
                    out.write(data.get(i)+"\n");
                }
            } 
            catch (IOException e) 
            {
		System.out.println("An error occurred.");
                e.printStackTrace();
            }
    }
    
    public void getComments(String filepath, DefaultTableModel model)
    {
        //load comments data to jtable
        File file = new File(filepath);
        
        try {
            file.createNewFile();
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String readLine = "";
            while ((readLine = br.readLine()) != null) 
            {
                String [] row = readLine.split("~");
                model.addRow(row);
            }
            fr.close();
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(ReportBugUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean storeNewComment(String filename, String [] array)
    {
        String line = "";
            for(int i = 0; i < array.length; i++)
            {
                line += array[i];
                if(i < array.length - 1)
                    line += "~";
            }
            //write the data to text file
            try(FileWriter fw = new FileWriter(filename, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter out = new PrintWriter(bw))
            {
                out.write(line+"\n");
            } 
            catch (IOException e) 
            {
		System.out.println("An error occurred.");
            }
            return true;
    }

    public void savePatchData(Patch patch, String bugid)
    {
        String file = patch.getPatch();
        ArrayList<String>data = new ArrayList<String>();
        String [] array = new String[15];
        //readfile
        // read and store in array
        try
	{	
	    FileReader in = new FileReader("BugReport.txt");
            BufferedReader br = new BufferedReader(in);
            // Read files
            String readLine = "";
            while ((readLine = br.readLine()) != null) 
            {
                data.add(readLine);
		String [] splitLine = readLine.split(":");
                if(splitLine[0].equals(bugid))
                    array = splitLine;
            }	
            br.close();
            in.close();
	} 
	catch (IOException ex) {
            Logger.getLogger(DeveloperUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        //update 
        String line = "";
        array[12] = file;
        array[9] = "Pending";
        for(int i = 0; i < array.length; i++)
        {
            line += array[i];
            if(i < array.length - 1)
                line+=":";
        }
        for(int i = 0; i < data.size(); i++)
        {
            String [] splitLine = data.get(i).split(":");
            if(splitLine[0].equals(array[0]))
                data.set(i, line);
        }
        // write to file
            try(FileWriter fw = new FileWriter("BugReport.txt", false);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter out = new PrintWriter(bw))
            {
                for(int i = 0; i < data.size(); i++)
                {
                    out.write(data.get(i)+"\n");
                }
            } 
            catch (IOException e) 
            {
		System.out.println("An error occurred.");
                e.printStackTrace();
            }
    }
    public boolean updateInvalidBug(String bugid, ArrayList<BugReport>bugReportList)
    {   
        for(int i = 0; i < bugReportList.size(); i++)
        {
            String [] array = bugReportList.get(i).getBugData();
            if(array[0].equals(bugid))
            {
                array[9] = "Invalid";
                bugReportList.get(i).setBugData(array);
            }
        }
      
        //update in text file
        try(FileWriter fw = new FileWriter("BugReport.txt", false);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter out = new PrintWriter(bw))
        {
            for(int i = 0; i < bugReportList.size(); i++)
            {
                String line = "";
                String [] array = bugReportList.get(i).getBugData();
                for(int j = 0; j < array.length; j++)
                {
                    if(j < array.length - 1)
                    {
                        line += array[j];
                        line += ":";
                    }
                    else if(j == array.length - 1)
                        line += array[j];
                }
                out.write(line+"\n");
            }
        } catch (IOException ex) {
            Logger.getLogger(ReportBugUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    public boolean updateSolvedBug(String bugid, ArrayList<BugReport>bugReportList)
    {
        for(int i = 0; i < bugReportList.size(); i++)
        {
            String [] array = bugReportList.get(i).getBugData();
            if(array[0].equals(bugid))
            {
                array[9] = "Resolved";
                bugReportList.get(i).setBugData(array);
            }
        }
      
        //update in text file
        try(FileWriter fw = new FileWriter("BugReport.txt", false);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter out = new PrintWriter(bw))
        {
            for(int i = 0; i < bugReportList.size(); i++)
            {
                String line = "";
                String [] array = bugReportList.get(i).getBugData();
                for(int j = 0; j < array.length; j++)
                {
                    if(j < array.length - 1)
                    {
                        line += array[j];
                        line += ":";
                    }
                    else if(j == array.length - 1)
                        line += array[j];
                }
                out.write(line+"\n");
            }
        } catch (IOException ex) {
            Logger.getLogger(ReportBugUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    public String [] getSearchBugs(ArrayList<BugReport>bugReports, String searchParam, String searchText)
    {
        ArrayList <String> data = new ArrayList<String>();
            // Read files
            
            for(int i = 0; i < bugReports.size(); i++)
            {
                String readLine = "";
                String[]splitArr = bugReports.get(i).getBugData();
                if(searchParam.equals("Bug Title"))
                {
                    if(splitArr[1].contains(searchText) || splitArr[1].equalsIgnoreCase(searchText))
                    {
                        for(int j = 0; j < splitArr.length; j++)
                        {
                            readLine+=splitArr[j];
                            if(j < splitArr.length - 1)
                                readLine += ":";
                        }
                        data.add(readLine);
                    }
                }
                if(searchParam.equals("Keyword"))
                {
                    if(splitArr[2].contains(searchText) || splitArr[2].equalsIgnoreCase(searchText))
                    {
                        for(int j = 0; j < splitArr.length; j++)
                        {
                            readLine+=splitArr[j];
                            if(j < splitArr.length - 1)
                                readLine += ":";
                        }
                        data.add(readLine);
                    }
                }
                if(searchParam.equals("Bug ID"))
                {
                    if(splitArr[0].equals(searchText))
                    {
                        for(int j = 0; j < splitArr.length; j++)
                        {
                            readLine+=splitArr[j];
                            if(j < splitArr.length - 1)
                                readLine += ":";
                        }
                        data.add(readLine);
                    }
                }
                if(searchParam.equals("Assignee"))
                {
                    if(splitArr[7].contains(searchText) || splitArr[7].equalsIgnoreCase(searchText))
                    {
                        for(int j = 0; j < splitArr.length; j++)
                        {
                            readLine+=splitArr[j];
                            if(j < splitArr.length - 1)
                                readLine += ":";
                        }
                        data.add(readLine);
                    }
                }
                if(searchParam.equals("Reporter"))
                {
                    if(splitArr[6].contains(searchText) || splitArr[6].equalsIgnoreCase(searchText))
                    {
                        for(int j = 0; j < splitArr.length; j++)
                        {
                            readLine+=splitArr[j];
                            if(j < splitArr.length - 1)
                                readLine += ":";
                        }
                        data.add(readLine);
                    }
                }
            }	 
	
        String [] array = new String[data.size()];
        for(int i = 0; i < array.length; i++)
        {
            array[i] = data.get(i);
        }
        return array;
    }
}
