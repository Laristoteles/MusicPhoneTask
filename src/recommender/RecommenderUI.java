package recommender;

import java.awt.*;


import java.awt.event.*;
import javax.swing.*;

public class RecommenderUI  {
	
	public static void createAndShowGUI() {
		
		
		//JPanel is the main container which holds all the widgets 
		 JPanel panel = new JPanel();
		 panel.setLayout(null);
		    
		 // when get recommendation button clicked, it display artists name  
		 JButton getBtn = new JButton("Get Recommendations");
		 getBtn.setBounds(20, 10, 200, 300);
		 getBtn.setSize(170, 30);
		 panel.add(getBtn);
		
			
		 JButton cancelBtn = new JButton("Cancel");
		 cancelBtn.setBounds(200, 10, 200, 300);
		 cancelBtn.setSize(80, 30);
		 panel.add(cancelBtn);
		
		 
		 JProgressBar progressbar = new JProgressBar();
		 progressbar.setBounds(290, 10, 200, 300);
		 progressbar.setSize(120, 30);
		 panel.add(progressbar);
		 
		 //The list shows artists 
		    
		 //String [] playlist = {};
		 JList artistlist = new JList();
		 artistlist.setSelectedIndex(1);
	     panel.add(artistlist);
	    	
	    	
	     JScrollPane artistscrollpane = new JScrollPane(artistlist);
	     panel.add(artistscrollpane );
	     artistscrollpane.setBounds(20, 50, 200, 200);  
	     artistscrollpane.setSize(450, 250);
	    
	    
	   
		 
		 // The add button adds selected artists to the selected artists list box, 
		 
		 JButton addBtn = new JButton("Add");
		 addBtn.setBounds(470, 100, 200, 300);
		 addBtn.setSize(80, 25);
		 panel.add(addBtn);
		 //Remove button removes selected artists from the selected artists list box 
		 JButton RemoveBtn = new JButton("Remove");
		 RemoveBtn.setBounds(470, 130, 200, 300);
		 RemoveBtn.setSize(80, 25);
		 panel.add(RemoveBtn);
		 
		//clear button removes all selected artists from the selected artists list box 
		 JButton ClearBtn = new JButton("Clear");
		 ClearBtn.setBounds(470, 160, 200, 300);
		 ClearBtn.setSize(80, 25);
		 panel.add(ClearBtn);
		 
		 
		 JLabel slected = new JLabel ("Selected Artists");
		 slected.setBounds(580, 40, 200, 20);
		 panel.add(slected);
		
		 // The list shows selected artists by the user 
		
		 JList selectedlist = new JList();
		 selectedlist.setSelectedIndex(1);
	     panel.add(selectedlist);
	    	
	    	
	     JScrollPane selectedscrollpane = new JScrollPane(selectedlist);
	     panel.add(selectedscrollpane );
	     selectedscrollpane.setBounds(550, 60, 200, 200);  
	     selectedscrollpane.setSize(170, 240);
	     
	    
	     JLabel concert = new JLabel ("Artist's Concert");
	     concert.setBounds(150, 305, 300, 10);
		 panel.add(concert);
		 
		 // The list shows the available concerts 
		 JList concertslist = new JList();
		 selectedlist.setSelectedIndex(1);
	     panel.add(concertslist);
	    	
	    	
	     JScrollPane concertscrollpane = new JScrollPane(selectedlist);
	     panel.add(concertscrollpane);
	     concertscrollpane.setBounds(20, 320, 300, 20);  
	     concertscrollpane.setSize(360, 150);
	     
	     
	     JLabel itinerary = new JLabel ("Trip Itinerary");
	     itinerary.setBounds(500, 305, 300, 10);
		 panel.add(itinerary);
		 
		// The list shows trip itinerary lists 
		 JList itinerarylist = new JList();
		 itinerarylist.setSelectedIndex(1);
	     panel.add(itinerarylist);
	    	
	    	
	     JScrollPane itineraryscrollpane = new JScrollPane(selectedlist);
	     panel.add(itineraryscrollpane);
	     itineraryscrollpane.setBounds(360, 320, 300, 20);  
	     itineraryscrollpane.setSize(360, 150);
	     
		 JFrame frame = new JFrame("MusicFone Recommender");
		 Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		 frame.setBounds(440, 130, 100, 20);
		 frame.setSize(750, 522);
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame.add(panel);
		 frame.setVisible(true);
		// frame.setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
	   
	    
	    SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }

			
        });
}

}