package com.example.vortex.Profil

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.vortex.R


@Composable
fun EditProfile(navController: NavController) {
    val bannerUri = remember { mutableStateOf<Uri?>(null) }
    val profilePictureUri = remember { mutableStateOf<Uri?>(null) }

    val bannerPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri: Uri? ->
            bannerUri.value = uri
        }
    )

    val profilePictureLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri: Uri? ->
            profilePictureUri.value = uri
        }
    )

    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())) {
        TopBar(topText = "Ubah Profil") {
            // Navigation back action
        }
        ContentProfile(bannerUri = bannerUri.value, profilePictureUri = profilePictureUri.value, onBannerClick = {
            bannerPickerLauncher.launch("image/*")
        }, onProfilePictureClick = {
            profilePictureLauncher.launch("image/*")
        })
    }
}


@Composable
fun TopBar(topText: String, onClickAction: () -> Unit) {
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
                    .clickable { onClickAction }
            )
            Text(
                text = topText,
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
fun ContentProfile(bannerUri: Uri?, profilePictureUri: Uri?, onBannerClick: () -> Unit, onProfilePictureClick: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize().background(Color.White)) {
        // Banner
        Box(modifier = Modifier.height(127.dp).fillMaxWidth()) {
            if (bannerUri != null) {
                Image(
                    painter = rememberAsyncImagePainter(bannerUri),
                    contentDescription = "Banner",
                    modifier = Modifier.fillMaxWidth().clickable { onBannerClick() },
                    contentScale = ContentScale.FillWidth
                )
            } else {
                // Default banner view
                Image(
                    painter = painterResource(id = R.drawable.tes1),
                    contentDescription = "Banner",
                    modifier = Modifier.fillMaxWidth().clickable { onBannerClick() },
                    contentScale = ContentScale.FillWidth
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 70.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            // Profile picture
            if (profilePictureUri != null) {
                Image(
                    painter = rememberAsyncImagePainter(profilePictureUri),
                    contentDescription = "Profile Picture",
                    modifier = Modifier.size(120.dp).aspectRatio(1f, matchHeightConstraintsFirst = true).clip(shape = CircleShape).clickable { onProfilePictureClick() }.border(2.dp, Color.White, CircleShape),
                    contentScale = ContentScale.Crop
                )
            } else {
                // Default profile picture view
                Image(
                    painter = painterResource(id = R.drawable.owi),
                    contentDescription = "Profile Picture",
                    modifier = Modifier.size(120.dp).aspectRatio(1f, matchHeightConstraintsFirst = true).clip(shape = CircleShape).clickable { onProfilePictureClick() }.border(2.dp, Color.White, CircleShape),
                    contentScale = ContentScale.Crop
                )
            }
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

