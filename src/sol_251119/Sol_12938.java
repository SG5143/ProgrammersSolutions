package sol_251119;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12938
 */

public class Sol_12938 {

    public int[] solution(int n, int s) {

        /* 최고의 집합이 존재하지 않음 */
        if(s < n) return new int[]{-1};

        int[] answer = new int[n];
        int quotient = s/n;
        int remainder = s%n;

        /* 나머지 수 만큼 뒤쪽 배열에 1을 더해서 저장 */
        for(int i=0; i<n-remainder; i++){
            answer[i] = quotient;
        }

        for(int i=n-remainder; i<n; i++){
            answer[i] = quotient+1;
        }

        return answer;
    }

}
