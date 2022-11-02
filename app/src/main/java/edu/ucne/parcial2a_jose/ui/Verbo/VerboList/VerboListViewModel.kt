package edu.ucne.parcial2a_jose.ui.Verbo.VerboList

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.parcial2a_jose.data.remote.dto.VerboDTO
import edu.ucne.parcial2a_jose.data.remote.respository.respositoryverbo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.getAndUpdate
import kotlinx.coroutines.launch
import javax.inject.Inject

data class VerboListViewModelUiState(
    val verbo: List<VerboDTO> = emptyList()
)
@HiltViewModel
class VerboListViewModel @Inject constructor(
    private val api: respositoryverbo
): ViewModel(){
    private val _uiState = MutableStateFlow(VerboListViewModelUiState())
    val uiState: StateFlow<VerboListViewModelUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            _uiState.getAndUpdate {
                it.copy(verbo = api.GetVerbos().sortedBy { it.Verbo})
            }
        }
    }
}