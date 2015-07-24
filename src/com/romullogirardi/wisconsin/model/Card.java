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
		if(color.equals(Color.BLUE)) {
			if(shape.equals(Shape.CIRCLE)) {
				switch (number) {
					case ONE:
//						return R.drawable.blue_circle_one;
					case TWO:
//						return R.drawable.blue_circle_two;
					case THREE:
//						return R.drawable.blue_circle_three;
					case FOUR:
						return R.drawable.blue_circle_four;
				}
			}
			else if(shape.equals(Shape.CROSS)) {
				switch (number) {
					case ONE:
//						return R.drawable.blue_cross_one;
					case TWO:
						return R.drawable.blue_cross_two;
					case THREE:
//						return R.drawable.blue_cross_three;
					case FOUR:
//						return R.drawable.blue_cross_four;
				}
			}
			else if(shape.equals(Shape.STAR)) {
				switch (number) {
					case ONE:
						return R.drawable.blue_star_one;
					case TWO:
//						return R.drawable.blue_star_two;
					case THREE:
//						return R.drawable.blue_star_three;
					case FOUR:
//						return R.drawable.blue_star_four;
				}
			}
			else if(shape.equals(Shape.TRIANGLE)) {
				switch (number) {
					case ONE:
						return R.drawable.blue_triangle_one;
					case TWO:
						return R.drawable.blue_triangle_two;
					case THREE:
//						return R.drawable.blue_triangle_three;
					case FOUR:
//						return R.drawable.blue_triangle_four;
				}
			}
		}
		else if(color.equals(Color.GREEN)) {
			if(shape.equals(Shape.CIRCLE)) {
				switch (number) {
					case ONE:
//						return R.drawable.green_circle_one;
					case TWO:
//						return R.drawable.green_circle_two;
					case THREE:
						return R.drawable.green_circle_three;
					case FOUR:
//						return R.drawable.green_circle_four;
				}
			}
			else if(shape.equals(Shape.CROSS)) {
				switch (number) {
					case ONE:
//						return R.drawable.green_cross_one;
					case TWO:
//						return R.drawable.green_cross_two;
					case THREE:
						return R.drawable.green_cross_three;
					case FOUR:
//						return R.drawable.green_cross_four;
				}
			}
			else if(shape.equals(Shape.STAR)) {
				switch (number) {
					case ONE:
//						return R.drawable.green_star_one;
					case TWO:
						return R.drawable.green_star_two;
					case THREE:
//						return R.drawable.green_star_three;
					case FOUR:
//						return R.drawable.green_star_four;
				}
			}
			else if(shape.equals(Shape.TRIANGLE)) {
				switch (number) {
					case ONE:
//						return R.drawable.green_triangle_one;
					case TWO:
//						return R.drawable.green_triangle_two;
					case THREE:
//						return R.drawable.green_triangle_three;
					case FOUR:
//						return R.drawable.green_triangle_four;
				}
			}
		}
		else if(color.equals(Color.RED)) {
			if(shape.equals(Shape.CIRCLE)) {
				switch (number) {
					case ONE:
//						return R.drawable.red_circle_one;
					case TWO:
//						return R.drawable.red_circle_two;
					case THREE:
//						return R.drawable.red_circle_three;
					case FOUR:
//						return R.drawable.red_circle_four;
				}
			}
			else if(shape.equals(Shape.CROSS)) {
				switch (number) {
					case ONE:
//						return R.drawable.red_cross_one;
					case TWO:
//						return R.drawable.red_cross_two;
					case THREE:
						return R.drawable.red_cross_three;
					case FOUR:
//						return R.drawable.red_cross_four;
				}
			}
			else if(shape.equals(Shape.STAR)) {
				switch (number) {
					case ONE:
//						return R.drawable.red_star_one;
					case TWO:
//						return R.drawable.red_star_two;
					case THREE:
						return R.drawable.red_star_three;
					case FOUR:
//						return R.drawable.red_star_four;
				}
			}
			else if(shape.equals(Shape.TRIANGLE)) {
				switch (number) {
					case ONE:
						return R.drawable.red_triangle_one;
					case TWO:
//						return R.drawable.red_triangle_two;
					case THREE:
//						return R.drawable.red_triangle_three;
					case FOUR:
//						return R.drawable.red_triangle_four;
				}
			}
		}
		else if(color.equals(Color.YELLOW)) {
			if(shape.equals(Shape.CIRCLE)) {
				switch (number) {
					case ONE:
//						return R.drawable.yellow_circle_one;
					case TWO:
//						return R.drawable.yellow_circle_two;
					case THREE:
//						return R.drawable.yellow_circle_three;
					case FOUR:
//						return R.drawable.yellow_circle_four;
				}
			}
			else if(shape.equals(Shape.CROSS)) {
				switch (number) {
					case ONE:
//						return R.drawable.yellow_cross_one;
					case TWO:
//						return R.drawable.yellow_cross_two;
					case THREE:
						return R.drawable.yellow_cross_three;
					case FOUR:
//						return R.drawable.yellow_cross_four;
				}
			}
			else if(shape.equals(Shape.STAR)) {
				switch (number) {
					case ONE:
//						return R.drawable.yellow_star_one;
					case TWO:
//						return R.drawable.yellow_star_two;
					case THREE:
//						return R.drawable.yellow_star_three;
					case FOUR:
						return R.drawable.yellow_star_four;
				}
			}
			else if(shape.equals(Shape.TRIANGLE)) {
				switch (number) {
					case ONE:
//						return R.drawable.yellow_triangle_one;
					case TWO:
//						return R.drawable.yellow_triangle_two;
					case THREE:
//						return R.drawable.yellow_triangle_three;
					case FOUR:
						return R.drawable.yellow_triangle_four;
				}
			}
		}
		return R.drawable.empty_card;
	}
}