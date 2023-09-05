package com.xxf.jetpack.compose.study

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


/**
 * @ProjectName: Jetpack_Compose_Study
 * @Package: com.xxf.jetpack.compose.study
 * @ClassName: StateActivity
 * @Description:
 * @Author: xuanyouwu@163.com 17611639080
 * @Date: 2023/9/4 17:53
 */
class StateActivity: ComponentActivity() {
    val vm:MyViewModel by viewModels<MyViewModel>();
    val s= androidx.compose.runtime.mutableStateOf("");
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                //对于输入框如果不记录 就会一直输入不了,所以采取提升状态 方式将mutableStateOf升级为activity的成员
                test2(s.value) {
                    s.value = it;
                };

                //提升状态采用remember函数记录
                test();
                
                for (i in 0 until 10){
                    Text(text = i.toString())
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun test(){
        val (text,setText)= remember {
            mutableStateOf("");
        }
        Row {
            TextField(value =text , onValueChange ={
                setText(it)
            },
                    modifier = Modifier
                        .background(Color.Green))
            Button(onClick = {
                setText("");
            }, enabled = text.isNotBlank()) {
                Text(text = "搜索")
            }
        }
    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun test2(value:String,onTextChange:(String)->Unit){
        Row {
            TextField(value =value , onValueChange =onTextChange,
                modifier = Modifier
                    .background(Color.Green))
            Button(onClick = {
                onTextChange("");
            }, enabled = value.isNotBlank()) {
                Text(text = "搜索")
            }
        }
    }

    class MyViewModel: ViewModel() {
        val state= MutableLiveData<Boolean>(true);
    }
}