package jp.hashimotonet.action;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jp.hashimotonet.dao.AccountDao;
import jp.hashimotonet.util.BaseUtil;

/**
 * サインイン処理のアクションクラスです。
 * （ログイン／アクタの権限設定など、一部未実装）
 *
 * @author Osamu Hashimoto
 *
 */
public final class SignInAction {

    /**
     * 要求電文のID
     */
    private String id;

    /**
     * 要求電文のパスワード
     */
    private String password;

    /**
     * JDBCコネクション
     */
    public Connection _conn;

    /**
     * ロガー
     */
    private Logger log = LogManager.getLogger(SignInAction.class);

    /**
     * デフォルトコンストラクタ
     */
    public SignInAction() {
        super();
    }

    /**
     * アクションである当クラスの主メソッドです。
     *
     * サインイン処理を実行します。
     *
     * @param request 要求電文
     * @param response 応答電文
     * @return boolean型である処理結果
     * @throws ServletException サーブレット例外
     * @throws IOException 入出力例外
     * @throws SQLException SQL例外
     * @throws URISyntaxException URIシンタックス例外
     * @throws ClassNotFoundException クラスが見つからない例外
     */
    public boolean execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,
                    IOException,
                    SQLException,
                    URISyntaxException,
                    ClassNotFoundException {

        // 返却値をFALSEで初期化
        boolean result = false;

        // アカウント権限。
        int authority = 0;

        // 要求電文よりIDとパスワードを取得する。
        // フロントエンドは、HttpURLConnectionでアクセスするので、#getParameter()は使えず、
        // #getInputStream()で入力ストリームより電文を解析取得する方法で対処を行う。
        InputStream is = request.getInputStream();

        // インスタンス変数に電文の内容をセット。
        getRequestParameters(is);

        // HTTPセッションを取得する。
        HttpSession session = request.getSession();

        // IDが取得できた。
        if (BaseUtil.isNotEmpty(id)) {
            // ID でアカウントマスタを検索。
            if(isAccountExists(id)) {
                // ID は存在したので、
                // ID とパスワードで、アカウントマスタを検索。
                authority = isAccountExists(id,password);

                // アカウントマスタの検索結果に、アカウント権限を取得する。
                if (authority != -1) {
                    // ここまで例外が起きていないので、処理結果はtrue。
                    result = true;
                }
            } else {
                // 新規ユーザであるので、登録処理を行う。
                createAccount(id, password);
                result = true;
            }
        }

        // セッションにIDを属性としてセットする。
        session.setAttribute("id", id);

        // 認証に成功したか。
        if (result) {
            log.warn("認証成功。");
        } else {
            log.warn("認証に失敗しました。");
        }

        // 処理結果を返却する。
        return result;
    }

    /**
     * IDによる、アカウントマスタへの存在チェックを行います。
     *
     * @param identity ID
     * @return マスタへの存在あり／なし
     * @throws SQLException SQL例外
     * @throws ClassNotFoundException クラスが見つからない例外
     * @throws IOException 入出力例外
     * @throws URISyntaxException URIシンタックス例外
     */
    private boolean isAccountExists(String identity)
            throws SQLException, ClassNotFoundException, IOException, URISyntaxException {
        boolean exists = false; // 戻り値をfalseで初期化。

        // アカウントマスタへのDAOインスタンス生成。
        AccountDao dao = new AccountDao();

        // IDによるアカウントマスタへの存在チェック。
        exists = dao.accuntExists(identity);

        // JDBC接続を閉じる。
        dao.close();

        // 存在チェック結果を返却。
        return exists;
    }

    /**
     * 要求電文をパラメータを取得し設定します。
     *
     * @param is サーブレット要求電文より取得の入力ストリーム。
     * @throws IOException 入出力例外
     */
    private void getRequestParameters(InputStream is)
            throws IOException {

        String containt = IOUtils.toString(is, Charset.defaultCharset());
        is.close();

        String[] containts = containt.split("&password=");
        this.id = containts[0].substring("id=".length());
        this.id = this.id.replace("%40", "@");

        this.password = containts[1];

        log.info("this.id = " + this.id + " : password = " + this.password);
    }

    /**
     * アカウントが存在するかを確認する。
     *
     * @param identity
     * @param password
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IOException
     * @throws URISyntaxException
     */
    private int isAccountExists(String identity, String password)
            throws SQLException, ClassNotFoundException, IOException, URISyntaxException {

        int authority = -1;

        AccountDao dao = new AccountDao();

        authority = dao.accuntExists(identity, password);

        dao.close();

        return authority;
    }

    private boolean createAccount(String identity, String password)
            throws SQLException,
                    ClassNotFoundException,
                    IOException,
                    URISyntaxException {
        boolean result = false;

        AccountDao dao = new AccountDao();
        result = dao.createAccout(identity, password);

        // アカウント作成処理は成功したか？
        if (result == true)
        { // 成功したので確定する。
            dao.commit();
        } else
        { // 作成処理に失敗したので、更新取消を行う。
            dao.rollback();
        }

        dao.close();

        return result;
    }
}
