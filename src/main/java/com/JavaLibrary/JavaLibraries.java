package com.JavaLibrary;

import java.util.Random;

public class JavaLibraries {

	public int randomNumber(int limit) {
		Random ran = new Random();
		int value = ran.nextInt(limit);
		return value;
	}
}
