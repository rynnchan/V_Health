import com.fasterxml.jackson.databind.ObjectMapper;

// String[] menu：おすすめメニューが格納された配列
// double[] ave：各種平均値が格納された配列
// int[] sleep：睡眠時間が格納された配列
public class Send_front {
    public static String send_front(String[] menu, double[] ave, int[] sleep) throws Exception {
        Front f = new Front();
        f.mainMenu = menu[0];
        f.subMenu = menu[1];
        f.menMenu = menu[2];
        f.donMenu = menu[3];
        f.ave_calorie = ave[0];
        f.ave_protein = ave[1];
        f.ave_lipid = ave[2];
        f.ave_carbo = ave[3];
        f.ave_salt = ave[4];
        f.sleep_h = sleep[0];
        f.sleep_m = sleep[1];

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(f);

        return json;
    }
}