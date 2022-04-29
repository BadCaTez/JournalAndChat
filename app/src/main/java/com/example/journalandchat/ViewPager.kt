package com.example.journalandchat

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

/** Класс, отвечающий за смену и отображение фграментов **/

class ViewPager(fragmentManager: FragmentActivity): FragmentStateAdapter(fragmentManager) {

    //Функция о получение списка фрагментов, вовзращая числом
    override fun getItemCount(): Int = 5;

    //Функция, возвращающая фрагмент выбраный для отображения
    override fun createFragment(position: Int): Fragment {
        val fragment: Fragment
       when(position){
           0 -> fragment = FragmentMainMenu()
           1 -> fragment = FragmentChat()
           2 -> fragment = FragmentGrabel()
           3 -> fragment = FragmentGroup()
           4 -> fragment = FragmentTimetable()
           else -> fragment = FragmentMainMenu()
       }
        return fragment
    }

}