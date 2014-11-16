package model.p2p;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import net.jxta.document.AdvertisementFactory;
import net.jxta.document.MimeMediaType;
import net.jxta.endpoint.Message;
import net.jxta.peer.PeerID;
import net.jxta.peergroup.PeerGroup;
import net.jxta.pipe.OutputPipe;
import net.jxta.pipe.PipeService;
import net.jxta.protocol.PipeAdvertisement;
import net.jxta.util.MessageUtilities;


/**
 * Classe permettant l'envoi de message sur un pipe (pipe d'emission)
 * La classe cree un pipe suivant un modele d'annonce (advertisement)
 * La classe fournit des fonctions d'envoi des messages
 */
public class Client extends Thread {

	private PeerGroup peerGroup = null;  //groupe d'appartenance du pair
	private OutputPipe outputPipe = null;  //pipe d'emission de message
	@SuppressWarnings("unused")
	private String monFichier = "";  //nom du fichier contenant l'annonce
	private  PipeAdvertisement myPipeAdvertisement = null ;


	/**
	 * Constructeur de la classe Client
	 */
	public Client(String s,PeerGroup p) {
		peerGroup = p;
		monFichier = s;
	}


	/**
	 * Chargement de l'annonce et creation du pipe d'emission principal
	 */
	public void loadPipeAdv(String fileName) throws FileNotFoundException, IOException {

		//chargement de l'annonce depuis un fichier
		FileInputStream file = new FileInputStream(fileName);
		MimeMediaType asMimeType = new MimeMediaType("text/xml");

		//il s'agit d'un pipe de diffusion (multicast)
		PipeAdvertisement pipeAdv = (PipeAdvertisement) AdvertisementFactory.newAdvertisement(asMimeType, file);
		myPipeAdvertisement = pipeAdv;
		//creation du pipe de communication
		PipeService pipeService = peerGroup.getPipeService();
		outputPipe = pipeService.createOutputPipe(pipeAdv,60000);

	}


	/**
	 * Lancement de la classe Client
	 */
	public void run() {

		try {
			loadPipeAdv("PropagatePipeAdvs.xml");
		} catch (Exception e)  { System.err.println("Erreur dans Client.run() : "); e.printStackTrace(); }

	}


	/**
	 * Envoi de messages sur le pipe principal (multicast)
	 * Le message est de "Type" MESSAGE et contient les champs
	 * "Auteur" (nom de l'emetteur) et "Texte" (texte du message)
	 */
	public void sendMessage(String messageString) {

		//creation du nouveau message et des differents champs
		Message message = new Message();
		MessageUtilities.addString(message,"Type","MESSAGE");
		//      MessageUtilities.addString(message,"Auteur", auteurString);
		MessageUtilities.addString(message,"Texte", messageString);

		//si le pipe n'est pas null, j'envoie le message
		if (outputPipe != null) {
			try {
				outputPipe.send(message);  //envoi du message sur le pipe
			} catch (IOException e) {  }
		}
		else {
			System.err.println("Erreur dans Client.sendMessage() : OutputPipe == null");
		}

	}

	public void sendMessagePair(String messageString, PeerID pid) {

		//creation du nouveau message et des differents champs
		Message message = new Message();
		MessageUtilities.addString(message,"Type","MESSAGE");
		//      MessageUtilities.addString(message,"Auteur", auteurString);
		MessageUtilities.addString(message,"Texte", messageString);

		OutputPipe PeerOutPipe = this.creationPipeVersPair(pid);
		//si le pipe n'est pas null, j'envoie le message
		if (PeerOutPipe != null) {
			try {
				PeerOutPipe.send(message);  //envoi du message sur le pipe
				System.out.println("Client.java - SendMessage: PeerOutPipe est null"+ message);
			} catch (IOException e) {  }
		}
		else {
			System.err.println("Erreur dans Client.sendMessage() : OutputPipe == null");
		}

	}

	/**
	 * Creation d'un pipe d'emission dirige vers un unique pair
	 */
	@SuppressWarnings("null")
	public OutputPipe creationPipeVersPair(PeerID pid) {


		// MODIFIER ICI
		// Créer une connexion pipe output à un pipe input du peer PeerID
		// Utiliser les mechanismes de découverte de annonces de pipes vues en TP2 (dans PropagatePipes)

		//   return myPipe;

		OutputPipe		myOutputPipe = null;
		PipeService 	myPipeService = null;

		try {
			myOutputPipe = myPipeService.createOutputPipe(myPipeAdvertisement, 1000);
			System.out.println("Output Pipe Created");
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
		System.out.println(myOutputPipe.getPipeID());

		return myOutputPipe;

	}

}
