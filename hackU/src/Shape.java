public class Shape {
    public static final int stan[][] = {{2300, 2650, 3050}, {1650, 1950, 2200}};  //カロリー基準量を格納する配列

    private static double[] list = new double[7];
    private static double bias = 0.4;  // 閾値設定の割合

    Shape(){
    }

    // day：曜日（0~6）、sex：性別（0,1）、level：身体活動レベル（0~2）、calorie：1日の摂取カロリーの合計
    public double[] calorie_calc(int day, int sex, int level, int calorie) {
        int sum = 0;
        double ave, imp0;
        double[] imp = new double[2];  // imp[0]：痩せるパラメータ、imp[1]：太るパラメータ
        int base = stan[sex][level];  // カロリー摂取基準値
        int diff = calorie - base;  // 摂取カロリーと基準値との差
        list[day] = diff;  // 差を曜日に対応するように格納

        // 各曜日の差の和を出し、差の平均値を出す
        for (int i = 0; i < list.length; i++) {
            sum += list[i];
        }
        ave = sum / 7;
        
        // 差の平均値を閾値で割り、影響度を設定（ただし影響度の範囲は[0,1]）
        imp0 = ave / base * bias;

        if (imp0 > 0) {
            imp[0] = 0;
            if (imp0 > 1)
                imp[1] = 1;
            else
                imp[1] = imp0;
        }
        else {
            imp[1] = 0;
            if (imp0 < -1)
                imp[0] = 1;
            else
                imp[0] = Math.abs(imp0);
        }
        return imp;
    }
    
    public static void main(String[] args) {

    }
}