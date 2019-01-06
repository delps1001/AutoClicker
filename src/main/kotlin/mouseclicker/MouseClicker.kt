package main.kotlin.mouseclicker

import java.awt.Robot
import java.awt.event.InputEvent
import java.awt.event.KeyEvent
import kotlin.random.Random

class MouseClicker {

    private val robot = Robot()

    private fun clickMouse() {
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK)
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK)
    }

    private fun pressEscape() {
        robot.keyPress(KeyEvent.VK_ESCAPE)
        robot.keyRelease(KeyEvent.VK_ESCAPE)
    }

    private fun pressF3() {
        robot.keyPress(KeyEvent.VK_F3)
        robot.keyRelease(KeyEvent.VK_F3)
    }

    private fun humidify() {
        while (true) {
            clickMouse()
            pressEscape()
            robot.delay(Random.nextInt(3000, 3200))
            clickMouse()
            pressF3()
            robot.delay(Random.nextInt(50, 100))
        }
    }

    private fun alchemy() {
        while(true) {
            robot.delay(Random.nextInt(2750, 3000))
            clickMouse()
            robot.delay(Random.nextInt(450, 500))
            clickMouse()
        }
    }

    private fun flickRapidHeal() {
        while(true) {
            robot.delay(Random.nextInt(55000, 55250))
            clickMouse()
            robot.delay(Random.nextInt(600, 700))
            clickMouse()
        }
    }

    private fun spamClick() {
        while(true) {
            clickMouse()
            robot.delay(25)
        }
    }

    private fun doClickingAction(input: String) {
        robot.delay(5000)
        when(input) {
            "h" -> humidify()
            "a" -> alchemy()
            "f" -> flickRapidHeal()
            "s" -> spamClick()
        }
    }

    private fun getUserInput(): String {
        println("Would you like to do alchemy(a), humidify(h), spamClick(s), or flickRapidHeal(f)?")
        return readLine().toString()
    }

    fun initialize() {
        doClickingAction(getUserInput())
    }
}