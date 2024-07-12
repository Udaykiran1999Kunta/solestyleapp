package com.project.solestyle.screens

import android.content.Intent
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.project.solestyle.DetailsPageActivity

import com.project.solestyle.R
import com.project.solestyle.UserProfileActivity
import com.project.solestyle.components.AppToolbar
import com.project.solestyle.components.NavigationDrawerBody
import com.project.solestyle.components.NavigationDrawerHeader

import com.project.solestyle.data.home.HomeViewModel
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(homeViewModel: HomeViewModel = viewModel()) {

    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    homeViewModel.getUserData()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            AppToolbar(toolbarTitle = stringResource(id = R.string.home),
                logoutButtonClicked = {
                    homeViewModel.logout()
                },
                navigationIconClicked = {
                    coroutineScope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            )
        },
        drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
        drawerContent = {
            NavigationDrawerHeader(homeViewModel.emailId.value)
            NavigationDrawerBody(navigationDrawerItems = homeViewModel.navigationItemsList,
                onNavigationItemClicked = {
                    Log.d("ComingHere","inside_NavigationItemClicked")
                    Log.d("ComingHere","${it.itemId} ${it.title}")
                })
        }

    ) { paddingValues ->

        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Blue)
                .padding(paddingValues)
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                Box(
                    modifier = Modifier
                        .requiredWidth(width = 360.dp)
                        .requiredHeight(height = 640.dp)
                        .background(color = Color.White)
                ) {
                    Text(
                        text = "All  Footwears",
                        color = Color.Black,
                        style = TextStyle(
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Medium),
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 161.dp,
                                y = 142.dp)
                            .requiredWidth(width = 359.dp)
                            .requiredHeight(height = 41.dp))


                    val localContext = LocalContext.current




                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 32.dp, y = 372.dp)
                            .requiredWidth(width = 446.dp)
                            .requiredHeight(height = 181.dp)
                            .clip(shape = RoundedCornerShape(15.dp))

                            .background(color = Color(0xFFFFFFFF))
                            .clickable {
                                localContext.startActivity(
                                    Intent(localContext, DetailsPageActivity::class.java)
                                )
                            }
                    )
                    {

                        Image(
                            painter = painterResource(id = R.drawable.hee),
                            contentDescription = "",
                            modifier = Modifier
                                .offset(x = 1.dp, y = 2.dp)
                                .requiredWidth(width =190.dp)
                                .requiredHeight(height = 133.dp)
                                .clip(shape = RoundedCornerShape(15.dp)))

                    }


                        Image(
                            painter = painterResource(id = R.drawable.san1),
                            //33
                            contentDescription = "",
                            modifier = Modifier
                                .align(alignment = Alignment.TopStart)
                                .offset(x = 0.dp,
                                    y = 552.dp)
                                .requiredWidth(width = 178.dp)
                                .requiredHeight(height = 153.dp)
                                .clip(shape = RoundedCornerShape(15.dp))
                                .clickable {
                                    localContext.startActivity(
                                        Intent(localContext, DetailsPageActivity::class.java)
                                    )
                                }

                        )

                    Image(
                        painter = painterResource(id = R.drawable.profile),
                        contentDescription = "",
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 321.dp, y = 26.dp)
                            .requiredSize(size = 62.dp)
                            .clickable {
                                localContext.startActivity(Intent(localContext,UserProfileActivity::class.java))
                            }
                            .clip(shape = CircleShape)
                            .border(border = BorderStroke(0.10000000149011612.dp, Color(0xFFA21A30)),
                                shape = CircleShape))
//
                    Image(

                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = "Vector 21",
                        modifier = Modifier.size(5.dp)

                            .align(alignment = Alignment.TopStart)
                            .offset(x = 65.dp,
                                y = 134.dp)
                            .requiredSize(size = 101.dp)
                            .clip(shape = RoundedCornerShape(2.dp))

                    )



                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 220.dp,
                                y = 405.dp)
                            .requiredWidth(width = 140.dp)
                            .requiredHeight(height = 50.dp)
                            .clip(shape = RoundedCornerShape(15.dp))

                            .background(color = Color(0xFFA21A30))

                    )
                    {
                        Text(
                            text = "Heels",
                            color = Color.White,
                            style = TextStyle(
                                fontSize = 26.sp,
                                fontWeight = FontWeight.Bold),
                            modifier = Modifier
                                .align(alignment = Alignment.TopStart)
                                .offset(x = 40.dp,
                                    y = 6.dp)
                                .requiredWidth(width = 105.dp)
                                .requiredHeight(height = 28.dp))
                    }

                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 12.dp,
                                y = 168.dp)
                            .requiredWidth(width = 386.dp)
                            .requiredHeight(height =151.dp)
                            .clip(shape = RoundedCornerShape(15.dp))
//                                .background(color = Color(0x37BE5F77)
                            .background(color = Color(0xFFFFFCFC)
                            )
                            .clickable {
                                localContext.startActivity(
                                    Intent(localContext, DetailsPageActivity::class.java)
                                )
                            }
                    )
                    {
                    Image(
                        painter = painterResource(id = R.drawable.sho1),
                        contentDescription = "",
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 4.dp,
                                y = 10.dp)
                            .requiredWidth(width = 168.dp)
                            .requiredHeight(height = 163.dp)
                            .clip(shape = RoundedCornerShape(15.dp)))}
                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 223.dp,
                                y = 225.dp)
                            .requiredWidth(width = 140.dp)
                            .requiredHeight(height = 50.dp)
                            .clip(shape = RoundedCornerShape(15.dp))
                            .background(color = Color(0xFFA21A30))
                    )






                    Image(
                        painter = painterResource(id = R.drawable.ellipse_img),
                        contentDescription = " ",
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 320.dp,
                                y = 26.dp)
                            .requiredSize(size = 62.dp)
                            .clip(shape = CircleShape)
                            .border(border = BorderStroke(0.10000000149011612.dp, Color(0xffbdbdbd)),
                                shape = CircleShape))

                }

            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}