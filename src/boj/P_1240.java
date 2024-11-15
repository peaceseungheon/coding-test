package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_1240 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] edges = new int[N+1][N+1];

        for(int i = 0; i < N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            edges[a][b] = d;
            edges[b][a] = d;
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            boolean[] visited = new boolean[N+1];
            visited[start] = true;
            dfs(visited, edges, end, start, 0);
        }
    }

    static void dfs(boolean[] visited, int[][] edges, int target, int node, int distance){
        if(target == node){
            System.out.println(distance);
            return;
        }
        for(int i = 1; i < edges[node].length; i++){
            if(!visited[i] && edges[node][i] != 0){
                visited[i] = true;
                dfs(visited, edges, target, i, distance + edges[node][i]);
            }
        }
    }

}
