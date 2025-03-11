package com.maxlvshv.urfutask.exception;

/**
 * Исключение, которое выбрасывается, когда пытаются создать сущность,
 * которая уже существует в системе.
 *
 * Это исключение может использоваться для обработки случаев, когда
 * пользователь пытается добавить дубликат сущности, например, при
 * регистрации пользователя с уже существующим именем.
 */
public class EntityAlreadyExistsException extends RuntimeException {
    public EntityAlreadyExistsException(String message) {
        super(message);
    }
}
