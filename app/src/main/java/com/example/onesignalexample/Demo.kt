package com.example.onesignalexample

import org.w3c.dom.Node

fun main() {
    var data: CustomArrayList<Int> = CustomArrayList()
    data.add(1)
    data.add(2)
    data.add(3)
    data.add(4)
    data.add(5)
    data.add(6)
    data.add(7)
    data.add(8)
    data.add(9)
    data.add(10)
    data.add(11)
    data.add(12)
    System.out.println("Size" + data.size())
    for (i in 0..data.size() - 1) {
        System.out.println("Data" + data.get(i))
    }

    data.remove(2)
    data.removeUsingItem(4)
    System.out.println("AfterSize" + data.size())
    for (i in 0..data.size() - 1) {
        System.out.println("Data" + data.get(i))
    }
    data.add(13)
    data.add(14)
    System.out.println("")
    System.out.println("AddAfterSize" + data.size())
    for (i in 0..data.size() - 1) {
        System.out.println("Data" + data.get(i))
    }
    data.clear()
    System.out.println("ClearAfterSize" + data.size())
}
