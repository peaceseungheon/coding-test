package boj;
import java.util.*;
import java.io.*;

public class P_15649 {

    static int N;
    static int M;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");
        N = Integer.parseInt(nums[0]);
        M = Integer.parseInt(nums[1]);
        boolean[] chk = new boolean[N+1];
        List<Integer> res = new ArrayList<>();
        backTracking(res, chk, 0);
    }

    static void backTracking(List<Integer> res, boolean[] chk, int count) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        if (count == M){
            for (Integer it : res) {
                bw.append(String.valueOf(it)).append(" ");
            }
            bw.append("\n");
            bw.flush();
            return;
        }

        for (int i = 1; i <= N; i++){
            if(chk[i]) continue;
            chk[i] = true;
            res.add(i);
            backTracking(res, chk, count+1);
            chk[i] = false;
            int index = res.lastIndexOf(i);
            res.remove(index);
        }
    }

}
