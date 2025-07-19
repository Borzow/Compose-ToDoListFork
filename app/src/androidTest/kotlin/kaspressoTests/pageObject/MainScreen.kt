package kaspressoTests.pageObject

import androidx.annotation.StringRes
import androidx.compose.ui.semantics.SemanticsNode
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import com.wisnu.kurniawan.composetodolist.testtags.MainTestTags.MAIN_LAZY_COLUMN
import com.wisnu.kurniawan.composetodolist.testtags.MainTestTags.MAIN_SCREEN
import com.wisnu.kurniawan.composetodolist.testtags.MainTestTags.mainCellsBlock
import com.wisnu.kurniawan.composetodolist.util.LazyListItemPosition
import io.github.kakaocup.compose.node.element.ComposeScreen
import io.github.kakaocup.compose.node.element.KNode
import io.github.kakaocup.compose.node.element.lazylist.KLazyListItemNode
import io.github.kakaocup.compose.node.element.lazylist.KLazyListNode

class MainScreen(semanticsProvider: SemanticsNodeInteractionsProvider) :
    ComposeScreen<MainScreen>(semanticsProvider = semanticsProvider) {
    val mainScreenTag: KNode = child {
        hasTestTag(MAIN_SCREEN)
    }
    val list = KLazyListNode(
        semanticsProvider = semanticsProvider,
        viewBuilderAction = {
            hasTestTag(MAIN_LAZY_COLUMN)
        },
        itemTypeBuilder = {
            itemType(::AllTask)
        },
        positionMatcher = { position ->
            SemanticsMatcher.expectValue(
                LazyListItemPosition,
                position
            )
        }
    )

    class AllTask(
        semanticsNode: SemanticsNode,
        semanticsProvider: SemanticsNodeInteractionsProvider,
    ) : KLazyListItemNode<AllTask>(semanticsNode, semanticsProvider) {
        fun overallTask(@StringRes res: Int): KNode {
            return child {
                hasTestTag(mainCellsBlock(res))
            }
        }
    }
}
