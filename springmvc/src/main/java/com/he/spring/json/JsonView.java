package com.he.spring.json;

/**
 * Created by heyanjing on 2017/11/27 14:53.
 */
public class JsonView {
    public interface Name {
    }

    public interface NameAndAge extends Name {
    }

    public interface NameAndAgeAndBirthday extends NameAndAge {
    }
}
