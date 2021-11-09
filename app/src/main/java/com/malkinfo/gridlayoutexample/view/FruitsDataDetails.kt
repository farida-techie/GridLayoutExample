package com.malkinfo.gridlayoutexample.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.malkinfo.gridlayoutexample.R
import com.malkinfo.gridlayoutexample.model.FruitsData
import com.malkinfo.gridlayoutexample.ui.theme.Purple500

@Composable
fun FruitsDataDetails(data:FruitsData){

    Column(modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column(modifier = Modifier.fillMaxWidth()
            .height(50.dp)
            .background(Purple500),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text ="Fruits Calories and Sugar",
                color = Color.White,
                fontSize =  20.sp,
                fontWeight = FontWeight.Bold
            )

        }
        Spacer(modifier = Modifier.padding(1.dp))
        Image(painter = painterResource(
            id =  when(data.id){
                1L-> R.drawable.apples
                2L -> R.drawable.avocado
                3L -> R.drawable.banana
                4L -> R.drawable.blackberry
                5L -> R.drawable.blueberry
                6L -> R.drawable.cantaloupe
                7L -> R.drawable.cherry
                8L -> R.drawable.grape
                9L -> R.drawable.kiwi
                10L -> R.drawable.orange
                11L -> R.drawable.peach
                12L -> R.drawable.pear
                13L -> R.drawable.pineapple
                14L -> R.drawable.plum
                15L -> R.drawable.raspberry
                16L -> R.drawable.strawberry
                17L -> R.drawable.watemelon
                else -> R.drawable.apples
            }
        ),
            contentDescription = "Grid Image",
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp)),
            alignment = Alignment.Center
        )
        Spacer(modifier = Modifier.padding(10.dp))
        Text(
            text = data.name,
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            color = Color.Black,
            fontSize =  20.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.padding(1.dp))

        Text(
            text = data.desc,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(6.dp),
            color = Color.Black,
            fontSize =  16.sp,
            fontWeight = FontWeight.Normal,


        )
    }



}