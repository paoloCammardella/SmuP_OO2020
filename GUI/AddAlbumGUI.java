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
import java.awt.Cursor;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddAlbumGUI extends JFrame {

	private JPanel contentPane;
	
	private Controller controller;
	private JTextField textFieldCodice;
	private JTextField textFieldNome;
	private JTextField textFieldGenere;
	
	Color darkGrey = new Color(21, 21, 21);
	Color grey = new Color(26, 26, 26);
	Color black = new Color(15, 15, 15);
	Color blue = new Color(0, 0, 153);
	
	int mouseX, mouseY;

	public AddAlbumGUI(Controller controller) {
		setUndecorated(true);
		
		setResizable(false);
		this.controller = controller;
		
		setTitle("Aggiungi Artist");
		setAlwaysOnTop(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 449, 613);
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
		
		JPanel AddAlbum = new JPanel();
		AddAlbum.setBackground(grey);
		
		JButton button = new JButton("Create");
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setBorderPainted(false);
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		button.setFocusPainted(false);
		button.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 0, 0)));
		button.setBackground(blue);
		
		JLabel labelCodice = new JLabel("Codice");
		labelCodice.setForeground(Color.WHITE);
		labelCodice.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		
		JLabel labelNome = new JLabel("Nome");
		labelNome.setForeground(Color.WHITE);
		labelNome.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		
		textFieldNome = new JTextField();
		textFieldNome.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				//labelNome.setForeground(blue);
				textFieldNome.setBorder(new MatteBorder(0, 0, 2, 0, (Color) blue));
			}
			@Override
			public void focusLost(FocusEvent e) {
				//labelNome.setForeground(Color.WHITE);
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
		
		JLabel labelGenere = new JLabel("Genere");
		labelGenere.setForeground(Color.WHITE);
		labelGenere.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		
		textFieldGenere = new JTextField();
		textFieldGenere.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				//labelGenere.setForeground(blue);
				textFieldGenere.setBorder(new MatteBorder(0, 0, 2, 0, (Color) blue));
			}
			@Override
			public void focusLost(FocusEvent e) {
				//labelGenere.setForeground(Color.WHITE);
				textFieldGenere.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
			}
		});
		textFieldGenere.setOpaque(false);
		textFieldGenere.setSelectionColor(new Color(0, 153, 204));
		textFieldGenere.setSelectedTextColor(Color.WHITE);
		textFieldGenere.setForeground(Color.WHITE);
		textFieldGenere.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textFieldGenere.setColumns(10);
		textFieldGenere.setCaretColor(new Color(0, 153, 204));
		textFieldGenere.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		textFieldGenere.setBackground(new Color(36, 53, 102));
		
		JLabel labelAddAlbum = new JLabel("Add Album");
		labelAddAlbum.setHorizontalAlignment(SwingConstants.CENTER);
		labelAddAlbum.setForeground(Color.WHITE);
		labelAddAlbum.setFont(new Font("Segoe UI", Font.BOLD, 26));
		
		textFieldCodice = new JTextField();
		textFieldCodice.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				//labelCodice.setForeground(blue);
				textFieldCodice.setBorder(new MatteBorder(0, 0, 2, 0, (Color) blue));
			}
			@Override
			public void focusLost(FocusEvent e) {
				//labelCodice.setForeground(Color.WHITE);
				textFieldCodice.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
			}
		});
		textFieldCodice.setOpaque(false);
		textFieldCodice.setSelectionColor(new Color(0, 153, 204));
		textFieldCodice.setSelectedTextColor(Color.WHITE);
		textFieldCodice.setForeground(Color.WHITE);
		textFieldCodice.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textFieldCodice.setColumns(10);
		textFieldCodice.setCaretColor(new Color(0, 153, 204));
		textFieldCodice.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		textFieldCodice.setBackground(new Color(36, 53, 102));
		GroupLayout gl_AddAlbum = new GroupLayout(AddAlbum);
		gl_AddAlbum.setHorizontalGroup(
			gl_AddAlbum.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_AddAlbum.createSequentialGroup()
					.addGroup(gl_AddAlbum.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_AddAlbum.createSequentialGroup()
							.addGap(25)
							.addGroup(gl_AddAlbum.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(textFieldCodice, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
								.addComponent(labelCodice, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(labelNome, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(textFieldNome)
								.addComponent(labelGenere, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(textFieldGenere)))
						.addGroup(gl_AddAlbum.createSequentialGroup()
							.addContainerGap()
							.addComponent(labelAddAlbum, GroupLayout.PREFERRED_SIZE, 385, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(13, Short.MAX_VALUE))
		);
		gl_AddAlbum.setVerticalGroup(
			gl_AddAlbum.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_AddAlbum.createSequentialGroup()
					.addContainerGap()
					.addComponent(labelAddAlbum, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addComponent(labelCodice, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textFieldCodice, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(labelNome, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textFieldNome, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(labelGenere, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textFieldGenere, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(261, Short.MAX_VALUE))
		);
		AddAlbum.setLayout(gl_AddAlbum);
		
		JLabel labelX = new JLabel("x");
		labelX.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		labelX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		labelX.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		labelX.setForeground(new Color(255, 0, 0));
		
		JButton button_1 = new JButton("Annulla");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		button_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		button_1.setFocusPainted(false);
		button_1.setBorderPainted(false);
		button_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 0, 0)));
		button_1.setBackground(new Color(204, 0, 0));
		GroupLayout gl_panelAdd = new GroupLayout(panelAdd);
		gl_panelAdd.setHorizontalGroup(
			gl_panelAdd.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelAdd.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelAdd.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panelAdd.createSequentialGroup()
							.addComponent(labelX)
							.addGap(21))
						.addGroup(Alignment.TRAILING, gl_panelAdd.createSequentialGroup()
							.addGroup(gl_panelAdd.createParallelGroup(Alignment.TRAILING)
								.addComponent(button_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
								.addComponent(AddAlbum, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE))
							.addGap(9))
						.addGroup(gl_panelAdd.createSequentialGroup()
							.addComponent(button, GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
							.addGap(9))))
		);
		gl_panelAdd.setVerticalGroup(
			gl_panelAdd.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelAdd.createSequentialGroup()
					.addContainerGap()
					.addComponent(labelX, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(AddAlbum, GroupLayout.PREFERRED_SIZE, 460, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelAdd.setLayout(gl_panelAdd);

		setLocationRelativeTo(null);
		
	}
}
