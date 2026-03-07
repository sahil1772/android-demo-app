package com.example.bugdemo.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bugdemo.data.model.User
import kotlinx.coroutines.launch

data class LoginResult(val success: Boolean, val user: User? = null, val error: String? = null)

class LoginViewModel : ViewModel() {
    private val repository = LoginRepository()
    private val _loginResult = MutableLiveData<LoginResult>()
    val loginResult: LiveData<LoginResult> = _loginResult

    fun login(username: String, password: String) {
        viewModelScope.launch {
            val user = repository.authenticate(username, password)
            if (user != null) {
                _loginResult.value = LoginResult(success = true, user = user)
            } else {
                _loginResult.value = LoginResult(success = false, error = "Invalid credentials")
            }
        }
    }
}
