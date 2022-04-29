package com.example.journalandchat

/**
 * Конструктор типа для получение и дальнешего использования данных новостей
 * Переменные названы, как и свойства объекта JSON для правильного внесения данных
 * name_news - наименования загаловка новостей
 * string_text - текст новости
 * news_date - дата новости
 * **/

data class NewsBD(val name_news: String, val string_text:String, val news_date: String) {}