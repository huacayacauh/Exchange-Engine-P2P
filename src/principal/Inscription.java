package principal;
import javax.swing.JOptionPane;

import traitement.Traitement_xml;



/**
 *
 * @author El MEHDI
 *  Classe permettant l'inscription d'un nouvel utilisateur
 */
@SuppressWarnings("serial")
public class Inscription extends javax.swing.JFrame {
	Thread monThread;
	boolean visible =  false;
	/**
	 * Creates new form Inscription
	 */
	public Inscription() {
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			//javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
		} catch (Exception ex) {
			//Handle Exception
		}

		initComponents();
		jProgressBar1.setVisible(false);
		jLabel9.setVisible(false);
	}

	/**
	 * gestion graphique
	 */             
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jLabel3 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jTextField_email = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jPasswordFieldmdp1 = new javax.swing.JPasswordField();
		jPasswordFieldmdp2 = new javax.swing.JPasswordField();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jTextField_nom = new javax.swing.JTextField();
		jLabel8 = new javax.swing.JLabel();
		jTextField_prenom = new javax.swing.JTextField();
		jProgressBar1 = new javax.swing.JProgressBar();
		jLabel9 = new javax.swing.JLabel();



		jPanel1.setBackground(new java.awt.Color(39, 39, 39));

		jLabel3.setFont(new java.awt.Font("Lucida Console", 1, 13)); // NOI18N
		jLabel3.setForeground(new java.awt.Color(102, 102, 255));
		jLabel3.setText("Page Inscription");

		jLabel2.setIcon(new javax.swing.ImageIcon("./src/media/boy-128.png")); // NOI18N
		jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel2MouseClicked(evt);
			}
		});

		jTextField_email.setFont(new java.awt.Font("Candara", 1, 13)); // NOI18N

		jLabel4.setFont(new java.awt.Font("Candara", 1, 13)); // NOI18N
		jLabel4.setForeground(new java.awt.Color(255, 255, 255));
		jLabel4.setText("E-mail :");

		jLabel5.setFont(new java.awt.Font("Candara", 1, 13)); // NOI18N
		jLabel5.setForeground(new java.awt.Color(255, 255, 255));
		jLabel5.setText("Mot de passe :");

		jLabel6.setFont(new java.awt.Font("Candara", 1, 13)); // NOI18N
		jLabel6.setForeground(new java.awt.Color(255, 255, 255));
		jLabel6.setText("Confirmation :");

		jLabel7.setFont(new java.awt.Font("Candara", 1, 13)); // NOI18N
		jLabel7.setForeground(new java.awt.Color(255, 255, 255));
		jLabel7.setText("Nom :");

		jTextField_nom.setFont(new java.awt.Font("Candara", 1, 13)); // NOI18N

		jLabel8.setFont(new java.awt.Font("Candara", 1, 13)); // NOI18N
		jLabel8.setForeground(new java.awt.Color(255, 255, 255));
		jLabel8.setText("Prénom :");

		jTextField_prenom.setFont(new java.awt.Font("Candara", 1, 13)); // NOI18N

		jLabel9.setFont(new java.awt.Font("Lucida Console", 1, 13)); // NOI18N
		jLabel9.setForeground(new java.awt.Color(102, 102, 255));
		jLabel9.setText("Enregistrement ...");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
						.addGap(0, 0, Short.MAX_VALUE)
						.addComponent(jLabel9)
						.addGap(98, 98, 98))
						.addGroup(jPanel1Layout.createSequentialGroup()
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(jPanel1Layout.createSequentialGroup()
												.addGap(112, 112, 112)
												.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(jPanel1Layout.createSequentialGroup()
																.addGap(10, 10, 10)
																.addComponent(jLabel2))
																.addComponent(jLabel3)))
																.addGroup(jPanel1Layout.createSequentialGroup()
																		.addGap(60, 60, 60)
																		.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
																				.addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																				.addComponent(jLabel4)
																				.addComponent(jLabel5)
																				.addComponent(jPasswordFieldmdp1)
																				.addComponent(jLabel6)
																				.addComponent(jPasswordFieldmdp2, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
																				.addComponent(jLabel7)
																				.addComponent(jTextField_nom, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
																				.addComponent(jLabel8)
																				.addComponent(jTextField_prenom, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
																				.addComponent(jTextField_email))))
																				.addContainerGap(67, Short.MAX_VALUE))
				);
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGap(34, 34, 34)
						.addComponent(jLabel3)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jLabel2)
						.addGap(12, 12, 12)
						.addComponent(jLabel4)
						.addGap(5, 5, 5)
						.addComponent(jTextField_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(11, 11, 11)
						.addComponent(jLabel5)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jPasswordFieldmdp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jLabel6)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jPasswordFieldmdp2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jLabel7)
						.addGap(5, 5, 5)
						.addComponent(jTextField_nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jLabel8)
						.addGap(5, 5, 5)
						.addComponent(jTextField_prenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jLabel9)
						.addContainerGap(41, Short.MAX_VALUE))
				);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				);

		pack();
	}// </editor-fold>                        

	/**
	 * methode permettant la gestion d'un nouveau utilisateur avec verification
	 * du format
	 */ 
	@SuppressWarnings("deprecation")
	private synchronized void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {    
		if (!(jTextField_email.getText().equals("") || jPasswordFieldmdp1.getText().equals("")
				|| jPasswordFieldmdp2.getText().equals("") || jTextField_nom.getText().equals("")
				|| jTextField_prenom.getText().equals(""))){

			if(Connexion.isValidEmailAddress(jTextField_email.getText())){
				if(jPasswordFieldmdp2.getText().equals(jPasswordFieldmdp1.getText())){
					if(Traitement_xml.verification_mel(jTextField_email.getText())){
						JOptionPane.showMessageDialog(null, "Le mel que vous avez choisi est existant Veuillez choisir un autre", "Erreur d'inscription", JOptionPane.ERROR_MESSAGE);

					}else{
						monThread= new Thread(new MonRunnable());
						monThread.start();
						Connexion son = new Connexion();
						son.setVisible(true);
						this.setVisible(false);
					}
				}else{
					JOptionPane.showMessageDialog(null, "le mot de passe n'est pas identique", "Mot de passe incorect", JOptionPane.ERROR_MESSAGE);

				}

			}else{
				JOptionPane.showMessageDialog(null, "format de votre adresse email est invaldide", "email invalide", JOptionPane.ERROR_MESSAGE);

			}




		}else{
			JOptionPane.showMessageDialog(null, "Vous devez remplire tout les champs", "Mot de passe indiquée est incorrecte", JOptionPane.ERROR_MESSAGE);

		}

	}                                    
	public class MonRunnable  implements Runnable
	{
		@SuppressWarnings({ "static-access", "deprecation" })
		public synchronized void run()
		{
			for (int j = 1; j < 100; j++) // on fait une boucle pour que la JProgressBar "avance"
			{
				jProgressBar1.setVisible(true);
				jProgressBar1.setValue(j);
				try
				{
					monThread.sleep(20);

				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}



			Traitement_xml.create_utilisateur(jTextField_prenom.getText(),
					jTextField_nom.getText(),jTextField_email.getText(),jPasswordFieldmdp1.getText());
		}



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
			java.util.logging.Logger.getLogger(Inscription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Inscription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Inscription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Inscription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Inscription().setVisible(true);
			}
		});
	}
            
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPasswordField jPasswordFieldmdp1;
	private javax.swing.JPasswordField jPasswordFieldmdp2;
	private javax.swing.JProgressBar jProgressBar1;
	private javax.swing.JTextField jTextField_email;
	private javax.swing.JTextField jTextField_nom;
	private javax.swing.JTextField jTextField_prenom;
             
}
