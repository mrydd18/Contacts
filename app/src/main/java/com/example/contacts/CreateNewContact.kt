package com.example.contacts
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.contacts.databinding.ActivityCreateNewContactBinding

class CreateNewContact : AppCompatActivity() {

    private val binding by lazy { ActivityCreateNewContactBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setListeners()
    }

    private fun setListeners() = with(binding) {



        createButton.setOnClickListener {
            val contactNameString = contactName.text.toString()
            val contactNumberString = contactNumber.text.toString().toInt()
            val contact = Contact(contactNameString, contactNumberString)
            ContactsRepository.addContact(contact)
            finish()
        }
    }
}