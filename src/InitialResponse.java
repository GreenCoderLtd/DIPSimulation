/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Avishek
 */
public class InitialResponse implements IResponse{
    
    private long requestID;
    private Client client;

    
    public InitialResponse(Request request) {
        this.requestID = request.getRequestID();
        this.client=request.getClient();
    }

    public long getRequestID() {
        return requestID;
    }

    public void setRequestID(long requestID) {
        this.requestID = requestID;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    
    
    
}
