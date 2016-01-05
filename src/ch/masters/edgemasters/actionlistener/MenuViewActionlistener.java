package ch.masters.edgemasters.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuViewActionlistener implements ActionListener {

	private String buttonname;
	private String name;
	
	public MenuViewActionlistener(String buttonname, String name){
		this.buttonname = buttonname;
		this.name = name; 
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.buttonname.equals("add Player")){
			
		}
		
	}

}
