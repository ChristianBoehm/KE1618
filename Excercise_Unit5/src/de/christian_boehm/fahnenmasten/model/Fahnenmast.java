package de.christian_boehm.fahnenmasten.model;

import java.util.ArrayList;

import de.christian_boehm.fahnenmasten.view.Fahnenbeobachter;

public class Fahnenmast {
	
	public enum Fahnenposition {
	    OBEN, HALBMAST, UNBEFLAGGT;
	}

	private ArrayList<Fahnenbeobachter> beobachterliste = new ArrayList<Fahnenbeobachter>();
	private Fahnenposition fahnenposition;
	
	public Fahnenmast(Fahnenposition fahnenposition) {
		setFahnenposition(fahnenposition);
	}
	
	public void addFahnenbeobachter(Fahnenbeobachter neuerbeobachter) {
		// Hinzufuegen eines Fahnenbeobachters. Um die Beobachter zu verwalten,
		// koennte eine java.util.ArrayList dienen.
		beobachterliste.add(neuerbeobachter);
	}

	public void removeFahnenbeobachter(Fahnenbeobachter neuerbeobachter) {
		// Entfernen eines Fahnenbeobachters.
		beobachterliste.remove(neuerbeobachter);
	}

	public void setStatus(Fahnenposition fahnenposition) {
		// Aendern des Fahnenstatus. Die Fahnenbeobachter sollten hierueber
		// informiert werden.
		setFahnenposition(fahnenposition);
		
		for (Fahnenbeobachter fahnenbeobachter : beobachterliste) {
			fahnenbeobachter.fahnenstatusGeaendert(this);
		}
		
	}

	public Fahnenposition getFahnenposition() {
		return this.fahnenposition;
	}

	public void setFahnenposition(Fahnenposition fahnenposition) {
		this.fahnenposition = fahnenposition;
	}
}
