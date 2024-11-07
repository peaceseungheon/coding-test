package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class P_25195 {

    static int N;
    static int M;
    static boolean neverMeet = false;

    public static void main(String[] args) throws IOException {
        /*아이디어
        * 1. 그래프를 순회한다. bfs로 순회
        * 2. 방문한 노드가 팬클럽 곰곰이가 숨어있는 노드이면 순회를 중단하고 yes를 출력
        * 3. 노드를 모두 순회하면 no를 출력
        * */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        List<List<Integer>> edges = new ArrayList<>();

        for(int i = 0; i < N+1; i++){
            edges.add(new ArrayList<>());
        }

        for(int i = 0; i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            edges.get(a).add(b);
        }

        int S = Integer.parseInt(br.readLine());
        int[] fan = new int[S];
        st = new StringTokenizer(br.readLine());
        for(int s = 0; s < S; s++){
            fan[s] = Integer.parseInt(st.nextToken());
        }

        int[] visited = new int[N+1];

        dfs(edges, fan, visited, 1, false);

        if(neverMeet){
            System.out.println("yes");
        }else{
            System.out.println("Yes");
        }
    }

    static void dfs(List<List<Integer>> edges, int[] fan, int[] visited, int node, boolean isMeet){
        if(isMatch(node, fan)){
            isMeet = true;
        }

        visited[node] = 1;

        List<Integer> nodes = edges.get(node);

        if(nodes.isEmpty()){
            if(!isMeet){ // 마지막 노드인데 한번도 팬을 만나지 않았다면
                neverMeet = true;
                return;
            }
        }

        for(int n : nodes){
            dfs(edges, fan, visited, n, isMeet);
        }
    }

    static boolean isMatch(int node, int[] fan){
        boolean isMatch = false;
        for(int f : fan){
            if(f == node){
                isMatch = true;
                break;
            }
        }
        return isMatch;
    }

}
