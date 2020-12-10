/*
 * File name:  ExampleDriver.java
 *
 * Programmer : Jake Botka
 *
 * Date: Jul 20, 2020
 *
 */
package main.org.botka.utility.api.conccurency.example;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

import main.org.botka.utility.api.conccurency.AsyncyOperation;

/**
 * <insert class description here>
 *
 * @author Jake Botka
 *
 */
public class ExampleDriver {

	static int mDownloadProgress = 0;

	/**
	 * @param command line arguements
	 */
	public static void main(String[] args) {
		test();

	}

	/**
	 * 
	 */
	public static void test() {
		File file = new File("example.txt");
		try {
			System.out.println(file.length());
			URL[] url = new URL[1];
			url[0] = file.toURL();
			AsyncTask task = new AsyncTask();
			task.execute(url);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * Async file download operation Only static cause part of driver class.
	 * 
	 * @author Jake Botka
	 *
	 */
	public static class AsyncTask extends AsyncyOperation<URL, Integer, Byte[]> {

		public AsyncTask() {

		}

		@Override
		public Byte[] executeInBackround(URL[] params) {
			System.out.println("Started");
			URL url = params[0];
			byte[] bytes = null;
			File file = new File(url.getPath());
			bytes = new byte[(int) file.length()];
			FileInputStream fileIn;
			try {
				fileIn = new FileInputStream(file);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
				return null;
			}
			int progress = 0;
			while (progress < file.length()) {
				try {
					int len = (int) file.length() / 2;
					fileIn.read(bytes, progress, len);
					progress += len;

					this.onProgressUpdate(new Integer(progress));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				}
			}
			Byte[] arr = null;
			if (bytes != null) {
				arr = new Byte[bytes.length];
				for (int i = 0; i < arr.length; i++) {
					arr[i] = new Byte(bytes[i]);
				}

			}

			return arr;

		}

		@Override
		public void onProgressUpdate(Integer progress) {
			mDownloadProgress = progress.intValue();
			System.out.println("Progress updated at: " + mDownloadProgress + "\n On thread: "
					+ this.getName());

		}

		@Override
		public Byte[] onResult(Byte[] result) {
			if (result != null) {
				System.out.println(
						"Operation completed" + "\nResult: " + String.valueOf(result.length));
			} else
				System.out.println("Completed" + "\nResult: Null");
			return result;
		}

	}

}
