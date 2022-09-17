package com.edw.jergy.sample.controller;

import com.edw.jergy.sample.domin.Board;
import com.edw.jergy.sample.exception.ApiException;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("/")
public class HomeController {
    @GET
    @Path("/")
    public String index(){
        return "Index";
    }

    @GET
    @Path("/board")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBoard() {
        Board board = new Board();
        board.setSeq(1);
        board.setTitle("게시물 1번");

        return Response.ok(board).build();
    }

    @GET
    @Path("/exception")
    @Produces(MediaType.APPLICATION_JSON)
    public Response throwException() throws ApiException {
        Board board = new Board();
        board.setSeq(2);
        board.setTitle("게시물 2번");

        if(true) {
            throw new ApiException("게시물에서 오류가 발생합니다.");
        }

        return Response.ok(board).build();
    }
}
