package com.zhang;

public class BadPerson implements Person {
    private String id;
    private String name;
    private String age;

    public BadPerson() {
    }

    ;

    public BadPerson(String id) {
        this.id = id;
    }

    public BadPerson(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public void read() {

    }
}
