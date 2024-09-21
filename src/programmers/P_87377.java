package programmers;

import java.util.*;

public class P_87377 {

    public String[] solution(int[][] lines) {
        int N = lines.length;
        List<Point> points = new ArrayList<>();

        // 교점을 구한다. 다만 교점은 정수 값이어야 한다.
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                Point point = calculate(lines[i], lines[j]);
                if (point != null) {
                    points.add(point);
                }
            }
        }

        // 교점들 중 x의 최소 최대, y의 최소 최대를 구한다
        long minX = Long.MAX_VALUE;
        long maxX = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE;
        long maxY = Long.MIN_VALUE;

        for (Point point : points) {
            minX = Math.min(minX, point.x);
            maxX = Math.max(maxX, point.x);
            minY = Math.min(minY, point.y);
            maxY = Math.max(maxY, point.y);
        }

        int weight = (int) (maxX - minX + 1);
        int height = (int) (maxY - minY + 1);

        char[][] matrix = new char[height][weight];
        for (char[] row: matrix){
            Arrays.fill(row, '.');
        }

        for (Point point : points){
            int x = (int) (point.x - minX);
            int y = (int) (maxY - point.y);

            matrix[y][x] = '*';
        }

        String[] answer = new String[matrix.length];

        for (int i = 0; i < answer.length; i++){
            answer[i] = new String(matrix[i]);
        }

        return answer;
    }

    Point calculate(int[] a, int[] b) {
        int A = a[0];
        int B = a[1];
        int E = a[2];

        int C = b[0];
        int D = b[1];
        int F = b[2];

        double x = (double) (B * F - E * D) / (A * D - B * C);
        double y = (double) (E * C - A * F) / (A * D - B * C);

        if (isInteger(x) && isInteger(y)) {
            return new Point((long) x, (long) y);
        } else {
            return null;
        }
    }

    boolean isInteger(Double num) {
        return num % 1 == 0;
    }

    class Point {

        long x;
        long y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
}


