package min_stack_155;


import java.util.ArrayList;
import java.util.List;

//时间复杂度和空间复杂度爆炸
public class SolutionByAlex {
    private List<Integer> list;

    public SolutionByAlex() {
        list = new ArrayList();
    }

    public void push(int x) {
        list.add(x);
    }

    public void pop() {

        list.remove(list.size()-1);
    }

    public int top() {
        return list.get(list.size()-1);
    }

    public int getMin() {
        int temp = Integer.MAX_VALUE;
        for(Integer i:list){
            if(i < temp){
                temp = i;
            }
        }
        return temp;
    }
}

