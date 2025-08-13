/*
    https://school.programmers.co.kr/learn/courses/30/lessons/12940
    최대공약수와 최소공배수

    두 수를 입력받아 두 수의 최대공약수와 최소공배수를 반환하는 함수,
    solution을 완성해 보세요. 배열의 맨 앞에 최대공약수, 그다음 최소공배수를 넣어 반환하면 됩니다.
    예를 들어 두 수 3, 12의 최대공약수는 3, 최소공배수는 12이므로 solution(3, 12)는 [3, 12]를 반환해야 합니다.

    제한 사항
    두 수는 1이상 1000000이하의 자연수입니다.
 */

import java.util.Arrays;

public class Sol_12940 {
    public int[] solution(int n, int m) {
        int gcd = getGCD(n, m);
        int lcm = n * m / gcd;
        return new int[] {gcd, lcm};
    }

    private int getGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        int n = 3;
        int m = 12;

        int[] result = new Sol_12940().solution(n, m);
        System.out.println(Arrays.toString(result));
    }
}
