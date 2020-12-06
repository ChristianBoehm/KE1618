package de.christian_boehm.fahnenmasten;

import de.christian_boehm.fahnenmasten.controller.Fahnenbedienung;
import de.christian_boehm.fahnenmasten.model.Fahnenmast;
import de.christian_boehm.fahnenmasten.model.Fahnenmast.Fahnenposition;
import de.christian_boehm.fahnenmasten.view.Fahnenbeobachter;
import de.christian_boehm.fahnenmasten.view.Tourist;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class Fahnentest {
	public static void main(String[] args) {
		Fahnenmast meinFahnenmast = new Fahnenmast(Fahnenposition.OBEN);
		Fahnenbedienung bedienung1 = new Fahnenbedienung(meinFahnenmast);
		Fahnenbedienung bedienung2 = new Fahnenbedienung(meinFahnenmast);
		Fahnenbeobachter anna = new Tourist("Anna");
		Fahnenbeobachter bernd = new Tourist("Bernd");
		Fahnenbeobachter charly = new Tourist("Charly");
		bedienung1.aendereBeflaggung(Fahnenposition.OBEN);
		meinFahnenmast.addFahnenbeobachter(bernd);
		
		
		/* Hier Teilaufgabe d) */
		
		Fahnenbeobachter michael = new Fahnenbeobachter() {
			private String name = "Michael"; 
			
			@Override
			public void fahnenstatusGeaendert(Fahnenmast fahnenmast) {
				System.out.println(name + " vermeldet fuer den Fahnenmast: " + fahnenmast.getFahnenposition());
			}
			
		};
		
		
		bedienung1.aendereBeflaggung(Fahnenposition.HALBMAST);
		meinFahnenmast.addFahnenbeobachter(anna);
		meinFahnenmast.addFahnenbeobachter(charly);
		meinFahnenmast.removeFahnenbeobachter(bernd);
		bedienung2.aendereBeflaggung(Fahnenposition.UNBEFLAGGT);
		bedienung2.aendereBeflaggung(Fahnenposition.OBEN);
		meinFahnenmast.addFahnenbeobachter(bernd);
	}
}