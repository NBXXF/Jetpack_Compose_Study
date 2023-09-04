package com.xxf.jetpack.compose.study

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet


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
           // MyConstraintLayout()
            DecoupledConstraintLayout()
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


    @Composable
    fun DecoupledConstraintLayout(){
        BoxWithConstraints {
            //横竖屏设置不一样的间距
            val constraints=if(this.maxWidth<this.maxHeight){
                decoupledConstraints(10.dp)
            }else{
                decoupledConstraints(60.dp)
            }
            ConstraintLayout(constraints) {
                Button(onClick = {  }, modifier = Modifier.layoutId("button")) {
                    Text(text = "Button")
                }
                Text(text = "文本", modifier = Modifier.layoutId("text"))
            }
        }
    }

    private fun decoupledConstraints(margin:Dp):ConstraintSet{
        return ConstraintSet{
            val button=createRefFor("button");
            val text=createRefFor("text");
            constrain(button){
                this.top.linkTo(this.parent.top,margin=margin);
            }
            constrain(text){
                this.top.linkTo(button.bottom,margin);
            }
        }
    }
}