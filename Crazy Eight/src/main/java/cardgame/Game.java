package cardgame;

import java.util.*;
import cardgame.Card.*;

public class Game {
	public static void main(String[] args) {		
		int i,point1=0, point2=0, point3=0, point4=0;
		Card mainCard;
		List<Card> deckCards=new ArrayList<>();		
		deckCards=Card.getDeck();		
		Collections.shuffle(deckCards);
		
		//creating objects
		
		Playerone user1=new Playerone();
		Playertwo user2=new Playertwo();
		
		
		//creating array lists
		
		List<Card> player1 =new ArrayList<>();
		List<Card> player2=new ArrayList<>(); 
		
		//card allocating to players
		
		for(i=1;i<=7;i++) 
		{
					
					player1.add(deckCards.get(deckCards.size()-1));
					deckCards.remove(deckCards.size()-1);	

		                      player2.add(deckCards.get(deckCards.size()-1));
					deckCards.remove(deckCards.size()-1);		
		}
				
     //if first top card is eight the deck should be shuffled
		
	for(;;)
	{
		mainCard=deckCards.get(deckCards.size()-1);
		if(mainCard.getRank()==Rank.EIGHT)
		{
			System.out.println("eight identified");
			Collections.shuffle(deckCards);
			continue;
		}
		break;
	}
		
		
	
		deckCards.remove(deckCards.size()-1);			
		
		
		
		System.out.println("\n Player - 1 \n");	
		for(i=0;i<player1.size();i++) {
			System.out.println(player1.get(i).getRank()+" "+player1.get(i).getSuit()+" ");
		}
		System.out.println("\n Player - 2 \n");
	
		for(i=0;i<player2.size();i++) {
			System.out.println(player2.get(i).getRank()+" "+player2.get(i).getSuit()+" ");
		}
		System.out.println();
		System.out.println("TopCard : "+mainCard.getRank()+" "+mainCard.getSuit());
		
		//taking card from deck
		
		user1.receiveInitialCards(player1);
		user2.receiveInitialCards(player2);
		Card.Suit decCard=null;
		
		
		
		while(point1<200 && point2<200 && point3<200 && point4<200 && !deckCards.isEmpty()) 
		{
			 
			
			for(i=0; i<3; i++) 
			{
				if(user1.shouldDrawCard(mainCard, decCard))
				{
					if(deckCards.size()!=0) 
					{	
						user1.receiveCard(deckCards.get(0));		
						deckCards.remove(0);			
					}
				}
				else{
					mainCard=user1.playCard();
					if(mainCard.getRank()==Rank.EIGHT&&user1.myCards.size()!=0) 
					{
						decCard=user1.declareSuit();
					}
					break;
				}
			}
			
			
			
			
			for(i=0; i<3; i++) 
			{
				if(user2.shouldDrawCard(mainCard, decCard))
				{
					if(deckCards.size()!=0) 
					{
						user2.receiveCard(deckCards.get(0));		
						deckCards.remove(0);			
					}
				}
				else
				{
					mainCard=user2.playCard();
					if(mainCard.getRank()==Rank.EIGHT&&user2.myCards.size()!=0)
					{
						decCard=user2.declareSuit();
					}
					break;
				}
			}
			
		
			
			
			
			if(user1.myCards.size()==0 ||deckCards.size()==0) {
				point2+=user2.getScore();
				System.out.println("\n player - 1 :"+point2);
			}
			if(user2.myCards.size()==0 ||deckCards.size()==0) {
				point1+=user1.getScore();
				System.out.println("\n player - 2 :"+point1);
			}
			
			}
			
			if(deckCards.size()==0) {
				deckCards=Card.getDeck();
				Collections.shuffle(deckCards);
				//break;
			}
				
			
		
		//printing results
		
		if(point1>=200) {
			System.out.println("\n player - 2 Wins");
		}
		else if(point2>=200) {
			System.out.println("\n player 1 -  Wins");
		}
		else {
			System.out.println("\n Finished");
		}
		
	}

}

