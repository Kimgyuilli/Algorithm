public class Main {
    public static void main(String[] args) {

        int NumArr[] = new int[10001];

        for (int i = 1; i <= 10000; i++) {
            int selfNum = generateSelfNum(i);

            if (selfNum <= 10000){
                NumArr[selfNum] = 1;
            }
        }

        for (int i = 1; i<= 10000; i++) {
            if(NumArr[i] == 0){
                System.out.println(i);
            }
        }

    }

    public static int generateSelfNum(int num) {
        int sum = num;
        while(num != 0){
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
