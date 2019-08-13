public class Colorpoint {
    public static final double p = 0.65; // ポアソン分布的なp
    // 3群の点数を用いて、栄養バランスによるパラメータ（[0,1]）を算出する
    // 各群の点数が格納された配列を受け取る
    // color[0]：赤、color[1]：緑、color[2]：黄
    public double[] colorpoint(double[] color) {
        double[] colorpoint = new double[2];  // colorpoint[0]：栄養バランス 悪い、colorpoint[1]：栄養バランス 良い
        double red = color[0];
        double green = color[1];
        double yellow = color[2];

        double first = red + green;  // 必須点数（9点目安）

        colorpoint[0] = 1 - (first / 9);
            if (colorpoint[0] < 0) 
                colorpoint[0] = Math.abs(colorpoint[0]);
        colorpoint[1] = first * p + yellow * (1 - p);  // 増減可能得点を含めて栄養バランスの良いパラメータを設定

        return colorpoint;
    }
    public static void main(String[] args) {

    }
}