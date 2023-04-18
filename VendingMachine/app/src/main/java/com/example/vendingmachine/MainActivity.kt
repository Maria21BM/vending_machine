package com.example.vendingmachine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.example.vendingmachine.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding ?= null
    var quantity = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        // 1 - Adapter View: ListView
//        var listView = findViewById<ListView>(R.id.listView)

        // 2 - Adapter
        var adapter = MyAdapter(this, generateData())

        binding?.listView?.adapter = adapter
        adapter.notifyDataSetChanged()

        binding?.btnRefill?.setOnClickListener {
            resetQuantity()
            adapter.notifyDataSetChanged()
        }
    }

    // 3 - Data Source
    fun generateData(): ArrayList<BeverageModel>{
        var beverageList = ArrayList<BeverageModel>()

        var beverage1: BeverageModel = BeverageModel("Coca Cola", quantity, R.drawable.cola)
        var beverage2: BeverageModel = BeverageModel("Fanta", quantity, R.drawable.fanta)
        var beverage3: BeverageModel = BeverageModel("Schweppes", quantity, R.drawable.schweppes)
        var beverage4: BeverageModel = BeverageModel("Mirinda", quantity, R.drawable.mirinda)
        var beverage5: BeverageModel = BeverageModel("Pepsi", quantity, R.drawable.pepsi)
        var beverage6: BeverageModel = BeverageModel("Sprite", quantity, R.drawable.sprite)
        var beverage7: BeverageModel = BeverageModel("Mountain Dew", quantity, R.drawable.mountaindew)
        var beverage8: BeverageModel = BeverageModel("Dr Pepper", quantity, R.drawable.drpepper)
        var beverage9: BeverageModel = BeverageModel("Dorna Still Water", quantity, R.drawable.dornastillwater)
        var beverage10: BeverageModel = BeverageModel("Dorna Mineral Water", quantity, R.drawable.dornamineralwater)

        beverageList.add(beverage1)
        beverageList.add(beverage2)
        beverageList.add(beverage3)
        beverageList.add(beverage4)
        beverageList.add(beverage5)
        beverageList.add(beverage6)
        beverageList.add(beverage7)
        beverageList.add(beverage8)
        beverageList.add(beverage9)
        beverageList.add(beverage10)

        return beverageList
    }

    private fun resetQuantity() {
        quantity = 10
        val beverages = generateData()
        (binding?.listView?.adapter as MyAdapter).updateBeverages(beverages)
    }

}