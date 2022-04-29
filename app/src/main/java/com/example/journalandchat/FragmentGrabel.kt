package com.example.journalandchat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * Класс фрагмента чата, отображая список оценок по предметам,
 * отображающийся в элеменетне viewPager, находящийся в MainMenuActivity
 * **/

class FragmentGrabel: Fragment() {

    //Статичный объект, передающий данные фрагмента в viewPager
    companion object {
        fun newInstate(): FragmentGrabel {
            return FragmentGrabel()
        }
    }

    /**
     * adapter - адаптер, для получения элементов и возвращение их в список
     * recyclerView - список элементов чата
     * parser - парсер, обрабатывающий запросов, для вывода данных в списке
     * list - массив, типа класса GrabeBD, для получение данных с парсера и
     * их дальнейшего использования
     * **/
    var adapter: GradeAdapter? = null
    lateinit var recyclerView: RecyclerView
    var parser: ParserJSON = ParserJSON()
    private lateinit var list: ArrayList<GradeBD>

    //Функция создания view fragment_grade
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        list = parser.getArrayGrade(requireContext())
        return inflater.inflate(R.layout.fragment_grade, container, false)
    }

    //Процедура создания элементов view fragment_grade, после его создания
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.list_grade)
        loadGrable(recyclerView)
    }

    //Процедура внесение данных о оценках в список
    fun loadGrable(recyclerAdapter: RecyclerView) {
        recyclerAdapter.layoutManager = LinearLayoutManager(context)
        recyclerAdapter.adapter = GradeAdapter(list)
    }
}