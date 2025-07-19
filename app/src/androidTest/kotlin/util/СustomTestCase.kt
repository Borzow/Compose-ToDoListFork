package util

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.kaspersky.components.composesupport.config.withComposeSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import com.wisnu.kurniawan.composetodolist.runtime.MainActivity
import org.junit.Rule

open class CustomTestCase : TestCase(
    kaspressoBuilder = Kaspresso.Builder.withComposeSupport(),
) {
    @JvmField
    @Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

}