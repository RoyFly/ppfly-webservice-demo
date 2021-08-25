package example;

import java.util.ArrayList;

/**
 * 参考网址：
 * (@link https://zhuanlan.zhihu.com/p/111085585)
 * (@link https://blog.csdn.net/qq_41961113/article/details/80239501)
 * 创建WebService项目，主要目的是作为Postman、soapUI等工具进行soap webservice 接口测试的案例
 */
public class HelloWorld {

    public String sayHelloWorldFrom(String from) {
        String result = "Hello, world, from " + from;
        System.out.println("sayHelloWorldFrom方法被调用--->" + result);
        return result;
    }

    //获取姓名接口
    public String getName(String name) {
        if (name == null || name.equals("null") || name.equals("")) {
            name = "there is no this name!!";
            return name;
        }
        System.out.println("sayHelloWorldFrom方法被调用--->name=" + name);
        return "welcome " + name + " to [ppfly webservice demo].";
    }

    //获取姓名列表接口
    public String getNameList() {
        ArrayList al = new ArrayList();
        al.add("allen");
        al.add("petter");
        al.add("Lucy");
        System.out.println("getNameList方法被调用--->getNameList=" + al.toString());
        return al.toString();
    }

    //获取加法运算结果接口
    public int sum(int a, int b) {
        return a + b;
    }
}
