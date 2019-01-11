package com.evite.giphytest.utils

class ArraysUtils {
    companion object {
        @JvmStatic fun contains(array: IntArray?, item: Int): Boolean {
            if (array == null) {
                return false
            } else {
                val size = array.size

                for (index in 0 until size) {
                    if (array[index] == item) {
                        return true
                    }
                }
                return false
            }
        }
    }
}
