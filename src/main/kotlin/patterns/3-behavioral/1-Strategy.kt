package org.example.patterns.`3-behavioral`

class Order(val description:String, val weight: Int, val price: Int)

interface ShippingStrategy{
    fun deliverOrder(order: Order)
}

class TruckShipping: ShippingStrategy{
    private val fee : Double = 0.05
    override fun deliverOrder(order: Order) = println("a truck is delivering your order: ${order.description}\nFinal price: \$${order.price * (1 + fee)}\n")
}

class BoatShipping: ShippingStrategy{
    private val fee : Double = 0.10
    override fun deliverOrder(order: Order) = println("a boat is delivering your order: ${order.description}\nFinal price: \$${order.price * (1 + fee)}\n")
}

class PlaneShipping: ShippingStrategy{
    private val fee : Double = 0.20
    override fun deliverOrder(order: Order) = println("a plane is delivering your order: ${order.description}\nFinal price: \$${order.price * (1+fee)}\n")
}


fun main(){
    val order = Order("order#1", 2, 150)
    val truckShipping = TruckShipping()
    val boatShipping = BoatShipping()
    val planeShipping = PlaneShipping()

    deliver(order, truckShipping)
    deliver(order, boatShipping)
    deliver(order, planeShipping)
}

fun deliver(order: Order, shippingStrategy: ShippingStrategy){
    shippingStrategy.deliverOrder(order)
}