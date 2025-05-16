/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/389479
 */

public class Sol_389479 {
    public int solution(int[] players, int m, int k) {
        print(players);

        int[] expire  = new int[24]; // 종료 서버
        int curServer = 0; // 현재 작동하는 서버
        int count = 0; // 총 몇번 서버가 오픈되었는지 카운트

        for(int i=0; i<24; i++){
            curServer -= expire[i];

            int needServer = players[i] / m;

            if (needServer > curServer) {
                int add = needServer - curServer;
                count += add;
                curServer += add;

                // k시간 뒤에 반납 예정
                if (i + k < expire.length) {
                    expire[i + k] += add;
                }
                System.out.printf("%d시~%d시에 %d개 서버 오픈!\n", i, i+1, add);
            }
        }

        return count;
    }

    private void print(int[] players){
        for(int i=0; i<24; i++){
            System.out.printf("%d시~%d시 %d명\n", i, i+1, players[i]);
        }
    }
}
