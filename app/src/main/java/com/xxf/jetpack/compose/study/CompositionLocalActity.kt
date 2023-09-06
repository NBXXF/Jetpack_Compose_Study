package com.xxf.jetpack.compose.study

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider


/**
 * @ProjectName: Jetpack_Compose_Study
 * @Package: com.xxf.jetpack.compose.study
 * @ClassName: CompositionLocalActity
 * @Description:
 * @Author: xuanyouwu@163.com 17611639080
 * @Date: 2023/9/6 15:25
 */
class CompositionLocalActity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CompositionLocalExample();
        }
    }

    @Composable
    fun CompositionLocalExample(){
        MaterialTheme {
            Column {
                Text("Uses MaterialTheme's provided alpha")
                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                    Text("Medium value provided for LocalContentAlpha")
                    Text("This Text also uses the medium value")
                    CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.disabled) {
                        DescendantExample()
                    }
                }
            }
        }
    }

    @Composable
    fun DescendantExample() {
        // CompositionLocalProviders also work across composable functions
        Text("This Text uses the disabled alpha now")
    }
}