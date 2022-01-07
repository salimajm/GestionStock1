package GestionStock1.GestionStock1.Metiers;

import java.util.Date;

public class Facture {
private Date date;
private double montant;
private int id;

public Facture(int id) {
	super();
	this.id = id;
}
public Facture(Date date, double montant, int id) {
super();
this.date = date;
this.montant = montant;
this.id = id;
}
public Date getDate() {
return date;
}
public void setDate(Date date) {
this.date = date;
}
public double getMontant() {
return montant;
}
public void setMontant(double montant) {
this.montant = montant;
}
public int getId() {
return id;
}
public void setId(int id) {
this.id = id;
}
@Override
public String toString() {
return "Facture [date=" + date + ", montant=" + montant + ", id=" + id + "]";
}


}
