package com.example.heliverseassignment.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.heliverseassignment.ui.screens.mainScreens.CompactMainScreen
import com.example.heliverseassignment.ui.screens.mainScreens.ExtendedMainScreen
import com.example.heliverseassignment.ui.utils.WindowInfo
import com.example.heliverseassignment.ui.utils.rememberWindowInfo


@Preview
@Composable
fun MainScreen() {
    val windowInfo= rememberWindowInfo()

    if(windowInfo.screenWidthInfo is WindowInfo.WindowType.Compact){
        CompactMainScreen()
    }
    else{
        ExtendedMainScreen()
    }
}