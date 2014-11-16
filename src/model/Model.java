package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import model.p2p.Peer;

/**
 * 
 * Classe exportee du projet P2P
 * Merci a ses auteurs
 */
public class Model{


	private Peer peer;

	public MyUserProfil  myUserProfil;
	public MySearchs     mySearchs;
	public MyPublishings myPublishings;


	public Model(){

		peer = new Peer();
		peer.start();

		myUserProfil  = new MyUserProfil(peer);
		mySearchs	  = new MySearchs();
		myPublishings = new MyPublishings(peer, myUserProfil);


	}


	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {

		Model model = new Model();

	}


	public void run(String ok) throws IOException{
		int i=0;

		while(true){

			if(i<1)	{
				publishMyOffer(ok);
				i++;}
			else{
				return;
			}

		}






	}


	private void publishMyOffer(String ok){

		try {
			myPublishings.postMyOffer(ok);
		} catch (IOException e) {
			e.printStackTrace();
		}   	
	}


	@SuppressWarnings("unused")
	private void publishMyDemands(){

		String title = scanf("\nEntrer un titre pour poster une demande: ");
		String description = scanf("\nEntrer une description:");

		try {
			myPublishings.postMyDemand(title, description);
		} catch (IOException e) {
			e.printStackTrace();
		}   	
	}

	@SuppressWarnings("unused")
	private void  displayMyOffer(){
		myPublishings.displayMyOffers();
	}

	private String scanf(String message){

		System.out.println(message);
		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));

		try {
			message = bufferRead.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return message;
	}








}