package com.sampletaskmathon.mathongoassignment.ui.add_score

import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.sampletaskmathon.mathongoassignment.models.AddScoreModel
import com.sampletaskmathon.mathongoassignment.models.PatchScoreModel
import com.sampletaskmathon.mathongoassignment.models.ScoreCardModel
import com.sampletaskmathon.mathongoassignment.repository.NetworkRepository
import com.sampletaskmathon.mathongoassignment.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class AddScoreActivityViewModel @Inject constructor(
    private val networkRepository: NetworkRepository
) : ViewModel(){
    fun addScoreCards(scoreCard : AddScoreModel) = liveData(Dispatchers.IO){
        emit(Resource.loading())
        try{
            val apiResponse = networkRepository.addScoreCard(scoreCard)
            emit(Resource.success(apiResponse))
        }catch(e : Exception){
            emit(Resource.error(e.localizedMessage))
        }
    }

    fun updateScoreCards(scoreId : String, scoreCard : PatchScoreModel) = liveData(Dispatchers.IO){
        emit(Resource.loading())
        try{
            val apiResponse = networkRepository.updateScoreCard(scoreId,scoreCard)
            emit(Resource.success(apiResponse))
        }catch(e : Exception){
            emit(Resource.error(e.localizedMessage))
        }
    }

    fun fetchTestSeries() = liveData(Dispatchers.IO){
        emit(Resource.loading())
        try{
            val apiResponse = networkRepository.fetchTestSeries()
            emit(Resource.success(apiResponse))
        }catch(e : Exception){
            emit(Resource.error(e.localizedMessage))
        }
    }
}