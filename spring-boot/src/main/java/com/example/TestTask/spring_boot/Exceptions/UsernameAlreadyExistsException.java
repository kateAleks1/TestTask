package com.example.TestTask.spring_boot.Exceptions;

public class UsernameAlreadyExistsException extends RuntimeException {

    // Конструктор, который принимает сообщение об ошибке
    public UsernameAlreadyExistsException(String message) {
        super(message);  // Передаем сообщение в родительский класс RuntimeException
    }

    // Конструктор, который принимает сообщение и причину ошибки
    public UsernameAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);  // Передаем сообщение и причину в родительский класс
    }
}