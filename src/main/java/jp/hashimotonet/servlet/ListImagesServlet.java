package jp.hashimotonet.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jp.hashimotonet.action.ListImagesAction;

/**
 * サーブレット実装である ListImagesServlet クラスです。
 * 一覧画面表示機能のサーブレットです。
 *
 */
@WebServlet(description = "一覧画面サーブレットです。", urlPatterns = { "/ListImages" })
public class ListImagesServlet extends HttpServlet {

    /**
     * ロガー
     */
    private Logger log = LogManager.getLogger(ListImagesServlet.class);

    // コンパイル警告防止のため
    private static final long serialVersionUID = 1L;

    /**
     * デフォルトコンストラクタ
     *
     * @see HttpServlet#HttpServlet()
     */
    public ListImagesServlet() {
        // 親クラスのコンストラクタ呼び出し
        super();
    }

    /**
     * 疎通用メソッド
     *
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 疎通のためにクライアントへサーブレット情報を表示する
        response.getWriter().append("Served at: ").append(request.getContextPath()).append(this.getServletName());

    }

    /**
     * 一覧画面出力メソッド。
     * 当メソッドは、POSTメソッドによりコールされます。
     *
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected synchronized void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // try 節に入る
        try {
            // 一覧画面アクションをコールする。
            ListImagesAction action = new ListImagesAction();

            // アクションクラス実行メソッドをコールします。
            action.execute(request, response);
        }
            catch(Exception e)

        { // 例外発生時

            // 例外ログを出力する。
            log.catching(e);
            
            // 内部サーバーエラー(500）を返却する。
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }

        // HTTPステータスコード(200）を返却する。
        response.setStatus(HttpServletResponse.SC_OK);
    }

}
