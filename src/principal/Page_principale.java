package principal;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import traitement.Creat_PDF;
import traitement.Traitement_xml;
import traitement_son.Traiement_son_remove_objet;
import traitement_son.Traiement_son_update_objet;

import com.itextpdf.text.DocumentException;

import model.Model;


/**
 *
 * @author El MEHDI
 * Classe principale contenant tout les fenetres.
 */

@SuppressWarnings({ "rawtypes", "serial" })
public class Page_principale extends javax.swing.JFrame {
	static boolean changer=false;
	public static boolean update= false;
	public static boolean son =false;
	static DefaultListModel listModel3 = new DefaultListModel();
	public static DefaultListModel listModel2 = new DefaultListModel();
	public static Model m;
	public static final String RESULT = "./src/media/Contrat.pdf";
	DefaultListModel listModel = new DefaultListModel();
	Thread monThread,monThread2,monThread3;

	/**
	 * constructeur
	 */
	@SuppressWarnings("unchecked")
	public Page_principale() {
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception ex) {
		}

		m =  new Model();
		initComponents();
		Traitement_xml.recuperer_information(Connexion.email_courant);
		Traitement_xml.recherche_objet_utilisateur(Connexion.email_courant);
		jLabel_nom.setText((Traitement_xml.nom)+" "+Traitement_xml.prenom);

		for (int i = 0; i < Traitement_xml.objet_utilisateur.size(); i++) {
			listModel3.addElement(Traitement_xml.objet_utilisateur.get(i));
		}
		jList1.setModel(listModel3);
		jComboBox_recherhc_eategorie.setEnabled(false);
		jComboBox_recherche_zone.setEnabled(false);
		jTextFieldrecherche_mmanuel.setEnabled(false);
		ButtonGroup bg = new ButtonGroup();
		bg.add(jRadioButton_mmanuel);
		bg.add(jRadioButton_categorie);
		bg.add(jRadioButton_zone);
		jList_chat.setModel(listModel2);
		Traitement_xml.Liste_utilisateur();
		for (int i = 0; i < Traitement_xml.Liste_utilisateur.size(); i++) {
			jTextField_personne1.addItem(Traitement_xml.Liste_utilisateur.get(i));
			jTextField_personne2.addItem(Traitement_xml.Liste_utilisateur.get(i));
			jTextField_personne3.addItem(Traitement_xml.Liste_utilisateur.get(i));
		}
		Traitement_xml.Liste_objet();
		for (int i = 0; i < Traitement_xml.Liste_objet.size(); i++) {
			jComboBox_objet1.addItem(Traitement_xml.Liste_objet.get(i));
			jComboBox_objet2.addItem(Traitement_xml.Liste_objet.get(i));
			jComboBox_objet3.addItem(Traitement_xml.Liste_objet.get(i));
		}
		try {
			m.run("2"+Traitement_xml.nom);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * gestion graphique
	 */                     
	@SuppressWarnings("unchecked")
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jTabbedPane1 = new javax.swing.JTabbedPane();
		jPanel2 = new javax.swing.JPanel();
		jLabel14 = new javax.swing.JLabel();
		jTextFieldrecherche_mmanuel = new javax.swing.JTextField();
		jComboBox_recherhc_eategorie = new javax.swing.JComboBox();
		jComboBox_recherche_zone = new javax.swing.JComboBox();
		jRadioButton_mmanuel = new javax.swing.JRadioButton();
		jRadioButton_categorie = new javax.swing.JRadioButton();
		jRadioButton_zone = new javax.swing.JRadioButton();
		jSeparator3 = new javax.swing.JSeparator();
		jScrollPane2 = new javax.swing.JScrollPane();
		jList_acceul = new javax.swing.JList();
		jLabel_image_acceuil = new javax.swing.JLabel();
		jLabel19 = new javax.swing.JLabel();
		jLabel_titre_acceuil = new javax.swing.JLabel();
		jLabel21 = new javax.swing.JLabel();
		jLabel_echange_aceuil = new javax.swing.JLabel();
		jLabel23 = new javax.swing.JLabel();
		jLabel24 = new javax.swing.JLabel();
		jProgressBar3 = new javax.swing.JProgressBar();
		jLabel_nom = new javax.swing.JLabel();
		jPanel3 = new javax.swing.JPanel();
		jLabel7 = new javax.swing.JLabel();
		jSeparator2 = new javax.swing.JSeparator();
		jScrollPane1 = new javax.swing.JScrollPane();
		jList1 = new javax.swing.JList();
		jLabel11 = new javax.swing.JLabel();
		jTextField_titre__mo = new javax.swing.JTextField();
		jLabel12 = new javax.swing.JLabel();
		jLabel13 = new javax.swing.JLabel();
		jLabel15 = new javax.swing.JLabel();
		jLabel17 = new javax.swing.JLabel();
		jTextField_telephone_mo = new javax.swing.JTextField();
		jTextField_echange_mo = new javax.swing.JTextField();
		jLabel18 = new javax.swing.JLabel();
		jLabel_cuoleur_choser_mo = new javax.swing.JLabel();
		jLabel_image_mo = new javax.swing.JLabel();
		jButton_modifier_mo = new javax.swing.JButton();
		jButton_supprimer_mo = new javax.swing.JButton();
		jComboBox_categorie_mo = new javax.swing.JComboBox();
		jComboBox_zone_mo = new javax.swing.JComboBox();
		jProgressBar2 = new javax.swing.JProgressBar();
		jLabelcouleur = new javax.swing.JLabel();
		jPanel4 = new javax.swing.JPanel();
		jLabel2 = new javax.swing.JLabel();
		jSeparator1 = new javax.swing.JSeparator();
		jLabel4 = new javax.swing.JLabel();
		jTextField_titre = new javax.swing.JTextField();
		jLabel5 = new javax.swing.JLabel();
		jComboBox_categorie = new javax.swing.JComboBox();
		jLabel6 = new javax.swing.JLabel();
		jLabel_couleur_choser = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		jTextField_change = new javax.swing.JTextField();
		jLabel9 = new javax.swing.JLabel();
		jComboBox_zone = new javax.swing.JComboBox();
		jLabel10 = new javax.swing.JLabel();
		jTextField_telephone = new javax.swing.JTextField();
		jButton_envoyer = new javax.swing.JButton();
		jButton_importer = new javax.swing.JButton();
		jLabel_couleur = new javax.swing.JLabel();
		jProgressBar1 = new javax.swing.JProgressBar();
		jLabel_name_fichier = new javax.swing.JLabel();
		jButton_image = new javax.swing.JButton();
		jLabel25_url = new javax.swing.JLabel();
		jPanel5 = new javax.swing.JPanel();
		jLabel16 = new javax.swing.JLabel();
		jProgressBar4 = new javax.swing.JProgressBar();
		jPanel7 = new javax.swing.JPanel();
		jTextField_personne1 = new javax.swing.JComboBox();
		jTextField_personne2 = new javax.swing.JComboBox();
		jTextField_personne3 = new javax.swing.JComboBox();
		jLabel20 = new javax.swing.JLabel();
		jLabel22 = new javax.swing.JLabel();
		jPanel8 = new javax.swing.JPanel();
		jComboBox_objet1 = new javax.swing.JComboBox();
		jComboBox_objet2 = new javax.swing.JComboBox();
		jComboBox_objet3 = new javax.swing.JComboBox();
		jTextField_taxe = new javax.swing.JTextField();
		jTextFieldpersonne = new javax.swing.JTextField();
		jTextField_taxe_du = new javax.swing.JTextField();
		jLabel26 = new javax.swing.JLabel();
		jLabel27 = new javax.swing.JLabel();
		jLabel28 = new javax.swing.JLabel();
		jLabel29 = new javax.swing.JLabel();
		jTextField_date = new JFormattedTextField(new java.util.Date());
		jScrollPane3 = new javax.swing.JScrollPane();
		jTextArea_clause = new javax.swing.JTextArea();
		jScrollPane4 = new javax.swing.JScrollPane();
		jTextArea_mode = new javax.swing.JTextArea();
		jButton_envoyer1 = new javax.swing.JButton();
		jLabel31 = new javax.swing.JLabel();
		jPanel6 = new javax.swing.JPanel();
		jSeparator4 = new javax.swing.JSeparator();
		jScrollPane5 = new javax.swing.JScrollPane();
		jList_chat = new javax.swing.JList();
		jLabel30 = new javax.swing.JLabel();
		jLabel1 = new javax.swing.JLabel();
		jPanel9 = new javax.swing.JPanel();
		jLabel3 = new javax.swing.JLabel();
		jSeparator5 = new javax.swing.JSeparator();
		jScrollPane6 = new javax.swing.JScrollPane();
		jList_chat_groupe = new javax.swing.JList();
		jScrollPane7 = new javax.swing.JScrollPane();
		jList_online = new javax.swing.JList();
		jTextField_chat = new javax.swing.JTextField();
		jButton1 = new javax.swing.JButton();
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				if (JOptionPane.showConfirmDialog(null, 
						"Veuillez vraiment quitter?", "Veuillez quitter?", 
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
					try {
						m.run("q"+Traitement_xml.nom);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.exit(0);
				}
			}
		});

