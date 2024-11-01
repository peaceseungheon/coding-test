package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class P_2178 {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int N;
    static int M;

    static class Point{
        int x;
        int y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        N = Integer.parseInt(tokens[0]);
        M = Integer.parseInt(tokens[1]);

        int[][] map = new int[N][M];
        boolean[][] checked = new boolean[N][M];
        for (int j = 0; j < N; j++){
            String[] nums = br.readLine().split("");
            for (int i = 0; i < M; i++){
                map[j][i] = Integer.parseInt(nums[i]);
            }
        }
        bfs(map, checked);
        System.out.println(map[N-1][M-1]);
    }

    static void bfs(int[][] map, boolean[][] checked){
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0,0));
        checked[0][0] = true;

        while (!queue.isEmpty()){
            Point point = queue.poll();

            for (int k = 0; k < 4; k++){
                int x = point.x + dx[k];
                int y = point.y + dy[k];

                if (x < 0 || x >= M){
                    continue;
                }
                if(y < 0 || y >= N){
                    continue;
                }

                if(!checked[y][x] && map[y][x] == 1){
                    queue.add(new Point(x, y));
                    checked[y][x] = true;
                    map[y][x] = map[point.y][point.x] + 1;
                }
            }
        }
    }

}
