/*
    https://school.programmers.co.kr/learn/courses/30/lessons/12930
    이상한 문자 만들기
    문자열 s는 한 개 이상의 단어로 구성되어 있습니다.
    각 단어는 하나 이상의 공백문자로 구분되어 있습니다. 각 단어의 짝수번째 알파벳은 대문자로,
    홀수번째 알파벳은 소문자로 바꾼 문자열을 리턴하는 함수, solution을 완성하세요.

    제한 사항
    문자열 전체의 짝/홀수 인덱스가 아니라, 단어(공백을 기준)별로 짝/홀수 인덱스를 판단해야합니다.
    첫 번째 글자는 0번째 인덱스로 보아 짝수번째 알파벳으로 처리해야 합니다.
    입출력 예
    s	return
    "try hello world"	"TrY HeLlO WoRlD"
    입출력 예 설명
    "try hello world"는 세 단어 "try", "hello", "world"로 구성되어 있습니다.
    각 단어의 짝수번째 문자를 대문자로, 홀수번째 문자를 소문자로 바꾸면 "TrY", "HeLlO", "WoRlD"입니다. 따라서 "TrY HeLlO WoRlD" 를 리턴합니다.
 */

public class Sol_12930 {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        int index = 0;  // 단어 내에서의 인덱스

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == ' ') {
                answer.append(c);
                index = 0;  // 공백이 나오면 단어 인덱스 초기화
            } else {
                if (index % 2 == 0)
                    answer.append(Character.toUpperCase(c));
                else
                    answer.append(Character.toLowerCase(c));
                index++;
            }
        }

        return answer.toString();
    }
}
