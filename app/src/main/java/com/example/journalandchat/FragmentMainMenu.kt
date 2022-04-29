package com.example.journalandchat

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * Класс фрагмента чата, отображая список новостей,
 * отображающийся в элеменетне viewPager, находящийся в MainMenuActivity
 * **/

class FragmentMainMenu: Fragment() {

    //Статичный объект, передающий данные фрагмента в viewPager
    companion object{
        fun newInstate(): FragmentMainMenu{
            return FragmentMainMenu()
        }
    }

    /**
     * adapter - адаптер, для получения элементов и возвращение их в список
     * recyclerView - список элементов чата
     * parser - парсер, обрабатывающий запросов, для вывода данных в списке
     * list - массив, типа класса NewsBD, для получение данных с парсера и
     * их дальнейшего использования
     * **/
    var adapter: NewsAdapter? = null
    lateinit var recyclerView: RecyclerView
    var parser :ParserJSON = ParserJSON()
    private lateinit var list: ArrayList<NewsBD>

    //Функция создания view fragment_news
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        list = parser.getArrayNews(requireContext())
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    //Процедура создания элементов view fragment_news, после его создания
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.list_news)
        loadNews(recyclerView, requireContext())
    }

    //Процедура внесение данных новостей в список
    fun loadNews(recyclerAdapter: RecyclerView, context: Context){
        recyclerAdapter.layoutManager = LinearLayoutManager(context)
        recyclerAdapter.adapter = NewsAdapter(list)
    }
}