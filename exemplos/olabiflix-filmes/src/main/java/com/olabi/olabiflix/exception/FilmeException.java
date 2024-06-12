package com.olabi.olabiflix.exception;

public class FilmeException extends RuntimeException {
    public FilmeException(String message){
        super(message);
    }

    public static class FilmeDuplicadoException extends FilmeException{
        public FilmeDuplicadoException(){
            super("Filme já existe no banco de dados");
        }
    }
}
