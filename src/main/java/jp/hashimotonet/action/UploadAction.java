package jp.hashimotonet.action;

import static jp.hashimotonet.util.AndroidDataFormatConvertor.*;
import static jp.hashimotonet.util.FileConvertUtil.*;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jp.hashimotonet.dao.PhotoDao;
import jp.hashimotonet.model.Photo;
import jp.hashimotonet.util.FileProcessorUtil;

/**
 * 画像アップロードとデータベースへの格納を行うアクション。
 *
 * @author Osamu Hashimoto
 *
 */
public final class UploadAction {

    /**
     * 当クラスのロガー
     */
    private Logger log = LogManager.getLogger(UploadAction.class);

    /**
     * デフォルトコンストラクタ
     */
    public UploadAction() {
        // 親クラスのコンストラクタ呼び出し
        super();
    }

    /**
     * 当クラスの実行メソッド。
     * 画像データのアップロードに伴い、データベースへの格納処理を司る。
     *
     * @param request 要求電文
     * @return 処理結果
     * @throws Exception 一般例外
     */
    public boolean execute (HttpServletRequest request)
            throws Exception {

        // 戻り値をFALSEで初期化
        boolean result = false;

        // モデルクラスの生成
        Photo photo = new Photo();

        // Base64クラスの宣言をする
        String base64 = null;

        // 要求電文より入力ストリームを取得
        InputStream is = request.getInputStream();

        // 入力ストリームをバイト配列に変換する
        byte[] in = IOUtils.toByteArray(is);

        // 要求電文を複合し、格納する
        String encoded = new String(in);

        log.trace("encoded = " + encoded);

        // 要求電文を分解。
        String array[] = getRequestedParameters(encoded);

        // IDを取得する。
        String id = array[0];
        //String id = "hashimoto";

        // '@'文字はURLエンコードされているので、
        // 変換を行う。
        id = id.replace("%40", "@");

        // base64文字列を取得する。
        //base64 = array[1];
        base64 = getBase64String(encoded);

        log.info("id = " + id);

        // Base64文字列をバイト配列に複合する。後にBLOBのDB格納値となる。
        byte[] data = decode2Bytes(base64);

        // Base64文字列が空文字でなければアップロード完了
        if ((!base64.equals("")))
            log.info("アップロード完了！");
        else
            log.warn("データがアップロードされていません！");

        // モデルクラスに値をセットする。
        photo.setIdentity(id);
        photo.setAuthority(1);    // TODO クライアントの権限レベル設定は未実装
        photo.setData(data);

        // DAOクラスの宣言をする
        PhotoDao dao = null;

        // try 節に入る
        try {

            log.info("try節に入る！");

            // DAOクラスのインスタンスを作成
            dao = new PhotoDao();

            // DAOクラスの挿入メソッド実行
            int inserted = dao.insert(photo);

            // DAOでコミットを行う
            dao.commit();

            // ログ出力する
            log.info("コミット完了！");

            // インデックスの最大値を取得する。
            //int max = dao.selectMaxId();

            // ファイルを書き込む。
            String name = FileProcessorUtil.writeOneImageById(request.getServletContext(),
                                                                id,
                                                                data);

            // ログ出力する。
            log.info("ファイル書き込み完了！：" + name);

        } catch(SQLException ex) { // SQL例外発生時
            // 例外ログを出力する
            log.catching(ex);

            // DAOでロールバックを行う
            dao.rollback();

            // ログ出力する
            log.info("例外発生！ロールバックします。");

            // 例外をスローします。
            throw ex;

        } catch(Exception e) { // その他の例外発生時

            // ログ出力する
            log.catching(e);

            // DAOでロールバックを行う。
            dao.rollback();

            // ログ出力する
            log.info("例外発生！ロールバックします。");

            // 例外をスローします。
            throw e;

        } finally { // 必ず経過する処理
            // DAOのJDBC接続を閉じる
            dao.close();
        }

        // 処理結果を真とする。
        result = true;

        // 処理結果を返却する。
        return result;
    }
    
