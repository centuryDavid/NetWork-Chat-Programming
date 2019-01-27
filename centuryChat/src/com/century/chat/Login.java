package com.century.chat;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAddress;
	private JTextField txtPort;
	private JLabel lblAddressDesc;
	private JLabel lblPortDesc;

	public Login() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		setResizable(false);
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 400);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtName = new JTextField();
		txtName.setBounds(86, 67, 122, 21);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtAddress = new JTextField();
		txtAddress.setBounds(86, 127, 122, 21);
		contentPane.add(txtAddress);
		txtAddress.setColumns(10);
		
		txtPort = new JTextField();
		txtPort.setBounds(86, 216, 122, 21);
		contentPane.add(txtPort);
		txtPort.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setFont(new Font("Century", Font.PLAIN, 16));
		lblNewLabel.setBounds(119, 38, 56, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblIpaddress = new JLabel("IPAddress:");
		lblIpaddress.setFont(new Font("Century", Font.PLAIN, 16));
		lblIpaddress.setBounds(106, 98, 81, 19);
		contentPane.add(lblIpaddress);
		
		JLabel lblPort = new JLabel("Port:");
		lblPort.setFont(new Font("Century", Font.PLAIN, 16));
		lblPort.setBounds(129, 187, 36, 19);
		contentPane.add(lblPort);
		
		lblAddressDesc = new JLabel("(eg.192.168.0.1)");
		lblAddressDesc.setFont(new Font("Century", Font.PLAIN, 16));
		lblAddressDesc.setBounds(86, 158, 122, 19);
		contentPane.add(lblAddressDesc);
		
		lblPortDesc = new JLabel("(eg.8196)");
		lblPortDesc.setFont(new Font("Century", Font.PLAIN, 16));
		lblPortDesc.setBounds(113, 247, 67, 19);
		contentPane.add(lblPortDesc);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String name = txtName.getText();
						String address = txtAddress.getText();
						int port = Integer.parseInt(txtPort.getText());
						login(name, address, port);
					}

				});
		btnLogin.setBounds(94, 297, 105, 30);
		contentPane.add(btnLogin);
	}

	private void login(String name, String address, int port) {
		dispose();
		new ClientWindow(name, address, port);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
