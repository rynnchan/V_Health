import java.io.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

public class Read_json{
    public JsonNode root;

    Read_json(String filename){
        try {
            File json = new File(filename);
            ObjectMapper mapper = new ObjectMapper();
            this.root = mapper.readTree(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
    // JSONから摂取タンパク質を受け取る関数
    public static double read_protein(JsonNode root) {
        double protein=0.0;
        for (JsonNode n : root.get("meal")) {
            protein += n.get("protein").doubleValue();
        }
        return protein;
    }
    // JSONから摂取脂質を受け取る関数
    public static double read_lipid(JsonNode root) {
        double lipid=0.0;
        for (JsonNode n : root.get("meal")) {
            lipid += n.get("lipid").doubleValue();
        }
        return lipid;
    }
    // JSONから摂取炭水化物を受け取る関数
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

    // JSONから赤の点数を受け取る関数
    public static double[] read_color(JsonNode root) {
        double[] color = {read_red(root),read_green(root),read_yellow(root)};
        return color;
    }

    // JSONから摂取カロリーの平均を受け取る関数
    public static double read_ave_calorie(JsonNode root){
        double ave_calorie = root.get("ave_calorie").doubleValue();
        return ave_calorie;
    }

    // JSONから摂取タンパク質の平均を受け取る関数
    public static double read_ave_protein(JsonNode root){
        double ave_protein = root.get("ave_protein").doubleValue();
        return ave_protein;
    }

    // JSONから摂取脂質の平均を受け取る関数
    public static double read_ave_lipid(JsonNode root){
        double ave_lipid = root.get("ave_lipid").doubleValue();
        return ave_lipid;
    }

    // JSONから摂取炭水化物の平均を受け取る関数
    public static double read_ave_carbohydrate(JsonNode root){
        double ave_carbohydrate = root.get("ave_carbohydrate").doubleValue();
        return ave_carbohydrate;
    }

    // JSONから摂取塩分の平均を受け取る関数
    public static double read_ave_salt(JsonNode root){
        double ave_salt = root.get("ave_salt").doubleValue();
        return ave_salt;
    }

    // JSONから赤の点数の平均を受け取る関数
    public static double read_ave_red(JsonNode root){
        double ave_red = root.get("ave_red").doubleValue();
        return ave_red;
    }

    // JSONから緑の点数の平均を受け取る関数
    public static double read_ave_green(JsonNode root){
        double ave_green = root.get("ave_green").doubleValue();
        return ave_green;
    }

    // JSONから黃の点数の平均を受け取る関数
    public static double read_ave_yellow(JsonNode root){
        double ave_yellow = root.get("ave_yellow").doubleValue();
        return ave_yellow;
    }

    // JSONから開始時期を受け取る関数
    public static int read_start(JsonNode root){
        int start = root.get("start").intValue();
        return start;
    }

    // JSONから書き込んだ日付を受け取る関数
    public static int read_today(JsonNode root){
        int today = root.get("today").intValue();
        return today;
    }
}