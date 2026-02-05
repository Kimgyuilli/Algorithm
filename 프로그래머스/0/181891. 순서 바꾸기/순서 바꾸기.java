class Solution {
    public int[] solution(int[] num_list, int n) {
        
        int[] arr1 = new int[n];
        int[] arr2 = new int[num_list.length - n];
        
        for(int i = 0; i < n; i++){
            arr1[i] = num_list[i];
        }
        
        for(int i = n; i < num_list.length; i++){
            arr2[i-n] = num_list[i];
        }
        
        for(int i = 0; i < num_list.length; i++){
            
            if(i < arr2.length){
                num_list[i] = arr2[i];
            }else{
                num_list[i] = arr1[i - arr2.length];
            }
            
        }
        
        return num_list;
    }
}