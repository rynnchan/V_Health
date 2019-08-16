import java.io.*;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Send_unity {
    // キャラ側に送るパラメータをJSON形式のString型に変換するメソッド
    public static String send_unity(double fat, double slim, double sleepy, double good, double bad) throws Exception {
        Unity u = new Unity(fat,slim,sleepy,good,bad);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(u);

        return json;
    }

    public static void write_json(String json){
        try {
            // FileWriterクラスのオブジェクトを生成する
            FileWriter file = new FileWriter("hackU/test.json");
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