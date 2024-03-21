package com.example.vortex.Koneksi

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.vortex.R
import com.example.vortex.Start.User
import com.example.vortex.data.FirebaseAuthManager

@Composable
fun Koneksi(navController: NavController) {
    val context = LocalContext.current
    val firebaseAuthManager = FirebaseAuthManager(context)
    var users by remember { mutableStateOf<List<User>>(emptyList()) }

    LaunchedEffect(key1 = Unit) {
        firebaseAuthManager.fetchUsers { fetchedUsers ->
            users = fetchedUsers
        }
    }

    Scaffold(
        topBar = { TopKoneksi() },
        content = { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                RekomendasiColumn(users = users)
            }
        }
    )
}

@Composable
fun TopKoneksi() {
    Surface (shadowElevation = 8.dp){
        Row(
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth()
                .padding(end = 15.dp)
        ) {
            Button(
                modifier = Modifier
                    .height(30.dp)
                    .width(88.dp)
                    .align(alignment = Alignment.CenterVertically),
                onClick = { /*TODO*/ },
//                shape = RoundedCornerShape(7.dp)
            ) {
                Text(
//                    modifier = Modifier.align(alignment = Alignment.CenterVertically),
                    text = "Filter",
                    fontSize = 12.sp)
                Icon(imageVector = Icons.Default.List, contentDescription = "Filter")
            }
        }
    }
}

@Composable
fun RecommendationRow(users: List<com.example.vortex.Start.User>) {
    LazyRow(
        modifier = Modifier.padding(horizontal = 10.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ){
        items(users) { user ->
            TerverifikasiItem(user = user)
        }
    }
}

@Composable
fun UserProfileImage(profilePictureUrl: String?) {
    val placeholder = painterResource(id = R.drawable.megachan)
    val painter = if (profilePictureUrl.isNullOrEmpty()) {
        placeholder
    } else {
        rememberAsyncImagePainter(model = profilePictureUrl, placeholder = placeholder)
    }

    Image(
        painter = painter,
        contentDescription = "Profile Picture",
        modifier = Modifier
            .size(75.dp)
            .clip(CircleShape),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun TerverifikasiItem(user: com.example.vortex.Start.User) {
    Card(
        modifier = Modifier
            .width(200.dp)
            .height(200.dp)
            .clickable { /*TODO*/ }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            Box(modifier = Modifier) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(bottom = 8.dp)
                ) {
                    UserProfileImage(profilePictureUrl = user.profilePictureUrl)
                    Spacer(modifier = Modifier.width(8.dp))
                    Column(
                        modifier = Modifier
                            .padding(start = 8.dp),
                    ) {
                        Text(
                            text = user.name,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                        RoleButton(
                            role = user.role,
                            backgroundColor = Color.LightGray,
                            textColor = Color.Black
                        )

                        RoleButton(
                            role = user.bidang,
                            backgroundColor = Color.LightGray,
                            textColor = Color.Black
                        )
                    }
                }
            }
            Text(
                text = user.description,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.weight(1f))
            LocationStyle(
                location = user.location,
                backgroundColor = Color.Black,
                textColor = Color.White
            )
        }
    }
}

@Composable
fun RekomendasiColumn(users: List<com.example.vortex.Start.User>) {
    LazyColumn(
        modifier = Modifier.padding(bottom = 50.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        item { BackgroundImg() }
        item { HeaderText(text = "Terverifikasi") }
        item { RecommendationRow(users = users) }
        item { HeaderText(text = "Rekomendasi") }
        items(users) { user ->
            RekomendasiItem(user = user)
        }
    }
}

@Composable
fun RekomendasiItem(user: com.example.vortex.Start.User) {
    Card(
        modifier = Modifier
            .height(140.dp)
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 5.dp)
            .clickable { /*TODO*/ },
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        Row(
            modifier = Modifier.padding(all = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            UserProfileImage(profilePictureUrl = user.profilePictureUrl)
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp)
            ) {
                Text(
                    text = user.name,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 16.sp
                )
                RoleButton(
                    role = user.role,
                    backgroundColor = Color.LightGray,
                    textColor = Color.Black
                )
                Text(
                    text = user.description,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 12.sp
                )

                LocationStyle(
                    location = user.location,
                    backgroundColor = Color.Black,
                    textColor = Color.White
                )
            }

        }
    }
}

@Composable
fun RoleButton(role: String, backgroundColor: Color, textColor: Color) {
    Surface(
        tonalElevation = 2.dp,
        shape = RoundedCornerShape(50)
    ) {
        Box(
            modifier = Modifier
                .background(backgroundColor)
                .padding(5.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = role,
                color = textColor,
                textAlign = TextAlign.Center,
                fontSize = 12.sp
            )
        }
    }
}

@Composable
fun LocationStyle(location: String, backgroundColor: Color, textColor: Color) {
    Surface(
        modifier = Modifier.padding(4.dp),
        tonalElevation = 2.dp,
        shape = RoundedCornerShape(50)
    ) {
        Box(
            modifier = Modifier
                .background(backgroundColor)
                .padding(vertical = 4.dp, horizontal = 16.dp)
                .width(130.dp)
                .height(20.dp),
            contentAlignment = Alignment.BottomStart,
        ) {
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    tint = Color.White,
                    contentDescription = "Location")
                Text(
                    text = location,
                    color = textColor,
                    textAlign = TextAlign.Left,
                    fontSize = 12.sp
                )
            }
        }
    }
}

@Composable
fun BackgroundImg() {
    Image(
        painter = painterResource(id = R.drawable.bg_koneksikoneksi),
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth(),
        contentScale = ContentScale.FillWidth
    )
}

@Composable
fun HeaderText(text: String) {
    Text(
        text = text,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .padding(start = 16.dp, top = 8.dp, bottom = 8.dp)
    )
}