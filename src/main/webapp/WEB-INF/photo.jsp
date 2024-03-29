<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" session="true" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="css/bootstrap.css" />
  <title>カメラ撮影画面</title>
</head>
<body>
	<div align="center">
		<h1>PhotoGallery</h1>
		<h5>カメラ撮影画面</h5>
	</div>
	<hr/>
    <!-- カメラ映像が描画されます。 -->
    <div align="center">
      <video id="video_area" style="background-color: #000"  width="480" height="320" autoplay></video>
    </div>

    <!-- キャプチャした静止画が描画されます。 -->
    <canvas id="capture_image" width="480" height="320" style="width:240px;"></canvas><br/>
    <label for="alt_text">Please insert a comment here.</label>
    <input id="alt_text" width="400" />
    <div align="center">
	    <!-- 押下するとカメラ映像描画を開始します。 -->
	    <button id="start_btn" class="btn btn-primary btn-sm">映像表示開始</button>
	
	    <!-- 押下するとカメラ映像から静止画をキャプチャします。 -->
	    <button onclick="copyFrame()" class="btn btn-primary btn-sm">静止画取得</button>
	    
	    <p>

    <form id="frm" name="frm">
    
        <input type="hidden" id="id" name="id" value="<%= request.getAttribute("id") %>" />
        <% request.setAttribute("id", request.getAttribute("id")); %>
        <button type="button" id="btn-send" class="btn btn-primary btn-sm">サーバへ保存</button>
        
        <button type="button" id="btn-disp" class="btn btn-primary btn-sm">一覧画面表示</button>
    </form>
      </div>

</body>
<script type="text/javascript">

    // getUserMedia が使えないときは、『getUserMedia()が利用できないブラウザです！』と言ってね。
    if (typeof navigator.mediaDevices.getUserMedia !== 'function') {
        const err = new Error('getUserMedia()が利用できないブラウザです！');
        alert(`${err.name} ${err.message}`);
        throw err;
    }

    // 操作する画面エレメント変数定義します。
    const $start = document.getElementById('start_btn');   // スタートボタン
    const $video = document.getElementById('video_area');  // 映像表示エリア

    // 「スタートボタン」を押下したら、getUserMedia を使って映像を「映像表示エリア」に表示してね。
    $start.addEventListener('click', () => {
        navigator.mediaDevices.getUserMedia({ video: true, audio: false })
        .then(stream => $video.srcObject = stream)
        .catch(err => alert(`${err.name} ${err.message}`));
    }, false);

	// 静止画画像
    var canvas_capture_image;

    // 「静止画取得」ボタンが押されたら「<canvas id="capture_image">」に映像のコマ画像を表示します。
    function copyFrame() {

        canvas_capture_image = document.getElementById('capture_image');
        var cci = canvas_capture_image.getContext('2d');
        var va = document.getElementById('video_area');

        canvas_capture_image.width  = va.videoWidth;
        canvas_capture_image.height = va.videoHeight;
        cci.drawImage(va, 0, 0);  // canvasに『「静止画取得」ボタン』押下時点の画像を描画。
    }

  //---------------------------------------------
 // 定数定義
 //---------------------------------------------
 // 保存を行うプログラムがあるURL
 const SAVE_URL = 'Upload';
//---------------------------------------------
//[event] ページ読み込み完了
//---------------------------------------------
window.onload = ()=>{

    //---------------------------------------------
    // 保存ボタンが押されたらサーバへ送信する
    //---------------------------------------------
    document.querySelector("#btn-send").addEventListener("click", ()=>{

      //alert("サーバー送信処理");

      //alert(eval(document.getElementById("capture_image")));

      // Canvasなどのデータを取得
      const canvas = document.getElementById("capture_image").toDataURL("image/png");  // DataURI Schemaが返却される
      const id =document.getElementById("id").value;
      var    alt=document.getElementById("alt_text").value;
      
      if( !checkLettersPermitted(alt) ) {
    	  alert("Please write a comment in English.\r\n入力は半角英数で行ってください。");
    	  document.getElementById("alt_text").forcus();
    	  return;
      }

      const json = {
    		  "id":id,
    		  "alt":alt,
    		  "data":canvas
      };
      
      //alert(eval(json));

      // 送信情報の設定
      const param  = {
        method: "POST",
        headers: {
          "Content-Type": "application/json; charset=utf-8"
        },
        //body: JSON.stringify({data: canvas})
        body: JSON.stringify(json)
      };

      // サーバへ送信
      sendServer(SAVE_URL, param);
    });

   document.querySelector("#btn-disp").addEventListener("click", ()=>{
	   document.frm.action="ListImages";
	   document.frm.method="post";
	   document.frm.submit();
   });

};


  /**
   * 半角英数チェック。
  */
  function checkLettersPermitted(str){
    str = (str==null)?"":str;
    if(str.match(/^[a-zA-Z0-9!-/:-@¥[-`{-~\s]*$/)){
    	return true;
    }else{
	    return false;
	  }
  }

  /**
   * サーバへJSON送信
   *
   * @param url   {string} 送信先URL
   * @param param {object} fetchオプション
   */
  function sendServer(url, param){
    fetch(url, param)
      .then((response)=>{
        return response;
      })
      .then((response)=>{
        if(response.status){
          alert("送信に『成功』しました");
          //setImage(json.result);    //json.resultにはファイル名が入っている
        }
        else{
      	  console.log(response.status);
          alert("送信に『失敗』しました");
          console.log(`[error1] ${json.result}`);
        }
      })
      .catch((error)=>{
        alert("送信に『失敗』しました");
        console.log(`[error2] ${error}`);
      });
  }
</script>

</html>
