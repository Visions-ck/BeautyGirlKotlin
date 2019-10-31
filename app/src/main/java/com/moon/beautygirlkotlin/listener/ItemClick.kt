package com.moon.beautygirlkotlin.listener

import android.view.View

/**
 * author: jiangtao.liang
 * date:   On 2019-10-30 20:31
 */
interface ItemClick<T> {
    fun onClick(view: View , body: T)
}