import scala.annotation.tailrec

object Playground {

  val morseService: MorseService = MorseService(new MorseCode)

  @tailrec
  private def run():Unit = {
    Scanner.getOption match {
      case 1 =>
        val message = Scanner.getInput("Please enter the message to be encoded")
        try println(morseService.messageToMorseService(message)) catch {
          case e: RuntimeException => println(e.getMessage)
        }
        run()
      case 2 =>
        val morse = Scanner.getInput("Please enter a valid morse code to decode")
        try println(morseService.morseToMessageService(morse)) catch {
          case e: RuntimeException => println(e.getMessage)
        }
        run()
      case 3 => println("Thanks for using the Morse encoder/decoder. Bye!!")
    }
  }

  def main(args: Array[String]): Unit = {
    println("Welcome to my Morse encoder/decoder")
    run()
  }

}
