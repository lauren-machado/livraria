package br.inatel.biblioteca.exception;

public class CampoRequeridoException extends RuntimeException {

    public CampoRequeridoException(String msg) {
        super(msg);
    }
}
