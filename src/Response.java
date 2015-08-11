/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Avishek
 */
public class Response implements IResponse{
    
    private long requestID;
    private double gpa;
    private long time; 
    private Client client;
    
    public Response(Request req,double gpa) {
        this.requestID = req.getRequestID();
        this.client=req.getClient();
        client.setResponse(this);
        this.gpa = gpa;
    }

    public long getRequestID() {
        return requestID;
    }

    public void setRequestID(long requestID) {
        this.requestID = requestID;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
    
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
