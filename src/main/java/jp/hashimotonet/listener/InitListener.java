package jp.hashimotonet.listener;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jp.hashimotonet.dao.PhotoDao;
import jp.hashimotonet.util.FileProcessorUtil;

/**
 * PhotoGalleryサーバアプリ起動時に実行される初期化リスナークラスです。
 *
 * Application Lifecycle Listener implementation class InitListener
 *
 */
@WebListener
public final class InitListener implements ServletContextListener {

    /**
     * Logger for this class.
     */
    private Logger log = LogManager.getLogger(InitListener.class);

    /**
     * Default constructor.
     */
    public InitListener() {
        log.info("\n---PhotoGallery Server APP Started.---");
    }

    /**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce)  {

    }

    /**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    @Override
    public void contextInitialized(ServletContextEvent sce)  {

        log.info("\n---contextInitialized() Started.---");

        // DBよりファイルに落とす id の一覧を取得する。
        PhotoDao dao = null;

        try {

        	dao = new PhotoDao();

            List<String> identities = dao.getIdentities();

            ServletContext context = sce.getServletContext();

            for(String id : identities) {
            	
                // id で示されるディレクトリが存在するか？
                File parent = FileProcessorUtil.getParentDir(id, context);

                log.debug("parent = " + parent.getName());

                boolean exists = parent.exists();

                log.debug("exists = " + exists);

                // DAOクラスのインスタンスを作成
                dao = new PhotoDao();

                // IDが同一であるもののレコードの画像データを取得する
                List<byte[]> images = dao.selectPhotoBlobsById(id);

                // DAOのクローズ
                dao.close();

                // 要求電文、ID、画像データを引数に、画像の一時イメージファイル集を
                // 作成し、ファイル一覧を戻り値として取得する。
                FileProcessorUtil.writeImageById(context, id, images);

            }

        } catch(URISyntaxException | SQLException | IOException | ClassNotFoundException e ) {
            e.printStackTrace();
            log.catching(e);
        } catch(Exception e) {
        	log.catching(e);
        } finally {
        	if (dao != null) {
        		try {
					dao.close();
				} catch (SQLException e) {
					log.catching(e);
				} 
        	}
        }

        log.info("\n---contextInitialized() Ended.---");
    }
}
