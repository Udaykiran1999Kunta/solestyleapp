package com.project.solestyle.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.project.solestyle.R
import com.project.solestyle.components.ButtonComponent
import com.project.solestyle.components.ClickableLoginTextComponent
import com.project.solestyle.components.DividerTextComponent
import com.project.solestyle.components.HeadingTextComponent
import com.project.solestyle.components.MyTextFieldComponent
import com.project.solestyle.components.PasswordTextFieldComponent
import com.project.solestyle.data.SigninViewModel
import com.project.solestyle.data.Signin.SigninUIEvent
import com.project.solestyle.navigation.AppRouter
import com.project.solestyle.navigation.Screen
import com.project.solestyle.navigation.SystemBackButtonHandler


@Composable
fun LoginScreen(signinViewModel: SigninViewModel = viewModel()) {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(28.dp)
        ) {

            Column( modifier = Modifier.fillMaxSize()) {
                Image(
                    modifier = Modifier.size(350.dp),
                    painter = painterResource(id = R.drawable.lo),
                    contentDescription = null)
                Spacer(modifier = Modifier.height(0.dp))
                HeadingTextComponent(value = "Login")
                Spacer(modifier = Modifier.height(0.dp))

                MyTextFieldComponent(labelValue = stringResource(id = com.project.solestyle.R.string.email),
                    painterResource(id = com.project.solestyle.R.drawable.message),
                    onTextChanged = { signinViewModel.onEvent(SigninUIEvent.EmailChanged(it)) },
                    errorStatus = signinViewModel.signinUIState.value.emailError
                )

                PasswordTextFieldComponent(
                    labelValue = stringResource(id =com.project.solestyle. R.string.password),
                    painterResource(id = com.project.solestyle.R.drawable.lock),
                    onTextSelected = {
                        signinViewModel.onEvent(SigninUIEvent.PasswordChanged(it))
                    },
                    errorStatus = signinViewModel.signinUIState.value.passwordError
                )

                Spacer(modifier = Modifier.height(0.dp))

                Spacer(modifier = Modifier.height(20.dp))

                ButtonComponent(
                    value = stringResource(id = com.project.solestyle.R.string.login),
                    onButtonClicked = {
                       signinViewModel.onEvent(SigninUIEvent.SigninButtonClicked)
                    },
                    isEnabled = signinViewModel.allValidationsPassed.value
                )

                Spacer(modifier = Modifier.height(20.dp))

                DividerTextComponent()

                ClickableLoginTextComponent(tryingToLogin = false, onTextSelected = {
                    AppRouter.navigateTo(Screen.SignUpScreen)
                })
            }
        }

        if(signinViewModel.loginInProgress.value) {
            CircularProgressIndicator()
        }
    }

    SystemBackButtonHandler {
        AppRouter.navigateTo(Screen.SignUpScreen)
    }

}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}

