/**
 *
 */
package jp.hashimotonet.util;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//import net.tk_factory.example.AbstractExample;


/**
* サムネイル画像を作成するサンプルプログラムです。
*
* 内容:
*

*
元のサイズの1/10のサムネイル画像を作成します。
*

*
* @author Takafumi Kondo (TK Factory)
* @see javax.imageio.ImageIO
*/
public class ExampleCreateThumbnailImage {
    /** ロガー */
    private static final Logger LOGGER = LogManager.getLogger(ExampleCreateThumbnailImage.class);

    static String EXAMPLE_FILE_DIRECTORY = "./";

    /** 入力ファイル名 */
    private static final String IN_FILE_NAME = EXAMPLE_FILE_DIRECTORY + "In.jpg";

    /** 出力ファイル名 */
    private static final String OUT_FILE_NAME = EXAMPLE_FILE_DIRECTORY + "Out.jpeg";

    /** サムネイル画像の倍率 */
    private static final double RATE = 0.125;

    /**
    * ExampleCreateThumbnailImageオブジェクトを構築すると、
    * UnsupportedOperationExceptionがスローされます。
    */
    protected ExampleCreateThumbnailImage() {
        throw new UnsupportedOperationException();
    }

    /**
    * mainメソッドです。
    *
    * @param args 引数
    */
    public static void main(String[] args) {
        try {
//            checkExistsFile(IN_FILE_NAME);
//            deleteExistsFile(OUT_FILE_NAME);

            // サムネイル画像作成
            createThumbnail(IN_FILE_NAME, OUT_FILE_NAME, RATE);
        } catch (IOException ioex) {
            ioex.printStackTrace();
        }
    }

    /**
    * サムネイル画像を作成します。
    *
    * @param inFileName 変換元の画像ファイル名
    * @param outFileName 変換後の画像ファイル名
    * @param rate 画像の倍率
    * @throws IOException 入出力エラーが発生した場合
    */
    private static void createThumbnail(String inFileName,
                                         String outFileName,
                                         double rate)
            throws IOException {
        FileOutputStream out = null;
        try {
            int index;
            String extension = "";

            // 入力ファイルの拡張子チェック
            index = inFileName.lastIndexOf(".");
            if (index != -1) {
                extension = inFileName.substring(index + 1);
            }
            if (!isReaderFormat(extension)) {
                // 読み込みがサポートされていない場合
                throw new IOException("Not Supported Reader Format!");
            }
            BufferedImage image1;
            image1 = ImageIO.read(new File(inFileName));
            if (image1 == null) {
                throw new IOException("Not Image File!");
            }

            // 元の画像の幅
            int width1 = image1.getWidth();
            LOGGER.debug("元の画像の幅=" + width1);

            // 元の画像の高さ
            int height1 = image1.getHeight();
            LOGGER.debug("元の画像の高さ=" + height1);

            // イメージ型
            int type = image1.getType();
            if (type == BufferedImage.TYPE_CUSTOM) {
                // イメージ型が不明な場合
                type = BufferedImage.TYPE_INT_RGB;
            }

            // サムネイル画像の幅
            int width2 = (int) (image1.getWidth() * rate);
            LOGGER.debug("サムネイル画像の幅=" + width2);

            // サムネイル画像の高さ
            int height2 = (int) (image1.getHeight() * rate);
            LOGGER.debug("サムネイル画像の高さ=" + height2);

            // サムネイル画像作成
            BufferedImage image2;
            image2 = new BufferedImage(width2, height2, type);
            AffineTransform at;
            at = AffineTransform.getScaleInstance(rate, rate);
            AffineTransformOp ato;
            ato = new AffineTransformOp(at, null);
            ato.filter(image1, image2);

            // 出力ファイルの拡張子チェック
            index = outFileName.lastIndexOf(".");
            if (index != -1) {
                extension = outFileName.substring(index + 1);
            }
            if (!isWriterFormat(extension)) {
                // 書き出しがサポートされていない場合
                extension = "jpg";
            }

            // サムネイル画像保存
            out = new FileOutputStream(outFileName);
            ImageIO.write(image2, extension, out);
        } catch(Exception e) {
            e.printStackTrace();

        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    /**
    * 読み込みがサポートされている画像フォーマットかどうか
    * チェックします。
    *
    * @param extension 画像ファイルの拡張子
    * @return 読み込みがサポートされている場合はtrue、そうでない場合はfalse
    */
    private static boolean isReaderFormat(String extension) {
        String[] reader = ImageIO.getReaderFormatNames();
        for (int i = 0; i < reader.length; i++) {
            if (reader[i].equalsIgnoreCase(extension)) {
                return true;
            }
        }
        return false;
    }

    /** * 書き出しがサポートされている画像フォーマットかどうか * チェックします。
    *
    * @param extension 画像ファイルの拡張子
    * @return 書き出しがサポートされている場合はtrue、そうでない場合はfalse
    */
    private static boolean isWriterFormat(String extension) {
        String[] writer = ImageIO.getWriterFormatNames();
        for (int i = 0; i < writer.length; i++) {
            if (writer[i].equalsIgnoreCase(extension)) {
                return true;
            }
        }
        return false;
    }
}