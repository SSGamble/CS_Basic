package com.td.剑指Offer;

/**
 * 单例模式
 */
public class Test2 {
    /**
     * 单例模式，懒汉式，线程安全
     */
    public static class Singleton {
        private final static Singleton INSTANCE = new Singleton();
        private Singleton() { }
        public static Singleton getInstance() {
            return INSTANCE;
        }
    }

    /**
     * 单例模式，饿汉式，线程不安全
     */
    public static class Singleton2 {
        private static Singleton2 instance = null;
        private Singleton2() { }
        public static Singleton2 getInstance() {
            if (instance == null) {
                instance = new Singleton2();
            }
            return instance;
        }
    }


    /**
     * 单例模式，饿汉式，线程安全，多线程环境下效率不高
     */
    public static class Singleton3 {
        private static Singleton3 instance = null;
        private Singleton3() { }
        public static synchronized Singleton3 getInstance() {
            if (instance == null) {
                instance = new Singleton3();
            }
            return instance;
        }
    }

    /**
     * 单例模式，饿汉式，变种，线程安全
     */
    public static class Singleton4 {
        private static Singleton4 instance = null;
        static {
            instance = new Singleton4();
        }
        private Singleton4() { }
        public static Singleton4 getInstance() {
            return instance;
        }
    }

    /**
     * 单例模式，懒汉式，使用静态内部类，线程安全【推荐--】
     *
     * 当我们第一次试图通过 Singleton5.getInstance() 得到 Singleton5 的实例时，
     * 会自动调用 SingletonHolder 的静态构造函数创建实例 instance。
     * 如果我们不调用属性 Singleton5.getInstance()，就不会触发运行时调用 SingletonHolder，也不会创建实例，
     * 这样就真正做到了按需创建，即懒加载。
     */
    public static class Singleton5 {
        private final static class SingletonHolder { // 内部类
            private static final Singleton5 INSTANCE = new Singleton5();
        }
        private Singleton5() { }
        public static Singleton5 getInstance() {
            return SingletonHolder.INSTANCE;
        }
    }

    /**
     * 静态内部类，使用双重校验锁，线程安全【推荐】
     */
    public static class Singleton7 {
        private volatile static Singleton7 instance = null;
        private Singleton7() { }
        public static Singleton7 getInstance() {
            if (instance == null) {
                synchronized (Singleton7.class) {
                    if (instance == null) {
                        instance = new Singleton7();
                    }
                }
            }
            return instance;
        }
    }
    public static void main(String[] args) {
        System.out.println(Singleton.getInstance() == Singleton.getInstance());
        System.out.println(Singleton2.getInstance() == Singleton2.getInstance());
        System.out.println(Singleton3.getInstance() == Singleton3.getInstance());
        System.out.println(Singleton4.getInstance() == Singleton4.getInstance());
        System.out.println(Singleton5.getInstance() == Singleton5.getInstance());
        System.out.println(Singleton7.getInstance() == Singleton7.getInstance());
    }
}
