package com.example.journalandchat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * Данный класс, отвечает за построенние элемента в списке новостей,
 * который будет отображаться в фрагменте FragmentMainMenu
 * **/

class NewsAdapter(private val news_data: ArrayList<NewsBD>) : RecyclerView.Adapter<NewsAdapter.ViewHolderNews>() {
    //Класс-конструктор, хранящие ссылки элементов view адаптера
    class ViewHolderNews(itemView: View): RecyclerView.ViewHolder(itemView){
         val nameNews: TextView = itemView.findViewById(R.id.text_nameNews)
         val textNews: TextView = itemView.findViewById(R.id.text_textNews)
         val dataNews: TextView = itemView.findViewById(R.id.text_dataNews)
         val imageNews: ImageView = itemView.findViewById(R.id.image_imageNews)
     }

    //Функция, создающий виды каждого элемента, возвращая в список
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderNews {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.adapter_news, parent, false)
        return ViewHolderNews(itemView)
    }

    //Процедура, вносящие данные в элементы вида элемента
    override fun onBindViewHolder(holder: ViewHolderNews, position: Int) {
        holder.nameNews.text = news_data[position].name_news
        holder.textNews.text = news_data[position].string_text
        holder.dataNews.text = news_data[position].news_date
        holder.imageNews.setImageResource(R.drawable.test_pictuer)
    }

    //Подсчёт кол-ва элементов, возвращая их число
    override fun getItemCount() = news_data.size
}