import csv
import sqlite3

# DBを表すConnectionオブジェクトをRAM上に作成して、DBに接続する。
conn = sqlite3.connect(':memory:')
# DB上の処理対象の行を指し示すためのCursorオブジェクトを作成する
cur = conn.cursor()

# ごはんという名前のtableを作成する
cur.execute("""CREATE TABLE ごはん
(メニュー名 CHAR(32) NOT NULL,
カロリー INTEGER NOT NULL,
タンパク質 DOUBLE NOT NULL,
脂質 DOUBLE NOT NULL,
炭水化物 DOUBLE NOT NULL,
塩分 DOUBLE NOT NULL,
赤 DOUBLE NOT NULL,
緑 DOUBLE NOT NULL,
黄 DOUBLE NOT NULL);""")

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
conn.close()