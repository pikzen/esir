package esir.tp2;

import types.*;
import rationnel.*;

public class TRationnel {
	public static void main(String[] args) {
		Rationnel r1 = new RationnelSimple(18, 5);
		Rationnel r2 = new RationnelSimple(32, 8);

		System.out.println("Rationnel : " + r1.toString());
		System.out.println("Somme : " + r1.somme(r2));
		System.out.println("Inverse : " + r1.inverse());
		System.out.println("Réel : " + r1.valeur());
		System.out.println("CompareTo : " + r1.compareTo(r2));
		System.out.println("Equals ? : " + r1.equals(r2));

	}
}
