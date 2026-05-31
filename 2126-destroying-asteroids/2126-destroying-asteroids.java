import java.util.*;

class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long longmass = mass;
        for(int i : asteroids) {
            if(longmass < i) return false;
            longmass += i;
        }
        return true;
    }
}