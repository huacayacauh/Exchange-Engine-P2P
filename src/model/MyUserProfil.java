package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import model.p2p.Peer;
/**
 * 
 * Classe exportee du projet P2P
 * Merci a ses auteurs
 */

public class MyUserProfil {

	private String name;
	private String mail;


	public MyUserProfil(Peer peer) {

		try {
			checkProfil();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}



	public void setName(String name){	
		this.name = name;
		try {
			writeInUserProfil();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setMail(String mail){
		this.mail = mail;

		try {
			writeInUserProfil();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getName(){
		return name;
	}

	public String getMail(){
		return mail;
	}




	public String scan(String message){

		System.out.println(message);

		String string = null;
		BufferedReader bufferRead = null;
		bufferRead = new BufferedReader(new InputStreamReader(System.in));  

		try {
			string = bufferRead.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return string;
	}


	public boolean checkProfil() throws IOException{

		File file = new File(".UserProfil.config");

		if (!file.exists()) {
			System.out.println("\nLe fichier .UserProfil est absent");
			file.createNewFile();
			System.out.println("\nCréation du fichier .UserProfil terminée");
		}

		FileReader fileReader = new FileReader(".UserProfil.config");
		BufferedReader br     = new BufferedReader(fileReader);     

		if (br.readLine() == null) {
			editUserProfil();  	
		}

		readUserProfil(fileReader);

		return true;

	}


	private void readUserProfil(FileReader file) throws IOException{

		String line;

		BufferedReader x = new BufferedReader(new FileReader(".UserProfil.config"));

		while((line = x.readLine()) != null) {
			System.out.println("line 1: " + line); 
			String arr[] = line.split(" ", 2);
			name = arr[0];
			mail = arr[1];
			System.out.println( "\n Profil utilisateur: "+ name + " " + mail);
		}	

		x.close();
	}

	public void editUserProfil() throws IOException{

		name = scan("entrer un nom: ");	
		mail = scan("entrer une adresse e-mail: ");

		writeInUserProfil();

	}


	private void writeInUserProfil() throws IOException{

		String content = name + " " + mail ;
		System.out.println("Edition du Profil: "+ content);
		File file = new File(".UserProfil.config"); 

		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("");
		bw.write(content);
		bw.close();

		System.out.println("\n Edition du profil terminée");		
	}

}
