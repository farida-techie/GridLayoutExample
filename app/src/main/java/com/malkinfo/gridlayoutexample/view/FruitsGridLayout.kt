package com.malkinfo.gridlayoutexample.view

import android.content.Context
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.malkinfo.gridlayoutexample.R
import com.malkinfo.gridlayoutexample.model.FruitsData
import com.malkinfo.gridlayoutexample.ui.theme.Purple500

@ExperimentalFoundationApi
@Composable
fun FruitGrid(navController : NavController){

    val context = LocalContext.current
    val dataFileString = getJsonDataFromAsset(context,"FruitsList.json")
    val gson = Gson()
    val gridSampleType = object :TypeToken<List<FruitsData>>(){}.type
    val fruitData : List<FruitsData> = gson.fromJson(dataFileString,gridSampleType)

    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(color = Purple500)
            .padding(6.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text ="Fruits Calories and Sugar",
                color = Color.White,
                fontSize =  20.sp,
                fontWeight = FontWeight.Bold
            )
        }
        LazyVerticalGrid(
            cells = GridCells.Fixed(3),
          modifier = Modifier.padding(10.dp)
        ){
            items(fruitData){data->
                FruitDataGridItem(data,navController)

            }

        }

    }



}

@Composable
fun FruitDataGridItem(data:FruitsData,navController :NavController){

    Card(modifier = Modifier
        .clickable {
            val itemVal = Gson().toJson(data)
            navController.navigate("grid_detail/$itemVal")
        }
        .padding(10.dp)
        .fillMaxSize(),
        elevation =  5.dp,
        shape = RoundedCornerShape(5.dp)
    ) {
        Column(modifier = Modifier) {
            Image(painter = painterResource(
                id =  when(data.id){
                   1L->R.drawable.apples
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
                    .fillMaxSize()
                    .align(Alignment.CenterHorizontally)
                    .clip(RoundedCornerShape(5.dp)),
                alignment = Alignment.Center
            )
            Spacer(modifier = Modifier.padding(3.dp))
            Text(
                text = data.name,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                fontSize =  15.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.padding(1.dp))
            Text(
                text = data.desc,
                modifier = Modifier
                    .padding(7.dp,0.dp,0.dp,20.dp)
                ,
                fontSize =  13.sp,
                fontWeight = FontWeight.Normal,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis

            )


        }

    }



}

fun getJsonDataFromAsset(context: Context, data: String):String {
    return context.assets.open(data).bufferedReader().use { it.readText() }

}
