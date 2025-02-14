package softeer;
import java.io.*;
import java.util.*;

public class P_Hanyang_Popularity_Exceeding_Competition {

    public static void main(String[] args) throws IOException {
        // value: 절대값(유명인의 인기도 - 철민이의 인기도)
        // value가 유명인의 친화력 보다 작거나 같아야 철민이의 인기도가 1증가
        // value가 유명인의 친화력보다 크면 pass


        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];

        for(int i = 0; i < N; i++){
            String[] input = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(input[0]);
            arr[i][1] = Integer.parseInt(input[1]);
        }

        int X = 0;


        for(int i = 0; i < N; i++){
            int value = Math.abs(arr[i][0] - X);
            if(value > arr[i][1]){
                continue;
            }
            X++;
        }
        System.out.println(X);
    }
}
