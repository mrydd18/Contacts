package com.example.contacts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.contacts.databinding.ItemContactsBinding

class ContactsAdapter : RecyclerView.Adapter<ContactsAdapter.ContactsViewHolder>() {

    private var contacts = listOf<Contact>()

    var onDeleteClick: (Contact) -> Unit = {}
    var onItemClick: (Contact) -> Unit = {}

    fun setContacts(newContacts: List<Contact>) {
        contacts = newContacts
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {

        val binding = ItemContactsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return ContactsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {
        val contact = contacts[position]
        holder.bind(contact)
    }

    override fun getItemCount(): Int = contacts.size

    inner class ContactsViewHolder(private val binding: ItemContactsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(contact: Contact) {
            binding.profileImageView.text = contact.name.first().toString()
            binding.numberTextView.text = contact.contactNumber.toString()

            binding.trashButton.setOnClickListener {
                onDeleteClick(contact)
            }
            binding.itemContacts.setOnClickListener {
                onItemClick(contact)
            }
        }
    }
}