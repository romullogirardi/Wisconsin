package com.romullogirardi.wisconsin.model;

import com.romullogirardi.wisconsin.R;
import com.romullogirardi.wisconsin.model.Enums.Color;
import com.romullogirardi.wisconsin.model.Enums.Shape;
import com.romullogirardi.wisconsin.model.Enums.Number;

public class Card {
	
	//ATTRIBUTES
	private Color color;
	private Shape shape;
	private Number number;
	
	//CONSTRUCTOR
	public Card(Color color, Shape shape, Number number) {
		this.color = color;
		this.shape = shape;
		this.number = number;
	}

	//GETTERS AND SETTERS
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public Shape getShape() {
		return shape;
	}
	
	public void setShape(Shape shape) {
		this.shape = shape;
	}
	
	public Number getNumber() {
		return number;
	}
	
	public void setNumber(Number number) {
		this.number = number;
	}
	
	//OTHER METHODS
	public String toString() {
		return "{" + color.toString() + ", " + shape.toString() + ", " + number.toString() + "}";
	}
	
	public int getDrawableId() {
		return R.drawable.empty_card;
	}
}