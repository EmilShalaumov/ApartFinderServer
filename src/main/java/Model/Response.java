package Model;

public class Response {
    private String responseString;
    private Token sessionToken;

    public Response(String responseString, Token token) {
        this.responseString = responseString;
        this.sessionToken = token;
    }

    public String getResponseString() {
        return responseString;
    }

    public Token getSessionToken() {
        return sessionToken;
    }
}
