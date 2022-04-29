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
 * Класс фрагмента чата, отображая список чатов пользователя,
 * отображающийся в элеменетне viewPager, находящийся в MainMenuActivity
 * **/

class FragmentChat: Fragment(){

    //Статичный объект, передающий данные фрагмента в viewPager
    companion object{
        fun newInstate(): FragmentChat{
            return FragmentChat()
        }
    }

    /**
     * adapter - адаптер, для получения элементов и возвращение их в список
     * recyclerView - список элементов чата
     * parser - парсер, обрабатывающий запросов, для вывода данных в списке
     * list - массив, типа класса ChatSelectBD, для получение данных с парсера и
     * их дальнейшего использования
     * **/
    var adapter: ChatSelectAdapter? = null
    private lateinit var recyclerView: RecyclerView
    var parser :ParserJSON = ParserJSON()
    private lateinit var list: ArrayList<ChatSelectBD>

    //Функция создания view fragment_chat
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        list = parser.getArrayChatSelect(requireContext())
        return inflater.inflate(R.layout.fragment_chat, container, false)
    }

    //Процедура создания элементов view fragment_chat, после его создания
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById<RecyclerView>(R.id.list_chat)
        loadChatList(recyclerView, requireContext())
    }

    //Процедура внесение данных о чатах в список
    fun loadChatList(recyclerAdapter: RecyclerView, context: Context){
        recyclerAdapter.layoutManager = LinearLayoutManager(context)
        recyclerAdapter.adapter = ChatSelectAdapter(list)
    }
}