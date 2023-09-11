import java.util.*;
class Solution {
    public static int[] solution(String[] genres, int[] plays) {

        HashMap<String, PriorityQueue<Music>> map = new HashMap<>();
        HashMap<String, Genre> temp = new HashMap<>();
        for(int i=0; i < genres.length; i++){
            if (!map.containsKey(genres[i])){
                map.put(genres[i], new PriorityQueue<Music>(
                        (o1, o2)-> {
                            int two = Integer.compare(o2.play,o1.play);
                            if (two==0){
                                return Integer.compare(o1.index, o2.index);
                            }
                            return two;
                        }));
                temp.put(genres[i], new Genre(genres[i],0));
            }
            temp.get(genres[i]).plays += plays[i];
            map.get(genres[i]).add(new Music(genres[i], plays[i], i));
        }
        Genre[] genreArr = temp.values().toArray(new Genre[temp.size()]);
        ArrayList<Integer> result = new ArrayList<>();
        Arrays.sort(genreArr,(o1, o2) -> Integer.compare(o2.plays, o1.plays));
        for (Genre genre : genreArr) {
            if (map.get(genre.name).size()==1){
                result.add(map.get(genre.name).poll().index);
                continue;
            }
            for (int i = 0; i < 2; i++) {
                result.add(map.get(genre.name).poll().index);
            }
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}
class Genre{
    String name;
    int plays;

    public Genre(String name, int plays) {
        this.name = name;
        this.plays = plays;
    }
}

class Music{

    String genre;
    int play;
    int index;

    Music(String genre, int play, int index){
        this.genre = genre;
        this.play = play;
        this.index = index;
    }

}