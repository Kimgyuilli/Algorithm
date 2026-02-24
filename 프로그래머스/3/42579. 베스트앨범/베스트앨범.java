import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        Map<String, Integer> genres_list = new HashMap<>();
        Map<String, List<int[]>> genres_map = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++) {
            genres_list.put(genres[i], genres_list.getOrDefault(genres[i], 0) + plays[i]);
            List<int[]> list = genres_map.getOrDefault(genres[i], new ArrayList<>());
            list.add(new int[]{i, plays[i]});
            genres_map.put(genres[i], list);
        }
        
        List<String> sorted_genres = new ArrayList<>(genres_list.keySet());
        sorted_genres.sort((a, b) -> {
            return genres_list.get(b) - genres_list.get(a);
        });
        
        List<Integer> result = new ArrayList<>();
        
        for(String genre : sorted_genres) {
            List<int[]> songs = genres_map.get(genre);
            
            songs.sort((a, b) -> b[1] - a[1]); 
            
            for(int i = 0; i < Math.min(2, songs.size()); i++) {
                result.add(songs.get(i)[0]);
            }
            
        }
        
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}