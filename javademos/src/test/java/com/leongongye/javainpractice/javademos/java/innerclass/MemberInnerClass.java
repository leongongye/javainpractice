/*
 * Zenlayer.com Inc.
 * Copyright (c) 2014-2021 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.java.innerclass;

import com.leongongye.javainpractice.javademos.java.innerclass.OuterClass.InnerClass;

/**
 * @author leon
 * @date 2021-03-11 14:46:01
 * @version $ Id: MemberInnerClass.java, v 0.1  leon Exp $
 */
public class MemberInnerClass {

    public static void main(String[] args) {

        OuterClass oc = new OuterClass("aaa", "bbb");
        System.out.println(oc);

        InnerClass inner = oc.getInner();
        System.out.println(inner);

        InnerClass inner2 = oc.new InnerClass(); //用 oc.new 才能new一个InnerClass
        inner2.setTitle("2222");
        oc.setInner(inner2);

        System.out.println(oc);
        System.out.println(inner2.getOuter()); //不能直接用this，要用 OuterClass.this
    }
}

class OuterClass {

    private String     name;
    private InnerClass inner;

    public OuterClass(String name, String title) {
        this.name = name;
        this.inner = new InnerClass();
        inner.setTitle(title);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public InnerClass getInner() {
        return inner;
    }

    public void setInner(InnerClass inner) {
        this.inner = inner;
    }

    @Override
    public String toString() {
        return "OuterClass{" + "name='" + name + '\'' + ", inner=" + inner + '}';
    }

    class InnerClass {
        private String title;

        public OuterClass getOuter() {
            return OuterClass.this;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        @Override
        public String toString() {
            return "innerClass{" + "title='" + title + '\'' + '}';
        }
    }

}