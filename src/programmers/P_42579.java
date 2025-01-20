package programmers;
import java.util.*;

public class P_42579 {

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] solution = s.solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500});
        System.out.println(Arrays.toString(solution));
    }



    static class Solution {
        public int[] solution(String[] genres, int[] plays) {
            // 장르별로 가장 많이 재생된 노래를 두개씩 모아 베스트 앨범 구성
            // 정렬 우선순위
            // 1. 장르 기준 재생 수가 높은 순으로 정렬
            // 2. 장르 내에서 재생 수가 높은 노래 순으로 정렬
            // 3. 재생 수가 같으면 고유번호가 낮은 노래로 정렬
            // i는 노래의 고유 번호

            // 출력: 베스트 앨범에 들어갈 노래의 고유 번호
            Map<String, Genre> map = new HashMap<>();

            for(int i = 0; i < genres.length; i++){
                Genre g = map.get(genres[i]);
                if(g == null){
                    map.put(genres[i], new Genre(i, plays[i]));
                }else{
                    g.addSong(new Song(i, plays[i]));
                }
            }

            List<Genre> genreList = new ArrayList<>();

            for(String key : map.keySet()){
                Genre genre = map.get(key);
                Collections.sort(genre.songs);
                genreList.add(genre);
            }

            Collections.sort(genreList);
            List<Integer> temp = new ArrayList<>();

            for(Genre g : genreList){
                if(g.songs.size() == 1){
                    temp.add(g.songs.get(0).id);
                }else{
                    temp.add(g.songs.get(0).id);
                    temp.add(g.songs.get(1).id);
                }
            }
            int[] album = new int[temp.size()];
            for(int i = 0; i < album.length; i++){
                album[i] = temp.get(i);
            }
            return album;
        }

        class Genre implements Comparable<Genre> {
            int total;
            List<Song> songs;

            Genre(int id, int count){
                this.total += count;
                this.songs = new ArrayList<>();
                songs.add(new Song(id, count));
            }

            void addSong(Song s){
                this.total += s.count;
                this.songs.add(s);
            }

            @Override
            public int compareTo(Genre g){
                if(this.total < g.total){
                    return 1;
                }else{
                    return -1;
                }
            }
        }

        class Song implements Comparable<Song> {
            int id;
            int count;

            Song(int id, int count){
                this.id = id;
                this.count = count;
            }

            @Override
            public int compareTo(Song s){
                if(this.count < s.count){
                    return 1;
                }else if(this.count > s.count){
                    return -1;
                }else {
                    return Integer.compare(this.id, s.id);
                }
            }
        }
    }
}


