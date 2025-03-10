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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Mail
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.nvegas.common.ui.buttons.CheckBoxButtonComponent
import com.nvegas.common.ui.dialogs.ErrorDialogComponent
import com.nvegas.common.ui.dialogs.LoadingDialogComponent
import com.nvegas.common.ui.inputs.TextInputComponent
import com.nvegas.common.ui.text.TextComponent
import com.nvegas.domain.models.request.SignInRequestModel

@Composable
fun SignInScreen(
    request: SignInRequestModel,
    signInState: SignInState,
    setRequest: (SignInRequestModel, SignInInputTypes) -> Unit,
    resetState:()->Unit,
    navigateToSignUp: () -> Unit,
    signIn: () -> Unit
) {

    var checkbox by remember { mutableStateOf(false) }

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
                "Welcome back",
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
            )
            TextComponent("sign in to access your account")
            Spacer(Modifier.height(25.dp))
            TextInputComponent(
                label = "Enter Your Email",
                text = request.email,
                icon = Icons.Outlined.Mail,
                shape = RoundedCornerShape(20.dp),
                setText = {
                    setRequest.invoke(request.copy(email = it.trim()), SignInInputTypes.Email)
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
                    setRequest.invoke(request.copy(password = it.trim()), SignInInputTypes.Password)
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
            Spacer(Modifier.height(16.dp))
            Row(
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                CheckBoxButtonComponent(
                    checked = checkbox,
                    modifier = Modifier.size(12.dp),
                    onCheckedChange = { checkbox = it },
                )
                Spacer(Modifier.size(16.dp))
                TextComponent(
                    "Remember me",
                    style = MaterialTheme.typography.bodySmall
                )
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
                "Login",
                enabled = request.emailError == null && request.passwordError == null
            ) {
                signIn()
            }
            Spacer(Modifier.height(8.dp))

            Row {

                TextComponent("New member?")
                Spacer(Modifier.width(4.dp))
                TextComponent(
                    "Register Now",
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                    modifier = Modifier.clickable {
                        navigateToSignUp()
                    }
                )
            }

        }


    }

    AnimatedVisibility(signInState.isLoading) {
        LoadingDialogComponent()
    }

    AnimatedVisibility(signInState.error.isNotBlank()) {
        ErrorDialogComponent(signInState.error){
            resetState()
        }
    }

}

@Preview(name = "light Mode")
@Preview(name = "dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun PreviewSignInScreen() {
    AppTheme {
        SignInScreen(
            request = SignInRequestModel(),
            SignInState(),
            setRequest = { _, _ -> },
            {},
            {},
            {})
    }
}