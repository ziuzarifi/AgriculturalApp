package com.example.agriculturalapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.agriculturalapp.R
import com.example.agriculturalapp.databinding.ContactCenterItemBinding
import com.example.agriculturalapp.models.profile.contact_center.Data

class ContactCenterAdapter: RecyclerView.Adapter<ContactCenterAdapter.ContactCenterHolder>() {

    private var contactList: List<Data> = emptyList()

    class ContactCenterHolder(item: View): RecyclerView.ViewHolder(item) {
        private val binding = ContactCenterItemBinding.bind(item)

        fun bind(contact: Data) = with(binding) {
            tvTel.text = contact.phone
            tvMail.text = contact.email
        }
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ContactCenterHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.contact_center_item, p0, false)
        return ContactCenterHolder(view)
    }

    override fun onBindViewHolder(p0: ContactCenterHolder, p1: Int) {
        p0.bind(contactList[p1])
    }

    override fun getItemCount(): Int {
        return contactList.size
    }

    fun setContactInfo(list: List<Data>) {
        contactList = list
    }
}