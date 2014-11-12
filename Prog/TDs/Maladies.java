public interface Maladie {
	public Maladie(String nom, List<Integer> symptomes);

	public String getNom();

	public List<Integer> getSymptomes();
}

public static int symptomesCommuns(Maladie m1, Maladie m2) {
	List<Integer> s1 = m1.getSymptomes();
	List<Integer> s2 = m2.getSymptomes();

	int commun = 0;
	int sympt1 = -1, sympt2 = -1;
	while (s1.hasNext() && s2.hasNext()) {
		if ()
	}
}
