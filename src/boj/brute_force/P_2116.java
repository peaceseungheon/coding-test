package boj.brute_force;

import java.io.*;
import java.util.*;

public class P_2116 {

        /*5
        2 3 1 6 5 4
        3 1 2 4 6 5
        5 6 4 1 3 2
        1 3 6 2 4 5
        4 1 6 5 2 3*/

    public static void main(String[] args) throws IOException {
        // 0 - 5
        // 1 - 3
        // 2 - 4

        // 1. 첫번째 주사위의 면을 반복문을 돌며 윗면을 지정한다.
        // 2. 1 ~ n-1까지 반복문을 돌며 i - 1의 면과 일치하는 것을 찾는다.
        // 3. 일치하는 면과 그 반대면을 제외한 나머지 면의 값중 최대 값을 찾고 sum에 더해준다.
        // 4. sum을 반환한다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] dices = new int[N][6];

        for(int i = 0; i < N; i++){
            String[] tokens = br.readLine().split(" ");
            for(int j = 0; j < tokens.length; j++){
                dices[i][j] = Integer.parseInt(tokens[j]);
            }
        }

        int answer = Integer.MIN_VALUE;
        for(int i = 0; i < dices[0].length; i++){
            int top = dices[0][i];
            int bottomIndex = findOppose(i);

            int sum = findMax(i, bottomIndex, dices[0]);
            answer = Math.max(answer, append(top, dices, 1, sum));
        }

        System.out.println(answer);
    }

    static int append(int beforeTop, int[][] dices, int now, int sum){
        if(now == dices.length){
            return sum;
        }
        int bottomIndex = -1;
        for(int i = 0; i < dices[now].length; i++){
            if(dices[now][i] == beforeTop){
                bottomIndex = i;
                break;
            }
        }
        int topIndex = findOppose(bottomIndex);
        int max = findMax(topIndex, bottomIndex, dices[now]);
        sum += max;
        return append(dices[now][topIndex], dices, now+1, sum);
    }

    static int findMax(int topIndex, int bottomIndex, int[] dice){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dice.length; i++) {
            if(i != topIndex && i != bottomIndex){
                max = Math.max(max, dice[i]);
            }
        }
        return max;
    }

    static int findOppose(int index){
        switch (index){
            case 0:
                return 5;
            case 1:
                return 3;
            case 2:
                return 4;
            case 3:
                return 1;
            case 4:
                return 2;
            case 5:
                return 0;
            default:
                return -1;
        }
    }

}
