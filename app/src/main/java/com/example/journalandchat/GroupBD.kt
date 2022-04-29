package com.example.journalandchat

/**
 * Конструктор типа для получение и дальнешего использования данных о учасиниках группы
 * Переменные названы, как и свойства объекта JSON для правильного внесения данных
 * id_account - id пользователя
 * name - имя пользователя
 * type_account - роль пользователя в группе
 * **/
data class GroupBD(val id_account: String, val name: String, val type_account: String) {
}