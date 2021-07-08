/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BugTracker;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author malla
 */
public class LoginUITest {
    
    public LoginUITest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of checkValidity method, of class LoginUI.
     */
    @Test
    public void testCheckValidity() {
        
        System.out.println("Checking User Validity");
        System.out.println("----------------------");
        String[][] accountDataDeveloper = {{"D12345","qweasd","David White"}};
        String[][] accountDataUser = {{"U12345","qweasd","Walter Green"}};
        String[][] accountDataTriager = {{"T12345","qweasd","Barry White"}};
        String[][] accountDataReviewer = {{"R12345","qweasd","John Davis"}};
        String[] userDetailsDeveloper = {"D12345","qweasd"};
        String[] userDetailsUser = {"U12345","qweasd"};
        String[] userDetailsTriager = {"T12345","qweasd"};
        String[] userDetailsReviewer = {"R12345","qweasd"};
        
        System.out.println("Checking Developer...");
        LoginController instanceDev = new LoginController();
        String expResultDev = "Valid UserDavid White";
        String resultDev = instanceDev.checkValidity(accountDataDeveloper, userDetailsDeveloper);
        assertEquals(expResultDev, resultDev);
        System.out.println("Developer checked, Login Successful...\n");
        
        System.out.println("Checking User...");
        LoginController instanceUser = new LoginController();
        String expResultUser = "Valid UserWalter Green";
        String resultUser = instanceUser.checkValidity(accountDataUser, userDetailsUser);
        assertEquals(expResultUser, resultUser);
        System.out.println("User checked, Login Successful...\n");
        
        System.out.println("Checking Triager...");
        LoginController instanceTria = new LoginController();
        String expResultTria = "Valid UserBarry White";
        String resultTria = instanceTria.checkValidity(accountDataTriager, userDetailsTriager);
        assertEquals(expResultTria, resultTria);
        System.out.println("Triager checked, Login Successful...\n");
        
        System.out.println("Checking Reviewer...");
        LoginController instanceRev = new LoginController();
        String expResultRev = "Valid UserJohn Davis";
        String resultRev = instanceRev.checkValidity(accountDataReviewer, userDetailsReviewer);
        assertEquals(expResultRev, resultRev);
        System.out.println("Reviewer checked, Login Successful...\n");
        // TODO review the generated test code and remove the default call to fail.
    }
    
    /**
     * Test of main method, of class LoginUI.
     */
    @Test
    public void testMain() {
        
        String[] args = null;
        LoginUI.main(args);
        // TODO review the generated test code and remove the default call to fail.
        //fail("Before Writing Test Script");
    }
    
}
