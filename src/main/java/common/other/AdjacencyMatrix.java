package common.other;

import java.util.ArrayList;
import java.util.List;

/**
  * @program: p40-algorithm
  * @description: 邻接矩阵
  * @author luoyuntian
  * @date 2022-03-03 06:58:16
  */
public class AdjacencyMatrix {
    // 存储点的链表
    private List vertexList;
    // 邻接矩阵，用来存储边
    private int[][] edges;
    // 边的数目
    private int numOfEdges;
    public AdjacencyMatrix(int n){
        // 初始化矩阵，一维数组，和边的数目
        edges = new int[n][n];
        vertexList = new ArrayList(n);
        numOfEdges = 0;
    }
    // 获取边的个数
    public int getNumOfEdges() {
        return numOfEdges;
    }
    // 获取节点的个数
    public int getNumOfVertex(){
        return vertexList.size();
    }
    // 返回节点i的数据
    public Object getValueByIndex(int i){
        return vertexList.get(i);
    }
    // 返回v1，v2的权值
    public int getWeight(int v1,int v2){
        return edges[v1][v2];
    }
    // 插入节点
    public void insertVertex(Object vertex){
        vertexList.add(vertex);
    }
    // 插入边
    public void insertEdge(int v1,int v2,int weight){
        edges[v1][v2] = weight;
        numOfEdges++;
    }
}
