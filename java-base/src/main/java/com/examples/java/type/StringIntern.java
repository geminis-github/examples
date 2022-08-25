package com.examples.java.type;

/**
 * String常量池测试以及intern方法演示使用
 */
public class StringIntern {

    public static void main(String[] args) {
//        String s1 = new String("1");
//        String s3 = s1.intern();
//        String s2 = "1";
//        System.out.println(s1 == s2);
//        System.out.println(s2 == s3);
//        System.out.println(s1 == s3);

//        String s3 = new String("1") + new String("1");
//        String s5 = s3.intern();
//        String s4 = "11";
//        System.out.println(s3 == s4);

//        String s1 = "Hello";
//        String s2 = "Hello";
//        String s3 = "Hel" + "lo";
//        String s4 = "Hel" + new String("lo");
//        String s5 = new String("Hello");
//        String s6 = s5.intern();
//        String s7 = "H";
//        String s8 = "ello";
//        String s9 = s7 + s8;
//        System.out.println("s1 == s2: " + (s1 == s2));
//        System.out.println("s1 == s3: " + (s1 == s3));
//        System.out.println("s1 == s4: " + (s1 == s4));
//        System.out.println("s1 == s9: " + (s1 == s9));
//        System.out.println("s4 == s5: " + (s4 == s5));
//        System.out.println("s1 == s6: " + (s1 == s6));

        // todo String是不可变的，“+”的拼接操作，其实是会生成新的对象，并且拼接后的对象位于堆中
        // todo 在Java8 时JDK 对“+”号拼接进行了优化，下面所写的拼接方式会被优化为基于 StringBuilder 的 append 方法进行处理。Java 会在编译期对“+”号进行处理。
//        String one = "1" + new String("1");
//        String two = "1" + new String("1");
//        String b = one.intern();
//        String c = two.intern();
//        System.out.println(one == two);
//        System.out.println(b == c);

//        String s = new String("1");
//        String s2 = "1";
//        s.intern();
//        System.out.println(s == s2);

//        String s3 = new String("1") + new String("1");
//        String s4 = "11";
//        s3.intern();
//        System.out.println(s3 == s4);
    }

}
