package com.lelo;

public class Requester {

    private final int serverPort;

    public Requester(int serverPort) {
        this.serverPort = serverPort;
    }

    private String getServerPath() {
        return "http://localhost:" + serverPort;
    }

    public void saveRequest(com.lelo.appointment.model.Request request) throws java.io.IOException {
        String json = new com.google.gson.Gson().toJson(request);

        int statusCode =
                org.apache.http.client.fluent.Request
                        .Post(getServerPath() + "/appointment")
                        .addHeader("Content-Type", "application/json")
                        .bodyString(json, org.apache.http.entity.ContentType.APPLICATION_JSON)
                        .execute()
                        .returnResponse()
                        .getStatusLine()
                        .getStatusCode();

        org.junit.jupiter.api.Assertions.assertEquals(200, statusCode);
    }

    public java.util.List<com.lelo.appointment.model.Response> findAllAvailable() throws java.io.IOException {
        String jsonResponse =
                org.apache.http.client.fluent.Request
                        .Get(getServerPath() + "/appointments/available")
                        .addHeader("Content-Type", "application/json")
                        .execute()
                        .returnContent()
                        .asString();
        return java.util.List.of(new com.google.gson.Gson().fromJson(jsonResponse, com.lelo.appointment.model.Response[].class));
    }

    public java.util.List<com.lelo.appointment.model.Response> findAll() throws java.io.IOException {
        String jsonResponse =
                org.apache.http.client.fluent.Request
                        .Get(getServerPath() + "/appointments")
                        .addHeader("Content-Type", "application/json")
                        .execute()
                        .returnContent()
                        .asString();
        return java.util.List.of(new com.google.gson.Gson().fromJson(jsonResponse, com.lelo.appointment.model.Response[].class));
    }

    public void attach(String officer, int id) throws java.io.IOException {
        int statusCode =
                org.apache.http.client.fluent.Request
                        .Put(getServerPath() + "/officer/" + officer + "/attach/" + id)
                        .addHeader("Content-Type", "application/json")
                        .execute()
                        .returnResponse()
                        .getStatusLine()
                        .getStatusCode();

        org.junit.jupiter.api.Assertions.assertEquals(200, statusCode);
    }

    public int deleteAll() throws java.io.IOException {
        return org.apache.http.client.fluent.Request
                .Delete(getServerPath() + "/appointments/all")
                .addHeader("Content-Type", "application/json")
                .execute()
                .returnResponse()
                .getStatusLine()
                .getStatusCode();
    }
}
