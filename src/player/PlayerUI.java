package player;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


import javax.swing.JFrame;
import javax.swing.event.ListSelectionEvent;
import commons.SQATException;



public class PlayerUI implements  ActionListener {

	private JList<Track> playlist;
	private JButton nextbtn;
	static JTextField distext;
	private JPanel mainpanel;
	
	//  private ListenerClass listener;
	public Container createContentPane (){
		mainpanel = new JPanel();
		mainpanel.setLayout(null);
		mainpanel.setBounds(5, 5, 5, 5);

		JLabel playlabel = new JLabel("Now playing:");
		mainpanel.add(playlabel);
		playlabel.setBounds(20, 10, 100, 20);

		// display the selected item

		JLabel listlabel = new JLabel("Playlist");
		mainpanel.add(listlabel);
		listlabel.setBounds(20, 30, 100, 20);


		JTextField distext = new JTextField("");
		distext.setEnabled(false);
		mainpanel.add(distext);
		distext.setBounds(130, 10, 100, 20);

		String [] playlist = {"Metallica-one","Cher- Believe","U2-Elevation"};
		JList<String> list = new JList<String>(playlist);
		list.setSelectedIndex(0);
		mainpanel.add(list);

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

	public static void createAndShowGUI(){
		JFrame frame = new JFrame("MusicFone Player");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		PlayerUI player = new PlayerUI(); 
		frame.setContentPane(player.createContentPane());
		frame.setBounds(140, 130, 100, 20);
		frame.setSize(300,300 );   
		frame.setVisible(true);



	}


	public void valueChanged(ListSelectionEvent lse)
	{
		try {
			throw new SQATException("You should implement this");
		} catch (SQATException e) {
			JOptionPane.showInternalMessageDialog (mainpanel,e.getMessage());
		}

	} 

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			throw new SQATException("You should implement this");
		} catch (SQATException e1) {
			JOptionPane.showInternalMessageDialog (mainpanel,e1.getMessage());
		}

	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

	public JList<Track> getPlaylist() {
		return playlist;
	}

	public void setPlaylist(JList<Track> playlist) {
		this.playlist = playlist;
	}

}
