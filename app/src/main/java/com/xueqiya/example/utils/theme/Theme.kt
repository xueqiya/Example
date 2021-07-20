package com.xueqiya.example.utils.theme

import androidx.annotation.ColorRes
import androidx.annotation.StyleRes
import com.xueqiya.example.R

enum class Theme(
    val id: Int,
    @StyleRes
    val theme: Int,
    @ColorRes
    val colorRes: Int,
    val colorName: String
) {
    DeepPurple(1, R.style.DeepPurpleTheme, R.color.colorDeepPurplePrimary, "深紫色"),
    Brown(2, R.style.BrownTheme, R.color.colorBrownPrimary, "棕色"),
    Purple(3, R.style.PurpleTheme, R.color.colorPurplePrimary, "紫色"),
    Teal(4, R.style.TealTheme, R.color.colorTealPrimary, "深绿色"),
    Green(5, R.style.GreenTheme, R.color.colorGreenPrimary, "绿色"),
    Pink(6, R.style.PinkTheme, R.color.colorPinkPrimary, "粉红色"),
    Orange(7, R.style.OrangeTheme, R.color.colorOrangePrimary, "橙色"),
    BlueGrey(8, R.style.BlueGreyTheme, R.color.colorBlueGreyPrimary, "蓝灰色"),
    Indigo(9, R.style.IndigoTheme, R.color.colorIndigoPrimary, "靛蓝"),
    Cyan(10, R.style.CyanTheme, R.color.colorCyanPrimary, "青色"),
    LightGreen(11, R.style.LightGreenTheme, R.color.colorLightGreenPrimary, "浅绿色"),
    Lime(12, R.style.LimeTheme, R.color.colorLimePrimary, "石灰"),
    DeepOrange(13, R.style.DeepOrangeTheme, R.color.colorDeepOrangePrimary, "深橙"),
    Blue(14, R.style.BlueTheme, R.color.colorBluePrimary, "蓝色"),
    Blank(16, R.style.BlankTheme, R.color.colorBlankPrimary, "黑色");
}