/*
    https://school.programmers.co.kr/learn/courses/30/lessons/42579
    배스트앨범
    문제 설명
    스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다.
    노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.

    속한 노래가 많이 재생된 장르를 먼저 수록합니다.
    장르 내에서 많이 재생된 노래를 먼저 수록합니다.
    장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
    노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때,
    베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.

    제한사항
    genres[i]는 고유번호가 i인 노래의 장르입니다.
    plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
    genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
    장르 종류는 100개 미만입니다.
    장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
    모든 장르는 재생된 횟수가 다릅니다.
 */
import java.util.*;

public class Sol_42579 {
    private static class Song{
        public int totalPlayCount = 0;
        public List<int[]> songs = new ArrayList<>();

        public void addSong(int index, int playCount){
            this.songs.add(new int[]{index, playCount});
            this.totalPlayCount += playCount;
        }

        public void getBestSongIndex(List<Integer> indexes) {
            // 재행 횟수가 같으면 인덱스 오름차순, 재생홧수 내림차순
            // 조건에 모든 장르는 재생된 횟수가 다릅니다 << 조건이 있어 비교 안해도 무방
            this.songs.sort((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
            indexes.add(this.songs.get(0)[0]);

            if (this.songs.size() > 1)
                indexes.add(this.songs.get(1)[0]);
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        // 장르별 노래 정보 저장
        HashMap<String, Song> map = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            map.computeIfAbsent(genres[i], s -> new Song()).addSong(i, plays[i]);
        }

        // 장르별 총 재생횟수 기준으로 정렬 내림차순
        List<String> genresList = new ArrayList<>(map.keySet());
        genresList.sort((a, b) -> map.get(b).totalPlayCount - map.get(a).totalPlayCount);

        // 각 장르 상위 곡 추출(최대 두곡)
        List<Integer> results = new ArrayList<>();
        for(String genre : genresList) {
//            System.out.println("==============");
//            System.out.printf("KEY: %s\nTOTAL: %d\n", genre, map.get(genre).totalPlayCount);
            map.get(genre).getBestSongIndex(results);
        }

        return results.stream().mapToInt(Integer::intValue).toArray();
    }
}
