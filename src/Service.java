
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Avishek
 */
public class Service implements IService{
    
    IQueue<Request> inQueue;
    IQueue<IResponse> outQueue;
    IDispatcher dispatcher;
    int maxLoad;
    int handlingUser;
    int serviceDelay;
    boolean isRunning=true;

    public Service(IQueue inQueue,IQueue outQueue, int maxLoad,int serviceDelay) {
        this.inQueue=inQueue;
        this.outQueue = outQueue;
        this.maxLoad = maxLoad;
        this.serviceDelay=serviceDelay;
        
        dispatcher=new DispatcherInputQueue(inQueue,this);
        
        Thread dispatcherThread=new Thread(dispatcher);
        dispatcherThread.start();
    }
    
    
    
    @Override
    public IResponse getResult(Request request)
    {
     
        if(isRunning)
        {
            handlingUser++;
            
            Simulation.requestProcessingLabel.setText(handlingUser+"");

            if(handlingUser>maxLoad)
            {

                Simulation.serverStatusLabel.setText("Service Fail");
                isRunning=false;
                dispatcher.setIsRunning(isRunning);
            }
            else
            {
                try 
                {
                    Thread.sleep(serviceDelay);
                    
                    handlingUser--;
                    
                    Simulation.requestProcessingLabel.setText(handlingUser+"");
                    
                    Response response=new Response(request,Utility.generateGPA());
                    
                    if(inQueue.maxsize()>0)
                    {
                        outQueue.enqueue(response);
                    
                        Simulation.outputQueueLoadLabel.setText(outQueue.size()+"");
                    
                    }
                    
                    return response;
                } 
                catch (InterruptedException ex) 
                {
                    
                }
            }
        }
        else
        {
            Simulation.requestProcessingLabel.setText("0");
        }
        
        return null;
        
    }
}
