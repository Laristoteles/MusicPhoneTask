package recommender;

import gps.GpsUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import commons.SQATException;
import commons.dataClasses.ConcertInfo;
import commons.dataClasses.Destination;
import commons.dataClasses.Recommendation;
import dataConnectors.LastFmConnectionException;
import dataConnectors.LastFmXmlConnector;
import player.PlayerUI;

public class RecommenderUI implements ActionListener {
	private ArrayList<Recommendation> myRecommendations;
	private ArrayList<Destination> myEvents;
	private ArrayList<Destination> myItinerary;

	private JPanel panel;
	RecommenderAdapter ra;
	PlayerUI playerWindow;
	GpsUI gpsWindow;
	public RecommenderUI(){
		this.ra = new RecommenderAdapter(new LastFmXmlConnector());

	}

	private static boolean canceled;
	JList artistlist;
	JList concertslist;
	String artist;
	DefaultListModel<String> artistListModel;
	DefaultListModel<String> concertListModel;
	public Container createContentPane(){
		final JProgressBar progressbar = new JProgressBar();
		artistlist = new JList();
		final JButton clearBtn = new JButton("Clear");
		final JButton cancelBtn = new JButton("Cancel");

		//JPanel is the main container which holds all the widgets 
		panel = new JPanel();
		panel.setLayout(null);

		// when get recommendation button clicked, it display artists name  
		final JButton getBtn = new JButton("Get Recommendations");
		getBtn.setBounds(20, 10, 200, 300);
		getBtn.setSize(170, 30);
		getBtn.addActionListener(this);
		panel.add(getBtn);



		cancelBtn.setBounds(200, 10, 200, 300);
		cancelBtn.setSize(80, 30);
		cancelBtn.addActionListener(this);
		panel.add(cancelBtn);

		// The list shows the available concerts 
		concertslist = new JList();
		concertslist.setSelectedIndex(1);
		panel.add(concertslist);


		progressbar.setBounds(290, 10, 200, 300);
		progressbar.setSize(120, 30);
		panel.add(progressbar);

		//The list shows artists 
		artistlist.setSelectedIndex(1);
		panel.add(artistlist);
		artistlist.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent lse) {
				if(!lse.getValueIsAdjusting()){
					getArtistName();
					List<Destination> destinations = ra.getRecommender().getDestinationsForArtists(artist);
					concertListModel = new DefaultListModel<String>();
					for (Destination destination : destinations) {
						concertListModel.addElement(destination.getVenue() + ", " + destination.getCity() +
								" @ " + destination.getStartDate().toString());
					}
					concertslist.setModel(concertListModel);
					
				}


			}
		});

		JScrollPane artistscrollpane = new JScrollPane(artistlist);
		panel.add(artistscrollpane );
		artistscrollpane.setBounds(20, 50, 200, 200);  
		artistscrollpane.setSize(450, 250);




		// The add button adds selected artists to the selected artists list box, 
		JButton addBtn = new JButton("Add");
		addBtn.setBounds(470, 100, 200, 300);
		addBtn.setSize(80, 25);
		addBtn.addActionListener(this);
		panel.add(addBtn);

		//Remove button removes selected artists from the selected artists list box 
		JButton RemoveBtn = new JButton("Remove");
		RemoveBtn.setBounds(470, 130, 200, 300);
		RemoveBtn.setSize(80, 25);
		RemoveBtn.addActionListener(this);
		panel.add(RemoveBtn);

		//clear button removes all selected artists from the selected artists list box 
		clearBtn.setBounds(470, 160, 200, 300);
		clearBtn.setSize(80, 25);
		clearBtn.addActionListener(this);
		panel.add(clearBtn);


		JLabel selected = new JLabel ("Selected Artists");
		selected.setBounds(580, 40, 200, 20);
		panel.add(selected);

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



		JScrollPane concertscrollpane = new JScrollPane(concertslist);
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


		return panel;
	}


	public static void createAndShowGUI() {

		JFrame frame = new JFrame("MusicFone Recommender");
		frame.setBounds(440, 130, 100, 20);
		frame.setSize(750, 522);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new RecommenderUI().createContentPane());
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand()=="Get Recommendations") {
			artistListModel = new DefaultListModel<String>();
			try {
				List<Recommendation> recs = ra.getRecommender().getRecommendations();
				for (Recommendation rec: recs) {
					artistListModel.addElement(rec.getArtist() + "-" + rec.getFanCount());
				}

				artistlist.setModel(artistListModel);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}


	public static boolean isCanceled() {
		return canceled;
	}


	public static void setCanceled(boolean canceled) {
		RecommenderUI.canceled = canceled;
	}


	public ArrayList<Destination> getMyEvents() {
		return myEvents;
	}


	public void setMyEvents(ArrayList<Destination> myEvents) {
		this.myEvents = myEvents;
	}


	public ArrayList<Recommendation> getMyRecommendations() {
		return myRecommendations;
	}


	public void setMyRecommendations(ArrayList<Recommendation> myRecommendations) {
		this.myRecommendations = myRecommendations;
	}


	public ArrayList<Destination> getMyItinerary() {
		return myItinerary;
	}


	public void setMyItinerary(ArrayList<Destination> myItinerary) {
		this.myItinerary = myItinerary;
	}


	private void getArtistName() {
		try {
			artist = (String)artistlist.getModel().getElementAt(artistlist.getSelectedIndex());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Array out of bound");
		}
	
		artist = artist.substring(0, artist.lastIndexOf("-"));
	}

}