/*
    https://school.programmers.co.kr/learn/courses/30/lessons/250137
    [PCCP 기출문제] 1번 / 붕대 감기
    어떤 게임에는 붕대 감기라는 기술이 있습니다.

    붕대 감기는 t초 동안 붕대를 감으면서 1초마다 x만큼의 체력을 회복합니다.
    t초 연속으로 붕대를 감는 데 성공한다면 y만큼의 체력을 추가로 회복합니다.
    게임 캐릭터에는 최대 체력이 존재해 현재 체력이 최대 체력보다 커지는 것은 불가능합니다.

    기술을 쓰는 도중 몬스터에게 공격을 당하면 기술이 취소되고, 공격을 당하는 순간에는 체력을 회복할 수 없습니다.
    몬스터에게 공격당해 기술이 취소당하거나 기술이 끝나면 그 즉시 붕대 감기를 다시 사용하며, 연속 성공 시간이 0으로 초기화됩니다.

    몬스터의 공격을 받으면 정해진 피해량만큼 현재 체력이 줄어듭니다.
    이때, 현재 체력이 0 이하가 되면 캐릭터가 죽으며 더 이상 체력을 회복할 수 없습니다.

    당신은 붕대감기 기술의 정보, 캐릭터가 가진 최대 체력과 몬스터의 공격 패턴이 주어질 때
    캐릭터가 끝까지 생존할 수 있는지 궁금합니다.

    붕대 감기 기술의 시전 시간, 1초당 회복량, 추가 회복량을 담은 1차원 정수 배열 bandage와
    최대 체력을 의미하는 정수 health, 몬스터의 공격 시간과 피해량을 담은 2차원 정수 배열 attacks가 매개변수로 주어집니다.
    모든 공격이 끝난 직후 남은 체력을 return 하도록 solution 함수를 완성해 주세요.
    만약 몬스터의 공격을 받고 캐릭터의 체력이 0 이하가 되어 죽는다면 -1을 return 해주세요.
 */

public class Sol_250137 {
    private int maxHealth;
    private int t, x, y; // 붕대 감기 정보

    private int currentHealth = 0;
    private int continuousSuccess = 0;

    public int solution(int[] bandage, int health, int[][] attacks) {
        this.t = bandage[0];
        this.x = bandage[1];
        this.y = bandage[2];
        this.maxHealth = health;
        this.currentHealth = health;

        int attackIndex = 0;
        int lastAttackTime = attacks[attacks.length - 1][0];

        for (int time = 0; time <= lastAttackTime; time++) {
            if (attackIndex < attacks.length && attacks[attackIndex][0] == time) {
                if (!processAttack(attacks[attackIndex][1])) return -1;
                attackIndex++;
            } else {
                processHealing();
            }
        }

        return currentHealth;
    }

    // 몬스터의 공격 처리
    private boolean processAttack(int damage) {
        currentHealth -= damage;
        continuousSuccess = 0;
        return currentHealth > 0;
    }

    // 1초간 회복 처리
    private void processHealing() {
        currentHealth += x;
        continuousSuccess++;

        if (continuousSuccess == t) {
            currentHealth += y;
            continuousSuccess = 0;
        }

        if (currentHealth > maxHealth) {
            currentHealth = maxHealth;
        }
    }
}
