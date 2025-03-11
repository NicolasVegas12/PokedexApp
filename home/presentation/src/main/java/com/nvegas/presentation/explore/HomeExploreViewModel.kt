package com.nvegas.presentation.explore

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.nvegas.domain.models.list.PokedexListResultModel
import com.nvegas.domain.usecases.GetConnectivityUseCase
import com.nvegas.domain.usecases.GetPokedexListUseCase
import com.nvegas.presentation.explore.components.pager.PokedexPagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeExploreViewModel @Inject constructor(
    private val getPokedexUseCase: GetPokedexListUseCase,
    private val getConnectivityUseCase: GetConnectivityUseCase
) : ViewModel() {

    var pokedex: Flow<PagingData<PokedexListResultModel>>? = null
    private val _searchQuery = mutableStateOf("")
    val searchQuery: State<String> = _searchQuery

    private val _connectivity = mutableStateOf(true)
    val connectivity: State<Boolean> = _connectivity

    init {
        getPokedex()
        getConnectivity()
    }

    private fun getConnectivity() {
        getConnectivityUseCase.invoke().onEach {
            _connectivity.value = it
        }.launchIn(viewModelScope)
    }

    private fun getPokedex() {
        pokedex = Pager(
            config = PagingConfig(pageSize = 20),
            pagingSourceFactory = {
                PokedexPagingSource(getPokedexUseCase)
            }
        ).flow.cachedIn(viewModelScope)
    }

    fun setSearchQuery(value: String) {
        _searchQuery.value = value
    }

}