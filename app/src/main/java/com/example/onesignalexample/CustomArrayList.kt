package com.example.onesignalexample

import java.lang.IndexOutOfBoundsException
import java.util.*

class CustomArrayList<Type> {
    private var data: Array<Type?>
    private var position = 0;

    constructor() {
        data = arrayOfNulls<Any>(1) as Array<Type?>
    }

    constructor(size: Int) {
        data = arrayOfNulls<Any>(size) as Array<Type?>
    }

    fun add(item: Type) {
        if (position <= data.size - 1) {
            data[position] = item
            position++
        } else {
            var newdata: Array<Type?> = arrayOfNulls<Any>(data.size + 1) as Array<Type?>
            System.arraycopy(data, 0, newdata, 0, data.size)
            data = newdata
            data[position] = item
            position++
        }
    }

    fun remove(index: Int) {
        checkBoundExclusive(index)
        var size = data.size
        if (index != --size)
            System.arraycopy(data, index + 1, data, index, size - index)

        data[size] = null
        position--
    }
    fun clear() {
        if (data.size > 0) {
            Arrays.fill(data, 0, data.size, null);
            position = 0
        }
    }

    fun removeUsingItem(data: Type) {
        var index = getIndex(data)
        remove(index)
    }

    fun getIndex(item: Type): Int {
        var index: Int = -1
        for (i in 0..data.size - 1) {
            if (item is String) {
                if (data[i].toString().equals(item)) {
                    index = i
                    break
                }
            } else {
                if (data[i] == item) {
                    index = i
                    break
                }
            }
        }
        return index
    }

    private fun checkBoundExclusive(index: Int) {
        if (index >= data.size - 1) {
            throw IndexOutOfBoundsException("Index: " + index + ", Size: " + data.size)
        }
    }

    fun get(index: Int): Type? {
        return data.get(index)
    }

    fun size(): Int {
        var size = 0
        for (i in data) {
            if (i != null) {
                size++
            }
        }
        return size
    }
}