/**
 * 
 */
package jp.hashimotonet.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @author hashi
 *
 */
public class DalvikAdapterUtil {

	/**
	 * プライベートコンストラクタ。外から不可視。
	 */
	private DalvikAdapterUtil() {

	}
	
	public static boolean isDalvik(HttpServletRequest request) {
		boolean myApp = false;
		String header = request.getHeader("user-agent");
		if (header.contains("Dalvik")) {
			myApp = true;
		}
		return myApp;
	}

}
