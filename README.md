# PhotoGallery
クラウド対応画像ストアアプリ"OsaStagram"のクラウドサーバー版です。

サーバーサイドJavaの技術を駆使しており、Java歴20年に及ぶ筆者が、そのノウハウを駆使して作成を行いました。

当アプリは以下の機能によって成り立っています。

〇ログイン機能【/SignIn】

ログインでは、「サインインまたは登録」と名付けられたボタンがあり、その名称の通り、登録済みユーザであればログイン、初めてログインを行うユーザであれば、当アプリに対するユーザの登録の役割を果たします。

〇カメラ撮影機能

カメラ撮影機能では、一般に出回っている「Android Camera2Basic Sample」の機能を使用しています。
カメラが捉えた被写体と背景を自動フォーカスし、撮影ボタンをタップすることで、写っている画像の状態をファイルに保存します。
なお、当機能は、フロントエンドのAndroidの機能であり、サーバーサイドの当アプリには含まれていません。

〇撮影画像アップロード機能【/Upload】

アカウントのIDと、Base64文字列にエンコードされた画像イメージがセットされた要求電文を取得し解析を行い、データベースへの保存を行います。
画像はアカウントに紐づけられた形で格納が行われます。

DDLは当リポジトリに添付していますが、データベースの環境作成は別途行う必要があります。

〇画像一覧表示機能【/ListImages】

ログインとカメラ撮影を行い、アップロードされアカウントに紐づけられた画像イメージの一覧表示を行います。
一覧表示された画像をタップすると、撮影画像のサイズのイメージが表示されます。


なお、当プログラムは"OsaStagram"のサーバーサイドの処理を充足するものです。全体を補完する動作のためには別途提供のAndroid アプリ："OsaStagram" のようなフロントエンドアプリが必要となります。

-----------------
Osamu Hashimoto
