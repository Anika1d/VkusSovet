package com.template.vkussovet.composablescreen.products

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.template.vkussovet.ActivityViewModel
import com.template.vkussovet.R
import com.template.vkussovet.data.model.product.Product
import com.template.vkussovet.ui.theme.DarkPrimaryColor
import com.template.vkussovet.ui.theme.SecondaryColor

@Composable
fun GridProducts(modifier: Modifier, viewModel: ActivityViewModel) {

    val listProduct by remember {
        viewModel.getProductListByCategory()
    }
    LazyVerticalGrid(
        modifier = modifier.padding(start = 30.dp, top = 10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        columns = GridCells.Fixed(2)
//    horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(listProduct.size) {
            ItemProducts(
                modifier = Modifier
                    .fillMaxWidth(0.2f)
                    .fillMaxHeight(0.4f)
                    .clip(RoundedCornerShape(30f)), product = listProduct[it]
            )
        }
    }
}


//ItemProducts(
//modifier = Modifier.fillMaxWidth(0.3f).fillMaxHeight(0.36f).clip(RoundedCornerShape(25f)), product = Product(
//id = "1",
//name = "Name",
//content = "Content",
//image = "",
//price = "1240",
//weight = "950g",
//spicy = "Y"
//)
//)

@Composable
fun ItemProducts(modifier: Modifier, product: Product) {
    Box(
        modifier = modifier.background(Color.Transparent.copy(alpha = 0f)),
    ) {
        Box(
            modifier = Modifier
                .width(150.dp)
                .height(200.dp)
                .clip(
                    RoundedCornerShape(topEnd = 35f, bottomEnd = 40f, bottomStart = 40f)
                )
                .background(Color.Black), contentAlignment = Alignment.TopCenter
        ) {
            Column(

            ) {
                Box(
                    contentAlignment = Alignment.TopCenter,
                    modifier = Modifier.padding(top = 15.dp)
                ) {
                    Column(
                        Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = product.name, style =
                            TextStyle(color = Color.White, fontSize = 17.sp),
                            textAlign = TextAlign.Center
                        )
                        Text(
                            text = product.content, style =
                            TextStyle(color = SecondaryColor, fontSize = 14.sp), maxLines = 2,
                            textAlign = TextAlign.Center
                        )
                    }

                }
                Box(
                    contentAlignment = Alignment.BottomCenter,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column(
                        Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row(
                            Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Row(
                                Modifier.fillMaxWidth(0.9f).padding(2.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.End
                            ) {
                                Text(
                                    text = product.price + "₽",
                                    style = TextStyle(color = Color.White, fontSize = 16.sp)
                                )
                                Text(
                                    " / " + product.weight + '.',
                                    style = TextStyle(color = SecondaryColor, fontSize = 14.sp)
                                )
                            }
                            if (product.spicy == "Y")
                                Box(
                                    contentAlignment = Alignment.CenterEnd,
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_hot),
                                        contentDescription = "hot"
                                    )
                                }
                        }
                        Image(
                            painter = rememberAsyncImagePainter("https://vkus-sovet.ru/${product.image}"),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxHeight()
                                .fillMaxWidth()
                                .clip(
                                    RoundedCornerShape
                                        (bottomEnd = 25f, bottomStart = 25f)
                                )
                        )

                    }

                }
            }
        }
        Box(
            contentAlignment = Alignment.BottomCenter,
            modifier = Modifier
                .background(Color.Transparent.copy(0.0f))
                .width(150.dp)
                .height(220.dp)
        ) {
            Button(
                modifier = Modifier
                    .fillMaxWidth(0.90f)
                    .fillMaxHeight(0.2f),
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(DarkPrimaryColor),
            ) {
                Text(text = "В корзину", fontSize = 12.sp, textAlign = TextAlign.Center)
            }
        }
    }
}

@Preview
@Composable
fun PREVIEWPRODUCTS() {
    ItemProducts(
        modifier = Modifier
            .fillMaxWidth(0.4f), product = Product(
            id = "1",
            name = "Name",
            content = "Content",
            image = "",
            price = "1240",
            weight = "950g",
            spicy = "Y"
        )
    )
}