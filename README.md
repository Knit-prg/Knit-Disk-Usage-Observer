# KDUO(Knit Disk Usage Observer)

ただただストレージの使用容量を表示し続けるだけのシンプルなプログラムです。

## 使用方法
1. https://github.com/Knit-prg/Knit-Disk-Usage-Observer/releases からjarファイルをダウンロード
2. `java -jar KDUO-(バージョン).jar`(jarダブルクリックでは動かないので注意)

## オプション
少なくともWindowsでは、`java -jar KDUO-(バージョン).jar (ドライブレター)`とすると指定したドライブレターの使用容量を表示します。何も指定しない場合はjarファイルのあるドライブになります。<br>
Windows以外については、持ってないので正直分かりません。許してくださいお願いします何でもしますから(何でもするとは言っていない)

## コンパイル方法
`gradle build jar`