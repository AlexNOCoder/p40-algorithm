package moving_average_from_data_stream_346;

import java.util.LinkedList;
import java.util.Queue;

public class SolutionByAlex {

    private int size;
    private double sum;
    //滑动窗口与队列
    private Queue<Integer> queue;
    public SolutionByAlex(int size) {
        this.size = size;
        this.queue = new LinkedList<>();
        this.sum = 0.0;
    }

    public double next(int val) {
        sum += val;
        queue.offer(val);
        if(queue.size() > size){
            sum -= queue.remove();
        }
        return sum/ queue.size();
    }
}
