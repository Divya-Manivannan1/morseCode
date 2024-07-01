case class MorseService (morseCode :MorseCode) {

  def morseToMessageService(morse: String) : String = {
    val message = morseCode.decodeMorseToMessage(morse)
    message match {
      case Some(msg) => s"The decoded message is => $msg"
      case None => throw new RuntimeException("The morse code entered is incorrect")
    }
  }

  def messageToMorseService(message:String) : String = {
    val morse = morseCode.encodeMessageToMorse(message)
    morse match {
      case Some(m) => s"The encoded message is => $m"
      case None => throw new RuntimeException("The message is not valid")
    }
  }

}
