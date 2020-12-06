package de.christian_boehm.fahnenmasten.view;

import de.christian_boehm.fahnenmasten.model.Fahnenmast;

public class Tourist implements Fahnenbeobachter {
	private String name = "Unbekannt";

	public Tourist(String name) {
		this.name = name;
	}
	
	@Override
	public void fahnenstatusGeaendert(Fahnenmast fahnenmast) {
		System.out.println(name + " vermeldet fuer den Fahnenmast: " + fahnenmast.getFahnenposition());
	}

}
