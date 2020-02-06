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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.JFormattedTextField;

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
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class AddArtistGUI extends JFrame {

	private JPanel contentPane;
	
	private Controller controller;
	
	private JTextField textFieldCodiceArtista;
	private JTextField textFieldNome;
	private JTextField textFieldCognome;
	private JFormattedTextField textFieldDataNascita;
	private JTextField textFieldNomeDarte;
	private JTextField textFieldCitta;
	private JTextField textFieldFollowers;
	
	Color darkGrey = new Color(21, 21, 21);
	Color grey = new Color(26, 26, 26);
	Color black = new Color(15, 15, 15);
	Color blue = new Color(0, 0, 153);
	
	int mouseX, mouseY;

	public AddArtistGUI(Controller controller) {
		setUndecorated(true);
		
		setResizable(false);
		this.controller = controller;
		
		setTitle("Aggiungi Artist");
		setAlwaysOnTop(true);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 433, 750);
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
		contentPane.add(panelAdd, BorderLayout.SOUTH);
		
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
		
		JLabel labelAddArtist = new JLabel("Add Artist");
		labelAddArtist.setHorizontalAlignment(SwingConstants.CENTER);
		labelAddArtist.setForeground(Color.WHITE);
		labelAddArtist.setFont(new Font("Segoe UI", Font.BOLD, 26));
		
		JLabel labelCodiceArtista = new JLabel("Codice");
		labelCodiceArtista.setForeground(new Color(255, 255, 255));
		labelCodiceArtista.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		
		textFieldCodiceArtista = new JTextField();
		textFieldCodiceArtista.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textFieldCodiceArtista.setBorder(new MatteBorder(0, 0, 2, 0, (Color) blue));
			}
			@Override
			public void focusLost(FocusEvent e) {
				textFieldCodiceArtista.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
			}
		});
		textFieldCodiceArtista.setOpaque(false);
		textFieldCodiceArtista.setSelectedTextColor(new Color(255, 255, 255));
		textFieldCodiceArtista.setSelectionColor(new Color(0, 153, 204));
		textFieldCodiceArtista.setCaretColor(new Color(0, 153, 204));
		textFieldCodiceArtista.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textFieldCodiceArtista.setForeground(new Color(255, 255, 255));
		textFieldCodiceArtista.setBackground(new Color(36, 53, 102));
		textFieldCodiceArtista.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		textFieldCodiceArtista.setColumns(10);
		
		JLabel labelNome = new JLabel("Nome");
		labelNome.setForeground(Color.WHITE);
		labelNome.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		
		textFieldNome = new JTextField();
		textFieldNome.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textFieldNome.setBorder(new MatteBorder(0, 0, 2, 0, (Color) blue));
			}
			@Override
			public void focusLost(FocusEvent e) {
				textFieldNome.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
			}
		});
		textFieldNome.setOpaque(false);
		textFieldNome.setSelectionColor(new Color(0, 153, 204));
		textFieldNome.setSelectedTextColor(Color.WHITE);
		textFieldNome.setForeground(Color.WHITE);
		textFieldNome.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textFieldNome.setColumns(10);
		textFieldNome.setCaretColor(new Color(0, 153, 204));
		textFieldNome.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		textFieldNome.setBackground(new Color(36, 53, 102));
		
		JLabel lblCognome = new JLabel("Cognome");
		lblCognome.setForeground(Color.WHITE);
		lblCognome.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		
		textFieldCognome = new JTextField();
		textFieldCognome.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textFieldCognome.setBorder(new MatteBorder(0, 0, 2, 0, (Color) blue));
			}
			@Override
			public void focusLost(FocusEvent e) {
				textFieldCognome.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
			}
		});
		textFieldCognome.setOpaque(false);
		textFieldCognome.setSelectionColor(new Color(0, 153, 204));
		textFieldCognome.setSelectedTextColor(Color.WHITE);
		textFieldCognome.setForeground(Color.WHITE);
		textFieldCognome.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textFieldCognome.setColumns(10);
		textFieldCognome.setCaretColor(new Color(0, 153, 204));
		textFieldCognome.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		textFieldCognome.setBackground(new Color(36, 53, 102));
		
		JLabel labelData = new JLabel("Data nascita");
		labelData.setForeground(Color.WHITE);
		labelData.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		
		textFieldDataNascita = new JFormattedTextField(format);
		textFieldDataNascita.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textFieldDataNascita.setBorder(new MatteBorder(0, 0, 2, 0, (Color) blue));
			}
			@Override
			public void focusLost(FocusEvent e) {
				textFieldDataNascita.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
			}
		});
		textFieldDataNascita.setOpaque(false);
		textFieldDataNascita.setSelectionColor(new Color(0, 153, 204));
		textFieldDataNascita.setSelectedTextColor(Color.WHITE);
		textFieldDataNascita.setForeground(Color.WHITE);
		textFieldDataNascita.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textFieldDataNascita.setColumns(10);
		textFieldDataNascita.setCaretColor(new Color(0, 153, 204));
		textFieldDataNascita.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		textFieldDataNascita.setBackground(new Color(36, 53, 102));
		
		JLabel labelNomeDarte = new JLabel("Nome d'arte");
		labelNomeDarte.setForeground(Color.WHITE);
		labelNomeDarte.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		
		textFieldNomeDarte = new JTextField();
		textFieldNomeDarte.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textFieldNomeDarte.setBorder(new MatteBorder(0, 0, 2, 0, (Color) blue));
			}
			@Override
			public void focusLost(FocusEvent e) {
				textFieldNomeDarte.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
			}
		});
		textFieldNomeDarte.setOpaque(false);
		textFieldNomeDarte.setSelectionColor(new Color(0, 153, 204));
		textFieldNomeDarte.setSelectedTextColor(Color.WHITE);
		textFieldNomeDarte.setForeground(Color.WHITE);
		textFieldNomeDarte.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textFieldNomeDarte.setColumns(10);
		textFieldNomeDarte.setCaretColor(new Color(0, 153, 204));
		textFieldNomeDarte.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		textFieldNomeDarte.setBackground(new Color(36, 53, 102));
		
		JLabel lblCitt = new JLabel("Citt\u00E0");
		lblCitt.setForeground(Color.WHITE);
		lblCitt.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		
		textFieldCitta = new JTextField();
		textFieldCitta.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textFieldCitta.setBorder(new MatteBorder(0, 0, 2, 0, (Color) blue));
			}
			@Override
			public void focusLost(FocusEvent e) {
				textFieldCitta.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
			}
		});
		textFieldCitta.setOpaque(false);
		textFieldCitta.setSelectionColor(new Color(0, 153, 204));
		textFieldCitta.setSelectedTextColor(Color.WHITE);
		textFieldCitta.setForeground(Color.WHITE);
		textFieldCitta.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textFieldCitta.setColumns(10);
		textFieldCitta.setCaretColor(new Color(0, 153, 204));
		textFieldCitta.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		textFieldCitta.setBackground(new Color(36, 53, 102));
		
		JLabel labelErroreInput = new JLabel("");
		labelErroreInput.setForeground(Color.RED);
		labelErroreInput.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		textFieldFollowers = new JTextField();
		textFieldFollowers.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textFieldFollowers.setBorder(new MatteBorder(0, 0, 2, 0, (Color) blue));
			}
			@Override
			public void focusLost(FocusEvent e) {
				textFieldFollowers.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
			}
		});
		textFieldFollowers.setOpaque(false);
		textFieldFollowers.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char c = e.getKeyChar();
				if(Character.isLetter(c)) {
					labelErroreInput.setText("Caratteri non validi");
				}
				else
					labelErroreInput.setText("");
			}
		});
		textFieldFollowers.setSelectionColor(new Color(0, 153, 204));
		textFieldFollowers.setSelectedTextColor(Color.WHITE);
		textFieldFollowers.setForeground(Color.WHITE);
		textFieldFollowers.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textFieldFollowers.setColumns(10);
		textFieldFollowers.setCaretColor(new Color(0, 153, 204));
		textFieldFollowers.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		textFieldFollowers.setBackground(new Color(36, 53, 102));
		
		JLabel lblFollowers = new JLabel("Followers");
		lblFollowers.setForeground(Color.WHITE);
		lblFollowers.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		
		GroupLayout gl_AddArtist = new GroupLayout(AddArtist);
		gl_AddArtist.setHorizontalGroup(
			gl_AddArtist.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_AddArtist.createSequentialGroup()
					.addGroup(gl_AddArtist.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(Alignment.LEADING, gl_AddArtist.createSequentialGroup()
							.addContainerGap()
							.addComponent(labelAddArtist, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, gl_AddArtist.createSequentialGroup()
							.addGap(20)
							.addGroup(gl_AddArtist.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(labelCodiceArtista, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(textFieldCodiceArtista, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
								.addComponent(textFieldNome, Alignment.LEADING)
								.addComponent(lblCognome, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(labelNome, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(textFieldCognome, Alignment.LEADING)
								.addComponent(labelData, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(textFieldDataNascita, Alignment.LEADING)
								.addComponent(labelNomeDarte, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(textFieldNomeDarte, Alignment.LEADING)
								.addComponent(lblCitt, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(textFieldCitta, Alignment.LEADING)
								.addComponent(lblFollowers, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(textFieldFollowers, Alignment.LEADING)
								.addComponent(labelErroreInput, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_AddArtist.setVerticalGroup(
			gl_AddArtist.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_AddArtist.createSequentialGroup()
					.addContainerGap()
					.addComponent(labelAddArtist, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(labelCodiceArtista)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textFieldCodiceArtista, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(labelNome)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textFieldNome, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblCognome)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textFieldCognome, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(labelData)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textFieldDataNascita, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(labelNomeDarte)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textFieldNomeDarte, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblCitt)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textFieldCitta, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblFollowers)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textFieldFollowers, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(labelErroreInput, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
		);
		AddArtist.setLayout(gl_AddArtist);
		
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
			gl_panelAdd.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelAdd.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelAdd.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelAdd.createSequentialGroup()
							.addComponent(AddArtist, GroupLayout.PREFERRED_SIZE, 402, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_panelAdd.createParallelGroup(Alignment.LEADING)
							.addGroup(Alignment.TRAILING, gl_panelAdd.createSequentialGroup()
								.addComponent(labelX)
								.addContainerGap())
							.addGroup(gl_panelAdd.createSequentialGroup()
								.addComponent(btnAnnulla, GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
								.addGap(11))
							.addGroup(gl_panelAdd.createSequentialGroup()
								.addComponent(btnAggiungi, GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
								.addGap(11)))))
		);
		gl_panelAdd.setVerticalGroup(
			gl_panelAdd.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelAdd.createSequentialGroup()
					.addComponent(labelX)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(AddArtist, GroupLayout.PREFERRED_SIZE, 607, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAggiungi, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnAnnulla, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panelAdd.setLayout(gl_panelAdd);

		setLocationRelativeTo(null);
		
	}
}
