package com.xxf.jetpack.compose.study

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class TextActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                Column {
                    showXMLString()
                    showTextColor()
                    showTextSize()
                    showFontWeight()
                    showTextAlign()
                    showTextShadow()
                    showFontFamily()
                    MultipleStylesInText()
                    ParagraphStyleDemo()
                    showMaxLine()
                    showSelectableText()
                    showMutiSelectableText()
                    showClickableText()
                    Spacer(modifier =Modifier.height(300.dp))
                    HelloContent()
                    AnnotatedClickableText()
                }
            }
        }
    }


    @Composable
    fun showXMLString(){
        Text(text = stringResource(id = R.string.app_name))
    }

    @Composable
    fun showTextColor(){
        Text(text = "color", color = Color.Yellow)
    }

    @Composable
    fun showTextSize(){
        Text(text = "fontSize", fontSize =30.sp )
    }

    @Composable
    fun showFontWeight(){
        Text(text = "fontWight", fontWeight = FontWeight.Bold )
    }

    @Composable
    fun showTextAlign(){
        Text(text = "textAlign", textAlign = TextAlign.Center, modifier = Modifier
            .width(150.dp)
            .background(Color.Blue))
    }

    @Composable
    fun showTextShadow(){
        Text(text = "textShadow",
            style = TextStyle(shadow = Shadow(color = Color.Gray,
            offset = Offset(10.0f,10.0f),
            blurRadius=3f)))
    }
    
    @Composable
    fun showFontFamily(){
        Column(modifier = Modifier.padding(10.dp)) {
            Text(text = "FontFamily", fontFamily = FontFamily.Serif)
            Text(text = "FontFamily", fontFamily = FontFamily.SansSerif)
        }
    }

    @Composable
    fun MultipleStylesInText() {
        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.Blue)) {
                    append("H")
                }
                append("ello ")

                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Red)) {
                    append("W")
                }
                append("orld")
            }
        )
    }

    @Composable
    fun ParagraphStyleDemo() {
        Text(
            buildAnnotatedString {
                withStyle(style = ParagraphStyle(lineHeight = 30.sp)) {
                    withStyle(style = SpanStyle(color = Color.Blue)) {
                        append("Hello\n")
                    }
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.Bold,
                            color = Color.Red
                        )
                    ) {
                        append("World\n")
                    }
                    append("Compose")
                }
            }
        , modifier = Modifier.padding(15.dp))
    }

    @Composable
    fun showMaxLine(){
        Box(modifier = Modifier.width(100.dp)) {
            Text("床前明月光,疑是地上双,举头望明月,低头思故乡",
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .padding(15.dp)
                    .background(Color.Gray))
        }
    }

    @Composable
    fun showSelectableText() {
        SelectionContainer {
            Text("支持划选的文字")
        }
    }

    @Composable
    fun showMutiSelectableText() {
        SelectionContainer(modifier = Modifier.padding(10.dp)) {
            Column {
                Text("支持划选的文字第一个")
                DisableSelection {
                    Text("支持划选的文字第二个")
                }
                Text("支持划选的文字第三个")
            }
        }
    }

    @Composable
    fun showClickableText(){
        ClickableText(text = AnnotatedString("这个文字支持点击位置获取"), onClick ={ offset->
            println("===========>点击位置${offset}");
            Toast.makeText(this,"点击未知${offset}",Toast.LENGTH_SHORT);
        })
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun HelloContent() {
        Column(modifier = Modifier.padding(16.dp)) {
            var name by remember { mutableStateOf("") }
            ClickableText(text = AnnotatedString("12445uyyy"), onClick ={
                println("============>clickaleText:$it");
            })
            Text(
                text = "Hello, $name!",
                modifier = Modifier.padding(bottom = 8.dp),
                style = MaterialTheme.typography.bodyMedium
            )
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Name") }
            )
        }
    }

    @Composable
    fun AnnotatedClickableText(){
        val annotatedString= buildAnnotatedString {
            this.append("Click")
            this.pushStringAnnotation(tag = "URL", annotation = "https://developer.android.com");
            this.withStyle(style = SpanStyle(color = Color.Blue,fontWeight=FontWeight.Bold)){
                append("here");
            }
            pop();

        }
        ClickableText(text = annotatedString, onClick ={offset->
            annotatedString.getStringAnnotations(tag = "URL", start =offset, end = offset)
                .firstOrNull()?.let {
                    Log.d("=======>","clickText:"+it.item);
                }
        })
    }

}