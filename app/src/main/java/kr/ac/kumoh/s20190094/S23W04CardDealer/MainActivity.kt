package kr.ac.kumoh.s20190094.S23W04CardDealer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import kr.ac.kumoh.s20190094.S23W04CardDealer.databinding.ActivityMainBinding
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    private lateinit var main: ActivityMainBinding
    private lateinit var model:CardDealerViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        main = ActivityMainBinding.inflate(layoutInflater)
        model = ViewModelProvider(this)[CardDealerViewModel::class.java]
        model.cards.observe(this, {
            val res = IntArray(5)
            for (i in res.indices) {
                res[i] = resources.getIdentifier(
                    getCardName(res[i]),
                    "drawable",
                    packageName
                )
            }

            main.card1.setImageResource(res[0])
//            main.card2.setImageResource(res[1])
//            main.card3.setImageResource(res[2])
//            main.card4.setImageResource(res[3])
//            main.card5.setImageResource(res[4])
        })
        //setContentView(R.layout.activity_main)
        main.btnShuffle.setOnClickListener {
            model.shuffle()
        }
        setContentView(main.root)

        //binding.card1.setImageResource(R.drawable.c_2_of_hearts)
        val c = Random.nextInt(52)
        Log.i("Test", "$c : ${getCardName(c)}")

        val res = resources.getIdentifier(
            getCardName(c),
            "drawable",
            packageName
        )

        main.card1.setImageResource(res)
    }

    private fun getCardName(c: Int) : String {
        val shape = when (c / 13) {
            0 -> "spades"
            1 -> "diamonds"
            2 -> "hearts"
            3 -> "clubs"
            else -> "error"
        }

        val number = when (c % 13) {
            0 -> "ace"
            in 1..9 -> (c % 13 + 1).toString()
            10 -> "jack"
            11 -> "queen"
            12 -> "king"
            else -> "error"
        }
        return "c_${number}_of_${shape}"
    }
}