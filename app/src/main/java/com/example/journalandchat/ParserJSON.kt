package com.example.journalandchat

import android.content.Context
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Класс, отвечающий за парсировку данных Json и последующего
 * использования в списках фрагментов
 * **/

class ParserJSON: AppCompatActivity() {
    //Данная переменная вызывает функцию библиотеки Gson, для парсировки дданных
    val gson = Gson()

    //Функция, обрабатывающий запрос под более понятный формат приложению
    fun getJsonArray(context: Context, fileName: String):String?{
        Log.i("data", "Идёт парсировка")
        val jsonString: String = context.assets.open(fileName).bufferedReader().use{it.readText()}
        Log.i("data", jsonString)
        return jsonString
    }

    /**
     * Дальнейшие методы обрабатывают jsonString,рабирая его на данные для массива и возвращая его в
     * списки
     * list* - класс-тип
     * *_Array - массив, заполняющий данными для использования в списках фрагментов
     * **/
    fun getArrayNews(context: Context): ArrayList<NewsBD>{
        val listNews = object : TypeToken<ArrayList<NewsBD>>() {}.type
        val news_Array: ArrayList<NewsBD> =
                gson.fromJson(getJsonArray(context, "NewsJson.json"), listNews)
        news_Array.forEachIndexed { id, tut -> Log.i("data", "> Item ${id}:\n ${tut}") }
        return news_Array
    }

    fun getArrayChatSelect(context: Context): ArrayList<ChatSelectBD>{
        val listChatSelect = object : TypeToken<ArrayList<ChatSelectBD>>() {}.type
        val chatSelect_Array: ArrayList<ChatSelectBD> =
                gson.fromJson(getJsonArray(context, "ChatSelectJson.json"), listChatSelect)
        chatSelect_Array.forEachIndexed {
            id, tut -> Log.i("data", "> Item ${id}:\n ${tut}") }
        return chatSelect_Array
    }

    fun getArrayGrade(context: Context): ArrayList<GradeBD>{
        val listGrade = object : TypeToken<ArrayList<GradeBD>>() {}.type
        val grade_Array: ArrayList<GradeBD> =
                gson.fromJson(getJsonArray(context, "GradeJson.json"), listGrade)
        grade_Array.forEachIndexed { id, tut -> Log.i("data", "> Item ${id}:\n ${tut}") }
        return grade_Array
    }

    fun getArrayGroup(context: Context): ArrayList<GroupBD>{
        val listGroup = object : TypeToken<ArrayList<GroupBD>>() {}.type
        val group_Array: ArrayList<GroupBD> =
                gson.fromJson(getJsonArray(context, "GroupJson.json"), listGroup)
        group_Array.forEachIndexed { id, tut -> Log.i("data", "> Item ${id}:\n ${tut}") }
        return group_Array
    }

    fun getArrayTimetable(context: Context): ArrayList<TimetableBD>{
        val listTimetable = object : TypeToken<ArrayList<TimetableBD>>() {}.type
        val timetable_Array: ArrayList<TimetableBD> =
                gson.fromJson(getJsonArray(context, "TimeTableJson.json"), listTimetable)
        timetable_Array.forEachIndexed {
            id, tut -> Log.i("data", "> Item ${id}:\n ${tut}") }
        return timetable_Array
    }
    /**_________________________________________________________________________________________**/
}