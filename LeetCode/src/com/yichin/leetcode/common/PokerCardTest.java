package com.yichin.leetcode.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class PokerCardTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Deck deck = new Deck();
		deck.print();
		System.out.println("=========");
		deck.shuffle();
		deck.print();
	}
	
}

class Deck{
	List<PokerCard> deck;
	
	public Deck(){
		deck = new ArrayList<>();
		for(Suite suite : Suite.values()){
			for(Card card : Card.values()){
				deck.add(new PokerCard(suite, card));
			}
		}
	}
	
	public void shuffle(){
		Random random = new Random(System.currentTimeMillis());
		List<PokerCard> nextDeck = new ArrayList<>();
		while(deck.size()!=1){
			int k=Math.abs(random.nextInt())%deck.size();
			PokerCard picked = deck.get(k);
			nextDeck.add(picked);
			deck.remove(k);
		}
		nextDeck.add(deck.get(0));	// last one
		deck = nextDeck;
	}
	
	public void print(){
		for(PokerCard pk : deck){
			System.out.println(pk.suite.name() + " " + pk.card.name());
		}
	}
}

class PokerCard{
	Suite suite;
	Card card;
	
	PokerCard(Suite suite, Card card){
		this.suite = suite;
		this.card = card;
	}
}


enum Suite{
	Hearts(0), Spades(1), Diamonds(2), Clubs(3);
	
	
	private int value;
	private Map<Integer, Suite> map = new HashMap<Integer,Suite>();
	Suite(int value){
		this.value = value;
		map.put(value, this);
	}
	
	int getValue(){
		return this.value;
	}
	
	public Suite getSuite(int value){
		return map.get(value);
	}
}

enum Card{
    ACE(1), TWO(2), THREE(3), FOUR(4),
    FIVE(5), SIX(6), SEVEN(7), EIGHT(8),
    NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13);

    private int value;
	private Map<Integer, Card> map = new HashMap<Integer,Card>();

    Card(int value) {
        this.value = value;
		map.put(value, this);
    }

    int getValue() {
        return this.value;
    }
    
    public Card getCard(int value){
		return map.get(value);
	}
}