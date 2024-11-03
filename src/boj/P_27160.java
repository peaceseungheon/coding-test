package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P_27160 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> maps = new HashMap<>();
        maps.put("BANANA", 0);
        maps.put("STRAWBERRY", 0);
        maps.put("LIME", 0);
        maps.put("PLUM", 0);

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String S = st.nextToken();
            int X = Integer.parseInt(st.nextToken());
            Integer preX = maps.get(S);
            maps.put(S, preX + X);
        }

        if(maps.containsValue(5)){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }

}
