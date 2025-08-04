/*
    https://school.programmers.co.kr/learn/courses/30/lessons/77884
    약수의 개수와 덧셈

    두 정수 left와 right가 매개변수로 주어집니다.
    left부터 right까지의 모든 수들 중에서, 약수의 개수가 짝수인 수는 더하고,
    약수의 개수가 홀수인 수는 뺀 수를 return 하도록 solution 함수를 완성해주세요.
 */

public class Sol_77884 {
    public int solution(int left, int right) {
        int answer = 0;

        for (int i = left; i <= right; i++) {
            if (Math.sqrt(i) == (int)Math.sqrt(i)) {
                answer -= i;
            } else {
                answer += i;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int left = 13;
        int right = 17;

        int result = new Sol_77884().solution(left, right);
        System.out.println(result);
    }
}
