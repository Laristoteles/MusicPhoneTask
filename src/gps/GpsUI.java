package gps;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;

import commons.dataClasses.GeoPoint;

public class GpsUI {
	private static GpsAdapter gps; 
	private GpsAdapterObserver gao;
	private GeoPoint oulu;

    public static void createAndShowGUI() {
    	
    	JPanel panel = new JPanel();
    	panel.setLayout(null);
    	 
    	JLabel latlabel = new JLabel("Latitude:");
    	panel.add(latlabel);
    	latlabel.setBounds(20, 10, 100, 20);
    	
    	
    	//Hardcoded GPS position as in the example "ottawa"
    	JTextField Lattextfield = new JTextField();
       	Lattextfield.setText(gps.getCurrentPosition().getLatitude());
       	Lattextfield.setEnabled(false);
    	panel.add(Lattextfield);
    	Lattextfield.setBounds(105, 15, 100, 20);
    	
    	JLabel longlabel = new JLabel("Longitude:");
    	panel.add(longlabel);
    	longlabel.setBounds(20, 35, 100, 40);
    	
    	JTextField Lontextfield = new JTextField();
    	Lontextfield.setText(gps.getCurrentPosition().getLongitude());
    	Lontextfield.setEnabled(false);
    	panel.add(Lontextfield);
    	//Lontextfield.getDocument().addDocumentListener(new myTextActionListener());
    	
    	Lontextfield.setBounds(105, 50, 100, 20);
    	
    	JLabel dislabel = new JLabel("Distance Units:");
    	panel.add(dislabel);
    	dislabel.setBounds(20, 70, 100, 40);
    	
    	ButtonGroup btngroup = new ButtonGroup();
    	
    	JRadioButton kmbtn = new JRadioButton(gps.getDistanceUnits());
    	kmbtn.setBounds(105, 80, 100, 20);
    	btngroup.add(kmbtn);
    	
    	
    	JRadioButton mibtn = new JRadioButton("mi");
    	mibtn.setBounds(160, 80, 120, 20);
    	mibtn.setEnabled(false);
    	btngroup.add(mibtn);
        panel.add(mibtn);
        panel.add(kmbtn);
        
      
       
      /*  ActionListener actionlistener = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
              AbstractButton aButton = (AbstractButton) actionEvent.getSource();
              System.out.println("Selected: " + aButton.getText());
            }
          };
          
          
       mibtn.addActionListener(actionlistener);
       kmbtn.addActionListener(actionlistener);

*/
    
        JFrame frame = new JFrame("MusicFone Gps");
        frame.add(panel);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds(180, 430, 100, 20);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(260,150 );
        frame.setVisible(true);
    }
    
    
    
	public GpsUI() {
		gps =  new GpsAdapter();
		gao = new GpsAdapterObserver();
		oulu  = new GeoPoint("65", "45");
		gps.addObserver(gao);
		gps.setCurrentPosition(oulu);
		gps.setDistanceUnits("km");
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
		

	}


}