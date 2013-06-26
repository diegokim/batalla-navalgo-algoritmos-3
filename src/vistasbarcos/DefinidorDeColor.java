package vistasbarcos;

import java.awt.Color;

import barcos.Buque;
import barcos.Destructor;
import barcos.Lancha;
import barcos.Portaaviones;
import barcos.Rompehielo;

public class DefinidorDeColor implements AbstractDefinition {

	public Color devolverColor(Buque buque) {
		return Color.WHITE;
	}

	public Color devolverColor(Destructor destructor) {
		return Color.BLUE;
	}

	public Color devolverColor(Rompehielo rompehielo) {
		return Color.GREEN;
	}

	public Color devolverColor(Lancha lancha) {
		return Color.ORANGE;
	}

	public Color devolverColor(Portaaviones portaaviones) {
		return Color.RED;
	}

	@Override
	public Color identificarColor(Buque buque) {
		return Color.WHITE;
	}

}
