public class Colorcheck {
    public static final int RED = 0;
    public static final int GREEN = 1;
    public static final int YELLOW = 2;
    public static final int MALE = 0;
    public static final int FEMALE = 1;
    public static final double MALE_SALT = 8.0;  // 男性の食塩基準
    public static final double FEMALE_SALT = 7.0;  // 女性の食塩基準
    

    // sex：性別、salt：塩分摂取量
    public static double salt(int sex, double salt) {
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

    // 各群の点数を要素とする配列を受け取り、1週間分の各群の点数の和を計算
    // そして、その和から最も点数の少ない群をintで返す関数
    public static int minColor(double[] colors) {
        int color = RED;
        
        // 最も点数の少ない群の探索
        if (colors[0] > colors[1] && colors[2] > colors[1])
            color = GREEN;
        else if (colors[0] > colors[2] && colors[1] > colors[2])
            color = YELLOW;
        
        return color;
    }
}