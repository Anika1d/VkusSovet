@file:OptIn(ExperimentalMaterial3Api::class)

package com.template.vkussovet

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.template.vkussovet.composablescreen.MainScreen
import com.template.vkussovet.ui.theme.DarkGreyColor
import com.template.vkussovet.ui.theme.VkusSovetTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModels: ActivityViewModel by viewModels()

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VkusSovetTheme {
                Column(Modifier.fillMaxSize()) {
                    Scaffold(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp),
                        topBar = {
                            SmallTopAppBar(
                                title = {
                                    Text(
                                        text = "VKUSSOVET", style =
                                        TextStyle(
                                            color = Color.White,
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 30.sp
                                        )
                                    )
                                },
                                navigationIcon = {
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_logo),
                                        contentDescription = "logo"
                                    )
                                },
                                actions = {
                                    IconButton(onClick = { }) {
                                        Icon(
                                            imageVector = Icons.Default.Call,
                                            contentDescription = "menu",
                                            tint = Color.White
                                        )
                                    }

                                },
                                colors = TopAppBarDefaults.smallTopAppBarColors(
                                    Color.Black
                                )
                            )
                        },
                    ) {
                        //TODO()
                    }

                    MainScreen(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.95f)
                            .background(DarkGreyColor)
                            .padding(4.dp),
                        viewModel =viewModels,
                        lifecycleOwner =this@MainActivity
                    )
                    Scaffold(
                        containerColor = Color.Black,
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(),
                        bottomBar = {
                            Surface(
                                modifier = Modifier.padding(4.dp),
                                color = Color.Black,
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(80.dp)
                                        .selectableGroup(),
                                    horizontalArrangement = Arrangement.SpaceEvenly,
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Menu,
                                        contentDescription = null,
                                        tint = Color.White
                                    )
                                    Icon(
                                        imageVector = Icons.Default.ShoppingCart,
                                        contentDescription = null,
                                        tint = Color.White
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Info,
                                        contentDescription = null,
                                        tint = Color.White
                                    )
                                }
                            }
                        },
                    ) { //TODO()
                     }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    VkusSovetTheme {
        Greeting("Android")
    }
}