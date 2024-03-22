package com.example.opscfirstproject

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.opscfirstproject.databinding.ActivityOrderDetailsBinding

class orderDetailsActivity : AppCompatActivity() {
    var order = Order()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityOrderDetailsBinding.inflate(layoutInflater)

        order.productName = intent.getStringExtra("order").toString()

        binding.cDrinkName.text = order.productName

        when(order.productName)
        {
            "Soy Latte" -> binding.ImgDrink.setImageResource(R.drawable.sb1)
            "Chocco Frapp"  -> binding.ImgDrink.setImageResource(R.drawable.sb2)
            "Bottled Americano"  -> binding.ImgDrink.setImageResource(R.drawable.sb3)
            "Rainbow Frapp"  -> binding.ImgDrink.setImageResource(R.drawable.sb4)
            "Caramel Frapp"  -> binding.ImgDrink.setImageResource(R.drawable.sb5)
            "Black Forest Frapp"  -> binding.ImgDrink.setImageResource(R.drawable.sb6)
        }

        binding.fab.setOnClickListener()
        {
            shareIntent(applicationContext, order.productName)
        }
        enableEdgeToEdge()
        setContentView(R.layout.activity_order_details)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}