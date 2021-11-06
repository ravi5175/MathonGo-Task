package com.sampletaskmathon.mathongoassignment.ui.base

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.sampletaskmathon.mathongoassignment.repository.NetworkRepository
import com.sampletaskmathon.mathongoassignment.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val networkRepository: NetworkRepository
) : ViewModel() {

    fun fetchScoreCards(email : String, page : String, limit : String) = liveData(Dispatchers.IO){
        emit(Resource.loading())
        try{
            val apiResponse = networkRepository.fetchScoreCard(email, page, limit)
            emit(Resource.success(apiResponse))
        }catch(e : Exception){
            emit(Resource.error(e.localizedMessage))
        }
    }

    fun deleteScoreCards(scoreCardId : String) = liveData(Dispatchers.IO){
        emit(Resource.loading())
        try{
            val apiResponse = networkRepository.deleteScoreCard(scoreCardId)
            emit(Resource.success(apiResponse))
        }catch(e : Exception){
            emit(Resource.error(e.localizedMessage))
        }
    }
}