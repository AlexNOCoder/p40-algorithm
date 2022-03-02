package common.other;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author luoyuntian
 * @program: p40-algorithm
 * @description: 邻接表
 * @date 2022-03-03 07:22:18
 */
public class AdjacencyList {
    // 顶点
    private class Vertex{
        // 顶点名称
        String name;
        // 从该顶点出发的边
        Edge next;
        public Vertex(String name,Edge next){
            this.name = name;
            this.next = next;
        }
    }
    // 边
    private class Edge{
        // 被指向的顶点
        String name;
        // 弧的权值
        int weight;
        // 被指向的下一个边
        Edge next;

        public Edge(String name,int weight,Edge next){
            this.name = name;
            this.weight = weight;
            this.next = next;
        }
    }

    Map<String,Vertex> vertexMap;

    public AdjacencyList(){
        this.vertexMap = new HashMap<>();
    }
    // 添加节点
    public void insertVertex(String vertexName){
        Vertex vertex = new Vertex(vertexName,null);
        vertexMap.put(vertexName,vertex);
    }
    // 添加边
    public void insertEdge(String begin,String end,int weight){
       Vertex beginVertex = vertexMap.get(begin);
       if(beginVertex == null){
           beginVertex = new Vertex(begin,null);
           vertexMap.put(begin,beginVertex);
       }

       Edge edge = new Edge(end,weight,null);
       if(beginVertex.next == null){
           beginVertex.next = edge;
       }else {
           Edge lastEdge = beginVertex.next;
           while(lastEdge.next != null){
               lastEdge = lastEdge.next;
           }
           lastEdge.next = edge;
       }
    }

    // 打印图
    public void printGraph(){
        Set<Map.Entry<String,Vertex>> set = vertexMap.entrySet();
        Iterator<Map.Entry<String,Vertex>> it = set.iterator();
        while(it.hasNext()){
            Map.Entry<String,Vertex> entry = it.next();
            Vertex vertex = entry.getValue();
            Edge edge = vertex.next;
            while(edge != null){
                System.out.println(vertex.name +" 指向 "+edge.name+" 权值为："+edge.weight);
                edge = edge.next;
            }
        }

    }

}
