package com.td.常见算法.图;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 深度和广度优先搜索
 */
public class Graph {

    private int v;
    private LinkedList<Integer> adj[]; // 邻接表

    /**
     * 无向图
     *
     * @param v 节点个数
     */
    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    /**
     * 添加边
     *
     * @param s 顶点
     * @param t 顶点
     */
    public void addEdge(int s, int t) { // 无向图一条边存两次
        adj[s].add(t);
        adj[t].add(s);
    }

    public static void main(String[] args) {
        // 初始化图
        Graph graph = new Graph(8);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 7);

        graph.bfs(0, 6); // 广度优先
        //graph.dfs(0, 6); // 深度优先
    }

    /**
     * 广度优先搜索
     *
     * @param s 起始点
     * @param t 终结点
     */
    public void bfs(int s, int t) {
        if (s == t) return;
        boolean[] visited = new boolean[v]; // visited 是用来记录已经被访问的顶点，用来避免顶点被重复访问
        visited[s] = true;
        Queue<Integer> queue = new LinkedList<>(); // queue 是一个队列，用来存储已经被访问、但相连的顶点还没有被访问的顶点
        queue.add(s);
        int[] prev = new int[v]; // prev 反向存储的搜索路径，eg：我们通过顶点 2 的邻接表访问到顶点 3，那 prev[3] 就等于 2
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }
        while (queue.size() != 0) {
            int w = queue.poll(); // 出队
            for (int i = 0; i < adj[w].size(); ++i) {
                int q = adj[w].get(i);
                if (!visited[q]) {
                    prev[q] = w;
                    if (q == t) {
                        print(prev, s, t);
                        return;
                    }
                    visited[q] = true;
                    queue.add(q); // 入队
                }
            }
        }
    }

    /**
     * 递归打印 s->t 的路径
     *
     * @param prev 反向存储的搜索路径
     * @param s 起始点
     * @param t 终结点
     */
    private void print(int[] prev, int s, int t) {
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + " ");
    }

    boolean found = false; // 全局变量或者类成员变量，是否找到终止点

    /**
     * 深度优先搜索
     *
     * @param s 起始点
     * @param t 终结点
     */
    public void dfs(int s, int t) {
        found = false;
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }
        recurDfs(s, t, visited, prev);
        print(prev, s, t);
    }

    /**
     * 深度优先搜索，递归
     *
     * @param w 节点
     * @param t 节点
     * @param visited 用来记录已经被访问的顶点，用来避免顶点被重复访问
     * @param prev 反向存储的搜索路径
     */
    private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
        if (found == true) return;
        visited[w] = true;
        if (w == t) {
            found = true;
            return;
        }
        for (int i = 0; i < adj[w].size(); ++i) {
            int q = adj[w].get(i);
            if (!visited[q]) {
                prev[q] = w;
                recurDfs(q, t, visited, prev);
            }
        }
    }
}
