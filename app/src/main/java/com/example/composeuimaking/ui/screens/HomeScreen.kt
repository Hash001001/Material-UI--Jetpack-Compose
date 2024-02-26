package com.example.composeuimaking.ui.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeuimaking.R
import com.example.composeuimaking.ui.enitites.BottomMenu
import com.example.composeuimaking.ui.enitites.Feature
import com.example.composeuimaking.ui.theme.AquaBlue
import com.example.composeuimaking.ui.theme.Beige2
import com.example.composeuimaking.ui.theme.BlueViolet1
import com.example.composeuimaking.ui.theme.ButtonBlue
import com.example.composeuimaking.ui.theme.DarkerButtonBlue
import com.example.composeuimaking.ui.theme.DeepBlue
import com.example.composeuimaking.ui.theme.LightGreen1
import com.example.composeuimaking.ui.theme.LightRed
import com.example.composeuimaking.ui.theme.TextWhite

@Composable
fun HomeScreen() {

    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize()
    ) {
        Column {
            GreetingSection()

            ChipsSections(listOf("Sweet sleep", "Insomnia", "Depression"))

            DailyMeditationSection()

            FeaturedSection(
                featureList = listOf(
                    Feature(
                        "Sleep meditation", R.drawable.ic_headphone, ButtonBlue
                    ),
                    Feature(
                        "Tips for sleeping", R.drawable.ic_videocam, BlueViolet1
                    ),
                    Feature(
                        "Night island", R.drawable.ic_moon, LightGreen1
                    ),
                    Feature(
                        "Calming sounds", R.drawable.ic_music, Beige2
                    )
                )
            )
        }

        BottomNavigationSection(
            menuItem = listOf(
                BottomMenu("Home", R.drawable.ic_home),
                BottomMenu("Meditate", R.drawable.ic_bubble),
                BottomMenu("Sleep", R.drawable.ic_moon),
                BottomMenu("Music", R.drawable.ic_music),
                BottomMenu("Profile", R.drawable.ic_profile),
            ), modifier = Modifier.align(Alignment.BottomCenter)
        )

        
    }
}


@Composable
fun GreetingSection() {

    Spacer(modifier = Modifier.height(12.dp))
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(
            verticalArrangement = Arrangement.Center, modifier = Modifier.padding(start = 4.dp)
        ) {
            Text(
                text = "Good Morning, Philipp", style = MaterialTheme.typography.headlineLarge
            )
            Text(
                text = "We wish you have a good day!", style = MaterialTheme.typography.bodyLarge
            )
        }

        Icon(
            painter = painterResource(id = R.drawable.ic_search),
            tint = Color.White,
            contentDescription = "Search",
            modifier = Modifier
                .size(36.dp)
                .padding(8.dp)
        )
    }

}


@Composable
fun ChipsSections(
    chips: List<String>
) {
    var selectedChip by remember {
        mutableStateOf(0)
    }

    LazyRow() {
        items(chips.size) {
            Box(

                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                    .clickable {
                        selectedChip = it
                    }
                    .clip(RoundedCornerShape(13.dp))
                    .background(if (selectedChip == it) ButtonBlue else DarkerButtonBlue)
                    .padding(start = 15.dp, end = 15.dp, top = 10.dp, bottom = 10.dp)) {
                Text(text = chips[it], color = TextWhite)
            }
        }
    }
}

@Composable
fun DailyMeditationSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color = LightRed)
            .padding(horizontal = 15.dp, vertical = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = "Daily Thought", style = MaterialTheme.typography.headlineLarge
            )
            Text(
                text = "Meditation . 3-10 min",
                style = MaterialTheme.typography.bodyLarge,
                color = TextWhite
            )
        }
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(color = ButtonBlue)
                .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_play),
                tint = Color.White,
                contentDescription = "Search",
                modifier = Modifier
                    .size(16.dp)
                    .align(Alignment.Center)
            )
        }
    }
}

@Composable
fun FeaturedSection(
    featureList: List<Feature>
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "Featured",
            color = TextWhite,
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(15.dp)
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),

        ) {
            items(featureList.size) {
                FeatureItem(feature = featureList[it])
            }
        }
    }
}

@Composable
fun FeatureItem(
    feature: Feature
) {
    BoxWithConstraints(
        modifier = Modifier
            .padding(7.5.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(10.dp))
            .background(color = feature.bgColor)
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {

            Text(
                text = feature.title,
                style = MaterialTheme.typography.headlineMedium,
                lineHeight = 26.sp,
                color = TextWhite,
                modifier = Modifier.align(Alignment.TopStart)
            )

            Icon(
                painter = painterResource(id = feature.icon),
                contentDescription = "",
                modifier = Modifier.align(Alignment.BottomStart),
                tint = Color.White
            )

            Text(
                text = "Start",
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .clip(RoundedCornerShape(12.dp))
                    .background(color = DeepBlue)
                    .padding(horizontal = 14.dp, vertical = 5.dp)
                    .clickable {
                        //handle click here
                    }

            )

        }

    }
}


@Composable
fun BottomNavigationSection(
    menuItem: List<BottomMenu>,
    modifier: Modifier = Modifier,
    activeHiglightColor: Color = ButtonBlue,
    activeHiglLightTextCOlor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    initalSelectedItem: Int = 0
) {
    var selectedItem by remember {
        mutableStateOf(initalSelectedItem)
    }

    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(DeepBlue)


    ) {
        menuItem.forEachIndexed { index, bottomMenu ->
            BottomMenuItem(
                item = bottomMenu,
                isSelected = selectedItem == index,
                activeHiglightColor = activeHiglightColor,
                activeHiglLightTextCOlor = activeHiglLightTextCOlor,
                inactiveTextColor = inactiveTextColor,
                onItemClick = {
                    selectedItem = index
                }
            )
        }
    }
}


@Composable
fun BottomMenuItem(
    item: BottomMenu,
    isSelected: Boolean = false,
    activeHiglightColor: Color = ButtonBlue,
    activeHiglLightTextCOlor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    onItemClick: () -> Unit,
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable {
            onItemClick()
        }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(if (isSelected) activeHiglightColor else Color.Transparent)
                .padding(10.dp)

        ) {
            Icon(
                painter = painterResource(id = item.icon),
                contentDescription = item.title,
                tint = if (isSelected) activeHiglLightTextCOlor else inactiveTextColor,
                modifier = Modifier.size(20.dp)
            )
        }

        Text(
            text = item.title,
            color = if (isSelected) activeHiglightColor else inactiveTextColor
        )

    }

}

@Composable
@Preview(showBackground = true)
fun HomeScreenPreview() {
    HomeScreen()
}