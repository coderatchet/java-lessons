package org.coderatchet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileIO {
	public static void main(String[] args) {
		FileInputStream in = null;
		FileOutputStream out = null;
		BufferedReader reader = null;
		BufferedWriter writer = null;
		File outFile = null;
		try {
			outFile = new File("/home/jared/eclipse/workspace/java-lessons/src/resources/org/coderatchet/new.txt");
			if(! outFile.exists()){
				outFile.createNewFile();
			}
			reader = new BufferedReader(new InputStreamReader(new FileInputStream("/home/jared/eclipse/workspace/java-lessons/src/resources/org/coderatchet/test.txt")));
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
