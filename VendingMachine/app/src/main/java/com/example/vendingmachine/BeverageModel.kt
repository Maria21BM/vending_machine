package com.example.vendingmachine

class BeverageModel {

    var name : String = ""
    var quantity: Int = 0
    var beverage_img : Int = 0

    constructor(name: String, quantity: Int, beverage_img: Int) {
        this.name = name
        this.quantity = quantity
        this.beverage_img = beverage_img
    }
}