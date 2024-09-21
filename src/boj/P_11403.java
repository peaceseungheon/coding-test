package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class P_11403 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] matrix = new int[N][N];
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 1; i <= matrix.length; i++) {
            map.put(i, new ArrayList<>());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int count = 1;
            while (st.hasMoreTokens()) {
                int linked = Integer.parseInt(st.nextToken());
                if(linked == 1) map.get(i).add(count);
                count++;
            }
        }
        int[][] result = new int[N][N];

        boolean[] checked = new boolean[N];
        Stack<Integer> stack = new Stack<>();
        stack.add(1);

        while (!stack.isEmpty()){
            // 1. stack에 연결된 노드들을 추가한다.
            int temp = stack.pop();
            if (checked[temp]){
                continue;
            }
            checked[temp] = true;


            // 2. 하나씩 꺼내서 방문하지 않은 노드의 하위노드를 추가한다.
            stack.addAll(map.get(temp));

            // 3. stack이 빌 때까지 반복한다.
        }

        System.out.println(Arrays.toString(result));
    }

    static boolean check(Map<Integer, List<Integer>> map, List<Integer> nodes, int j, boolean[] checked){
        if(nodes.isEmpty()){
            return false;
        }

        boolean isMatch = nodes.stream().anyMatch(it -> it == j);

        if (isMatch){
            return true;
        }

        boolean result = false;

        for (Integer node : nodes) {
            checked[node] = true;
            result = check(map, map.get(node), j, checked);
            if (result) break;
        }

        return result;
    }




}
