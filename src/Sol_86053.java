/*
    https://school.programmers.co.kr/learn/courses/30/lessons/86053

    금과 은 운반하기

    어느 왕국에 하나 이상의 도시들이 있습니다.
    왕국의 왕은 새 도시를 짓기로 결정하였습니다.
    해당 도시를 짓기 위해서는 도시를 짓는 장소에 금 a kg과 은 b kg이 전달되어야 합니다.

    각 도시에는 번호가 매겨져 있는데,
    i번 도시에는 금 g[i] kg, 은 s[i] kg, 그리고 트럭 한 대가 있습니다.
    i번 도시의 트럭은 오직 새 도시를 짓는 건설 장소와 i번 도시만을 왕복할 수 있으며,
    편도로 이동하는 데 t[i] 시간이 걸리고, 최대 w[i] kg 광물을 운반할 수 있습니다.
    (광물은 금과 은입니다. 즉, 금과 은을 동시에 운반할 수 있습니다.)
    모든 트럭은 같은 도로를 여러 번 왕복할 수 있으며 연료는 무한대라고 가정합니다.

    정수 a, b와 정수 배열 g, s, w, t가 매개변수로 주어집니다.
    주어진 정보를 바탕으로 각 도시의 트럭을 최적으로 운행했을 때,
    새로운 도시를 건설하기 위해 금 a kg과 은 b kg을 전달할 수 있는
    가장 빠른 시간을 구해 return 하도록 solution 함수를 완성해주세요.

    1> 각 도시에서 금 g[i], 은 s[i] 있음
    2> 트럭은 한번에 최대 w[i] kg, 왕복에 t[i]시간 걸림
    3> 새 도시를 만들기 위해 금 a, 은 b를 보내야 함
    4> 모든 도시의 트럭을 최대한 활용해서 a, b를 보내는 최소 시간을 구해야 함
 */


import java.util.ArrayList;
import java.util.List;

public class Sol_86053 {

    private class City {
        public int gold;
        public int silver;
        public int weight;
        public int time;

        public City(int gold, int silver, int weight, int time) {
            this.gold = gold;
            this.silver = silver;
            this.weight = weight;
            this.time = time;
        }
    }

    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        List<City> cities = new ArrayList<>();

        for (int i = 0; i < g.length; i++) {
            cities.add(new City(g[i], s[i], w[i], t[i]));
        }

        long left = 0;
        long right = (long) 1e14;  // 100조 (충분히 큰 시간)
        long answer = right;

        while (left <= right) {
            long mid = (left + right) / 2;

            boolean possible = canDeliverInTime(mid, a, b, cities);

            // 디버깅 출력
            System.out.printf("시간: %d | 가능 여부: %s | 범위: [%d, %d]\n", mid, possible, left, right);

            if (possible) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }


    // 모든 도시의 트럭을 time 동안 최대로 운행 했을 때,
    // 금 a, 은 b, 총합 a + b를 만족할 수 있는지
    private boolean canDeliverInTime(long time, int a, int b, List<City> cities) {
        long totalGold = 0;
        long totalSilver = 0;
        long totalCombined = 0;

        for (City city : cities) {
            long roundTripTime = city.time * 2L;

            // 왕복 횟수를 설정, 남은 시간으로 한 번 더 운행이 가능할 경우 +1;
            long trips = time / roundTripTime;
            if (time % roundTripTime >= city.time) {
                trips++;
            }

            long max = trips * (long) city.weight;

            long gold = Math.min(city.gold, max);
            long silver = Math.min(city.silver, max);
            long combined = Math.min(city.gold + city.silver, max);

            totalGold += gold;
            totalSilver += silver;
            totalCombined += combined;
        }

        return totalGold >= a && totalSilver >= b && totalCombined >= (a + b);
    }
}
