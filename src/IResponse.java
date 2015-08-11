/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Avishek
 */
public interface IResponse {
    
    public long getRequestID();

    public void setRequestID(long requestID);
    
    public Client getClient();

    public void setClient(Client client);

    
}
