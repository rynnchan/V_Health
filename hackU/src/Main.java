import org.json.JSONObject;

public class Main {
    
    /** main **/
    public static void main(String[] args) {
        double[] colors = {6,5,4};
        Colorcheck colorcheck = new Colorcheck();
        System.out.println(colorcheck.minColor(colors,0));
        colors = newColors(5,5,10);
        System.out.println(colorcheck.minColor(colors,0));
        colors = newColors(0,5,1);
        System.out.println(colorcheck.minColor(colors,0));

        colorcheck.printList();
        
        colorcheck.initializeList(0);
        colorcheck.printList();

        System.out.println(colorcheck.salt(0, 7));
        System.out.println(colorcheck.salt(0, 8));
        System.out.println(colorcheck.salt(0, 9));
        
        // Unity側に送信するJSON作成
        int day = 0;  // 曜日
        int sex = 0;  // 性別
        int level = 0;  // 身体活動レベル
        int calorie = 0;  // 摂取カロリー

        int start_h = 0;  // 寝た時間（時）
        int start_m = 0;  // 寝た時間（分）
        int end_h = 0;  // 起きた時間（時）
        int end_m = 0;  // 起きた時間（分）

        double[] color = {0, 0, 0};  // 3群点数が格納された配列
        // これより上の変数は実際にはフロントエンド側からJSONで受け取る

        // このパラメータはサーバで計算される
        int min_color = 0; // 最も点数の少ない群

        // 体型パラメータが格納された配列
        double[] shape = Shape.calorie_calc(day, sex, level, calorie);

        // 睡眠時間による影響度のパラメータ
        double sleepy = Sleep.Sleep_imp(Sleep.Sleep_time(start_h, start_m, end_h, end_m));

        // 栄養バランスの良い・悪いのパラメータが格納された配列
        double[] balance = Colorpoint.colorpoint(color, sex);

        // おすすめメニューが格納された配列
        String[] menu = Menu_prop.proposal(min_color);

        JSONObject json_unity = new JSONObject();

        // JSONに値を記録
        json_unity.put("fat", shape[1]);
        json_unity.put("slim", shape[0]);
        json_unity.put("sleepy", sleepy);
        json_unity.put("good", balance[1]);
        json_unity.put("bad", balance[0]);

        // フロントエンド側に送信するJSONの作成
        JSONObject json_front = new JSONObject();

        // JSONに値を記録
        json_front.put("menu_syusai", menu[0]);
        json_front.put("menu_fukusai", menu[1]);
        json_front.put("menu_men", menu[2]);
        json_front.put("menu_don", menu[3]);
    }

    public static double[] newColors(double r,double g, double y){
        double[] colors = {r,g,y};
        return colors;
    }
}