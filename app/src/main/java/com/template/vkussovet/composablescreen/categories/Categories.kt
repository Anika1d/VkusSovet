package com.template.vkussovet.composablescreen.categories

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.template.vkussovet.ActivityViewModel
import com.template.vkussovet.MainActivity
import com.template.vkussovet.R
import com.template.vkussovet.data.model.category.Category
import com.template.vkussovet.ui.theme.DarkGreyColor
import com.template.vkussovet.ui.theme.DarkPrimaryColor
import com.template.vkussovet.ui.theme.SecondaryColor

@Composable
fun RowCategories(
    modifier: Modifier,
    verticalAlignment: Alignment.Vertical = Alignment.Top,
    contentSpaceBetween: Dp = 20.dp, contentPadding: PaddingValues = PaddingValues(0.dp),
    selectedColor: Color = DarkPrimaryColor,
    unSelectedColor: Color = Color.DarkGray,
    viewModel: ActivityViewModel,
    lifecycleOwner: MainActivity
) {
    val listCategories by remember {
        viewModel.getCategoriesList()
    }
    viewModel.apply {
        initCategoriesList()
    }
    var fl by remember {
        mutableStateOf(true)
    }
    val isSelectedList = MutableList(listCategories.size) {
        remember {
            mutableStateOf(false)
        }
    }
    if (fl && listCategories.isNotEmpty()) {
        isSelectedList[0].value = true
        viewModel.changeCategory(listCategories[0])
        fl = false
    }
    LazyRow(
        modifier = modifier,
        verticalAlignment = verticalAlignment,
        horizontalArrangement = Arrangement.spacedBy(contentSpaceBetween),
        contentPadding = contentPadding
    ) {
        items(listCategories.size) {
            CategoryItem(
                modifier = Modifier
                    .fillMaxWidth(0.4f)
                    .fillMaxHeight(1f)
                    .background(
                        if (isSelectedList[it].value) selectedColor else unSelectedColor,
                        shape = RoundedCornerShape(10)
                    )
                    .clickable {
                        isSelectedList.map { isselect ->
                            isselect.value = false
                        }
                        isSelectedList[it].value = true
                        viewModel.changeCategory(listCategories[it])
                    }, category = listCategories[it],
                viewModel = viewModel,
                lifecycleOwner = lifecycleOwner
            )
        }
    }
}

val SIZECATEGORYWIDHT = 100.dp

@Composable
fun CategoryItem(
    modifier: Modifier,
    category: Category,
    lifecycleOwner: MainActivity,
    viewModel: ActivityViewModel
) {

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            contentAlignment = Alignment.TopStart
        ) {
            Image(
                modifier = Modifier
                    .fillMaxHeight(0.5f)
                    .width(SIZECATEGORYWIDHT)
                    .clip(RoundedCornerShape(topEnd = 25f, topStart = 25f)),
                painter = rememberAsyncImagePainter("https://vkus-sovet.ru/${category.image}"),
                contentDescription = null,
                alignment = Alignment.TopCenter,
            )
        }
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(SIZECATEGORYWIDHT),
            contentAlignment = Alignment.Center
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = category.name, style = TextStyle(
                        Color.White, fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Bold, fontSize = 16.sp,
                    ), maxLines = 1
                )
                Text(
                    modifier = Modifier.padding(top = 15.dp),
                    text = "${category.subMenuCount} ${declension(category.subMenuCount)}",
                    style = TextStyle(
                        color = SecondaryColor,
                        fontStyle = FontStyle(1),
                        fontSize = 12.sp,
                    )
                )
            }
        }
    }
}

//@Preview(showBackground = false)
//@Composable
//internal fun PreviewCategories() {
//    CategoryItem(
//        modifier = Modifier
//            .fillMaxWidth(0.5f)
//            .fillMaxHeight(0.5f)
//            .background(DarkGray, shape = RoundedCornerShape(10)), category =
//        Category(
//            image = "/upload/iblock/275/275276f076ad29bae643e3ae7d6b5df6.jpeg",
//            menuID = "1",
//            name = "Суши",
//            subMenuCount = 7,
//        ), lifecycleOwner = lifecycleOwner, viewModel = viewModel
//    )
//}


internal fun declension(subMenuCount: Int): String {
    return if (subMenuCount % 10 == 1 && subMenuCount % 100 != 11)
        "товар"
    else if (subMenuCount % 10 in 2..4 && subMenuCount % 100 !in 11..14)
        "товара"
    else
        "товаров"
}
