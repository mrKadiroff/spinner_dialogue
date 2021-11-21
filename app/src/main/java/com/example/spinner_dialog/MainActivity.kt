package com.example.spinner_dialog

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.spinner_dialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnShowDialog.setOnClickListener {
          val mBuilder = AlertDialog.Builder(this)
          val layoutInflater:LayoutInflater = LayoutInflater.from(applicationContext)
          val mView: View = layoutInflater.inflate(R.layout.dialog_spinner, null)
            mBuilder.setTitle("Spinner in custom dialog")
            val mSpinner = mView.findViewById<Spinner>(R.id.spinner)
            val adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,resources.getStringArray(R.array.restaurantList))
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            mSpinner.adapter = adapter

            mBuilder.setPositiveButton(
                "Ok"
            ) { dialog, which ->
                if (!mSpinner.selectedItem.toString().equals("Choose a restaurant…", ignoreCase = true)) Boolean
                Toast.makeText(this,mSpinner.selectedItem.toString(),Toast.LENGTH_SHORT).show()
                dialog.dismiss()

            }
            mBuilder.setNegativeButton(
                "Dismiss"
            ) {dialog, which ->
                dialog.dismiss()
            }
            mBuilder.setView(mView)
            val dialog : AlertDialog = mBuilder.create()
            dialog.show()




        }
    }
}