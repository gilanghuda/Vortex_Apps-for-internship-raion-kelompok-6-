package com.example.vortex.Koneksi

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vortex.Profil.RowSetting
import com.example.vortex.Profil.TopBar
import com.example.vortex.R
import com.example.vortex.Start.TextComponent

@Composable
fun DetailKoneksi() {
    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())) {
        TopBar(topText = "Profil"){
//            navController.popBackStack()
        }
//        ContentProfile()
    }
}

@Composable
fun contentDetail() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
//        Box(
//            modifier = Modifier
//                .height(127.dp)
//                .fillMaxWidth()
//        ) {

            Image(
                painter = painterResource(id = R.drawable.img_1),
                contentDescription = "Banner",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(127.dp),
                contentScale = ContentScale.FillWidth
            )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 60.dp),
//            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row (
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.Bottom,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
            ){
                Image(
                    painter = painterResource(id = R.drawable.owi),
                    contentDescription = "Profile Picture",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(120.dp)
                        .aspectRatio(1f, matchHeightConstraintsFirst = true)
                        .clip(shape = CircleShape)
                        .border(2.dp, Color.White, CircleShape)
                )

                Button(
                    modifier = Modifier
                        .height(25.dp)
                        .width(88.dp),
                    onClick = { /*TODO*/ },
//                shape = RoundedCornerShape(7.dp)
                ) {
                    Text(
//                    modifier = Modifier.align(alignment = Alignment.CenterVertically),
                        text = "Ikuti",
                        fontSize = 12.sp)
                    Icon(imageVector = Icons.Default.List, contentDescription = "Filter")
                }

                Button(
                    modifier = Modifier
                        .height(30.dp)
                        .width(88.dp),
                    onClick = { /*TODO*/ },
//                shape = RoundedCornerShape(7.dp)
                ) {
                    Text(
//                    modifier = Modifier.align(alignment = Alignment.CenterVertically),
                        text = "Filter",
                        fontSize = 12.sp)
                    Icon(imageVector = Icons.Default.List, contentDescription = "Pesan")
                }

            }

//            TextComponent(textValue = "Afids Hakk"/*FirebaseAuth.getInstance().currentUser?.displayName.toString()*/, size = 20.sp)
            TextComponent(textValue = "Role", size = 16.sp)
            TextComponent(textValue = "177 Koneksi", size = 12.sp)
            Text(
                text = "Username",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 20.sp,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Bold ,
                ),
                textAlign = TextAlign.Center
            )

            }

        }
    }
//}

@Composable
fun userDetailKoneksi() {
    Column {
        Text(
            text = "Detail",
            color = Color.Black,
            style = TextStyle(
                fontSize = 20.sp,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Bold)
            )
        RowSetting(icon = painterResource(id = R.drawable.ic_perusahaan), textDescription = "Perusahaan nama" )
    }
}

@Preview
@Composable
private fun DetailKonPrev() {
    contentDetail()
}

