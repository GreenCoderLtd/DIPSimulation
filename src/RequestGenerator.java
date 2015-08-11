
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
public class RequestGenerator implements Runnable{
    
    private int totalRequest;
    private IService service;

    public RequestGenerator(int totalRequest, IService service) {
        this.totalRequest = totalRequest;
        this.service = service;
    }

    
    
    
    public void run()
    {
        for(int i=0;i<totalRequest;i++)
        {
            
            Client client=new Client();
            
            service.getResult(client.getRequest());
            
            try {
                
                System.out.println("Sending reqiuest "+(i+1));
                
                long rd=Utility.generateRequestDelay();
                
                Thread.sleep(rd);
                
                
            } 
            catch (InterruptedException ex) {
                Logger.getLogger(RequestGenerator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        //Simulation.requestProcessingLabel.setText("0");
    }
}
