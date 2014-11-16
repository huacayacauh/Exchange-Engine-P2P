package model.p2p;

import java.io.IOException;
import java.net.URL;

import model.MySearchs;
import net.jxta.id.IDFactory;
import net.jxta.peer.PeerID;
import net.jxta.peergroup.PeerGroup;
import net.jxta.peergroup.PeerGroupFactory;


public class Peer extends Thread {

	private PeerGroup groupe = null; 
	private Client client = null; 
	private Server server = null;
	private Discovery discovery = null;   
	private String monNom = null;  

	private String urlPipeAdv ="./chat/PropagatePipeAdv.xml";


	/**
	 * Constructeur de la classe ChatJXTA
	 */
	public Peer() {

		try {
			groupe = PeerGroupFactory.newNetPeerGroup();  //cree un nouveau groupe general
		} catch (Exception e) {System.err.println("ChatPeer : Erreur de creation du groupe");}

		//instanciation des services de decouverte et de communications
		client = new Client(urlPipeAdv,groupe);
		server = new Server(this,urlPipeAdv,groupe);

		//recuperation du nom du pair dans le groupe general
		monNom = groupe.getPeerName().toString();
		System.out.println(groupe.toString());

		//instanciation de l'interface graphique

		System.out.println( " ***** " + monNom + " *****");
		discovery = new Discovery(groupe);

	}


	/**
	 * Methode de lancement de la classe ChatPeer
	 * lance le client, le serveur, la decouverte et l'interface graphique
	 */
	public void run() {
		discovery.start();
		client.start();
		server.start();

		travail();
	}


	/**
	 * Oblige le pair � effectuer une recherche de pairs
	 * dans le r�seau toutes les 5 secondes
	 */
	public void travail() {
		while (true) {
			discovery.rechercher();  //recherche des pairs dans le reseau
			try {
				Thread.sleep(5000);  //endormissement du thread
			} catch (Exception e) {System.err.println("Impossible de dormir");}
		}
	}


	/**
	 * Envoi d'un message par l'utilisateur
	 */
	public void sendMessage(String message) {
		//envoi d'un message a l'ensemble des pairs
		client.sendMessage(message);
		System.out.println("Peer.java - sendMessage(String message): "+ message + "\n");
	}


	/**
	 * Affichage d'un message recu
	 * @throws IOException 
	 */
	public void afficheMessage(String message) throws IOException {



		MySearchs mySearchs = new MySearchs();
		mySearchs.update(message);
	}


	/**
	 * Transformation d'une chaine de caracteres contenant un PeerID
	 * en un objet du type PeerID
	 */
	public PeerID chaineVersPeerID(String pid_str) {
		PeerID dest_pid = null;

		try {

			dest_pid = (PeerID) IDFactory.fromURL(new URL(pid_str));

		} catch (Exception e) { System.err.println("Erreur dans ChatPeer.chaineVersPeerID()");  }

		return dest_pid;
	}



}
