package boj.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class P_1197 {

    static class Edge implements Comparable<Edge>{
        int weight;
        int nodeNo;

        Edge(int w, int n){
            this.weight = w;
            this.nodeNo = n;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        /*
        * 아이디어
        * - 간선을 입접리스트 형태로 저장한다.
        * */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");
        int V = Integer.parseInt(nums[0]);
        int E = Integer.parseInt(nums[1]);

        List<List<Edge>> list = new ArrayList<>();

        for (int i = 0; i <= V; i++){
            list.add(i, new ArrayList<>());
        }

        for (int i = 0; i < E; i++){
            String[] abc = br.readLine().split(" ");
            int a = Integer.parseInt(abc[0]);
            int b = Integer.parseInt(abc[1]);
            int c = Integer.parseInt(abc[2]);
            List<Edge> aEdges = list.get(a);
            aEdges.add(new Edge(c, b));
            List<Edge> bEdges = list.get(b);
            bEdges.add(new Edge(c, a));
        }
        int rs = 0;
        boolean[] chk = new boolean[V+1];
        PriorityQueue<Edge> heap = new PriorityQueue<>();
        heap.add(new Edge(0, 1));

        while (!heap.isEmpty()){
            Edge edge = heap.poll();

            if(!chk[edge.nodeNo]){
                chk[edge.nodeNo] = true;
                rs += edge.weight;

                for (Edge nextEdge : list.get(edge.nodeNo)) {
                    if(!chk[nextEdge.nodeNo]){
                        heap.add(new Edge(nextEdge.weight, nextEdge.nodeNo));
                    }
                }
            }
        }

        System.out.println(rs);
    }

}
