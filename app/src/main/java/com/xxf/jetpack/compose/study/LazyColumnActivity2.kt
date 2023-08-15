package com.xxf.jetpack.compose.study

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class LazyColumnActivity2: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                MyLazyList()
            }
        }
    }

    @Composable
    fun MyLazyList(){
        val state= rememberLazyListState();
        val items= listOf<Item>(Item("张三","我是中国的"),
            Item("李四","我是中国的"),
            Item("王武","我是中国的"))
        LazyColumn(state=state){
            items(items){
                MyItem(item = it)
            }
        }
    }

    @Composable
    @Preview
    fun MyItemPreview(){
        MyItem(item = Item("张三","我是中国的"))
    }
    
    @Composable
    fun MyItem(item:Item){
        return Row(modifier = Modifier.padding(10.dp)) {
            Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription ="这是头显",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .border(width = 2.dp, color = MaterialTheme.colorScheme.secondary, shape = CircleShape)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(text = item.name);
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = item.desc);
            }
        }
    }

     class Item(val name:String,val desc:String){
    }

}