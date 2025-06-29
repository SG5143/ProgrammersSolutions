/*
    https://school.programmers.co.kr/learn/courses/30/lessons/86051
    없는 숫자 더하기
    0부터 9까지의 숫자 중 일부가 들어있는 정수 배열 numbers가 매개변수로 주어집니다.
    numbers에서 찾을 수 없는 0부터 9까지의 숫자를 모두 찾아 더한 수를 return 하도록 solution 함수를 완성해주세요.
 */

public class Sol_86051 {
    public int solution(int[] numbers) {
        boolean[] num = new boolean[10];

        for (int number : numbers) {
            num[number] = true;
        }

        int sum = 0;
        for(int i = 0; i < 10; i++) {
            if(!num[i]) {
                sum += i;
            }
        }

        return sum;
    }
}
