/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Avishek
 */
public class ServiceEdge implements IService{
    
    
    IQueue<Request> inQueue;
    IQueue<IResponse> outQueue;
    Handler handler;
    IDispatcher dispatcher;
    boolean isRunning=true;
    IService service;

    public ServiceEdge(IQueue inQueue,IQueue outQueue,IService service) {
        
        this.inQueue=inQueue;
        this.outQueue = outQueue;
        this.service=service;
   
        handler=new Handler(inQueue,service);
        dispatcher=new DispatcherOutputQueue(outQueue,this);
        
        Thread dispatcherThread=new Thread(dispatcher);
        dispatcherThread.start();
    }

    
    @Override
    public IResponse getResult(Request request)
    {
        request.setRequestID(Utility.generateRequestId());
        
        handler.handleRequest(request);
        
        IResponse response=new InitialResponse(request);
        
        return response;
    }
    
}
