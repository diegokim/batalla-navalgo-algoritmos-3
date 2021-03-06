package barcos;

public class Vector {
	protected int x, y;

	public Vector(Vector vector) {
		this.asignar(vector);
	}

	public Vector(int enX, int enY) {
		x = enX;
		y = enY;
	}

	public Vector(String strVector) {
		x = Integer.parseInt(strVector.substring(strVector.indexOf("(") + 1,
				strVector.indexOf(",")));
		y = Integer.parseInt(strVector.substring(strVector.indexOf(",") + 1,
				strVector.indexOf(")")));
	}

	public int x() {
		return x;
	}

	public int y() {
		return y;
	}

	public void setX(int a) {
		x = a;
	}

	public void setY(int a) {
		y = a;
	}

	public boolean sonIguales(Vector vector) {
		boolean igualX = ((this.x()) == (vector.x()));
		boolean igualY = ((this.y()) == (vector.y()));
		return (igualX && igualY);
	}

	public void asignar(Vector vector) {
		x = vector.x();
		y = vector.y();
	}

	public Vector sumar(Vector vector) {
		return new Vector(vector.x() + x, vector.y() + y);
	}

	public Vector porEscalar(int escalar) {
		return new Vector(x * escalar, y * escalar);
	}

	@Override
	public String toString() {
		return new String("(" + Integer.toString(x) + "," + Integer.toString(y)
				+ ")");
	}

	public int productoEscalar(Vector vector) {
		int resultado = this.x() * vector.x() + this.y() * vector.y();
		return resultado;
	}

	public boolean sonOrtogonales(Vector vector) {
		if (this.productoEscalar(vector) == 0)
			return true;
		return false;
	}
}
