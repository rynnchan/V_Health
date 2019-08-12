public class Colorcheck {
    public static int cnt = 0;

    // 各群の点数を要素とする配列を受け取り、過去21回分（1週間分）の各群の点数の和を計算
    // そして、その和から最も点数の少ない群をintで返す関数
    // 0：赤、1：緑、2：黄
    public static int colorcheck(double[] colors) {
        double[][] list = new double[3][21];
        double[] sum = new double[3];
        int color = 0;

        // 受け取った各群の点数を配列に格納し、これまでの点数和を算出
        for (int i = 0; i < 3; i++) {
            list[i][cnt] = colors[i];
            for (int j = 0; j < cnt; j++) {
                sum[i] += list[i][j];
            }
        }
        
        // 最も点数の少ない群の探索
        if (sum[0] > sum[1] && sum[2] > sum[1])
            color = 1;
        else if (sum[0] > sum[2] && sum[1] > sum[2])
            color = 2;

        // カウンターの調整
        // 21回記録したら、カウンターを0に戻す
        cnt++;
        if (cnt == 21)
            cnt = 0;
        
        return color;
        }

    public static void main(String[] args) {

    }
}