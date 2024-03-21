package com.example.vortex.Beranda

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vortex.R
import com.example.vortex.databinding.ActivityPembukuanBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database



class PembukuanActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPembukuanBinding
    private lateinit var database: DatabaseReference
    private lateinit var auth: FirebaseAuth
    private lateinit var authId: String
    lateinit var pembukuanList: MutableList<RowPembukuanItem>
    private lateinit var rowPembukuanAdapter: RowPembukuanAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPembukuanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        authId = auth.currentUser!!.uid
        database = Firebase.database.reference.child("Pembukuan").child(authId)

        getDataFromFirebase()

        binding.rvPembukuan.setHasFixedSize(true)
        binding.rvPembukuan.layoutManager = LinearLayoutManager(this)

        pembukuanList = mutableListOf()
        rowPembukuanAdapter = RowPembukuanAdapter(this, pembukuanList)
        binding.rvPembukuan.adapter = rowPembukuanAdapter

        binding.btnFloatin.setOnClickListener {
            val intent = Intent(this, TambahPembukuan::class.java)
            intent.putExtra("pembukuanList", ArrayList(pembukuanList))
            startActivity(intent)
        }
        binding.btnBack.setOnClickListener {
            finish()
        }
    }
    private fun getDataFromFirebase() {
        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                pembukuanList.clear()
                for (taskSnapshot in snapshot.children) {
                    val pembukuan =
                        taskSnapshot.key?.let { RowPembukuanItem(taskSnapshot.value.toString(), taskSnapshot.value.toString(), taskSnapshot.value.toString()) }

                    if (pembukuan != null) {
                        pembukuanList.add(pembukuan)
                    }

                }
                Log.d(TAG, "onDataChange: " + pembukuanList)
                rowPembukuanAdapter.notifyDataSetChanged()
            }
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@PembukuanActivity, error.toString(), Toast.LENGTH_SHORT).show()
            }
        })
    }

     fun  savePembukuan(pembukuanList: RowPembukuanItem) {

        database.push().setValue(pembukuanList).addOnCompleteListener {
                if (it.isSuccessful) {
                    Toast.makeText(this, "Task Added Successfully", Toast.LENGTH_SHORT).show()

                } else {
                    Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                }
            }

    }


}