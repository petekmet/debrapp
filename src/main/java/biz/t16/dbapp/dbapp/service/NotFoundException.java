package biz.t16.dbapp.dbapp.service;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException() {
    }
}
