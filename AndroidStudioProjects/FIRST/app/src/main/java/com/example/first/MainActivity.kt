package com.example.first

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.example.first.databinding.ActivityMainBinding

class MainActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GreetingCardTheme {
// A surface container using the 'background color from
                Surface(
                    modifier Modifier.fillMaxSize(),
                    color MaterialTheme.colorScheme.background
                ) {
                    Greeting(name: "Android")
                }
            }
        }
    }
}
@Composable
fun Greeting (name: String, modifier: Modifier Modifier) {
    androidx.compose.foundation.layout.Box {
        Text(
            text = "Hello $name!",
            modifier modifier
        )
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Greeting CardTheme {
        Greeting(name: "Android")
    }




}