
import javax.swing.JFrame;
import javax.swing.JTextField;



import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

public class MyJDia {
	private JTextField txtInput;	// input dialog
	private String message=null;
	private JButton confirm;
	private JDialog dialog = null;
	private String inText;
	public String getMessage(JFrame father, String message){
		this.message=message;
		
		txtInput = new JTextField();
		txtInput.setText("Input");
		txtInput.setBounds(120, 120, 86, 20);
		
		confirm = new JButton("confirm");
		confirm.setBounds(230,120,86,20);
		confirm.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			
				inText=txtInput.getText();
				
				MyJDia.this.dialog.dispose(); 
			}
			
		});
		
		dialog = new JDialog(father, true); 
		dialog.setTitle("input your data");
		dialog.setLayout(null);
		dialog.getContentPane().add(confirm);		
		dialog.add(txtInput);
		dialog.pack();
		dialog.setSize(new Dimension(350,200));
		dialog.setLocationRelativeTo(father);
		dialog.setVisible(true);
		
		return inText;
		
	}
}
