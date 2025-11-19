package sol_251119;/*
    https://school.programmers.co.kr/learn/courses/30/lessons/76502
    괄호 회전하기

    다음 규칙을 지키는 문자열을 올바른 괄호 문자열이라고 정의합니다.

    (), [], {} 는 모두 올바른 괄호 문자열입니다.
    만약 A가 올바른 괄호 문자열이라면, (A), [A], {A} 도 올바른 괄호 문자열입니다.
    예를 들어, [] 가 올바른 괄호 문자열이므로, ([]) 도 올바른 괄호 문자열입니다.
    만약 A, B가 올바른 괄호 문자열이라면, AB 도 올바른 괄호 문자열입니다.
    예를 들어, {} 와 ([]) 가 올바른 괄호 문자열이므로, {}([]) 도 올바른 괄호 문자열입니다.
    대괄호, 중괄호, 그리고 소괄호로 이루어진 문자열 s가 매개변수로 주어집니다.

    이 s를 왼쪽으로 x (0 ≤ x < (s의 길이)) 칸만큼 회전시켰을 때
    s가 올바른 괄호 문자열이 되게 하는 x의 개수를 return 하도록 solution 함수를 완성해주세요.
 */

public class Sol_76502 {
    public int solution(String s) {
        int answer = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            String rotated = s.substring(i) + s.substring(0, i);
            if (isValid(rotated)) {
                answer++;
            }
        }
        return answer;
    }

    private boolean isValid(String s) {
        java.util.Stack<Character> stack = new java.util.Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                        (c == ']' && top != '[') ||
                        (c == '}' && top != '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Sol_76502 sol = new Sol_76502();
        String s = "[](){}";
        int result = sol.solution(s);
        System.out.println(result);
    }
}
