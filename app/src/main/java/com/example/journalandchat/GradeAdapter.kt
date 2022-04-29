package com.example.journalandchat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

/**
 * Данный класс, отвечает за построенние элемента в списке оценок,
 * который будет отображаться в фрагменте FragmentAdapter
 * **/

class GradeAdapter(private val grade_data: ArrayList<GradeBD>): RecyclerView.Adapter<GradeAdapter.ViewHolderGrade>() {
    //Класс-конструктор, хранящие ссылки элементов view адаптера
    class ViewHolderGrade(itemView: View): RecyclerView.ViewHolder(itemView){
        val subjectname_text: TextView = itemView.findViewById(R.id.subjectname_text)
        val grade_text: TextView = itemView.findViewById(R.id.grade_text)
    }

    //Функция, создающий виды каждого элемента, возвращая в список
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GradeAdapter.ViewHolderGrade {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.adapter_grabel, parent, false)
        return GradeAdapter.ViewHolderGrade(itemView)
    }

    //Процедура, вносящие данные в элементы вида элемента
    override fun onBindViewHolder(holder: GradeAdapter.ViewHolderGrade, position: Int) {
        var string_array: String = ""
        holder.subjectname_text.text = grade_data[position].name
        grade_data[position].grade.forEach { element -> string_array = string_array + element + " "}
        holder.grade_text.text = string_array
    }

    //Подсчёт кол-ва элементов, возвращая их число
    override fun getItemCount(): Int = grade_data.size
}