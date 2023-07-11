package com.example.multiplerecyclerview

sealed class DataItem{
    data class Item( val id: Int, val descricao: String):DataItem()
    data class Header(val texto: String): DataItem()
}
