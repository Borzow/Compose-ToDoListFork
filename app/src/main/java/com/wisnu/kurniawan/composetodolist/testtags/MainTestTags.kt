package com.wisnu.kurniawan.composetodolist.testtags

import androidx.annotation.StringRes

object MainTestTags {
    const val MAIN_SCREEN = "ToDoMainScreen_PgPageLayout_Column"
    const val MAIN_LAZY_COLUMN = "ToDoMainScreen_LazyColumn"
    const val MAIN_LAZY_ROW = "ToDoMainScreen_LazyColumn_Row"
    fun mainCellsBlock(@StringRes res:Int) = "ToDoMainScreen_$res"
}