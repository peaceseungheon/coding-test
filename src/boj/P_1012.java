package boj;

import java.util.*;
import java.io.*;

public class P_1012 {

    static int N;
    static int M;
    static int count;

    static int[] dx = new int[]{0,0,-1,1};
    static int[] dy = new int[]{-1,1,0,0};

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            int K = Integer.parseInt(st.nextToken());

            int[][] map = new int[N][M];

            for (int k = 0; k < K; k++){
                String[] nums = br.readLine().split(" ");
                int x = Integer.parseInt(nums[0]);
                int y = Integer.parseInt(nums[1]);

                map[y][x] = 1;
            }
            boolean[][] chk = new boolean[N][M];
            count = 0;
            Queue<Point> queue = new LinkedList<>();

            for (int j = 0; j < N; j++){
                for(int i = 0; i < M; i++){
                    if(map[j][i] == 1 && !chk[j][i]) {
                        chk[j][i] = true;
                        queue.add(new Point(i, j));
                        bfs(map, chk, queue);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    static void bfs(int[][] map, boolean[][] chk, Queue<Point> queue) {
        while(!queue.isEmpty()){
            Point point = queue.poll();

            for(int d = 0; d < 4; d++) {
                int x = point.x + dx[d];
                int y = point.y + dy[d];

                if (x < 0 || x >= M) continue;
                if (y < 0 || y >= N) continue;

                if (map[y][x] == 1 && !chk[y][x]){
                    chk[y][x] = true;
                    queue.add(new Point(x, y));
                }
            }
        }
    }
}
