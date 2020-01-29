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
		
		JButton buttonDashboard = new JButton("Dashboard");
		buttonDashboard.setHorizontalAlignment(SwingConstants.LEFT);
		buttonDashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		buttonDashboard.setHorizontalTextPosition(SwingConstants.RIGHT);
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
		buttonDashboard.setFont(new Font("Dialog", Font.PLAIN, 15));
		buttonDashboard.setForeground(new Color(255, 255, 255));
		buttonDashboard.setBackground(black);
		buttonDashboard.setFocusPainted(false);
		buttonDashboard.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonDashboard.setBorderPainted(false);
		buttonDashboard.setIcon(new ImageIcon(HomeGUI.class.getResource("/Img/Dashboard-48.png")));
		
		JButton buttonShowArtists = new JButton("Show artist");
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
		buttonShowArtists.setFont(new Font("Dialog", Font.PLAIN, 15));
		buttonShowArtists.setFocusPainted(false);
		buttonShowArtists.setBorderPainted(false);
		buttonShowArtists.setBackground(new Color(15, 15, 15));
		
		JButton buttonShowAlbums = new JButton("Show albums");
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
		buttonShowAlbums.setFont(new Font("Dialog", Font.PLAIN, 15));
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
				.addGroup(Alignment.TRAILING, gl_menuRight.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_menuRight.createParallelGroup(Alignment.LEADING)
						.addComponent(buttonDashboard, GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
						.addComponent(buttonShowArtists, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
						.addComponent(buttonShowAlbums, GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_menuRight.setVerticalGroup(
			gl_menuRight.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_menuRight.createSequentialGroup()
					.addGap(281)
					.addComponent(buttonDashboard, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(3)
					.addComponent(buttonShowArtists, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(3)
					.addComponent(buttonShowAlbums, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(322, Short.MAX_VALUE))
		);
		menuRight.setLayout(gl_menuRight);
		Card.setLayout(new CardLayout(0, 0));
		
		JPanel panelDashboard = new JPanel();
		panelDashboard.setBackground(grey);
		Card.add(panelDashboard, "name_228475787480200");
		
		JLabel labelCreatedBy = new JLabel("Created by Cammardella Paolo & Franzese Salvatore");
		labelCreatedBy.setHorizontalAlignment(SwingConstants.CENTER);
		labelCreatedBy.setAlignmentX(Component.CENTER_ALIGNMENT);
		labelCreatedBy.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		labelCreatedBy.setForeground(new Color(255, 255, 255));
		labelCreatedBy.setFont(new Font("Dialog", Font.PLAIN, 10));
		
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
		
		GroupLayout gl_panelDashboard = new GroupLayout(panelDashboard);
		gl_panelDashboard.setHorizontalGroup(
			gl_panelDashboard.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDashboard.createSequentialGroup()
					.addGap(10)
					.addComponent(lblDashboard, GroupLayout.DEFAULT_SIZE, 1077, Short.MAX_VALUE)
					.addGap(10))
				.addGroup(gl_panelDashboard.createSequentialGroup()
					.addContainerGap()
					.addComponent(SpazioLeft, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(buttonAddArtist, GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
					.addGap(58)
					.addComponent(buttonAddAlbum, GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(SpazioRight, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_panelDashboard.createSequentialGroup()
					.addGap(20)
					.addComponent(SpazioButtom, GroupLayout.DEFAULT_SIZE, 1077, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panelDashboard.createSequentialGroup()
					.addComponent(labelCreatedBy, GroupLayout.DEFAULT_SIZE, 1085, Short.MAX_VALUE)
					.addContainerGap())
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
								.addComponent(SpazioLeft, GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
								.addGroup(gl_panelDashboard.createParallelGroup(Alignment.BASELINE)
									.addComponent(buttonAddArtist, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
									.addComponent(buttonAddAlbum, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))))
						.addGroup(gl_panelDashboard.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(SpazioRight, GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(SpazioButtom, GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(labelCreatedBy, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panelDashboard.setLayout(gl_panelDashboard);
		
		JPanel panelShowArtists = new JPanel();
		panelShowArtists.setBackground(new Color(26, 26, 26));
		Card.add(panelShowArtists, "name_228485702864300");
		
		JPanel panelShowAlbums = new JPanel();
		panelShowAlbums.setBackground(new Color(26, 26, 26));
		Card.add(panelShowAlbums, "name_228516752218900");
		contentPane.setLayout(gl_contentPane);
		setLocationRelativeTo(null);
	}
}