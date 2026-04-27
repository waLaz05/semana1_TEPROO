package arreglo;

import java.util.ArrayList;

import clase.Estudiante;

public class ArregloEstudiante {
private ArrayList<Estudiante>estu;
public ArregloEstudiante() {
	estu=new ArrayList<Estudiante>();
	Adicionar(new Estudiante(1020, "Anita", 14, 16));
	Adicionar(new Estudiante(3040, "Pepe", 15, 16));
	Adicionar(new Estudiante(5060, "Luis", 17, 15));
	Adicionar(new Estudiante(7080, "Víctor", 10, 7));
}
public void Adicionar(Estudiante x) {
	estu.add(x);
}

public int Tamaño() {
	return estu.size();
}
public Estudiante Obtener(int x) {
	return estu.get(x);
}
public double PromedioGeneral() {
	double suma=0.0;
	for (int i = 0; i < Tamaño(); i++) {
		suma+=Obtener(i).Promedio();
	}
	return suma/Tamaño();
}
public Estudiante Buscar(int cod) {
	for (int i = 0; i <Tamaño(); i++) {
		if(Obtener(i).getCod()==cod)return Obtener(i);
	}
	return null;
}
public void Eliminar(Estudiante x) {
	estu.remove(x);
}
}





