package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;

import _Controller.Controller;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.ScrollPaneConstants;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class HomeGUI extends JFrame {

	private JPanel contentPane;

	private Controller controller;

	Color darkGrey = new Color(21, 21, 21);
	Color grey = new Color(26, 26, 26);
	Color black = new Color(15, 15, 15);
	Color blue = new Color(0, 0, 255);
	Color darkBlue = new Color(0, 0, 153);

	private JPanel panel;
	private JPanel panel2;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane2;

	public HomeGUI(Controller controller) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(HomeGUI.class.getResource("/Img/Logo-48.png")));

		this.controller = controller;

		setBackground(new Color(36, 53, 102));
		setTitle("Home");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1342, 815);
		contentPane = new JPanel();
		contentPane.setBackground(darkGrey);
		setContentPane(contentPane);

		JPanel menuRight = new JPanel();
		menuRight.setBackground(black);

		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(HomeGUI.class.getResource("/Img/Logo-64.png")));

		JPanel Card = new JPanel();
		Card.setBackground(grey);

		JPanel panelDashboard = new JPanel();
		panelDashboard.setBackground(grey);

		JPanel panelShowArtists = new JPanel();
		panelShowArtists.setBackground(grey);

		JPanel panelShowAlbums = new JPanel();
		panelShowAlbums.setBackground(grey);

		JButton buttonDashboard = new JButton("Dashboard");
		buttonDashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelDashboard.setVisible(true);
				panelShowArtists.setVisible(false);
				panelShowAlbums.setVisible(false);
			}
		});
		buttonDashboard.setHorizontalTextPosition(SwingConstants.RIGHT);
		buttonDashboard.setHorizontalAlignment(SwingConstants.LEFT);
		buttonDashboard.setIconTextGap(10);
		buttonDashboard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				buttonDashboard.setBackground(darkGrey);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				buttonDashboard.setBackground(black);
			}
		});
		buttonDashboard.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		buttonDashboard.setForeground(new Color(255, 255, 255));
		buttonDashboard.setBackground(black);
		buttonDashboard.setFocusPainted(false);
		buttonDashboard.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonDashboard.setBorderPainted(false);
		buttonDashboard.setIcon(new ImageIcon(HomeGUI.class.getResource("/Img/Dashboard-48.png")));

		JButton buttonShowArtists = new JButton("Show artist");
		buttonShowArtists.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelDashboard.setVisible(false);
				panelShowArtists.setVisible(true);
				panelShowAlbums.setVisible(false);

				stampaArtistGUI();
			}
		});
		buttonShowArtists.setHorizontalTextPosition(SwingConstants.RIGHT);
		buttonShowArtists.setHorizontalAlignment(SwingConstants.LEFT);
		buttonShowArtists.setIconTextGap(10);
		buttonShowArtists.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonShowArtists.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				buttonShowArtists.setBackground(darkGrey);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				buttonShowArtists.setBackground(black);
			}
		});
		buttonShowArtists.setIcon(new ImageIcon(HomeGUI.class.getResource("/Img/Artists-48.png")));
		buttonShowArtists.setForeground(Color.WHITE);
		buttonShowArtists.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		buttonShowArtists.setFocusPainted(false);
		buttonShowArtists.setBorderPainted(false);
		buttonShowArtists.setBackground(new Color(15, 15, 15));

		JButton buttonShowAlbums = new JButton("Show albums");
		buttonShowAlbums.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelDashboard.setVisible(false);
				panelShowArtists.setVisible(false);
				panelShowAlbums.setVisible(true);
				
				stampaAlbumGUI();
			}
		});
		buttonShowAlbums.setHorizontalTextPosition(SwingConstants.RIGHT);
		buttonShowAlbums.setHorizontalAlignment(SwingConstants.LEFT);
		buttonShowAlbums.setIconTextGap(10);
		buttonShowAlbums.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonShowAlbums.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				buttonShowAlbums.setBackground(darkGrey);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				buttonShowAlbums.setBackground(black);
			}
		});
		buttonShowAlbums.setIcon(new ImageIcon(HomeGUI.class.getResource("/Img/Albums-48.png")));
		buttonShowAlbums.setForeground(Color.WHITE);
		buttonShowAlbums.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		buttonShowAlbums.setFocusPainted(false);
		buttonShowAlbums.setBorderPainted(false);
		buttonShowAlbums.setBorder(new LineBorder(new Color(0, 51, 255), 10));
		buttonShowAlbums.setBackground(new Color(15, 15, 15));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(menuRight, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(6)
										.addComponent(label, GroupLayout.DEFAULT_SIZE, 989, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(Card, GroupLayout.DEFAULT_SIZE, 985, Short.MAX_VALUE)))
						.addContainerGap())
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(35)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(Card, GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
						.addContainerGap())
				.addComponent(menuRight, GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE)
				);
		GroupLayout gl_menuRight = new GroupLayout(menuRight);
		gl_menuRight.setHorizontalGroup(
			gl_menuRight.createParallelGroup(Alignment.LEADING)
				.addComponent(buttonDashboard, GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
				.addComponent(buttonShowArtists, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
				.addComponent(buttonShowAlbums, GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
		);
		gl_menuRight.setVerticalGroup(
			gl_menuRight.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_menuRight.createSequentialGroup()
					.addGap(199)
					.addComponent(buttonDashboard, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(3)
					.addComponent(buttonShowArtists, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(3)
					.addComponent(buttonShowAlbums, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(425, Short.MAX_VALUE))
		);
		menuRight.setLayout(gl_menuRight);
		Card.setLayout(new CardLayout(0, 0));

		Card.add(panelDashboard, "name_228475787480200");

		JLabel labelCreatedBy = new JLabel("Created by Franzese Salvatore & Cammardella Paolo");
		labelCreatedBy.setHorizontalAlignment(SwingConstants.CENTER);
		labelCreatedBy.setAlignmentX(Component.CENTER_ALIGNMENT);
		labelCreatedBy.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		labelCreatedBy.setForeground(new Color(255, 255, 255));
		labelCreatedBy.setFont(new Font("Segoe UI", Font.PLAIN, 18));

		JLabel lblDashboard = new JLabel("DASHBOARD");
		lblDashboard.setAlignmentY(Component.TOP_ALIGNMENT);
		lblDashboard.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblDashboard.setHorizontalTextPosition(SwingConstants.CENTER);
		lblDashboard.setHorizontalAlignment(SwingConstants.CENTER);
		lblDashboard.setForeground(new Color(255, 255, 255));
		lblDashboard.setFont(new Font("Segoe UI", Font.BOLD, 30));

		JButton buttonAddArtist = new JButton("Add Artist");
		buttonAddArtist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.frameAddArtistGUI();
			}
		});
		buttonAddArtist.setBorder(null);
		buttonAddArtist.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonAddArtist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				buttonAddArtist.setBackground(darkGrey);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				buttonAddArtist.setBackground(black);
			}
		});
		buttonAddArtist.setVerticalTextPosition(SwingConstants.BOTTOM);
		buttonAddArtist.setHorizontalTextPosition(SwingConstants.CENTER);
		buttonAddArtist.setIcon(new ImageIcon(HomeGUI.class.getResource("/Img/Artist-64.png")));
		buttonAddArtist.setIconTextGap(10);
		buttonAddArtist.setForeground(Color.WHITE);
		buttonAddArtist.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		buttonAddArtist.setFocusPainted(false);
		buttonAddArtist.setBorderPainted(false);
		buttonAddArtist.setBackground(new Color(15, 15, 15));

		JButton buttonAddAlbum = new JButton("Add Album");
		buttonAddAlbum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.frameAddAlbumGUI();
			}
		});
		buttonAddAlbum.setBorder(null);
		buttonAddAlbum.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				buttonAddAlbum.setBackground(darkGrey);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				buttonAddAlbum.setBackground(black);
			}
		});
		buttonAddAlbum.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonAddAlbum.setIcon(new ImageIcon(HomeGUI.class.getResource("/Img/Album-64.png")));
		buttonAddAlbum.setVerticalTextPosition(SwingConstants.BOTTOM);
		buttonAddAlbum.setIconTextGap(10);
		buttonAddAlbum.setHorizontalTextPosition(SwingConstants.CENTER);
		buttonAddAlbum.setForeground(Color.WHITE);
		buttonAddAlbum.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		buttonAddAlbum.setFocusPainted(false);
		buttonAddAlbum.setBorderPainted(false);
		buttonAddAlbum.setBackground(new Color(15, 15, 15));

		JLabel SpazioButtom = new JLabel("");
		SpazioButtom.setHorizontalAlignment(SwingConstants.CENTER);
		SpazioButtom.setForeground(Color.WHITE);
		SpazioButtom.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		SpazioButtom.setAlignmentY(1.0f);
		SpazioButtom.setAlignmentX(0.5f);

		JLabel SpazioLeft = new JLabel("");

		JLabel SpazioRight = new JLabel("");

		JButton btnAddSong = new JButton("Add Song");
		btnAddSong.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAddSong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAddSong.setBackground(darkGrey);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnAddSong.setBackground(black);
			}
		});
		btnAddSong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.frameAddSongGUI();
			}
		});
		btnAddSong.setIcon(new ImageIcon(HomeGUI.class.getResource("/Img/Song-48.png")));
		btnAddSong.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnAddSong.setIconTextGap(10);
		btnAddSong.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAddSong.setForeground(Color.WHITE);
		btnAddSong.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btnAddSong.setFocusPainted(false);
		btnAddSong.setBorderPainted(false);
		btnAddSong.setBorder(null);
		btnAddSong.setBackground(new Color(15, 15, 15));

		GroupLayout gl_panelDashboard = new GroupLayout(panelDashboard);
		gl_panelDashboard.setHorizontalGroup(
				gl_panelDashboard.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDashboard.createSequentialGroup()
						.addGap(10)
						.addComponent(lblDashboard, GroupLayout.DEFAULT_SIZE, 1065, Short.MAX_VALUE)
						.addGap(10))
				.addGroup(gl_panelDashboard.createSequentialGroup()
						.addContainerGap()
						.addComponent(SpazioLeft, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(buttonAddArtist, GroupLayout.PREFERRED_SIZE, 305, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(buttonAddAlbum, GroupLayout.PREFERRED_SIZE, 315, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btnAddSong, GroupLayout.PREFERRED_SIZE, 315, GroupLayout.PREFERRED_SIZE)
						.addGap(1)
						.addComponent(SpazioRight, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
						.addContainerGap())
				.addGroup(gl_panelDashboard.createSequentialGroup()
						.addContainerGap()
						.addComponent(labelCreatedBy, GroupLayout.DEFAULT_SIZE, 1065, Short.MAX_VALUE)
						.addContainerGap())
				.addGroup(gl_panelDashboard.createSequentialGroup()
						.addGap(20)
						.addComponent(SpazioButtom, GroupLayout.DEFAULT_SIZE, 1065, Short.MAX_VALUE))
				);
		gl_panelDashboard.setVerticalGroup(
				gl_panelDashboard.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDashboard.createSequentialGroup()
						.addGap(11)
						.addComponent(lblDashboard, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelDashboard.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelDashboard.createSequentialGroup()
										.addGap(11)
										.addGroup(gl_panelDashboard.createParallelGroup(Alignment.LEADING)
												.addComponent(SpazioLeft, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
												.addGroup(gl_panelDashboard.createSequentialGroup()
														.addGap(2)
														.addGroup(gl_panelDashboard.createParallelGroup(Alignment.LEADING, false)
																.addComponent(buttonAddArtist, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(buttonAddAlbum, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)))))
								.addGroup(gl_panelDashboard.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(gl_panelDashboard.createParallelGroup(Alignment.LEADING)
												.addComponent(btnAddSong, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE)
												.addComponent(SpazioRight, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(SpazioButtom, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
						.addGap(4)
						.addComponent(labelCreatedBy, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				);
		panelDashboard.setLayout(gl_panelDashboard);

		Card.add(panelShowArtists, "name_228485702864300");

		JLabel lblArtists_1 = new JLabel("ARTISTS");
		lblArtists_1.setForeground(new Color(255, 255, 255));
		lblArtists_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblArtists_1.setFont(new Font("Segoe UI", Font.BOLD, 30));

		scrollPane = new JScrollPane();
		scrollPane.setAutoscrolls(true);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBorder(null);
		
		GroupLayout gl_panelShowArtists = new GroupLayout(panelShowArtists);
		gl_panelShowArtists.setHorizontalGroup(
				gl_panelShowArtists.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelShowArtists.createSequentialGroup()
						.addGap(10)
						.addComponent(lblArtists_1, GroupLayout.DEFAULT_SIZE, 1065, Short.MAX_VALUE)
						.addGap(10))
				.addGroup(gl_panelShowArtists.createSequentialGroup()
						.addContainerGap()
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1062, Short.MAX_VALUE)
						.addGap(13))
				);
		gl_panelShowArtists.setVerticalGroup(
				gl_panelShowArtists.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelShowArtists.createSequentialGroup()
						.addGap(11)
						.addComponent(lblArtists_1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
						.addGap(16))
				);

		panel = new JPanel();
		panel.setPreferredSize(new Dimension(400, 500));
		panel.setBackground(grey);
		panel.setForeground(grey);

		scrollPane.setBackground(darkGrey);
		scrollPane.setViewportView(panel);

		JPanel panel_BackGround = new JPanel();
		panel_BackGround.setBackground(darkGrey);

		JTextField textFieldNomeArtista = new JTextField();
		textFieldNomeArtista.setForeground(new Color(255, 255, 255));
		textFieldNomeArtista.setEditable(false);
		textFieldNomeArtista.setDisabledTextColor(new Color(255, 255, 255));
		textFieldNomeArtista.setBackground(darkGrey);
		textFieldNomeArtista.setBorder(null);
		textFieldNomeArtista.setFont(new Font("Segoe UI", Font.BOLD, 24));
		textFieldNomeArtista.setColumns(10);

		JTextField textFieldNomeDArte = new JTextField();
		textFieldNomeDArte.setForeground(new Color(255, 255, 255));
		textFieldNomeDArte.setEditable(false);
		textFieldNomeDArte.setDisabledTextColor(new Color(255, 255, 255));
		textFieldNomeDArte.setBackground(darkGrey);
		textFieldNomeDArte.setBorder(null);
		textFieldNomeDArte.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		textFieldNomeDArte.setColumns(10);

		JTextField textFieldDataNascita = new JTextField();
		textFieldDataNascita.setForeground(new Color(255, 255, 255));
		textFieldDataNascita.setEditable(false);
		textFieldDataNascita.setDisabledTextColor(new Color(255, 255, 255));
		textFieldDataNascita.setBackground(darkGrey);
		textFieldDataNascita.setBorder(null);
		textFieldDataNascita.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textFieldDataNascita.setColumns(10);

		JTextField textFieldFollowers = new JTextField();
		textFieldFollowers.setForeground(new Color(255, 255, 255));
		textFieldFollowers.setEditable(false);
		textFieldFollowers.setDisabledTextColor(new Color(255, 255, 255));
		textFieldFollowers.setBackground(darkGrey);
		textFieldFollowers.setBorder(null);
		textFieldFollowers.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		textFieldFollowers.setColumns(10);

		JTextField textFieldCity = new JTextField();
		textFieldCity.setForeground(new Color(255, 255, 255));
		textFieldCity.setEditable(false);
		textFieldCity.setDisabledTextColor(new Color(255, 255, 255));
		textFieldCity.setBackground(darkGrey);
		textFieldCity.setBorder(null);
		textFieldCity.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textFieldCity.setColumns(10);

		JTextField textFieldCodiceArtista = new JTextField();
		textFieldCodiceArtista.setForeground(new Color(255, 255, 255));
		textFieldCodiceArtista.setEditable(false);
		textFieldCodiceArtista.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textFieldCodiceArtista.setDisabledTextColor(new Color(255, 255, 255));
		textFieldCodiceArtista.setBackground(darkGrey);
		textFieldCodiceArtista.setBorder(null);
		textFieldCodiceArtista.setColumns(10);

		JTextField textFieldCognomeArtista = new JTextField();
		textFieldCognomeArtista.setForeground(Color.WHITE);
		textFieldCognomeArtista.setFont(new Font("Segoe UI", Font.BOLD, 24));
		textFieldCognomeArtista.setEditable(false);
		textFieldCognomeArtista.setDisabledTextColor(Color.WHITE);
		textFieldCognomeArtista.setColumns(10);
		textFieldCognomeArtista.setBorder(null);
		textFieldCognomeArtista.setBackground(new Color(21, 21, 21));

		JLabel lblFollowers = new JLabel("Followers:");
		lblFollowers.setForeground(new Color(255, 255, 255));
		lblFollowers.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		JLabel lblCod = new JLabel("Cod:");
		lblCod.setForeground(Color.WHITE);
		lblCod.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		JLabel lblDataNascita = new JLabel("Data nascita:");
		lblDataNascita.setForeground(Color.WHITE);
		lblDataNascita.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		JButton buttonDelete = new JButton("");
		buttonDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String codice = textFieldCodiceArtista.getText();
				controller.deleteArtistDB(codice);
				stampaArtistGUI();
			}
		});
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		buttonDelete.setIcon(new ImageIcon(HomeGUI.class.getResource("/Img/DeleteArtist-48.png")));
		buttonDelete.setIconTextGap(10);
		buttonDelete.setHorizontalTextPosition(SwingConstants.RIGHT);
		buttonDelete.setForeground(Color.WHITE);
		buttonDelete.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		buttonDelete.setFocusPainted(false);
		buttonDelete.setBorderPainted(false);
		buttonDelete.setBorder(new LineBorder(new Color(0, 51, 255), 10));
		buttonDelete.setBackground(new Color(15, 15, 15));

		JButton buttonModify = new JButton("");
		JButton buttonSave = new JButton("");
		buttonSave.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonSave.setEnabled(false);
		buttonSave.setIcon(new ImageIcon(HomeGUI.class.getResource("/Img/Save-48.png")));
		buttonSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldNomeArtista.setEditable(false);
				textFieldCognomeArtista.setEditable(false);
				textFieldDataNascita.setEditable(false);
				textFieldCity.setEditable(false);
				textFieldFollowers.setEditable(false);
				textFieldNomeDArte.setEditable(false);

				textFieldNomeArtista.setBorder(null);
				textFieldCognomeArtista.setBorder(null);
				textFieldDataNascita.setBorder(null);
				textFieldCity.setBorder(null);
				textFieldFollowers.setBorder(null);
				textFieldNomeDArte.setBorder(null);

				String codice = textFieldCodiceArtista.getText();
				String nome = textFieldNomeArtista.getText();
				String cognome = textFieldCognomeArtista.getText();
				String dataNascita = textFieldDataNascita.getText();
				String nomeDArte = textFieldNomeDArte.getText();
				String citta = textFieldCity.getText();
				String followers = textFieldFollowers.getText();

				controller.updateArtistDB(codice, nome, cognome, dataNascita, nomeDArte, citta, followers);

				buttonSave.setEnabled(false);
				buttonSave.setBackground(darkGrey);
				buttonModify.setEnabled(true);
			}
		});
		buttonSave.setIconTextGap(10);
		buttonSave.setHorizontalTextPosition(SwingConstants.RIGHT);
		buttonSave.setForeground(Color.WHITE);
		buttonSave.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		buttonSave.setFocusPainted(false);
		buttonSave.setBorderPainted(false);
		buttonSave.setBorder(new LineBorder(new Color(0, 51, 255), 10));
		buttonSave.setBackground(new Color(15, 15, 15));

		buttonModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldNomeArtista.setEditable(true);
				textFieldCognomeArtista.setEditable(true);
				textFieldDataNascita.setEditable(true);
				textFieldCity.setEditable(true);
				textFieldFollowers.setEditable(true);
				textFieldNomeDArte.setEditable(true);
				buttonSave.setEnabled(true);
				buttonModify.setBackground(darkGrey);
				buttonModify.setEnabled(false);

				textFieldNomeArtista.setBorder(new MatteBorder(0, 0, 2, 0, (Color) blue));
				textFieldCognomeArtista.setBorder(new MatteBorder(0, 0, 2, 0, (Color) blue));
				textFieldDataNascita.setBorder(new MatteBorder(0, 0, 2, 0, (Color) blue));
				textFieldCity.setBorder(new MatteBorder(0, 0, 2, 0, (Color) blue));
				textFieldFollowers.setBorder(new MatteBorder(0, 0, 2, 0, (Color) blue));
				textFieldNomeDArte.setBorder(new MatteBorder(0, 0, 2, 0, (Color) blue));
			}
		});
		buttonModify.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonModify.setIcon(new ImageIcon(HomeGUI.class.getResource("/Img/Modify-48.png")));
		buttonModify.setIconTextGap(10);
		buttonModify.setHorizontalTextPosition(SwingConstants.RIGHT);
		buttonModify.setForeground(Color.WHITE);
		buttonModify.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		buttonModify.setFocusPainted(false);
		buttonModify.setBorderPainted(false);
		buttonModify.setBorder(new LineBorder(new Color(0, 51, 255), 10));
		buttonModify.setBackground(new Color(15, 15, 15));
		buttonModify.setEnabled(true);

		GroupLayout gl_panel_BackGround = new GroupLayout(panel_BackGround);
		gl_panel_BackGround.setHorizontalGroup(
				gl_panel_BackGround.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_BackGround.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel_BackGround.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_BackGround.createSequentialGroup()
										.addComponent(lblCod, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textFieldCodiceArtista, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_BackGround.createSequentialGroup()
										.addComponent(textFieldNomeArtista, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textFieldCognomeArtista, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
						.addComponent(textFieldNomeDArte, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
						.addGap(34)
						.addComponent(lblDataNascita, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel_BackGround.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel_BackGround.createSequentialGroup()
										.addComponent(textFieldDataNascita, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textFieldCity, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_BackGround.createSequentialGroup()
										.addComponent(lblFollowers, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textFieldFollowers, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)))
						.addGap(18)
						.addComponent(buttonDelete)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(buttonModify, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(buttonSave, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				);
		gl_panel_BackGround.setVerticalGroup(
				gl_panel_BackGround.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_BackGround.createSequentialGroup()
						.addGroup(gl_panel_BackGround.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel_BackGround.createSequentialGroup()
										.addGap(21)
										.addGroup(gl_panel_BackGround.createParallelGroup(Alignment.TRAILING)
												.addGroup(gl_panel_BackGround.createParallelGroup(Alignment.BASELINE)
														.addComponent(textFieldNomeArtista, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(textFieldNomeDArte, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addComponent(textFieldCognomeArtista, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(gl_panel_BackGround.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblCod, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
												.addComponent(textFieldCodiceArtista, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)))
								.addGroup(gl_panel_BackGround.createSequentialGroup()
										.addContainerGap(25, Short.MAX_VALUE)
										.addGroup(gl_panel_BackGround.createParallelGroup(Alignment.TRAILING)
												.addComponent(buttonSave, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
												.addComponent(buttonDelete)
												.addComponent(buttonModify, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
												.addGroup(gl_panel_BackGround.createSequentialGroup()
														.addGroup(gl_panel_BackGround.createParallelGroup(Alignment.BASELINE)
																.addComponent(textFieldCity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																.addComponent(textFieldDataNascita, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																.addComponent(lblDataNascita, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addGroup(gl_panel_BackGround.createParallelGroup(Alignment.BASELINE)
																.addComponent(textFieldFollowers, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																.addComponent(lblFollowers))))))
						.addContainerGap())
				);
		panel_BackGround.setLayout(gl_panel_BackGround);
		panel.add(panel_BackGround);
		
		panelShowArtists.setLayout(gl_panelShowArtists);

		Card.add(panelShowAlbums, "name_228516752218900");

		JLabel lblAlbums_1 = new JLabel("ALBUMS");
		lblAlbums_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlbums_1.setForeground(new Color(255, 255, 255));
		lblAlbums_1.setFont(new Font("Segoe UI", Font.BOLD, 30));
		
		scrollPane2 = new JScrollPane();
		scrollPane2.setAutoscrolls(true);
		scrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane2.setBorder(null);
		
		GroupLayout gl_panelShowAlbums = new GroupLayout(panelShowAlbums);
		gl_panelShowAlbums.setHorizontalGroup(
			gl_panelShowAlbums.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelShowAlbums.createSequentialGroup()
					.addGap(10)
					.addComponent(lblAlbums_1, GroupLayout.DEFAULT_SIZE, 1065, Short.MAX_VALUE)
					.addGap(10))
				.addGroup(gl_panelShowAlbums.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 1065, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panelShowAlbums.setVerticalGroup(
			gl_panelShowAlbums.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelShowAlbums.createSequentialGroup()
					.addGap(11)
					.addComponent(lblAlbums_1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		panel2 = new JPanel();
		panel2.setPreferredSize(new Dimension(400, 500));
		panel2.setBackground(grey);
		scrollPane2.setViewportView(panel2);
		panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panelBackGroundAlbum = new JPanel();
		panelBackGroundAlbum.setBackground(new Color(21, 21, 21));
		panel2.add(panelBackGroundAlbum);
		
		JTextField textFieldArtista = new JTextField();
		textFieldArtista.setForeground(Color.WHITE);
		textFieldArtista.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textFieldArtista.setEditable(false);
		textFieldArtista.setDisabledTextColor(Color.WHITE);
		textFieldArtista.setColumns(10);
		textFieldArtista.setBorder(null);
		textFieldArtista.setBackground(new Color(21, 21, 21));
		
		JTextField textFieldNomeAlbum = new JTextField();
		textFieldNomeAlbum.setForeground(Color.WHITE);
		textFieldNomeAlbum.setFont(new Font("Segoe UI", Font.BOLD, 24));
		textFieldNomeAlbum.setEditable(false);
		textFieldNomeAlbum.setDisabledTextColor(Color.WHITE);
		textFieldNomeAlbum.setColumns(10);
		textFieldNomeAlbum.setBorder(null);
		textFieldNomeAlbum.setBackground(new Color(21, 21, 21));
		
		JLabel lblDataPubblicazione = new JLabel("Data pubblicazione:");
		lblDataPubblicazione.setForeground(Color.WHITE);
		lblDataPubblicazione.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		JTextField textFieldData = new JTextField();
		textFieldData.setForeground(Color.WHITE);
		textFieldData.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textFieldData.setEditable(false);
		textFieldData.setDisabledTextColor(Color.WHITE);
		textFieldData.setColumns(10);
		textFieldData.setBorder(null);
		textFieldData.setBackground(new Color(21, 21, 21));
		
		JLabel labelGenere = new JLabel("Genere:");
		labelGenere.setForeground(Color.WHITE);
		labelGenere.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		JTextField textFieldGenere = new JTextField();
		textFieldGenere.setForeground(Color.WHITE);
		textFieldGenere.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		textFieldGenere.setEditable(false);
		textFieldGenere.setDisabledTextColor(Color.WHITE);
		textFieldGenere.setColumns(10);
		textFieldGenere.setBorder(null);
		textFieldGenere.setBackground(new Color(21, 21, 21));
		
		JTextField textFieldNumeroBrani = new JTextField();
		textFieldNumeroBrani.setForeground(Color.WHITE);
		textFieldNumeroBrani.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textFieldNumeroBrani.setEditable(false);
		textFieldNumeroBrani.setDisabledTextColor(Color.WHITE);
		textFieldNumeroBrani.setColumns(10);
		textFieldNumeroBrani.setBorder(null);
		textFieldNumeroBrani.setBackground(new Color(21, 21, 21));
		
		JTextField textFieldCodiceAlbum = new JTextField();
		textFieldCodiceAlbum.setForeground(Color.WHITE);
		textFieldCodiceAlbum.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textFieldCodiceAlbum.setEditable(false);
		textFieldCodiceAlbum.setDisabledTextColor(Color.WHITE);
		textFieldCodiceAlbum.setColumns(10);
		textFieldCodiceAlbum.setBorder(null);
		textFieldCodiceAlbum.setBackground(new Color(21, 21, 21));
		
		JButton buttonSalvaAlbum = new JButton("");
		JButton buttonModificaAlbum = new JButton("");
		buttonModificaAlbum.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonModificaAlbum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldNomeAlbum.setEditable(true);
				textFieldNumeroBrani.setEditable(true);
				textFieldGenere.setEditable(true);
				textFieldData.setEditable(true);
				buttonSalvaAlbum.setEnabled(true);
				buttonModificaAlbum.setBackground(darkGrey);
				buttonModificaAlbum.setEnabled(false);
				
				textFieldNomeAlbum.setBorder(new MatteBorder(0, 0, 2, 0, (Color) blue));
				textFieldNumeroBrani.setBorder(new MatteBorder(0, 0, 2, 0, (Color) blue));
				textFieldGenere.setBorder(new MatteBorder(0, 0, 2, 0, (Color) blue));
				textFieldData.setBorder(new MatteBorder(0, 0, 2, 0, (Color) blue));
			}
		});
		buttonModificaAlbum.setIcon(new ImageIcon(HomeGUI.class.getResource("/Img/Modify-48.png")));
		buttonModificaAlbum.setIconTextGap(10);
		buttonModificaAlbum.setHorizontalTextPosition(SwingConstants.RIGHT);
		buttonModificaAlbum.setForeground(Color.WHITE);
		buttonModificaAlbum.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		buttonModificaAlbum.setFocusPainted(false);
		buttonModificaAlbum.setEnabled(true);
		buttonModificaAlbum.setBorderPainted(false);
		buttonModificaAlbum.setBorder(new LineBorder(new Color(0, 51, 255), 10));
		buttonModificaAlbum.setBackground(new Color(15, 15, 15));
		
		buttonSalvaAlbum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldNomeAlbum.setEditable(false);
				textFieldNumeroBrani.setEditable(false);
				textFieldGenere.setEditable(false);
				textFieldData.setEditable(false);
				buttonSalvaAlbum.setEnabled(false);
				buttonModificaAlbum.setBackground(new Color(15, 15, 15));
				buttonModificaAlbum.setEnabled(true);
				
				String codice = textFieldCodiceAlbum.getText();
				String nome = textFieldNomeAlbum.getText();
				String songNumber = textFieldNumeroBrani.getText();
				String genere = textFieldGenere.getText();
				String data = textFieldData.getText();
				
				controller.updateAlbum(codice, nome, songNumber, genere, data);
				
				textFieldNomeAlbum.setBorder(null);
				textFieldNumeroBrani.setBorder(null);
				textFieldGenere.setBorder(null);
				textFieldData.setBorder(null);
			}
		});
		buttonSalvaAlbum.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonSalvaAlbum.setIcon(new ImageIcon(HomeGUI.class.getResource("/Img/Save-48.png")));
		buttonSalvaAlbum.setIconTextGap(10);
		buttonSalvaAlbum.setHorizontalTextPosition(SwingConstants.RIGHT);
		buttonSalvaAlbum.setForeground(Color.WHITE);
		buttonSalvaAlbum.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		buttonSalvaAlbum.setFocusPainted(false);
		buttonSalvaAlbum.setEnabled(false);
		buttonSalvaAlbum.setBorderPainted(false);
		buttonSalvaAlbum.setBorder(new LineBorder(new Color(0, 51, 255), 10));
		buttonSalvaAlbum.setBackground(new Color(15, 15, 15));
		
		JButton buttonDeleteAlbum = new JButton("");
		buttonDeleteAlbum.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonDeleteAlbum.setIcon(new ImageIcon(HomeGUI.class.getResource("/Img/DeleteArtistW-64.png")));
		buttonDeleteAlbum.setIconTextGap(10);
		buttonDeleteAlbum.setHorizontalTextPosition(SwingConstants.RIGHT);
		buttonDeleteAlbum.setForeground(Color.WHITE);
		buttonDeleteAlbum.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		buttonDeleteAlbum.setFocusPainted(false);
		buttonDeleteAlbum.setEnabled(true);
		buttonDeleteAlbum.setBorderPainted(false);
		buttonDeleteAlbum.setBorder(new LineBorder(new Color(0, 51, 255), 10));
		buttonDeleteAlbum.setBackground(new Color(15, 15, 15));
		
		JLabel lblCod_1 = new JLabel("Cod:");
		lblCod_1.setForeground(Color.WHITE);
		lblCod_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			
		JLabel lblNBrani = new JLabel("N. brani:");
		lblNBrani.setForeground(Color.WHITE);
		lblNBrani.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		
		GroupLayout gl_panelBackGroundAlbum = new GroupLayout(panelBackGroundAlbum);
		gl_panelBackGroundAlbum.setHorizontalGroup(
			gl_panelBackGroundAlbum.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelBackGroundAlbum.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelBackGroundAlbum.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panelBackGroundAlbum.createSequentialGroup()
							.addComponent(textFieldNomeAlbum, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textFieldArtista, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelBackGroundAlbum.createSequentialGroup()
							.addComponent(lblCod_1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFieldCodiceAlbum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNBrani, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFieldNumeroBrani, 0, 0, Short.MAX_VALUE)))
					.addGap(128)
					.addGroup(gl_panelBackGroundAlbum.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelBackGroundAlbum.createSequentialGroup()
							.addComponent(lblDataPubblicazione, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFieldData, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelBackGroundAlbum.createSequentialGroup()
							.addComponent(labelGenere, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFieldGenere, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(buttonDeleteAlbum, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(buttonModificaAlbum, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(buttonSalvaAlbum, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panelBackGroundAlbum.setVerticalGroup(
			gl_panelBackGroundAlbum.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelBackGroundAlbum.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelBackGroundAlbum.createParallelGroup(Alignment.TRAILING)
						.addComponent(buttonDeleteAlbum, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
						.addComponent(buttonSalvaAlbum, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
						.addComponent(buttonModificaAlbum, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelBackGroundAlbum.createSequentialGroup()
							.addGroup(gl_panelBackGroundAlbum.createParallelGroup(Alignment.BASELINE)
								.addComponent(textFieldData, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDataPubblicazione, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panelBackGroundAlbum.createParallelGroup(Alignment.BASELINE)
								.addComponent(textFieldGenere, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(labelGenere)))
						.addGroup(gl_panelBackGroundAlbum.createSequentialGroup()
							.addGroup(gl_panelBackGroundAlbum.createParallelGroup(Alignment.BASELINE)
								.addComponent(textFieldNomeAlbum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldArtista, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panelBackGroundAlbum.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCod_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldCodiceAlbum, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNBrani, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldNumeroBrani, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(12, Short.MAX_VALUE))
		);
		panelBackGroundAlbum.setLayout(gl_panelBackGroundAlbum);
		
		panelShowAlbums.setLayout(gl_panelShowAlbums);
		contentPane.setLayout(gl_contentPane);
		setLocationRelativeTo(null);
	}
	

	public void stampaArtistGUI() {
		ResultSet rs = controller.stampaArtistDB();
		panel.removeAll();
		try {
			if(rs != null) {
				while(rs.next()) {
					JPanel panel_BackGround = new JPanel();
					panel_BackGround.setBackground(darkGrey);

					JTextField textFieldNomeArtista = new JTextField();
					textFieldNomeArtista.setForeground(new Color(255, 255, 255));
					textFieldNomeArtista.setEditable(false);
					textFieldNomeArtista.setDisabledTextColor(new Color(255, 255, 255));
					textFieldNomeArtista.setBackground(darkGrey);
					textFieldNomeArtista.setBorder(null);
					textFieldNomeArtista.setFont(new Font("Segoe UI", Font.BOLD, 24));
					textFieldNomeArtista.setColumns(10);

					JTextField textFieldNomeDArte = new JTextField();
					textFieldNomeDArte.setForeground(new Color(255, 255, 255));
					textFieldNomeDArte.setEditable(false);
					textFieldNomeDArte.setDisabledTextColor(new Color(255, 255, 255));
					textFieldNomeDArte.setBackground(darkGrey);
					textFieldNomeDArte.setBorder(null);
					textFieldNomeDArte.setFont(new Font("Segoe UI", Font.PLAIN, 18));
					textFieldNomeDArte.setColumns(10);

					JTextField textFieldDataNascita = new JTextField();
					textFieldDataNascita.setForeground(new Color(255, 255, 255));
					textFieldDataNascita.setEditable(false);
					textFieldDataNascita.setDisabledTextColor(new Color(255, 255, 255));
					textFieldDataNascita.setBackground(darkGrey);
					textFieldDataNascita.setBorder(null);
					textFieldDataNascita.setFont(new Font("Segoe UI", Font.PLAIN, 14));
					textFieldDataNascita.setColumns(10);

					JTextField textFieldFollowers = new JTextField();
					textFieldFollowers.setForeground(new Color(255, 255, 255));
					textFieldFollowers.setEditable(false);
					textFieldFollowers.setDisabledTextColor(new Color(255, 255, 255));
					textFieldFollowers.setBackground(darkGrey);
					textFieldFollowers.setBorder(null);
					textFieldFollowers.setFont(new Font("Segoe UI", Font.PLAIN, 16));
					textFieldFollowers.setColumns(10);

					JTextField textFieldCity = new JTextField();
					textFieldCity.setForeground(new Color(255, 255, 255));
					textFieldCity.setEditable(false);
					textFieldCity.setDisabledTextColor(new Color(255, 255, 255));
					textFieldCity.setBackground(darkGrey);
					textFieldCity.setBorder(null);
					textFieldCity.setFont(new Font("Segoe UI", Font.PLAIN, 14));
					textFieldCity.setColumns(10);

					JTextField textFieldCodiceArtista = new JTextField();
					textFieldCodiceArtista.setForeground(new Color(255, 255, 255));
					textFieldCodiceArtista.setEditable(false);
					textFieldCodiceArtista.setFont(new Font("Segoe UI", Font.PLAIN, 14));
					textFieldCodiceArtista.setDisabledTextColor(new Color(255, 255, 255));
					textFieldCodiceArtista.setBackground(darkGrey);
					textFieldCodiceArtista.setBorder(null);
					textFieldCodiceArtista.setColumns(10);

					JTextField textFieldCognomeArtista = new JTextField();
					textFieldCognomeArtista.setForeground(Color.WHITE);
					textFieldCognomeArtista.setFont(new Font("Segoe UI", Font.BOLD, 24));
					textFieldCognomeArtista.setEditable(false);
					textFieldCognomeArtista.setDisabledTextColor(Color.WHITE);
					textFieldCognomeArtista.setColumns(10);
					textFieldCognomeArtista.setBorder(null);
					textFieldCognomeArtista.setBackground(new Color(21, 21, 21));

					JLabel lblFollowers = new JLabel("Followers:");
					lblFollowers.setForeground(new Color(255, 255, 255));
					lblFollowers.setFont(new Font("Segoe UI", Font.PLAIN, 14));

					JLabel lblCod = new JLabel("Cod:");
					lblCod.setForeground(Color.WHITE);
					lblCod.setFont(new Font("Segoe UI", Font.PLAIN, 14));

					JLabel lblDataNascita = new JLabel("Data nascita:");
					lblDataNascita.setForeground(Color.WHITE);
					lblDataNascita.setFont(new Font("Segoe UI", Font.PLAIN, 14));

					JButton buttonDelete = new JButton("");
					buttonDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					buttonDelete.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String codice = textFieldCodiceArtista.getText();
							controller.deleteArtistDB(codice);
							panel.removeAll();
							stampaArtistGUI();
						}
					});
					panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
					buttonDelete.setIcon(new ImageIcon(HomeGUI.class.getResource("/Img/DeleteArtist-48.png")));
					buttonDelete.setIconTextGap(10);
					buttonDelete.setHorizontalTextPosition(SwingConstants.RIGHT);
					buttonDelete.setForeground(Color.WHITE);
					buttonDelete.setFont(new Font("Segoe UI", Font.PLAIN, 18));
					buttonDelete.setFocusPainted(false);
					buttonDelete.setBorderPainted(false);
					buttonDelete.setBorder(new LineBorder(new Color(0, 51, 255), 10));
					buttonDelete.setBackground(new Color(15, 15, 15));

					JButton buttonModify = new JButton("");
					JButton buttonSave = new JButton("");
					buttonSave.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					buttonSave.setEnabled(false);
					buttonSave.setIcon(new ImageIcon(HomeGUI.class.getResource("/Img/Save-48.png")));
					buttonSave.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							textFieldNomeArtista.setEditable(false);
							textFieldCognomeArtista.setEditable(false);
							textFieldDataNascita.setEditable(false);
							textFieldCity.setEditable(false);
							textFieldFollowers.setEditable(false);
							textFieldNomeDArte.setEditable(false);

							textFieldNomeArtista.setBorder(null);
							textFieldCognomeArtista.setBorder(null);
							textFieldDataNascita.setBorder(null);
							textFieldCity.setBorder(null);
							textFieldFollowers.setBorder(null);
							textFieldNomeDArte.setBorder(null);

							String codice = textFieldCodiceArtista.getText();
							String nome = textFieldNomeArtista.getText();
							String cognome = textFieldCognomeArtista.getText();
							String dataNascita = textFieldDataNascita.getText();
							String nomeDArte = textFieldNomeDArte.getText();
							String citta = textFieldCity.getText();
							String followers = textFieldFollowers.getText();

							controller.updateArtistDB(codice, nome, cognome, dataNascita, nomeDArte, citta, followers);

							buttonSave.setEnabled(false);
							buttonSave.setBackground(darkGrey);
							buttonModify.setEnabled(true);
						}
					});
					buttonSave.setIconTextGap(10);
					buttonSave.setHorizontalTextPosition(SwingConstants.RIGHT);
					buttonSave.setForeground(Color.WHITE);
					buttonSave.setFont(new Font("Segoe UI", Font.PLAIN, 18));
					buttonSave.setFocusPainted(false);
					buttonSave.setBorderPainted(false);
					buttonSave.setBorder(new LineBorder(new Color(0, 51, 255), 10));
					buttonSave.setBackground(new Color(15, 15, 15));

					buttonModify.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							textFieldNomeArtista.setEditable(true);
							textFieldCognomeArtista.setEditable(true);
							textFieldDataNascita.setEditable(true);
							textFieldCity.setEditable(true);
							textFieldFollowers.setEditable(true);
							textFieldNomeDArte.setEditable(true);
							buttonSave.setEnabled(true);
							buttonModify.setBackground(darkGrey);
							buttonModify.setEnabled(false);

							textFieldNomeArtista.setBorder(new MatteBorder(0, 0, 2, 0, (Color) blue));
							textFieldCognomeArtista.setBorder(new MatteBorder(0, 0, 2, 0, (Color) blue));
							textFieldDataNascita.setBorder(new MatteBorder(0, 0, 2, 0, (Color) blue));
							textFieldCity.setBorder(new MatteBorder(0, 0, 2, 0, (Color) blue));
							textFieldFollowers.setBorder(new MatteBorder(0, 0, 2, 0, (Color) blue));
							textFieldNomeDArte.setBorder(new MatteBorder(0, 0, 2, 0, (Color) blue));
						}
					});
					buttonModify.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					buttonModify.setIcon(new ImageIcon(HomeGUI.class.getResource("/Img/Modify-48.png")));
					buttonModify.setIconTextGap(10);
					buttonModify.setHorizontalTextPosition(SwingConstants.RIGHT);
					buttonModify.setForeground(Color.WHITE);
					buttonModify.setFont(new Font("Segoe UI", Font.PLAIN, 18));
					buttonModify.setFocusPainted(false);
					buttonModify.setBorderPainted(false);
					buttonModify.setBorder(new LineBorder(new Color(0, 51, 255), 10));
					buttonModify.setBackground(new Color(15, 15, 15));
					buttonModify.setEnabled(true);

					GroupLayout gl_panel_BackGround = new GroupLayout(panel_BackGround);
					gl_panel_BackGround.setHorizontalGroup(
							gl_panel_BackGround.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_BackGround.createSequentialGroup()
									.addContainerGap()
									.addGroup(gl_panel_BackGround.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_panel_BackGround.createSequentialGroup()
													.addComponent(lblCod, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(textFieldCodiceArtista, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE))
											.addGroup(gl_panel_BackGround.createSequentialGroup()
													.addComponent(textFieldNomeArtista, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(textFieldCognomeArtista, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)))
									.addPreferredGap(ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
									.addComponent(textFieldNomeDArte, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
									.addGap(34)
									.addComponent(lblDataNascita, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel_BackGround.createParallelGroup(Alignment.TRAILING)
											.addGroup(gl_panel_BackGround.createSequentialGroup()
													.addComponent(textFieldDataNascita, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(textFieldCity, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
											.addGroup(gl_panel_BackGround.createSequentialGroup()
													.addComponent(lblFollowers, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(textFieldFollowers, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)))
									.addGap(18)
									.addComponent(buttonDelete)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(buttonModify, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(buttonSave, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
									.addContainerGap())
							);
					gl_panel_BackGround.setVerticalGroup(
							gl_panel_BackGround.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_panel_BackGround.createSequentialGroup()
									.addGroup(gl_panel_BackGround.createParallelGroup(Alignment.TRAILING)
											.addGroup(gl_panel_BackGround.createSequentialGroup()
													.addGap(21)
													.addGroup(gl_panel_BackGround.createParallelGroup(Alignment.TRAILING)
															.addGroup(gl_panel_BackGround.createParallelGroup(Alignment.BASELINE)
																	.addComponent(textFieldNomeArtista, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																	.addComponent(textFieldNomeDArte, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
															.addComponent(textFieldCognomeArtista, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
													.addPreferredGap(ComponentPlacement.UNRELATED)
													.addGroup(gl_panel_BackGround.createParallelGroup(Alignment.BASELINE)
															.addComponent(lblCod, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
															.addComponent(textFieldCodiceArtista, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)))
											.addGroup(gl_panel_BackGround.createSequentialGroup()
													.addContainerGap(25, Short.MAX_VALUE)
													.addGroup(gl_panel_BackGround.createParallelGroup(Alignment.TRAILING)
															.addComponent(buttonSave, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
															.addComponent(buttonDelete)
															.addComponent(buttonModify, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
															.addGroup(gl_panel_BackGround.createSequentialGroup()
																	.addGroup(gl_panel_BackGround.createParallelGroup(Alignment.BASELINE)
																			.addComponent(textFieldCity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																			.addComponent(textFieldDataNascita, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																			.addComponent(lblDataNascita, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
																	.addPreferredGap(ComponentPlacement.UNRELATED)
																	.addGroup(gl_panel_BackGround.createParallelGroup(Alignment.BASELINE)
																			.addComponent(textFieldFollowers, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																			.addComponent(lblFollowers))))))
									.addContainerGap())
							);
					panel_BackGround.setLayout(gl_panel_BackGround);
					panel.add(panel_BackGround);

					textFieldCodiceArtista.setText(rs.getString("id_Artist"));
					textFieldNomeArtista.setText(rs.getString("firstName"));
					textFieldCognomeArtista.setText(rs.getString("secondName"));
					textFieldDataNascita.setText(rs.getString("birthDate"));
					textFieldCity.setText(rs.getString("city"));
					textFieldFollowers.setText(rs.getString("followers"));
					textFieldNomeDArte.setText(rs.getString("nomeDArte"));
				}
			}
			else
				JOptionPane.showMessageDialog(this,
						"DataBase vuoto!!!",
						"Errore",
						JOptionPane.ERROR_MESSAGE);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void stampaAlbumGUI() {
		ResultSet rs = controller.stampaAlbumDB();
		panel2.removeAll();
		try {
			if(rs != null) {
				while(rs.next()) {
					JPanel panelBackGroundAlbum = new JPanel();
					panelBackGroundAlbum.setBackground(new Color(21, 21, 21));
					panel2.add(panelBackGroundAlbum);
					
					JTextField textFieldArtista = new JTextField();
					textFieldArtista.setForeground(Color.WHITE);
					textFieldArtista.setFont(new Font("Segoe UI", Font.PLAIN, 14));
					textFieldArtista.setEditable(false);
					textFieldArtista.setDisabledTextColor(Color.WHITE);
					textFieldArtista.setColumns(10);
					textFieldArtista.setBorder(null);
					textFieldArtista.setBackground(new Color(21, 21, 21));
					
					JTextField textFieldNomeAlbum = new JTextField();
					textFieldNomeAlbum.setForeground(Color.WHITE);
					textFieldNomeAlbum.setFont(new Font("Segoe UI", Font.BOLD, 24));
					textFieldNomeAlbum.setEditable(false);
					textFieldNomeAlbum.setDisabledTextColor(Color.WHITE);
					textFieldNomeAlbum.setColumns(10);
					textFieldNomeAlbum.setBorder(null);
					textFieldNomeAlbum.setBackground(new Color(21, 21, 21));
					
					JLabel lblDataPubblicazione = new JLabel("Data pubblicazione:");
					lblDataPubblicazione.setForeground(Color.WHITE);
					lblDataPubblicazione.setFont(new Font("Segoe UI", Font.PLAIN, 14));
					
					JTextField textFieldData = new JTextField();
					textFieldData.setForeground(Color.WHITE);
					textFieldData.setFont(new Font("Segoe UI", Font.PLAIN, 14));
					textFieldData.setEditable(false);
					textFieldData.setDisabledTextColor(Color.WHITE);
					textFieldData.setColumns(10);
					textFieldData.setBorder(null);
					textFieldData.setBackground(new Color(21, 21, 21));
					
					JLabel labelGenere = new JLabel("Genere:");
					labelGenere.setForeground(Color.WHITE);
					labelGenere.setFont(new Font("Segoe UI", Font.PLAIN, 14));
					
					JTextField textFieldGenere = new JTextField();
					textFieldGenere.setForeground(Color.WHITE);
					textFieldGenere.setFont(new Font("Segoe UI", Font.PLAIN, 16));
					textFieldGenere.setEditable(false);
					textFieldGenere.setDisabledTextColor(Color.WHITE);
					textFieldGenere.setColumns(10);
					textFieldGenere.setBorder(null);
					textFieldGenere.setBackground(new Color(21, 21, 21));
					
					JTextField textFieldNumeroBrani = new JTextField();
					textFieldNumeroBrani.setForeground(Color.WHITE);
					textFieldNumeroBrani.setFont(new Font("Segoe UI", Font.PLAIN, 14));
					textFieldNumeroBrani.setEditable(false);
					textFieldNumeroBrani.setDisabledTextColor(Color.WHITE);
					textFieldNumeroBrani.setColumns(10);
					textFieldNumeroBrani.setBorder(null);
					textFieldNumeroBrani.setBackground(new Color(21, 21, 21));
					
					JTextField textFieldCodiceAlbum = new JTextField();
					textFieldCodiceAlbum.setForeground(Color.WHITE);
					textFieldCodiceAlbum.setFont(new Font("Segoe UI", Font.PLAIN, 14));
					textFieldCodiceAlbum.setEditable(false);
					textFieldCodiceAlbum.setDisabledTextColor(Color.WHITE);
					textFieldCodiceAlbum.setColumns(10);
					textFieldCodiceAlbum.setBorder(null);
					textFieldCodiceAlbum.setBackground(new Color(21, 21, 21));
					
					JButton buttonSalvaAlbum = new JButton("");
					JButton buttonModificaAlbum = new JButton("");
					buttonModificaAlbum.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					buttonModificaAlbum.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							textFieldNomeAlbum.setEditable(true);
							textFieldNumeroBrani.setEditable(true);
							textFieldGenere.setEditable(true);
							textFieldData.setEditable(true);
							buttonSalvaAlbum.setEnabled(true);
							buttonModificaAlbum.setBackground(darkGrey);
							buttonModificaAlbum.setEnabled(false);
							
							textFieldNomeAlbum.setBorder(new MatteBorder(0, 0, 2, 0, (Color) blue));
							textFieldNumeroBrani.setBorder(new MatteBorder(0, 0, 2, 0, (Color) blue));
							textFieldGenere.setBorder(new MatteBorder(0, 0, 2, 0, (Color) blue));
							textFieldData.setBorder(new MatteBorder(0, 0, 2, 0, (Color) blue));
						}
					});
					buttonModificaAlbum.setIcon(new ImageIcon(HomeGUI.class.getResource("/Img/Modify-48.png")));
					buttonModificaAlbum.setIconTextGap(10);
					buttonModificaAlbum.setHorizontalTextPosition(SwingConstants.RIGHT);
					buttonModificaAlbum.setForeground(Color.WHITE);
					buttonModificaAlbum.setFont(new Font("Segoe UI", Font.PLAIN, 18));
					buttonModificaAlbum.setFocusPainted(false);
					buttonModificaAlbum.setEnabled(true);
					buttonModificaAlbum.setBorderPainted(false);
					buttonModificaAlbum.setBorder(new LineBorder(new Color(0, 51, 255), 10));
					buttonModificaAlbum.setBackground(new Color(15, 15, 15));
					
					buttonSalvaAlbum.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							textFieldNomeAlbum.setEditable(false);
							textFieldNumeroBrani.setEditable(false);
							textFieldGenere.setEditable(false);
							textFieldData.setEditable(false);
							buttonSalvaAlbum.setEnabled(false);
							buttonModificaAlbum.setBackground(new Color(15, 15, 15));
							buttonModificaAlbum.setEnabled(true);
							
							String codice = textFieldCodiceAlbum.getText();
							String nome = textFieldNomeAlbum.getText();
							String songNumber = textFieldNumeroBrani.getText();
							String genere = textFieldGenere.getText();
							String data = textFieldData.getText();
							
							controller.updateAlbum(codice, nome, songNumber, genere, data);
							
							textFieldNomeAlbum.setBorder(null);
							textFieldNumeroBrani.setBorder(null);
							textFieldGenere.setBorder(null);
							textFieldData.setBorder(null);
						}
					});
					buttonSalvaAlbum.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					buttonSalvaAlbum.setIcon(new ImageIcon(HomeGUI.class.getResource("/Img/Save-48.png")));
					buttonSalvaAlbum.setIconTextGap(10);
					buttonSalvaAlbum.setHorizontalTextPosition(SwingConstants.RIGHT);
					buttonSalvaAlbum.setForeground(Color.WHITE);
					buttonSalvaAlbum.setFont(new Font("Segoe UI", Font.PLAIN, 18));
					buttonSalvaAlbum.setFocusPainted(false);
					buttonSalvaAlbum.setEnabled(false);
					buttonSalvaAlbum.setBorderPainted(false);
					buttonSalvaAlbum.setBorder(new LineBorder(new Color(0, 51, 255), 10));
					buttonSalvaAlbum.setBackground(new Color(15, 15, 15));
					
					JButton buttonDeleteAlbum = new JButton("");
					buttonDeleteAlbum.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					buttonDeleteAlbum.setIcon(new ImageIcon(HomeGUI.class.getResource("/Img/DeleteArtistW-64.png")));
					buttonDeleteAlbum.setIconTextGap(10);
					buttonDeleteAlbum.setHorizontalTextPosition(SwingConstants.RIGHT);
					buttonDeleteAlbum.setForeground(Color.WHITE);
					buttonDeleteAlbum.setFont(new Font("Segoe UI", Font.PLAIN, 18));
					buttonDeleteAlbum.setFocusPainted(false);
					buttonDeleteAlbum.setEnabled(true);
					buttonDeleteAlbum.setBorderPainted(false);
					buttonDeleteAlbum.setBorder(new LineBorder(new Color(0, 51, 255), 10));
					buttonDeleteAlbum.setBackground(new Color(15, 15, 15));
					
					JLabel lblCod_1 = new JLabel("Cod:");
					lblCod_1.setForeground(Color.WHITE);
					lblCod_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
						
					JLabel lblNBrani = new JLabel("N. brani:");
					lblNBrani.setForeground(Color.WHITE);
					lblNBrani.setFont(new Font("Segoe UI", Font.PLAIN, 14));
					
					
					GroupLayout gl_panelBackGroundAlbum = new GroupLayout(panelBackGroundAlbum);
					gl_panelBackGroundAlbum.setHorizontalGroup(
						gl_panelBackGroundAlbum.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panelBackGroundAlbum.createSequentialGroup()
								.addContainerGap()
								.addGroup(gl_panelBackGroundAlbum.createParallelGroup(Alignment.LEADING, false)
									.addGroup(gl_panelBackGroundAlbum.createSequentialGroup()
										.addComponent(textFieldNomeAlbum, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(textFieldArtista, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_panelBackGroundAlbum.createSequentialGroup()
										.addComponent(lblCod_1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textFieldCodiceAlbum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(lblNBrani, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textFieldNumeroBrani, 0, 0, Short.MAX_VALUE)))
								.addGap(128)
								.addGroup(gl_panelBackGroundAlbum.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_panelBackGroundAlbum.createSequentialGroup()
										.addComponent(lblDataPubblicazione, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textFieldData, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_panelBackGroundAlbum.createSequentialGroup()
										.addComponent(labelGenere, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textFieldGenere, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(buttonDeleteAlbum, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(buttonModificaAlbum, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(buttonSalvaAlbum, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
					);
					gl_panelBackGroundAlbum.setVerticalGroup(
						gl_panelBackGroundAlbum.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panelBackGroundAlbum.createSequentialGroup()
								.addContainerGap()
								.addGroup(gl_panelBackGroundAlbum.createParallelGroup(Alignment.TRAILING)
									.addComponent(buttonDeleteAlbum, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
									.addComponent(buttonSalvaAlbum, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
									.addComponent(buttonModificaAlbum, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_panelBackGroundAlbum.createSequentialGroup()
										.addGroup(gl_panelBackGroundAlbum.createParallelGroup(Alignment.BASELINE)
											.addComponent(textFieldData, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblDataPubblicazione, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(gl_panelBackGroundAlbum.createParallelGroup(Alignment.BASELINE)
											.addComponent(textFieldGenere, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(labelGenere)))
									.addGroup(gl_panelBackGroundAlbum.createSequentialGroup()
										.addGroup(gl_panelBackGroundAlbum.createParallelGroup(Alignment.BASELINE)
											.addComponent(textFieldNomeAlbum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(textFieldArtista, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(gl_panelBackGroundAlbum.createParallelGroup(Alignment.BASELINE)
											.addComponent(lblCod_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
											.addComponent(textFieldCodiceAlbum, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblNBrani, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
											.addComponent(textFieldNumeroBrani, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))))
								.addContainerGap(12, Short.MAX_VALUE))
					);
					panelBackGroundAlbum.setLayout(gl_panelBackGroundAlbum);
					
					panel2.add(panelBackGroundAlbum);
					
					textFieldCodiceAlbum.setText(rs.getString("id_Album"));
					textFieldNomeAlbum.setText(rs.getString("name"));
					textFieldArtista.setText(rs.getString("id_Artist"));
					textFieldNumeroBrani.setText(rs.getString("songNumber"));
					textFieldGenere.setText(rs.getString("genere"));
					textFieldData.setText(rs.getString("releaseDate"));
				}
			}
			else
				JOptionPane.showMessageDialog(this,
						"DataBase vuoto!!!",
						"Errore",
						JOptionPane.ERROR_MESSAGE);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}