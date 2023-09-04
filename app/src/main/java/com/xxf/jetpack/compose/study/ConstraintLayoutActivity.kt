package com.xxf.jetpack.compose.study

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout


/**
 * @ProjectName: Jetpack_Compose_Study
 * @Package: com.xxf.jetpack.compose.study
 * @ClassName: ConstraintLayoutActivity
 * @Description:
 * @Author: xuanyouwu@163.com 17611639080
 * @Date: 2023/9/4 13:50
 */
class ConstraintLayoutActivity: ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyConstraintLayout()
        }
    }
    @Composable
    fun MyConstraintLayout(){
        ConstraintLayout {
            //用createRefs 创建组件的引用

            //用Modifier.constrainAs(xxx)进行连接赋值
            val (button,text)=createRefs();
            Button(onClick = {  }, modifier = Modifier.constrainAs(button){
                this.top.linkTo(parent.top, margin = 10.dp);
            }) {
                Text(text = "Button")
            }

            Text(text = "文本", modifier = Modifier.constrainAs(text){
                this.top.linkTo(button.bottom, margin = 10.dp);
            })
        }
    }

}