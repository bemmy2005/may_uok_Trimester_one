package com.form;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SimpleLogin implements ActionListener{
	private JFrame frame;
	//labels
	private JLabel username_lb=new JLabel("Usename: ");
	private JLabel password_lb=new JLabel("Password: ");
	//text field
	private JTextField username_tf=new JTextField();
	private JTextField password_tf=new JTextField();
	//buttons
	private JButton login_btn=new JButton("Login");
	private JButton reset_btn=new JButton("Reset");
	//constructor
	public SimpleLogin() {
		createWindow();
		setLocationAndSIze();
		addComponentsToFrame();
		addActionEvent();
	}
	private void addActionEvent() {
		login_btn.addActionListener(this);
		reset_btn.addActionListener(this);
	}
	private void addComponentsToFrame() {
		frame.add(username_lb);
		frame.add(password_lb);
		frame.add(username_tf);
		frame.add(password_tf);
		frame.add(login_btn);
		frame.add(reset_btn);
	}
	private void setLocationAndSIze() {
		username_lb.setBounds(20,20,100,20);
		password_lb.setBounds(20,70,100,20);
		username_tf.setBounds(180,20,100,20);
		password_tf.setBounds(180, 70, 100, 20);
		login_btn.setBounds(20,120,100,20);
		reset_btn.setBounds(180,120,100,20);

	}
	private void createWindow() {
		frame=new JFrame();
		frame.setTitle("Simple Login");
		frame.setBounds(20, 200, 380, 200);
		frame.getContentPane().setBackground(Color.GRAY);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==login_btn) {
			if((username_tf.getText()=="Hello") && (password_tf.getText()=="Abana!@")) {
				System.out.println("Your credential are ok!");
			}else {
				System.out.println("Wrong credentials");
			}
		}
		if(e.getSource()==reset_btn) {
			username_tf.setText("");
			password_tf.setText("");
		}

	}
	public static void main(String[] args) {
		SimpleLogin lgfrm=new SimpleLogin();
	}
}
