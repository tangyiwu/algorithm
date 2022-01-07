package com.algorithm.java;

/**
 * Java类初始化顺序：
 * OuterClass Static Block1
 * OuterClass Static Block2
 * OuterClass Code Block1
 * InnerClass Static Block1
 * InnerClass Static Block2
 * InnerClass Code Block1
 * InnerClass Code Block2
 * InnerClass constructor
 * OuterClass Code Block2
 * OuterClass constructor
 */
public class JavaInitilizeOrder {
    {
        System.out.println("OuterClass Code Block1");
    }

    static {
        System.out.println("OuterClass Static Block1");
    }

    private InnerClass innerClass = new InnerClass();

    private static class InnerClass {
        {
            System.out.println("InnerClass Code Block1");
        }

        static {
            System.out.println("InnerClass Static Block1");
        }

        public InnerClass() {
            System.out.println("InnerClass constructor");
        }

        static {
            System.out.println("InnerClass Static Block2");
        }

        {
            System.out.println("InnerClass Code Block2");
        }
    }

    public JavaInitilizeOrder() {
        System.out.println("OuterClass constructor");
    }

    static {
        System.out.println("OuterClass Static Block2");
    }

    {
        System.out.println("OuterClass Code Block2");
    }

    public static void main(String[] args) {
        JavaInitilizeOrder outerClass = new JavaInitilizeOrder();
    }
}
