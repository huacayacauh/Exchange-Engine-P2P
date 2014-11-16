package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
/**
 * 
 * Classe exportee du projet P2P
 * Merci a ses auteurs
 */
public class MySearchs {


	ArrayList<String> publishing;

	public MySearchs() {

		this.publishing = new ArrayList<String>();
		try {

			fileIsExists(".MarketPlace.data");
			readMarket();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public ArrayList<String> getMyOffers() throws IOException{

		ArrayList<String> myOffers = new ArrayList<String>();

		BufferedReader br = new BufferedReader(new FileReader(".MyOffers.data"));
		String line;
		while ((line = br.readLine()) != null) {
			//if (!myOffers.contains(line))
			myOffers.add(line);
		}
		br.close();	

		return myOffers;	
	}

	public ArrayList<String> getMyDemands() throws IOException{

		ArrayList<String> myDemands = new ArrayList<String>();

		BufferedReader br = new BufferedReader(new FileReader(".MyDemands.data"));
		String line;
		while ((line = br.readLine()) != null) {
			//if (!myOffers.contains(line))
			myDemands.add(line);
		}
		br.close();	

		return  myDemands;	
	}


	public void readMarket() throws IOException{


		BufferedReader br = new BufferedReader(new FileReader(".MarketPlace.data"));
		String line;
		while ((line = br.readLine()) != null) {
			publishing.add(line);
		}
		br.close();	
	}



	public void update(String message) throws IOException{

		publishing.add(message);

		ArrayList<String> myOffers = null;
		ArrayList<String> myDemands = null;

		try {
			myOffers = getMyOffers();
			myDemands = getMyDemands();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (myOffers.contains(message)){
			return;
		}

		if (myDemands.contains(message)){
			return;
		}

		FileWriter fw = new FileWriter(".MarketPlace.data");

		for (String s : publishing) {
			fw.write(s+"\n");
		}
		fw.close();
		//System.out.println("Offre externe ajouté");

	}


	public void displayOfferInMarket(){

		if(publishing == null){
			System.out.println("\n Aucun résultat n'est disponible  \n");
			return ;	
		}

		System.out.println("\n ***  Market Place - Offres **** \n");
		for (String s : publishing) {
			if(s.charAt(0) == 'O')
				System.out.println(s);
		}	
	}


	public void displayDemandsInMarket(){

		if(publishing == null){
			System.out.println("\n Aucun résultat n'est disponible  \n");
			return ;	
		}	
		System.out.println("\n ***  Market Place - Demandes **** \n");
		for (String s : publishing) {
			if(s.charAt(0) == 'D')
				System.out.println(s);
		}	
	}


	public void displayMarket(){

		if(publishing == null){
			System.out.println("\n Aucun résultat n'est disponible  \n");
			return ;

		}
		System.out.println("\n ***  Market Place **** \n");
		for (String s : publishing) {

			System.out.println(s);
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



}
