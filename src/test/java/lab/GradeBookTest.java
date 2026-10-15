package lab;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class GradeBookTest {
  private final GradeBook book = new GradeBook();

  @Test
  void averageOfStudents() {
    assertEquals(12, book.average(List.of(new Student("Imrane", 14), new Student("Sara", 10))));
  }

  @Test
  void emptyAverage() {
    assertEquals(0, book.average(List.of()));
  }

  @Test
  void successfulOnly() {
    assertEquals(
        List.of(new Student("Sara", 10)),
        book.successful(List.of(new Student("Sara", 10), new Student("Ali", 9))));
  }

  @Test
  void validatesNames() {
    assertThrows(IllegalArgumentException.class, () -> new Student("", 12));
    assertThrows(IllegalArgumentException.class, () -> new Student(null, 12));
  }

  @Test
  void validatesGrades() {
    for (double grade : new double[] {-1, 21, Double.NaN, Double.POSITIVE_INFINITY})
      assertThrows(IllegalArgumentException.class, () -> new Student("Ali", grade));
  }

  @Test
  void nullListIsRejected() {
    assertThrows(NullPointerException.class, () -> book.average(null));
  }
}
