package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P_11561 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++){
            long N = Long.parseLong(br.readLine());
            long start = 1;
            long end = (long) Math.sqrt(2 * N);

            long max_count = 1;
            while (start <= end){
                long mid = (start + end) / 2;
                long sum = sum(mid);
                if(sum <= N){
                    max_count = mid;
                    start =  mid + 1;
                }else{
                    end = mid - 1;
                }
            }
            bw.write(String.format("%d\n", max_count));
        }
        bw.flush();
    }

    static long sum(long jump){
        return (jump * (jump + 1)) / 2;
    }

}
