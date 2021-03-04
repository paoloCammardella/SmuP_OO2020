package GUI;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import _Controller.Controller;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

public class LoginGUI extends JFrame {

	private JPanel contentPane;

	private Controller controller;

	Color darkGrey = new Color(21, 21, 21);
	Color grey = new Color(26, 26, 26);
	Color black = new Color(15, 15, 15);
	Color blue = new Color(0, 0, 255);
	Color darkBlue = new Color(0, 0, 153);
	Color green = new Color(50,205,50);
	Color darkGreen = new Color(0,100,0);
	Color purple = new Color(147,112,219);
	Color blueViolet = new Color(138,43,226);
	Color darkPurple = new Color(128,0,128);

	int mouseX, mouseY;
	private JTextField usernameTextField;
	private JPasswordField passwordField;

	public LoginGUI(Controller controller) {
		this.controller = controller;

		setUndecorated(true);
		setBackground(Color.DARK_GRAY);

		setIconImage(Toolkit.getDefaultToolkit().getImage(HomeGUI.class.getResource("/Img/LogoB-48.png")));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 475);
		contentPane = new JPanel();
		contentPane.setBackground(darkGrey);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();

				setLocation(x - mouseX, y - mouseY);
			}
		});

		setLocationRelativeTo(null);

		JPanel panelLogin = new JPanel();
		panelLogin.setBackground(grey);

		JLabel labelX = new JLabel("x");
		labelX.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		labelX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		labelX.setForeground(Color.RED);
		labelX.setFont(new Font("Segoe UI", Font.PLAIN, 26));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(5)
						.addComponent(panelLogin, GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE)
						.addGap(5))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
						.addContainerGap(637, Short.MAX_VALUE)
						.addComponent(labelX, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
						.addComponent(labelX, GroupLayout.PREFERRED_SIZE, 25, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panelLogin, GroupLayout.PREFERRED_SIZE, 408, GroupLayout.PREFERRED_SIZE)
						.addGap(6))
				);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(10, 33, 638, 36);
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setFont(new Font("Segoe UI", Font.BOLD, 26));

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(146, 94, 376, 25);
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Segoe UI", Font.PLAIN, 18));

		usernameTextField = new JTextField();
		usernameTextField.setBounds(146, 120, 380, 30);
		usernameTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				usernameTextField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) blueViolet));
			}
			@Override
			public void focusLost(FocusEvent e) {
				usernameTextField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
			}
		});
		usernameTextField.setSelectionColor(new Color(0, 153, 204));
		usernameTextField.setSelectedTextColor(Color.WHITE);
		usernameTextField.setOpaque(false);
		usernameTextField.setForeground(Color.WHITE);
		usernameTextField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		usernameTextField.setColumns(10);
		usernameTextField.setCaretColor(new Color(0, 153, 204));
		usernameTextField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		usernameTextField.setBackground(new Color(36, 53, 102));

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(146, 161, 376, 25);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Segoe UI", Font.PLAIN, 18));

		JLabel lblNonHaiUn = new JLabel("Don't have a account?");
		lblNonHaiUn.setBounds(146, 239, 184, 25);
		lblNonHaiUn.setForeground(Color.WHITE);
		lblNonHaiUn.setFont(new Font("Segoe UI", Font.PLAIN, 18));

		JButton buttonAnnulla = new JButton("Annulla");
		buttonAnnulla.setBounds(146, 340, 380, 41);
		buttonAnnulla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				buttonAnnulla.setBackground(new Color(139, 0, 0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				buttonAnnulla.setBackground(new Color(204, 0, 0));
			}
		});
		buttonAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		buttonAnnulla.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonAnnulla.setForeground(Color.WHITE);
		buttonAnnulla.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		buttonAnnulla.setFocusPainted(false);
		buttonAnnulla.setBorderPainted(false);
		buttonAnnulla.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 0, 0)));
		buttonAnnulla.setBackground(new Color(204, 0, 0));

		JButton btnAccedi = new JButton("Sign in");
		btnAccedi.setBounds(146, 293, 380, 41);
		btnAccedi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = usernameTextField.getText();
				String password = String.valueOf(passwordField.getPassword());

				controller.checkUser(username, password);

				usernameTextField.setText("");
				passwordField.setText("");
			}
		});
		btnAccedi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAccedi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAccedi.setBackground(darkGreen);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnAccedi.setBackground(green);
			}
		});
		btnAccedi.setForeground(Color.WHITE);
		btnAccedi.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnAccedi.setFocusPainted(false);
		btnAccedi.setBorderPainted(false);
		btnAccedi.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 0, 0)));
		btnAccedi.setBackground(green);

		JButton btnRegistra = new JButton("Sign Up now");
		btnRegistra.setBounds(334, 233, 116, 34);
		btnRegistra.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnRegistra.setForeground(blueViolet);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnRegistra.setForeground(purple);
			}
		});
		btnRegistra.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegistra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.frameSignUpGUI();
				setVisible(false);
			}
		});
		btnRegistra.setForeground(purple);
		btnRegistra.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnRegistra.setFocusPainted(false);
		btnRegistra.setBorderPainted(false);
		btnRegistra.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 0, 0)));
		btnRegistra.setBackground(grey);

		JCheckBox chckbxShowPassword = new JCheckBox("");
		chckbxShowPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chckbxShowPassword.isSelected())
					passwordField.setEchoChar((char)0);
				else
					passwordField.setEchoChar('●');
			}
		});
		chckbxShowPassword.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxShowPassword.setBounds(486, 192, 40, 34);

		chckbxShowPassword.setIcon(new ImageIcon(LoginGUI.class.getResource("/Img/NOShowPassword-32.png")));
		chckbxShowPassword.setSelectedIcon(new ImageIcon(LoginGUI.class.getResource("/Img/ShowPassword-32.png")));
		chckbxShowPassword.setPressedIcon(new ImageIcon(LoginGUI.class.getResource("/Img/ShowPassword-32.png")));

		chckbxShowPassword.setForeground(Color.WHITE);
		chckbxShowPassword.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		chckbxShowPassword.setFocusPainted(false);
		chckbxShowPassword.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		chckbxShowPassword.setBackground(new Color(26, 26, 26));

		passwordField = new JPasswordField();
		passwordField.setEchoChar('●');
		passwordField.setBounds(146, 197, 330, 30);
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				passwordField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) blueViolet));
			}
			@Override
			public void focusLost(FocusEvent e) {
				passwordField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
			}
		});
		passwordField.setSelectionColor(new Color(0, 153, 204));
		passwordField.setSelectedTextColor(Color.WHITE);
		passwordField.setOpaque(false);
		passwordField.setForeground(Color.WHITE);
		passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		passwordField.setColumns(10);
		passwordField.setCaretColor(new Color(0, 153, 204));
		passwordField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		passwordField.setBackground(new Color(36, 53, 102));
		panelLogin.setLayout(null);
		panelLogin.add(lblLogin);
		panelLogin.add(lblNonHaiUn);
		panelLogin.add(btnRegistra);
		panelLogin.add(btnAccedi);
		panelLogin.add(buttonAnnulla);
		panelLogin.add(usernameTextField);
		panelLogin.add(lblUsername);
		panelLogin.add(lblPassword);
		panelLogin.add(passwordField);
		panelLogin.add(chckbxShowPassword);
		contentPane.setLayout(gl_contentPane);
	}
}
