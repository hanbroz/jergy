package com.edw.jergy.sample.exception;

import com.edw.jergy.sample.domin.Board;
import lombok.extern.java.Log;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.logging.Level;

@Provider
@Log
public class ApiException extends Exception implements ExceptionMapper<ApiException> {

    public ApiException(String string) {
        super(string);
    }

    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public Response toResponse(ApiException exception)
    {
        String msg = exception.getMessage();
        log.log(Level.SEVERE, "ERROR MESSAGE : "+msg);

        Board board = new Board();
        board.setSeq(3);
        board.setTitle("게시물 3번 - "+msg);

        return Response.ok(board).build();
    }
}