package Model;

public class Response {
    private Object responseString;
    private Token sessionToken;

    public Response(Object responseString, Token token) {
        this.responseString = responseString;
        this.sessionToken = token;
    }

    public Object getResponseString() {
        return responseString;
    }

    public Token getSessionToken() {
        return sessionToken;
    }
}
