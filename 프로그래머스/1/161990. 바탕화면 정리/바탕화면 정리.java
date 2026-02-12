class Solution {
    public int[] solution(String[] wallpaper) {
        
        int height = wallpaper.length;
        int width = wallpaper[0].length();
        
        char[][] list = new char[height][width];
        
        for(int i = 0; i < height; i++){
            list[i] = wallpaper[i].toCharArray();
        }
        
        int[] points = new int[4];
        points[0] = Integer.MAX_VALUE; //Left
        points[1] = Integer.MAX_VALUE; //Top
        points[2] = Integer.MIN_VALUE; //Right
        points[3] = Integer.MIN_VALUE; //Bottom
        
        
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                if(list[i][j] == '#'){
                    if(i < points[0]) points[0] = i;  // 최소 행 (위)
                    if(j < points[1]) points[1] = j;  // 최소 열 (왼쪽)
                    if(i > points[2]) points[2] = i;  // 최대 행 (아래)
                    if(j > points[3]) points[3] = j;  // 최대 열 (오른쪽)
                }
            }
        }
        
        points[2]++;
        points[3]++;
        
        return points;
    }
}