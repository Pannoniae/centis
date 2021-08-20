package com.example.happybirthday

fun cmToPixels(): Int {
    return 50
}
fun mmToPixels(): Int {
    return cmToPixels() / 10
}

fun getMaxDeviceSizeInCm(): Int {
    return 50 * 15;
}