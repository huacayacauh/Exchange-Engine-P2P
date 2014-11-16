package principal;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

import traitement.Traitement_xml;
import traitement_son.Tritement_son;
import model.Model;


/**
 *
 * @author El MEHDI
 * 
 * Classe permettant la connexion
 */
@SuppressWarnings("serial")
public class Connexion extends javax.swing.JFrame {
	Thread monThread;
	static Page_principale p;
	static Model m;
	public static String email_courant="";
	/**
	 * constructeur
	 */
	public Connexion() {
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			//javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
		} catch (Exception ex) {
			//Handle Exception
		}

		initComponents();
		jTextField1.setText("chtiwi.dev@gmail.com");
		jPasswordField1.setText("123");
		jProgressBar1.setVisible(false);
		jLabel7.setVisible(false);
	}
	/**
	 * gestion graphique
	 */
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jSeparator1 = new javax.swing.JSeparator();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jButton_connecter = new javax.swing.JButton();
		jButton_inscription = new javax.swing.JButton();
		jPasswordField1 = new javax.swing.JPasswordField();
		jTextField1 = new javax.swing.JTextField();
		jLabel6 = new javax.swing.JLabel();
		jProgressBar1 = new JProgressBar(0, 100); 
		jLabel7 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setBackground(new java.awt.Color(39, 39, 39));
		jPanel1.setBackground(new java.awt.Color(39, 39, 39));
		jLabel1.setToolTipText("");

		jLabel2.setIcon(new javax.swing.ImageIcon("./src/media/navigateur-terre-globe-internet-web-icone-3747-96.png")); // NOI18N

		jLabel3.setFont(new java.awt.Font("Lucida Console", 1, 13)); // NOI18N
		jLabel3.setForeground(new java.awt.Color(51, 204, 0));
		jLabel3.setText("XML STYLE IS BACK");

		jLabel4.setFont(new java.awt.Font("Candara", 1, 13)); // NOI18N
		jLabel4.setForeground(new java.awt.Color(255, 255, 255));
		jLabel4.setText("Login :");

		jLabel5.setFont(new java.awt.Font("Candara", 1, 13)); // NOI18N
		jLabel5.setForeground(new java.awt.Color(255, 255, 255));
		jLabel5.setText("Mot de passe :");

		jButton_connecter.setIcon(new javax.swing.ImageIcon("./src/media/envoyer.png")); // NOI18N
		jButton_connecter.setText("Se connecter");
		jButton_connecter.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton_connecterActionPerformed(evt);
			}
		});

		jPasswordField1.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				jPasswordField1KeyPressed(evt);
			}
		});

		jButton_inscription.setIcon(new javax.swing.ImageIcon("./src/media/utilisateur-dajouter-icone-8846-16.png")); // NOI18N
		jButton_inscription.setText("Inscriver-vous");
		jButton_inscription.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton_inscriptionActionPerformed(evt);
			}
		});

		jPasswordField1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

		jTextField1.setFont(new java.awt.Font("Candara", 1, 13)); // NOI18N

		jLabel6.setBackground(new java.awt.Color(39, 39, 39));
		jLabel6.setForeground(new java.awt.Color(39, 39, 39));
		jLabel6.setText("jLabel6");

		jLabel7.setFont(new java.awt.Font("Lucida Console", 1, 13)); // NOI18N
		jLabel7.setForeground(new java.awt.Color(51, 204, 0));
		jLabel7.setText("loading ...");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(jPanel1Layout.createSequentialGroup()
														.addGap(74, 74, 74)
														.addComponent(jLabel1))
														.addGroup(jPanel1Layout.createSequentialGroup()
																.addGap(130, 130, 130)
																.addComponent(jLabel2))
																.addGroup(jPanel1Layout.createSequentialGroup()
																		.addGap(103, 103, 103)
																		.addComponent(jLabel3))
																		.addGroup(jPanel1Layout.createSequentialGroup()
																				.addGap(58, 58, 58)
																				.addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))
																				.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
																						.addComponent(jLabel4)
																						.addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
																						.addComponent(jLabel5)
																						.addComponent(jPasswordField1, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
																						.addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
																						.addGroup(jPanel1Layout.createSequentialGroup()
																								.addGap(116, 116, 116)
																								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
																										.addComponent(jButton_inscription, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
																										.addComponent(jButton_connecter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
																										.addGroup(jPanel1Layout.createSequentialGroup()
																												.addGap(156, 156, 156)
																												.addComponent(jLabel6)))
																												.addContainerGap(60, Short.MAX_VALUE))
																												.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
																														.addGap(0, 0, Short.MAX_VALUE)
																														.addComponent(jLabel7)
																														.addGap(129, 129, 129))
				);
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGap(20, 20, 20)
						.addComponent(jLabel2)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jLabel3)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jLabel1)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(23, 23, 23)
						.addComponent(jLabel4)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(14, 14, 14)
						.addComponent(jLabel5)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(33, 33, 33)
						.addComponent(jButton_connecter)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jButton_inscription)
						.addGap(57, 57, 57)
						.addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jLabel7)
						.addGap(45, 45, 45)
						.addComponent(jLabel6)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);

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
	 * fonction permettant la verification du format d'email
	 */
	public static boolean isValidEmailAddress(String email) {
		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
		java.util.regex.Matcher m = p.matcher(email);
		return m.matches();
	}
	/**
	 * methode permettant la verification de login et mot de passe de l'utilisateur
	 */
	public  void connexion (String mdp ,String email){
		if (!(email.equals("") || mdp.equals(""))){

			if(isValidEmailAddress(jTextField1.getText())){
				jProgressBar1.setVisible(true);
				jTextField1.setEnabled(false);
				jPasswordField1.setVisible(true);
				jButton_connecter.setEnabled(false);
				jButton_inscription.setEnabled(false);
				monThread= new Thread(new MonRunnable());
				monThread.start();

			}else{
				JOptionPane.showMessageDialog(null, "Votre de votre adresse email est incorect", "Format inconnu", JOptionPane.ERROR_MESSAGE);	
			}

		}  else{
			JOptionPane.showMessageDialog(null, "Vous devez remplire tout les champs", "Mot de passe indiquée est incorrecte", JOptionPane.ERROR_MESSAGE);

		}   

	}

	@SuppressWarnings("deprecation")
	private void jPasswordField1KeyPressed(java.awt.event.KeyEvent evt) {                                           
		if (evt.getKeyCode()==KeyEvent.VK_ENTER){
			connexion(jTextField1.getText(),jPasswordField1.getText());
		}
	}   
	@SuppressWarnings("deprecation")
	private void jButton_connecterActionPerformed(java.awt.event.ActionEvent evt) { 
		connexion(jTextField1.getText(),jPasswordField1.getText());

	}
	/**
	 * methode permettant l'ajout d'un nouvel utilisateur
	 */
	private void jButton_inscriptionActionPerformed(java.awt.event.ActionEvent evt) {  
		this.setVisible(false);
		Inscription ins = new Inscription();
		ins.setVisible(true);


	}       

	public class MonRunnable  implements Runnable
	{
		@SuppressWarnings({ "static-access", "deprecation" })
		public void run()
		{


			for (int j = 1; j < 100; j++) // on fait une boucle pour que la JProgressBar "avance"
			{
				jProgressBar1.setValue(j);
				try
				{
					monThread.sleep(5);

				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			String res=Traitement_xml.Verification_connexion(jTextField1.getText(),jPasswordField1.getText());
			if(res.equals("2")){
				email_courant=jTextField1.getText();

				p = new Page_principale();
				p.setVisible(true);


				Tritement_son son = new Tritement_son();
				son.start();
				try {
					System.out.println("ok");
				} catch (Exception e) {
					e.printStackTrace();
				}

			}else if(res.equals("3")){
				JOptionPane.showMessageDialog(null, "Mot de passe indiquée est incorrecte", "Mot de passe indiquée est incorrecte", JOptionPane.ERROR_MESSAGE);
				jTextField1.setEnabled(true);
				jPasswordField1.setVisible(true);
				jButton_connecter.setEnabled(true);
				jButton_inscription.setEnabled(true);
			}else{
				JOptionPane.showMessageDialog(null, "l'adresse email indiquée est incorrecte", "l'adresse email indiquée est incorrecte", JOptionPane.ERROR_MESSAGE);
				jTextField1.setEnabled(true);
				jPasswordField1.setVisible(true);
				jButton_connecter.setEnabled(true);
				jButton_inscription.setEnabled(true);
			}

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
			java.util.logging.Logger.getLogger(Connexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Connexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Connexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Connexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Connexion().setVisible(true);
			}
		});
	}                
	private javax.swing.JButton jButton_connecter;
	private javax.swing.JButton jButton_inscription;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPasswordField jPasswordField1;
	private javax.swing.JProgressBar jProgressBar1;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JTextField jTextField1;              
}
