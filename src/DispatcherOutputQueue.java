/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Avishek
 */
public class DispatcherOutputQueue implements IDispatcher{

    IQueue<Response> queue;
    IService service;
    boolean isRunning=true;

    public DispatcherOutputQueue(IQueue<Response> queue, IService service) {
        this.queue = queue;
        this.service = service;
    }
    @Override
    public void run() {

        while(isRunning)
        {
            try {
                    
                        Thread.sleep(300);
                            
                } 
                catch (InterruptedException ex) 
                {
                   
                }
            
            Response response=queue.dequeue();
            
            if(response!=null)
            {
               Simulation.outputQueueLoadLabel.setText(queue.size()+"");
            
               System.out.println("Output queue size "+queue.size()); 
               
               response.setTime(System.currentTimeMillis());
               //response.getClient().setResponse(response);
               System.out.println("Request Id "+response.getRequestID()+" Respone Time "+(response.getTime()-response.getClient().getRequest().getTime()) );
               
            }
            else
            {
                try {
                    
                        Thread.sleep(500);
                            
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
