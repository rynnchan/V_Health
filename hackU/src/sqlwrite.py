import csv
import sqlite3

# MENU.dbを作成する
dbname = 'MENU.db'

# DBを表すConnectionオブジェクトをRAM上に作成して、DBに接続する。
conn = sqlite3.connect(dbname)
# DB上の処理対象の行を指し示すためのCursorオブジェクトを作成する
cur = conn.cursor()

# ごはんという名前のtableを作成する
cur.execute("""CREATE TABLE ごはん
(メニュー名 STRING,
カロリー INTEGER,
タンパク質 DOUBLE,
脂質 DOUBLE,
炭水化物 DOUBLE,
塩分 DOUBLE,
赤 DOUBLE,
緑 DOUBLE,
黄 DOUBLE);""")

# csvファイルを開く
with open('CSV\ごはん.csv', 'rt', encoding="utf-8") as f:
    b = csv.reader(f)
    header = next(b)
    for t in b:
        # tableに各行のデータを挿入する
        cur.execute('INSERT INTO ごはん VALUES (?,?,?,?,?,?,?,?,?);', t)

# DBの変更を保存する
conn.commit()

#DBとの接続を閉じる
cur.close()
conn.close()