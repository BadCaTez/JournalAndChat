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
 * Класс фрагмента чата, отображая список пользователей в группе,
 * отображающийся в элеменетне viewPager, находящийся в MainMenuActivity
 * **/


class FragmentGroup: Fragment() {

    //Статичный объект, передающий данные фрагмента в viewPager
    companion object{
        fun newInstate(): FragmentGroup{
            return FragmentGroup()
        }
    }


    /**
     * adapter - адаптер, для получения элементов и возвращение их в список
     * recyclerView - список элементов чата
     * parser - парсер, обрабатывающий запросов, для вывода данных в списке
     * list - массив, типа класса GroupBD, для получение данных с парсера и
     * их дальнейшего использования
     * **/
    var adapter: GroupAdapter? = null
    lateinit var recyclerView: RecyclerView
    var parser :ParserJSON = ParserJSON()
    private lateinit var list: ArrayList<GroupBD>

    //Функция создания view fragment_group
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        list = parser.getArrayGroup(requireContext())
        return inflater.inflate(R.layout.fragment_group, container, false)
    }

    //Процедура создания элементов view fragment_group, после его создания
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.list_group)
        loadGroup(recyclerView, requireContext())
    }

    //Процедура внесение данных пользователей группы в список
    fun loadGroup(recyclerAdapter: RecyclerView, context: Context){
        recyclerAdapter.layoutManager = LinearLayoutManager(context)
        recyclerAdapter.adapter = GroupAdapter(list)
    }
}