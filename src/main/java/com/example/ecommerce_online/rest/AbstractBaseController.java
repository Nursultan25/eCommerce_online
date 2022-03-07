package com.example.ecommerce_online.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface AbstractBaseController<T> {
    public ResponseEntity<?> create(T t);
    public ResponseEntity<?> getAll();
    public ResponseEntity<?> get(Long id);
    public ResponseEntity<?> update(T t);
    public ResponseEntity<?> delete(Long id);
}
