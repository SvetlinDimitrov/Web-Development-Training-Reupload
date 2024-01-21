package com;

public class HelloService {
    private final HelloRepo helloRepo;

    public HelloService() {
        this.helloRepo = new HelloRepo();
    }

    public HelloEntity getByCountry(String country){
        return helloRepo.getHelloEntityMap().get(country);
    }
}
