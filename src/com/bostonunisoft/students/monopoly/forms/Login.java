package com.bostonunisoft.students.monopoly.forms;

import org.eclipse.swt.events.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.*;

/*
 * @autor Vasetskiy
 */

public class Login {
	Display display = new Display();
	Shell shell = new Shell(display);
	Label label = null;
	Button button = null;

	public Login() {
		//shell.setLayout(new GridLayout(6,false));
		shell.setSize(400, 350);
		shell.setText("LoginForm");
		
		GridLayout shellLayout = new GridLayout(2,false);
		shellLayout.marginLeft=0;
		shellLayout.marginTop=0;
		shellLayout.horizontalSpacing=20;
		
		GridLayout gridLayout = new GridLayout(2,true);
				
		Group group = new Group(shell, SWT.RIGHT);
		group.setText("��� �� ������");
		group.setSize(150,100);
		
		Group groupLogin = new Group(shell, SWT.RIGHT);
		groupLogin.setText("����/�����������");
		groupLogin.setLayout(gridLayout);
		groupLogin.setSize(150, 100);
		
		Label label = new Label(groupLogin, SWT.NONE);
		label.setText("������� email: ");
		Text textEmail = new Text (groupLogin, SWT.BORDER);
		
		Label labe2 = new Label(groupLogin, SWT.NONE);
		labe2.setText("������� password: ");
		Text textPassword = new Text (groupLogin, SWT.BORDER);
		
				
		Button buttonOk = new Button(groupLogin, SWT.CENTER);
		buttonOk.setText("  �����  ");
		buttonOk.addSelectionListener(new LoginListener());
		
		Button buttonCancel = new Button(groupLogin, SWT.NONE);        
		buttonCancel.setText("�����������");
		buttonCancel.addSelectionListener(new RegisterListener());
		
		shell.setDefaultButton (buttonCancel);
		shell.setLayout(shellLayout);        
		
		
		//shell.pack();
		/*label = new Label(shell, SWT.NONE);
		label.setText("Say Hello.");
		button = new Button(shell, SWT.NONE);
		button.setText("Say");
		button.addSelectionListener(new SimpleListener());*/
		//shell.pack();
		//label.pack();
		//button.pack();
	}

	class LoginListener implements SelectionListener {
		public void widgetSelected(SelectionEvent e) {
			MessageBox message = new MessageBox(shell,
				SWT.ICON_WARNING | SWT.OK);
			message.setText("Message Box");
			message.setMessage("Hello!");
			message.open();
		}
		public void widgetDefaultSelected(SelectionEvent e) {}
	}
	
	class RegisterListener implements SelectionListener {
		public void widgetSelected(SelectionEvent e) {
			
			Registration registerForm = new Registration(display);
			registerForm.start();
			
			
		}
		public void widgetDefaultSelected(SelectionEvent e) {}
	}
	

	public void start() {
		shell.open();
		while(!shell.isDisposed()){
			if(!display.readAndDispatch())
				display.sleep();}
		display.dispose();
	}
	

	public static void main(String[] args) {
		Login simpleGUI = new Login();
		simpleGUI.start();
		
	}
}
