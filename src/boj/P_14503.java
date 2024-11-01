package boj;

import java.util.*;
import java.io.*;

public class P_14503 {

    static int N;
    static int M;

    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{-1, 1, 0, 0};

    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        void go(int direction){
            switch (direction){
                case 0:
                    y--;
                    break;
                case 1:
                    x++;
                    break;
                case 2:
                    y++;
                    break;
                case 3:
                    x--;
                    break;
            }
        }
        void back(int direction){
            switch (direction){
                case 0:
                    y++;
                    break;
                case 1:
                    x--;
                    break;
                case 2:
                    y--;
                    break;
                case 3:
                    x++;
                    break;
            }
        }

        @Override
        public String toString(){
            return String.format("(%d, %d)", y, x);
        }
    }

    public static void main(String[] args) throws IOException {

        /*
        * 변수
        * 지도 int[][]
        * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");
        N = Integer.parseInt(nums[0]);
        M = Integer.parseInt(nums[1]);

        nums = br.readLine().split(" ");
        Point now = new Point(Integer.parseInt(nums[1]), Integer.parseInt(nums[0]));
        int direction = Integer.parseInt(nums[2]);

        int[][] map = new int[N][M];

        for (int j = 0; j < N; j++){
            String[] tokens = br.readLine().split(" ");
            for (int i = 0; i < M; i++){
                map[j][i] = Integer.parseInt(tokens[i]);
            }
        }
        int count = 0;
        while(true){
            if (map[now.y][now.x] == 0){
                map[now.y][now.x] = 2;
                count++;
            }
            if(allClean(map, now)){
                now.back(direction);
                if(map[now.y][now.x] == 1){
                    break;
                }
            }else{
                direction = spin(direction);
                if(isForwardNotClean(map, now, direction)){
                    now.go(direction);
                }
            }
        }
        System.out.println(count);
    }

    static boolean allClean(int[][] map, Point point){
        boolean clean = true;
        for(int i = 0; i < 4; i++){
            int x = point.x + dx[i];
            int y = point.y + dy[i];

            if(map[y][x] == 0){
                clean = false;
                break;
            }
        }
        return clean;
    }

    static int spin (int direction){
        if (direction == 0){
            return 3;
        } else if (direction == 1) {
            return 0;
        } else if (direction == 2) {
            return 1;
        }else{
            return 2;
        }
    }

    static boolean isForwardNotClean(int[][] map, Point point, int direction){
        int x = point.x;
        int y = point.y;
        if(direction == 0){
            y--;
        } else if (direction == 1) {
            x++;
        }else if (direction == 2){
            y++;
        }else{
            x--;
        }
        return map[y][x] == 0;
    }
}
