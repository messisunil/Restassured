package com.GenericLibraries;

import java.util.Random;
/**
 * this class consists of java libraries.
 * @author sunil
 *
 */
public class JavaLibraries {

	/**
	 * this method is used to generate random number.
	 * @param limit
	 * @return
	 */
	public int randomNumber(int limit) {
		Random ran = new Random();
		return ran.nextInt(limit);
	}
}
