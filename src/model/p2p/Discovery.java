package model.p2p;

import java.util.Enumeration;
import java.util.Vector;

import net.jxta.discovery.DiscoveryEvent;
import net.jxta.discovery.DiscoveryListener;
import net.jxta.discovery.DiscoveryService;
import net.jxta.protocol.DiscoveryResponseMsg;
import net.jxta.peergroup.PeerGroup;
import net.jxta.protocol.PeerAdvertisement;

/**
 * Classe permettant la decouverte des annonces (advertisements)
 * circulant sur le reseau
 */
public class Discovery extends Thread implements DiscoveryListener {

	private PeerGroup netPeerGroup = null;  //groupe principal d'appartenance du pair
	private DiscoveryService discovery = null;  //service de decouverte du groupe
	// private ChatFrame cframe = null;  //le frame du chat

	/**
	 * Constructeur de la classe Decouverte
	 */
	public Discovery(PeerGroup p) {

		netPeerGroup = p;
		discovery = netPeerGroup.getDiscoveryService();
		discovery.addDiscoveryListener(this);

	}

	/**
	 * Lancement de la classe Decouverte
	 */
	public void run() {

	}

	/**
	 * Recherche des pairs dans le reseau
	 */
	public void rechercher() {

		try {
			//decouverte des annonces distantes concernant les pairs
			discovery.getRemoteAdvertisements(null, DiscoveryService.PEER, null, null,50);

		}
		catch (Exception e) {
			System.err.println("\nErreur dans Decouverte.rechercher() : ");
			e.printStackTrace();
		}
	}

	/**
	 * Reception des evenements lies a la decouverte de pairs (d'annonces)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void discoveryEvent(DiscoveryEvent ev) {


		DiscoveryResponseMsg res = ev.getResponse();
		Vector veclist = new Vector();

		PeerAdvertisement adv = null;
		Enumeration en = res.getAdvertisements();
		if (en != null ) {
			while (en.hasMoreElements()) {
				adv = (PeerAdvertisement) en.nextElement();

				veclist.add(adv);
			}
		}  
		// REMPLIR ICI
		// transformer l'enumeration en un vector



	}

}


