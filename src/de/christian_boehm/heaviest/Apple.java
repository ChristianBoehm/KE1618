package de.christian_boehm.heaviest;

public class Apple extends Obst {

	private final double weight;
	
	public Apple(double weightInGramm) {
		this.weight = weightInGramm;
	}
	
	@Override
	public double getWeight() {
		
		return this.weight;
	}

	@Override
	public int compareTo(MaximumWeight o) {
		if (this.getWeight() > o.getWeight()) {
			return 1;
		} else if (this.getWeight() == o.getWeight()) {
			return -1;
		} else {
			return -1;
		}
	}
}
