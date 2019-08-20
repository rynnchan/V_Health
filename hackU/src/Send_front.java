import java.io.*;
import com.fasterxml.jackson.databind.ObjectMapper;

// String[] menu：おすすめメニューが格納された配列
// double[] ave：各種平均値が格納された配列
// int[] sleep：睡眠時間が格納された配列
public class Send_front {
    public static String send_front(String[] menu, double[] ave, double sleep_h) throws Exception {
        Front f = new Front(menu,ave,sleep_h);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(f);

        return json;
    }
    public static void write_json(String json){
        try {
            // FileWriterクラスのオブジェクトを生成する
            FileWriter file = new FileWriter("node_unity_app-master-2/public/dist/data1.json");
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