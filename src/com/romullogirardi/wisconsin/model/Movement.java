package com.romullogirardi.wisconsin.model;

import com.romullogirardi.wisconsin.model.Enums.Strategy;

public class Movement {

	//ATTRIBUTES
	private Strategy currentStrategy;
	private boolean success;
	private boolean colorSuccess;
	private boolean shapeSuccess;
	private boolean numberSuccess;
	
	//CONSTRUCTOR
	public Movement(Strategy currentStrategy, boolean success, boolean colorSuccess, boolean shapeSuccess, boolean numberSuccess) {
		this.currentStrategy = currentStrategy;
		this.success = success;
		this.colorSuccess = colorSuccess;
		this.shapeSuccess = shapeSuccess;
		this.numberSuccess = numberSuccess;
	}

	//GETTERS AND SETTERS
	public Strategy getCurrentStrategy() {
		return currentStrategy;
	}

	public void setCurrentStrategy(Strategy currentStrategy) {
		this.currentStrategy = currentStrategy;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public boolean isColorSuccess() {
		return colorSuccess;
	}

	public void setColorSuccess(boolean colorSuccess) {
		this.colorSuccess = colorSuccess;
	}

	public boolean isShapeSuccess() {
		return shapeSuccess;
	}

	public void setShapeSuccess(boolean shapeSuccess) {
		this.shapeSuccess = shapeSuccess;
	}

	public boolean isNumberSuccess() {
		return numberSuccess;
	}

	public void setNumberSuccess(boolean numberSuccess) {
		this.numberSuccess = numberSuccess;
	}
	
	//OTHER METHODS
	public String toString() {
		return "Estratégia corrente - " + currentStrategy.toString() + " / " +
				((success) ? "ACERTO" : "ERRO") + " / " +
				((colorSuccess) ? "COR IGUAL" : "COR DIFERENTE") + " / " +
				((shapeSuccess) ? "FORMA IGUAL" : "FORMA DIFERENTE") + " / " +
				((numberSuccess) ? "NÚMERO IGUAL" : "NÚMERO DIFERENTE");
	}
}