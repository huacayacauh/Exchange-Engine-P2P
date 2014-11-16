package model;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import model.p2p.Peer;
/**
 * 
 * Classe exportee du projet P2P
 * Merci a ses auteurs
 */
public class MyPublishings {


	private Peer peer;
	private MyUserProfil myUserProfil;

	ArrayList<String> myOffers  = new ArrayList<String>();
	ArrayList<String> myDemands = new ArrayList<String>();



	public MyPublishings(Peer peer, MyUserProfil myUserPorfil){

		this.peer = peer;	
		this.myUserProfil = myUserPorfil;

		try {
			readMyPublishings();
			fileIsExists(".MyDemands.data");
			fileIsExists(".MyOffers.data");
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

	public void fileIsExists(String fileName){

		File file = new File(fileName);

		if(file.exists()){
			return;
		}

		try {
			file.createNewFile();
		} catch (IOException e) {
			System.out.println("\n Le Erreur dans la création du fichier "+ fileName);
			e.printStackTrace();
		}
	}

	private void readMyPublishings() throws IOException{

		readFile(".MyOffers.data",  myOffers);
		readFile(".MyDemands.data", myDemands);

	}



	private void readFile(String path, ArrayList<String> list) throws IOException{

		BufferedReader br = new BufferedReader(new FileReader(path));
		String line;
		while ((line = br.readLine()) != null) {
			if (!list.contains(line))
				list.add(line);
		}
		br.close();	

		System.out.println(" \n Lecture initial du fichier "+ path + "terminé");		
	}



	public void postMyOffer(String ok) throws IOException{

		int id =  getID();
		String name = myUserProfil.getName();
		String mail = myUserProfil.getMail();

		String myOffer = "O"+id +":"+ok+":"+ok+":"+ name +":"+ mail;

		myOffers.add(myOffer);
		p2pPublish(ok);
		writeInFile(".MyOffers.data", myOffers); 
	}


	public void postMyDemand(String title, String description) throws IOException{

		int id = getID();

		String name = myUserProfil.getName();
		String mail = myUserProfil.getMail();

		String myDemand = "D"+id +":" +title+":"+description+":"+ name +":"+ mail;
		myDemands.add(myDemand);
		p2pPublish(myDemand);
		writeInFile(".MyDemands.data", myDemands);	 
	}


	private int getID(){

		int min = 100000;
		int max = 999999;

		int id = min + (int)(Math.random() * ((max - min) + 1));

		return id;		 
	}


	private void writeInFile(String path, ArrayList<String> PublishingList) throws IOException{

		FileWriter fw = new FileWriter(path);

		for (String s : PublishingList) {
			fw.write(s+"\n");
		}
		fw.close();
		System.out.println("Ecriture dans le fichier "+path + "terminé");	
	}


	public void displayMyOffers(){

		try {
			readMyPublishings();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("\n ***  Mes offres **** \n");
		for (String s : myOffers) {	
			System.out.println(s);
		}	 
	}


	public void displayMyDemands(){

		try {
			readMyPublishings();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("\n ***  Mes Demandes **** \n");
		for (String s : myDemands) {	
			System.out.println(s);
		}	 
	}


	private void p2pPublish(String message){ 	
		peer.sendMessage(message);	
	}




}
