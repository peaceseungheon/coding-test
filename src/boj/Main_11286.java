package boj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main_11286 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b)-> {
            if(Math.abs(a) < Math.abs(b)){
                return -1;
            }else if (Math.abs(a) == Math.abs(b)){
                if(a < b){
                    return -1;
                }else if(a.equals(b)){
                    return 0;
                }else{
                    return 1;
                }
            }else{
                return 1;
            }
        });
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i<N; i++){
            int x = sc.nextInt();
            if(x == 0){
                if(queue.isEmpty()){
                    ans.add(0);
                }else{
                    ans.add(queue.poll());
                }
            }else{
                queue.add(x);
            }
        }
        for (Integer an : ans) {
            System.out.println(an);
        }
    }
}
