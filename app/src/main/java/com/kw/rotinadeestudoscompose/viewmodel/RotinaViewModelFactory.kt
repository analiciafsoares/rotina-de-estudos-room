package com.kw.rotinadeestudoscompose.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kw.rotinadeestudoscompose.data.RotinaRepository

class RotinaViewModelFactory(private val repository: RotinaRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return RotinaViewModel(repository) as T
    }
}
