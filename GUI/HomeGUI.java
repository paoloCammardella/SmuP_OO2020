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
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomeGUI extends JFrame {

	private JPanel contentPane;

	private Controller controller;

	Color darkGrey = new Color(21, 21, 21);
	Color grey = new Color(26, 26, 26);
	Color black = new Color(15, 15, 15);

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
						.addGap(165)
						.addComponent(buttonDashboard, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
						.addGap(3)
						.addComponent(buttonShowArtists, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
						.addGap(3)
						.addComponent(buttonShowAlbums, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(331, Short.MAX_VALUE))
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
		GroupLayout gl_panelShowArtists = new GroupLayout(panelShowArtists);
		gl_panelShowArtists.setHorizontalGroup(
				gl_panelShowArtists.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelShowArtists.createSequentialGroup()
						.addGap(10)
						.addComponent(lblArtists_1, GroupLayout.DEFAULT_SIZE, 1065, Short.MAX_VALUE)
						.addGap(10))
				);
		gl_panelShowArtists.setVerticalGroup(
				gl_panelShowArtists.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelShowArtists.createSequentialGroup()
						.addGap(11)
						.addComponent(lblArtists_1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
				);
		panelShowArtists.setLayout(gl_panelShowArtists);

		Card.add(panelShowAlbums, "name_228516752218900");

		JLabel lblAlbums_1 = new JLabel("ALBUMS");
		lblAlbums_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlbums_1.setForeground(new Color(255, 255, 255));
		lblAlbums_1.setFont(new Font("Segoe UI", Font.BOLD, 30));
		GroupLayout gl_panelShowAlbums = new GroupLayout(panelShowAlbums);
		gl_panelShowAlbums.setHorizontalGroup(
				gl_panelShowAlbums.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelShowAlbums.createSequentialGroup()
						.addGap(10)
						.addComponent(lblAlbums_1, GroupLayout.DEFAULT_SIZE, 1065, Short.MAX_VALUE)
						.addGap(10))
				);
		gl_panelShowAlbums.setVerticalGroup(
				gl_panelShowAlbums.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelShowAlbums.createSequentialGroup()
						.addGap(11)
						.addComponent(lblAlbums_1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
				);
		panelShowAlbums.setLayout(gl_panelShowAlbums);
		contentPane.setLayout(gl_contentPane);
		setLocationRelativeTo(null);
	}
}