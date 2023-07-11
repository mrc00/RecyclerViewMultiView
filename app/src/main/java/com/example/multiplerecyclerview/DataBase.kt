package com.example.multiplerecyclerview

object DataBase {
    const val TYPE_HEADER = 1
    const val TYPE_ITEM = 0
    val docs = listaDocs()
    fun getItens(): ArrayList<Any> {
        val itemlist = arrayListOf<Any>()
        var docAtual = ""
        for (documents in docs) {
            if (documents.docEntry.toString() != docAtual) {
                docAtual = documents.docEntry.toString()
                itemlist.add(DataItem.Header(docAtual))
            }
            var id = 1
            itemlist.add(DataItem.Item(id, documents.description))
            id++
        }
        return itemlist
    }
}