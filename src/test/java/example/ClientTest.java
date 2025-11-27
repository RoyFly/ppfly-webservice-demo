package example;

import example.client.HelloWorldServiceLocator;
import example.client.HelloWorld_PortType;
import org.junit.jupiter.api.Test;

class ClientTest {

    /**
     * WSDL To Java
     */
    @Test
    void generate() {
        // 相当于命令行：
        // java org.apache.axis.wsdl.WSDL2Java -o generated -p example.client HelloWorld.xml
        org.apache.axis.wsdl.WSDL2Java.main(new String[]{
                // 输出目录
                "-o", "generated",
                // 包名
                "-p", "example.client",
                // wsdl绝对路径
                Thread.currentThread().getContextClassLoader().getResource("static/HelloWorld.wsdl").getPath()
        });
    }

    /**
     * 客户端调用验证
     *
     * @throws Exception
     */
    @Test
    void test() throws Exception {
        /* 1. 拿到服务定位器 */
        HelloWorldServiceLocator service = new HelloWorldServiceLocator();

        /* 2. 可选：改端口地址（如果与 WSDL 里不一致） */
        service.setHelloWorldEndpointAddress("http://localhost:8081/services/HelloWorld");

        /* 3. 取代理（桩） */
        HelloWorld_PortType port = service.getHelloWorld();

        /* 4. 直接调 */
        System.out.println("sayHelloWorldFrom -> " + port.sayHelloWorldFrom("ppfly"));
        System.out.println("getName -> " + port.getName("zhangsan"));
        System.out.println("sum -> " + port.sum(123, 234));
        System.out.println("getNameList -> " + port.getNameList());
    }
}
