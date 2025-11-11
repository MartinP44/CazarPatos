package com.posso.martin.cazarpatos

import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    
    private lateinit var emailInputLayout: TextInputLayout
    private lateinit var passwordInputLayout: TextInputLayout
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        
        initializeViews()
        setupLoginButton()
    }
    
    private fun initializeViews() {
        emailInputLayout = findViewById(R.id.emailInputLayout)
        passwordInputLayout = findViewById(R.id.passwordInputLayout)
        emailEditText = findViewById(R.id.emailEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        loginButton = findViewById(R.id.loginButton)
    }
    
    private fun setupLoginButton() {
        loginButton.setOnClickListener {
            validateAndLogin()
        }
    }
    
    private fun validateAndLogin() {
        val email = emailEditText.text.toString().trim()
        val password = passwordEditText.text.toString()
        
        var isValid = true
        
        // Validate email
        if (!isValidEmail(email)) {
            emailInputLayout.error = getString(R.string.error_invalid_email)
            isValid = false
        } else {
            emailInputLayout.error = null
        }
        
        // Validate password (minimum 8 characters)
        if (!isValidPassword(password)) {
            passwordInputLayout.error = getString(R.string.error_invalid_password)
            isValid = false
        } else {
            passwordInputLayout.error = null
        }
        
        if (isValid) {
            // Proceed with login
            emailInputLayout.error = null
            passwordInputLayout.error = null
            // TODO: Implement actual login logic here
        }
    }
    
    private fun isValidEmail(email: String): Boolean {
        return email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
    
    private fun isValidPassword(password: String): Boolean {
        return password.length >= 8
    }
}
