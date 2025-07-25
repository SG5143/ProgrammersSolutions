/*
    https://school.programmers.co.kr/learn/courses/30/lessons/142086
    가장 가까운 같은 글자

    문자열 s가 주어졌을 때, s의 각 위치마다 자신보다 앞에 나왔으면서, 자신과 가장 가까운 곳에 있는 같은 글자가 어디 있는지 알고 싶습니다.
    예를 들어, s="banana"라고 할 때,  각 글자들을 왼쪽부터 오른쪽으로 읽어 나가면서 다음과 같이 진행할 수 있습니다.

    b는 처음 나왔기 때문에 자신의 앞에 같은 글자가 없습니다. 이는 -1로 표현합니다.
    a는 처음 나왔기 때문에 자신의 앞에 같은 글자가 없습니다. 이는 -1로 표현합니다.
    n은 처음 나왔기 때문에 자신의 앞에 같은 글자가 없습니다. 이는 -1로 표현합니다.
    a는 자신보다 두 칸 앞에 a가 있습니다. 이는 2로 표현합니다.
    n도 자신보다 두 칸 앞에 n이 있습니다. 이는 2로 표현합니다.
    a는 자신보다 두 칸, 네 칸 앞에 a가 있습니다. 이 중 가까운 것은 두 칸 앞이고, 이는 2로 표현합니다.
    따라서 최종 결과물은 [-1, -1, -1, 2, 2, 2]가 됩니다.

    문자열 s이 주어질 때, 위와 같이 정의된 연산을 수행하는 함수 solution을 완성해주세요.
 */

import java.util.Arrays;
import java.util.HashMap;

public class Sol_142086 {

    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        HashMap<Character, Integer> lastIndexMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (lastIndexMap.containsKey(ch)) {
                answer[i] = i - lastIndexMap.get(ch);
            } else {
                answer[i] = -1;
            }
            lastIndexMap.put(ch, i);
        }

        return answer;
    }

    public static void main(String[] args) {
        String s = "banana";
        int[] result = new Sol_142086().solution(s);
        System.out.println(Arrays.toString(result));
    }
}
