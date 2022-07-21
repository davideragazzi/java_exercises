package it.beije.ragazzi.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import it.beije.ragazzi.database.Utente;


public class CSVmanager {

	public static List<Utente> readCSV(String path) {
		
//		File file = new File("/temp/rubrica.csv");
//		System.out.println("path: " + file.getAbsolutePath());
//		System.out.println("exist? " + file.exists());

		FileReader reader = null;
		BufferedReader bufferedReader = null;
		List<Utente> utenti = new ArrayList<Utente>(); 
		try {
			//FileReader reader = new FileReader(file);
			//reader = new FileReader("rubrica.csv");
			//reader = new FileReader("prova.txt");
			reader = new FileReader(path);
			
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
			
			List<String> rows = new ArrayList<String>(); 
			bufferedReader = new BufferedReader(reader);
			while (bufferedReader.ready()) {
				String r = bufferedReader.readLine();
				System.out.println(r);
				rows.add(r);
			}
			

			Utente u = null;
			String[] cols = null;
			for (String r : rows) {
//				StringTokenizer tokenizer = new StringTokenizer(r, ";");
//				while (tokenizer.hasMoreTokens()) {
//					System.out.println(tokenizer.nextToken());
//				}
				
				cols = r.split(";");
//				for (String c : cols) System.out.println("-> " + c);
				u = new Utente();
				u.setNome(cols[0]);
				u.setTelefono(cols[1]);
				u.setEmail(cols[2]);
				utenti.add(u);
			}			
			
		
		} catch (FileNotFoundException fnfEx) {
			fnfEx.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				bufferedReader.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return utenti;
	}
	
	
	public static void writeCSV(List<Utente> rubrica, String path) {
		
		File file = new File(path);
		System.out.println("path: " + file.getAbsolutePath());
		System.out.println("exist? " + file.exists());
		
		//if (file.exists()) throw new RuntimeException("file già esistente"); 

		FileWriter writer = null;
		
		try {
			writer =  new FileWriter(file);
			
			StringBuilder row = null;
			for (Utente utente : rubrica) {
				row = new StringBuilder()
						.append(utente.getNome() != null ? utente.getNome() : "").append(';')
						.append(utente.getCognome() != null ? utente.getCognome() : "").append(';')
						.append(utente.getTelefono() != null ? utente.getTelefono() : "").append(';')
						.append(utente.getEmail() != null ? utente.getEmail() : "").append(';')
						.append('\n');
				
				writer.write(row.toString());
			}
			
			writer.flush();
			
		} catch (FileNotFoundException fnfEx) {
			fnfEx.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {

		List<Utente> rubrica = readCSV("rubrica.csv");
		
		writeCSV(rubrica, "rubrica.txt");
	}

}
