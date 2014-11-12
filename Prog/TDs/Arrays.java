//============================================================================
//Question 1
//============================================================================
public static<T extends Comparable<T>> fusionFiles(File<T> f1, File<T> f2) {
	File<T> result = new FileAnneau<T>(f1.taille() + f2.taille());

	while (!f1.estVide() || !f2.estVide()) {
		felem = f1.getTete();
		selem = f2.getTete();

		if (felem < selem) {
			result.ajouter(felem);
			f1.supprimer();
		}
		else {
			result.ajouter(selem);
			f2.supprimer();
		}
	}

	File<T> nonVide = f1.estVide() ? f1 : f2;

	while(!nonVide.estVide()) {
		result.ajouter(nonVide.getTete());
		nonVide.supprimer();
	}

	return result;
}

//============================================================================
//Question 2
//============================================================================
public static<T> File<File<T>> initialisationFile(Array<T> elements) {
	File<File<T>> result = new FileAnneau<File<T>>(elements.length());

	for (int i = 0; i < elements.length; i++) {
		File<T> item = new FileAnneau<T>(1);
		item.ajouter(elements.get(i));

		result.ajouter(item);
	}

	return result;
}

//============================================================================
//Question 3
//============================================================================
// Sans Recursion
public static<T extends Comparable<T>> File<T> fusionTriee(File<File<T>> elements) {
	while (elements.taille() > 1) {
		File<T> f1 = elements.getTete();
		elements.supprimer();
		File<T> f2 = elements.getTete();
		elements.supprimer();

		elements.ajouter(fusionFiles(f1, f2));
	}

	return elements.getTete();
}

//============================================================================
//Question 4
//============================================================================
public static<T extends Comparable<T>> Array<T> triFusion(Array<T> elements) {
	File<T> file = fusionTriee(initialisationFile(elements));
	for (int i = 0; i < elements.length(); i++) {
		elements.set(i, file.getTete());
		file.supprimer();
	}
}
