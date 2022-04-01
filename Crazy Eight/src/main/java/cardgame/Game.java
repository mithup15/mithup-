package cardgame;

import java.util.*;
import cardgame.Card.*;

public class Game {
	public static void main(String[] args) {		
		int i,p1=0, p2=0;
		Card firstCard;
		List<Card> cardDeck=new ArrayList<>();		
		cardDeck=Card.getDeck();		
		Collections.shuffle(cardDeck);
		
		//creating objects
		
		Playerone obj1=new Playerone();
		Playertwo obj2=new Playertwo();
		
		
		//creating array lists
		
		List<Card> player1 =new ArrayList<>();
		List<Card> player2=new ArrayList<>(); 
		
		//card allocating to players
		
		for(i=1;i<=7;i++) 
		{
					
					player1.add(cardDeck.get(cardDeck.size()-1));
					cardDeck.remove(cardDeck.size()-1);	

		                      player2.add(cardDeck.get(cardDeck.size()-1));
		                      cardDeck.remove(cardDeck.size()-1);		
		}
				
     //if first top card is eight the deck should be shuffled
		firstCard=cardDeck.get(cardDeck.size()-1);
		if(firstCard.getRank()==Card.Rank.EIGHT)
		{
			while(firstCard.getRank()==Card.Rank.EIGHT)
			{
				Collections.shuffle(cardDeck);
				firstCard=cardDeck.get(cardDeck.size()-1);
			}
		}
		
		
	
	cardDeck.remove(cardDeck.size()-1);			
		
		
		
		System.out.println("\n Player - 1 \n");	
		for(i=0;i<player1.size();i++) {
			System.out.print(player1.get(i).getRank()+" "+player1.get(i).getSuit()+" ");
		}
		System.out.println("\n Player - 2 \n");
	
		for(i=0;i<player2.size();i++) {
			System.out.print(player2.get(i).getRank()+" "+player2.get(i).getSuit()+" ");
		}
		System.out.println();
		System.out.println("TopCard : "+firstCard.getRank()+" "+firstCard.getSuit());
		
		//taking card from deck
		
		obj1.receiveInitialCards(player1);
		obj2.receiveInitialCards(player2);
		Card.Suit decCard=null;
		
		
		
		while(p1<200 && p2<200 && cardDeck.size() != 0) 
		{
			 
			
			for(i=0; i<3; i++) 
			{
				if(obj1.shouldDrawCard(firstCard, decCard))
				{
					if(cardDeck.size()!=0) 
					{	
						obj1.receiveCard(cardDeck.get(0));		
						cardDeck.remove(0);			
					}
				}
				else{
					firstCard=obj1.playCard();
					if(firstCard.getRank()==Rank.EIGHT&&obj1.myCards.size()!=0) 
					{
						decCard=obj1.declareSuit();
					}
					break;
				}
			}
			
			
			
			
			for(i=0; i<4; i++) 
			{
				if(obj2.shouldDrawCard(firstCard, decCard))
				{
					if(cardDeck.size()!=0 && (i<3)) 
					{
						obj2.receiveCard(cardDeck.get(0));		
						cardDeck.remove(0);			
					}
				}
				else 
				{
					firstCard=obj2.playCard();
					if(firstCard.getRank()==Rank.EIGHT&&obj2.myCards.size()!=0)
					{
						decCard=obj2.declareSuit();
					}
					break;
				}
			}
			
		
			
			
			
			if(obj1.myCards.size()==0 ||cardDeck.size()==0) {
				p2=obj2.getScore(p2);
				System.out.println("\n player - 1 :"+p2);
			}
			if(obj2.myCards.size()==0 ||cardDeck.size()==0) {
				p1=obj1.getScore(p1);
				System.out.println("\n player - 2 :"+p1);
			}
			if(cardDeck.size()==0) {
				cardDeck=Card.getDeck();
				Collections.shuffle(cardDeck);
				//break;
			}
			}
			
			
				
			
		
		//printing results
		
		if(p1>=200) {
			System.out.println("\n player - 2 Wins");
		}
		else if(p2>=200){
			System.out.println("\n player 1 -  Wins");
		}
			System.out.println("\n Finished");
		
	}

}
