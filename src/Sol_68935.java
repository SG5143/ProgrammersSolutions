/*
    https://school.programmers.co.kr/learn/courses/30/lessons/68935
    3진법 뒤집기

    자연수 n이 매개변수로 주어집니다.
    n을 3진법 상에서 앞뒤로 뒤집은 후,
    이를 다시 10진법으로 표현한 수를 return 하도록 solution 함수를 완성해주세요.
 */

public class Sol_68935 {
    public int solution(int n) {
        String ternary = Integer.toString(n, 3);

        String reversed = new StringBuilder(ternary).reverse().toString();

        return Integer.parseInt(reversed, 3);
    }
}
