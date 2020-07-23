package twitterScraper;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import twitter4j.Status;
import twitter4j.TwitterException;

public class GUI {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JPanel panel2 = new JPanel();
	JButton btn = new JButton("Check Text for Phishing");
	JTextField text = new JTextField();
	String queryText;
	PhishingRules rules = new PhishingRules();
	
	public GUI() throws TwitterException {
		panel.setBorder(BorderFactory.createEmptyBorder(130,600,600,600));
		panel.setLayout(new GridLayout(0,1));
		panel.add(text);
		panel.add(btn);
		
		frame.add(panel, BorderLayout.NORTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Twitter Phishing Scraper");
		frame.pack();
		frame.setVisible(true);

		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				queryText = text.getText();
				Scraper s = new Scraper();
				try {
					List<Status> queryResults = s.getTweet(queryText);
					for (Status status: queryResults) {
			    		@SuppressWarnings("static-access")
						boolean uhoh = rules.checkForPhishing(status.getText());
			    		if(uhoh == true) {
			    			JLabel label = new JLabel("BAD!" +"@" + status.getUser().getScreenName() + ":" + status.getText());
			    			label.setForeground(Color.RED);
			    			System.out.println("BAD!"+"@" + status.getUser().getScreenName() + ":" + status.getText());
			    			panel.add(label);
			    			
			    		}
			    		else {
			    			JLabel label = new JLabel("@" + status.getUser().getScreenName() + ":" + status.getText());
			    			label.setForeground(Color.CYAN);
			    			panel.add(label);
			    		}
			    		
			    	}
				} catch (TwitterException e1) {
					e1.printStackTrace();
				}
			}
		
			
		});
		
	}
	
}
