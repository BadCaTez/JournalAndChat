package com.example.journalandchat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

/**
 * Данный класс, отвечает за построенние элемента в списке выбора чата,
 * который будет отображаться в фрагменте FragmentChat
 * **/

class ChatSelectAdapter(private val chatSelect_data: ArrayList<ChatSelectBD>):
        RecyclerView.Adapter<ChatSelectAdapter.ViewHolderChatSelect>() {
    //Класс-конструктор, хранящие ссылки элементов view адаптера
    class ViewHolderChatSelect(itemView: View): RecyclerView.ViewHolder(itemView){
        val fc: FragmentChat = FragmentChat()
        val username_text :TextView = itemView.findViewById(R.id.username_text)
        val message_text :TextView = itemView.findViewById(R.id.message_text)
        val date_text :TextView = itemView.findViewById(R.id.date_text)
    }

    //Функция, создающий виды каждого элемента, возвращая в список
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ChatSelectAdapter.ViewHolderChatSelect {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.adapter_selecchat, parent, false)
        return ChatSelectAdapter.ViewHolderChatSelect(itemView)
    }

    //Подсчёт кол-ва элементов, возвращая их число
    override fun getItemCount(): Int = chatSelect_data.size

    //Процедура, вносящие данные в элементы вида элемента
    override fun onBindViewHolder(holder: ViewHolderChatSelect, position: Int) {
        holder.username_text.text = chatSelect_data[position].user_name
        holder.message_text.text = chatSelect_data[position].last_message
        holder.date_text.text = chatSelect_data[position].date_message
    }
}