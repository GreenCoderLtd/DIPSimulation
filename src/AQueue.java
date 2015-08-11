
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Avishek
 */
public class AQueue<T> implements IQueue<T>{
    
    List<T> list;
    int maxSize;

    public AQueue(int maxSize) {
        
        list=new LinkedList<T>();
        this.maxSize=maxSize;
    }
    
    

    @Override
    public void enqueue(T o) {
        
        
        if(maxSize>0 && list.size()>maxSize)
        {
            Simulation.serverStatusLabel.setText("Service Fail");
            JOptionPane.showMessageDialog(null, "Queue Full");
        }
        else
        {
            list.add(o);
        }
        
        //list.add(o);
    }

    @Override
    public void enqueueFront(T o) {
        list.add(0, o);
    }

    @Override
    public T dequeue() {

        T o=null;
        
        if(list.size()>0)
        {
        
            o=list.remove(0);
        }
        
        return o;
    }

    @Override
    public int size() 
    {
    
        return list.size();
    }

    @Override
    public boolean IsFull() {
        
        if(list.size()>=maxSize)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public int maxsize() {
        return maxSize;
    }
    
}
