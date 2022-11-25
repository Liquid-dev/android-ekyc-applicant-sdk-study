package com.example.sdk.demoapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.sdk.ExampleSdk
import com.example.sdk.demoapp.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        binding.content.nonInteractiveFunctionButton.setOnClickListener {
            startNonInteractiveFunction()
        }
        binding.content.interactiveFunctionButton.setOnClickListener {
            startInteractiveFunction()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> {
                startActivity(
                    Intent(
                        Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                        Uri.fromParts("package", applicationContext.packageName, null)
                    )
                )
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        ExampleSdk.getInstance(applicationContext)
            .handleInteractiveFunctionResult(
                requestCode, resultCode
            ) {
                showResult(it)
            }
    }

    private fun startNonInteractiveFunction() {
        val parameter = binding.content.parameterEditText.text?.toString()
        ExampleSdk.getInstance(applicationContext)
            .nonInteractiveFunction(parameter) {
                showResult(it)
            }
    }

    private fun startInteractiveFunction() {
        val parameter = binding.content.parameterEditText.text?.toString()
        ExampleSdk.getInstance(applicationContext)
            .interactiveFunction(parameter, this)
    }

    private fun showResult(result: Any) {
        Snackbar.make(binding.root, "result = $result", Snackbar.LENGTH_LONG)
            .setAction("Done", null).show()
    }

}