/**
 * 
 */

/**
 * @author sutto11 Sep 2020
 *
 */

/*
 * import swt plugin and appropriate widgets
 */
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.*;

	/**
	 * @param args
	 */
	public class LoginForm {
	  Display display = new Display();
	  Shell shell = new Shell(display);
	  Label label1,label2;
	  Text username;
	  Text password;
	  Text message;
		  
	  public LoginForm() {
		 /* 
		  * set layout and title text on the main frame
		  */
		  shell.setLayout(new GridLayout(2, false));
		  shell.setText("Login Form");
		  
		  /*
		   * UserName label and text variables
		   */
		  label1 = new Label(shell, SWT.NULL);
		  label1.setText("User Name: ");
		  username = new Text(shell, SWT.SINGLE | SWT.BORDER);
		  username.setText("");
		  username.setTextLimit(20);
		  
		  /*
		   * Password label, text
		   */
		  label2 = new Label(shell, SWT.NULL);
		  label2.setText("Password: ");		  
		  password = new Text(shell, SWT.SINGLE | SWT.BORDER);
		  System.out.println(password.getEchoChar());
		  password.setEchoChar('*');
		  password.setTextLimit(20);

		  /*
		   * submit username and password button
		   */
		  Button submitButton = new Button(shell,SWT.PUSH);
		  submitButton.setText("Submit");
		  
		  submitButton.addListener(SWT.Selection, new Listener() {
			  public void handleEvent(Event event) {
				  String userName = username.getText();
				  String passWord = password.getText();
			  
			  /*
			   * if username field is empty, show error
			   */				  
			  if(userName == "") { 
				  MessageBox messageBox = new MessageBox(shell, SWT.OK |
				  SWT.ICON_WARNING |SWT.CANCEL);
				  messageBox.setMessage("Enter the User Name");
				  messageBox.open();
			  }
			  
			  /*
			   * if password field is empty, show error
			   */
			  if(passWord == "") {
				  MessageBox messageBox = new MessageBox(shell, SWT.OK |
				   SWT.ICON_WARNING |SWT.CANCEL);
				  messageBox.setMessage("Enter the Password");
				  messageBox.open();
			  }
			  
			  /*
			   * if both fields are filled, log the user in
			   * and show welcome message
			   */
			  else{
				  MessageBox messageBox=new MessageBox(shell,SWT.OK|SWT.CANCEL);
				  messageBox.setText("Login Form");
				  messageBox.setMessage("Welcome: " + username.getText());
				  messageBox.open();
			  	}
		  	}
		  });
		  
		  username.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		  password.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		  
		  /*
		   * open the shell (main frame) set size
		   */
		  shell.pack();
		  shell.open();
		  shell.setSize(300, 150);
		  while (!shell.isDisposed()) {
			  if (!display.readAndDispatch()) {
				  display.sleep();
			  }				 
		  }
		  
		  display.dispose();
	  }
		  
	  public static void main(String[] args) {
		  new LoginForm();
	  }	
}
