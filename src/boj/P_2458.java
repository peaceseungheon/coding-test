package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class P_2458 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] edges = new int[N+1][N+1];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edges[a][b] = 1;
        }

        int[][] maps = new int[N+1][N+1];

        for(int i = 0; i < maps.length; i++){
            Arrays.fill(maps[i], Integer.MAX_VALUE);
        }

        for(int i = 1; i < N+1; i++){
            Stack<Integer> stack = new Stack<>();
            int[] visited = new int[N+1];
            stack.add(i);
            visited[i] = 1;

            while (!stack.isEmpty()){
                Integer node = stack.pop();
                for(int n = 1; n < edges[node].length; n++){
                    if(visited[n]==0 && edges[node][n] == 1){
                        maps[i][n] = 1;
                        stack.add(n);
                        visited[n] = 1;
                    }
                }
            }
        }
        int ans = 0;
        for(int j = 1; j < maps.length; j++){
            int count = 0;
            for(int i = 1; i < maps[j].length; i++){
                if(j == i) continue;
                // i에서 j까지 갈 수 있거나 j에서 i까지 갈 수 있는 경우
                if(maps[i][j] == 1 || maps[j][i] == 1){
                    count++;
                }
            }
            if(count == N-1){
                ans++;
            }
        }
        System.out.println(ans);
    }

}
