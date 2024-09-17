package com.geracomdev.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.geracomdev.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardAppTheme {
                Surface {
                    BusinessCard(
                        stringResource(R.string.myName),
                        stringResource(R.string.jobTitle),
                        modifier = Modifier
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCard(fullName: String, businessTitle: String, modifier: Modifier) {
    Column(modifier.fillMaxHeight().padding(10.dp), verticalArrangement = Arrangement.Center) {
        Row(modifier.fillMaxWidth(),horizontalArrangement = Arrangement.Center) {

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.selfie),
                    contentDescription = "Profile Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(150.dp)
                        .clip(
                            CircleShape
                        )
                )
                Text(fullName, fontSize = 24.sp)
                Text(businessTitle, fontStyle = FontStyle.Italic)
            }
        }
        Row(modifier.paddingFromBaseline(top = 50.dp).fillMaxWidth()) {
            Column {
                Row(modifier.padding(vertical = 5.dp)) {
                    Column(modifier.weight(1f), horizontalAlignment = Alignment.End) {
                        Icon(Icons.Default.Phone, contentDescription = "Phone")
                    }
                    Column(modifier.weight(2f).padding(start = 5.dp)) {
                        Text("(806)317-6030")
                    }
                }
                Row(modifier.padding(vertical = 5.dp)){
                    Column(modifier.weight(1f), horizontalAlignment = Alignment.End) {
                        Icon(Icons.Default.AccountCircle, contentDescription = "Social Media")
                    }
                    Column(modifier.weight(2f).padding(start = 5.dp)) {
                        Text("@CamorlingaJr")
                    }
                }
                Row(modifier.padding(vertical = 5.dp)) {
                    Column(modifier.weight(1f), horizontalAlignment = Alignment.End) {
                        Icon(Icons.Default.Email, contentDescription = "Email")
                    }
                    Column(modifier.weight(2f).padding(start = 5.dp)) {
                        Text("gercamjr.dev@gmail.com")
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ProfileBlockPreview() {
    BusinessCardAppTheme {
        BusinessCard("Gerardo Camorlinga Jr", "Test Test", modifier = Modifier)
    }
}