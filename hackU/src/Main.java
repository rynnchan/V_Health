import java.util.Calendar;
public class Main {
    
    public static void main(String[] args) {
        
        // Unity側に送信するJSON作成
//        Read_json sj = new Read_json("hackU/json/server.json");
        Read_json sj = new Read_json("node_unity_app-master-2/json/data.json");
        int sex = Read_json.read_sex(sj.root);  // 性別
        int level = Read_json.read_level(sj.root);  // 身体活動レベル
        int calorie = Read_json.read_calorie(sj.root);  // 摂取カロリー
        double protein = Read_json.read_protein(sj.root);  // 摂取タンパク質
        double lipid = Read_json.read_lipid(sj.root);  // 摂取脂質
        double carbohydrate = Read_json.read_carbohydrate(sj.root);  // 摂取炭水化物
        double salt = Read_json.read_salt(sj.root);  // 摂取塩分
        int[] bedTime = Read_json.read_sleep(sj.root);
        int[] wakeUpTime = Read_json.read_wake(sj.root);
        int start_h = bedTime[0];  // 寝た時間（時）
        int start_m = bedTime[1];  // 寝た時間（分）
        int end_h = wakeUpTime[0];  // 起きた時間（時）
        int end_m = wakeUpTime[1];  // 起きた時間（分）
        double[] color = Read_json.read_color(sj.root);  // 3群点数が格納された配列
        //System.out.println(color[0]+","+color[1]+","+color[2]);
        // これより上の変数は実際にはフロントエンド側からJSONで受け取る

        Read_json aj = new Read_json("hackU/json/average.json");
        int start=Read_json.read_start(aj.root);
        int today_y=Read_json.read_today(aj.root);

        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal2.set(start/10000, (start%10000)/100-1, start%100);
        long diffTime = cal1.getTimeInMillis() - cal2.getTimeInMillis();
        double diffDayMillis = 1000 * 60 * 60 * 24;
        int n = (int) (Math.ceil(((double)diffTime / diffDayMillis)));

        double today_calorie=calorie;
        double today_protein=protein;
        double today_lipid=lipid;
        double today_carbohydrate=carbohydrate;
        double today_salt=salt;
        double today_red=color[0];
        double today_green=color[1];
        double today_yellow=color[2];
        int today = cal1.get(Calendar.YEAR)*10000+(cal1.get(Calendar.MONTH)+1)*100+cal1.get(Calendar.DAY_OF_MONTH);
        
        double ave_n=(today==today_y ? 1 : (n-1)/(double)n );
        double ave_calorie=Read_json.read_ave_calorie(aj.root)*ave_n+today_calorie/n;
        double ave_protein=Read_json.read_ave_protein(aj.root)*ave_n+today_protein/n;
        double ave_lipid=Read_json.read_ave_lipid(aj.root)*ave_n+today_lipid/n;
        double ave_carbohydrate=Read_json.read_ave_carbohydrate(aj.root)*ave_n+today_carbohydrate/n;
        double ave_salt=Read_json.read_ave_salt(aj.root)*ave_n+today_salt/n;
        double ave_red=Read_json.read_ave_red(aj.root)*ave_n+today_red/n;
        double ave_green=Read_json.read_ave_green(aj.root)*ave_n+today_green/n;
        double ave_yellow=Read_json.read_ave_yellow(aj.root)*ave_n+today_yellow/n;
        double[] ave_color={ave_red,ave_green,ave_yellow};

        try {
            String sa = Send_average.send_average(ave_calorie,ave_protein,ave_lipid,ave_carbohydrate,ave_salt,ave_red,ave_green,ave_yellow,start,today);
            Send_average.write_json(sa);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 体型パラメータが格納された配列
        double[] shape = Shape.calorie_calc(sex, level, ave_calorie);

        // 睡眠時間による影響度のパラメータ
        double sleepy = Sleep.Sleep_imp(Sleep.Sleep_time(start_h, start_m, end_h, end_m));

        // 栄養バランスの良い・悪いのパラメータが格納された配列
        double[] balance = Colorpoint.colorpoint(ave_color, sex);

        try {
            String su = Send_unity.send_unity(shape[1], shape[0], sleepy, balance[1], balance[0]);
            Send_unity.write_json(su);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // このパラメータはサーバで計算される
        int min_color = Colorcheck.minColor(sex,ave_color); // 最も点数の少ない群
        
        // おすすめメニューが格納された配列
        String[] menu = Menu_prop.proposal(min_color);

        double[] ave = {ave_calorie,ave_protein,ave_lipid,ave_carbohydrate,ave_salt};

        double sleep_h = Sleep.Sleep_hour(Sleep.Sleep_time(start_h, start_m, end_h, end_m));

        try {
            String sf = Send_front.send_front(menu, ave, sleep_h);
            Send_front.write_json(sf);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}