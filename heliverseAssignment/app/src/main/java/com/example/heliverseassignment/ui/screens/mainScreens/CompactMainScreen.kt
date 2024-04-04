package com.example.heliverseassignment.ui.screens.mainScreens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.heliverseassignment.R
import com.example.heliverseassignment.ui.theme.PinkDark
import com.example.heliverseassignment.ui.theme.PinkLight
import com.example.heliverseassignment.ui.utils.WindowInfo
import com.example.heliverseassignment.ui.utils.rememberWindowInfo


@Preview
@Composable
fun CompactMainScreen() {

    val windowInfo = rememberWindowInfo()
    Box(modifier = Modifier.fillMaxSize()) {

        Image(
            painter = painterResource(id = R.drawable.img_bg),
            contentDescription = "",
            modifier = Modifier.fillMaxHeight(),
            contentScale = ContentScale.FillHeight
        )
        Column(
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier
                .fillMaxSize()
                .zIndex(1f),
            horizontalAlignment = Alignment.Start
        ) {
            Box(
                modifier = Modifier
                    .padding(start = windowInfo.scalarWidth(.24f), bottom = 8.dp)
                    .height(
                        textBoxHeight(
                            text = "Are You 14 Years Or Older?",
                            maxWidth = windowInfo.scalarWidth(.4f) - 10.dp,
                            18.sp
                        ) + 10.dp
                    )
                    .width(windowInfo.scalarWidth(.55f)), contentAlignment = Alignment.TopStart
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_message_left),
                    contentDescription = "",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillBounds
                )
                Text(
                    modifier = Modifier.padding(vertical = 8.dp, horizontal = 10.dp),
                    text = "Are You 14 Years Or Older?",
                    fontSize = 18.sp,
                    color = PinkLight,
                    fontFamily = FontFamily(Font(R.font.font_apache))
                )
            }
            Image(
                painter = painterResource(id = R.drawable.img_girl),
                contentDescription = "",
                modifier = Modifier
                    .height(windowInfo.scalarHeight(.63f))
                    .zIndex(1f)
                    .scale(-1f, 1f)
                    .offset(y = windowInfo.scalarWidth(.03f))
            )
            Image(
                painter = painterResource(id = R.drawable.img_platform),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = windowInfo.scalarWidth(0.074f)),
                contentScale = ContentScale.FillWidth

            )
        }
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
            Image(
                painter = painterResource(id = R.drawable.img_glow),
                contentDescription = "",
                modifier = Modifier
                    .width(width = windowInfo.screenWidth)
                    .alpha(.6f),
                contentScale = ContentScale.FillWidth
            )
            Image(
                painter = painterResource(id = R.drawable.img_lamp),
                contentDescription = "",
                modifier = Modifier
                    .height(windowInfo.scalarHeight(.035f))
                    .width(windowInfo.scalarWidth(.63f)),
                contentScale = ContentScale.FillBounds
            )
        }
        Column(
            modifier = Modifier.padding(
                top = windowInfo.scalarHeight(.02f), start = windowInfo.scalarWidth(.09f)
            )
        ) {
            Image(
                painter = painterResource(id = R.drawable.img_star),
                contentDescription = "Logo",
                modifier = Modifier
                    .height(windowInfo.scalarHeight(.05f))
                    .width(windowInfo.scalarWidth(.1f)),
                contentScale = ContentScale.FillBounds
            )
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier
                    .height(windowInfo.scalarHeight(.05f))
                    .width(windowInfo.scalarWidth(.33f))
                    .offset(x = -12.dp, y = -15.dp),
                contentScale = ContentScale.FillBounds
            )
            Image(
                painter = painterResource(id = R.drawable.img_logo_underline),
                contentDescription = "Logo",
                modifier = Modifier
                    .width(windowInfo.scalarWidth(.28f))
                    .offset(x = -4.dp, y = -22.dp),
                contentScale = ContentScale.FillBounds
            )

        }
        Box(
            modifier = Modifier
                .padding(
                    start = windowInfo.scalarWidth(.29f), top = windowInfo.scalarHeight(.38f)
                )

                .width(windowInfo.scalarWidth(.67f))
                .zIndex(.5f)){

            var imageHeight by remember { mutableStateOf(0.dp) }
            val content = @Composable {
                BoxContent(windowInfo)
            }

            Layout(
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y=20.dp)
                    .zIndex(2f),
                content = content
            ) { measurables, constraints ->
                val placeable = measurables.first().measure(constraints)
                imageHeight = placeable.height.toDp() // Update the image height
                layout(placeable.width, placeable.height) {
                    placeable.place(0, 0)
                }
            }

            Image(
                painter = painterResource(id = R.drawable.img_box),
                contentDescription = "Box",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(imageHeight-10.dp)

                    .zIndex(.4f)
            )
        }

    }
}

