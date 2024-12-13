package hust.soict.dsai.aims.screen;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import hust.soict.dsai.aims.Aims.Aims;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

public class MediaStore extends JPanel {
	private Media media;
	
	public MediaStore(Media media) {
		this.media = media;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		ButtonListener btnListener = new ButtonListener();
		
		JLabel title = new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel cost = new JLabel("" + media.getCost() + " $");
		cost.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JButton addCart = new JButton("Add to cart");
		container.add(addCart);
		addCart.addActionListener(btnListener);
		if (media instanceof Playable) {
			JButton play = new JButton("Play");
			container.add(play);
			play.addActionListener(btnListener);
		}
		
		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String button = e.getActionCommand();
			if (button.equals("Add to cart")) {
				Aims.addtoCart(media);
			} else if (button.equals("Play")) {
				Aims.playMedia(media);
			}
		}
	}
}
