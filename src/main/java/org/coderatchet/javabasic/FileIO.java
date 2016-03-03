package org.coderatchet.javabasic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileIO {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader reader = null;
		BufferedWriter writer = null;
		File outFile = null;
		File inFile = null;
		try {
			outFile = new File("data/new.txt");
			outFile.getParentFile().mkdirs();
			outFile.createNewFile();
			System.out.println(outFile.getAbsolutePath());
			inFile = new File("data/test.txt");
			inFile.getParentFile().mkdirs();
			System.out.println(inFile.getPath());
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(inFile.getPath())));
			writer = new BufferedWriter(new FileWriter(outFile));
			
			String line;
			for (line = reader.readLine(); line != null; line = reader.readLine()) {
				writer.append(line);
			};
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(reader != null) {
				try {
					reader.close();
				} catch (IOException ignore) {
				}
			}
			if(writer != null) {
				try {
					writer.close();
				} catch (IOException ignore) {
				}
			}
		}
	}
}
