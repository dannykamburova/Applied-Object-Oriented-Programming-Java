// Fig. 7.10: DeckOfCards.java
package problem1;
// DeckOfCards class represents a deck of playing cards.
import java.util.Random;

public class DeckOfCards
{
   private Card deck[]; // array of Card objects
   private int currentCard; // index of next Card to be dealt
   private final int NUMBER_OF_CARDS = 52; // constant number of Cards
   private Random randomNumbers; // random number generator
   private final String faces[] = { "Ace", "Deuce", "Three", "Four", "Five", "Six",
           "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };
   private final String suits[] = { "Hearts", "Diamonds", "Clubs", "Spades" };
   // constructor fills deck of Cards
   public DeckOfCards()
   {

      deck = new Card[ NUMBER_OF_CARDS ]; // create array of Card objects
      currentCard = 0; // set currentCard so first Card dealt is deck[ 0 ]
      randomNumbers = new Random(); // create random number generator

      // populate deck with Card objects
      for ( int count = 0; count < deck.length; count++ ) 
         deck[ count ] = 
            new Card( faces[ count % 13 ], suits[ count / 13 ] );
   } // end DeckOfCards constructor
   public void shuffle()
   {
      // after shuffling, dealing should start at deck[ 0 ] again
      currentCard = 0; // reinitialize currentCard

      // for each Card, pick another random Card and swap them
      for ( int first = 0; first < deck.length; first++ ) 
      {
         // select a random number between 0 and 51 
         int second =  randomNumbers.nextInt( NUMBER_OF_CARDS );
         
         // swap current Card with randomly selected Card
         Card temp = deck[ first ];        
         deck[ first ] = deck[ second ];   
         deck[ second ] = temp;            
      } // end for
   } // end method shuffle

   // deal one Card
   public Card dealCard()
   {
      // determine whether Cards remain to be dealt
      if ( currentCard < deck.length )
         return deck[ currentCard++ ]; // return current Card in array
      else        
         return null; // return null to indicate that all Cards were dealt
   } // end method dealCard
   public Card[] dealHand(){
      Card[] hand = new Card[5];
      for(int i = 0; i < hand.length; i++) {
         hand[i] = dealCard();
      }
      return hand;
   }

   private int[] getCountOfFaces(Card[] hand){
      int[] countOfFaces = new int[faces.length];

      for (int i = 0; i < hand.length; i++) {
         for (int j = 0; j < faces.length; j++) {
            if(hand[i].getFace().equals(faces[j])) {
               countOfFaces[j]++;
            }
         }
      }
      return countOfFaces;
   }
   private int getPairs(Card[] hand) {
      int[] countOfFaces = getCountOfFaces(hand);
      int countPairs = 0;

      for(int i = 0; i < countOfFaces.length; i++) {
         if(countOfFaces[i] == 2) {
            countPairs++;
         }
      }
      return countPairs;
   }

   private boolean hasThree(Card[] hand) {
      int[] countOfFaces = getCountOfFaces(hand);

      for(int i = 0; i < countOfFaces.length; i++) {
         if(countOfFaces[i] == 3) {
            return true;
         }
      }
      return false;
   }

   public boolean hasPair(Card[] hand) {
//      int countPairs = getPairs(hand);
//
//      boolean hasThree = hasThree(hand);
//
//      if(countPairs == 1 && hasThree == false) {
//         return true;
//      }else{
//         return false;
//      }
      return getPairs(hand) == 1 && !hasThree(hand);
   }

   public boolean hasTwoPairs(Card[] hand){
      return getPairs(hand) == 2;
   }

   public boolean hasThreeOfAKind(Card[] hand) {
      return getPairs(hand) == 0 && hasThree(hand);
   }

   public boolean hasFullHouse(Card[] hand) {
      return getPairs(hand) == 1 && hasThree(hand);
   }

   public boolean hasFourOfAKind(Card[] hand) {
      int[] countOfFaces = getCountOfFaces(hand);

      for(int i = 0; i < countOfFaces.length; i++) {
         if(countOfFaces[i] == 4) {
            return true;
         }
      }
      return false;
   }

   public boolean hasStraight(Card[] hand){
      int[] countOfFaces = getCountOfFaces(hand);

      int consecutive = 0;
      for (int i = 0; i < countOfFaces.length; i++) {
         if(countOfFaces[i] == 1){
            consecutive++;
         }else {
            consecutive = 0;
         }
         if(consecutive == 5){
            return true;
         }
      }
      return consecutive == 4 && countOfFaces[0] == 1;
      //A, K, Q, J, 10
   }

   public boolean hasFlush(Card[] hand) {
      String color = hand[0].getSuit();

      for(int i = 1; i < hand.length; i++) {
         if(!hand[i].getSuit().equals(color)) {
            return false;
         }
      }
      return true;
   }

   public int hasStrength(Card[] hand) {
      if(hasFourOfAKind(hand)) return 7;
      if(hasFullHouse(hand)) return 6;
      if(hasFlush(hand)) return 5;
      if(hasStraight(hand)) return 4;
      if(hasThreeOfAKind(hand)) return 3;
      if(hasTwoPairs(hand)) return 2;
      if(hasPair(hand)) return 1;
      return 0;
   }
} // end class DeckOfCards


