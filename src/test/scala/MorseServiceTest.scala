import org.scalatest.funspec.AnyFunSpec
import org.mockito.MockitoSugar._

class MorseServiceTest extends AnyFunSpec {

  val mockMorseCode: MorseCode = mock[MorseCode]
  val morseService: MorseService = MorseService(mockMorseCode)

  describe("morseToMessageService") {
    it("should throw an exception if an invalid morse code is given") {
      val wrongMorseCode = "---"
      when(mockMorseCode.decodeMorseToMessage(wrongMorseCode)).thenReturn(None)
      val exception = intercept[RuntimeException] {
        morseService.morseToMessageService(wrongMorseCode)
      }
      assert(exception.getMessage == "The morse code entered is incorrect")
    }

    it("should give the correct response if a valid morse code is given") {
      val correctMorseCode = "---"
      val expectedResult = "A"
      when(mockMorseCode.decodeMorseToMessage(correctMorseCode)).thenReturn(Some(expectedResult))
      val message = morseService.morseToMessageService(correctMorseCode)
      assert(message == s"The decoded message is => $expectedResult")
    }
  }

  describe("messageToMorseService"){
    it("should throw an exception if an invalid message is given") {
      val wrongMessage = "9jnm"
      when(mockMorseCode.encodeMessageToMorse(wrongMessage)).thenReturn(None)
      val exception = intercept[RuntimeException] {
        morseService.messageToMorseService(wrongMessage)
      }
      assert(exception.getMessage == "The message is not valid")
    }

    it("should give the correct response if a valid message is given") {
      val correctMessage = "hi"
      val expectedResult = "A"
      when(mockMorseCode.encodeMessageToMorse(correctMessage)).thenReturn(Some(expectedResult))
      val morse = morseService.messageToMorseService(correctMessage)
      assert(morse == s"The encoded message is => $expectedResult")
    }
  }

}
