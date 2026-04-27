package clase;

public class Estudiante {
private int cod;
private String nom;
private double n1,n2;
public Estudiante(int cod, String nom, double n1, double n2) {
	this.cod = cod;
	this.nom = nom;
	this.n1 = n1;
	this.n2 = n2;
}
public int getCod() {
	return cod;
}
public void setCod(int cod) {
	this.cod = cod;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public double getN1() {
	return n1;
}
public void setN1(double n1) {
	this.n1 = n1;
}
public double getN2() {
	return n2;
}
public void setN2(double n2) {
	this.n2 = n2;
}
public double Promedio() {
	return (n1+n2)/2;
}
}





