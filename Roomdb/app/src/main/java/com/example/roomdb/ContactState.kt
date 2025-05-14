package com.example.roomdb

data class ContactState(
    val contacts: List<Contact> = emptyList(),
    val firstName: String = "",
    val lastName: String = "",
    val phoneNumber: String = "",
    val showDialog: Boolean = false,
    val sortType: SortType = SortType.FIRST_NAME,
    val isAddingContact: Boolean = false
)
