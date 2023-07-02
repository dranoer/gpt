package com.dranoer.gpt.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.dranoer.gpt.networking.model.DetailItem
import com.dranoer.gpt.MainViewModel
import com.dranoer.gpt.MainViewModel.DetailUiState.Error
import com.dranoer.gpt.MainViewModel.DetailUiState.Loading
import com.dranoer.gpt.MainViewModel.DetailUiState.Success
import com.dranoer.gpt.R
import com.dranoer.gpt.ui.component.DetailView
import com.dranoer.gpt.ui.theme.GptTheme

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = hiltViewModel(),
    id: String,
    backPress: () -> Unit,
) {
    LaunchedEffect(key1 = id) {
        viewModel.fetchArtDetail(objectNumber = id)
    }

    Surface(modifier = modifier.fillMaxSize()) {
        val state = viewModel.detailUiState.collectAsState().value
        //region UI State
        when (state) {
            is Loading -> Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) { CircularProgressIndicator() }

            is Success -> LoadedDetailScreen(detail = state.data, backPress = backPress)

            is Error -> Text(text = "Error ${state.message}")
        } //endregion
    }
}

@Composable
private fun LoadedDetailScreen(
    detail: DetailItem?,
    backPress: () -> Unit,
) {
    Scaffold(
        //region TopAppBar
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(onClick = { backPress() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = stringResource(id = R.string.app_name),
                            tint = colorResource(id = R.color.black)
                        )
                    }
                },
                backgroundColor = colorResource(id = R.color.white),
                elevation = dimensionResource(id = R.dimen.size_0),
            )
        }, //endregion
        //region Content
        content = { padding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(dimensionResource(id = R.dimen.size_0)),
            ) {
                detail?.let { detailItem ->
                    DetailView(item = detailItem)
                }
            }
        } //endregion
    )
}

//region Preview
@Preview("Normal detail screen")
@Composable
private fun DetailPreview_Normal() {
    GptTheme {
        DetailScreen(id = "1", backPress = {})
    }
}
//endregion