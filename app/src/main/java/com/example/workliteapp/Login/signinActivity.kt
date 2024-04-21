package com.example.workliteapp.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil.setContentView
import com.example.workliteapp.HomeActivity
import com.example.workliteapp.ProfileActivity

import com.example.workliteapp.R
import com.example.workliteapp.RewardActivity
import com.example.workliteapp.databinding.ActivitySigninBinding


class signinActivity : AppCompatActivity(){
 private lateinit var binding: ActivitySigninBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding=ActivitySigninBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.loginButton.setOnClickListener {
           val intent=Intent(this,RewardActivity::class.java)
            startActivity(intent)
            finish()

        }
    }
}