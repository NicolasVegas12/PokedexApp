package com.nvegas.presentation

import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Mail
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.nvegas.common.theme.AppTheme
import com.nvegas.common.ui.buttons.ButtonComponent
import com.nvegas.common.ui.dialogs.ErrorDialogComponent
import com.nvegas.common.ui.dialogs.LoadingDialogComponent
import com.nvegas.common.ui.inputs.TextInputComponent
import com.nvegas.common.ui.text.TextComponent
import com.nvegas.domain.models.SignUpRequestModel

@Composable
fun SignUpScreen(
    request: SignUpRequestModel,
    signUpState: SignUpState,
    setRequest: (SignUpRequestModel, SignUpInputType) -> Unit,
    signUp: () -> Unit,
    goBack: () -> Unit,
    resetState: () -> Unit
) {


    ConstraintLayout(
        Modifier
            .fillMaxSize()
            .padding(20.dp)
            .imePadding()
    ) {
        val (body, footer) = createRefs()

        /*---Body---*/
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.constrainAs(body) {
                top.linkTo(parent.top)
                end.linkTo(parent.end)
                start.linkTo(parent.start)
                bottom.linkTo(footer.top)
            }
        ) {
            TextComponent(
                "Get Started",
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
            )
            TextComponent("by creating a free account.")
            Spacer(Modifier.height(25.dp))
            TextInputComponent(
                label = "Enter Your Email",
                text = request.email,
                icon = Icons.Outlined.Mail,
                shape = RoundedCornerShape(20.dp),
                setText = {
                    setRequest.invoke(request.copy(email = it.trim()), SignUpInputType.Email)
                }
            )
            request.emailError?.let {
                Spacer(Modifier.height(4.dp))
                if (it.isNotBlank()) {
                    TextComponent(
                        it,
                        color = Color.Red
                    )
                }
            }

            Spacer(Modifier.height(25.dp))
            TextInputComponent(
                label = "Password",
                text = request.password,
                icon = Icons.Outlined.Lock,
                shape = RoundedCornerShape(20.dp),
                setText = {
                    setRequest.invoke(request.copy(password = it.trim()), SignUpInputType.Password)
                },
                visualTransformation = PasswordVisualTransformation()
            )
            request.passwordError?.let {
                Spacer(Modifier.height(4.dp))
                if (it.isNotBlank()) {
                    TextComponent(
                        it,
                        color = Color.Red
                    )
                }
            }


        }
        /*---Body---*/


        /*---Footer---*/
        Column(
            modifier = Modifier.constrainAs(footer) {
                bottom.linkTo(parent.bottom)
                end.linkTo(parent.end)
                start.linkTo(parent.start)
            },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ButtonComponent(
                "Register",
                enabled = request.emailError == null && request.passwordError == null
            ) {
                signUp()
            }
            Spacer(Modifier.height(8.dp))

            Row {

                TextComponent("Alredy a member?")
                Spacer(Modifier.width(4.dp))
                TextComponent(
                    "Log In",
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                    modifier = Modifier.clickable {
                        goBack()
                    }
                )
            }

        }


    }

    AnimatedVisibility(signUpState.isLoading) {
        LoadingDialogComponent()
    }

    AnimatedVisibility(signUpState.error.isNotBlank()) {
        ErrorDialogComponent(signUpState.error) {
            resetState()
        }
    }

}

@Preview(name = "Light Mode")
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun PreviewSignUpScreen() {
    AppTheme {
        SignUpScreen(
            request = SignUpRequestModel(),
            signUpState = SignUpState(),
            setRequest = { _, _ -> },
            signUp = { },
            goBack = { },
            resetState = { }
        )
    }
}