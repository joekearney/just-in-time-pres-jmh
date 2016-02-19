/**
 * Created by joekearney on 17/02/2016.
 */
public class EquivExamplesJava {
}
class JavaConstants {
  public static final String jeSuisUnConstant =
          "some string";

  public static String jeSuisUnUtilityFunction(
          int param) {
    return String.valueOf(param);
  }
}
class JavaClass {
  final String name;
  final int ageInYears;
  private int ageInDays;

  public JavaClass(String name, int ageInYears) {
    this.name = name;
    this.ageInYears = ageInYears;
    this.ageInDays = ageInYears * 365;
  }

  JavaClass rename(String newName) {
    return new JavaClass(newName, ageInYears);
  }
}