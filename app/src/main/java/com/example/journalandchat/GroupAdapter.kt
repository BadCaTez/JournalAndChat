package com.example.journalandchat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList


/**
 * Данный класс, отвечает за построенние элемента в списке участников группы,
 * который будет отображаться в фрагменте FragmentGroup
 * **/
class GroupAdapter (private val group_data: ArrayList<GroupBD>):
        RecyclerView.Adapter<GroupAdapter.ViewHolderGroup>() {
    //Класс-конструктор, хранящие ссылки элементов view адаптера
    class ViewHolderGroup(itemView: View): RecyclerView.ViewHolder(itemView){
        val name_text: TextView = itemView.findViewById(R.id.namePerson_text)
        val type_text: TextView = itemView.findViewById(R.id.type_text)
    }

    //Функция, создающий виды каждого элемента, возвращая в список
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            GroupAdapter.ViewHolderGroup {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.adapter_group, parent, false)
        return GroupAdapter.ViewHolderGroup(itemView)
    }

    //Процедура, вносящие данные в элементы вида элемента
    override fun onBindViewHolder(holder: GroupAdapter.ViewHolderGroup, position: Int) {
        holder.name_text.text = group_data[position].name
        holder.type_text.text = group_data[position].type_account
    }

    //Подсчёт кол-ва элементов, возвращая их число
    override fun getItemCount() = group_data.size
}