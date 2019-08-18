import java.util.Calendar;
public class Main {
    
    public static void main(String[] args) {
        
        // Unity側に送信するJSON作成
        Read_json rj = new Read_json();

        int day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)-1;  // 曜日
        int sex = rj.sex;  // 性別
        int level = rj.physicalActivityLevel;  // 身体活動レベル
        int calorie = rj.calorie;  // 摂取カロリー

        int start_h = rj.bedTime[0];  // 寝た時間（時）
        int start_m = rj.bedTime[1];  // 寝た時間（分）
        int end_h = rj.wakeUpTime[0];  // 起きた時間（時）
        int end_m = rj.wakeUpTime[1];  // 起きた時間（分）

        double[] color = {rj.red, rj.green, rj.yellow};  // 3群点数が格納された配列
        // これより上の変数は実際にはフロントエンド側からJSONで受け取る

        // 体型パラメータが格納された配列
        double[] shape = Shape.calorie_calc(day, sex, level, calorie);

        // 睡眠時間による影響度のパラメータ
        double sleepy = Sleep.Sleep_imp(Sleep.Sleep_time(start_h, start_m, end_h, end_m));

        // 栄養バランスの良い・悪いのパラメータが格納された配列
        double[] balance = Colorpoint.colorpoint(color, sex);

        try {
            String su = Send_unity.send_unity(shape[1], shape[0], sleepy, balance[1], balance[0]);
            System.out.println(su);
            Send_unity.write_json(su);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // このパラメータはサーバで計算される
        int min_color = Colorcheck.minColor(color, day); // 最も点数の少ない群
        
        // おすすめメニューが格納された配列
        String[] menu = Menu_prop.proposal(min_color);

        double[] ave = new double[5];

        int[] sleep = Sleep.Sleep_time(start_h, start_m, end_h, end_m);

        try {
            String sf = Send_front.send_front(menu, ave, sleep);
            System.out.println(sf);
            Send_front.write_json(sf);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}