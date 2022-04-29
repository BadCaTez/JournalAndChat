package com.example.journalandchat

/**
 * Конструктор типа для получение и дальнешего использования данных о чатах
 * Переменные названы, как и свойства объекта JSON для правильного внесения данных
 * id_chat - id чата
 * user_name - имя пользователя
 * last_message - последнее сообщение
 * date_message - дата последнего сообщения
 * **/
data class ChatSelectBD (val id_chat: String, val user_name: String,
                         val last_message: String, val date_message: String) {}