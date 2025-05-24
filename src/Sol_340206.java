import java.util.Scanner;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/340206
디버깅(Debugging)은 이미 완성된 코드에서 버그를 찾아 수정하는 문제 타입입니다.
1줄만 수정하여 버그를 고치세요.
2줄 이상 수정할 경우, 실행 결과에 에러 메시지가 표시됩니다.
 */

public class Sol_340206 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int angle1 = sc.nextInt();
        int angle2 = sc.nextInt();

        int sum_angle = angle1 + angle2;
        //System.out.println(sum_angle);
        System.out.println(sum_angle % 360);
    }
}
