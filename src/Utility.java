/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Avishek
 */
public class Utility {
    
    static int ROLL_NUMBER_LIMIT=9999;
    
    static double GPA_LIMIT=4;
    
    public static int REQUEST_ID;
    
    static int REQUEST_DELAY_LIMIT=200;
    
    public static int generateRollNumber()
    {
        double d= Math.random()*ROLL_NUMBER_LIMIT;
        
        int roll= (int) d;
        
        return roll;
    }
    
    public static int generateRequestId()
    {
        REQUEST_ID=REQUEST_ID+1;
        
        return REQUEST_ID;
    }
    
     public static int generateRequestDelay()
    {
         double d= Math.random()*REQUEST_DELAY_LIMIT;
        
        int delay= (int) d;
        
        return delay;
    }
    
    public static double generateGPA()
    {
        double gpa= Math.random()*GPA_LIMIT;
        
        return gpa;
    }
    
}
