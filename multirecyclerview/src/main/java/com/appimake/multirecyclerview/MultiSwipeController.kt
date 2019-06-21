package com.appimake.multirecyclerview

import android.annotation.SuppressLint
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.ItemTouchHelper.ACTION_STATE_SWIPE
import androidx.recyclerview.widget.ItemTouchHelper.Callback
import android.util.Log
import android.view.MotionEvent

internal enum class ButtonsState {
    GONE,
    LEFT_VISIBLE,
    RIGHT_VISIBLE
}

data class SwipeButton(val title: String, val color: Int, val size: Float)

class MultiSwipeController(val recyclerView: androidx.recyclerview.widget.RecyclerView, val buttonsActions: MultiSwipeControllerActions, val swipeFlag: Int) : Callback() {

    private var swipeBack = false

    private var buttonShowedState = ButtonsState.GONE

    private var buttonInstance: RectF? = null

    private var currentItemViewHolder: androidx.recyclerview.widget.RecyclerView.ViewHolder? = null

    private var swipeIndex = 0f

    // Config able
    var buttonWidth = 300f
    var buttonMargin = 20f
    var buttonLeft = SwipeButton("EDIT", Color.BLUE, 30f)
    var buttonRight = SwipeButton("DELETE", Color.RED, 30f)

    init {
        val itemTouchhelper = ItemTouchHelper(this)
        itemTouchhelper.attachToRecyclerView(recyclerView)

        recyclerView.addItemDecoration(object : androidx.recyclerview.widget.RecyclerView.ItemDecoration() {
            override fun onDraw(c: Canvas, parent: androidx.recyclerview.widget.RecyclerView, state: androidx.recyclerview.widget.RecyclerView.State) {
                drawCanvas(c)
            }
        })
    }

    override fun getMovementFlags(recyclerView: androidx.recyclerview.widget.RecyclerView, viewHolder: androidx.recyclerview.widget.RecyclerView.ViewHolder): Int {
        if ((viewHolder as BaseMultiViewHolder).canSwipe())
            return ItemTouchHelper.Callback.makeMovementFlags(0, swipeFlag)
        else return 0
    }

    override fun onMove(recyclerView: androidx.recyclerview.widget.RecyclerView, viewHolder: androidx.recyclerview.widget.RecyclerView.ViewHolder, target: androidx.recyclerview.widget.RecyclerView.ViewHolder): Boolean {
        return false
    }

    override fun onSwiped(viewHolder: androidx.recyclerview.widget.RecyclerView.ViewHolder, direction: Int) {

    }

    override fun convertToAbsoluteDirection(flags: Int, layoutDirection: Int): Int {

        Log.d("TESTSWIPE", "R 1")
        if (swipeBack) {
            Log.d("TESTSWIPE", "R 2")
            swipeBack = buttonShowedState != ButtonsState.GONE
            return 0
        }
        return super.convertToAbsoluteDirection(flags, layoutDirection)
    }

