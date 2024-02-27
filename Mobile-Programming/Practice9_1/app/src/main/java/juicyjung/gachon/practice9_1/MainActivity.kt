package juicyjung.gachon.practice9_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import juicyjung.gachon.practice9_1.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var count: Int = 0

        binding.textview.text = count.toString()

        binding.btn.setOnClickListener{
            count++
            binding.textview.text = count.toString()
        }
    }
}