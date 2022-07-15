package com.example.provajfx;

public class FattoreRischio {
		private int  codice;
		private String  tipo;
		private String  descrizione;
		private int  livello;
		private int  fattore;
	private int codice_assegnato = 0;

		public FattoreRischio(String tipo, String descrizione, int livello) {
			this.tipo = tipo;
			if((livello < 1 || livello > 5) && descrizione == null)
				throw new IllegalArgumentException();

			this.livello = livello;
			this.descrizione = descrizione;
		}
	}
