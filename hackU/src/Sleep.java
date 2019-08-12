import java.util.*;

public class Sleep {
    public static int[] Sleep_time(int start_h, int start_m, int end_h, int end_m) {
        int hours, minutes;
        // 睡眠時間（時）の計算
        if (end_h < start_h && start_h < 24)
            hours = (24 - start_h) + end_h;
        else
            hours = end_h - start_h;
        
        // 睡眠時間（分）の計算
            minutes = end_m - start_m;
        if (minutes < 0) {
            hours--;
            minutes += 60;
        }
        // 結果の格納
        int[] sleep_time = new int[2];
        sleep_time[0] = hours;
        sleep_time[1] = minutes;

        return  sleep_time;
    }

    public static double Sleep_imp(int[] sleep_time) {
        double imp, diff;
        int sleep_h = sleep_time[0];
        int sleep_m = 60 - sleep_time[1];
        
        // 7時間以上の場合、影響なし
        // そうでない場合、7時間との差を出し、その差が大きいほど影響が大きい（1に近い）
        if (sleep_h >= 7)
            imp = 0;
        else {
            diff = (7 - sleep_h) + (sleep_m / 60);
            imp = diff / 7;
        }
        return imp;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("寝た時間を入力してください。");
        System.out.print("何時：");
        int start_h = scan.nextInt();
        System.out.print("何分：");
        int start_m = scan.nextInt();

        System.out.println("起きた時間を入力してください。");
        System.out.print("何時：");
        int end_h = scan.nextInt();
        System.out.print("何分：");
        int end_m = scan.nextInt();

        int[] sleep = Sleep_time(start_h, start_m, end_h, end_m);

        scan.close();

        System.out.println("本日の睡眠時間は" + sleep[0] + "時間" + sleep[1] + "分です。");
        System.out.println("睡眠不足影響度：" + Sleep_imp(sleep));
    }
}