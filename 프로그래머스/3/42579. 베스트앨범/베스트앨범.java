import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        Map<String, Integer> genreTotal = new HashMap<>();
        Map<String, List<int[]>> genreMap = new HashMap<>();
        
        int len = genres.length;
        
        for(int i = 0; i < len; i++) {
            String genre = genres[i];
            int play = plays[i];
            
            genreTotal.put(genre, genreTotal.getOrDefault(genre, 0) + play);
            if(genreMap.get(genre) == null) {
                genreMap.put(genre, new ArrayList<>());
            }
            genreMap.get(genre).add(new int[] {i, play});
        }
        
        List<Integer> answer = new ArrayList<>();
        
        
        List<String> sorted_genre = new ArrayList<>(genreTotal.keySet());
        sorted_genre.sort( (a, b) -> {
           return genreTotal.get(b) - genreTotal.get(a);
        });
        
        for(String genre : sorted_genre) {
            List<int[]> songs = genreMap.get(genre);
            songs.sort((a, b) -> {
               return b[1] - a[1]; 
            });
            
            for(int i = 0; i < Math.min(2, songs.size()); i++) {
                answer.add(songs.get(i)[0]);
            }
        }
        
        int[] result = new int[answer.size()];
        
        for(int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }
        
        return result;
    }
}