import org.scalatest.funsuite.AnyFunSuite

class MorseCodeTest extends AnyFunSuite {

  val morse = new MorseCode

  // Tests for EncodeMessageToMorse
  test("EncodeMessageToMorse should convert a empty string to Null") {
    val message = ""
    assert(morse.encodeMessageToMorse(message).isEmpty)
  }

  test("EncodeMessageToMorse should convert a single letter to the correct morse code") {
    val message = "i"
    assert(morse.encodeMessageToMorse(message).contains(".."))
  }

  test("EncodeMessageToMorse should convert a single word to the correct morse code") {
    val message = "Hi"
    assert(morse.encodeMessageToMorse(message).contains("....   .."))
  }

  test("EncodeMessageToMorse should convert a sentence to the correct morse code") {
    val message = "Hi, I am Divya"
    assert(morse.encodeMessageToMorse(message).contains("....   ..   __..__       ..       ._   __       _..   ..   ..._   _.__   ._"))
  }

  test("EncodeMessageToMorse should convert a invalid input to None") {
    val letter = "£"
    val message = "Hi, I'm Divya"
    assert(morse.encodeMessageToMorse(letter).isEmpty)
    assert(morse.encodeMessageToMorse(message).isEmpty)
  }

  //Tests for decodeMorseToMessage
  test("DecodeMorseToMessage should convert a empty string to Null") {
    val morseCode = ""
    assert(morse.decodeMorseToMessage(morseCode).isEmpty)
  }

  test("decodeMorseToMessage should convert a single letter to the correct morse code") {
    val message = ".."
    assert(morse.decodeMorseToMessage(message).contains("i"))
  }

  test("decodeMorseToMessage should convert a single word to the correct morse code") {
    val message = "....   .."
    assert(morse.decodeMorseToMessage(message).contains("hi"))
  }

  test("decodeMorseToMessage should convert a sentence to the correct morse code") {
    val message = "....   ..   __..__       ..       ._   __       _..   ..   ..._   _.__   ._"
    assert(morse.decodeMorseToMessage(message).contains("hi, i am divya"))
  }

  test("decodeMorseToMessage should convert a invalid input to None") {
    val letter = ".-...--...-"
    val message = "....   ..   __..__..-"
    assert(morse.decodeMorseToMessage(letter).isEmpty)
    assert(morse.decodeMorseToMessage(message).isEmpty)
  }

  //Tests for getLetter
  test("GetLetter should convert a empty string to Null") {
    val morseCodeLetter = ""
    assert(morse.getLetter(morseCodeLetter).contains("*"))
  }

  test("GetLetter should convert the code for a single letter to the correct letter") {
    val morseCodeLetter = "...."
    assert(morse.getLetter(morseCodeLetter).contains("h"))
  }


  test("GetLetter should convert the code for a number to the corresponding") {
    val morseCodeLetter = "..___"
    assert(morse.getLetter(morseCodeLetter).contains("2"))
  }

  test("GetLetter should convert an invalid code to *") {
    val morseCodeLetter = "..---."
    val morseCodeLetter2 = "3"
    assert(morse.getLetter(morseCodeLetter).contains("*"))
    assert(morse.getLetter(morseCodeLetter2).contains("*"))
  }

  //tests for getMorseCode

  test("getMorseCode should convert a empty string to Null") {
    val letter = ""
    assert(morse.getMorseCode(letter).contains("*"))
  }

  test("getMorseCode should convert a lower case letter string to the correct morse code") {
    val letter = "h"
    assert(morse.getMorseCode(letter).contains("...."))
  }

  test("getMorseCode should convert an upper case letter string to the correct morse code") {
    val letter = "H"
    assert(morse.getMorseCode(letter).contains("...."))
  }

  test("getMorseCode should convert a number string to the correct morse code") {
    val letter = "2"
    assert(morse.getMorseCode(letter).contains("..___"))
  }

  test("getMorseCode should convert an invalid string to *") {
    val letter = "="
    assert(morse.getMorseCode(letter).contains("*"))
  }


}
