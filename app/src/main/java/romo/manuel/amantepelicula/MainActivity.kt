package romo.manuel.amantepelicula

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tvUserName = findViewById<EditText>(R.id.etUserName)
        val tvPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<TextView>(R.id.btnLogIn)

        btnLogin.setOnClickListener {

            val userName : String = tvUserName.text.toString().trim()
            val password : String = tvPassword.text.toString().trim()

            if(userName == "" || password == ""){
                Toast.makeText(this, "Usuario y/o contraseña inválidos", Toast.LENGTH_SHORT).show();
            } else{
                val intent = Intent(this, ActivityMovie::class.java)
                startActivity(intent)
            }

        }

    }
}