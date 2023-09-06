package com.xxf.jetpack.compose.study

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction


/**
 * @ProjectName: Jetpack_Compose_Study
 * @Package: com.xxf.jetpack.compose.study
 * @ClassName: KeyBoardActivity
 * @Description:
 * @Author: xuanyouwu@163.com 17611639080
 * @Date: 2023/9/5 14:16
 */
class KeyBoardActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            testKeyBoard()
        }
    }

    @OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
    @Composable
    fun testKeyBoard(){
        val keyboardController=LocalSoftwareKeyboardController.current;
        val (text,setText)= rememberSaveable {
            mutableStateOf("");
        }
        TextField(value =text ,
            onValueChange =setText,
            colors = TextFieldDefaults.textFieldColors(containerColor = Color.Yellow),
            maxLines = 1,
            minLines=1,
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = {
                setText("");
                keyboardController?.hide();
            }, onNext = {
                setText("");
                keyboardController?.hide();
            }, onSend = {
                setText("");
                keyboardController?.hide();
            })
        )
    }
}