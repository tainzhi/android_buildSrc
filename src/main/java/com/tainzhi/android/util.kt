package com.tainzhi.android

import java.text.SimpleDateFormat
import java.util.Locale

/**
 * File:     util
 * Author:   tainzhi
 * Created:  2020/12/31 14:07
 * Mail:     QFQ61@qq.com
 * Description:
 */

object Util {
    fun getSystemTime(): String {
        // "YYYY_MM_dd_HH_mm_ss"
        val simpleDateFormat = SimpleDateFormat("MMddHHmmss", Locale.CHINA)
        return simpleDateFormat.format(System.currentTimeMillis())
    }
}
