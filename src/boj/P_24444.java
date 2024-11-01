package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P_24444 {

    private static int count = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = br.readLine().split(" ");
        int N = Integer.parseInt(tokens[0]);
        int M = Integer.parseInt(tokens[1]);
        int startNode = Integer.parseInt(tokens[2]);

        List<List<Integer>> edges = new ArrayList<>();

        for(int i = 0; i <= N; i++){
            edges.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            String[] nodes = br.readLine().split(" ");
            int node1 = Integer.parseInt(nodes[0]);
            int node2 = Integer.parseInt(nodes[1]);

            edges.get(node1).add(node2);
            edges.get(node2).add(node1);
        }
        int[] visited = new int[N+1];
        int[] orders = new int[N+1];
        bfs(edges, visited, startNode, orders);

        for (int i = 1; i < orders.length; i++){
            System.out.println(orders[i]);
        }
    }

    static void bfs(List<List<Integer>> edges, int[] visited, int node, int[] orders){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = 1;
        orders[node] = count;
        count++;

        while(!queue.isEmpty()){
            Integer temp = queue.poll();
            List<Integer> nodes = edges.get(temp);
            Collections.sort(nodes);
            for(int n: nodes){
                if(visited[n] == 0){
                    queue.add(n);
                    visited[n] = 1;
                    orders[n] = count;
                    count++;
                }
            }
        }
    }

}
