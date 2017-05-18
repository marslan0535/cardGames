package domain;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class DataAccessLayer {
private static DataAccessLayer instance = new DataAccessLayer();
	
	public DataAccessLayer(){ }
	
	public static DataAccessLayer getInstance() {
		return instance;
	}
	
	public void writeFile(String fileName, String text) throws Exception{
		
		String name = new String(fileName+".txt"); 
		
		BufferedWriter writeResult = new BufferedWriter(new FileWriter(name));
		writeResult.write(text);
		writeResult.close();

		System.out.println("Game Result Written to "+name);
	}
}
