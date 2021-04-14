package org.java.web.logic.service;

import org.java.web.exception.BadRequestException;
import org.java.web.exception.ServerErrorException;

public interface Service<T, E> {
    T doService(E entity) throws BadRequestException, ServerErrorException;
}
