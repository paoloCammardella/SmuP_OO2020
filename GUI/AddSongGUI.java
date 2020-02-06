package GUI;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import _Controller.Controller;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class AddSongGUI extends JFrame {

	private JPanel contentPane;
	
	private Controller controller;
	private JComboBox<String> comboBoxPubblicazioni;
	
	Color darkGrey = new Color(21, 21, 21);
	Color grey = new Color(26, 26, 26);
	Color black = new Color(15, 15, 15);
	Color blue = new Color(0, 0, 153);
	
	int mouseX, mouseY;
	private JTextField textFieldNomePubblicazione;
	private JTextField textFieldDurata;
	private JTextField textFieldGenere;
	private JTextField textFieldEP;

	public AddSongGUI(Controller controller) {
		setUndecorated(true);
		
		setResizable(false);
		this.controller = controller;
		
		setTitle("Aggiungi Artist");
		setAlwaysOnTop(true);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 448, 726);
		setBackground(darkGrey);
		
		contentPane = new JPanel();
		contentPane.setBackground(darkGrey);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelAdd = new JPanel();
		panelAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		panelAdd.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				
				setLocation(x - mouseX, y - mouseY);
			}
		});
		panelAdd.setBackground(darkGrey);
		contentPane.add(panelAdd, BorderLayout.CENTER);
		
		DateFormat format = new SimpleDateFormat("dd/MM/YYYY");
		
		JPanel AddArtist = new JPanel();
		AddArtist.setBackground(grey);
		
		JButton btnAggiungi = new JButton("Aggiungi");
		btnAggiungi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAggiungi.setBorderPainted(false);
		btnAggiungi.setForeground(Color.WHITE);
		btnAggiungi.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnAggiungi.setFocusPainted(false);
		btnAggiungi.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 0, 0)));
		btnAggiungi.setBackground(blue);
		
		JLabel labelAddSong = new JLabel("Add Song");
		labelAddSong.setBounds(10, 11, 401, 36);
		labelAddSong.setHorizontalAlignment(SwingConstants.CENTER);
		labelAddSong.setForeground(Color.WHITE);
		labelAddSong.setFont(new Font("Segoe UI", Font.BOLD, 26));
		
		JLabel labelErroreInput = new JLabel("");
		labelErroreInput.setBounds(20, 538, 0, 23);
		labelErroreInput.setForeground(Color.RED);
		labelErroreInput.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		JLabel lblHaiQualcheSingolo = new JLabel("Tipo di pubblicazione");
		lblHaiQualcheSingolo.setBounds(10, 120, 401, 25);
		lblHaiQualcheSingolo.setForeground(Color.WHITE);
		lblHaiQualcheSingolo.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		
		textFieldNomePubblicazione = new JTextField();
		textFieldNomePubblicazione.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textFieldNomePubblicazione.setBorder(new MatteBorder(0, 0, 2, 0, (Color) blue));
			}
			@Override
			public void focusLost(FocusEvent e) {
				textFieldNomePubblicazione.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
			}
		});
		textFieldNomePubblicazione.setBounds(10, 229, 361, 30);
		textFieldNomePubblicazione.setVisible(false);
		textFieldNomePubblicazione.setSelectionColor(new Color(0, 153, 204));
		textFieldNomePubblicazione.setSelectedTextColor(Color.WHITE);
		textFieldNomePubblicazione.setOpaque(false);
		textFieldNomePubblicazione.setForeground(Color.WHITE);
		textFieldNomePubblicazione.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textFieldNomePubblicazione.setColumns(10);
		textFieldNomePubblicazione.setCaretColor(new Color(0, 153, 204));
		textFieldNomePubblicazione.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		textFieldNomePubblicazione.setBackground(new Color(36, 53, 102));
		
		JLabel labelNomePubblicazione = new JLabel("Nome Song");
		labelNomePubblicazione.setBounds(10, 193, 361, 25);
		labelNomePubblicazione.setVisible(false);
		labelNomePubblicazione.setForeground(Color.WHITE);
		labelNomePubblicazione.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		
		JLabel labelDurata = new JLabel("Durata");
		labelDurata.setBounds(10, 270, 361, 25);
		labelDurata.setVisible(false);
		labelDurata.setForeground(Color.WHITE);
		labelDurata.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		
		textFieldDurata = new JTextField();
		textFieldDurata.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textFieldDurata.setBorder(new MatteBorder(0, 0, 2, 0, (Color) blue));
			}
			@Override
			public void focusLost(FocusEvent e) {
				textFieldDurata.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
			}
		});
		textFieldDurata.setBounds(10, 306, 361, 30);
		textFieldDurata.setVisible(false);
		textFieldDurata.setSelectionColor(new Color(0, 153, 204));
		textFieldDurata.setSelectedTextColor(Color.WHITE);
		textFieldDurata.setOpaque(false);
		textFieldDurata.setForeground(Color.WHITE);
		textFieldDurata.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textFieldDurata.setColumns(10);
		textFieldDurata.setCaretColor(new Color(0, 153, 204));
		textFieldDurata.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		textFieldDurata.setBackground(new Color(36, 53, 102));
		
		textFieldGenere = new JTextField();
		textFieldGenere.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textFieldGenere.setBorder(new MatteBorder(0, 0, 2, 0, (Color) blue));
			}
			@Override
			public void focusLost(FocusEvent e) {
				textFieldGenere.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
			}
		});
		textFieldGenere.setBounds(10, 383, 361, 30);
		textFieldGenere.setVisible(false);
		textFieldGenere.setSelectionColor(new Color(0, 153, 204));
		textFieldGenere.setSelectedTextColor(Color.WHITE);
		textFieldGenere.setOpaque(false);
		textFieldGenere.setForeground(Color.WHITE);
		textFieldGenere.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textFieldGenere.setColumns(10);
		textFieldGenere.setCaretColor(new Color(0, 153, 204));
		textFieldGenere.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		textFieldGenere.setBackground(new Color(36, 53, 102));
		
		JLabel labelGenere = new JLabel("Genere");
		labelGenere.setBounds(10, 347, 361, 25);
		labelGenere.setVisible(false);
		labelGenere.setForeground(Color.WHITE);
		labelGenere.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		
		textFieldEP = new JTextField();
		textFieldEP.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textFieldEP.setBorder(new MatteBorder(0, 0, 2, 0, (Color) blue));
			}
			@Override
			public void focusLost(FocusEvent e) {
				textFieldEP.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
			}
		});
		textFieldEP.setBounds(10, 460, 361, 30);
		textFieldEP.setVisible(false);
		textFieldEP.setSelectionColor(new Color(0, 153, 204));
		textFieldEP.setSelectedTextColor(Color.WHITE);
		textFieldEP.setOpaque(false);
		textFieldEP.setForeground(Color.WHITE);
		textFieldEP.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textFieldEP.setColumns(10);
		textFieldEP.setCaretColor(new Color(0, 153, 204));
		textFieldEP.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		textFieldEP.setBackground(new Color(36, 53, 102));
		
		JLabel labelNomeEP = new JLabel("Nome EP");
		labelNomeEP.setBounds(10, 424, 361, 25);
		labelNomeEP.setVisible(false);
		labelNomeEP.setForeground(Color.WHITE);
		labelNomeEP.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		
		JLabel labelAlbum = new JLabel("Album");
		labelAlbum.setForeground(Color.WHITE);
		labelAlbum.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		labelAlbum.setBounds(10, 424, 401, 25);
		labelAlbum.setVisible(false);
		AddArtist.add(labelAlbum);
		
		JComboBox<String> comboBoxAlbum = new JComboBox<String>();
		comboBoxAlbum.setOpaque(true);
		comboBoxAlbum.setForeground(Color.WHITE);
		comboBoxAlbum.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		comboBoxAlbum.setBorder(null);
		comboBoxAlbum.setBackground(new Color(21, 21, 21));
		comboBoxAlbum.setBounds(10, 460, 179, 26);
		comboBoxAlbum.setVisible(false);
		AddArtist.add(comboBoxAlbum);
		
		
		comboBoxPubblicazioni = new JComboBox<String>();
		comboBoxPubblicazioni.setBounds(10, 156, 179, 26);
		comboBoxPubblicazioni.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				comboBoxPubblicazioni.setBackground(darkGrey);
			}
		});
		comboBoxPubblicazioni.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		comboBoxPubblicazioni.setBackground(darkGrey);
		comboBoxPubblicazioni.setBorder(null);
		comboBoxPubblicazioni.setForeground(Color.white);
		comboBoxPubblicazioni.setOpaque(true);
		comboBoxPubblicazioni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBoxPubblicazioni.getSelectedItem() == "Singolo") {
					textFieldNomePubblicazione.setVisible(true);
					labelNomePubblicazione.setVisible(true);
					labelDurata.setVisible(true);
					textFieldDurata.setVisible(true);
					textFieldGenere.setVisible(true);
					labelGenere.setVisible(true);
					labelNomeEP.setVisible(false);
					textFieldEP.setVisible(false);
					labelAlbum.setVisible(false);
					comboBoxAlbum.setVisible(false);
				}
				else if(comboBoxPubblicazioni.getSelectedItem() == "Brano") {
					textFieldNomePubblicazione.setVisible(true);
					labelNomePubblicazione.setVisible(true);
					labelDurata.setVisible(true);
					textFieldDurata.setVisible(true);
					textFieldGenere.setVisible(true);
					labelGenere.setVisible(true);
					labelAlbum.setVisible(true);
					comboBoxAlbum.setVisible(true);
					labelNomeEP.setVisible(false);
					textFieldEP.setVisible(false);
				}
				else if(comboBoxPubblicazioni.getSelectedItem() == "EP") {
					textFieldNomePubblicazione.setVisible(true);
					labelNomePubblicazione.setVisible(true);
					labelDurata.setVisible(true);
					textFieldDurata.setVisible(true);
					textFieldGenere.setVisible(true);
					labelGenere.setVisible(true);
					labelNomeEP.setVisible(true);
					textFieldEP.setVisible(true);
					labelAlbum.setVisible(false);
					comboBoxAlbum.setVisible(false);
				}
				else {
					textFieldNomePubblicazione.setVisible(false);
					labelNomePubblicazione.setVisible(false);
					labelDurata.setVisible(false);
					textFieldDurata.setVisible(false);
					textFieldGenere.setVisible(false);
					labelGenere.setVisible(false);
					textFieldEP.setVisible(false);
					textFieldEP.setVisible(false);
					labelAlbum.setVisible(false);
					comboBoxAlbum.setVisible(false);
				}
			}
		});
		comboBoxPubblicazioni.setModel(new DefaultComboBoxModel<String>(new String[] {"No", "Singolo", "EP", "Brano"}));
		
		JLabel labelX = new JLabel("x");
		labelX.setAlignmentY(Component.TOP_ALIGNMENT);
		labelX.setAlignmentX(Component.RIGHT_ALIGNMENT);
		labelX.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		labelX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		labelX.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		labelX.setForeground(new Color(255, 0, 0));
		
		JButton btnAnnulla = new JButton("Annulla");
		btnAnnulla.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnAnnulla.setForeground(Color.WHITE);
		btnAnnulla.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnAnnulla.setFocusPainted(false);
		btnAnnulla.setBorderPainted(false);
		btnAnnulla.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 0, 0)));
		btnAnnulla.setBackground(new Color(204, 0, 0));
		
		GroupLayout gl_panelAdd = new GroupLayout(panelAdd);
		gl_panelAdd.setHorizontalGroup(
			gl_panelAdd.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelAdd.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelAdd.createParallelGroup(Alignment.TRAILING)
						.addComponent(AddArtist, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
						.addComponent(labelX)
						.addComponent(btnAggiungi, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
						.addComponent(btnAnnulla, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panelAdd.setVerticalGroup(
			gl_panelAdd.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelAdd.createSequentialGroup()
					.addComponent(labelX)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(AddArtist, GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnAggiungi, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAnnulla, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		AddArtist.setLayout(null);
		AddArtist.add(labelErroreInput);
		AddArtist.add(labelNomeEP);
		AddArtist.add(textFieldEP);
		AddArtist.add(labelGenere);
		AddArtist.add(textFieldGenere);
		AddArtist.add(labelDurata);
		AddArtist.add(textFieldDurata);
		AddArtist.add(labelNomePubblicazione);
		AddArtist.add(textFieldNomePubblicazione);
		AddArtist.add(comboBoxPubblicazioni);
		AddArtist.add(lblHaiQualcheSingolo);
		AddArtist.add(labelAddSong);
		
		JLabel labelNomeArtista = new JLabel("Artista");
		labelNomeArtista.setForeground(Color.WHITE);
		labelNomeArtista.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		labelNomeArtista.setBounds(10, 47, 401, 25);
		AddArtist.add(labelNomeArtista);
		
		JComboBox<String> comboBoxArtisti = new JComboBox<String>();
		comboBoxArtisti.setOpaque(true);
		comboBoxArtisti.setForeground(Color.WHITE);
		comboBoxArtisti.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		comboBoxArtisti.setBorder(null);
		comboBoxArtisti.setBackground(new Color(21, 21, 21));
		comboBoxArtisti.setBounds(10, 83, 179, 26);
		AddArtist.add(comboBoxArtisti);
		
		panelAdd.setLayout(gl_panelAdd);

		setLocationRelativeTo(null);
		
	}
}
