package com.student;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class StudentManagementForm implements ActionListener{
	private JFrame frame;
	//labels
	private JLabel id_ld=new JLabel("id: ");
	private JLabel name_lb=new JLabel("name: ");
	//text field
	private JTextField id_tf=new JTextField();
	private JTextField name_tf=new JTextField();
	//buttons
	private JButton insert_btn=new JButton("Insert");
	private JButton view_btn=new JButton("View");
	private JButton update_btn=new JButton("Update");
	private JButton delete_btn=new JButton("Delete");
	//constructor
	public StudentManagementForm() {
		createWindow();
		setLocationAndSIze();
		addComponentsToFrame();
		addActionEvent();
	}
	private void addActionEvent() {
		update_btn.addActionListener(this);
		delete_btn.addActionListener(this);
		insert_btn.addActionListener(this);
		view_btn.addActionListener(this);
	}
	private void addComponentsToFrame() {
		frame.add(id_ld);
		frame.add(name_lb);
		frame.add(id_tf);
		frame.add(name_tf);
		frame.add(update_btn);
		frame.add(delete_btn);
		frame.add(insert_btn);
		frame.add(view_btn);
	}
	private void setLocationAndSIze() {
		id_ld.setBounds(20,20,100,20);
		name_lb.setBounds(20,70,100,20);
		id_tf.setBounds(180,20,100,20);
		name_tf.setBounds(180, 70, 100, 20);
		insert_btn.setBounds(20,120,70,20);
		view_btn.setBounds(100,120,65,20);
		update_btn.setBounds(180,120,80,20);
		delete_btn.setBounds(280,120,80,20);

	}
	private void createWindow() {
		frame=new JFrame();
		frame.setTitle("Student management");
		frame.setBounds(20, 200, 380, 200);
		frame.getContentPane().setBackground(Color.GRAY);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Student st=new Student();
		if(e.getSource()==insert_btn) {
			st.setId(Integer.parseInt(id_tf.getText()));
			st.setName(name_tf.getText());
			st.insertDataIntoDatabase();
		}else if(e.getSource()==view_btn){
			//st.setId(Integer.parseInt(id_tf.getText()));
			st.readwithID(Integer.parseInt(id_tf.getText()));
			name_tf.setText(st.getName());
		}else if(e.getSource()==update_btn) {
			int id=Integer.parseInt(id_tf.getText());
			st.setName(name_tf.getText());
			//In case you have combobox
			//st.setGender((String)genderBox.getSelectedItem());
			st.update(id);
		}else if (e.getSource()==delete_btn) {
			int id=Integer.parseInt(id_tf.getText());
			st.delete(id);
		}

	}
	public static void main(String[] args) {
		StudentManagementForm lgfrm=new StudentManagementForm();
	}
}
