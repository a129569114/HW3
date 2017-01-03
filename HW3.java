package project;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
//B0444251
//Tian shuo
//i have a puzzle at 17 0.0
public class HW3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("input N(deck of cards):");
		String testn= sc.nextLine(); 
		int nDeck=1;
		Deck deck=new Deck(nDeck);//This line is ok until i build the method"getonecard",i dont konw why,please tell me  ,thank you >.<
		
		//TODO: please check your output, make sure that you print all cards on your screen
		Card newCard=deck.getOneCard( );
		newCard.printCard();
		deck.shuffle();
		Card newCard2=deck.getOneCard();
		newCard2.printCard();
		if(isAllCardsCorrect(deck.getAllCards(),nDeck)){
			if(!isShuffleWorking(deck,newCard,newCard2)){
				System.out.println("All Card: Well done! But shufller is not working");
			}else{
				System.out.println("Well done!");
			}
			
		}else{
			System.out.println("All Card: Error, please check your sourse code");
		}

	}
	

	
	
	
	
	class Deck{
		private ArrayList<Card> cards ;
		//TODO: Please implement the constructor
		public Deck(int nDeck){
			cards =new ArrayList<Card>();
			for (int w =1 ;w <= nDeck;  w++)
			{    for (int suit=1;suit <=4;suit++)
			{  
			for (int rank =1;rank <=13;rank++ )

			{ Card  card =new Card(suit,rank);
		
			   cards.add(card);}

				
			}}}
	
	
	
	


		public Card getOneCard() {
			Random onecard =new Random();
			int anshan =onecard.nextInt(52);
			Card a =cards.get(anshan);
			cards.remove(anshan);
			
			// TODO Auto-generated method stub
			return a;
		}






		public void printDeck(){
			for(int i=0;i<cards.size();i++)
			{
				Card x =cards.get(i);
				x.printCard();
				
				
			}
			//Hint: print all items in ArrayList<Card> cards, 
			//please implement and reuse printCard method in Card class

		}
		public ArrayList<Card> getAllCards(){
			return cards;
		}




		public void shuffle() {
			Random  shenyang =new Random();
			for (int dalian =0;dalian<52;dalian ++)

			{
				int anshan =shenyang.nextInt(52);
				Card fuxin =cards.get(anshan);
				Card beijing =cards.get(dalian);
				cards.set(anshan,beijing );
				cards.set(dalian,fuxin);
				
			}
			// TODO Auto-generated method stub
			
		}
	}
	/*
	 * Description: TODO: please add description here
	 */
	class Card {
		private int suit; //Definition: 1~4, Clubs=1, Diamonds=2, Hearts=3, Spades=4
		private int rank; //1~13
		public Card(int s,int r){
			suit=s;
			rank=r;
		}	

		//TODO: 1. Please implement the printCard method
		public void printCard(){
			System.out.print(suit+","+rank);
			//Hint: print (System.out.println) card as suit,rank, for example: print 1,1 as Clubs Ace

		}
		public int getSuit(){
			return suit;
		}
		public int getRank(){
			return rank;
		}
	}
			
			
	
	

	
	
	
	
	
	
	
	
	
	
	/*
	 * This method is used for checking your result, not a part of your HW3
	 */
	private static boolean isShuffleWorking(Deck deck,Card newCard,Card newCard2){
		boolean isCorrect=true;
		if(newCard.getSuit().equals(newCard2.getSuit()) &&
				newCard.getRank()==newCard2.getRank()){
					isCorrect=false;
					return isCorrect;
		}
		for(int i=0;i<53;i++){
			deck.getOneCard();
		}
		if(deck.nUsed!=2){
			isCorrect=false;
		}
		return isCorrect;
	}
	
	private static boolean isAllCardsCorrect(ArrayList<Card> allCards,int nDeck){
		//check the output 
		boolean isCorrect=true;;
		HashMap <String,Integer> checkHash=new HashMap<String,Integer>();
		for(Card card:allCards){
			Card.Suit suit= card.getSuit();
			int rank = card.getRank();
			if(rank>13||rank<1){
				isCorrect=false;
				break;
			}
			if(checkHash.containsKey(suit+","+rank)){
				checkHash.put(suit+","+rank, 
						checkHash.get(suit+","+rank)+1);
			}else{
				checkHash.put(suit+","+rank, 1);
			}

		}
		if(checkHash.keySet().size()==52){
			for(int value:checkHash.values()){
				if(value!=nDeck){
					isCorrect=false;
					break;
				}
			}
		}else{
			isCorrect=false;
		}
		return isCorrect;
	}

}