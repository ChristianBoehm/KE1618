package de.christian_boehm.fahnenmasten.controller;

import de.christian_boehm.fahnenmasten.model.Fahnenmast;
import de.christian_boehm.fahnenmasten.model.Fahnenmast.Fahnenposition;

public class Fahnenbedienung {
	private Fahnenmast fahnenmast;

	public Fahnenbedienung(Fahnenmast fahnenmast) {
		this.fahnenmast = fahnenmast;
	}

	public void aendereBeflaggung(Fahnenposition fahnenposition) {
		fahnenmast.setStatus(fahnenposition);
	}
}
