import com.fasterxml.jackson.databind.JsonNode;

public class Read_json{
    /*
    以下の関数を使う場合には、
    File json = new File("JSONのパス");
    ObjectMapper mapper = new ObjectMapper();
    JsonNode root = mapper.readTree(json);
    が必要
    */

    // JSONから性別のパラメータを受け取る関数
    public static int read_sex(JsonNode root) {
        int sex = root.get("sex").intValue();

        return sex;
    }

    // JSONから身体活動レベルのパラメータを受け取る関数
    public static int read_level(JsonNode root) {
        int level = root.get("physicalActivityLevel").intValue();

        return level;
    }

    // JSONから寝た時間を受け取る関数
    public static int[] read_sleep(JsonNode root) {
        String sleep = root.get("bedTime").textValue();
        String[] list = sleep.split(":");

        int[] time = {Integer.parseInt(list[0]), Integer.parseInt(list[1])};

        return time;
    }

    // JSONから起きた時間を受け取る関数
    public static int[] read_wake(JsonNode root) {
        String wake = root.get("wakeUpTime").textValue();
        String[] list = wake.split(":");

        int[] time = {Integer.parseInt(list[0], Integer.parseInt(list[1]))};

        return time;
    }

    // JSONから摂取カロリーを受け取る関数
    public static int read_calorie(JsonNode root) {
        double calorie = root.get("calorie").doubleValue();

        return (int)calorie;
    }

    // JSONから摂取塩分を受け取る関数
    public static double read_salt(JsonNode root) {
        double salt = root.get("salt").doubleValue();

        return salt;
    }

    // JSONから赤の点数を受け取る関数
    public static double read_red(JsonNode root) {
        double red = root.get("red").doubleValue();

        return red;
    }

    // JSONから緑の点数を受け取る関数
    public static double read_green(JsonNode root) {
        double green = root.get("green").doubleValue();

        return green;
    }

    // JSONから黄の点数を受け取る関数
    public static double read_yellow(JsonNode root) {
        double yellow = root.get("yellow").doubleValue();

        return yellow;
    }
}