package com.example.cleanarchitecture.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cleanarchitecture.data.repository.UserRepositoryImpl
import com.example.cleanarchitecture.databinding.ActivityMainBinding
import com.example.cleanarchitecture.domain.models.SaveUserNameParam
import com.example.cleanarchitecture.domain.models.Username
import com.example.cleanarchitecture.domain.usecase.GetUserNameUseCase
import com.example.cleanarchitecture.domain.usecase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {

    private val userRepository by lazy(LazyThreadSafetyMode.NONE) { UserRepositoryImpl(context = applicationContext)}
    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) { GetUserNameUseCase(userRepository = userRepository)}
    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) { SaveUserNameUseCase(userRepository = userRepository)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)

        binding.sendButton.setOnClickListener {
            val text = binding.dataEV.text.toString()
            val params = SaveUserNameParam(name = text)
            val result = saveUserNameUseCase.execute(param = params)
            binding.dataTV.text = "Save result = $result"
        }

        binding.receiveButton.setOnClickListener {
            val userName: Username = getUserNameUseCase.execute()
            binding.dataTV.text = "${userName.firstName} ${userName.lastName}"
        }

        setContentView(binding.root)

    }
}