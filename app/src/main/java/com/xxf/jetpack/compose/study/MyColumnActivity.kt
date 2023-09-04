package com.xxf.jetpack.compose.study

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.Measurable
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import com.xxf.jetpack.compose.study.ui.theme.Jetpack_Compose_StudyTheme


/**
 * @ProjectName: Jetpack_Compose_Study
 * @Package: com.xxf.jetpack.compose.study.ui.theme
 * @ClassName: MyColumnActivity
 * @Description:
 * @Author: xuanyouwu@163.com 17611639080
 * @Date: 2023/9/4 10:25
 */
class MyColumnActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Jetpack_Compose_StudyTheme {
                MyColumnWidget(modifier = Modifier
                    .padding(10.dp)
                    .background(Color.Yellow)) {
                    Text("第一行",color = Color.Black)
                    Text("第二行",color= Color.Red)
                    Text("第三行",color= Color.Green)
                    Text("第四行",color= Color.Blue)
                }
            }
        }
    }

    @Composable
    fun MyColumnWidget(modifier: Modifier=Modifier,
                       content:@Composable ()->Unit){
        Layout(modifier=modifier,content=content){ measurables, constraints->
            //测量元素
            val placeables = measurables.map {
                it.measure(constraints);
            }

            //布局
            var yPostion=0;
            layout(constraints.maxWidth,constraints.maxHeight) {
                placeables.forEach {
                    it.placeRelative(x=0,y=yPostion);
                    yPostion+=it.height;
                }
            }
        }
    }
}