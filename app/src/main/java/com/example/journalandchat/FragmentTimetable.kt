package com.example.journalandchat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

/**
 * Класс фрагмента чата, отображая рассписания группы,
 * отображающийся в элеменетне viewPager, находящийся в MainMenuActivity
 * **/

class FragmentTimetable : Fragment() {

    //Статичный объект, передающий данные фрагмента в viewPager
    companion object{
        fun newInstate(): FragmentTimetable{
            return FragmentTimetable()
        }
    }

    /**
     * parser - парсер, обрабатывающий запросов, для вывода данных в списке
     * list - массив, типа класса TimetabelBD, для получение данных с парсера и
     * их дальнейшего использования
     * **/
    var parser :ParserJSON = ParserJSON()
    private lateinit var list: ArrayList<TimetableBD>

    //данные списки хранят ссылки о элементах TextView, буднях, для оптимизированного заполнеия
    val monText: List<Int> = listOf(R.id.monLes_text1, R.id.monLes_text2, R.id.monLes_text3,
            R.id.monLes_text4, R.id.monLes_text5, R.id.monLes_text6)
    val tuesText: List<Int> = listOf(R.id.tuesLes_text1, R.id.tuesLes_text2, R.id.tuesLes_text3,
            R.id.tuesLes_text4, R.id.tuesLes_text5, R.id.tuesLes_text6)
    val wedText: List<Int> = listOf(R.id.wesLes_text1, R.id.wesLes_text2, R.id.wesLes_text3,
            R.id.wesLes_text4, R.id.wesLes_text5, R.id.wesLes_text6)
    val thurText: List<Int> = listOf(R.id.thurLes_text1, R.id.thurLes_text2, R.id.thurLes_text3,
            R.id.thurLes_text4, R.id.thurLes_text5, R.id.thurLes_text6)
    val friText: List<Int> = listOf(R.id.friLes_text1, R.id.friLes_text2, R.id.friLes_text3,
            R.id.friLes_text4, R.id.friLes_text5, R.id.friLes_text6)

    //Функция создания view fragment_timetable
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        list = parser.getArrayTimetable(requireContext())
        return inflater.inflate(R.layout.fragment_timetable, container, false)
    }

    //Процедура создания элементов view fragment_timetable, после его создания
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        for(i in 0..list.size - 1){
            when(list[i].day_week){
                "MONDAY" -> enterDayWeek(list[i].name_les, monText,
                        list[i].day_week, R.id.monTime_text, view)
                "TUESDAY" -> enterDayWeek(list[i].name_les, tuesText,
                        list[i].day_week, R.id.tuesTime_text, view)
                "WEDNESDAY" -> enterDayWeek(list[i].name_les, wedText,
                        list[i].day_week, R.id.wesTime_text, view)
                "THURSDAY" -> enterDayWeek(list[i].name_les, thurText,
                        list[i].day_week, R.id.thurTime_text, view)
                "FRIDAY" -> enterDayWeek(list[i].name_les, friText,
                        list[i].day_week, R.id.friTime_text, view)
            }
        }
    }

    //Процедура внесение данных рассписания в список
    private lateinit var time_text: TextView
    private lateinit var les_text: TextView
    private fun enterDayWeek(listDay: List<String>, listText: List<Int>, dayWeek: String, textDayWeek: Int, view: View){
        time_text = view.findViewById(textDayWeek)
        time_text.text = dayWeek
        for(i in 0..listText.size - 1)
        {
            les_text = view.findViewById(listText[i])
            les_text.text = listDay[i]
        }
    }
}