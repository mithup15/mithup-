package cardgame;

import java.util.List;

public class Playerone implements PlayerStrategy{
	int playerId;
	List<Integer> opponentIds;
	List<Card> myCards;
	Card topPileCard;
	Card.Suit changedSuit;
	public void init(int playerId, List<Integer> opponentIds) {
		this.playerId=playerId;
		this.opponentIds=opponentIds;
	}
	public void receiveInitialCards(List<Card> cards) {
		this.myCards=cards;
	}
	public boolean shouldDrawCard(Card topPileCard, Card.Suit changedSuit) {
		this.topPileCard=topPileCard;
		this.changedSuit=changedSuit;
		if(changedSuit==null) {
			for(int i=0;i<myCards.size();i++) {
				if(myCards.get(i).getSuit().equals(topPileCard.getSuit())||myCards.get(i).getRank().equals(topPileCard.getRank())) {
					return false;
				}
			}
		}
		else {
			for(int i=0;i<myCards.size();i++) {
				if(myCards.get(i).getSuit().equals(changedSuit)) {
					return false;
				}
			}
		}
		return true;
		
	}
	
	//taking top card from deck
	
	public void receiveCard(Card drawnCard) {
		System.out.println("Player - 1 recieved :"+drawnCard.getRank()+" "+drawnCard.getSuit());
		myCards.add(drawnCard);
	}
	public Card playCard() {
		
		Card dropCard=null;
		if(changedSuit==null) {
			for(int i=0;i<myCards.size();i++) {
				if(myCards.get(i).getSuit().equals(topPileCard.getSuit())||myCards.get(i).getRank().equals(topPileCard.getRank())) {
					System.out.println("Player - 1 played : "+myCards.get(i).getRank()+" "+myCards.get(i).getSuit());
					dropCard=myCards.get(i);
					myCards.remove(i);
					break;
				}
			}
			
		}
		else {
			for(int i=0;i<myCards.size();i++) {
				if(myCards.get(i).getSuit() == changedSuit) {
					System.out.println("Player - 1 played : "+myCards.get(i).getRank()+" "+myCards.get(i).getSuit());
					dropCard=myCards.get(i);
					myCards.remove(i);
					break;
				}
			}
//			if(z==0)
//			{
//			while(k!=0)
//			{
//				myCards.add(cardDeck.get(cardDeck.size()-1));
//			}
//			}
		}
		return dropCard;
		
	}
	public Card.Suit declareSuit(){
		Card declaredSuit=myCards.get(0);
		int max=0,count=0;
		for(int i=0;i<myCards.size();i++) {
			count=0;
			for(int j=0;j<myCards.size();j++) {
				if(myCards.get(i)==myCards.get(j))
					count++;
			}
			if(count>max) {
				max=count;
				declaredSuit=myCards.get(i);
			}
		}
		System.out.println("\n Delcare suit : "+declaredSuit.getSuit());
		return declaredSuit.getSuit();
		
	}
	public void processOpponentActions(List<PlayerTurn> opponentActions) {
		
	}
	 public void reset() {
		 
	 }
	@Override
	public int getScore(int point) {
		for(int i=0;i<myCards.size();i++) {
			if(point<200)
				point+=myCards.get(i).getPointValue();
		}
		return point;
	}
}
