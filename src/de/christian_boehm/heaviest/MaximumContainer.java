package de.christian_boehm.heaviest;

public class MaximumContainer<T extends MaximumWeight> {

	private T heaviest;

	public T getHeaviest() {
		return heaviest;
	}

	public void store(T element) {
		if (heaviest == null || element.getWeight() > heaviest.getWeight()) {
			heaviest = element;
		}
	}
}
