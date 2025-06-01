/*
    https://school.programmers.co.kr/learn/courses/30/lessons/12953
    두 수의 최소공배수(Least Common Multiple)란 입력된 두 수의 배수 중
    공통이 되는 가장 작은 숫자를 의미합니다. 예를 들어 2와 7의 최소공배수는 14가 됩니다.
    정의를 확장해서, n개의 수의 최소공배수는 n 개의 수들의 배수 중 공통이 되는 가장 작은 숫자가 됩니다.
    숫자를 담은 배열 arr이 입력되었을 때 이 수들의 최소공배수를 반환하는 함수, solution을 완성해 주세요.

    제한 사항
    arr은 길이 1이상, 15이하인 배열입니다.
    arr의 원소는 100 이하인 자연수입니다.
 */

public class Sol_12953_1 {
    public int solution(int[] arr) {

        // 첫 번째 숫자로 시작
        int result = arr[0];

        // 배열의 각 숫자와 최소 공배수를 정함
        for(int i = 1; i < arr.length; i++) {
            result = getLeastCommonMultiple(result, arr[i]);
        }

        return result;
    }

    // 최소 공배수 Least Common Multiple
    private int getLeastCommonMultiple(int num1, int num2) {
        int gcd = getGreatestCommonDivisor(num1, num2);
        return (num1*num2) / gcd;
    }

    // 최대 공약수 Greatest Common Divisor
    private int getGreatestCommonDivisor(int num1, int num2) {
        while (num2 != 0) {
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }
        return num1;
    }
}
