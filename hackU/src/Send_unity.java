import com.fasterxml.jackson.databind.ObjectMapper;

public class Send_unity {
    // キャラ側に送るパラメータをJSON形式のString型に変換するメソッド
    public static String send_unity(double fat, double slim, double sleepy, double good, double bad) throws Exception {
        Unity u = new Unity(fat,slim,sleepy,good,bad);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(u);

        return json;
    }
}