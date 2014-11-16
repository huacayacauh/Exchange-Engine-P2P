package model.p2p;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import principal.Page_principale;
import traitement.Traitement_xml;
import traitement_son.Traiement_son_nouveau_client;
import traitement_son.Traiment_son_nouveaumsg;
import net.jxta.discovery.DiscoveryService;
import net.jxta.document.AdvertisementFactory;
import net.jxta.document.MimeMediaType;
import net.jxta.endpoint.Message;
import net.jxta.peergroup.PeerGroup;
import net.jxta.pipe.InputPipe;
import net.jxta.pipe.PipeMsgEvent;
import net.jxta.pipe.PipeMsgListener;
import net.jxta.pipe.PipeService;
import net.jxta.protocol.PipeAdvertisement;

/**
 * Classe d'ecoute des messages dans le groupe
 * Creation d'un pipe d'ecoute
 * Methode de traitement des messages entrant
 */
public class Server extends Thread implements PipeMsgListener {
	@SuppressWarnings("unused")
	private boolean b = true;
	@SuppressWarnings("unused")
	private String type="";
	private PeerGroup peerGroup = null;  //groupe d'appartenance du pair
	@SuppressWarnings("unused")
	private InputPipe inputPipe = null;  //pipe d'entree des messages
	@SuppressWarnings("unused")
	private InputPipe inputPipePerso = null;  //pipe d'entree des messages pour des messages perso
	@SuppressWarnings("unused")
	private String monFichier = "PropagatePipeAdv";  //nom du fichier de l'annonce
	private DiscoveryService discovery = null;  //service de publication des annonces
	private Peer  monPair = null;  //pair maitre du serveur
	@SuppressWarnings("rawtypes")
	static DefaultListModel listModel3 = new DefaultListModel();
	@SuppressWarnings("rawtypes")
	static DefaultListModel listModel4 = new DefaultListModel();
	Traiement_son_nouveau_client a;
	Traiment_son_nouveaumsg c;
	public static ArrayList<String>liste_uti = new ArrayList<String>();
	/**
	 * Constructeur de la classe Serveur
	 */
	public Server(Peer pair,String s,PeerGroup p) {
		monFichier = s;
		peerGroup = p;
		monPair = pair;
	}


	/**
	 * Chargement de l'annonce et creation du pipe d'ecoute
	 */
	public void loadPipeAdv(String fileName) throws FileNotFoundException, IOException {

		//chargement de l'annonce
		FileInputStream file = new FileInputStream(fileName);
		MimeMediaType asMimeType = new MimeMediaType("text/xml");
		PipeAdvertisement pipeAdv = (PipeAdvertisement) AdvertisementFactory.newAdvertisement(asMimeType, file);

		//creation du service de publication des annonces
		discovery = peerGroup.getDiscoveryService();
		discovery.publish(pipeAdv,60000,60000);
		discovery.remotePublish(pipeAdv,(long) 60000);

		//creation du pipe d'ecoute
		PipeService pipeService = peerGroup.getPipeService();
		inputPipe = pipeService.createInputPipe(pipeAdv, this);

	}


	/**
	 * Lancement du serveur
	 */
	public void run() {
		try {
			loadPipeAdv("PropagatePipeAdvs.xml");
			//publishPerso();
		} catch (Exception e) { System.out.println("\nErreur dans Serveur.run() : "); e.printStackTrace();}
	}


	/**
	 * Notification d'arrivee des differents messages sur le pipe
	 */
	@SuppressWarnings("unchecked")
	public void pipeMsgEvent(PipeMsgEvent event) {

		//recuperation du message venant d'arriver et de son type
		Message message = event.getMessage();
		String type = message.getMessageElement("Type").toString();

		//il s'agit d'un message texte de discussion


		if (type.equals("MESSAGE")) {
			try {
				monPair.afficheMessage(message.getMessageElement("Texte").toString());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}



			String mesge = message.getMessageElement("Texte").toString();
			int longeur= mesge.length();

			String str = mesge.substring(0, 1);

			if(str.equals("1")){
				type="nouveau objet";
				try {
					Traitement_xml.taritement_p2p(message.getMessageElement("Texte").toString().substring(1, longeur));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(str.equals("2")) {// un nouveau utilisateur en ligne

				String utilisateur = mesge.substring(1,longeur);

				liste_uti.add(utilisateur);
				listModel3.addElement(utilisateur);
				Page_principale.jList_online.setModel(listModel3);


				listModel4.addElement(utilisateur+" viens de joindre le groupe");
				Page_principale.jList_chat_groupe.setModel(listModel4); 

				//

				if(!utilisateur.equals(Traitement_xml.nom)){

					a = new Traiement_son_nouveau_client();
					a.start();


				} 

				liste_uti.add(utilisateur);

				for (int i = 0; i < liste_uti.size(); i++) {
					System.out.println("----- "+liste_uti.get(i));
				}



			}else if(str.equals("3")){//suppression
				String titre_objet = mesge.substring(1,longeur);
				Page_principale.remove_p2p(titre_objet);
			}else if(str.equals("4")){// modification
				String titre_objet = mesge.substring(1,longeur);
				Page_principale.update_p2p(titre_objet);

			}else if(str.equals("0")){//message chat
				listModel4.addElement(message.getMessageElement("Texte").toString().substring(1, longeur));
				Page_principale.jList_chat_groupe.setModel(listModel4); 


				if(!mesge.contains(Traitement_xml.nom)){
					c = new Traiment_son_nouveaumsg();
					c.start();
				}


			}else if(str.equals("q")){
				listModel3.removeElement(message.getMessageElement("Texte").toString().substring(1, longeur));
				Page_principale.jList_online.setModel(listModel3);


				listModel4.addElement(message.getMessageElement("Texte").toString().substring(1, longeur)+" viens de quitter le groupe");
				Page_principale.jList_chat_groupe.setModel(listModel4); 
			}else if(str.equals("9")){
				System.out.println("je suis la");
				String utilisateur = mesge.substring(1,longeur);
				if(!utilisateur.equals(Traitement_xml.nom)){
					if(!verif(utilisateur)){


						liste_uti.add(utilisateur);
						listModel3.addElement(utilisateur);
						Page_principale.jList_online.setModel(listModel3);


						listModel4.addElement(utilisateur+" viens de joindre le groupe");
						Page_principale.jList_chat_groupe.setModel(listModel4); 
						liste_uti.add(utilisateur);
					}
				}
			}



		}



	}

	public static boolean verif(String nom){
		for (int i = 0; i < liste_uti.size(); i++) {
			if(liste_uti.get(i).equals(nom))
				return true;
		}
		return false;
	}

}

