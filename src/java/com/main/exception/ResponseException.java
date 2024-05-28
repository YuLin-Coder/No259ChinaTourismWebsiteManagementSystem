package com.main.exception;


import com.main.Response;

public class ResponseException extends Exception {

    protected Response mResponse = null;
    public ResponseException(Response response)
    {
        mResponse = response;
    }

    public Response getResponse() {
        return mResponse;
    }
}
