/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Avishek
 */
class Request {
    
    private long requestID;
    private int rollNumber;
    private long time;
    private Client client;

    public Request(int rollNumber,Client client) {
        this.rollNumber = rollNumber;
        this.client=client;
        time=System.currentTimeMillis();
    }

    public long getRequestID() {
        return requestID;
    }

    public void setRequestID(long requestID) {
        this.requestID = requestID;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
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
