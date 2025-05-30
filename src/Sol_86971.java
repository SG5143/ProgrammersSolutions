import java.util.ArrayList;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/86971
 * n개의 송전탑이 전선을 통해 하나의 트리 형태로 연결되어 있습니다.
 * 당신은 이 전선들 중 하나를 끊어서 현재의 전력망 네트워크를 2개로 분할하려고 합니다.
 * 이때, 두 전력망이 갖게 되는 송전탑의 개수를 최대한 비슷하게 맞추고자 합니다.
 *
 * 송전탑의 개수 n, 그리고 전선 정보 wires가 매개변수로 주어집니다.
 * 전선들 중 하나를 끊어서 송전탑 개수가 가능한 비슷하도록 두 전력망으로 나누었을 때,
 * 두 전력망이 가지고 있는 송전탑 개수의 차이(절대값)를 return 하도록 solution 함수를 완성해주세요.
 */


public class Sol_86971 {
    public int solution(int n, int[][] wires) {
        ArrayList<Integer>[] adj = new ArrayList[n];

        for(int i=0; i<n; i++){
            adj[i] = new ArrayList<>();
        }

        for (int[] wire : wires) {
            int start = wire[0]-1;
            int end = wire[1]-1;

            adj[start].add(end+1);
            adj[end].add(start+1);
        }

        printTest(n, adj);


        int answer = 99999;
        for (int[] wire : wires) {
            int start = wire[0] - 1;
            int end = wire[1] - 1;

            adj[start].remove(Integer.valueOf(end + 1));
            adj[end].remove(Integer.valueOf(start + 1));

            boolean[] visited = new boolean[n];
            int count = dfs(start, visited, adj);

            int diff = Math.abs(count * 2 - n);
            answer = Math.min(answer, diff);

            adj[start].add(end + 1);
            adj[end].add(start + 1);
        }

        return answer;
    }

    private int dfs(int curNode, boolean[] visited, ArrayList<Integer>[] adj){
        int count = 1;

        visited[curNode] = true;

        for(int nextNode : adj[curNode]){
            if(!visited[nextNode-1]){
                count += dfs(nextNode-1, visited, adj);
            }
        }

        return count;
    }

    private void printTest(int n, ArrayList<Integer>[] adj){
        System.out.println("------- 테스트 용도 -------");
        for (int i = 0; i < n; i++) {
            System.out.println("송전탑 " + (i+1) + ": " + adj[i]);
        }
        System.out.println("-------------------------");
    }

}
