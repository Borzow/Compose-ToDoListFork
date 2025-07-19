package kaspressoTests.test

import androidx.compose.ui.test.ExperimentalTestApi
import com.wisnu.kurniawan.composetodolist.R
import com.wisnu.kurniawan.composetodolist.testtags.MainTestTags.MAIN_LAZY_ROW
import io.github.kakaocup.compose.node.element.ComposeScreen.Companion.onComposeScreen
import kaspressoTests.pageObject.MainScreen
import org.junit.Test
import util.CustomTestCase

class MainPageTest : CustomTestCase() {

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun test() = run {
        step("Открыт главный экран") {
            onComposeScreen<MainScreen>(composeTestRule) {
                mainScreenTag{
                    assertIsDisplayed()
                }
            }
        }
        step("Нажимаем на колонку Today"){
            onComposeScreen<MainScreen>(composeTestRule) {
               list.childWith<MainScreen.AllTask> {
                   hasTestTag(MAIN_LAZY_ROW)
               }.perform {
                   overallTask(R.string.todo_today).assertIsDisplayed()
                   overallTask(R.string.todo_today).performClick()
               }
            }
        }
    }
}