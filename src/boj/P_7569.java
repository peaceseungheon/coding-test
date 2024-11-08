package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P_7569 {

    static int N;
    static int M;
    static int H;

    // 위 아래 왼쪽 오른쪽 앞 뒤
    static int[] dx = new int[]{0, 0, -1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, 0, 0, 1, -1};
    static int[] dz = new int[]{-1, 1, 0, 0, 0, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        int[][][] arr = new int[H][N][M];

        for(int h = 0; h < H; h++){
            for(int n = 0; n < N; n++){
                st = new StringTokenizer(br.readLine());
                for(int m = 0; m < M; m++){
                    arr[h][n][m] = Integer.parseInt(st.nextToken());
                }
            }
        }

        int[][][] visited = new int[H][N][M];

        for(int h = 0; h < H; h++){
            for(int n = 0; n < N; n++){
                for(int m = 0; m < M; m++){
                    if(arr[h][n][m] == 1){
                        bfs(arr, visited, h, n, m);
                    }
                }
            }
        }
    }

    static void bfs(int[][][] store, int[][][] visited, int h, int n, int m){
        Point start = new Point(h, n, m);
        Queue<Point> queue = new LinkedList<>();

        queue.add(start);
        visited[h][n][m] = 1;
        while (!queue.isEmpty()){
            Point point = queue.poll();

            if(store[point.z][point.y][point.x] != 1){
                continue;
            }

            for(int d = 0; d < 6; d++){
                int dh = point.z + dz[d];
                int dn = point.y + dy[d];
                int dm = point.x + dx[d];

                if(dh < 0 || dh >= H){
                    continue;
                }
                if(dn < 0 || dn >= N){
                    continue;
                }
                if(dm < 0 || dm >= M){
                    continue;
                }

                if(store[dh][dn][dm] == 0){
                    store[dh][dn][dm] = 1;
                    Point neighbor = new Point(dh, dn, dm);
                    queue.add(neighbor);
                    visited[dh][dn][dm] = 1;
                }
            }
        }
    }

    static class Point{
        int z;
        int y;
        int x;

        Point(int z, int y, int x){
            this.z = z;
            this.y = y;
            this.x = x;
        }

        @Override
        public boolean equals(Object o){
            Point p = (Point) o;
            return this.z == p.z && this.y == p.y && this.x == p.x;
        }
    }
}
