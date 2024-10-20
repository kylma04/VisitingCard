package com.example.visitingcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.visitingcard.ui.theme.VisitingCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VisitingCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

val customFontFamily = FontFamily(
    Font(R.font.bricolage_grotesque_bold, FontWeight.Bold),
    Font(R.font.bricolage_grotesque_regular, FontWeight.Normal)
)

@Composable
fun MyRow(text: String, icon: ImageVector){
    Row { Icon(
        icon,
        contentDescription = stringResource(id = R.string.email_content_desc),
        modifier = Modifier.padding(end = 8.dp)
    )
        Text(
            text = text,
            fontFamily = customFontFamily
        ) }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally){
        Spacer(modifier = Modifier.size(80.dp))
        Column(horizontalAlignment = Alignment.CenterHorizontally){
            Image(painter = painterResource(R.drawable.images), contentDescription = "Image principale", modifier = Modifier.size(200.dp).clip(CircleShape))
            Text(text = "SAOURE Kouamé Teddy", fontWeight = FontWeight.Bold, fontSize = 28.sp, fontFamily = customFontFamily)
            Text(text = "Junior Fullstack Developer", fontSize = 18.sp, fontFamily = customFontFamily)
        }
        Spacer(modifier = Modifier.size(40.dp))
        Column{
            MyRow("+225 07 080 629 82", Icons.Rounded.Call)
            MyRow("saoured11@gmail.com", Icons.Rounded.Email)
            MyRow("Abidjan, Port-bouet", Icons.Rounded.LocationOn)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    VisitingCardTheme {
        Greeting()
    }
}