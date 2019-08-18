function sampleAjax() {
    // リクエストJSON
    var request = {
        param1 : "param",
        param2 : 12345
    };
    
    // ajaxでservletにリクエストを送信
    $.ajax({
        type    : "GET",          // GET / POST
        url     : "hackU\\dist\\index.html",  // 送信先のServlet URL
        data    : request,        // リクエストJSON
        async   : true,           // true：非同期（デフォルト）、false：同期
        success : function(data) {
            // 通信が成功した場合に受け取るメッセージ
            response1 = data["response1"];
            response2 = data["response2"];
        },
        error : function(XMLHttpRequest, textStatus, errorThrown) {
            alert("リクエスト時に何らかのエラーが発生しました：" + textStatus + ":\n" + errorThrown);
        }
    });
}