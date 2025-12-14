public class Main {
    public static void main(String[] args) {

        boolean[] isNotSelfNum = new boolean[10001];

        for (int i = 1; i <= 10000; i++) {
            int selfNum = generateSelfNum(i);

            if (selfNum <= 10000){
                isNotSelfNum [selfNum] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i<= 10000; i++) {
            if(!isNotSelfNum [i]){
                sb.append(i).append('\n');
            }
        }
        System.out.print(sb);

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
