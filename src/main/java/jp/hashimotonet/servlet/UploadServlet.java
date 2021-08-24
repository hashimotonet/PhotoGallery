package jp.hashimotonet.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jp.hashimotonet.action.UploadAction;

/**
 * サーブレット実装である  UploadServlet クラスです。
 */
@WebServlet(description = "画像アップロードを処理するサーブレットです。", urlPatterns = { "/Upload" })
public class UploadServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * 当クラスのロガー
     */
    private Logger log = LogManager.getLogger(UploadServlet.class);

    /**
     * Default constructor.
     */
    public UploadServlet() {
        // スーパークラスのコンストラクタ呼び出し
        super();
    }

    /**
     * 画像アップロードサーブレットである当クラスの主処理です。
     *
     * POSTメソッドによりコールされます。
     *
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 要求電文に対するキャラクタセットの指定。
        request.setCharacterEncoding("UTF-8");

        // リクエスト電文のヘッダの一覧をログ出力する。。
        //printRequestHeaders(request);

        // リクエスト電文の内容をログ出力する。
        List<String> datas = printRequestedValues(request);
        
        /*
         *  Android端末からの要求であるかについて、ユーザーエージェントにて判定。
         */
        final String USER_AGENT = "User-Agent";
        final String LINUX = "Linux;";
        final String ANDROID = "Dalvik";
        String userAgent = request.getHeader(USER_AGENT);
        int linux = userAgent.indexOf(LINUX);
        int android = userAgent.indexOf(ANDROID);

        log.debug(userAgent);
        
        // try 節に入る。
        try {

            // アップロードアクションクラスの実行メソッドをコールする。
            if (linux > 0 && android > 0) {
            	new UploadAction().execute(request);
            } else {
            	new UploadAction().executeRendering(request);
            }

            // クライアントへレスポンス返却
            sendResponse(response);

        } catch(Exception e) { // 例外発生時
            e.printStackTrace();

            // 例外ログを出力する。
            log.catching(e);

            // サーブレット返却コードに500（サーバー内部エラー）を設定する。
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            
            return;
            
        }
        
        response.setStatus(HttpServletResponse.SC_OK);
    }

    /**
     * 疎通確認用メソッド。GETメソッド呼び出しによってコールされます。
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);

        response.getWriter().println("doGet()");

    }

    protected void sendResponse(HttpServletResponse response)
            throws IOException {
        PrintWriter out = response.getWriter();
        //out.print("success");
        out.close();
        response.setStatus(HttpServletResponse.SC_OK);
    }

    /**
     * 受信電文ヘッダをINFOログ出力します。
     *
     * @param req
     */
    private void printRequestHeaders(HttpServletRequest req) {
        // 受信電文中に含まれる、電文ヘッダ名称群を取得。
        Enumeration<String> e = req.getHeaderNames();

        // 名称をNULLで初期化。
        String name = null;

        // ヘッダの要素が存在している間、ループする。
        while(e.hasMoreElements()) {
            // 名称取得。
            name = e.nextElement();

            // 値を取得。
            String value = req.getParameter(name);

            // 名称と値をログ出力する。
            log.info(name + " = " + value);

        }
    }

    /**
     *
     * 受信電文をINFOログ出力します。
     *
     * また、PhotoGalleryアプリにユニークな方式として、
     * 受信電文のVALUE部分を、List<Strig>に変換して
     * 返却します。
     *
     * @param req 受信電文
     */
    private List<String> printRequestedValues(HttpServletRequest req) {

        // Enumerationクラスに、要求電文より電文名称を取得したものをセットする。
        Enumeration<String> e = req.getParameterNames();

        // name値の初期化。
        String name = null;

        // 電文値をセットして、返却値とする値の初期化。
        List<String> result = new ArrayList<String>();

        // ログ出力
        log.info("(e != null) : " + (e != null));

        // 電文のキーバリューが存在している間、ループする。
        while(e.hasMoreElements()) {
            // 電文名称を取得
            name = e.nextElement();

            // 電文名称をログ出力
            log.info(name);

            // 電文名称より、値を取得する。
            String value = req.getParameter(name);

            // 値をログ出力。
            log.info(value);

            // 値がNULLでなければ
//            if (value != null) {
//                log.debug(value.split("\r\n").length);
//                if (value.split("\r\n").length == 3) {
//                    // 改行文字でsplit分割した、実際の値部分を取得する。
//                    value = value.split("\n")[2];
//
//                    // 値をログ出力する。
//                    log.debug(value);
//                }
//            }

            // 値を取得結果に追加する。
            result.add(value);
        }

        // 値の集合体である結果を返却する。
        return result;
    }

}
