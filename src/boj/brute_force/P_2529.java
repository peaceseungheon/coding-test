package boj.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class P_2529 {

    static int K;
    static int[] nums = new int[]{0,1,2,3,4,5,6,7,8,9};
    static String[] strs;
    static List<String> results = new ArrayList<>();

    public static void main(String[] args) throws IOException {


        /*
        * 입력: 첫줄에 부등호 문자의 갯수 정수 k가 주어짐, 다음 줄엔 부등호 기호가 하나의 공백을 두고 제시
        *
        * 로직:
        * 1. 0 ~ 9 까지 반복문을 돈다.
        * 2. i에 대해 i가 아니고 부등호를 만족하는 수에 대해 다시 재귀 함수를 호출한다.
        * 3. len이 k이면 배열에 담는다.
        * 4. 배열을 정렬한 후 첫번째와 마지막 요소를 출력한다.
        *
        * 출력: 부등호 관계를 만족하는 k+1 자리의 최대, 최소 정수를 첫째줄과 둘째 줄에 각각 출력
        *
        * */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        strs = br.readLine().split(" ");

        for (int n : nums) {
            recursive(n, List.of(n),0,  String.valueOf(n));
        }

        results.sort(Comparator.comparingLong(Long::parseLong));

        System.out.println(results.get(results.size()-1));
        System.out.println(results.get(0));
    }

    static void recursive(int n, List<Integer> used, int kIndex, String str){
        if(kIndex == K){
            results.add(str);
            return;
        }
        for(int num : nums){
            if(!used.contains(num) && compare(n, num, strs[kIndex])){
                List<Integer> addUsed = new ArrayList<>(used);
                addUsed.add(num);
                recursive(num, addUsed,kIndex+1, str + num);
            }
        }
    }

    static boolean compare(int a, int b, String c){
        if(c.equals("<")){
            return a < b;
        }else{
            return a > b;
        }
    }

}
