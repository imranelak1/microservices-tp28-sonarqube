package lab;

import java.util.*;

/** Calculs sans état partagé pour le projet analysé par SonarQube. */
public class GradeBook {
  public double average(List<Student> students) {
    Objects.requireNonNull(students);
    return students.stream().mapToDouble(Student::grade).average().orElse(0);
  }

  public List<Student> successful(List<Student> students) {
    return students.stream().filter(Student::passed).toList();
  }
}
