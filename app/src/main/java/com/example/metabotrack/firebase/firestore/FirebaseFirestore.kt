package com.example.metabotrack.firebase.firestore

import com.google.firebase.firestore.FirebaseFirestore

object FirestoreHelper {
    private val db = FirebaseFirestore.getInstance()

    fun saveActivity(userId: String, activity: ActivityEntity) {
        db.collection("users")
            .document(userId)
            .collection("activities")
            .add(activity)
    }
}
