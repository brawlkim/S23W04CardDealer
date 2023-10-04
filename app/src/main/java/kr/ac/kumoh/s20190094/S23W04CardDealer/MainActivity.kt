package kr.ac.kumoh.s20190094.S23W04CardDealer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import kr.ac.kumoh.s20190094.S23W04CardDealer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var main: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        main = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_main)
        setContentView(main.root)

        main.card1.setImageResource(R.drawable.c_2_of_hearts)
    }
}