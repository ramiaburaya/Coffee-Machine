package machine

import kotlin.system.exitProcess

class Machine {
    private var availableWater: Int = 400

    private var availableMilk: Int = 540

    private var availableBeans: Int = 120

    private var cups: Int = 9
    private var money: Int = 550

    fun action() {
        println("Write action (buy, fill, take, remaining, exit): ")

        when (readln()) {
            "buy" -> buy()
            "fill" -> fill()
            "take" -> take()
            "remaining" -> printInfo()
            "exit" -> exitProcess(0)
        }
        action()
    }

    private fun buy() {
        print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ")
        val s = readln()
        if (s == "back") {
            action()
        } else {
            when {
                s.toInt() == 1 -> makeEspresso()
                s.toInt() == 2 -> makeLatte()
                s.toInt() == 3 -> makeCappuccino()
            }
        }
    }

    private fun makeEspresso() {
        if (availableWater >= 250 && availableBeans >= 16) {
            println("I have enough resources, making you a coffee!")
            availableWater -= 250
            availableBeans -= 16
            money += 4
            cups -= 1
        } else {
            if (availableWater < 250)
                println("Sorry, not enough water!")
            else
                println("Sorry, not enough beans!")

        }
    }

    private fun makeLatte() {
        if (availableWater >= 350 && availableMilk >= 75 && availableBeans >= 20) {
            println("I have enough resources, making you a coffee!")

            availableWater -= 350
            availableMilk -= 75
            availableBeans -= 20
            money += 7
            cups -= 1
        } else {
            if (availableWater < 350)
                println("Sorry, not enough water!")
            else if (availableBeans < 75)
                println("Sorry, not enough milk!")
            else
                println("Sorry, not enough beans!")

        }
    }

    private fun makeCappuccino() {
        if (availableWater >= 200 && availableMilk >= 100 && availableBeans >= 12) {
            println("I have enough resources, making you a coffee!")

            availableWater -= 200
            availableMilk -= 100
            availableBeans -= 12
            money += 6
            cups -= 1
        } else {
            if (availableWater < 200)
                println("Sorry, not enough water!")
            else if (availableBeans < 100)
                println("Sorry, not enough milk!")
            else
                println("Sorry, not enough beans!")

        }
    }

    private fun fill() {
        print("Write how many ml of water you want to add: ")
        availableWater += readln().toInt()

        print("Write how many ml of milk you want to add: ")
        availableMilk += readln().toInt()

        print("Write how many grams of coffee beans you want to add: ")
        availableBeans += readln().toInt()

        print("Write how many disposable cups you want to add: ")
        cups += readln().toInt()

    }

    private fun take() {
        println("I gave you $$money")
        money = 0
    }

    private fun printInfo() {
        println("The coffee machine has:")
        println("$availableWater ml of water")
        println("$availableMilk ml of milk")
        println("$availableBeans g of coffee beans")
        println("$cups disposable cups")
        println("$$money of money")
    }
}

fun main() {
    val s = Machine()
    s.action()
}








