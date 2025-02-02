import java.util.Arrays;
import programmers.P_87377;

public class Main {

    static int n;
    static int m;

    public static void main(String[] args) {
        // 두 정수 n,m이 주어졌을 때 n의 m을 구하라

        // 재귀 함수를 통해 n * n * ...을 진행.
        // 재귀 함수의 호출은 횟수가 m이 되었을 때 종료
        n = 2;
        m = 5;
        System.out.println(power(1, 1));
        int[][] arr = {{1}};

        
    }

    static int power(int result, int count){
        if(count > m){
            return result;
        }
        return power(result * n, count+1);
    }
}
