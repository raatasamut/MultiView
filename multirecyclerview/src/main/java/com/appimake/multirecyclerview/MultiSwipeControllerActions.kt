package com.appimake.multirecyclerview

abstract class MultiSwipeControllerActions {

    open fun onLeftClicked(position: Int, data: BaseMultiViewData) {}

    open fun onRightClicked(position: Int, data: BaseMultiViewData) {}

}