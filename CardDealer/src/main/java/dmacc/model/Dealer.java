package dmacc.model;

import java.util.ArrayList;
import java.util.Random;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dmacc.config.HandBeanConfig;
import dmacc.model.Hand;

public class Dealer {
	String[] suit = new String[]{"D", "H", "S", "C"};
	String[] value = new String[] {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
	String[] deck = new String[52];
	
	Random rand = new Random();
	
	public Dealer() {
		int count = 0;
		for (String s : suit) {
			for(String v : value) {
				deck[count] = v + s;
				count++;
			}
		}
	}
	
	public Hand deal() {
		ApplicationContext context = new AnnotationConfigApplicationContext(HandBeanConfig.class);
		ArrayList<String> noDupes = new ArrayList<String>();
		Hand hand = context.getBean("hand", Hand.class);
		hand.setHand("");
		for (int i = 0; i < 5; i++) {
			String card = getACard();
			while (noDupes.contains(card)) {
				System.out.println("Found a dupe");
				card = getACard();
			}
			noDupes.add(card);
			hand.setHand(hand.getHand() + card);
		}
		return hand;
	}
	
	public String getACard() {
		return deck[Math.abs(rand.nextInt()) % 52] + " ";
	}

}
