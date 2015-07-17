package com.romullogirardi.wisconsin.model;

import java.util.ArrayList;

import com.romullogirardi.wisconsin.model.Enums.Color;
import com.romullogirardi.wisconsin.model.Enums.Number;
import com.romullogirardi.wisconsin.model.Enums.Shape;
import com.romullogirardi.wisconsin.model.Enums.Strategy;

public class Constants {

	public static final Strategy INITIAL_STRATEGY = Strategy.COLOR;
	public static final Card REFERENCE_CARD_1 = new Card(Color.RED, Shape.CIRCLE, Number.ONE);
	public static final Card REFERENCE_CARD_2 = new Card(Color.GREEN, Shape.TRIANGLE, Number.TWO);
	public static final Card REFERENCE_CARD_3 = new Card(Color.BLUE, Shape.SQUARE, Number.THREE);
	public static final Card REFERENCE_CARD_4 = new Card(Color.YELLOW, Shape.STAR, Number.FOUR);
	public static final int SUCCESS_COUNTER_CHANGE_POINT = 2;
	public static final int MINIMUM_SCORE_EXPECTED = 3;
	
	public static final ArrayList<Card> generateCardsToBePlayed() {
		
		ArrayList<Card> cardsToBePlayed = new ArrayList<>();
		cardsToBePlayed.add(new Card(Color.RED, Shape.TRIANGLE, Number.TWO));
		cardsToBePlayed.add(new Card(Color.BLUE, Shape.CIRCLE, Number.ONE));
		cardsToBePlayed.add(new Card(Color.GREEN, Shape.SQUARE, Number.THREE));
		cardsToBePlayed.add(new Card(Color.YELLOW, Shape.STAR, Number.FOUR));
		cardsToBePlayed.add(new Card(Color.BLUE, Shape.CIRCLE, Number.ONE));
		return cardsToBePlayed;
	}
}