		jPanel1.setBackground(new java.awt.Color(39, 39, 39));

		jTabbedPane1.setBackground(new java.awt.Color(39, 39, 39));
		jTabbedPane1.setFont(new java.awt.Font("Candara", 1, 12)); // NOI18N

		jPanel2.setBackground(new java.awt.Color(39, 39, 39));

		jLabel14.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
		jLabel14.setForeground(new java.awt.Color(255, 255, 255));
		jLabel14.setText("Bonjour ");

		jTextFieldrecherche_mmanuel.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				jTextFieldrecherche_mmanuelKeyPressed(evt);
			}
		});

		jComboBox_recherhc_eategorie.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "vehicule", "immobilier", "multimedia", "loisirs", "materiel informatique" }));
		jComboBox_recherhc_eategorie.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jComboBox_recherhc_eategorieActionPerformed(evt);
			}
		});

		jComboBox_recherche_zone.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "alsace", "basse-normandie", "champagne-ardenne", "nord-pas-de-calais", "picardie" }));
		jComboBox_recherche_zone.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jComboBox_recherche_zoneActionPerformed(evt);
			}
		});

		jRadioButton_mmanuel.setBackground(new java.awt.Color(39, 39, 39));
		jRadioButton_mmanuel.setFont(new java.awt.Font("Vani", 1, 12)); // NOI18N
		jRadioButton_mmanuel.setForeground(new java.awt.Color(255, 255, 255));
		jRadioButton_mmanuel.setText("Mannuel");
		jRadioButton_mmanuel.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				jRadioButton_mmanuelItemStateChanged(evt);
			}
		});

		jRadioButton_categorie.setBackground(new java.awt.Color(39, 39, 39));
		jRadioButton_categorie.setFont(new java.awt.Font("Vani", 1, 12)); // NOI18N
		jRadioButton_categorie.setForeground(new java.awt.Color(255, 255, 255));
		jRadioButton_categorie.setText("Catégorie:");
		jRadioButton_categorie.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				jRadioButton_categorieItemStateChanged(evt);
			}
		});

		jRadioButton_zone.setBackground(new java.awt.Color(39, 39, 39));
		jRadioButton_zone.setFont(new java.awt.Font("Vani", 1, 12)); // NOI18N
		jRadioButton_zone.setForeground(new java.awt.Color(255, 255, 255));
		jRadioButton_zone.setText("Zone :");
		jRadioButton_zone.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				jRadioButton_zoneItemStateChanged(evt);
			}
		});
		jList_acceul.setFont(new java.awt.Font("Vani", 1, 12)); // NOI18N
		jList_acceul.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				//  jList_acceulMouseClicked(evt);
			}
		});
		jList_acceul.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
			public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
				jList_acceulValueChanged(evt);
			}
		});
		jScrollPane2.setViewportView(jList_acceul);

		jLabel_image_acceuil.setText(" ");

		jLabel19.setFont(new java.awt.Font("Vani", 1, 12)); // NOI18N
		jLabel19.setForeground(new java.awt.Color(255, 255, 255));
		jLabel19.setText("Titre :");

		jLabel_titre_acceuil.setFont(new java.awt.Font("Vani", 1, 12)); // NOI18N
		jLabel_titre_acceuil.setForeground(new java.awt.Color(255, 255, 255));
		jLabel_titre_acceuil.setText("");

		jLabel21.setFont(new java.awt.Font("Vani", 1, 12)); // NOI18N
		jLabel21.setForeground(new java.awt.Color(255, 255, 255));
		jLabel21.setText("Echange :");

		jLabel_echange_aceuil.setFont(new java.awt.Font("Vani", 1, 12)); // NOI18N
		jLabel_echange_aceuil.setForeground(new java.awt.Color(255, 255, 255));
		jLabel_echange_aceuil.setText(" ");

		jLabel23.setFont(new java.awt.Font("Vani", 1, 12)); // NOI18N
		jLabel23.setForeground(new java.awt.Color(255, 255, 255));
		jLabel23.setText("Télephone :");

		jLabel24.setFont(new java.awt.Font("Vani", 1, 12)); // NOI18N
		jLabel24.setForeground(new java.awt.Color(255, 255, 255));
		jLabel24.setText("Titre :");

		jLabel_nom.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
		jLabel_nom.setForeground(new java.awt.Color(255, 255, 255));
		jLabel_nom.setText("Recherche");

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(
				jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup()
						.addGap(198, 198, 198)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addGroup(jPanel2Layout.createSequentialGroup()
										.addComponent(jLabel23)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addComponent(jLabel_image_acceuil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
										.addGroup(jPanel2Layout.createSequentialGroup()
												.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabel21)
														.addComponent(jLabel19))
														.addGap(19, 19, 19)
														.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																.addComponent(jLabel_echange_aceuil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(jLabel_titre_acceuil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
																.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
																.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
																		.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																		.addComponent(jProgressBar3, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
																		.addGroup(jPanel2Layout.createSequentialGroup()
																				.addGap(195, 195, 195)
																				.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(jPanel2Layout.createSequentialGroup()
																								.addComponent(jLabel14)
																								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																								.addComponent(jLabel_nom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
																								.addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
																								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
																										.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																												.addComponent(jRadioButton_zone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																												.addGroup(jPanel2Layout.createSequentialGroup()
																														.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																																.addComponent(jRadioButton_mmanuel)
																																.addComponent(jRadioButton_categorie))
																																.addGap(0, 0, Short.MAX_VALUE)))
																																.addGap(18, 18, 18)
																																.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
																																		.addComponent(jTextFieldrecherche_mmanuel)
																																		.addComponent(jComboBox_recherhc_eategorie, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																																		.addComponent(jComboBox_recherche_zone, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))))
																																		.addGap(206, 206, 206))
				);
		jPanel2Layout.setVerticalGroup(
				jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup()
						.addGap(52, 52, 52)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel14)
								.addComponent(jLabel_nom))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jTextFieldrecherche_mmanuel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jRadioButton_mmanuel))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jComboBox_recherhc_eategorie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jRadioButton_categorie))
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jComboBox_recherche_zone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jRadioButton_zone))
														.addGap(6, 6, 6)
														.addComponent(jProgressBar3, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
														.addComponent(jLabel_image_acceuil, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
																.addComponent(jLabel19)
																.addComponent(jLabel_titre_acceuil))
																.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
																		.addComponent(jLabel21)
																		.addComponent(jLabel_echange_aceuil))
																		.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
																				.addComponent(jLabel23)
																				.addComponent(jLabel24))
																				.addContainerGap(35, Short.MAX_VALUE))
				);

		jTabbedPane1.addTab("Menu", jPanel2);

		jPanel3.setBackground(new java.awt.Color(39, 39, 39));

		jLabel7.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
		jLabel7.setForeground(new java.awt.Color(255, 255, 255));
		jLabel7.setText("MES OBJETS");

		jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
			public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
				jList1ValueChanged(evt);
			}
		});
		jScrollPane1.setViewportView(jList1);

		jLabel11.setFont(new java.awt.Font("Vani", 1, 12)); // NOI18N
		jLabel11.setForeground(new java.awt.Color(255, 255, 255));
		jLabel11.setText("Titre :");

		jTextField_titre__mo.setFont(new java.awt.Font("Vani", 1, 10)); // NOI18N

		jLabel12.setFont(new java.awt.Font("Vani", 1, 12)); // NOI18N
		jLabel12.setForeground(new java.awt.Color(255, 255, 255));
		jLabel12.setText("Catégorie :");

		jLabel13.setFont(new java.awt.Font("Vani", 1, 12)); // NOI18N
		jLabel13.setForeground(new java.awt.Color(255, 255, 255));
		jLabel13.setText("Echange :");

		jLabel15.setFont(new java.awt.Font("Vani", 1, 12)); // NOI18N
		jLabel15.setForeground(new java.awt.Color(255, 255, 255));
		jLabel15.setText("Zone :");

		jLabel17.setFont(new java.awt.Font("Vani", 1, 12)); // NOI18N
		jLabel17.setForeground(new java.awt.Color(255, 255, 255));
		jLabel17.setText("Télephone :");

		jTextField_telephone_mo.setFont(new java.awt.Font("Vani", 1, 10)); // NOI18N

		jTextField_echange_mo.setFont(new java.awt.Font("Vani", 1, 10)); // NOI18N

		jLabel18.setFont(new java.awt.Font("Vani", 1, 12)); // NOI18N
		jLabel18.setForeground(new java.awt.Color(255, 255, 255));
		jLabel18.setText("Couleur :");

		jLabel_cuoleur_choser_mo.setFont(new java.awt.Font("Vani", 1, 12)); // NOI18N
		jLabel_cuoleur_choser_mo.setForeground(new java.awt.Color(255, 255, 255));
		jLabel_cuoleur_choser_mo.setIcon(new javax.swing.ImageIcon("./src/media/navigateur-couleur-icone-5475-32.png")); // NOI18N
		jLabel_cuoleur_choser_mo.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel_cuoleur_choser_moMouseClicked(evt);
			}
		});
		jLabel_image_mo.setBackground(new java.awt.Color(39, 39, 39));
		jLabel_image_mo.setText(" ");

		jButton_modifier_mo.setIcon(new javax.swing.ImageIcon("./src/media/Modifier.png")); // NOI18N
		jButton_modifier_mo.setText("Modifier");
		jButton_modifier_mo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton_modifier_moActionPerformed(evt);
			}
		});

		jButton_supprimer_mo.setIcon(new javax.swing.ImageIcon("./src/media/suppriler.png")); // NOI18N
		jButton_supprimer_mo.setText("Supprimer");
		jButton_supprimer_mo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton_supprimer_moActionPerformed(evt);
			}
		});

		jComboBox_categorie_mo.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 11)); // NOI18N
		jComboBox_categorie_mo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "vehicule", "immobilier", "multimedia", "loisirs", "materiel informatique" }));

		jComboBox_zone_mo.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 11)); // NOI18N
		jComboBox_zone_mo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Alsace", "Basse-Normandie", "Champagne-Ardenne", "Nord-Pas-de-Calais", "Picardie" }));

		jLabelcouleur.setText(" ");

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(
				jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup()
						.addGap(33, 33, 33)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(jPanel3Layout.createSequentialGroup()
										.addGap(54, 54, 54)
										.addComponent(jLabel7))
										.addComponent(jLabel18)
										.addComponent(jLabel17)
										.addComponent(jTextField_telephone_mo)
										.addComponent(jLabel15)
										.addComponent(jLabel13)
										.addComponent(jLabel12)
										.addComponent(jScrollPane1)
										.addComponent(jLabel11)
										.addComponent(jTextField_titre__mo)
										.addComponent(jTextField_echange_mo)
										.addComponent(jComboBox_categorie_mo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jComboBox_zone_mo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(jPanel3Layout.createSequentialGroup()
												.addComponent(jLabel_cuoleur_choser_mo)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(jLabelcouleur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
												.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
														.addComponent(jButton_modifier_mo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(jButton_supprimer_mo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(jLabel_image_mo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(jProgressBar2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE))
														.addGap(29, 29, 29))
				);
		jPanel3Layout.setVerticalGroup(
				jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup()
						.addGap(37, 37, 37)
						.addComponent(jLabel7)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addGroup(jPanel3Layout.createSequentialGroup()
										.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(jPanel3Layout.createSequentialGroup()
														.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
														.addComponent(jLabel11)
														.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(jTextField_titre__mo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(jLabel12)
														.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(jComboBox_categorie_mo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(8, 8, 8)
														.addComponent(jLabel13)
														.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(jTextField_echange_mo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(7, 7, 7)
														.addComponent(jLabel15)
														.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																.addComponent(jButton_supprimer_mo)
																.addComponent(jComboBox_zone_mo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
																.addGroup(jPanel3Layout.createSequentialGroup()
																		.addComponent(jLabel_image_mo, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(18, 18, 18)
																		.addComponent(jButton_modifier_mo)))
																		.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(jLabel18))
																		.addComponent(jProgressBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																				.addGroup(jPanel3Layout.createSequentialGroup()
																						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																						.addComponent(jLabel_cuoleur_choser_mo))
																						.addGroup(jPanel3Layout.createSequentialGroup()
																								.addGap(15, 15, 15)
																								.addComponent(jLabelcouleur)))
																								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																								.addComponent(jLabel17)
																								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																								.addComponent(jTextField_telephone_mo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
																								.addContainerGap(36, Short.MAX_VALUE))
				);

		jTabbedPane1.addTab("Mes objets", jPanel3);

		jPanel4.setBackground(new java.awt.Color(39, 39, 39));

		jLabel2.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
		jLabel2.setForeground(new java.awt.Color(255, 255, 255));
		jLabel2.setText("AJOUTER UN NOUVEAU OBJET");

		jLabel4.setFont(new java.awt.Font("Vani", 1, 12)); // NOI18N
		jLabel4.setForeground(new java.awt.Color(255, 255, 255));
		jLabel4.setText("Titre :");

		jTextField_titre.setFont(new java.awt.Font("Vani", 1, 10)); // NOI18N

		jLabel5.setFont(new java.awt.Font("Vani", 1, 12)); // NOI18N
		jLabel5.setForeground(new java.awt.Color(255, 255, 255));
		jLabel5.setText("Catégorie");

		jComboBox_categorie.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 11)); // NOI18N
		jComboBox_categorie.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "vehicule", "immobilier", "multimedia", "loisirs", "materiel informatique" }));

		jLabel6.setFont(new java.awt.Font("Vani", 1, 12)); // NOI18N
		jLabel6.setForeground(new java.awt.Color(255, 255, 255));
		jLabel6.setText("Couleur");

		jLabel_couleur_choser.setFont(new java.awt.Font("Vani", 1, 12)); // NOI18N
		jLabel_couleur_choser.setForeground(new java.awt.Color(255, 255, 255));
		jLabel_couleur_choser.setIcon(new javax.swing.ImageIcon("./src/media/navigateur-couleur-icone-5475-32.png")); // NOI18N
		jLabel_couleur_choser.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel_couleur_choserMouseClicked(evt);
			}
		});

		jLabel8.setFont(new java.awt.Font("Vani", 1, 12)); // NOI18N
		jLabel8.setForeground(new java.awt.Color(255, 255, 255));
		jLabel8.setText("Echange :");

		jTextField_change.setFont(new java.awt.Font("Vani", 1, 10)); // NOI18N

		jLabel9.setFont(new java.awt.Font("Vani", 1, 12)); // NOI18N
		jLabel9.setForeground(new java.awt.Color(255, 255, 255));
		jLabel9.setText("Zone :");

		jComboBox_zone.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 11)); // NOI18N
		jComboBox_zone.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Alsace", "Basse-Normandie", "Champagne-Ardenne", "Nord-Pas-de-Calais", "Picardie" }));

		jLabel10.setFont(new java.awt.Font("Vani", 1, 12)); // NOI18N
		jLabel10.setForeground(new java.awt.Color(255, 255, 255));
		jLabel10.setText("Télephone :");

		jTextField_telephone.setFont(new java.awt.Font("Vani", 1, 10)); // NOI18N

		jButton_envoyer.setText("Envoyer");
		jButton_envoyer.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton_envoyerActionPerformed(evt);
			}
		});

		jButton_importer.setText("Importer");
		jButton_importer.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton_importerActionPerformed(evt);
			}
		});



		jLabel_couleur.setBackground(new java.awt.Color(255, 153, 153));
		jLabel_couleur.setForeground(new java.awt.Color(102, 204, 0));
		jLabel_couleur.setText("                       ");

		jLabel_name_fichier.setFont(new java.awt.Font("Vani", 1, 12)); // NOI18N
		jLabel_name_fichier.setForeground(new java.awt.Color(255, 255, 255));
		jLabel_name_fichier.setText("");

		jButton_image.setIcon(new javax.swing.ImageIcon("./src/media/rss-image-flux-reflet-04-icone-6830-16.png")); // NOI18N
		jButton_image.setText("image");
		jButton_image.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton_imageActionPerformed(evt);
			}
		});
		jLabel25_url.setFont(new java.awt.Font("Vani", 1, 12)); // NOI18N
		jLabel25_url.setForeground(new java.awt.Color(255, 255, 255));
		jLabel25_url.setText("");

		javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
		jPanel4.setLayout(jPanel4Layout);
		jPanel4Layout.setHorizontalGroup(
				jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel4Layout.createSequentialGroup()
						.addGap(207, 207, 207)
						.addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(jSeparator1)
								.addGroup(jPanel4Layout.createSequentialGroup()
										.addGap(16, 16, 16)
										.addComponent(jLabel2))
										.addComponent(jTextField_telephone)
										.addComponent(jComboBox_zone, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jTextField_change)
										.addComponent(jLabel9)
										.addGroup(jPanel4Layout.createSequentialGroup()
												.addComponent(jLabel8)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(jLabel25_url, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
												.addComponent(jLabel4)
												.addComponent(jLabel10)
												.addGroup(jPanel4Layout.createSequentialGroup()
														.addComponent(jLabel_couleur_choser)
														.addGap(37, 37, 37)
														.addComponent(jLabel_couleur)
														.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(jButton_image))
														.addComponent(jTextField_titre)
														.addComponent(jLabel5)
														.addComponent(jComboBox_categorie, 0, 301, Short.MAX_VALUE)
														.addComponent(jLabel6)
														.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
																.addComponent(jButton_envoyer)
																.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
																.addComponent(jButton_importer))
																.addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(jLabel_name_fichier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
																.addContainerGap(216, Short.MAX_VALUE))
				);
		jPanel4Layout.setVerticalGroup(
				jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel4Layout.createSequentialGroup()
						.addGap(54, 54, 54)
						.addComponent(jLabel2)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(jLabel4)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jTextField_titre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jLabel5)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jComboBox_categorie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jLabel6)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel_couleur_choser)
								.addGroup(jPanel4Layout.createSequentialGroup()
										.addGap(5, 5, 5)
										.addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel_couleur)
												.addComponent(jButton_image))))
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel8)
														.addComponent(jLabel25_url))
														.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(jTextField_change, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(jLabel9)
														.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(jComboBox_zone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(jLabel10)
														.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(jTextField_telephone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(18, 18, 18)
														.addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(10, 10, 10)
														.addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
																.addComponent(jButton_envoyer)
																.addComponent(jButton_importer))
																.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																.addComponent(jLabel_name_fichier)
																.addContainerGap(23, Short.MAX_VALUE))
				);

		jTabbedPane1.addTab("Ajouter un objet", jPanel4);

		jPanel5.setBackground(new java.awt.Color(39, 39, 39));

		jLabel16.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
		jLabel16.setForeground(new java.awt.Color(255, 255, 255));
		jLabel16.setText("Formulaire de génération de contrat au format PDF");

		jPanel7.setBackground(new java.awt.Color(204, 204, 204));

		javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
		jPanel7.setLayout(jPanel7Layout);
		jPanel7Layout.setHorizontalGroup(
				jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel7Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jTextField_personne1)
								.addComponent(jTextField_personne2, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
								.addComponent(jTextField_personne3, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
								.addContainerGap())
				);
		jPanel7Layout.setVerticalGroup(
				jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel7Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jTextField_personne1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jTextField_personne2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jTextField_personne3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);

		jLabel20.setFont(new java.awt.Font("Vani", 1, 12)); // NOI18N
		jLabel20.setForeground(new java.awt.Color(255, 255, 255));
		jLabel20.setText("Personne concernées :");

		jLabel22.setFont(new java.awt.Font("Vani", 1, 12)); // NOI18N
		jLabel22.setForeground(new java.awt.Color(255, 255, 255));
		jLabel22.setText("Objets concernées :");

		jPanel8.setBackground(new java.awt.Color(204, 204, 204));

		javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
		jPanel8.setLayout(jPanel8Layout);
		jPanel8Layout.setHorizontalGroup(
				jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel8Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jComboBox_objet1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jComboBox_objet2, javax.swing.GroupLayout.Alignment.TRAILING, 0, 168, Short.MAX_VALUE)
								.addComponent(jComboBox_objet3, 0, 168, Short.MAX_VALUE))
								.addContainerGap())
				);
		jPanel8Layout.setVerticalGroup(
				jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel8Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jComboBox_objet1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jComboBox_objet2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jComboBox_objet3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				);

		jLabel26.setFont(new java.awt.Font("Vani", 1, 12)); // NOI18N
		jLabel26.setForeground(new java.awt.Color(255, 255, 255));
		jLabel26.setText("Montant de Taxe :");

		jLabel27.setFont(new java.awt.Font("Vani", 1, 12)); // NOI18N
		jLabel27.setForeground(new java.awt.Color(255, 255, 255));
		jLabel27.setText("Taxe due a :");

		jLabel28.setFont(new java.awt.Font("Vani", 1, 12)); // NOI18N
		jLabel28.setForeground(new java.awt.Color(255, 255, 255));
		jLabel28.setText("Personne qui devra payer :");

		jLabel29.setFont(new java.awt.Font("Vani", 1, 12)); // NOI18N
		jLabel29.setForeground(new java.awt.Color(255, 255, 255));
		jLabel29.setText("Date Limite de réception :");

		jTextArea_clause.setColumns(20);
		jTextArea_clause.setRows(5);
		jScrollPane3.setViewportView(jTextArea_clause);

		jTextArea_mode.setColumns(20);
		jTextArea_mode.setRows(5);
		jScrollPane4.setViewportView(jTextArea_mode);

		jButton_envoyer1.setText("Envoyer");
		jButton_envoyer1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton_envoyer1ActionPerformed(evt);
			}
		});

		jLabel31.setFont(new java.awt.Font("Vani", 1, 12)); // NOI18N
		jLabel31.setForeground(new java.awt.Color(255, 255, 255));
		jLabel31.setText("Clause de rupture :");

		javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
		jPanel5.setLayout(jPanel5Layout);
		jPanel5Layout.setHorizontalGroup(
				jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
						.addContainerGap(142, Short.MAX_VALUE)
						.addComponent(jLabel16)
						.addGap(139, 139, 139))
						.addGroup(jPanel5Layout.createSequentialGroup()
								.addGap(33, 33, 33)
								.addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(jPanel5Layout.createSequentialGroup()
												.addComponent(jLabel31)
												.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
												.addGroup(jPanel5Layout.createSequentialGroup()
														.addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
																.addComponent(jScrollPane3)
																.addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
																		.addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
																				.addComponent(jLabel22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																				.addComponent(jPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
																				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																				.addComponent(jButton_envoyer1))
																				.addGroup(jPanel5Layout.createSequentialGroup()
																						.addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
																								.addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																								.addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
																								.addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																										.addGroup(jPanel5Layout.createSequentialGroup()
																												.addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																														.addGroup(jPanel5Layout.createSequentialGroup()
																																.addGap(63, 63, 63)
																																.addComponent(jLabel27)
																																.addGap(102, 102, 102))
																																.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
																																		.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																																		.addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																																				.addComponent(jLabel26)
																																				.addComponent(jLabel28))
																																				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
																																				.addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																																						.addComponent(jTextField_taxe)
																																						.addComponent(jTextFieldpersonne)
																																						.addComponent(jTextField_taxe_du, javax.swing.GroupLayout.Alignment.TRAILING)))
																																						.addGroup(jPanel5Layout.createSequentialGroup()
																																								.addGap(63, 63, 63)
																																								.addComponent(jLabel29)
																																								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																																								.addComponent(jTextField_date))))
																																								.addComponent(jProgressBar4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																																								.addComponent(jScrollPane4))
																																								.addGap(40, 40, 40))))
				);
		jPanel5Layout.setVerticalGroup(
				jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel5Layout.createSequentialGroup()
						.addGap(24, 24, 24)
						.addComponent(jLabel16)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jProgressBar4, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(24, 24, 24)
						.addComponent(jLabel20)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel5Layout.createSequentialGroup()
										.addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jTextField_taxe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel26))
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
												.addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jTextFieldpersonne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel28))
														.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
														.addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
																.addComponent(jTextField_taxe_du, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(jLabel27))
																.addGap(19, 19, 19))
																.addGroup(jPanel5Layout.createSequentialGroup()
																		.addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
																		.addComponent(jLabel22)
																		.addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
																				.addGroup(jPanel5Layout.createSequentialGroup()
																						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																						.addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
																						.addGroup(jPanel5Layout.createSequentialGroup()
																								.addGap(15, 15, 15)
																								.addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
																										.addComponent(jTextField_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addComponent(jLabel29))
																										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																										.addComponent(jButton_envoyer1)))
																										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																										.addComponent(jLabel31)
																										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																										.addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addGap(18, 18, 18)
																										.addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addGap(22, 22, 22))
				);

		jTabbedPane1.addTab("Générer un PDF", jPanel5);

		jPanel6.setBackground(new java.awt.Color(39, 39, 39));

		jScrollPane5.setViewportView(jList_chat);

		jLabel1.setIcon(new javax.swing.ImageIcon("./src/media/navigateur-globe-internet-reseau-monde-icone-9389-128.png")); // NOI18N

		javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
		jPanel6.setLayout(jPanel6Layout);
		jPanel6Layout.setHorizontalGroup(
				jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel6Layout.createSequentialGroup()
						.addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel6Layout.createSequentialGroup()
										.addGap(285, 285, 285)
										.addComponent(jLabel30)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(jLabel1))
										.addGroup(jPanel6Layout.createSequentialGroup()
												.addGap(173, 173, 173)
												.addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
														.addComponent(jSeparator4)
														.addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE))))
														.addGap(183, 183, 183))
				);
		jPanel6Layout.setVerticalGroup(
				jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel6Layout.createSequentialGroup()
						.addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel6Layout.createSequentialGroup()
										.addGap(73, 73, 73)
										.addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(29, 29, 29))
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
												.addContainerGap()
												.addComponent(jLabel1)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
												.addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addContainerGap(159, Short.MAX_VALUE))
				);

		jTabbedPane1.addTab("Connexion Groupe", jPanel6);
		jPanel9.setBackground(new java.awt.Color(39, 39, 39));
		jLabel3.setIcon(new javax.swing.ImageIcon("./src/media/email.png")); // NOI18N

		jList_chat_groupe.setFont(new java.awt.Font("Vani", 1, 12)); // NOI18N
		jScrollPane6.setViewportView(jList_chat_groupe);

		jList_online.setFont(new java.awt.Font("Vani", 1, 12)); // NOI18N
		jList_online.setForeground(new java.awt.Color(0, 204, 51));
		jScrollPane7.setViewportView(jList_online);

		jTextField_chat.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				jTextField_chatKeyPressed(evt);
			}
		});


		jButton1.setText("Envoyer");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
		jPanel9.setLayout(jPanel9Layout);
		jPanel9Layout.setHorizontalGroup(
				jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jLabel3)
						.addGap(295, 295, 295))
						.addGroup(jPanel9Layout.createSequentialGroup()
								.addGap(147, 147, 147)
								.addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(jPanel9Layout.createSequentialGroup()
												.addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
														.addComponent(jTextField_chat, javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE))
														.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
																.addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
																.addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)))
																.addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE))
																.addContainerGap(166, Short.MAX_VALUE))
				);
		jPanel9Layout.setVerticalGroup(
				jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel9Layout.createSequentialGroup()
						.addGap(69, 69, 69)
						.addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jTextField_chat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jButton1))
										.addContainerGap(162, Short.MAX_VALUE))
				);

		jTabbedPane1.addTab("Chat Groupe", jPanel9);

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jTabbedPane1)
				);
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jTabbedPane1)
				);

		jTabbedPane1.getAccessibleContext().setAccessibleName("Menu");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				);

		pack();
	}// </editor-fold>                        

	/**
	 * methode permettant la gestion du tchat
	 */  
	public void send_tchat(String phrase){
		try {
			m.run("0"+Traitement_xml.nom+" : "+phrase);
		} catch (IOException e) {
			e.printStackTrace();
		}
		jTextField_chat.setText("");
		notif();
	}

	/**
	 * methode permet d'envoyer une phrase en brodcast (gestion KeyListener)
	 */
	private void jTextField_chatKeyPressed(java.awt.event.KeyEvent evt) {                                           
		if (evt.getKeyCode()==KeyEvent.VK_ENTER){
			send_tchat(jTextField_chat.getText());
		}

	} 

	/**
	 * methode permet d'envoyer une phrase en brodcast (gestion ActionListener)
	 */
	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {   
		if(!jTextField_chat.getText().equals("")){
			send_tchat(jTextField_chat.getText());
		}
	}  

	/**
	 * methode permet d'importer une image
	 */
	private void jButton_imageActionPerformed(java.awt.event.ActionEvent evt) {                                              
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"JPG & GIF Images", "jpg", "gif");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(null);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			jLabel25_url.setText(chooser.getSelectedFile().getName());
		}
	}    

	private void jRadioButton_mmanuelItemStateChanged(java.awt.event.ItemEvent evt) {                                                      
		jComboBox_recherhc_eategorie.setEnabled(false);
		jComboBox_recherche_zone.setEnabled(false);
		jTextFieldrecherche_mmanuel.setEnabled(true);
	} 

	private void jRadioButton_categorieItemStateChanged(java.awt.event.ItemEvent evt) {                                                        
		jTextFieldrecherche_mmanuel.setEnabled(false);
		jComboBox_recherche_zone.setEnabled(false);
		jComboBox_recherhc_eategorie.setEnabled(true);

	}  
	private void jRadioButton_zoneItemStateChanged(java.awt.event.ItemEvent evt) {                                                   
		jTextFieldrecherche_mmanuel.setEnabled(false);
		jComboBox_recherche_zone.setEnabled(true);
		jComboBox_recherhc_eategorie.setEnabled(false);
	} 

	/**
	 * methode permettant d'afficher un objet
	 */
	private void jList_acceulValueChanged(javax.swing.event.ListSelectionEvent evt) {                                          
		Traitement_xml.recuper_info_objet((String)jList_acceul.getSelectedValue());
		jLabel_titre_acceuil.setText((String)jList_acceul.getSelectedValue());
		jLabel_echange_aceuil.setText(Traitement_xml.echange);
		jLabel24.setText(Traitement_xml.telephone);
		jLabel_image_acceuil.setIcon(new javax.swing.ImageIcon("./src/media/"+Traitement_xml.url)); // NOI18N
	} 

	/**
	 * methode permettant la recherche d'un objet par catégorie
	 */
	private void jComboBox_recherhc_eategorieActionPerformed(java.awt.event.ActionEvent evt) {      

		listModel.removeAllElements();	
		Traitement_xml.recherche_type("categorie",(String)jComboBox_recherhc_eategorie.getSelectedItem());
		monThread2= new Thread(new MonRunnable2());
		monThread2.start();
	} 

	/**
	 * methode permettant la recherche d'un objet par zone
	 */
	private void jComboBox_recherche_zoneActionPerformed(java.awt.event.ActionEvent evt) {   

		listModel.removeAllElements();	
		Traitement_xml.recherche_type("zone",(String)jComboBox_recherche_zone.getSelectedItem());
		monThread2= new Thread(new MonRunnable2());
		monThread2.start();
	}     

	/**
	 * methode permettant la recherche d'un objet manuellement
	 */
	private void jTextFieldrecherche_mmanuelKeyPressed(java.awt.event.KeyEvent evt) {                                                       
		int key = evt.getKeyCode();
		if (key == KeyEvent.VK_ENTER) {
			listModel.removeAllElements();	
			Traitement_xml.recherche_type("titre",jTextFieldrecherche_mmanuel.getText());
			monThread2= new Thread(new MonRunnable2());
			monThread2.start();
		}
	}      

	/**
	 * methode permettant la modification d'un objet existant
	 */
	@SuppressWarnings("unchecked")
	private void jButton_modifier_moActionPerformed(java.awt.event.ActionEvent evt) {  
		son = true;

		if((changer) ){
			if(Traitement_xml.isPhoneNumberCorrect(jTextField_telephone_mo.getText()))  {
				String titre=(String)jList1.getSelectedValue();
				String image = Traitement_xml.recuper_image(titre);

				Traitement_xml.create_objet_send(jTextField_titre__mo.getText(),
						Connexion.email_courant,(String)jComboBox_categorie_mo.getSelectedItem(),
						(jLabelcouleur.getBackground()).toString(),jTextField_echange_mo.getText(),
						jTextField_telephone_mo.getText(),image,(String)jComboBox_zone_mo.getSelectedItem());

				monThread= new Thread(new MonRunnable4());
				monThread.start();
				Traitement_xml.lecutre();
				listModel3.removeElement(titre);
				jList1.setModel(listModel3);
				Traitement_xml.objet_utilisateur.clear();
				listModel3.clear();
				jList1.setModel(listModel3);

				Traitement_xml.recherche_objet_utilisateur(Connexion.email_courant);
				for (int i = 0; i < Traitement_xml.objet_utilisateur.size(); i++) {
					listModel3.addElement(Traitement_xml.objet_utilisateur.get(i));
				}
				jList1.setModel(listModel3);

				Traitement_xml.Liste_objet();
				jComboBox_objet1.removeAllItems();
				jComboBox_objet2.removeAllItems();
				jComboBox_objet3.removeAllItems();
				for (int i = 0; i < Traitement_xml.Liste_objet.size(); i++) {
					Page_principale.jComboBox_objet1.addItem(Traitement_xml.Liste_objet.get(i));
					Page_principale.jComboBox_objet2.addItem(Traitement_xml.Liste_objet.get(i));
					Page_principale.jComboBox_objet3.addItem(Traitement_xml.Liste_objet.get(i));
				}

			}else{
				JOptionPane.showMessageDialog(null, "Format de votre numero de telephone est incorrect", "Erreur modification", JOptionPane.ERROR_MESSAGE);

			}
		}else{
			JOptionPane.showMessageDialog(null, "Voue devez remplire tout les champs ", "Erreur modification", JOptionPane.ERROR_MESSAGE);

		}
		son = false;
	}                                                   

	/**
	 * methode permettant la suppresion d'un objet
	 */
	private void jButton_supprimer_moActionPerformed(java.awt.event.ActionEvent evt) {   
		monThread= new Thread(new MonRunnable3());
		monThread.start();  
	}

	/**
	 * methode permet de choisir une couleur pour l'objet
	 */
	private void jLabel_couleur_choserMouseClicked(java.awt.event.MouseEvent evt) {                                                   
		Color initialBackground = jLabel_couleur.getBackground();

		Color background = JColorChooser.showDialog(null,
				"JColorChooser Sample", initialBackground);

		if (background != null) {
			jLabel_couleur.setOpaque(true);
			jLabel_couleur.setBackground(background);

		}
	}                

	/**
	 * methode permettant d'envoyer un objet en broadcast en vérifiant le format
	 */
	@SuppressWarnings("unchecked")
	private void jButton_envoyerActionPerformed(java.awt.event.ActionEvent evt) {       

		if(jLabel_name_fichier.getText().equals("")){

			if(!(jTextField_titre.getText().equals("") || jTextField_change.getText().equals("") || 
					jTextField_telephone.getText().equals("") || jLabel25_url.getText().equals("") || !Traitement_xml.isPhoneNumberCorrect(jTextField_telephone.getText()))){

				Traitement_xml.create_objet_send(jTextField_titre.getText(),
						Connexion.email_courant,(String)jComboBox_categorie.getSelectedItem(),
						(jLabel_couleur.getBackground()).toString(),jTextField_change.getText(),
						jTextField_telephone.getText(),jLabel25_url.getText(),(String)jComboBox_zone.getSelectedItem());

				monThread= new Thread(new MonRunnable());
				monThread.start();

			}else{
				JOptionPane.showMessageDialog(null, "Voue devez remplire tout les champs pour ajouter votre objet", "Erreur objet", JOptionPane.ERROR_MESSAGE);

			}
		}else{
			if(Traitement_xml.traitement(jLabel_name_fichier.getText())){

				Traitement_xml.lecutre_browser(jLabel_name_fichier.getText());
				Traitement_xml.objet_utilisateur.clear();
				listModel3.clear();
				jList1.setModel(listModel3);

				Traitement_xml.recherche_objet_utilisateur(Connexion.email_courant);
				for (int i = 0; i < Traitement_xml.objet_utilisateur.size(); i++) {
					listModel3.addElement(Traitement_xml.objet_utilisateur.get(i));
				}
				jList1.setModel(listModel3);
				listModel2.addElement((Traitement_xml.nom).toUpperCase()+" "+Traitement_xml.prenom+" Viens d'exporter un fichier");
				Traitement_xml.Liste_objet();
				jComboBox_objet1.removeAllItems();
				jComboBox_objet2.removeAllItems();
				jComboBox_objet3.removeAllItems();
				for (int i = 0; i < Traitement_xml.Liste_objet.size(); i++) {
					Page_principale.jComboBox_objet1.addItem(Traitement_xml.Liste_objet.get(i));
					Page_principale.jComboBox_objet2.addItem(Traitement_xml.Liste_objet.get(i));
					Page_principale.jComboBox_objet3.addItem(Traitement_xml.Liste_objet.get(i));
				}
			}else{
				JOptionPane.showMessageDialog(null, "Votre fichier ne respect pas le format demandé", "Erreur objet", JOptionPane.ERROR_MESSAGE);

			}}}

	/**
	 * methode permet de choisir une couleur pour l'objet
	 */
	private void jLabel_cuoleur_choser_moMouseClicked(java.awt.event.MouseEvent evt) {                                                      
		Color initialBackground = jLabelcouleur.getBackground();

		Color background = JColorChooser.showDialog(null,
				"JColorChooser Sample", initialBackground);

		if (background != null) {
			jLabelcouleur.setOpaque(true);
			jLabelcouleur.setBackground(background);
			changer=true;

		}
	}    

	/**
	 * methode permet d'importer un fichier objet format XML
	 */
	private void jButton_importerActionPerformed(java.awt.event.ActionEvent evt) {                                                 
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"XML", "xml", "xml");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(null);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			jLabel_name_fichier.setText(chooser.getSelectedFile().getName());
		}
	}                                     

	/**
	 * methode permettant la creation du contrat sous format pdf 
	 */
	private void jButton_envoyer1ActionPerformed(java.awt.event.ActionEvent evt) {      
		monThread= new Thread(new MonRunnable5());
		monThread.start();
	}      

	/**
	 * methode permet d'afficher les informations d'un objet
	 */
	private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {                                    
		Traitement_xml.recuper_info_mes_objet((String)jList1.getSelectedValue());
		jTextField_titre__mo.setText((String)jList1.getSelectedValue());
		jTextField_echange_mo.setText(Traitement_xml.echange2);
		jLabel_image_mo.setIcon(new javax.swing.ImageIcon("./src/media/"+Traitement_xml.url2));
		jTextField_telephone_mo.setText(Traitement_xml.telephone2);
	}   

	public static void main(String args[]) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Page_principale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Page_principale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Page_principale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Page_principale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Page_principale().setVisible(true);


			}
		});
	}
	private javax.swing.JButton jButton_envoyer;
	private javax.swing.JButton jButton_envoyer1;
	private javax.swing.JButton jButton_image;
	private javax.swing.JButton jButton_importer;
	private javax.swing.JButton jButton_modifier_mo;
	private javax.swing.JButton jButton_supprimer_mo;
	private javax.swing.JComboBox jComboBox_categorie;
	private static javax.swing.JComboBox jComboBox_categorie_mo;
	public static javax.swing.JComboBox jComboBox_objet1;
	public static javax.swing.JComboBox jComboBox_objet2;
	public static javax.swing.JComboBox jComboBox_objet3;
	private javax.swing.JComboBox jComboBox_recherche_zone;
	private javax.swing.JComboBox jComboBox_recherhc_eategorie;
	private javax.swing.JComboBox jComboBox_zone;
	private static javax.swing.JComboBox jComboBox_zone_mo;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel14;
	private javax.swing.JLabel jLabel15;
	private javax.swing.JLabel jLabel16;
	private javax.swing.JLabel jLabel17;
	private javax.swing.JLabel jLabel18;
	private javax.swing.JLabel jLabel19;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel20;
	private javax.swing.JLabel jLabel21;
	private javax.swing.JLabel jLabel22;
	private javax.swing.JLabel jLabel23;
	private javax.swing.JLabel jLabel24;
	private javax.swing.JLabel jLabel26;
	private javax.swing.JLabel jLabel27;
	private javax.swing.JLabel jLabel28;
	private javax.swing.JLabel jLabel29;
	private javax.swing.JLabel jLabel30;
	private javax.swing.JLabel jLabel31;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JLabel jLabel_couleur;
	private javax.swing.JLabel jLabel_couleur_choser;
	private javax.swing.JLabel jLabel_cuoleur_choser_mo;
	private javax.swing.JLabel jLabel_echange_aceuil;
	private javax.swing.JLabel jLabel_image_acceuil;
	private javax.swing.JLabel jLabel_image_mo;
	private javax.swing.JLabel jLabel_name_fichier;
	private javax.swing.JLabel jLabel_nom;
	private javax.swing.JLabel jLabel_titre_acceuil;
	private static javax.swing.JList jList1;
	private javax.swing.JList jList_acceul;
	public static javax.swing.JList jList_chat;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JPanel jPanel5;
	private javax.swing.JPanel jPanel6;
	private javax.swing.JPanel jPanel7;
	private javax.swing.JPanel jPanel8;
	private javax.swing.JProgressBar jProgressBar1;
	private javax.swing.JProgressBar jProgressBar2;
	private javax.swing.JProgressBar jProgressBar3;
	private javax.swing.JProgressBar jProgressBar4;
	private javax.swing.JRadioButton jRadioButton_categorie;
	private javax.swing.JRadioButton jRadioButton_mmanuel;
	private javax.swing.JRadioButton jRadioButton_zone;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JScrollPane jScrollPane4;
	private javax.swing.JScrollPane jScrollPane5;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JSeparator jSeparator2;
	private javax.swing.JSeparator jSeparator3;
	private javax.swing.JSeparator jSeparator4;
	private javax.swing.JTabbedPane jTabbedPane1;
	private javax.swing.JTextArea jTextArea_clause;
	private javax.swing.JTextArea jTextArea_mode;
	private javax.swing.JTextField jTextField_change;
	private javax.swing.JFormattedTextField jTextField_date;
	private javax.swing.JLabel jLabel25_url;
	private static javax.swing.JTextField jTextField_echange_mo;
	private javax.swing.JComboBox jTextField_personne1;
	private javax.swing.JComboBox jTextField_personne2;
	private static javax.swing.JLabel jLabelcouleur;
	private javax.swing.JComboBox jTextField_personne3;
	private javax.swing.JTextField jTextField_taxe;
	private javax.swing.JTextField jTextField_taxe_du;
	private javax.swing.JTextField jTextField_telephone;
	private static javax.swing.JTextField jTextField_telephone_mo;
	private javax.swing.JTextField jTextField_titre;
	private static javax.swing.JTextField jTextField_titre__mo;
	private javax.swing.JTextField jTextFieldpersonne;
	private javax.swing.JTextField jTextFieldrecherche_mmanuel;
	private javax.swing.JPanel jPanel9;
	private javax.swing.JLabel jLabel3;
	public static javax.swing.JList jList_online;
	private javax.swing.JTextField jTextField_chat;
	private javax.swing.JButton jButton1;
	public static javax.swing.JList jList_chat_groupe;
	private javax.swing.JSeparator jSeparator5;
	private javax.swing.JScrollPane jScrollPane6;
	private javax.swing.JScrollPane jScrollPane7;

	public class MonRunnable  implements Runnable
	{
		@SuppressWarnings({ "static-access", "unchecked" })
		public void run()
		{
			for (int j = 1; j < 100; j++)
			{
				jProgressBar1.setValue(j);
				try
				{
					monThread.sleep(50);

				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			Traitement_xml.lecutre();
			Traitement_xml.objet_utilisateur.clear();
			listModel3.clear();
			jList1.setModel(listModel3);
			Traitement_xml.recherche_objet_utilisateur(Connexion.email_courant);
			for (int i = 0; i < Traitement_xml.objet_utilisateur.size(); i++) {
				listModel3.addElement(Traitement_xml.objet_utilisateur.get(i));
			}
			jList1.setModel(listModel3);
			Traitement_xml.Liste_objet();
			jComboBox_objet1.removeAllItems();
			jComboBox_objet2.removeAllItems();
			jComboBox_objet3.removeAllItems();
			for (int i = 0; i < Traitement_xml.Liste_objet.size(); i++) {
				Page_principale.jComboBox_objet1.addItem(Traitement_xml.Liste_objet.get(i));
				Page_principale.jComboBox_objet2.addItem(Traitement_xml.Liste_objet.get(i));
				Page_principale.jComboBox_objet3.addItem(Traitement_xml.Liste_objet.get(i));
			}

		}
	}


	public class MonRunnable2  implements Runnable
	{
		@SuppressWarnings({ "static-access", "unchecked" })
		public void run()
		{

			for (int j = 1; j < 100; j++)
			{
				jProgressBar3.setValue(j);
				try
				{
					monThread2.sleep(10);

				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			for (int j = 0; j < Traitement_xml.Liste_trait.size(); j++) {
				listModel.addElement(Traitement_xml.Liste_trait.get(j));
			}
			jList_acceul.setModel(listModel);

		}
	}


	public class MonRunnable3  implements Runnable
	{
		@SuppressWarnings("static-access")
		public void run()
		{

			for (int j = 1; j < 100; j++)
			{
				jProgressBar2.setValue(j);
				try
				{
					monThread3.sleep(30);

				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			if(jList1.getModel().getSize() != 0) {
				try {
					m.run("3"+(String)jList1.getSelectedValue());
				} catch (IOException e) {
					e.printStackTrace();
				}
				jTextField_titre__mo.setText("");
				jTextField_echange_mo.setText("");
				jTextField_telephone_mo.setText("");
				jLabel_image_mo.setIcon(new javax.swing.ImageIcon("         "+"./src/media/suprimer.png")); // NOI18N


			}else{
				jButton_modifier_mo.setEnabled(false);
				jButton_supprimer_mo.setEnabled(false);
			}  

		}
	}

	public class MonRunnable4  implements Runnable
	{
		String titre=(String)jList1.getSelectedValue();
		String image = Traitement_xml.recuper_image(titre);
		@SuppressWarnings("static-access")
		public void run()
		{

			for (int j = 1; j < 100; j++)
			{
				jProgressBar2.setValue(j);
				try
				{
					monThread3.sleep(40);

				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}

			if(jList1.getModel().getSize() != 0) {
				try {
					m.run("4"+(String)jList1.getSelectedValue());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else{
				jButton_modifier_mo.setEnabled(false);
				jButton_supprimer_mo.setEnabled(false);
			}  

		}
	}

	@SuppressWarnings("unchecked")
	public static void remove_p2p(String msg){
		int ligne = Traitement_xml.re_int(msg);
		try {
			Traitement_xml.remove_ligne(ligne+7);

			Traitement_xml.remove_ligne(ligne+6);
			Traitement_xml.remove_ligne(ligne+5);
			Traitement_xml.remove_ligne(ligne+4);
			Traitement_xml.remove_ligne(ligne+3);
			Traitement_xml.remove_ligne(ligne+2);
			Traitement_xml.remove_ligne(ligne+1);
			Traitement_xml.remove_ligne(ligne);
			Traitement_xml.remove_ligne(ligne-1);
			Traitement_xml.remove_ligne(ligne-2);
			Traitement_xml.remove_ligne(ligne-3);
			Traitement_xml.remove_ligne(ligne-4);
		} catch (IOException e) {
			e.printStackTrace();
		}

		listModel2.addElement("Un nouveau objet supprimer");
		jList_chat.setModel(listModel2);
		Traitement_xml.objet_utilisateur.clear();
		listModel3.clear();
		jList1.setModel(listModel3);
		Traitement_xml.recherche_objet_utilisateur(Connexion.email_courant);
		for (int i = 0; i < Traitement_xml.objet_utilisateur.size(); i++) {
			listModel3.addElement(Traitement_xml.objet_utilisateur.get(i));
		}
		jList1.setModel(listModel3);
		Traitement_xml.Liste_objet();
		jComboBox_objet1.removeAllItems();
		jComboBox_objet2.removeAllItems();
		jComboBox_objet3.removeAllItems();
		for (int i = 0; i < Traitement_xml.Liste_objet.size(); i++) {
			Page_principale.jComboBox_objet1.addItem(Traitement_xml.Liste_objet.get(i));
			Page_principale.jComboBox_objet2.addItem(Traitement_xml.Liste_objet.get(i));
			Page_principale.jComboBox_objet3.addItem(Traitement_xml.Liste_objet.get(i));
		}
		Traiement_son_remove_objet a = new Traiement_son_remove_objet();
		a.start();

	}


	public static void update_p2p(String msg){
		son=true;
		update = true;
		int ligne = Traitement_xml.re_int(msg);
		try {
			Traitement_xml.remove_ligne(ligne+7);

			Traitement_xml.remove_ligne(ligne+6);
			Traitement_xml.remove_ligne(ligne+5);
			Traitement_xml.remove_ligne(ligne+4);
			Traitement_xml.remove_ligne(ligne+3);
			Traitement_xml.remove_ligne(ligne+2);
			Traitement_xml.remove_ligne(ligne+1);
			Traitement_xml.remove_ligne(ligne);
			Traitement_xml.remove_ligne(ligne-1);
			Traitement_xml.remove_ligne(ligne-2);
			Traitement_xml.remove_ligne(ligne-3);
			Traitement_xml.remove_ligne(ligne-4);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Traiement_son_update_objet a = new Traiement_son_update_objet();
		a.start();

	}

	public class MonRunnable5  implements Runnable
	{
		@SuppressWarnings("static-access")
		public void run()
		{
			for (int j = 1; j < 100; j++) // on fait une boucle pour que la JProgressBar "avance"
			{
				jProgressBar4.setValue(j);
				try
				{
					monThread3.sleep(40);

				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}

			try {
				try {
					new Creat_PDF().createPdf(RESULT,(String)jTextField_personne1.getSelectedItem(),
							(String)jTextField_personne2.getSelectedItem(),
							(String)jTextField_personne3.getSelectedItem(),
							(String)jComboBox_objet1.getSelectedItem(),
							(String)jComboBox_objet2.getSelectedItem(),
							(String)jComboBox_objet3.getSelectedItem(),
							jTextArea_clause.getText(),
							jTextArea_mode.getText(),
							jTextField_taxe.getText(),
							jTextFieldpersonne.getText(),
							jTextField_taxe_du.getText(),
							jTextField_date.getText());
				} catch (DocumentException e) {
					e.printStackTrace();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}  
			Desktop desk = Desktop.getDesktop();
			try {
				desk.open(new File("./src/media/Contrat.pdf"));
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}


	public static void notif(){

		try {
			m.run("9"+Traitement_xml.nom);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
