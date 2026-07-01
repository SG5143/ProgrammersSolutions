package Lv3;

import java.util.*;

public class Sol_133500 {
    static int n = 8;
    static int[][] lighthouse = {{1, 2}, {1, 3}, {1, 4}, {1, 5}, {5, 6}, {5, 7}, {5, 8}};

    // 2. dp 배열 만들기
    int[][] dp = new int[n+1][2];

    public static void main(String[] args){
        Sol_133500 sol = new Sol_133500();
        System.out.println(sol.solution(n, lighthouse));
    }

    public int solution(int n, int[][] lighthouse) {
        // 1. 인접 리스트 만들고 확인하기
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for(int[] ints : lighthouse){
            list.get(ints[0]).add(ints[1]);
            list.get(ints[1]).add(ints[0]);
        }

//        for(int i=1; i<=n; i++){
//            System.out.printf("%d번 등대: %s\n", i, list.get(i));
//        }

        // 4. dfs 시작
        dfs(1, 0, list);

        return Math.min(dp[1][0], dp[1][1]);
    }

    // 3. dfs 정의
    private void dfs(int now, int parent, List<List<Integer>> list){
        // 3.1 now 까지 계산하기
        // 킨경우를 1 끈 경우를 0 으로 둘 경우 각각 1,0
        dp[now][0] = 0;
        dp[now][1] = 1;

        // 3.2 현재 노드의 자식이 있다면 돌면서 반복문 수행
        for(int next: list.get(now)){
            // 3.2.1 부모 노드일 경우 돌아가면 안되니 패스
            if(next ==  parent) continue;

            // 3.2.2 자식 노드 기준으로 반복문 수행
            dfs(next, now, list);

            // 3.2.3 현재 등대(now)가 꺼질 경우 켜진 자식 노드 켜진쪽을 반영
            dp[now][0] += dp[next][1];
            // 3.2.4 현재 등대(now)가 켜질 경우 자식 노드의 경우 중 적게 켜진 쪽을 반영
            dp[now][1] += Math.min(dp[next][0], dp[next][1]);
        }
    }


}
