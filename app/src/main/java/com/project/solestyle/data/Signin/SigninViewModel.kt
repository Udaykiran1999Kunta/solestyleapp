package com.project.solestyle.data

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.project.solestyle.data.Signin.SigninUIEvent
import com.project.solestyle.data.rules.Validator
import com.project.solestyle.navigation.AppRouter
import com.project.solestyle.navigation.Screen


class SigninViewModel : ViewModel() {

    private val TAG = SigninViewModel::class.simpleName

    var signinUIState = mutableStateOf(SigninUIState())

    var allValidationsPassed = mutableStateOf(false)

    var loginInProgress = mutableStateOf(false)


    fun onEvent(event: SigninUIEvent) {
        when (event) {
            is SigninUIEvent.EmailChanged -> {
                signinUIState.value = signinUIState.value.copy(
                    email = event.email
                )
            }

            is SigninUIEvent.PasswordChanged -> {
                signinUIState.value = signinUIState.value.copy(
                    password = event.password
                )
            }

            is SigninUIEvent.SigninButtonClicked -> {
                login()
            }
        }
        validateLoginUIDataWithRules()
    }

    private fun validateLoginUIDataWithRules() {
        val emailResult = Validator.validateEmail(
            email = signinUIState.value.email
        )


        val passwordResult = Validator.validatePassword(
            password = signinUIState.value.password
        )

        signinUIState.value = signinUIState.value.copy(
            emailError = emailResult.status,
            passwordError = passwordResult.status
        )

        allValidationsPassed.value = emailResult.status && passwordResult.status

    }

    private fun login() {

        loginInProgress.value = true
        val email = signinUIState.value.email
        val password = signinUIState.value.password

        FirebaseAuth
            .getInstance()
            .signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                Log.d(TAG,"Inside_login_success")
                Log.d(TAG,"${it.isSuccessful}")

                if(it.isSuccessful){
                    loginInProgress.value = false
                    AppRouter.navigateTo(Screen.HomeScreen)
                }
            }
            .addOnFailureListener {
                Log.d(TAG,"Inside_login_failure")
                Log.d(TAG,"${it.localizedMessage}")

                loginInProgress.value = false

            }

    }

}


