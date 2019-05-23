package jp.hashimotonet.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

import org.junit.jupiter.api.Test;


public class FileConvertUtilTest {

    final String submitted = "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";

    @Test
    public void testBase64ByteArray2Binary() {
        byte[] data = Base64.getMimeDecoder().decode(submitted);
        writeFile(data);

    }

    private void writeFile(byte[] b) {
        //ファイルオブジェクト作成
        FileOutputStream fileOutStm = null;
        try {
            fileOutStm =
                    new FileOutputStream("out.jpg");
        } catch (FileNotFoundException e1) {
            System.out.println("ファイルが見つからなかった。");
        }
        try {
            fileOutStm.write(b);
        } catch (IOException e) {
            System.out.println("入出力エラー。");
        }
        System.out.println("終了");	}

}
