package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P_2644 {

    static int N;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[][] edges = new int[N+1][N+1];

        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            edges[x][y] = 1;
            edges[y][x] = 1;
        }

        visited = new boolean[N+1];
        int[][] maps = new int[N+1][N+1];
        // 노드들을 순회하며 노드에서 다른 노드까지의 거리를 계산
        dfs(maps, edges, a, a, 0);
        System.out.println(maps[a][b] == 0 ? -1 : maps[a][b]);
    }

    static void dfs(int[][] maps, int[][] edges,int start, int node, int count){
        visited[node] = true;
        count++;

        for(int i = 1; i < edges[node].length; i++){
            if(!visited[i] && edges[node][i]==1){
                maps[start][i] = count;
                dfs(maps, edges, start, i, count);
            }
        }
    }

}
