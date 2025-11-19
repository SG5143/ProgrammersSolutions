package sol_251119;/*
    https://school.programmers.co.kr/learn/courses/30/lessons/12932
    자연수 뒤집어 배열로 만들기
    자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요.
    예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.

    제한 조건
    n은 10,000,000,000이하인 자연수입니다.
 */

import java.util.ArrayList;

public class Sol_12932 {
    public int[] solution(long n) {
        ArrayList<Integer> list = new ArrayList<>();

        while(n>0){
            list.add((int)(n%10));
            n/=10;
        }

        return list.stream().mapToInt(i->i).toArray();
    }
}

