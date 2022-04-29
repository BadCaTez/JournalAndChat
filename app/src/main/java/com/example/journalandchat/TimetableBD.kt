package com.example.journalandchat

/**
 * Конструктор типа для получение и дальнешего использования данных о рассписании группы
 * Переменные названы, как и свойства объекта JSON для правильного внесения данных
 * time_text - дата написания рассписания
 * day_week - дата буднего дня
 * name_less - список наименования предметов в будний день
 * **/

data class TimetableBD(val time_text: String, val day_week: String, val name_les: List<String>) {}