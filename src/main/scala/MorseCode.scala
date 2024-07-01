import scala.collection.immutable.HashMap
import scala.language.postfixOps

class MorseCode {
  private val morseCodeToLetter = HashMap[String, String] (
    "._" -> "a",
    "_..." -> "b",
    "_._." -> "c",
    "_.." -> "d",
    "." -> "e",
    ".._." -> "f",
    "__." -> "g",
    "...." -> "h",
    ".." -> "i",
    ".___" -> "j",
    "_._" -> "k",
    "._.." -> "l",
    "__" -> "m",
    "_." -> "n",
    "___" -> "o",
    ".__." -> "p",
    "__._" -> "q",
    "._." -> "r",
    "..." -> "s",
    "_" -> "t",
    ".._" -> "u",
    "..._" -> "v",
    ".__" -> "w",
    "_.._" -> "x",
    "_.__" -> "y",
    "__.." -> "z",
    "_____" -> "0",
    ".____" -> "1",
    "..___" -> "2",
    "...__" -> "3",
    "...._" -> "4",
    "....." -> "5",
    "_...." -> "6",
    "__..." -> "7",
    "___.." -> "8",
    "____." -> "9",
    "._._._" -> ".",
    "__..__" -> ",",
    "..__.." -> "?",
    "_._.__" -> "!",
  )

  private val letterToMorseCode: Map[String, String] = {
   {for (m <- morseCodeToLetter.keysIterator.toList)
        yield morseCodeToLetter(m) -> m
    }.toMap
  }

  def getMorseCode (letter:String) : String = letterToMorseCode.getOrElse(letter.toLowerCase, "*")

  def getLetter (morse:String) : String = morseCodeToLetter.getOrElse(morse, "*")

  def decodeMorseToMessage (morseCode:String) : Option[String] = {
    val wordsMorse = morseCode.split(" ".repeat(7))
    val words = wordsMorse.map(word => word.split(" ".repeat(3)).map(getLetter).mkString)
    val msg= words.mkString(" ")
    if(msg.contains("*"))
      None
    else
      Some(msg)
  }

  def encodeMessageToMorse (message:String) : Option[String] = {
    val words = message.split(" ")
    val morseCode = words.map(word => word.split("").map(getMorseCode).mkString(" ".repeat(3))).mkString(" ".repeat(7))
    if(morseCode.contains("*"))
      None
    else
      Some(morseCode)
  }

}
