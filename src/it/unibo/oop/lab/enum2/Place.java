package it.unibo.oop.lab.enum2;

public enum Place {
	INDOOR("indoor"),
	OUTDOOR("outdoor");
	
	private final String name;
	
	Place(final String name){
		this.name = name;
	}
	
	public String toString() {
		return this.name;
	}
}