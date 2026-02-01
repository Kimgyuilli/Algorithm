import java.util.Arrays;

class Solution {
    public int solution(int[] arr1, int[] arr2) {
        if(arr1.length != arr2.length){
            return arr1.length > arr2.length ? 1 : -1;
        }
        
        int a1 = Arrays.stream(arr1)
            .sum();
        int a2 = Arrays.stream(arr2)
            .sum();
        
        return a1 == a2 ? 0 : a1 > a2 ? 1 : -1;
    }
}