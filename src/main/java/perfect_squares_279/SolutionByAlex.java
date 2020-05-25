package perfect_squares_279;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SolutionByAlex {

    public int numSquares(int n) {
        List<Integer> list = new ArrayList();
        for(int i=1;i*i <=n;i++){
            list.add(i*i);
        }
        int minLength = 0;
        int size = list.size();
        Queue<Integer> queue = new LinkedList();
        queue.offer(n);
        while(!queue.isEmpty()){
            minLength++;
            int width = queue.size();
            for(int j=0;j< width;j++){
                int temp = queue.poll();
                for(int k=size-1;k>=0;k--){
                    if(list.get(k).equals(temp)){
                        return minLength;
                    }else if(list.get(k) < temp){
                        queue.offer(temp - list.get(k));
                    }
                }
            }
        }
        return minLength;
    }

}
