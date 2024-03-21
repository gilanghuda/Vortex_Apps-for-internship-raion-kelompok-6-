package com.example.vortex.Start

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.vortex.Navigation.Screen
import com.example.vortex.R

@Composable
fun ChooseRole(navController: NavController) {
    Box (
        modifier = Modifier
            .fillMaxSize()
    ){
        Image(
            painter = painterResource(id = R.drawable.bg_chooserole),
            contentDescription = null,
            modifier = Modifier.fillMaxSize())
        Column (modifier = Modifier
            .fillMaxSize()
            .padding(25.dp)
        ){
            Spacer(modifier = Modifier.height(75.dp))
            TextComponent(textValue = "Pilih Role Anda!", size = 32.sp)
            Spacer(modifier = Modifier.height(10.dp))
            TextComponent(textValue = "Tentukan role anda dalam aplikasi Vortex dan berikan kontribusi pada pembangunan Indonesia", size = 16.sp)
            Spacer(modifier = Modifier.height(30.dp))
            Card(
                modifier = Modifier
                    .height(140.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 5.dp)
                    .clickable { navController.navigate("${Screen.SignInRoute.route}/Investor")},
                shape = RoundedCornerShape(10.dp),
                elevation = CardDefaults.cardElevation(5.dp)
            ) {
                Row(
                    modifier = Modifier
                        .padding(all = 10.dp)
                        .fillMaxHeight(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.image_investor),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(100.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 8.dp)
                    ) {
                        Text(
                            text = "Investor",
                            fontWeight = FontWeight.Bold,
                            fontSize = 25.sp
                        )
                        Text(
                            text = "Investasikan modal Anda di berbagai peluang dan raih keuntungan jangka panjang",
                            fontSize = 12.sp
                        )
                    }

                }
            }
            Card(
                modifier = Modifier
                    .height(140.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 5.dp)
                    .clickable { navController.navigate("${Screen.SignInRoute.route}/Pengusaha") },
                shape = RoundedCornerShape(10.dp),
                elevation = CardDefaults.cardElevation(5.dp)
            ) {
                Row(
                    modifier = Modifier
                        .padding(all = 10.dp)
                        .fillMaxHeight(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.image_pengusaha),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(100.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 8.dp)
                    ) {

                        Text(
                            text = "Pengusaha",
                            fontWeight = FontWeight.Bold,
                            fontSize = 25.sp
                        )
                        Text(
                            text = "Ubah ide cemerlang menjadi kenyataan dan ciptakan produk/layanan yang bermanfaat",
                            fontSize = 12.sp
                        )
                    }

                }
            }
        }
    }
}

