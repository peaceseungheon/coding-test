import java.util.Arrays;
import programmers.P_87377;

public class Main {

    public static void main(String[] args) {
        P_87377 p = new P_87377();
        //String[] ans = p.solution(new int[][]{{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}});
        // p.solution([[2, -1, 4], [-2, -1, 4], [0, -1, 1], [5, -8, -12], [5, 8, 12]])

        String[] ans = p.solution(new int[][]{{-2, -1, 4}, {2, -1, 4}});

        System.out.println(Arrays.toString(ans));
    }
}
