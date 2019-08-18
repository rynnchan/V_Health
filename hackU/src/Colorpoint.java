public class Colorpoint {
    public static final double p = 0.65; // ポアソン分布的なp
    public static final int MALE_POINT = 16;
    public static final int FEMALE_POINT = 11;
    public static final int MALE = 0; // 男性を0とし
    public static final int FEMALE = 1;  // 女性を1とする

    // 3群の点数を用いて、栄養バランスによるパラメータ（[0,1]）を算出する
    // 各群の点数が格納された配列を受け取る
    // color[0]：赤、color[1]：緑、color[2]：黄
    public static double[] colorpoint(double[] color, int sex) {
        double[] colorpoint = new double[2];  // colorpoint[0]：栄養バランス 悪い、colorpoint[1]：栄養バランス 良い
        double red = color[0];
        double green = color[1];
        double yellow = color[2];

        double first = red + green;  // 必須点数（9点目安）
        first = Math.min(first, 9);
        colorpoint[0] = 1 - (first / 9);
            if (colorpoint[0] < 0) 
                colorpoint[0] = Math.abs(colorpoint[0]);

        if (sex == MALE)
        colorpoint[1] = (first / 9) * p + (Math.min(yellow,MALE_POINT) / MALE_POINT) * (1 - p);
        else
        colorpoint[1] = (first / 9) * p + (Math.min(yellow,FEMALE_POINT) / FEMALE_POINT) * (1 - p);

        return colorpoint;
    }
}