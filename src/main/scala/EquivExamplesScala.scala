/**
  * Created by joekearney on 17/02/2016.
  */
object ScalaConstants {
  val ichBinEinConstant = "some string"
  def ichBinEinUtilityFunction(param: Int): String = String.valueOf(param)
}

class ScalaClass(name: String, ageInYears: Int) {
  private val ageInDays = ageInYears * 365
  def rename(newName: String) = new ScalaClass(newName, ageInYears)
}