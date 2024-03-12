package com.example.vortex.Profil

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vortex.R


@Composable
fun ProfileScreen() {

    Column (
        modifier = Modifier.fillMaxSize()
    ){
        Spacer(modifier = Modifier.height(20.dp))
        ProfileBar(
            name = "Budi Susanto Warhamto",
            email = "budisusantowarhammto@gmail.com",
        )
        Spacer(modifier = Modifier.height(35.dp))
        SettingBox(modifier = Modifier.align(Alignment.CenterHorizontally))
    }
}


@Composable
fun ProfileBar(
    name: String,
    email: String,
    modifier: Modifier = Modifier
) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 35.dp)
            .clickable { }
    ){
        RoundImage(
            image = painterResource(id = R.drawable.megachan),
            modifier = Modifier.weight(2f)
        )
        Spacer(modifier = Modifier.width(22.dp))
        Box(
            modifier = Modifier
                .align(alignment = Alignment.CenterVertically)
                .weight(5f)
        ){
            Column(horizontalAlignment = Alignment.Start) {
                Text(
                    text = name,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Left
                )
                Spacer(modifier = Modifier.height(1.dp))
                Text(
                    text = email,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Left
                )
            }
        }
        Icon(
            imageVector = Icons.Default.KeyboardArrowRight,
            tint = Color.Gray,
            contentDescription = "Edit Profile",
            modifier = Modifier
                .weight(2f)
                .size(35.dp)
                .clickable { }
            )
    }
}

@Composable
fun RoundImage(
    image: Painter,
    modifier: Modifier = Modifier
) {
    Image(
        painter = image,
        contentScale = ContentScale.Crop,
        contentDescription = null,
        modifier = modifier
            .size(75.dp)
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .clip(shape = CircleShape)
    )
}

@Composable
fun SettingBox(
    modifier: Modifier = Modifier
) {
   Box(
       contentAlignment = Alignment.CenterStart,
       modifier = Modifier
           .padding(horizontal = 25.dp)
//           .clip(RoundedCornerShape(16.dp))
//           .shadow(1.dp)
           .border(width = 1.dp, color = Color.LightGray, shape = RoundedCornerShape(16.dp))


   ) {
       Column(
           verticalArrangement = Arrangement.SpaceAround,
           modifier = Modifier.padding(10.dp)
       ) {
           RowSetting(icon = painterResource(id = R.drawable.ic_tersimpan), textDescription = "Tersimpan")
           RowSetting(icon = painterResource(id = R.drawable.ic_setting), textDescription = "Pengaturan")
           RowSetting(icon = painterResource(id = R.drawable.ic_support), textDescription = "Pusat Bantuan")
           RowSetting(icon = painterResource(id = R.drawable.ic_info), textDescription = "Tentang")
           RowSetting(icon = painterResource(id = R.drawable.ic_logout), textDescription = "Log Out")
       }
   }
}

@Composable
fun RowSetting(
    icon: Painter,
    textDescription: String,
) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 5.dp, vertical = 15.dp)
            .clickable { }
    ){
        Icon(
            painter = icon,
            tint = Color.Unspecified,
            contentDescription = null,
            modifier = Modifier
                .weight(2f)
                .size(20.dp)
        )
        Text(
            modifier = Modifier.weight(6f),
            textAlign = TextAlign.Start,
            fontSize = 16.sp,
            text = textDescription

        )
        Icon(
            imageVector = Icons.Default.KeyboardArrowRight ,
            contentDescription = null,
            modifier = Modifier
                .weight(2f),
            tint = Color.Gray,
        )
    }
}