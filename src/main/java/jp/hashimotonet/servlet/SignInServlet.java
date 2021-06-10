package jp.hashimotonet.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jp.hashimotonet.action.SignInAction;

/**
 * サーブレット実装である SignInServlet クラスです。
 */
@WebServlet(description = "サインインのサーブレットです。", urlPatterns = { "/SignIn" })
public final class SignInServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * ロガー
     */
    private Logger log = LogManager.getLogger(SignInServlet.class);

    /**
     * デフォルトコンストラクタ。
     *
     * @see HttpServlet#HttpServlet()
     */
    public SignInServlet() {
        // 親クラスのコンストラクタ呼び出し
        super();
    }

    /**
     * 主に疎通確認を行うメソッドです。
     *
     * GETメソッドによりコールされます。
     *
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 疎通のためにクライアントへサーブレット情報を表示する
        response.getWriter().append("Served at: ").append(request.getContextPath());

    }

    /**
     * 当サーブレットの主メソッドです。
     *
     * POSTメソッドによる呼び出しによりコールされます。
     *
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String id = request.getParameter("id");
    	
    	// tryブロックに入ります
        try {

            // サインインのアクションをコールします。
            SignInAction action = new SignInAction();

            // アクションの実行メソッドをコールします、
            boolean result = action.execute(request, response);

            // アクションの実行結果がFALSEであるか
            if (result == false) {    // FALSEであれば
                // 例外をスローします。
                throw new Exception("Actionで false が返却されました。");
            } else {
                response.sendRedirect("/photo.jsp?id=" + id);
            }

        } catch(Exception e) {    // 例外である場合
            // 例外メッセージをログ出力します。
            log.catching(e);

            // サーブレット返却コードに401（認証失敗）を設定する。
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

            // 主処理に失敗
            doGet(request, response);
        }
        
        // HTTPステータスコードに400を設定。
        response.setStatus(HttpServletResponse.SC_OK);

    }

}