    override fun onChildDraw(c: Canvas, recyclerView: androidx.recyclerview.widget.RecyclerView, viewHolder: androidx.recyclerview.widget.RecyclerView.ViewHolder, dX: Float, dY: Float, actionState: Int, isCurrentlyActive: Boolean) {
        var dx = dX
        swipeIndex = dx
        if (actionState == ACTION_STATE_SWIPE) {
            if (buttonShowedState != ButtonsState.GONE) {
                if (buttonShowedState == ButtonsState.LEFT_VISIBLE) dx = Math.max(dx, buttonWidth)
                if (buttonShowedState == ButtonsState.RIGHT_VISIBLE) dx = Math.min(dx, -buttonWidth)
                super.onChildDraw(c, recyclerView, viewHolder, dx, dY, actionState, isCurrentlyActive)
            } else {
                setTouchListener(c, recyclerView, viewHolder, dx, dY, actionState, isCurrentlyActive)
            }
        }

        if (buttonShowedState == ButtonsState.GONE) {
            super.onChildDraw(c, recyclerView, viewHolder, dx, dY, actionState, isCurrentlyActive)
        }
        currentItemViewHolder = viewHolder
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun setTouchListener(c: Canvas, recyclerView: androidx.recyclerview.widget.RecyclerView, viewHolder: androidx.recyclerview.widget.RecyclerView.ViewHolder, dX: Float, dY: Float, actionState: Int, isCurrentlyActive: Boolean) {
        Log.d("TESTSWIPE", "1")
        recyclerView.setOnTouchListener { _, event ->
            Log.d("TESTSWIPE", "2")
            swipeBack = event.action == MotionEvent.ACTION_CANCEL || event.action == MotionEvent.ACTION_UP
            if (swipeBack) {
                Log.d("TESTSWIPE", "3")
                if (dX < -buttonWidth)
                    buttonShowedState = ButtonsState.RIGHT_VISIBLE
                else if (dX > buttonWidth)
                    buttonShowedState = ButtonsState.LEFT_VISIBLE

                if (buttonShowedState != ButtonsState.GONE) {
                    setTouchDownListener(c, recyclerView, viewHolder, dY, actionState, isCurrentlyActive)
                    setItemsClickable(recyclerView, false)
                }
            }
            false
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun setTouchDownListener(c: Canvas, recyclerView: androidx.recyclerview.widget.RecyclerView, viewHolder: androidx.recyclerview.widget.RecyclerView.ViewHolder, dY: Float, actionState: Int, isCurrentlyActive: Boolean) {
        Log.d("TESTSWIPE", "4")
        recyclerView.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                setTouchUpListener(c, recyclerView, viewHolder, dY, actionState, isCurrentlyActive)
            }
            false
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun setTouchUpListener(c: Canvas, recyclerView: androidx.recyclerview.widget.RecyclerView, viewHolder: androidx.recyclerview.widget.RecyclerView.ViewHolder, dY: Float, actionState: Int, isCurrentlyActive: Boolean) {
        Log.d("TESTSWIPE", "5")
        recyclerView.setOnTouchListener { _, event ->
            Log.d("TESTSWIPE", "IN")
            if (event.action == MotionEvent.ACTION_UP) {
                super@MultiSwipeController.onChildDraw(c, recyclerView, viewHolder, 0f, dY, actionState, isCurrentlyActive)
                setItemsClickable(recyclerView, true)
                swipeBack = false

                if (buttonInstance != null && buttonInstance!!.contains(event.x, event.y)) {
                    if (buttonShowedState == ButtonsState.LEFT_VISIBLE) {
                        Log.d("TESTSWIPE", "click l")
                        buttonsActions.onLeftClicked(viewHolder.adapterPosition, (recyclerView.adapter as MultiViewAdapter).getItemData(viewHolder.adapterPosition))
                    } else if (buttonShowedState == ButtonsState.RIGHT_VISIBLE) {
                        Log.d("TESTSWIPE", "click r")
                        buttonsActions.onRightClicked(viewHolder.adapterPosition, (recyclerView.adapter as MultiViewAdapter).getItemData(viewHolder.adapterPosition))
                    }
                }
                buttonShowedState = ButtonsState.GONE
                currentItemViewHolder = null
            }
            false
        }
    }

    private fun setItemsClickable(recyclerView: androidx.recyclerview.widget.RecyclerView, isClickable: Boolean) {
        for (i in 0 until recyclerView.childCount) {
            recyclerView.getChildAt(i).isClickable = isClickable
        }
    }

    private fun drawButtons(c: Canvas, viewHolder: androidx.recyclerview.widget.RecyclerView.ViewHolder) {
        val buttonWidthWithoutPadding = buttonWidth
        val corners = 8f

        val itemView = viewHolder.itemView
        val p = Paint()

        val leftButton = RectF(itemView.left.toFloat() + buttonMargin, itemView.top.toFloat() + buttonMargin, itemView.left + buttonWidthWithoutPadding, itemView.bottom.toFloat() - buttonMargin)
        val rightButton = RectF(itemView.right - buttonWidthWithoutPadding, itemView.top.toFloat() + buttonMargin, itemView.right.toFloat() - buttonMargin, itemView.bottom.toFloat() - buttonMargin)

        if (swipeIndex > 0) {
            p.color = buttonLeft.color
            c.drawRoundRect(leftButton, corners, corners, p)
            drawText(buttonLeft.title, buttonLeft.size, c, leftButton, p)
        } else if (swipeIndex < 0) {
            p.color = buttonRight.color
            c.drawRoundRect(rightButton, corners, corners, p)
            drawText(buttonRight.title, buttonRight.size, c, rightButton, p)
        } else {
            p.color = buttonLeft.color
            c.drawRoundRect(leftButton, corners, corners, p)
            drawText(buttonLeft.title, buttonLeft.size, c, leftButton, p)

            p.color = buttonRight.color
            c.drawRoundRect(rightButton, corners, corners, p)
            drawText(buttonRight.title, buttonRight.size, c, rightButton, p)
        }

        buttonInstance = null
        if (buttonShowedState == ButtonsState.LEFT_VISIBLE) {
            buttonInstance = leftButton
        } else if (buttonShowedState == ButtonsState.RIGHT_VISIBLE) {
            buttonInstance = rightButton
        }
    }

    private fun drawText(text: String, textSize: Float, c: Canvas, button: RectF, p: Paint) {
        p.color = Color.WHITE
        p.isAntiAlias = true
        p.textSize = textSize

        val textWidth = p.measureText(text)
        c.drawText(text, button.centerX() - textWidth / 2, button.centerY() + textSize / 2, p)
    }

    fun drawCanvas(c: Canvas) {
        if (currentItemViewHolder != null) {
            drawButtons(c, currentItemViewHolder!!)
        }
    }
}