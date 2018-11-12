package hnu;

import javax.persistence.criteria.CriteriaBuilder;
/**
 * Created by yang on 2018/4/24.
 *
 */

public class Person {
    private Integer id;
    private String name;
    private Integer age ;//为什么写这种代码时，心情是那么舒畅呢

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
