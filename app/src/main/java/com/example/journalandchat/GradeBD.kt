package com.example.journalandchat

/**
 * Конструктор типа для получение и дальнешего использования данных о оценках
 * Переменные названы, как и свойства объекта JSON для правильного внесения данных
 * name - наименование предметов
 * grade - оценки предмета
 * **/
data class GradeBD (val name: String, val grade: List<String>) {}
