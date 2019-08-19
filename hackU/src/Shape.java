public class Shape {
    public static final int stan[][] = {{2300, 2650, 3050}, {1650, 1950, 2200}};  //カロリー基準量を格納する配列

    private static double bias = 0.4;  // 閾値設定の割合

    // sex：性別（0,1）、level：身体活動レベル（0~2）、ave_calorie：1日の摂取カロリーの平均
    public static double[] calorie_calc(int sex, int level, double ave_calorie) {
        double imp0;
        double[] imp = new double[2];  // imp[0]：痩せるパラメータ、imp[1]：太るパラメータ
        int base = stan[sex][level];  // カロリー摂取基準値
        double diff = ave_calorie - base;  // 摂取カロリーと基準値との差
        
        // 差の平均値を閾値で割り、影響度を設定（ただし影響度の範囲は[0,1]）
        imp0 = diff / base * bias;

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
}