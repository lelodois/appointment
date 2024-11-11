package com.lelo;

import io.cucumber.java.en.*;

@io.cucumber.spring.CucumberContextConfiguration
@org.springframework.boot.test.context.SpringBootTest(
        webEnvironment = org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
)
public class DefinitionScenes {

    @org.springframework.boot.test.web.server.LocalServerPort
    private int serverPort;

    @Given("I want save {int} appointments")
    public void givenTest(int quantity) throws java.io.IOException {
        com.lelo.Requester requester = new com.lelo.Requester(serverPort);
        for (int index = 0; index < quantity; index++) {
            requester.saveRequest(new AppointmentFixture().buildNew(index));
        }
    }

    @When("When found {int} appointments")
    public void whenTest(int quantity) throws java.io.IOException {
        java.util.ArrayList<com.lelo.appointment.model.Response> responses =
                org.assertj.core.util.Lists.newArrayList(new com.lelo.Requester(serverPort).findAll());
        org.junit.jupiter.api.Assertions.assertEquals(quantity, responses.size());
    }

    @Then("Attach one available appointment to {string}")
    public void thenTest(String officialName) throws java.io.IOException {
        com.lelo.Requester requester = new com.lelo.Requester(serverPort);
        int id = requester.findAllAvailable().iterator().next().getId();
        requester.attach(officialName, id);
    }

    @When("must have {int} appointments available")
    public void whenAvailable(int quantity) throws java.io.IOException {
        Requester requester = new Requester(serverPort);
        java.util.ArrayList<com.lelo.appointment.model.Response> responses =
                org.assertj.core.util.Lists.newArrayList(requester.findAllAvailable());
        org.junit.jupiter.api.Assertions.assertEquals(quantity, responses.size());
    }

    @Then("delete all")
    public void thenDelete() throws java.io.IOException {
        int statusCode = new Requester(serverPort).deleteAll();
        org.junit.jupiter.api.Assertions.assertEquals(200, statusCode);
    }

}