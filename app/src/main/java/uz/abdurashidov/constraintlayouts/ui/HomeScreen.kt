package uz.abdurashidov.constraintlayouts.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension

@Composable
fun HomeScreen() {

    val constraints = ConstraintSet {
        val blueBox = createRefFor("bluebox")
        val redBox = createRefFor("redbox")
        val greenBox = createRefFor("greenbox")
        val yellowBox = createRefFor("yellowbox")

        constrain(blueBox) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            bottom.linkTo(redBox.top)
            end.linkTo(yellowBox.start)
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)

        }
        constrain(redBox) {
            top.linkTo(blueBox.bottom)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(greenBox.start)
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
        }
        constrain(yellowBox) {
            end.linkTo(parent.end)
            top.linkTo(parent.top)
            bottom.linkTo(greenBox.top)
            start.linkTo(blueBox.end)
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
        }
        constrain(greenBox) {
            bottom.linkTo(parent.bottom)
            end.linkTo(parent.end)
            start.linkTo(redBox.end)
            top.linkTo(yellowBox.bottom)
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
        }

        createVerticalChain(blueBox, redBox, chainStyle = ChainStyle.Packed)
    }

    ConstraintLayout(
        constraints,
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .background(Color.Green)
                .layoutId("greenbox")
        )
        Box(
            modifier = Modifier
                .background(Color.Red)
                .layoutId("redbox")
        )
        Box(
            modifier = Modifier
                .background(Color.Blue)
                .layoutId("bluebox")
        )
        Box(
            modifier = Modifier
                .background(Color.Yellow)
                .layoutId("yellowbox")
        )
    }
}


@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}
