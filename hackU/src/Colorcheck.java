public class Colorcheck {
    public static final int RED = 0;
    public static final int GREEN = 1;
    public static final int YELLOW = 2;
    public static final int MALE = 0;
    public static final int FEMALE = 1;
    public static final double MALE_SALT = 8.0;  // 男性の食塩基準
    public static final double FEMALE_SALT = 7.0;  // 女性の食塩基準
    
    private static double[][] list = new double[3][7];

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

    // 各群の点数を要素とする配列を受け取り、1週間分の各群の点数の和を計算
    // そして、その和から最も点数の少ない群をintで返す関数
    public int minColor(double[] colors, int week) {
        double[] sum = new double[3];
        int color = RED;

        // 受け取った各群の点数を配列に格納し、これまでの点数和を算出
        for (int i = 0; i < 3; i++) {
            list[i][week] += colors[i];
            for (int j = 0; j < 7; j++) {
                sum[i] += list[i][j];
            }
        }
        
        // 最も点数の少ない群の探索
        if (sum[0] > sum[1] && sum[2] > sum[1])
            color = GREEN;
        else if (sum[0] > sum[2] && sum[1] > sum[2])
            color = YELLOW;
        
        return color;
    }

    public static double[][] getList(){
        return list;
    }
    public static void printList(){
        for(double[] val : getList()){
            for(double x : val){
                System.out.print(x+" ");
            }
            System.out.println();
        }
    }

    public static void initializeList(int week){
        for(int i=0; i<3; i++){
            list[i][week] = 0;
        }
    }
}