import java.sql.*;
import java.util.*;
import java.io.*;

public class Write {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection connection = null;
        try {
            // 読み込む対象のデータ
            String csv = args.length>0 ? args[0] : "../../CSV/ごはん.csv";
            // テーブル名の指定
            String table = args.length>0 ? args[1] : "ごはん";

            // sample.dbに書き込む
            connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // もしテーブルが作成されてなかったら作成する
            statement.executeUpdate("create table if not exists " + table + " (name string, calorie integer, protein double, lipid double, carbohydrate double, salt double, red double, green double, yellow double)");
            
            try {
                // sqliteのデータベースに格納予定のデータセット
                FileInputStream fis = new FileInputStream(new File(csv));
                InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
                BufferedReader br = new BufferedReader(isr);
                String line = ""; // 一行ずつ読み込む
                String insert = ""; // insertする文
                boolean header = true; // ヘッダーフラグ

                while ((line = br.readLine()) != null) {
                    StringTokenizer token = new StringTokenizer(line , ",");
                    int column_queue = 0; // 何カラム存在するか

                    while (token.hasMoreTokens()) {
                        String tmpString = token.nextToken();
                        System.out.println(tmpString);
                        
                        if (column_queue == 0) {
                            insert += "\'" + tmpString + "\', ";
                        }
                        else {
                            insert += tmpString + ", ";
                        }
                    }
                    if (header) {
                        header = false;
                    }
                    else {
                        insert = insert.substring(0, insert.length() - 2);
                        insert = "insert of replace into " + table + " values(" + insert + ")";
                        System.out.println(insert);
                        statement.executeUpdate(insert);
                    }

                    insert = "";
                    System.out.println("----------------------------------------------");
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // 結果の確認
            ResultSet rs = statement.executeQuery("select * from " + table);
            while (rs.next()) {
                System.out.println("\t" + rs.getString("name") + "\t" + rs.getInt("calorie") + "\t" + rs.getDouble("protein") + "\t" + rs.getDouble("lipid") + "\t" + rs.getDouble("carbohydrate") + "\t" + rs.getDouble("salt") + "\t" + rs.getDouble("red") + "\t" + rs.getDouble("red") + "\t" + rs.getDouble("green") + "\t" + rs.getDouble("yellow"));
            }
        } catch (SQLException e) {
            System.err.println("exception :" + e.getMessage());
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
}