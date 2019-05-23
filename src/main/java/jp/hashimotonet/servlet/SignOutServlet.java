package jp.hashimotonet.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * サーブレット実装であるSignOutServletクラスです
 */
@WebServlet(description = "サインアウトのサーブレットです", urlPatterns = { "/SignOut" })
public class SignOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignOutServlet() {
    	// 親クラスのコンストラクタ呼び出し
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// サインインからのセッションを破棄する。
		request.getSession().invalidate();

		// クライアントにサインアウトの旨を通知。
		response.getWriter().println("Signed out.");

		// 当メソッドの処理を終える。
		return;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		doPost(request, response);
	}



}
