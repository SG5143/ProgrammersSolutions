package Lv3;

import java.util.Arrays;

public class Sol_77886 {
    static String[] s = {"1110", "100111100", "0111111010"};

    public static void main() {
        Sol_77886 sol = new Sol_77886();
        System.out.println(Arrays.toString(sol.solution(s)));
    }

    public String[] solution(String[] s) {

        // 문자열을 담을 StringBuilder 객체 생성
        StringBuilder sb = new StringBuilder();
        int idx = 0;

        for (String string : s) {
            // 110이 발견되면 추출하고 갯수를 세기 위해 카운트 변수 선언
            int cnt110 = 0;

            for(char c: string.toCharArray()){
                // 문자열을 하나씩 담음
                sb.append(c);

                // 문자열 개수가 3개 이상이면 110이 포함되는지 검사하고 포함될경우 추출     + cnt110 증가
                int len = sb.length();
                if (len >= 3 &&
                        sb.charAt(len - 3) == '1' &&
                        sb.charAt(len - 2) == '1' &&
                        sb.charAt(len - 1) == '0') {

                        sb.setLength(len - 3);
                        cnt110++;
                }
            }

            // 110 갯수만큼 문자 생성
            StringBuilder add = new StringBuilder();
            for(int i=0;i<cnt110;i++){
                add.append("110");
            }

            // 0이 포함된 마지막 위치 찾기
            int pos = sb.lastIndexOf("0");

            // 없으면 -1을 반환 맨 뒤에 추가
            // 발견되면 0뒤에다 추가
            if(pos != -1){
                sb.insert(pos+1, add);
            }else{
                sb.insert(0, add);
            }

            // 정렬된 값을 배열에 넣어 변경
            s[idx++] = sb.toString();

            // 선언한 스트링 빌더를 다음 반복을 위해 비우기
            sb.setLength(0);
        }

        return s;
    }


}
