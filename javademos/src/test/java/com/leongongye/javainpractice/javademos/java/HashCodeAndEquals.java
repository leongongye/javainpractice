/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.java;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author leon
 * @version $Id: HashCodeAndEquals.java, v 0.1 2017年7月29日 下午3:56:30 leon Exp $
 */
public class HashCodeAndEquals {
    public static void main(String[] args) {
        Boy b1 = new Boy("a", 1, 1);
        Boy b2 = new Boy("b", 1, 1);

        ArrayList<Boy> bl = new ArrayList<>();
        bl.add(b1);
        bl.add(b2);

        System.out.println(bl.contains(new Boy("a", 2, 2)));

        HashMap<Boy, Integer> bh = new HashMap<>();

    }
}

class Boy {
    private String name;
    private int    sex;
    private int    age;

    /**
     *
     */
    public Boy(String name, int sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int hashCode() {
        System.out.println("hhh");
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + sex;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("eee");
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Boy other = (Boy) obj;
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        if (sex != other.sex) {
            return false;
        }
        return true;
    }

}