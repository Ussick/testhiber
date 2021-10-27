package ua.itea.dto;

import java.util.Objects;

public class UserDto {
    private int id;
    private String login;
    private String name;
    private String password;
    private String gender;
    private String region;
    private String comment;

    public UserDto() {
    }

    public int getId() {
        return id;
    }

    public UserDto setId(int id) {
        this.id = id;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public UserDto setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public UserDto setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getRegion() {
        return region;
    }

    public UserDto setRegion(String region) {
        this.region = region;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public UserDto setComment(String comment) {
        this.comment = comment;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto that = (UserDto) o;
        return id == that.id && login.equals(that.login) && name.equals(that.name) && password.equals(that.password) && gender.equals(that.gender) && region.equals(that.region) && Objects.equals(comment, that.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login);
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", region='" + region + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
