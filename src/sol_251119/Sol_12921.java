package sol_251119;/*
    https://school.programmers.co.kr/learn/courses/30/lessons/12921
    소수 찾기
    1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수, solution을 만들어 보세요.

    소수는 1과 자기 자신으로만 나누어지는 수를 의미합니다.
    (1은 소수가 아닙니다.)

    제한 조건
    n은 2이상 1000000이하의 자연수입니다.
 */

public class Sol_12921 {
    public int solution(int n) {
        boolean[] isNotPrime = new boolean[n + 1];
        isNotPrime[0] = isNotPrime[1] = true;

        for (int i = 2; i * i <= n; i++) {
            if (!isNotPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }

        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (!isNotPrime[i]) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        int n = 10;

        int result = new Sol_12921().solution(n);
        System.out.println(result);
    }
}
