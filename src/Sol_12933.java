/*
    https://school.programmers.co.kr/learn/courses/30/lessons/12933
    정수 내림차순으로 배치하기
    함수 solution은 정수 n을 매개변수로 입력받습니다.
    n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요.
    예를들어 n이 118372면 873211을 리턴하면 됩니다.

    제한 조건
    n은 1이상 8000000000 이하인 자연수입니다.
 */
import java.util.Arrays;

public class Sol_12933 {
    public long solution(long n) {
        String str = String.valueOf(n);

        char[] arr = str.toCharArray();
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder(new String(arr));
        sb.reverse();

        return Long.parseLong(sb.toString());
    }

    public static void main(String[] args) {
        long n = 118372;

        long result = new Sol_12933().solution(n);
        System.out.println(result);
    }
}
