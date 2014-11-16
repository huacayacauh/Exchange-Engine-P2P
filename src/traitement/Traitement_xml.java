package traitement;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jdom2.*;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import principal.Page_principale;
import traitement_son.Traiement_son_nouveau_objet;

/**
 * class permettant la gestion de fichier xml
 */

public class Traitement_xml {

	public static ArrayList<String> objet_utilisateur = new ArrayList<String>();
	public static ArrayList<String> Liste_trait = new ArrayList<String>();
	public static ArrayList<String> Liste_utilisateur = new ArrayList<String>();
	public static ArrayList<String> Liste_objet = new ArrayList<String>();
	static int   cmpt = 0;
	public boolean etape  = false;
	public static String url="";
	public static String titre="";
	public static String echange="";
	public static String telephone="";
	public static String nom="";
	public static String prenom="";
	public static String echange2="";
	public static String couleur2="";
	public static String telephone2="";
	public static String url2="";
	public static int cmt = 0;
	static Element racine;
	static Utilisateur client = new Utilisateur();
	static Document  document ;


	/**
	 * methode permet de verifier l'email et le mot de passe
	 */
	public static String Verification_connexion(String adresse,String passe){
		SAXBuilder builder = new SAXBuilder();

		File fichierXML = new File("./src/media/utilisateur.xml");
		Document document = null;

		try {
			document = builder.build(fichierXML);
		} catch (JDOMException e) {

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Element rootNode = document.getRootElement();
		List<Element> liste = rootNode.getChildren("utilisateur");
		for (Element eClasse : liste) {
			List<Element> attributs = eClasse.getChildren("information");
			if(eClasse.getChildText("mel").equals(adresse)){
				for(Element eAttribut : attributs){
					if(eAttribut.getChildText("mdp").equals(passe)){
						return "2";
					}else{
						return "3";
					}

				}
			}
		}
		return "1";
	}

	/**
	 * methode permettant la creation d'un nouveau utilisateur
	 */
	public static  void create_utilisateur(String nom,String prenom,String mel,String mdp){
		Element racine = new Element("utilisateur");
		Element mele = new Element("mel");
		mele.setText(mel);
		Element informaion = new Element("information");
		Element prenome = new Element("prenom");
		prenome.setText(prenom);
		Element nome = new Element("nom");
		nome.setText(nom);
		Element mdpe = new Element("mdp");
		mdpe.setText(mdp);
		/* Création de la hiérarchie */
		racine.addContent(mele);
		racine.addContent(informaion);
		informaion.addContent(prenome);
		informaion.addContent(nome);
		informaion.addContent(mdpe);
		/* Enregistrment */
		Document document = new Document(racine);
		XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
		try {
			sortie.output(document, new FileOutputStream("./src/media/utilisateur.xml",true));
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		recherche("./src/media/utilisateur.xml","<?xml");
		recherche("./src/media/utilisateur.xml","</diagramme>");try {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("./src/media/utilisateur.xml", true));
			bufferedWriter.write("</diagramme>");
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * methode permettant la recherche d'un mot dans un fichier
	 */
	public static  void recherche(String path,String mot){
		int i = 1; 
		String line = null, recherche = mot;
		try
		{
			BufferedReader br = new BufferedReader
					(new FileReader(path));

			while ((line = br.readLine()) != null)
			{
				if ( line.indexOf(recherche) != -1)
					readReplace(path,i);
				i++;
			}
			br.close();
		}
		catch(FileNotFoundException exc) { System.out.println("File not found" );  }
		catch(IOException ioe) { System.out.println("Erreur IO" ); }
	}

	/**
	 * methode permet de remplacer un mot dans un fichier
	 */
	public static boolean readReplace(String fileName, int lineNumber) {
		String line;
		StringBuffer sb = new StringBuffer();
		int nbLinesRead = 0;
		try {
			FileInputStream fis = new FileInputStream(fileName);
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					fis));
			while ((line = reader.readLine()) != null) {
				nbLinesRead++;
				line = line.toLowerCase();

				if (nbLinesRead == lineNumber) {
					line = "";
				}
				sb.append(line + "\n");
			}
			reader.close();
			BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
			out.write(sb.toString());
			out.close();

		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/**
	 * methode permet d'ajouter un objet dans le fichier objet.xml
	 */
	public static void create_objet(String titr,String mel,String categori,String couleu,String echang,String tel,String urle,String zon){

		Element racine = new Element("objet");
		Element propritaire = new Element("propritaire");
		propritaire.setText(mel);
		Element information = new Element("information");
		Element titre = new Element("titre");
		titre.setText(titr);
		Element categorie = new Element("categorie");
		categorie.setText(categori);
		Element couleur = new Element("couleur");
		couleur.setText(couleu);
		Element echange = new Element("echange");
		echange.setText(echang);
		Element zone = new Element("zone");
		zone.setText(zon);
		Element numero = new Element("numero");
		numero.setText(tel);
		Element url = new Element("url");
		url.setText(urle);

		racine.addContent(propritaire);
		racine.addContent(information);
		information.addContent(titre);
		information.addContent(categorie);
		information.addContent(couleur);
		information.addContent(echange);
		information.addContent(zone);
		information.addContent(numero);
		information.addContent(url);

		Document document = new Document(racine);
		XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
		try {
			sortie.output(document, new FileOutputStream("./src/media/objet.xml",true));
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}

		recherche("./src/media/objet.xml","<?xml");
		recherche("./src/media/objet.xml","</diagramme>");
		try {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("./src/media/objet.xml", true));
			bufferedWriter.write("</diagramme>");
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * methode permet d'ajouter un objet dans le fichier objet_send.xml
	 */
	public static void create_objet_send(String titr,String mel,String categori,String couleu,String echang,String tel,String urle,String zon){
		Element racine = new Element("objet");
		Element propritaire = new Element("propritaire");
		propritaire.setText(mel);
		Element information = new Element("information");
		Element titre = new Element("titre");
		titre.setText(titr);
		Element categorie = new Element("categorie");
		categorie.setText(categori);
		Element couleur = new Element("couleur");
		couleur.setText(couleu);
		Element echange = new Element("echange");
		echange.setText(echang);
		Element zone = new Element("zone");
		zone.setText(zon);
		Element numero = new Element("numero");
		numero.setText(tel);
		Element url = new Element("url");
		url.setText(urle);

		racine.addContent(propritaire);
		racine.addContent(information);
		information.addContent(titre);
		information.addContent(categorie);
		information.addContent(couleur);
		information.addContent(echange);
		information.addContent(zone);
		information.addContent(numero);
		information.addContent(url);

		Document document = new Document(racine);
		XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
		try {
			sortie.output(document, new FileOutputStream("./src/media/objet_send.xml"));
			recherche("./src/media/objet_send.xml","<?xml");
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * methode permettant la recherche de tous les objet d'un utilisateur précis
	 */

	public static void recherche_objet_utilisateur(String adresse){
		SAXBuilder builder = new SAXBuilder();

		File fichierXML = new File("./src/media/objet.xml");
		Document document = null;
		try {
			document = builder.build(fichierXML);
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Element rootNode = document.getRootElement();
		List<Element> liste = rootNode.getChildren("objet");
		for (Element eClasse : liste) {
			List<Element> attributs = eClasse.getChildren("information");
			if(eClasse.getChildText("propritaire").equals(adresse)){
				for(Element eAttribut : attributs){
					objet_utilisateur.add(eAttribut.getChildText("titre"));
				}
			}

		}

	}

	/**
	 * methode permet de récupérer les informations d'un objet
	 */
	public static void recuper_info_objet(String titre){
		SAXBuilder builder = new SAXBuilder();

		File fichierXML = new File("./src/media/objet.xml");
		Document document = null;


		try {
			document = builder.build(fichierXML);
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Element rootNode = document.getRootElement();
		List<Element> liste = rootNode.getChildren("objet");
		for (Element eClasse : liste) {
			List<Element> attributs = eClasse.getChildren("information");
			for(Element eAttribut : attributs){
				if(eAttribut.getChildText("titre").equals(titre)){
					url=eAttribut.getChildText("url");
					echange=eAttribut.getChildText("echange");
					telephone=eAttribut.getChildText("numero");
				}
			}		
		}
	}

	/**
	 * methode permettant la recherche d'un objet par type
	 */
	public static void recherche_type(String genre,String info){
		Liste_trait.clear();
		SAXBuilder builder = new SAXBuilder();
		File fichierXML = new File("./src/media/objet.xml");
		Document document = null;
		try {
			document = builder.build(fichierXML);
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Element rootNode = document.getRootElement();
		List<Element> liste = rootNode.getChildren("objet");
		if(genre.equals("categorie")){
			for (Element eClasse : liste) {
				List<Element> attributs = eClasse.getChildren("information");
				for(Element eAttribut : attributs){
					if(eAttribut.getChildText("categorie").equals(info)){
						Liste_trait.add(eAttribut.getChildText("titre"));
					}
				}
			}
		} else if(genre.equals("zone")){
			for (Element eClasse : liste) {
				List<Element> attributs = eClasse.getChildren("information");
				for(Element eAttribut : attributs){
					if(eAttribut.getChildText("zone").equals(info)){
						Liste_trait.add(eAttribut.getChildText("titre"));
					}
				}
			}
		}
		else{
			for (Element eClasse : liste) {
				List<Element> attributs = eClasse.getChildren("information");
				for(Element eAttribut : attributs){
					if(info.equals("all")){
						Liste_trait.add(eAttribut.getChildText("titre"));
						break;
					}
					if(eAttribut.getChildText("titre").matches(".*"+info+".*")){
						Liste_trait.add(eAttribut.getChildText("titre"));
					}
				}
			}
		}

	}

	/**
	 * methode permettant la verification d'un email
	 */
	public static boolean verification_mel(String mel){
		SAXBuilder builder = new SAXBuilder();
		File fichierXML = new File("./src/media/utilisateur.xml");
		Document document = null;


		try {
			document = builder.build(fichierXML);
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Element rootNode = document.getRootElement();
		List<Element> liste = rootNode.getChildren("utilisateur");
		for (Element eClasse : liste) {
			if(eClasse.getChildText("mel").equals(mel)){
				return true;
			}
		}
		return false;
	}


	/**
	 * methode permet de récuperer les information d'un utilisateur
	 */
	public static void recuperer_information(String mel){
		SAXBuilder builder = new SAXBuilder();

		File fichierXML = new File("./src/media/utilisateur.xml");
		Document document = null;

		try {
			document = builder.build(fichierXML);
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Element rootNode = document.getRootElement();
		List<Element> liste = rootNode.getChildren("utilisateur");
		for (Element eClasse : liste) {
			List<Element> attributs = eClasse.getChildren("information");
			if(eClasse.getChildText("mel").equals(mel)){
				for(Element eAttribut : attributs){
					nom=eAttribut.getChildText("nom");
					prenom=eAttribut.getChildText("prenom");

				}
			}
		}
	}

	/**
	 * methode permettant de recuperer les informations d'un objet a partir de son titre
	 */
	public static void recuper_info_mes_objet(String titre){
		SAXBuilder builder = new SAXBuilder();
		File fichierXML = new File("./src/media/objet.xml");
		Document document = null;
		try {
			document = builder.build(fichierXML);
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Element rootNode = document.getRootElement();
		List<Element> liste = rootNode.getChildren("objet");
		for (Element eClasse : liste) {
			List<Element> attributs = eClasse.getChildren("information");
			for(Element eAttribut : attributs){
				if(eAttribut.getChildText("titre").equals(titre)){
					url2=eAttribut.getChildText("url");
					echange2=eAttribut.getChildText("echange");
					telephone2=eAttribut.getChildText("numero");
					couleur2=eAttribut.getChildText("couleur");
				}
			}
		}
	}
	/**
	 * methode permettant de renvoyer l'indice en fonction du titre 
	 */
	@SuppressWarnings("unused")
	public static  int re_int(String mot){
		int compt=0;
		String chaine="";
		String fichier ="./src/media/objet.xml";

		//lecture du fichier texte	
		try{
			InputStream ips=new FileInputStream(fichier); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			@SuppressWarnings("resource")
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			while ((ligne=br.readLine())!=null){
				compt++;
				if(ligne.equals("    <titre>"+mot+"</titre>")){
					return compt;
				}
				chaine+=ligne+"\n";
			}
			br.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
		return 0;
	}
	
	/**
	 * methode permettant la suppression d'un ligne 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked", "resource" })
	public static  void remove_ligne(int lig) throws IOException {
		Vector monVector = new Vector();

		File f = new File("./src/media/objet.xml"); 
		BufferedReader B = new BufferedReader(new FileReader(f)); 
		String ligne = B.readLine(); 
		while (ligne != null){ 
			monVector.addElement(ligne); 
			ligne = B.readLine(); 
		} 
		System.out.println(lig);
		monVector.removeElementAt(lig); 
		PrintWriter P = new PrintWriter (new FileWriter(f)); 
		for (int i = 0; i < monVector.size(); i++){ 
			P.println(monVector.get(i)); 
		} 
		P.close(); 
		monVector.clear();
	}

	/**
	 * methode permettant de recuperer l'url de l'image en fonction de son titre
	 */
	public static String recuper_image(String titre){
		SAXBuilder builder = new SAXBuilder();
		File fichierXML = new File("./src/media/objet.xml");
		Document document = null;
		try {
			document = builder.build(fichierXML);
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Element rootNode = document.getRootElement();
		List<Element> liste = rootNode.getChildren("objet");
		for (Element eClasse : liste) {
			List<Element> attributs = eClasse.getChildren("information");
			for(Element eAttribut : attributs){
				if(eAttribut.getChildText("titre").equals(titre)){
					return eAttribut.getChildText("url");
				}
			}
		}
		return "";
	}

	/**
	 * methode permettant de lire un fichier et l'envoyer en broadcast
	 */
	@SuppressWarnings("unused")
	public static void traitesment_browser(String path) throws IOException{
		String chaine="";
		String fichier ="./src/media/"+path;
		recherche("./src/media/objet.xml","</diagramme>");
		BufferedWriter out;
		out = new BufferedWriter(new FileWriter("./src/media/objet.xml", true));
		//lecture du fichier texte	
		try{
			InputStream ips=new FileInputStream(fichier); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			while ((ligne=br.readLine())!=null){
				if(ligne.equals("<diagramme>") || ligne.equals("</diagramme>")){
					chaine+=ligne+"\n";
				}else{

					try {
						taritement_p2p(ligne);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			br.close(); 
			out.close();
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
	}
	/**
	 * methode permettant la gestion du fichier objet_send.xml
	 */
	@SuppressWarnings("unused")
	public static  void lecutre(){
		String chaine="";
		String fichier ="./src/media/objet_send.xml";
		try{
			InputStream ips=new FileInputStream(fichier); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			while ((ligne=br.readLine())!=null){
				Page_principale.m.run("1"+ligne);
				chaine+=ligne+"\n";
				Thread.sleep(500);
			}
			br.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
	}
	/**
	 * methode permettant la gestion d'un fichier quelconque
	 */
	@SuppressWarnings("unused")
	public static  void lecutre_browser(String path){
		String chaine="";
		String fichier ="./src/media/"+path;
		try{
			InputStream ips=new FileInputStream(fichier); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			while ((ligne=br.readLine())!=null){
				Page_principale.m.run("1"+ligne);
				chaine+=ligne+"\n";
				Thread.sleep(500);
			}
			br.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
	}

	/**
	 * methode permettant la gestion des objet recu en P2P
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	public static void taritement_p2p(String line) throws IOException{
		String utilisateur ="";
		if(cmt == 0){
			recherche("./src/media/objet.xml","</diagramme>");
		}
		if(cmt == 4){
			recherche("./src/media/objet.xml","</diagramme>");
		}
		if(cmt == 2){
			utilisateur = line.substring(15,(line.length())-14);
		}
		cmt++;
		BufferedWriter out;
		out = new BufferedWriter(new FileWriter("./src/media/objet.xml", true));
		out.write(line+"\n");
		out.close();
		if(cmt == 13){
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("./src/media/objet.xml", true));
			bufferedWriter.write("</diagramme>");
			bufferedWriter.close();
			cmt=0;
			if(!Page_principale.son){
				Traiement_son_nouveau_objet a = new Traiement_son_nouveau_objet();
				a.start();	    
			}
			Page_principale.son=false;
			Traitement_xml.Liste_objet();
			Page_principale.jComboBox_objet1.removeAllItems();
			Page_principale.jComboBox_objet2.removeAllItems();
			Page_principale.jComboBox_objet3.removeAllItems();
			for (int i = 0; i < Traitement_xml.Liste_objet.size(); i++) {
				Page_principale.jComboBox_objet1.addItem(Traitement_xml.Liste_objet.get(i));
				Page_principale.jComboBox_objet2.addItem(Traitement_xml.Liste_objet.get(i));
				Page_principale.jComboBox_objet3.addItem(Traitement_xml.Liste_objet.get(i));
			}

			if(!Page_principale.update){
				Page_principale.listModel2.addElement("Un nouveau objet ajouter");
				Page_principale.jList_chat.setModel(Page_principale.listModel2);
			}
			if(Page_principale.update){
				Page_principale.listModel2.addElement("Un nouveau objet modifier");
				Page_principale.jList_chat.setModel(Page_principale.listModel2);
				Page_principale.update =false;
			}
		}

	}

	/**
	 * methode permettant de lister tout les utilisateur online
	 */
	public static void  Liste_utilisateur(){
		Liste_utilisateur.clear();
		SAXBuilder builder = new SAXBuilder();
		File fichierXML = new File("./src/media/utilisateur.xml");
		Document document = null;
		try {
			document = builder.build(fichierXML);
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Element rootNode = document.getRootElement();
		List<Element> liste = rootNode.getChildren("utilisateur");
		for (Element eClasse : liste) {
			List<Element> attributs = eClasse.getChildren("information");
			for(Element eAttribut : attributs){
				Liste_utilisateur.add(eAttribut.getChildText("nom"));
			}
		}
	}

	/**
	 * methode permettant de lister tout les objet disponible
	 */
	public static void  Liste_objet(){
		Liste_objet.clear();
		Liste_objet.clear();
		SAXBuilder builder = new SAXBuilder();
		File fichierXML = new File("./src/media/objet.xml");
		Document document = null;
		try {
			document = builder.build(fichierXML);
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Element rootNode = document.getRootElement();
		List<Element> liste = rootNode.getChildren("objet");
		for (Element eClasse : liste) {
			List<Element> attributs = eClasse.getChildren("information");
			for(Element eAttribut : attributs){
				Liste_objet.add(eAttribut.getChildText("titre"));
			}
		}
	}

	/**
	 * methode permettant de verifier le format de fichier xml importer
	 */
	public static boolean verification(String ligne, int num){
		try {
			if(num == 1){
				if(ligne.equals("<objet>")){
					return true;
				}
				return false;
			}
			if(num == 2){

				if(ligne.substring(0,15).equals("  <propritaire>") && ligne.substring((ligne.length()-14),ligne.length()).equals("</propritaire>")){

					return true;
				}
				return false;
			}
			if(num == 3){

				if(ligne.substring(0,15).equals("  <information>")){

					return true;
				}
				return false;
			}

			if(num == 4){

				if(ligne.substring(0,11).equals("    <titre>") && ligne.substring((ligne.length()-8),ligne.length()).equals("</titre>")){

					return true;
				}
				return false;
			}
			if(num == 5){

				if(ligne.substring(0,15).equals("    <categorie>") && ligne.substring((ligne.length()-12),ligne.length()).equals("</categorie>")){

					return true;
				}
				return false;
			}

			if(num == 6){

				if(ligne.substring(0,13).equals("    <couleur>") && ligne.substring((ligne.length()-10),ligne.length()).equals("</couleur>")){

					return true;
				}
				return false;
			}
			if(num == 7){

				if(ligne.substring(0,13).equals("    <echange>") && ligne.substring((ligne.length()-10),ligne.length()).equals("</echange>")){

					return true;
				}
				return false;
			}
			if(num == 8){

				if(ligne.substring(0,10).equals("    <zone>") && ligne.substring((ligne.length()-7),ligne.length()).equals("</zone>")){

					return true;
				}
				return false;
			}
			if(num == 9){

				if(ligne.substring(0,12).equals("    <numero>") && ligne.substring((ligne.length()-9),ligne.length()).equals("</numero>")){

					return true;
				}
				return false;
			}
			if(num == 10){

				if(ligne.substring(0,9).equals("    <url>") && ligne.substring((ligne.length()-6),ligne.length()).equals("</url>")){

					return true;
				}
				return false;
			}
			if(num == 11){

				if(ligne.substring(0,ligne.length()).equals("  </information>")){

					return true;
				}
				return false;
			}
			if(num == 12){

				if(ligne.equals("</objet>")){

					return true;
				}
				return false;
			}

			if(num == 13){
				cmpt=1;
				if(ligne.equals("<objet>")){

					return true;
				}
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@SuppressWarnings("resource")
	public static boolean traitement(String path){
		boolean b = true;
		String fichier ="./src/media/objet_send.xml";
		try{
			InputStream ips=new FileInputStream(fichier); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			while ((ligne=br.readLine())!=null){
				if(!ligne.equals("")){
					cmpt = cmpt + 1;

					if(cmpt == 1){
						if(!verification(ligne,1))
							b= false;
					}
					else if(cmpt == 2){
						if(!verification(ligne,2))
							b= false;
					}
					else if(cmpt == 3){
						if(!verification(ligne,3))
							b= false;
					}
					else if(cmpt == 4){
						if(!verification(ligne,4))
							b= false;
					}
					else if(cmpt == 5){
						if(!verification(ligne,5))
							b= false;
					}
					else if(cmpt == 6){
						if(!verification(ligne,6))
							b= false;
					}
					else if(cmpt == 7){
						if(!verification(ligne,7))
							b= false;
					}
					else if(cmpt == 8){
						if(!verification(ligne,8))
							b= false;
					}
					else if(cmpt == 9){
						if(!verification(ligne,9))
							b= false;
					}
					else if(cmpt == 10){
						if(!verification(ligne,10))
							b= false;
					}
					else if(cmpt == 11){
						if(!verification(ligne,11))
							b= false;
					}
					else if(cmpt == 12){
						if(!verification(ligne,12))
							b= false;
					}
					else if(cmpt == 13){

						if(!verification(ligne,13))
							b= false;

					}
				}
			}
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
		return b;
	}
	
	/**
	 * methode permettant de verifier le format de numéro de telephone
	 */
	public static boolean isPhoneNumberCorrect(String pPhoneNumber) {
		Pattern pattern = Pattern.compile("\\d{3}\\d{7}");
		Matcher matcher = pattern.matcher(pPhoneNumber);

		if (matcher.matches()) {
			return true;
		}
		return false;
	}

}
