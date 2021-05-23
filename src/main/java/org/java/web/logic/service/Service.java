package org.java.web.logic.service;

import org.java.web.exception.BadRequestException;
import org.java.web.exception.ServerErrorException;

import java.io.IOException;

public interface Service<T, E> {
    T doService(E entity) throws BadRequestException, ServerErrorException, IOException;
}
