/*
  uid, data1, data2, ...と並んだCSVファイルから，uidからdata3までをSqliteのデータベースへ書き込む    
  uidは一意な値として作成し，同一のuidならば上書きされる
*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.io.*;

public class Csv2Sqlite
{
  public static void main(String[] args) throws ClassNotFoundException
  {
  // load the sqlite-JDBC driver using the current class loader
    Class.forName("org.sqlite.JDBC");
    Connection connection = null;
    try
    {
      // 読み込む対象のデータ
      String csv = args.length>0 ? args[0] : "../../CSV/ごはん.csv";
      // テーブル名の指定
      String table = args.length>0 ? args[1] : "test"; //テーブル名の選択

      // create a database connection
      // sample.dbに書き込む
      connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
      Statement statement = connection.createStatement();
      statement.setQueryTimeout(30);  // set timeout to 30 sec.
    
      // もしテーブルが作成されてなければ，作成する
      statement.executeUpdate("create table if not exists "+table+" (uid integer UNIQUE, url string, contents string, value string)");

      try
      {
        //sqliteのデータベースに格納予定のデータセット
        FileInputStream fis = new FileInputStream(new File(csv));
        InputStreamReader isr = new InputStreamReader(fis , "UTF-8");
        BufferedReader br = new BufferedReader(isr);       
        String line = ""; //一行ずつ読み込む
        String insert = ""; //insertする文
        boolean header = true; //ヘッダーフラグ

        while((line = br.readLine()) != null)
        {
          StringTokenizer token = new StringTokenizer(line, ",");
          int column_queue = 0; //何カラム存在するか

          while(token.hasMoreTokens())
          {
            String tmpString = token.nextToken();
            System.out.println(tmpString);            
            if(column_queue==0) //1列目のuidは整数なのでクォーテーション使わない  
            {
              insert += tmpString + ", ";
            }          
            else if(column_queue<=3)
            {
              insert += "\'" + tmpString + "\', ";
            }
            column_queue++;
          }
          
          if(column_queue<4) //4カラム存在しない場合は'null'で埋める
          {          
            while(column_queue<4)
            {
              insert += "\'null\', ";
              column_queue++;
            } 
          }
          
          if(header) //ヘッダーはinsertしない
          { 
           header = false; 
          }
          else
          {
            insert = insert.substring(0,insert.length()-2);//最後の","までを削除した文            
            insert ="insert or replace into "+table+" values("+insert+")";        
            System.out.println(insert); //insert内容を確認する
            statement.executeUpdate(insert); //insert実行
          }
        
          insert = "";//中身をカラにする
          System.out.println("------------------------------"); //区切り
        }
      } 
      catch (FileNotFoundException e)
      {
        e.printStackTrace();
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }

      // 結果の確認
      ResultSet rs = statement.executeQuery("select * from "+table);
      while(rs.next())
      {
        //read the result set
        System.out.println("\t"+rs.getString("uid")+"\t"+rs.getString("url")+"\t"+rs.getString("contents")+"\t"+rs.getString("value"));
      } 

    }
    catch(SQLException e)
    {
      // if the error message is "out of memory",
      // it probably means no database file is found
      System.err.println("exception :"+e.getMessage());
    }
    finally
    {
      try
      {
        if(connection != null) connection.close();
      }
      catch(SQLException e)
      {
        // connection close failed.
        System.err.println(e);
      }
    }
  }
}