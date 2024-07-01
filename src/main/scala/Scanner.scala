import scala.io.StdIn.{readInt, readLine}
import scala.util.matching.Regex

object Scanner {

  def getOption : Int = {
    println("Please select an option:")
    println("1. English to Morse code")
    println("2. Morse code to English")
    println("3. Quit")
    var option:Int = 0
    try{
      option = readInt()
    }catch {
      case _:(java.lang.IllegalArgumentException) => {
        println("Value entered is not a number")
        option = 0
      }
      case _:(java.io.EOFException) => {
        println("Error in the input stream")
        option = 0
      }
    }
    if (option >= 1 && option <= 3)
      option
    else {
      println("The option selected is not valid")
      getOption
    }
  }

  def getInput(message: String):String = {
    println(message)
    readLine().trim
  }
}