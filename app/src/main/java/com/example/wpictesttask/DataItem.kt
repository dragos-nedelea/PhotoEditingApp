package com.example.wpictesttask

sealed class DataItemTypes {

    object ItemHeaderLayout : DataItemTypes()

    object ItemContentLayout : DataItemTypes()

    data class ItemFooter(val imageResIds: List<Int>) : DataItemTypes()

}