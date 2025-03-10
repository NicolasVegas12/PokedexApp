package com.nvegas.data.repository

import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.nvegas.domain.models.SignUpRequestModel
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class SignUpRepositoryImpl @Inject constructor() : SignUpRepository {

    override suspend fun signUp(request: SignUpRequestModel): Boolean =
        suspendCoroutine { coroutine ->
            val auth = Firebase.auth
            auth.createUserWithEmailAndPassword(request.email, request.email)
                .addOnCompleteListener { task ->
                    coroutine.resume(task.isSuccessful)
                }

        }


}