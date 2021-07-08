/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BugTracker;

/**
 *
 * @author malla
 */
public class TestResult {
    private String TestResult;
    private String Tester;
    public TestResult()
    {
    
    }
    public void setTester(String Tester)
    {
        this.Tester = Tester;
    }
    public void SetTestResult(String TestResult)
    {
        this.TestResult = TestResult;
    }
    public String getTester()
    {
        return Tester;
    }
    public String GetTestResult()
    {
        return TestResult;
    }
}
