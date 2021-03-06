package disparos;

import java.util.ArrayList;
import java.util.LinkedList;

import partes.Parte;
import partes.ParteDanioDisparo;
import partes.ParteDanioTotal;
import barcos.Vector;
import casillero.Casillero;
import escenario.Tablero;
import excepciones.PosicionInvalida;

public abstract class Mina extends Disparo {
	protected int radio;
	protected LinkedList<Casillero> casillerosAfectados;

	@Override
	public int getX() {
		return posicion.x();
	}

	@Override
	public int getY() {
		return posicion.y();
	}

	public int radio() {
		return radio;
	}

	@Override
	public void cambiarCasillerosAfectados(Vector unaPosicion)
			throws PosicionInvalida {
		Tablero tablero = Tablero.getTablero();
		casillerosAfectados = tablero.casillasAfectadas(unaPosicion,
				this.radio());
		posicion = unaPosicion;
	}

	@Override
	public void daniar() {
		notificar();
		for (int j = 0; j < casillerosAfectados.size(); j++) {
			Casillero casilleroAfectado = casillerosAfectados.get(j);
			ArrayList<Parte> partesAfectadas = casilleroAfectado
					.obtenerPartes();
			for (int i = 0; i < partesAfectadas.size(); i++) {
				(partesAfectadas.get(i)).explosion(this);
			}
		}
	}

	public Vector obtenerPosicion() {
		return posicion;
	}

	@Override
	public void afectar(ParteDanioTotal parte) {
		parte.recibirDanio(1);
	}

	@Override
	public void afectar(ParteDanioDisparo parte) {
	}

}