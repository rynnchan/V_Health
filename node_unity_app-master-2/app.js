const express = require('express')
const app = express()
const bodyParser = require('body-parser')
const fs = require('fs')
var userData = require('./json/data.json')

app.use(bodyParser.urlencoded({ extended: true }))
app.use(bodyParser.json())
 
app.use('/', express.static('public/dist'))

// ルーティング設定
//app.use('/', require('./routes/index.js'));


/*
app.use('/',function(req,res){
    res.json()
})
*/


//./json/data.jsonを送られたデータで書き換える
app.post('/urlServlet', function (req, res) {
    console.log(req.body)
    fs.writeFile('./json/data.json',JSON.stringify(req.body),(err)=>{
        if(err){
            console.log("エラーが発生しました。")
            throw err
        }
        else{
            console.log("ファイル書き出しに成功しました")
        }
    })

})


//./json/data.jsonを送る
app.post('/hackU', function(req,res){
    var json = JSON.parse(fs.readFileSync('./json/data.json'));
    console.log(JSON.stringify(json))
    res.json(json)
})
  


app.listen(8080); 
console.log('Server running at http://localhost:8080')
