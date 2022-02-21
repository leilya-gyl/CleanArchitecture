package com.example.cleanarchitecture.domain.repository

import com.example.cleanarchitecture.domain.models.SaveUserNameParam
import com.example.cleanarchitecture.domain.models.Username

interface UserRepository {
    fun saveName(saveParam: SaveUserNameParam): Boolean

    fun getName(): Username
}