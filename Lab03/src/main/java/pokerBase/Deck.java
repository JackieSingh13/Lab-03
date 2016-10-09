package pokerBase;

import java.util.ArrayList;
import java.util.Collections;

import pokerEnums.eRank;
import pokerEnums.eSuit;
import pokerExceptions.DeckException;

public class Deck {

	private ArrayList<Card> deckCards = new ArrayList<Card>();

	public Deck() {
		int iCardNbr = 1;
		for (eSuit eSuit : eSuit.values()) {
			for (eRank eRank : eRank.values()) {
				//TODO Lab3 - Fix this
				if ((eSuit != eSuit.Joker) && (eRank != eRank.Joker))
					deckCards.add(new Card(eSuit, eRank, iCardNbr++));
			}
		}
		Collections.shuffle(deckCards);
	}
	
	public Deck(int iNbrOfJokers) {
		this();
		for(int i = 0; i<iNbrOfJokers; i++){
			deckCards.add(new Card(eSuit.Joker, eRank.Joker, 53));
		}
		Collections.shuffle(deckCards);
	}
	
	
	public Deck(int NbrOfJokers, ArrayList<Card> Wilds) {
		
		this(NbrOfJokers);
		//for(Card c : deckCards) {
			//for(Card wc : Wilds) {
				//if ((c.geteRank() == wc.geteRank()) && (c.geteSuit() == wc.geteSuit()))
					//	c.setbWild(true);
			}
		//}
		
	//}
	public Card Draw() throws DeckException {
		if (deckCards.size()==0) {
			throw new DeckException(this);
		}
		return deckCards.remove(0);
	}
	private int GetDeckSize() {
		return deckCards.size();
	}
}
