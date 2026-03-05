import java.util.*;

class Solution {
    
    class Song {
        String title;
        int playTime;
        int index;

        public Song(String title, int playTime, int index) {
            this.title = title;
            this.playTime = playTime;
            this.index = index;
        }
    }

    public String replaceSharp(String s) {
        return s.replace("C#", "c")
                .replace("D#", "d")
                .replace("F#", "f")
                .replace("G#", "g")
                .replace("A#", "a")
                .replace("B#", "b");
    }

    public String solution(String m, String[] musicinfos) {
        List<Song> resultList = new ArrayList<>();
        String targetMelody = replaceSharp(m);
        
        for (int i = 0; i < musicinfos.length; i++) {
            String[] info = musicinfos[i].split(",");
            
            int startMin = parseTime(info[0]);
            int endMin = parseTime(info[1]);
            int playTime = endMin - startMin;
            
            String title = info[2];
            String melody = replaceSharp(info[3]);
            
            StringBuilder fullMelody = new StringBuilder();
            for (int j = 0; j < playTime; j++) {
                fullMelody.append(melody.charAt(j % melody.length()));
            }
            
            if (fullMelody.toString().contains(targetMelody)) {
                resultList.add(new Song(title, playTime, i));
            }
        }

        if (resultList.isEmpty()) return "(None)";

        Collections.sort(resultList, (a, b) -> {
            if (b.playTime == a.playTime) {
                return a.index - b.index; // 2순위: 먼저 입력된 순 (오름차순)
            }
            return b.playTime - a.playTime; // 1순위: 재생 시간 긴 순 (내림차순)
        });

        return resultList.get(0).title;
    }

    private int parseTime(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
}