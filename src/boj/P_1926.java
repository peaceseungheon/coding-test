package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P_1926 {
    // 위, 아래, 오른, 왼
    static int[] dx = new int[]{0, 0, 1, -1};
    static int[] dy = new int[]{1, -1, 0, 0};

    static class Node {
        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        /**
         * 아이디어:
         * 1) 이중 for 문을 돌면서 1을 만나면 탐색을 시작하고 갯수를 1 증가시킨다.
         * 2) 상하좌우를 확인하며 1인지 확인한다.
         * 3) 1이면 queue에 node를 추가한다.
         * 4) node에 추가하면 방문2차원 배열에 표시한다.
         * 4) queue가 비면 탐색을 종료하고 다음 좌표로 넘어간다.
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Node> queue = new LinkedList<>();
        int[][] checked = new int[N][M];

        int count = 0;
        int maxArea = 0;

        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (checked[i][j] == 1){
                    continue;
                }
                int temp = 0;
                if (arr[i][j] == 1){
                    queue.add(new Node(j, i));
                    checked[i][j] = 1;
                    count++;
                }

                while(!queue.isEmpty()){
                    Node node = queue.poll();
                    search(arr, checked, queue, node);
                    temp++;
                }
                maxArea = Math.max(maxArea, temp);
            }
        }

        System.out.println(count);
        System.out.println(maxArea);
    }

    static void search(int[][] arr, int[][] checked, Queue<Node> queue, Node node){
        for (int i = 0; i < 4; i++){
            int x = node.x + dx[i];
            int y = node.y + dy[i];

            if (x < 0 || x >= arr[0].length){
                continue;
            }

            if (y < 0 || y >= arr.length){
                continue;
            }

            if (checked[y][x] == 1){
                continue;
            }

            int pos = arr[y][x];

            if (pos == 1){
                queue.add(new Node(x, y));
                checked[y][x] = 1;
            }
        }
    }
}
