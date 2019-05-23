package jp.hashimotonet.util;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.junit.jupiter.api.Test;

public class TestClass {

    @Test
    public void test() {
        File f = new File(".");
        System.out.println(f.getAbsolutePath());
        System.getProperties().list(System.out);

        String sep = FileProcessorUtil.SEP;
        System.out.println(System.getProperty("catalina.home") + sep + "webapps\\PhotoGalleryServer");

    }

    public void getRealPath(HttpServletRequest request) {
        System.out.println(request.getRealPath("/"));
    }

    @org.junit.jupiter.api.Test
    public void regex() {
        String index = "98";
        // 取得インデックスが数値であることの判定。
        Pattern p = Pattern.compile("^[0-9]+$");
        Matcher m = p.matcher(index);
        if (m.find() == true) {
            System.out.println("成功！");
        } else {
            System.out.println("失敗。。");
        }
    }

}
