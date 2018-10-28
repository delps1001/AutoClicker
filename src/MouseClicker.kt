import java.awt.Robot
import java.awt.event.InputEvent

class MouseClicker {

    private val robot = Robot()
    private var doubleClick: Boolean = true
    private var doubleClickDelayLength: Int = 2500
    private var clickDelayLength: Int = 55000

    private fun clickMouse() {
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK)
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK)
    }

    private fun clickOnLoop() {
        while (true) {
            robot.delay(clickDelayLength)
            clickMouse()
            if (doubleClick) {
                robot.delay(doubleClickDelayLength)
                clickMouse()
            }
        }
    }

    private fun getUserInput() {
        println("Would you like to double click? Double click is currently set to: $doubleClick. Press enter to keep the current value, or enter a new value.")
        doubleClick = readLine()?.toBoolean() == null
        if(doubleClick) {
            println("How long would you like the double click delay length to be? It is currently: $doubleClickDelayLength. Press enter to keep the current value, or enter a new value.")
            doubleClickDelayLength = readLine()?.toInt() ?: doubleClickDelayLength
        }
        println("How long would you like the click delay length to be? It is currently: $clickDelayLength. Press enter to keep the current value, or enter a new value.")
        clickDelayLength = readLine()?.toInt() ?: clickDelayLength
    }

    fun initialize() {
        getUserInput()
        clickOnLoop()
    }
}