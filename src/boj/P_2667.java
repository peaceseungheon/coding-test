package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P_2667 {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        boolean[][] checked = new boolean[N][N];

        for (int j = 0; j < N; j++){
            String row = br.readLine();
            String[] tokens = row.split("");
            for(int i = 0; i < tokens.length; i++){
                map[j][i] = Integer.parseInt(tokens[i]);
            }
        }

        int count = 0;
        List<Integer> sizes = new ArrayList<>();

        for (int j = 0; j < N; j++) {
            for (int i = 0; i < N; i++) {
                if (checked[j][i]){
                    continue;
                }

                if (map[j][i] == 1){
                    checked[j][i] = true;
                    count++;
                    sizes.add(dfs(map, j, i, checked));
                }
            }
        }
        System.out.println(count);
        Collections.sort(sizes);
        sizes.forEach(size-> {
            System.out.println(size);
        });
    }

    static int dfs(int[][] map, int j, int i, boolean[][] checked){
        int size = 1;

        if (map[j][i] == 0){
            return size;
        }

        for (int k = 0; k < 4; k++){
            int x = i + dx[k];
            int y = j + dy[k];

            if (x < 0 || x >= map.length){
                continue;
            }

            if(y < 0 || y >= map.length){
                continue;
            }
            if(checked[y][x]){
                continue;
            }
            if (map[y][x] == 1){
                checked[y][x] = true;
                size += dfs(map, y, x, checked);
            }
        }
        return size;
    }

}
