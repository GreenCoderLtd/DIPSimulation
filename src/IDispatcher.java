/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Avishek
 */
public interface IDispatcher extends Runnable{
    
    public void run();
    
    public boolean isIsRunning();

    public void setIsRunning(boolean isRunning);
    
}
