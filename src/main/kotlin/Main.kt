import kotlin.random.Random

fun main(){
    rockPaperScissors()
}

fun guessTheNumber(){
    val minThreshold = 10
    val number = Random.nextInt(1, 101)
    var amountOfTries = 0
    var guessedNumber = 0
    do {
        print("> Guess the number the computer chose: ")
        guessedNumber = readln().toIntOrNull() ?: 0
        if(guessedNumber == 0){
            println("> Invalid Guess! Choose again!")
            println("> Choose between [1-100] or (-1) to exit")
        }
        else if(guessedNumber == -1){
            guessedNumber=number
            amountOfTries = -1
        }
        else if(guessedNumber < number)
            println(">> GO HIGHER!")
        else if(guessedNumber > number)
            println(">> go lower!")
        else if(guessedNumber == number)
            println("> Well Done! The number was in fact: $guessedNumber")
        else
            println("> How did i get here...")
        amountOfTries++
    } while(guessedNumber != number)

    if(amountOfTries == 0)
        println("> Quitter :(")
    else if(amountOfTries <= minThreshold)
        println("> Only took you $amountOfTries tries!!")
    else
        println("> Took you $amountOfTries tries... Those are rookie numbers.")
}

fun rockPaperScissors(){

    val number = Random.nextInt(0, 3)
    println(number)
}