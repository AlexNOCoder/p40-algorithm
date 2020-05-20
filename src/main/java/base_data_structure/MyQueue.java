package base_data_structure;

import java.util.ArrayList;
import java.util.List;

public class MyQueue {
    private List<Integer> data;
    private int start;

    public MyQueue(){
        this.data = new ArrayList<>();
        this.start = 0;
    }

    public boolean enQueue(int x){
        data.add(x);
        return true;
    }

    public boolean deQueue(){
        if(isEmpty()){
            return false;
        }
        start ++;
        return true;
    }

    public boolean isEmpty(){
        return start >= data.size();
    }

    public int peek(){
        return data.get(start);
    }

    public int poll(){
        int temp = data.get(start);
        deQueue();
        return temp;
    }
}
