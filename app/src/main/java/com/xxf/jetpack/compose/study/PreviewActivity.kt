package com.xxf.jetpack.compose.study

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

class PreviewActivity:ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
               Text(text = "xxx");
            }
        }
    }

    @Preview(name = "第一个预览区域")
    @Composable
    fun preview(){
        Text(text="Hello,my name is jack,What's your name");
    }

    @Preview(name = "第二个预览区域")
    @Composable
    fun preview2(){
        Text(text="停车坐爱枫林晚,窗前明月光");
    }
}