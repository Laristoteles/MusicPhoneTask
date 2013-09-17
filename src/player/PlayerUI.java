package player;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


import javax.swing.JFrame;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;



public class PlayerUI implements  ActionListener {
		
	private static final ListSelectionListener ListSelectionListener = null;
	private JList playlist;
    private JButton nextbtn;
    static JTextField distext;
    private static JList list;
  //  private ListenerClass listener;
    
	public Container createContentPane (){
	

		
		JPanel mainpanel = new JPanel();
    	mainpanel.setLayout(null);
    	mainpanel.setBounds(5, 5, 5, 5);
    	 
    	JLabel playlabel = new JLabel("Currently playing:");
    	mainpanel.add(playlabel);
    	playlabel.setBounds(20, 10, 100, 20);
    	
    	// display the selected item
    	
    	
    	JLabel listlabel = new JLabel("playlist");
    	mainpanel.add(listlabel);
    	listlabel.setBounds(20, 30, 100, 20);
    	
    	
    	JTextField distext = new JTextField("");
        mainpanel.add(distext);
        distext.setBounds(130, 10, 100, 20);
    	
    	String [] playlist = {"Metallica-one","Cher- Believe","U2-Elevation"};
    	JList list = new JList(playlist);
    	list.setSelectedIndex(0);
    	//list.addListSelectionListener(new ListSelectionListener);
    	mainpanel.add(list);
    
     //   ListenerClass listener = new ListenerClass();
        
        //list.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
    	JScrollPane listjscroll = new JScrollPane(list);
    	mainpanel.add(listjscroll);
    	listjscroll.setBounds(20, 60, 200, 200);

    	nextbtn = new JButton("Next");
     	nextbtn.addActionListener(this);
     	mainpanel.add(nextbtn);
     
     	nextbtn.setBounds(120, 80, 200, 300);
     	nextbtn.setLocation(220, 60);
        nextbtn.setSize(60, 30);
        nextbtn.addActionListener(this);
        
       
     	
		return mainpanel;
       
   
     	
	}
       /* static class Action implements ActionListener{
            public void actionPerformed(ActionEvent e) {
            	distext.setText("Button 2!");
           
            }
        
          };*/
		
	
        public static void createAndShowGUI(){
    	
		JFrame frame = new JFrame("MusicFone player");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		PlayerUI player = new PlayerUI(); 
		frame.setContentPane(player.createContentPane());
		//frame.add.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds(140, 130, 100, 20);
		frame.setSize(300,300 );   
	    frame.setVisible(true);
	    
	   
	
	}
        
        
        public void valueChanged(ListSelectionEvent lse)
        {
           int[] n = playlist.getSelectedIndices();
         //  System.out.println(n.length + " item(s) selected"); 
        } 
        
        @Override
    	public void actionPerformed(ActionEvent e) {
        	JButton source = (JButton)e.getSource();

            if (source == nextbtn)
            {
               int[] n = list.getSelectedIndices();
               String s = "";
             /* for (int i = 0; i < n.length; ++i)
                  s += playlist [n[i]] + "\n";      */
              distext.setText(s);
           
            }
            else {
               System.exit(0);
            }
    		
    	}
	
	
	


	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
	}
	
	/* private class ListenerClass implements ListSelectionListener {
		
	        public void valueChanged(ListSelectionEvent e) {
	        	distext.setText(list.getSelectedValue().toString());
	        }
	    }*/

	

}
