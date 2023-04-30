package com.example.firecloudchat_app

class Car {
    var car_make:String? = null
    var car_model:String? = null
    var car_price:String? = null
    var car_photo:String? = null

    constructor(car_make:String, car_model:String, car_price:String, car_photo:String) {
        this.car_make = car_make
        this.car_model = car_model
        this.car_price = car_price
        this.car_photo = car_photo
    }

    constructor()

}