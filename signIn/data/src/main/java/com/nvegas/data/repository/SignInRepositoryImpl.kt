package com.nvegas.data.repository

import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.nvegas.domain.models.request.SignInRequestModel
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class SignInRepositoryImpl @Inject constructor() : SignInRepository {
    override suspend fun signIn(request: SignInRequestModel): Boolean =
        suspendCoroutine { coroutine ->
            val auth = Firebase.auth
            auth.signInWithEmailAndPassword(request.email, request.email)
                .addOnCompleteListener { task ->
                    coroutine.resume(task.isSuccessful)
                }
        }
}