public class Colorcheck {
    public static final int RED = 0;
    public static final int GREEN = 1;
    public static final int YELLOW = 2;
    public static final int MALE = 0;
    public static final int FEMALE = 1;
    public static final double MALE_SALT = 8.0;  // 男性の食塩基準
    public static final double FEMALE_SALT = 7.0;  // 女性の食塩基準
    private static int cnt = 0;
    private static double[][] list = new double[3][21];

    Colorcheck(){
    }

    // sex：性別、salt：塩分摂取量
    public double salt(int sex, double salt) {
        double rat, imp;
        // 食塩摂取量を（基準値）/（摂取量）のパラメータで評価
        if (sex == MALE) {
            rat = MALE_SALT / salt;
        }
        else {
            rat = FEMALE_SALT / salt;
        }

        // [0,1]の範囲に対応するようにimpを設定
        imp = Math.abs(1 - rat);

        return imp;
    }

    // 各群の点数を要素とする配列を受け取り、過去21回分（1週間分）の各群の点数の和を計算
    // そして、その和から最も点数の少ない群をintで返す関数
    public int minColor(double[] colors) {
        double[] sum = new double[3];
        int color = RED;

        // 受け取った各群の点数を配列に格納し、これまでの点数和を算出
        for (int i = 0; i < 3; i++) {
            list[i][cnt] = colors[i];
            for (int j = 0; j < 21; j++) {
                sum[i] += list[i][j];
            }
        }
        
        // 最も点数の少ない群の探索
        if (sum[0] > sum[1] && sum[2] > sum[1])
            color = GREEN;
        else if (sum[0] > sum[2] && sum[1] > sum[2])
            color = YELLOW;

        // カウンターの調整
        // 21回記録したら、カウンターを0に戻す
        cnt++;
        if (cnt == 21)
            cnt = 0;
        
        return color;
    }

    public static double[][] getList(){
        return list;
    }
}