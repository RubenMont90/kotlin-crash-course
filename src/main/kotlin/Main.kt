import kotlin.code
import kotlin.math.abs
import kotlin.random.Random

enum class GameOptions(val code:Int) {
    ROCK(1), PAPER(2), SCISSOR(3);
    companion object {
        fun fromCode(code: Int): GameOptions? {
            return entries.find { it.code == code }
        }
    }
}

fun main(){
    guessTheNumber()
}

fun guessTheNumber(){
    val minThreshold = 10
    val number = Random.nextInt(1, 101)
    var amountOfTries = 0
    var guessedNumber = 0
    do {
        print("> Guess the number the computer chose: ")
        guessedNumber = readln().toIntOrNull() ?: 0

        when{
            guessedNumber == 0 || guessedNumber > 100 || guessedNumber < -1 -> println("> Invalid Guess! Choose again!\n> Choose between [1-100] or (-1) to exit")
            guessedNumber == -1 -> {
                guessedNumber=number
                amountOfTries = -1
            }
            guessedNumber < number -> println(">> GO HIGHER!")
            guessedNumber > number -> println(">> go lower!")
            guessedNumber == number -> println("> Well Done! The number was in fact: $guessedNumber")
            else -> println("> How did i get here...")
        }
        amountOfTries++

    } while(guessedNumber != number)

    when{
        amountOfTries == 0 -> println("> Quitter :(")
        amountOfTries <= minThreshold -> println("> Only took you $amountOfTries tries!!")
        else -> println("> Took you $amountOfTries tries... Those are rookie numbers.")
    }
}

fun rockPaperScissors(){
    val number = Random.nextInt(1, 4)

    println("Choose 1-3 [1=ROCK 2=PAPER 3=SCISSOR]")
    val input = readln().toIntOrNull() ?: 0

    println("Computer:${GameOptions.fromCode(number)} vs Player:${GameOptions.fromCode(input)}")

    val diff = number - input
    val result = when {
        diff == 0 -> "It's a TIE!"
        abs(diff) == 1 -> if (number > input) "Computer WON!" else "Player WON!"
        else -> if (number == 1) "Computer WON!" else "Player WON!"
    }

    println(result)
}