package com.xueqiya.example.ui.main

import android.animation.Animator
import android.animation.ObjectAnimator
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import com.google.android.material.bottomnavigation.BottomNavigationView

/**
 * @Author xueqi
 * @Date 2021/7/15 12:09 下午
 * @Description: TODO
 */
private var isShow = true

fun showOtherView(bottomNavigationView: BottomNavigationView) {
    if (isShow) return
    isShow = !isShow
    val translationY = translationY(bottomNavigationView, bottomNavigationView.height.toFloat(), 0F)
    translationY.addListener(object : Animator.AnimatorListener {
        override fun onAnimationStart(animation: Animator?) {
            bottomNavigationView.visibility = View.VISIBLE
        }

        override fun onAnimationEnd(animation: Animator?) {}
        override fun onAnimationCancel(animation: Animator?) {}
        override fun onAnimationRepeat(animation: Animator?) {}
    })
    translationY.start()
}

fun hideOtherView(bottomNavigationView: BottomNavigationView) {
    if (!isShow) return
    isShow = !isShow
    val translationY = translationY(bottomNavigationView, 0F, bottomNavigationView.height.toFloat())
    translationY.addListener(object : Animator.AnimatorListener {
        override fun onAnimationStart(animation: Animator?) {
        }

        override fun onAnimationEnd(animation: Animator?) {
            bottomNavigationView.visibility = View.GONE
        }

        override fun onAnimationCancel(animation: Animator?) {}
        override fun onAnimationRepeat(animation: Animator?) {}
    })
    translationY.start()
}

private fun translationY(v: View, startFloat: Float, endFloat: Float): ObjectAnimator {
    val objectAnimator = ObjectAnimator.ofFloat(v, "translationY", startFloat, endFloat)
    objectAnimator.interpolator = AccelerateDecelerateInterpolator()
    objectAnimator.duration = 300
    return objectAnimator
}