package programmers;

import java.util.Arrays;

public class Main_Park {

    public static void main(String[] args) {
        String[] park = new String[]{"SOO","OXX","OOO"};
        String[] routes = new String[]{"E 2","S 2","W 1"};
        int[] result = solution(park, routes);
        System.out.println(Arrays.toString(result));
    }

    public static int maxX;
    public static int maxY;
    public static int[][] points;

    public static int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];

        points = new int[park.length][park[0].length()];

        maxX = park.length; // 최대 세로
        maxY = park[0].length() - 1; // 최대 가로

        int x = 0;
        int y = 0;

        // start : 0, 장애물: -1, 길: 1

        for (int i = 0; i < park.length; i++) {
            char[] chars = park[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                char c = chars[j];
                if (c == 'S') {
                    x = i;
                    y = j;
                } else if (c == 'X') {
                    points[i][j] = -1;
                } else {
                }
            }
        }

        for (String r : routes) {
            String[] tokens = r.split(" ");
            String direction = tokens[0];
            int distance = Integer.parseInt(tokens[1]);

            boolean isPath;
            switch (direction){
                case "E":
                    isPath = checkEast(x, y, distance);
                    if(!isPath) continue;
                    y += distance;
                    break;
                case "W":
                    isPath = checkWest(x, y, distance);
                    if(!isPath) continue;
                    y -= distance;
                    break;
                case "S":
                    isPath = checkSouth(x, y, distance);
                    if(!isPath) continue;
                    x += distance;
                    break;
                case "N":
                    isPath = checkNorth(x, y, distance);
                    if(!isPath) continue;
                    x -= distance;
                    break;
                default:
                    break;
            }
        }
        answer[0] = x;
        answer[1] = y;

        return answer;
    }

    public static boolean checkEast(int x, int y, int distance){
        if(y + distance > maxY){
            return false;
        }

        boolean can = true;
        for(int i = 1; i <= distance; i++){
            if(points[x][y+i] == -1){
                can = false;
                break;
            }
        }
        return can;
    }

    public static boolean checkWest(int x, int y, int distance){
        if(y - distance < 0){
            return false;
        }

        boolean can = true;
        for(int i = 1; i <= distance; i++){
            if(points[x][y-i] == -1){
                can = false;
                break;
            }
        }
        return can;
    }

    public static boolean checkSouth(int x, int y, int distance){
        if(x + distance > maxY){
            return false;
        }

        boolean can = true;
        for(int i = 1; i <= distance; i++){
            if(points[x+i][y] == -1){
                can = false;
                break;
            }
        }
        return can;
    }

    public static boolean checkNorth(int x, int y, int distance){
        if(x - distance < 0){
            return false;
        }

        boolean can = true;
        for(int i = 1; i <= distance; i++){
            if(points[x-i][y] == -1){
                can = false;
                break;
            }
        }
        return can;
    }
}
