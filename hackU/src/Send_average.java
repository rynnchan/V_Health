import java.io.*;
import com.fasterxml.jackson.databind.ObjectMapper;

// String[] menu：おすすめメニューが格納された配列
// double[] ave：各種平均値が格納された配列
// int[] sleep：睡眠時間が格納された配列
public class Send_average {
    public static String send_average(double ave_calorie,double ave_protein,double ave_lipid,double ave_carbohydrate,double ave_salt,double ave_red,double ave_green,double ave_yellow,int start,int today,double today_calorie,double today_protein,double today_lipid,double today_carbohydrate,double today_salt,double today_red,double today_green,double today_yellow) throws Exception {
        Average a = new Average(ave_calorie,ave_protein,ave_lipid,ave_carbohydrate,ave_salt,ave_red,ave_green,ave_yellow,start,today,today_calorie,today_protein,today_lipid,today_carbohydrate,today_salt,today_red,today_green,today_yellow);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(a);

        return json;
    }
    public static void write_json(String json){
        try {
            // FileWriterクラスのオブジェクトを生成する
            FileWriter file = new FileWriter("hackU/json/average.json");
            // PrintWriterクラスのオブジェクトを生成する
            PrintWriter pw = new PrintWriter(new BufferedWriter(file));
            
            //ファイルに書き込む
            pw.println(json);
            
            //ファイルを閉じる
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}