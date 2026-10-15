package lab;

/** Données d'un étudiant ; aucun secret dans le modèle. */
public record Student(String name, double grade) {
  public Student {
    if (name == null || name.isBlank()) throw new IllegalArgumentException("Nom requis");
    if (!Double.isFinite(grade) || grade < 0 || grade > 20)
      throw new IllegalArgumentException("Note entre 0 et 20");
  }

  public boolean passed() {
    return grade >= 10;
  }
}
