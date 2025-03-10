package com.nvegas.data.repository

import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class SplashRepositoryImpl : SplashRepository {

    override fun getAuthUser(): Boolean {
        val firebaseUser: FirebaseAuth = Firebase.auth
        return firebaseUser.currentUser != null

    }
}