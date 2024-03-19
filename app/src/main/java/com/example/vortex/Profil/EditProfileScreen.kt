package com.example.vortex.Profil

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vortex.R

@Preview
@Composable
fun editprofileprev() {
    EditProfile()
}

@Composable
fun EditProfile() {
    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())) {
        TopBar()
        ContentProfile()
    }
}

@Composable
fun TopBar() {
    Surface (shadowElevation = 5.dp){
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth()
        ) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowLeft,
                contentDescription = "Back",
                modifier = Modifier
                    .size(40.dp)
                    .clickable { }
            )
            Text(
                text = "Ubah Profil",
                fontSize = 24.sp,
                modifier = Modifier
//                    .weight(1f)
                    .fillMaxWidth(1f),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun ContentProfile() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ){
        Box(modifier = Modifier
            .height(127.dp)
            .fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.img_1),
                contentDescription = "Banner",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )
        }

        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 70.dp),
            horizontalAlignment = Alignment.CenterHorizontally
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
                    .height(48.dp)
                    .padding(vertical = 8.dp),
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(7.dp)
            ) {
                Text(
                    text = "Simpan Perubahan",
                    fontSize = 12.sp)
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Nama",
                fontSize = 12.sp,
                color = Color.Blue
            )
            
            TransparentTextField(labelValue = "Nama", textValue = "Yusrizal")
            Divider()

            TransparentTextField(labelValue = "Email", textValue = "yusrizalharits@gmail.com")
            Divider()

            TransparentTextField(labelValue = "Role", textValue = "Ossss")
            Divider()

            TransparentTextField(labelValue = "Nama Perusahaan", textValue = "PT. Mencari Cinta Sejati")
            Divider()

            TransparentTextField(labelValue = "Bidang", textValue = "Bidang")
            Divider()

            TransparentTextField(labelValue = "Lokasi", textValue = "Malang raya")
            Divider()

            TransparentTextField(labelValue = "Deskripsi", textValue = "Intan Jaya Bakery adalah produsen roti tawar unggulan, menawarkan produk berkualitas tinggi dengan rasa lezat dan tekstur sempurna. Kami berkomitmen pada kualitas, kebersihan, dan inovasi, dengan beragam varian roti tawar untuk memenuhi kebutuhan pelanggan. ")
            Divider()



            Text(
                text = "Upload Gambar Pendukung",
                fontSize = 10.sp,
                color = Color.Blue
            )
            Box(
                modifier = Modifier
                    .padding(bottom = 30.dp)
                    .height(130.dp)
                    .width(320.dp)
                    .border(2.dp, color = Color.Blue, RoundedCornerShape(14.dp))
            ){

            }
        }
    }
}

@Composable
fun ProfileTextField(
    label: String,
    value: String,
    height: Dp = 56.dp
) {

}

@Composable
fun DropdownProfileField(
    label: String,
    options: List<String>) {
    val expanded = remember { mutableStateOf(false) }
    val selectedIndex = remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = label,
            fontSize = 10.sp,
            color = Color.Blue,
            modifier = Modifier.align(Alignment.Start)
        )

        Spacer(modifier = Modifier.height(4.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .border(1.dp, Color.Black, RoundedCornerShape(8.dp))
                .clickable { expanded.value = true }
        ) {
            Text(
                text = options[selectedIndex.value],
                modifier = Modifier
                    .padding(start = 16.dp)
                    .align(Alignment.CenterStart)
            )
        }
    }
}
