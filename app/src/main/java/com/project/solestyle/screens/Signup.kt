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
import com.project.solestyle.components.ButtonComponent
import com.project.solestyle.components.CheckboxComponent
import com.project.solestyle.components.ClickableLoginTextComponent
import com.project.solestyle.components.DividerTextComponent
import com.project.solestyle.components.HeadingTextComponent
import com.project.solestyle.components.MyTextFieldComponent
import com.project.solestyle.components.PasswordTextFieldComponent
import com.project.solestyle.data.signup.SignupUIEvent
import com.project.solestyle.data.signup.SignupViewModel
import com.project.solestyle.navigation.AppRouter
import com.project.solestyle.navigation.Screen


@Composable
fun SignUpScreen(signupViewModel: SignupViewModel = viewModel()) {
    Box(
        modifier = Modifier.fillMaxSize()
            .background(color = Color.White),
        contentAlignment = Alignment.Center,

    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(28.dp)
                .align(Alignment.Center)
        ) {
            Column(
                modifier = Modifier
                    .background(color = Color.White),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center) {
                Image(
                    modifier = Modifier.size(250.dp),
                    painter = painterResource(id = com.project.solestyle.R.drawable.lo),
                    contentDescription = null)
                  HeadingTextComponent(value = "SoleStyle App")
                  Spacer(modifier = Modifier.height(2.dp))
                  MyTextFieldComponent(
                    labelValue = stringResource(id = com.project.solestyle.R.string.first_name),
                    painterResource(id =com.project.solestyle. R.drawable.profile),
                    onTextChanged = {
                        signupViewModel.onEvent(SignupUIEvent.FirstNameChanged(it))
                    },
                    errorStatus = signupViewModel.registrationUIState.value.firstNameError
                )

                MyTextFieldComponent(
                    labelValue = stringResource(id = com.project.solestyle.R.string.last_name),
                    painterResource = painterResource(id =com.project.solestyle. R.drawable.profile),
                    onTextChanged = {
                        signupViewModel.onEvent(SignupUIEvent.LastNameChanged(it))
                    },
                    errorStatus = signupViewModel.registrationUIState.value.lastNameError
                )

                MyTextFieldComponent(
                    labelValue = stringResource(id =com.project.solestyle. R.string.email),
                    painterResource = painterResource(id = com.project.solestyle.R.drawable.message),
                    onTextChanged = {
                        signupViewModel.onEvent(SignupUIEvent.EmailChanged(it))
                    },
                    errorStatus = signupViewModel.registrationUIState.value.emailError
                )

                PasswordTextFieldComponent(
                    labelValue = stringResource(id = com.project.solestyle.R.string.password),
                    painterResource = painterResource(id = com.project.solestyle.R.drawable.ic_lock),
                    onTextSelected = {
                        signupViewModel.onEvent(SignupUIEvent.PasswordChanged(it))
                    },
                    errorStatus = signupViewModel.registrationUIState.value.passwordError
                )

                CheckboxComponent(value = stringResource(id = com.project.solestyle.R.string.terms_and_conditions),
                    onTextSelected = {
                        AppRouter.navigateTo(Screen.TermsAndConditionsScreen)
                    },
                    onCheckedChange = {
                        signupViewModel.onEvent(SignupUIEvent.PrivacyPolicyCheckBoxClicked(it))
                    }
                )

                Spacer(modifier = Modifier.height(10.dp))

                ButtonComponent(
                    value = stringResource(id =com.project.solestyle. R.string.register),
                    onButtonClicked = {
                        signupViewModel.onEvent(SignupUIEvent.RegisterButtonClicked)
                    },
                    isEnabled = signupViewModel.allValidationsPassed.value
                )

                Spacer(modifier = Modifier.height(10.dp))

                DividerTextComponent()

                ClickableLoginTextComponent(tryingToLogin = true, onTextSelected = {
                    AppRouter.navigateTo(Screen.LoginScreen)
                })
            }
        }


        if(signupViewModel.signUpInProgress.value) {
            CircularProgressIndicator()
        }
    }

}

@Preview
@Composable
fun DefaultPreviewOfSignUpScreen() {
    SignUpScreen()
}