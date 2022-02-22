package alien_dictionary_269;


import org.checkerframework.checker.units.qual.C;

import java.util.*;

public class SolutionByAlex {
    public String alienOrder(String[] words){
        // 输入为空处理
        if(words == null || words.length == 0){

            return null;
        }
        // 输入的字符串只有一个处理
        if(words.length ==  1){
            return words[0];
        }
        // 构建有向图：定义邻接链表adjList，表示有向图。也可以使用邻接矩阵
        Map<Character, List<Character>> adjList = new HashMap<>();

        for(int i=0;i<words.length-1;i++){
            // 然后两两比较字符串
            // 对每个出现的字母都创建一个图里的顶点
            // 一旦发现两字母不同，就连接这两个顶点
            String w1 = words[i];
            String w2 = words[i+1];
            int n1 = w1.length();
            int n2 = w2.length();
            // 在这里，定义一个found变量
            // 表明一旦出现不同字母，只需处理好这两个字母，或顶点的关系
            // 之后的字母就不需要考虑
            boolean found = false;

            for(int j=0;j< Math.max(w1.length(),w2.length());j++){
                Character c1 = j < n1 ? w1.charAt(j):null;
                Character c2 = j < n2 ? w2.charAt(j):null;

                if(c1 != null && !adjList.containsKey(c1)){
                    adjList.put(c1,new ArrayList<>());
                }
                if(c2 != null && !adjList.containsKey(c2)){
                    adjList.put(c2,new ArrayList<>());
                }
                if(c1 != null && c2 !=null && c1 != c2 && !found){
                    adjList.get(c1).add(c2);
                    found = true;
                }
            }
        }
        // 开始拓扑排序
        Set<Character> visited = new HashSet<Character>();
        Set<Character> loop = new HashSet<>();
        // 需要一个stack来记录顶点的顺序
        // 最后将stack倒过来输出就是最终的结果
        Stack<Character> stack = new Stack<>();

        for(Character key:adjList.keySet()){
            if(!visited.contains(key)){
               if(!toplogicSort(adjList,key,visited,loop,stack)){
                   return "";
               }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return  sb.toString();
    }
    // 用深度优先搜实现的拓扑排序
    boolean toplogicSort(Map<Character,List<Character>> adjList,char u,Set<Character> visited,Set<Character> loop,Stack<Character> stack){
        // visited集合用来记录已访问过的顶点
        // stack堆栈：当从某顶点出发，访问完其他所有顶点，最后才把当前顶点加入到堆栈，即要想把该点加入stack里，必须先把其他跟它有联系的顶点都处理完毕
        // loop集合：防止有向图中出现环的情况  A->B->C->D->B    A->B->C D->B 其实无环；每次需要把loop清空
        // 将当前节点u加入visited集合以及loop集合中
        visited.add(u);
        loop.add(u);
        // 逐个访问与顶点u相邻的其他顶点v
        if(adjList.containsKey(u)){
            for(int i=0;i < adjList.get(u).size();i++){
                char v = adjList.get(u).get(i);

                // 如果在此轮访问过程中，v其实早已被访问过，则此处有环，返回false
                if(loop.contains(v)){
                   return false;
                }
                // 否则，如果顶点v还没有被访问过，就递归地访问它，如果在访问顶点v时发现了环，则返回false
                if(!visited.contains(v)){
                  if(!toplogicSort(adjList,v,visited,loop,stack)){
                      return false;
                  }
                }
            }
        }
        // 当这一轮访问结束后，即从顶点u出发，访问完毕所有能访问的点，将u从loop集合中删除
        loop.remove(u);
        // 把u加入堆栈中
        stack.push(u);
        // 返回true，表示此时访问没有发现环
        return true;
    }
}

