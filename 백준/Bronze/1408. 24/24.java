import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));

        String[] startTime = br.readLine().split(":");
        String[] endTime = br.readLine().split(":");

        int startSecond = Integer.parseInt(startTime[0]) * 3600 +
                Integer.parseInt(startTime[1]) * 60 +
                Integer.parseInt(startTime[2]);

        int endSecond = Integer.parseInt(endTime[0]) * 3600 +
                Integer.parseInt(endTime[1]) * 60 +
                Integer.parseInt(endTime[2]);

        int duration;
        if (endSecond >= startSecond) {
            duration = endSecond - startSecond;
        } else {
            duration = 86400 - startSecond + endSecond;
        }

        int hour = duration / 3600;
        int minute = (duration % 3600) / 60;
        int second = duration % 60;

        System.out.printf("%02d:%02d:%02d\n", hour, minute, second);
    }
}
