package com.example.vortex.data

import android.content.Context
import android.util.Log
import com.example.vortex.Start.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class FirebaseAuthManager(private val context: Context) {

    private val auth = FirebaseAuth.getInstance()
    private val db = FirebaseFirestore.getInstance()

    fun createUser(email: String, password: String, userDetails: Map<String, String>, onSuccess: () -> Unit, onFailure: (String) -> Unit) {
        if (email.isNotEmpty() && password.isNotEmpty()) {
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val user = auth.currentUser
                        val userId = user?.uid ?: return@addOnCompleteListener

                        // Store additional user details in Firestore
                        db.collection("users").document(userId)
                            .set(userDetails)
                            .addOnSuccessListener {
                                onSuccess()
                            }
                            .addOnFailureListener { e ->
                                onFailure(e.message ?: "Failed to store user details")
                            }
                    } else {
                        onFailure(task.exception?.message ?: "Authentication failed")
                    }
                }
        }
    }

    fun getUserDetails(onResult: (Map<String, Any>?) -> Unit) {
        val userId = auth.currentUser?.uid
        if (userId != null) {
            db.collection("users").document(userId)
                .get()
                .addOnSuccessListener { document ->
                    if (document.exists()) {
                        onResult(document.data)
                    } else {
                        Log.d("FirebaseAuthManager", "No such document")
                        onResult(null)
                    }
                }
                .addOnFailureListener { exception ->
                    Log.d("FirebaseAuthManager", "get failed with ", exception)
                    onResult(null)
                }
        } else {
            onResult(null)
        }
    }

    fun fetchUsers(onResult: (List<User>) -> Unit) {
        db.collection("users")
            .get()
            .addOnSuccessListener { snapshot ->
                val users = snapshot.documents.mapNotNull { doc ->
                    User(
                        noTelp = doc.getString("nomorHP") ?: "",
                        name = doc.getString("nama") ?: "",
                        email = doc.getString("email") ?: "",
                        role = doc.getString("role") ?: "",
                        description = doc.getString("deskripsi") ?: "",
                        location = doc.getString("lokasi") ?: "",
                        bidang = doc.getString("selectedBidang") ?: "",
                        profilePictureUrl = doc.getString("profilePictureUrl")
                        // Make sure all fields are properly initialized
                    )
                }
                onResult(users)
            }
            .addOnFailureListener {
                Log.e("FirebaseAuthManager", "Error fetching users", it)
                onResult(emptyList())
            }
    }

}

//data class User(
//    val noTelp: String,
//    val name: String,
//    val email: String,
//    val role: String,
//    val description: String,
//    val location: String,
//    val bidang: String,
//    val profilePictureUrl: String? = null // Optional, can be null
//)