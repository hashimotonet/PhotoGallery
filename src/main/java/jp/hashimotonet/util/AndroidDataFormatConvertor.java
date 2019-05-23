/**
 *
 */
package jp.hashimotonet.util;

import org.apache.commons.codec.binary.Base64;

/**
 * @author Osamu Hashimoto
 *
 */
public class AndroidDataFormatConvertor {

    private AndroidDataFormatConvertor() {}

//    public static Bitmap convert(String base64Str) throws IllegalArgumentException
//    {
//        byte[] decodedBytes = Base64.decode(
//                base64Str.substring(base64Str.indexOf(",")  + 1),
//                Base64.DEFAULT
//        );
//
//        return BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.length);
//    }

    public static byte[] decode2Bytes(String encoded) {

        if (Base64.isBase64(encoded)) {
            return Base64.decodeBase64(encoded);
        } else {
            return null;
        }
        //return org.apache.commons.codec.binary.Base64.decodeBase64(encoded);
//        return javax.xml.bind.DatatypeConverter.parseBase64Binary(encoded);
    }

//    public static String convert(Bitmap bitmap)
//    {
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
//
//        return new Base64().encodeToString(outputStream.toByteArray());
//    }

}
