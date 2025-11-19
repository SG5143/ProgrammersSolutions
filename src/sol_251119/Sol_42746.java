package sol_251119;/*
    https://school.programmers.co.kr/learn/courses/30/lessons/42746
    가장 큰 수
    0 또는 양의 정수가 주어졌을 때,
    정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.

    예를 들어, 주어진 정수가 [6, 10, 2]라면
    [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.

    0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때,
    순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.

    제한 사항
    numbers의 길이는 1 이상 100,000 이하입니다.
    numbers의 원소는 0 이상 1,000 이하입니다.
    정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
 */


import java.util.Arrays;

public class Sol_42746 {
    public String solution(int[] numbers) {
        String[] list = new String[numbers.length];

        for(int i=0; i<numbers.length; i++) {
            list[i] = String.valueOf(numbers[i]);
        }

        // 입력 숫자는 최대 1000이므로, 문자열로 변환 시 최대 3자리. 이를 3번 반복하여 비교
        // [3, 30, 34]
        // 문자열로 변환 후 3번 반복 > ["333", "303030", "343434"]
        // 사전순 내림차순 정렬 > ["343434", "333", "303030"]
        // 결과 > ["34", "3", "30"].
        Arrays.sort(list, (a, b) -> (b + b + b).compareTo(a + a + a));

        StringBuilder answer = new StringBuilder();
        for (String num : list) {
            answer.append(num);
        }

        return answer.charAt(0) == '0' ? "0" : answer.toString();
    }
}