    /**
     * ブラウザからの要求の際の実行メソッドです。
     * 
     * @param request
     * @return
     * @throws IOException
     * @throws SQLException 
     */
    public boolean executeRendering(HttpServletRequest request) throws IOException, 
    																	  SQLException, 
    																	  URISyntaxException,
    																	  ClassNotFoundException {
        // 戻り値をFALSEで初期化
        boolean result = false;

        // モデルクラスの生成
        Photo photo = new Photo();

        // Base64クラスの宣言をする
        String base64 = null;

        // 要求電文より入力ストリームを取得
        InputStream is = request.getInputStream();

        // 入力ストリームをバイト配列に変換する
        byte[] in = IOUtils.toByteArray(is);

        // 要求電文を複合し、格納する
        String encoded = new String(in);

        log.trace("encoded = " + encoded);

        // IDを取得する。
        //String id = array[0];
        String id = "hashimoto";

        // '@'文字はURLエンコードされているので、
        // 変換を行う。
        //id = id.replace("%40", "@");

        // base64文字列を取得する。
        //base64 = array[1];
        base64 = getBase64String(encoded);

        log.info("id = " + id);

        // Base64文字列をバイト配列に複合する。後にBLOBのDB格納値となる。
        byte[] data = decode2Bytes(base64);

        // Base64文字列が空文字でなければアップロード完了
        if ((!base64.equals("")))
            log.info("アップロード完了！");
        else
            log.warn("データがアップロードされていません！");

        // モデルクラスに値をセットする。
        photo.setIdentity(id);
        photo.setAuthority(1);    // TODO クライアントの権限レベル設定は未実装
        photo.setData(data);

        // DAOクラスの宣言をする
        PhotoDao dao = null;

        // try 節に入る
        try {

            log.info("try節に入る！");

            // DAOクラスのインスタンスを作成
            dao = new PhotoDao();

            // DAOクラスの挿入メソッド実行
            int inserted = dao.insert(photo);

            // DAOでコミットを行う
            dao.commit();

            // ログ出力する
            log.info("コミット完了！");

            // TODO DB側でインデックスは管理するので、削除対象になる？
            // インデックスの最大値を取得する。
            //int max = dao.selectMaxId();

            // ファイルを書き込む。
            String name = FileProcessorUtil.writeOneImageById(request.getServletContext(),
                                                                id,
                                                                data);

            // ログ出力する。
            log.info("ファイル書き込み完了！：" + name);

        } catch(SQLException ex) { // SQL例外発生時
            // 例外ログを出力する
            log.catching(ex);

            // DAOでロールバックを行う
            dao.rollback();

            // ログ出力する
            log.info("例外発生！ロールバックします。");

            // 例外をスローします。
            throw ex;

        } catch(Exception e) { // その他の例外発生時

            // ログ出力する
            log.catching(e);

            // DAOでロールバックを行う。
            dao.rollback();

            // ログ出力する
            log.info("例外発生！ロールバックします。");

            // 例外をスローします。
            throw e;

        } finally { // 必ず経過する処理
            // DAOのJDBC接続を閉じる
            dao.close();
        }

        // 処理結果を真とする。
        result = true;

        // 処理結果を返却する。
        return result;
    }

    /**
     * 引数のクエリ文字列より、パラメータを抽出します。
     *
     * @param queryString 要求電文文字列
     * @return 要求電文のString配列化表現
     */
    private String[] getRequestedParameters(String queryString) {
        String result[] = new String[2];
        int begin = "id=".length();
        String delimiter = "&base64=";
        int end = queryString.indexOf("&base64=");
        int next = delimiter.length();
        String first = queryString.substring(begin, end);
        result[0] = first;
        String second = queryString.substring(end + next);
        result[1] = second;

        return result;
    }

    private String getBase64String(String src) {
        String delimiter = ",";
        if (src == null) {
        	return null;
        }
        String result = src.substring(src.indexOf(delimiter) + 1, src.lastIndexOf("\""));

        return result;
    }

    @SuppressWarnings("unused")
    private byte[] getRequestBase64String2bytes(String base64Data) {
        byte[] data = base64String2ByteArray(base64Data);
        return data;
    }

}
