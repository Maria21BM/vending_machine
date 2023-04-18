package com.example.vendingmachine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.example.vendingmachine.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        // 1 - Adapter View: ListView
//        var listView = findViewById<ListView>(R.id.listView)

        // 2 - Adapter
        var adapter = MyAdapter(this, generateData())

        binding?.listView?.adapter = adapter
        adapter?.notifyDataSetChanged()
    }

    // 3 - Data Source
    fun generateData(): ArrayList<BeverageModel>{
        var beverageList = ArrayList<BeverageModel>()

        var beverage1: BeverageModel = BeverageModel("Coca Cola", 10, R.drawable.cola)
        var beverage2: BeverageModel = BeverageModel("Fanta", 10, R.drawable.fanta)
        var beverage3: BeverageModel = BeverageModel("Schweppes", 10, R.drawable.schweppes)
        var beverage4: BeverageModel = BeverageModel("Mirinda", 10, R.drawable.mirinda)
        var beverage5: BeverageModel = BeverageModel("Pepsi", 10, R.drawable.pepsi)
        var beverage6: BeverageModel = BeverageModel("Sprite", 10, R.drawable.sprite)
        var beverage7: BeverageModel = BeverageModel("Mountain Dew", 10, R.drawable.mountaindew)
        var beverage8: BeverageModel = BeverageModel("Dr Pepper", 10, R.drawable.drpepper)
        var beverage9: BeverageModel = BeverageModel("Dorna Still Water", 10, R.drawable.dornastillwater)
        var beverage10: BeverageModel = BeverageModel("Dorna Mineral Water", 10, R.drawable.dornamineralwater)


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
}