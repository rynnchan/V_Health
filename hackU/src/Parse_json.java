import java.io.*;
// import java.net.http.HttpClient;

import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
// import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
// import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.*;

// @SuppressWarnings("deprecation")
public class Parse_json {
    public static String[] parse_json(String url, String[] key) {
        String[] list = new String[key.length];

        // StringBuilderを使って可変長の文字列を扱う
        StringBuilder builder = new StringBuilder();
        // HttpClientのインスタンスを作る（HTTPリクエストを送るために必要）
        CloseableHttpClient client = HttpClients.createDefault();
        // HttpGetのインスタンスを作る（GETリクエストを送るために必要）
        HttpGet httpget = new HttpGet(url);

        try {
            //リクエストしたリンクが存在するか確認するために、HTTPリクエストを送ってHTTPレスポンスを取得する
            HttpResponse response = client.execute(httpget);
            // 返却されたHTTPレスポンスの中のステータスコードを調べる
            // statusCodeが200だったらページが存在、404だったらNot found（ページが存在しない）。500はInternal server error。
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                // HTTPレスポンスが200なのでページが存在
                // レスポンスからHTTPエンティティ（実体）を生成
                HttpEntity entity = response.getEntity();
                // HTTPエンティティからコンテント（中身）を生成
                InputStream content = entity.getContent();

                // コンテントからInputStreamReaderを生成し、さらにBufferedReaderを作る
                // InputStreamReaderはテキストファイル（InputStream）を読み込む
                // BufferedReaderはテキストファイルを一行ずつ読み込む
                BufferedReader reader = new BufferedReader(new InputStreamReader(content));
                String line;

                // readerからreadline()で行を読み込んで、builder文字列（StringBuilderクラス）に格納していく
                while ((line = reader.readLine()) != null) {
                    builder.append(line);
                }
            } 
            else {
                System.out.println("Failed to download file");
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 文字列をJSONオブジェクトに変換する
        try {
            // JSON Arrayを作成する（文字列としてのJOSNをJSON Arrayに変換）
            // builderはStringBuilderクラスなのでtoString()で文字列に変換
            JSONArray jsonArray = new JSONArray(builder.toString());

            // JSONオブジェクトを作成する
            for (int i = 0; i < jsonArray.length(); i++) {
                // getJSONObjectでJSON Arrayに格納された要素をJSON Objectとして取得できる
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                // JSON Objectをパースする
                // getString(key)で"key"をキーとする値を取得できる
                // 入れ子になっているときは、getJSONObjectを使って階層を下っていく
                list[i] = jsonObject.getString(key[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}