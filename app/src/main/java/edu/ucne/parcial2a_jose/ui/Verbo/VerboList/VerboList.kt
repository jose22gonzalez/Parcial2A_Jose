package edu.ucne.parcial2a_jose.ui.Verbo.VerboList

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import edu.ucne.parcial2a_jose.data.remote.dto.VerboDTO

@Composable
fun VerboList(
    viewModel: VerboListViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = {
            Text(
                text = "Consulta Verbo",
                style = MaterialTheme.typography.h5
            )
        }
    ) {

        val uiState by viewModel.uiState.collectAsState()

        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(it)) {
            Verbolist(verbo = uiState.verbo)
        }
}
}

@Composable
fun Verbolist(
    verbo: List<VerboDTO>
) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(verbo) { verb ->
           VerboRow(verboDTO = verb)
        }
    }
}

@Composable
fun VerboRow(verboDTO: VerboDTO) {
    Card(
        elevation = 16.dp,
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
    ) {
        Row(modifier = Modifier.padding(10.dp)) {
            Column(
                modifier = Modifier
                    .padding(5.dp)

            ) {
                Text(
                    text = "Verbo: ${verboDTO.Verbo}",
                    style = MaterialTheme.typography.subtitle1
                )

                Text(
                    text = "Categoria: ${verboDTO.Categoria}",
                    style = MaterialTheme.typography.subtitle1
                )

                Text(
                    text = "Nivel: ${verboDTO.Nivel}",
                    style = MaterialTheme.typography.subtitle1
                )

                AsyncImage(
                    model = "${verboDTO.Imagen}",
                    contentDescription = null
                )
            }
        }
    }
}