package bde;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

public class BaseFunction {

	public static void specifiyTextualLocation(String tableName, String keyName, String fileLocation) {
		
		BdeEntry.fileLocation = fileLocation;
		BdeEntry.T = tableName;
		BdeEntry.c = keyName;
	}
	
	public static void addText(String t, String c) throws Exception {
		
	    PrintWriter writer = new PrintWriter(BdeEntry.fileLocation+"/"+c+".txt", "UTF-8");
	    writer.println(t);
	    writer.close();
	}
	
}
