package com.project.solestyle.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.BoxScopeInstance.align
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.project.solestyle.R
import com.project.solestyle.components.HeadingTextComponent
import com.project.solestyle.components.NormalTextComponent
import com.project.solestyle.navigation.AppRouter
import com.project.solestyle.navigation.Screen
import com.project.solestyle.navigation.SystemBackButtonHandler

@Composable
fun TermsAndConditionsScreen() {
    Surface(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)
        .padding(6.dp)) {

        val localContext = LocalContext.current

        Box(
            modifier = Modifier
//                .align(alignment = Alignment.TopStart)
                .offset(x = 22.dp, y = 52.dp)
                .requiredWidth(width = 446.dp)
                .requiredHeight(height = 881.dp)
                .clip(shape = RoundedCornerShape(15.dp))

                .background(color = Color(0xFFFFFFFF))
//                .clickable {
//                    localContext.startActivity(
//                        Intent(localContext, DetailsPageActivity::class.java)
//                    )
//                }
        )
        {

            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "",
                modifier = Modifier
                    .offset(x = 1.dp, y = 232.dp)
                    .requiredWidth(width =390.dp)
                    .requiredHeight(height = 833.dp)
                    .clip(shape = RoundedCornerShape(15.dp)))

        }

        HeadingTextComponent(value = stringResource(id = R.string.terms_and_conditions_header))
        }
    NormalTextComponent(
        modifier = Modifier
            .offset(x = 1.dp, y = 572.dp),
        value = stringResource(id = R.string.terms_and_conditions_headerdes))

    SystemBackButtonHandler {
        AppRouter.navigateTo(Screen.SignUpScreen)
    }
}

@Preview
@Composable
fun TermsAndConditionsScreenPreview(){
    TermsAndConditionsScreen()
}