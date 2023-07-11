package com.example.multiplerecyclerview

 class Documents (
    val docEntry: Int,
    val description: String,
    val qtd: String,
    val idCall: Int
        )
fun listaDocs(): List<Documents>{
    val documentsList = listOf(
        Documents(1, "Documento 1", "5", 100),
        Documents(1, "Documento 2", "3", 101),
        Documents(1, "Documento 3", "2", 102),
        Documents(1, "Documento 4", "1", 103),
        Documents(1, "Documento 5", "4", 104),
        Documents(2, "Documento 6", "6", 105),
        Documents(3, "Documento 7", "2", 106),
        Documents(4, "Documento 8", "5", 107),
        Documents(4, "Documento 9", "3", 108),
        Documents(4, "Documento 10", "4", 109)
    )
    return documentsList
}