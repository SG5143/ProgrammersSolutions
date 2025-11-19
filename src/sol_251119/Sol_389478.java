package sol_251119;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/389478
 */

public class Sol_389478 {
    public int solution(int n, int w, int num) {
        int answer = 0;

        int row = ((num - 1) / w) + 1; // 현재 상자의 층
        int col = row % 2 == 0 ? (w - 1) - (num - 1) % w : (num - 1) % w; // 현재 상자의 열

        int evenLineMove = col * 2 + 1;
        int oddLineMove = w * 2 - evenLineMove;

        while(num<=n){
            num += row % 2 == 1 ? oddLineMove: evenLineMove;
            row++;
            answer++;
        }

        return answer;
    }
}
