import java.util.ArrayList;
import java.util.Random;

class Deck{
		private ArrayList<Card> cards ;
		private int nUsed=0;
		//TODO: Please implement the constructor
		public Deck (int nDeck){
			cards =new ArrayList<Card>();
			for (int w =1 ;w <= nDeck;  w++)
			{    
				for (Suit s : Suit.values()){ 
					for (int rank =1;rank <=13;rank++ )
					{ Card  card =new Card(s,rank);

					cards.add(card);
					}
				}
			}
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
		
		
		
		public Card getOneCard() {
			Random onecard =new Random();
			int anshan =onecard.nextInt(52);
			Card a =cards.get(anshan);
			cards.remove(anshan);

			// TODO Auto-generated method stub
			return a;
		}


}
