package boj.greedy;

import java.io.*;
import java.util.*;

public class P_2875 {

    public static void main(String[] args) throws IOException{
        // maleCount : 인턴십에 참가하는 남학생의 수, femaleCount : k - maleCount
        // 1 <= maleCount <= k 까지 반복문을 돌며 빠지는 남, 여학생 수를 구한다.
        // 빠진 N, M을 통해 만들 수 있는 팀의 수를 구한다.
        // 최대 값을 갱신한다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int max = Integer.MIN_VALUE;

        int maxMan = Math.min(M, K);

        for(int internMan = 0; internMan <= maxMan; internMan++){
            int internWoman = K - internMan;

            int tempWoman = N - internWoman;
            int tempMan = M - internMan;

            int teamCount = Math.min(tempWoman / 2, tempMan);
            max = Math.max(max, teamCount);
        }

        System.out.println(max);
    }



}
