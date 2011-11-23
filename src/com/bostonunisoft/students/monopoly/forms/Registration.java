package com.bostonunisoft.students.monopoly.forms;


import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.bostonunisoft.students.monopoly.forms.Login.LoginListener;
import com.bostonunisoft.students.monopoly.forms.Login.RegisterListener;

/*
 * @autor Vasetskiy
 */


public class Registration {
 
	Display display ;
	Shell shell = new Shell(display);
	/*Label label = null;
	Button button = null;*/

	public Registration(Display disp) {
		display=disp;
		
		shell.setSize(400, 350);
		shell.setText("LoginForm");
		
		GridLayout shellLayout = new GridLayout(2,false);
		shellLayout.marginLeft=0;
		shellLayout.marginTop=0;
		shellLayout.horizontalSpacing=200;
		
		
		GridLayout gridLayout = new GridLayout(2,true);
				
		/*Group group = new Group(shell, SWT.RIGHT);
		group.setText("��� �� ������");
		group.setSize(150,100);*/
		
		GridData data=new GridData();
		data.horizontalAlignment=5;
	data.horizontalIndent=2;
		
		Group groupLogin = new Group(shell, SWT.RIGHT);
		groupLogin.setLayoutData(data);
		groupLogin.setText("�����������");
		groupLogin.setLayout(gridLayout);
		groupLogin.setSize(150, 100);
		
		Label label = new Label(groupLogin, SWT.NONE);
		label.setText("������� email: ");
		Text textEmail = new Text (groupLogin, SWT.BORDER);
		
		Label labe2 = new Label(groupLogin, SWT.NONE);
		labe2.setText("������� password: ");
		Text textPassword = new Text (groupLogin, SWT.BORDER);
		
		Label labe3 = new Label(groupLogin, SWT.NONE);
		labe3.setText("������� password2: ");
		Text textPassword2 = new Text (groupLogin, SWT.BORDER);
		
		Label labe4 = new Label(groupLogin, SWT.NONE);
		labe4.setText("������� Nicname: ");
		Text textNicName = new Text (groupLogin, SWT.BORDER);
		
		/*Button buttonOk = new Button(groupLogin, SWT.CENTER);
		buttonOk.setText("  �����  ");
		buttonOk.addSelectionListener(new LoginListener());*/
		
		Button buttonCancel = new Button(groupLogin, SWT.NONE);        
		buttonCancel.setText("�����������");
		buttonCancel.addSelectionListener(new RegisterListener());
		
		shell.setDefaultButton (buttonCancel);
		shell.setLayout(shellLayout);        
		
	}
	
	class RegisterListener implements SelectionListener {
		public void widgetSelected(SelectionEvent e) {
			/*
			 * ������� � ����!
			 */
			shell.close();
		}
		public void widgetDefaultSelected(SelectionEvent e) {}
	}
	
	public void start() {
		shell.open();
		while(!shell.isDisposed())
			if(!display.readAndDispatch())
				display.sleep();
		//display.dispose();
	}
	
	/*public static void main(String... args){
		Registration simpleGUI = new Registration();
		simpleGUI.start();
		
	}*/
	
	
}