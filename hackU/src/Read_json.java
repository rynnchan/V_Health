import java.io.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

public class Read_json{
    public int sex;
    public int physicalActivityLevel;
    public int[] bedTime;
    public int[] wakeUpTime;
    public int calorie;
    public double protein;
    public double lipid;
    public double carbohydrate;
    public double salt;
    public double red;
    public double green;
    public double yellow;

    Read_json(){
        try {
            File json = new File("hackU/json/server.json");
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(json);

            this.sex = read_sex(root);
            this.physicalActivityLevel = read_level(root);
            this.bedTime = read_sleep(root);
            this.wakeUpTime = read_wake(root);
            this.calorie = read_calorie(root);
            this.protein = read_protein(root);
            this.lipid = read_lipid(root);
            this.carbohydrate = read_carbohydrate(root);
            this.salt = read_salt(root);
            this.red = read_red(root);
            this.green = read_green(root);
            this.yellow = read_yellow(root);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
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

        int[] time = {Integer.parseInt(list[0]), Integer.parseInt(list[1])};

        return time;
    }

    // JSONから摂取カロリーを受け取る関数
    public static int read_calorie(JsonNode root) {
        double calorie=0.0;
        for (JsonNode n : root.get("meal")) {
            calorie += n.get("calorie").doubleValue();
        }
        return (int)calorie;
    }
    // JSONから摂取カロリーを受け取る関数
    public static double read_protein(JsonNode root) {
        double protein=0.0;
        for (JsonNode n : root.get("meal")) {
            protein += n.get("protein").doubleValue();
        }
        return protein;
    }
    // JSONから摂取カロリーを受け取る関数
    public static double read_lipid(JsonNode root) {
        double lipid=0.0;
        for (JsonNode n : root.get("meal")) {
            lipid += n.get("lipid").doubleValue();
        }
        return lipid;
    }
    // JSONから摂取カロリーを受け取る関数
    public static double read_carbohydrate(JsonNode root) {
        double carbohydrate=0.0;
        for (JsonNode n : root.get("meal")) {
            carbohydrate += n.get("carbohydrate").doubleValue();
        }
        return carbohydrate;
    }

    // JSONから摂取塩分を受け取る関数
    public static double read_salt(JsonNode root) {
        double salt = 0.0;
        for (JsonNode n : root.get("meal")) {
            salt+= n.get("salt").doubleValue();
        }
        return salt;
    }

    // JSONから赤の点数を受け取る関数
    public static double read_red(JsonNode root) {
        double red = 0.0;
        for (JsonNode n : root.get("meal")) {
            red += n.get("red").doubleValue();
        }
        return red;
    }

    // JSONから緑の点数を受け取る関数
    public static double read_green(JsonNode root) {
        double green = 0.0;
        for (JsonNode n : root.get("meal")) {
            green += n.get("green").doubleValue();
        }
        return green;
    }

    // JSONから黄の点数を受け取る関数
    public static double read_yellow(JsonNode root) {
        double yellow = 0.0;
        for (JsonNode n : root.get("meal")) {
            yellow += n.get("yellow").doubleValue();
        }
        return yellow;
    }
}