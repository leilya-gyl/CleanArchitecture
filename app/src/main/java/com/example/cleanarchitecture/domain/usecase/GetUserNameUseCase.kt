package com.example.cleanarchitecture.domain.usecase

import com.example.cleanarchitecture.domain.models.Username
import com.example.cleanarchitecture.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {

    // Один класс имеет только один метод
    fun execute(): Username {
        return userRepository.getName()
    }
}