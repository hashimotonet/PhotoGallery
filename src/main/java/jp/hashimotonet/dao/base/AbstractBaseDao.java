package jp.hashimotonet.dao.base;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import jp.hashimotonet.util.PropertyUtil;

public abstract class AbstractBaseDao {

    /**
     * 接続プロパティを持つファイル名
     */
    private String property = "PGatAmazonAWS.properties";

    /**
     * 接続URL
     */
    private String url;

    /**
     * 接続ユーザ
     */
    private String user;

    /**
     * 接続パスワード
     */
    private String password;

    /**
     * JDBC接続オブジェクト
     */
    private Connection conn;
    
    /**
     * MyBatisのSQLセッション
     */
    private SqlSession mybatisSession;
    
	/**
	 * 自動コミットモード
	 * Commit/Rollbackは明示的に行うため、必ず false を設定。
	 */
    private final boolean autoCommitMode = false;
    
    /**
     * 
     */
    private final boolean debug = true;
    
    public AbstractBaseDao(SqlSession sqlSession) {
    	this.mybatisSession = sqlSession;
    }

    /**
     * デフォルトコンストラクタ
     *
     * JDBCドライバをロードし、システムの
     * DB接続プロパティを取得します。
     *
     * @throws ClassNotFoundException クラスが見つからない例外
     * @throws IOException 入出力例外
     * @throws URISyntaxException URIシンタックス例外
     */
    public AbstractBaseDao()
            throws ClassNotFoundException,
            IOException,
            URISyntaxException {
        // MySQLドライバをロード
        Class.forName("com.mysql.cj.jdbc.Driver");

        // プロパティ読み込みユーティリティを起動
        PropertyUtil util = new PropertyUtil(property);

        // データベース接続に必要なプロパティ読み込み
        this.url = util.get("URL"); // URLを取得
        this.user = util.get("USER"); // ユーザ名を取得
        this.password = util.get("PASSWORD"); // パスワードを取得
    }
    
    public synchronized SqlSession openSession() {
    	
    	try {
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(new InputStreamReader(Resources.getResourceAsStream("mybatis-config.xml")));
            mybatisSession = sqlSessionFactory.openSession(debug);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return mybatisSession;
    }

    /**
     * JDBC接続を取得するメソッド
     *
     * @return JDBC接続
     * @throws SQLException SQL例外
     */
    public Connection getConnection()
            throws SQLException {
        // JDBC接続を取得
        this.conn = DriverManager.getConnection(url, user, password);

        // 自動コミットモードはOFFにする
        this.conn.setAutoCommit(false);

        // オープンしたJDBC接続を返却する
        return conn;
    }
    
    /**
     * JDBCセッションをコミットします。
     * 
     * @param session
     */
    public void commit(SqlSession session) {
    	if (session != null) {
    		session.commit(true);
    	}
    }

    /**
     * JDBC接続をコミットします。
     *
     * @throws SQLException SQL例外
     */
    public void commit()
            throws SQLException {

        // 接続をコミットします
        this.conn.commit();

    }
    
    /**
     * JDBCセッションをロールバックします。
     * 
     * @param session
     */
    public void rollback(SqlSession session) {
    	if (session != null) {
    		session.rollback(false);
    	}
    }

    /**
     * JDBC接続をロールバックします。
     *
     * @throws SQLException SQL例外
     */
    public void rollback()
            throws SQLException {

        // 接続をロールバックします
        this.conn.rollback();

    }

    /**
     * JDBC接続をクローズし、リソースを解放します
     *
     * @throws SQLException SQL例外
     */
    public void close()
            throws SQLException {

    	if (this.conn != null) {
            // 接続をクローズします
            this.conn.close();
    	}
    }

    /**
     * JDBCセッションをクローズします。
     * 
     * @param session
     */
    public void close(SqlSession session) {
    	if (session != null) {
    		session.close();
    	}
    	
    	if (this.mybatisSession != null) {
    		this.mybatisSession.close();
    	}
    }
    
    /**
     * デストラクタです。
     */
    @Override
    public void finalize()
            throws SQLException {
    	close();
    	close(this.mybatisSession);
    }

}
