package jp.hashimotonet.action;

import static jp.hashimotonet.util.InputHandler.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jp.hashimotonet.bean.URLHolder;
import jp.hashimotonet.dao.PhotoDao;
import jp.hashimotonet.util.BaseUtil;
import jp.hashimotonet.util.FileProcessorUtil;
import net.arnx.jsonic.JSON;

/**
 * 一覧表示画面のアクションクラスです。
 *
 * @author Osamu Hashimoto
 *
 */
public final class ListImagesAction {

    Logger log = LogManager.getLogger(ListImagesAction.class);

    public ListImagesAction() {
        super();
    }

    /**
     * 一覧表示画面処理における主処理を行います。
     *
     * @param request HTTP要求電文
     * @param response HTTP応答電文
     * @return 処理結果
     * @throws ClassNotFoundException クラスが見つからない例外
     * @throws SQLException SQL例外
     * @throws IOException 入出力例外
     * @throws URISyntaxException URIシンタックス例外
     * @throws ServletException サーブレット例外
     */
    public boolean execute(HttpServletRequest request,
                            HttpServletResponse response)
            throws ClassNotFoundException,
                    SQLException,
                    IOException,
                    URISyntaxException,
                    ServletException {
        // 返却値をFALSEで初期化
        boolean result = false;

        // 入力ストリーム取得。
        InputStream is = request.getInputStream();

        String req = is2String(is);

        String name = "&status=";
        String id = null;
        String status =  null;

        if (req.contains(name)) {
            id = req.substring("id=".length(), req.indexOf(name));
            status = req.substring(req.indexOf(name) + name.length());
        } else {
            id = req.substring("id=".length());
        }

        log.debug("req = " + req);

        // ログ出力する
        log.debug("id =" + id + " : status = " + status);

        // アップロードされた画像があるか判定する。
        boolean uploaded = false;
        if (BaseUtil.isNotEmpty(status)) {
            if (status.equals("uploaded")) {
                uploaded = true;
            }
        }

        // id で示されるディレクトリが存在するか？
        File parent = FileProcessorUtil.getParentDir(id, request);

        log.debug("parent = " + parent.getName());

        boolean exists = parent.exists();

        log.debug("exists = " + exists);

        // 一覧画像ファイルのファイル名群
        List<URLHolder> files = null;
//        if ((exists) && (uploaded == false)) {
        if (exists) {

            // 親ディレクトリが既に存在する場合。
            log.info("親ディレクトリが存在するので取得のみ。");

            // ディレクトリ内を走査し、存在するファイルを取得する。
            files = FileProcessorUtil.getListFiles(parent);

        }else {
            // 親ディレクトリが存在しない場合。
            log.info("親ディレクトリが存在しない。");

            // DAOクラスのインスタンスを作成
            PhotoDao dao = new PhotoDao();

            // IDが同一であるもののレコードの画像データを取得する
            List<byte[]> images = dao.selectPhotoBlobsById(id);

            // DAOのクローズ
            dao.close();

            // 要求電文、ID、画像データを引数に、画像の一時イメージファイル集を
            // 作成し、ファイル一覧を戻り値として取得する。
            files = FileProcessorUtil.writeImageById(request.getServletContext(),
                                                      id,
                                                      images);

        }

        // 画像ファイルURL群を生成。
        List<URLHolder> urls = createUrlPaths(files, request);

        // クライアントへ要求処理結果に関して応答を行う。
        PrintWriter out = response.getWriter();
        out.println("success");
        out.println(JSON.encode(urls, true));

        // 処理は成功したので、処理結果を真とする。
        result = true;

        // 処理結果を返却する。
        return result;
    }


    /**
     * 画像ファイルのURL表現群を作成し返却します。
     *
     * @param files 元となるURLファイルパス
     * @param req HTTP要求電文
     * @return JSON応答値となるリストオブジェクト
     * @throws MalformedURLException 不正なURL例外
     */
    private  List<URLHolder> createUrlPaths(List<URLHolder> files, HttpServletRequest req)
            throws MalformedURLException {

        List<URLHolder> result = new ArrayList<URLHolder>();
        URLHolder bean = new URLHolder();

      ServletContext sc = req.getServletContext();

      for(URLHolder file : files) {
          // 画像イメージのURLを生成する。
          String url = "http://"
                          + req.getServerName()
                          + ":" + req.getServerPort()
                          + sc.getContextPath()
                          + file.getUrl();
          log.debug("url    = " + url);

          // URLHolderにURLをセット。
          bean.setUrl(url);

          // サムネイルイメージのURLを生成する。
          String thumb = "http://"
                  + req.getServerName()
                  + ":" + req.getServerPort()
                  + sc.getContextPath()
                  + file.getThumbnail();
          log.debug("thumb = " + thumb);

          // URLHolderにサムネイルURLをセット。
          bean.setThumbnail(thumb);

          // 返却値であるリストに、値のセットされたURLHolderを追加。
          result.add(bean);

          // 値を追加した変数を新規インスタンスとして初期化。
          bean = new URLHolder();
      }

      // JSON応答値となるリストを返却する。
      return result;
    }

}
