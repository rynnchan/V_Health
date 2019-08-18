import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.*;

@WebServlet(urlPatterns={"hackU\\dist\\index.html"})
public class Get_req extends HttpServlet {
    private static final long serialVersionUID = 1l;

    @Override
    public void doPost (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            // パラメータ取得
            String param1 = req.getParameter("param1");
            String param2 = req.getParameter("param2");

            // 処理（DB呼び出し等）
            String response1 = "";
            String response2 = "";

            // 出力（レスポンスをmapに格納してJSON化）

            // JSONマップ
            Map<String, String> mapMsg = new HashMap<String, String>();

            // 追加
            mapMsg.put("response1", response1);
            mapMsg.put("response2", response2);

            // マッパ（JSON <-> Map, List）
            ObjectMapper mapper = new ObjectMapper();

            //JSON文字列
            String jsonStr = mapper.writeValueAsString(mapMsg); // list, map

            // ヘッダ設定
            res.setContentType("application/json;charset=UTF-8"); // JSON形式, UTF-8

            // pwオブジェクト
            PrintWriter pw = res.getWriter();

            // 出力
            pw.print(jsonStr);

            // クローズ
            pw.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}