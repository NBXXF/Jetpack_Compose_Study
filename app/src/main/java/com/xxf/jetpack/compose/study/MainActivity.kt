package com.xxf.jetpack.compose.study

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.xxf.jetpack.compose.study.ui.theme.Jetpack_Compose_StudyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Jetpack_Compose_StudyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ListView()
                }
            }
        }
    }

    @Composable
    fun ListView(modifier: Modifier=Modifier){
        val scrollState= rememberScrollState();
        Column(Modifier.verticalScroll(scrollState)) {
            Text(text = "LazyColum",modifier=Modifier.padding(10.dp).clickable {
                this@MainActivity.startActivity(Intent(this@MainActivity,LazyColumnActivity::class.java))
            });
            Text(text = "LazyColum2",modifier=Modifier.padding(10.dp).clickable {
                this@MainActivity.startActivity(Intent(this@MainActivity,LazyColumnActivity2::class.java))
            });
            Text(text = "Text",modifier=Modifier.padding(10.dp).clickable {
                this@MainActivity.startActivity(Intent(this@MainActivity,TextActivity::class.java))
            });
            Text(text = "自定义列表",modifier=Modifier.padding(10.dp).clickable {
                this@MainActivity.startActivity(Intent(this@MainActivity,MyColumnActivity::class.java))
            });
            Text(text = "ConstraintLayout",modifier=Modifier.padding(10.dp).clickable {
                this@MainActivity.startActivity(Intent(this@MainActivity,ConstraintLayoutActivity::class.java))
            });
            Text(text = "状态管理",modifier=Modifier.padding(10.dp).clickable {
                this@MainActivity.startActivity(Intent(this@MainActivity,StateActivity::class.java))
            });
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
            .padding(10.dp)
            .background(color = Color.Yellow, shape = RoundedCornerShape(4.dp))
            .clickable {
                Log.d("========>", "点击了");
            }
    )
}





@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Jetpack_Compose_StudyTheme {
        Greeting("Android")
    }
}
