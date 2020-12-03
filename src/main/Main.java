package main;
// imported libraries
import java.awt.EventQueue;
import gui.MainMenu;
import backend.Database;


public class Main {
	
	public static void main(String[] args) throws Exception {
		Database db = new Database();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu(db);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
