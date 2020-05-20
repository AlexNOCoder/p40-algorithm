package base_data_structure;

//用size存储数据量，可以多存一个数
public class MyCircularQueue {
    private int[] data;
    private int front ;
    private int rear;
    private int size;

    public MyCircularQueue(int k) {
        this.data = new int[k];
        this.front = 0;
        this.rear = 0;
        this.size = 0;
    }

    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }

        data[rear] = value;
        rear = (rear + 1)%data.length;
        size++;
        return true;
    }


    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        front = (front+1)%data.length;
        size--;
        return true;
    }


    public int Front() {
        if(isEmpty()){
            return -1;
        }

        return data[front];
    }


    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        return data[(rear-1+data.length)%data.length];
    }


    public boolean isEmpty() {
        return size==0;
    }


    public boolean isFull() {
        return size == data.length;
    }

    public static void main(String[] args) {
        MyCircularQueue obj = new MyCircularQueue(5);
        boolean param_1 = obj.enQueue(2);
        boolean param_2 = obj.enQueue(3);
        boolean param_3 = obj.deQueue();
        int param_4 = obj.Rear();
        int param_5 = obj.Front();
        boolean param_6 = obj.isEmpty();
        boolean param_7 = obj.isFull();
    }
}
