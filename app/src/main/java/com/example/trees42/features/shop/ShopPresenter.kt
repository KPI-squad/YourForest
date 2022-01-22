package com.example.trees42.features.shop

import android.util.Log
import android.widget.Toast
import com.example.trees42.base.BasePresenter
import com.example.trees42.model.Tree
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import javax.inject.Inject

class ShopPresenter @Inject constructor(): BasePresenter<ShopContract>() {

    private var data = mutableListOf<Tree>()

    override fun onViewAttached() {
        val database = Firebase.database
        val myRef = database.getReference("trees")


        myRef.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                for(it in snapshot.children) {
                    val name = it.child("name").value.toString()
                    val imageId = it.child("description").child("imageId").value.toString()
                    val price = it.child("description").child("price").value.toString()

                    val x = it.child("location").child("x").value.toString()
                    val y = it.child("location").child("y").value.toString()

                    val tree = Tree(name, imageId, price, x, y)
                    data.add(tree)
                }
                rootView?.updateUI(data)
            }
            override fun onCancelled(error: DatabaseError) {
                Log.w("tagg", "Failed to read value.", error.toException())
            }

        })


    }
}