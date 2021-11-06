package com.sampletaskmathon.mathongoassignment.models

import com.google.gson.annotations.SerializedName

data class PatchScoreModel(
    @SerializedName("scores") val scores : AddScoreModel.Score
)