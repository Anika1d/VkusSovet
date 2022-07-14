@file:OptIn(ExperimentalMaterial3Api::class)

package com.template.vkussovet.composablescreen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.template.vkussovet.ActivityViewModel
import com.template.vkussovet.MainActivity
import com.template.vkussovet.composablescreen.categories.RowCategories
import com.template.vkussovet.composablescreen.products.GridProducts
import com.template.vkussovet.data.model.category.Category

@Composable
fun MainScreen(modifier: Modifier, viewModel: ActivityViewModel, lifecycleOwner: MainActivity) {

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        RowCategories(
            modifier = Modifier.fillMaxHeight(0.2f),
            viewModel = viewModel,
            lifecycleOwner = lifecycleOwner
        )
        val selectedCategory=viewModel.getSelectedCategory()
        Text(
            text = if (selectedCategory.value!= null)
                selectedCategory.value!!.name else
                "Сеты",
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 36.sp,
                color = Color.White
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            textAlign = TextAlign.Start
        )
        GridProducts(
            modifier = Modifier
                .fillMaxSize(),
            viewModel = viewModel
        )
    }
}


