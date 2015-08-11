/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Avishek
 */
public class Handler {
    
    IQueue<Request> inQueue;
    IService service;


    Handler(IQueue inQueue, IService service) {
       this.inQueue = inQueue;
       this.service=service;
    }
    
    public boolean shouldPrioritize(Request request)
    {
        if(request.getRequestID()%7==0)
        {
            return true;
        }
        
        return false;
    }
    
    public void handleRequest(final Request request)
    {
        if(inQueue.maxsize()>0)
        {
            new Thread(new Runnable(){
            
                public void run()
                {
                    if(shouldPrioritize(request))
                    {
                        inQueue.enqueueFront(request);
                    }
                    else
                    {
                        inQueue.enqueue(request);
                    }

                    Simulation.inputQueueLoadLabel.setText(inQueue.size()+"");
                }
            
            }).start();
            
        }
        else
        {
            new Thread(new Runnable(){
            
                public void run()
                {
                    service.getResult(request);
                }
            
            }).start();
            
        }
    }
    
}
