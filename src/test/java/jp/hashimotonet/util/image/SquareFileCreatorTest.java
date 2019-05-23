/**
 *
 */
package jp.hashimotonet.util.image;

import java.io.IOException;

import org.junit.jupiter.api.Test;

/**
 * @author user
 *
 */
public class SquareFileCreatorTest {

    SquareFileCreator target;

    /**
     * {@link jp.hashimotonet.util.image.SquareFileCreator#createSqueare()} のためのテスト・メソッド。
     */
    @Test
    public void testCreateSqueare() {
        target = new SquareFileCreator("test.jpg", "test_after.jpg");
        try {
            target.createSqueare();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

}
