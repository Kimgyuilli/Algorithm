class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        
        boolean isRightHand = hand.equals("right");
        
        int leftHand = 10;   // *
        int rightHand = 12;  // #
        
        for(int number : numbers){
            if(number == 1 || number == 4 || number == 7){
                sb.append("L");
                leftHand = number;
            } else if(number == 3 || number == 6 || number == 9){
                sb.append("R");
                rightHand = number;
            } else{
                char closeHand = getCloseHand(leftHand, rightHand, number, isRightHand);
                if(closeHand == 'R'){
                    rightHand = number;
                } else{
                    leftHand = number;
                }
                sb.append(closeHand);
            }
        }
        
        return sb.toString();
    }
    
    private char getCloseHand(int leftHand, int rightHand, int number, boolean isRightHand){
        int[] leftHandAt = getPosition(leftHand);
        int[] rightHandAt = getPosition(rightHand);
        int[] numberAt = getPosition(number);
        
        int leftToNumber = Math.abs(numberAt[0] - leftHandAt[0]) + Math.abs(numberAt[1] - leftHandAt[1]);
        int rightToNumber = Math.abs(numberAt[0] - rightHandAt[0]) + Math.abs(numberAt[1] - rightHandAt[1]);
        
        if(leftToNumber == rightToNumber){
            return isRightHand ? 'R' : 'L';
        }
        
        return leftToNumber < rightToNumber ? 'L' : 'R';
    }
    
    private int[] getPosition(int num){
        if(num == 0) return new int[]{3, 1};
        return new int[]{(num - 1) / 3, (num - 1) % 3};
    }
}