@Composable
fun textBoxHeight(
    text: String, maxWidth: Dp, fontSize: TextUnit = 20.sp
): Dp {
    val density = LocalDensity.current
    val textMeasurer = rememberTextMeasurer()
    val textLayoutResult = remember {
        textMeasurer.measure(
            text = AnnotatedString(text, SpanStyle(fontSize = fontSize)),
            constraints = Constraints(
                maxWidth = with(density) { maxWidth.toPx().toInt() }, // Convert maxWidth to pixels
                maxHeight = Int.MAX_VALUE
            ),

            )
    }
    val height = with(density) {
        textLayoutResult.size.height.toDp()
    }
    return height
}

@Composable
fun BoxContent(windowInfo:WindowInfo) {

    val context= LocalContext.current

    Column(
        Modifier
            .fillMaxWidth()
            .padding(bottom = 40.dp)
            .verticalScroll(rememberScrollState())

        , horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            modifier = Modifier
                .padding(horizontal = 35.dp),
            text = "By Clicking Continue, I Agree That I Am At Least 14 Years Old",
            fontSize = 20.sp,
            color = Color.White,
            fontFamily = FontFamily(Font(R.font.font_apache))
        )
        Spacer(modifier = Modifier.height(25.dp))
        Box(
            modifier = Modifier
                .height(
                    textBoxHeight(
                        text = "Yes, Continue", windowInfo.scalarWidth(.37f) - 15.dp
                    ) + 12.dp
                )
                .width(windowInfo.scalarWidth(.37f))
                .clickable {
                    Toast
                        .makeText(context, "Button Clicked Yes", Toast.LENGTH_SHORT)
                        .show()
                }
            , contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = R.drawable.gr_green_btn),
                contentDescription = "Yes",
                contentScale = ContentScale.FillBounds
            )
            Text(
                modifier = Modifier.padding(horizontal = 15.dp),
                text = "Yes, Continue",
                fontSize = 20.sp,
                color = Color.White,
                fontFamily = FontFamily(Font(R.font.font_apache))
            )
        }
        Spacer(modifier = Modifier.height(35.dp))
        Box(
            modifier = Modifier
                .height(
                    textBoxHeight(
                        text = "No, I'm Not 14", windowInfo.scalarWidth(.37f) - 10.dp
                    ) + 12.dp
                )
                .width(windowInfo.scalarWidth(.37f))
                .clickable {
                    Toast
                        .makeText(context, "Button Clicked No", Toast.LENGTH_SHORT)
                        .show()
                }, contentAlignment = Alignment.Center

        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = R.drawable.bg_yellow_btn),
                contentDescription = "No",
                contentScale = ContentScale.FillBounds
            )
            Text(
                modifier = Modifier.padding(horizontal = 15.dp),
                text = "No, I'm Not 14",
                fontSize = 20.sp,
                color = PinkDark,
                fontFamily = FontFamily(Font(R.font.font_apache))
            )
        }
        Spacer(modifier = Modifier.height(30.dp))
    }

}