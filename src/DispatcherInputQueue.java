/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Avishek
 */
public class DispatcherInputQueue implements IDispatcher{

    IQueue<Request> queue;
    IService service;
    boolean isRunning=true;

    public DispatcherInputQueue(IQueue<Request> queue, IService service) {
        this.queue = queue;
        this.service = service;
    }
    @Override
    public void run() {

        while(isRunning)
        {
            Request request=queue.dequeue();
            
            Simulation.inputQueueLoadLabel.setText(queue.size()+"");
            
            if(request!=null)
            {
               service.getResult(request);
               
            }
            else
            {
                try {
                    
                        Thread.sleep(100);
                            
                } 
                catch (InterruptedException ex) 
                {
                   
                }
            }
        }
    }

    public boolean isIsRunning() {
        return isRunning;
    }

    public void setIsRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }
    
    
    
}
