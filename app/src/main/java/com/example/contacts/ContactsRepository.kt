package com.example.contacts

object ContactsRepository {


    private val contacts = mutableListOf<Contact>()

    fun addContact(contact: Contact) {
        contacts.add(contact)
    }

    fun removeContact(contact: Contact) {
        contacts.remove(contact)
    }


    fun getContacts(): List<Contact> {
        return contacts.toList()

    }


}