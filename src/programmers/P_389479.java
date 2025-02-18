package programmers;

import java.util.*;
public class P_389479 {

    class Solution {

        public int solution(int[] players, int m, int k) {
            // 사용자가 m명 늘어날 때마다 서버 1대가 추가로 필요.
            // 특정 시간대의 이용자가 m명 미만이라면 서버 증설 X
            // 이용자가 n x m 명 이상 (n+1) x m 명 미만이라면 최소 n대의 증설된 서버가 운영 중이어야 함.
            // 한번 증설한 서버는 K시간 동안 운영, 그 이후엔 반납

            // 출력: 하루동안 서버를 최소 몇 번 증성해야 하는지 횟수를

            // 로직
            // players 반복문을 돌며 아래 작업 수행
            // 1. 이용자 수가 m명 이상인지 확인
            // 1-1. 증설된 서버의 수가 n / m보다 큰지 확인
            // 1-1-1. 크거나 같다면 작업 없음.
            // 1-1-2. 작다면 서버 증설, 증설 횟수 1 증가
            // 2. 증설된 서버 중 K시간이 지났는지 확인하여 지난 서버는 반납

            List<Server> servers = new ArrayList<>();
            int count = 0;

            for (int i = 0; i < players.length; i++) {
                checkExpired(servers, k, i);
                int n = players[i];
                if (n < m)
                    continue;
                int min = n / m;
                if (servers.size() < min) {
                    count += addServer(servers, min, i);
                }
            }
            return count;
        }

        int addServer(List<Server> servers, int min, int time) {
            int plus = min - servers.size();
            for (int m = 0; m < plus; m++) {
                servers.add(new Server(time));
            }
            return plus;
        }

        void checkExpired(List<Server> servers, int k, int now) {
            List<Server> expired = new ArrayList<>();
            for (Server server : servers) {
                int temp = server.createTime + k;
                if (now >= temp) {
                    expired.add(server);
                }
            }
            servers.removeAll(expired);
        }

        class Server {

            int createTime;

            Server(int createTime) {
                this.createTime = createTime;
            }
        }
    }
}
