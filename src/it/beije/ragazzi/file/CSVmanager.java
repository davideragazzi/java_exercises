package it.beije.ragazzi.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CSVmanager {

	public static void main(String[] args) {

//		File file = new File("/temp/rubrica.csv");
//		System.out.println("path: " + file.getAbsolutePath());
//		System.out.println("exist? " + file.exists());

		FileReader reader = null;
		BufferedReader bufferedReader = null;
		List<String> rows = new ArrayList<String>(); 
		try {
			//FileReader reader = new FileReader(file);
			//reader = new FileReader("rubrica.csv");
			reader = new FileReader("prova.txt");
			
			/*StringBuilder row = new StringBuilder();
			int c = reader.read();
			while (c >= 0) {
				//System.out.print((char) c);
				
				if ((char) c == '\n') {
					System.out.println("row : " + row.toString());
					//rows.add(row.toString());
					row = new StringBuilder();					
				} else {
					row.append((char) c);
				}
				
				c = reader.read();
			}*/
			
			bufferedReader = new BufferedReader(reader);
			while (bufferedReader.ready()) {
				String r = bufferedReader.readLine();
				System.out.println(r);
				rows.add(r);
			}
			

			for (String r : rows) {
//				StringTokenizer tokenizer = new StringTokenizer(r, ";");
//				while (tokenizer.hasMoreTokens()) {
//					System.out.println(tokenizer.nextToken());
//				}
				
				String[] cols = r.split("\";\"");
				for (String c : cols) System.out.println(c);
			}			
			
		
		} catch (FileNotFoundException fnfEx) {
			fnfEx.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
