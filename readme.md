# 1. 项目说明

- 本项目src/main中代码使用Apache Axis1.x（一个 Java Web 服务框架）创建WebService项目，主要目的是作为Postman、soapUI等工具进行soap
  webservice 接口测试的案例
- 本项目src/test中代码使用Apache Axis1.x 自带的`WSDL2Java`，根据服务接口暴露的WSDL，生成客户端桩代码进行webservice接口调用

# 2. 项目启动&访问说明

## 2.1. tomcat配置

![1-tomcat配置.png](src/main/resources/static/1-tomcat%E9%85%8D%E7%BD%AE.png)
![2-tomcat配置.png](src/main/resources/static/2-tomcat%E9%85%8D%E7%BD%AE.png)

## 2.2. 访问应用

### 2.2.1 查看所有services

http://localhost:8081/services
![3-查看所有service.png](src/main/resources/static/3-%E6%9F%A5%E7%9C%8B%E6%89%80%E6%9C%89service.png)

### 2.2.2 查看HelloWorld service

点击HelloWorld的(wsdl)
，进入[http://localhost:8081/services/HelloWorld?wsdl](http://localhost:8081/services/HelloWorld?wsdl)
![4-HelloWorld.wsdl.png](src/main/resources/static/4-HelloWorld.wsdl.png)

# 3. 使用说明

## 3.1 webservice服务端说明

### 3.3.1 HelloWorld.wsdl文件说明

该文件为Web Services Description Language，用于说明HelloWorld webservice服务的描述：

* 提供了哪些操作（operation）
* 每个操作的输入/输出消息格式（XML 元素）
* 这些操作通过什么网络地址、用什么协议（SOAP/HTTP）访问
  该文件可通过访问[http://localhost:8081/services/HelloWorld?wsdl](http://localhost:8081/services/HelloWorld?wsdl)生成查看

### 3.3.2 postman接口测试说明

- sayHelloWorldFrom

```xml
<?xml version="1.0" encoding="UTF-8"?>
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:xieshadouxing="http://example">
    <soapenv:Body>
        <xieshadouxing:sayHelloWorldFrom>
            <xieshadouxing:from>ppfly</xieshadouxing:from>
        </xieshadouxing:sayHelloWorldFrom>
    </soapenv:Body>
</soapenv:Envelope>
```

![5-sayHelloWorldFrom.png](src/main/resources/static/5-sayHelloWorldFrom.png)

- getName

```xml
<?xml version="1.0" encoding="UTF-8"?>
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:xieshadouxing="http://example">
    <soapenv:Body>
        <xieshadouxing:getName>
            <xieshadouxing:name>zhangsan</xieshadouxing:name>
        </xieshadouxing:getName>
    </soapenv:Body>
</soapenv:Envelope>
```

![6-getName.png](src/main/resources/static/6-getName.png)

- sum

```xml
<?xml version="1.0" encoding="UTF-8"?>
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:xieshadouxing="http://example">
    <soapenv:Body>
        <xieshadouxing:sum>
            <xieshadouxing:a>123</xieshadouxing:a>
            <xieshadouxing:b>234</xieshadouxing:b>
        </xieshadouxing:sum>
    </soapenv:Body>
</soapenv:Envelope>
```

![7-sum.png](src/main/resources/static/7-sum.png)

## 3.2 webservice客户端说明

Java 调用方案有以下几种：

- Postman 直接导出 → Java OKHttp
- `wsimport` 生成客户端桩代码
- 用 Axis 1.4 自带的 `WSDL2Java`
- 使用spring的`WebServiceTemplate`(只针对spring项目)

### 3.2.1 wsimport说明

`wsimport`是JAX-WS（Java API for XML Web Services）的一部分，用于从WSDL（Web Services Description
Language）文件生成Java代码，以便开发人员可以使用这些代码来创建客户端应用程序调用Web服务。
在JDK 11中`wsimport`工具已被移除，开发者可以使用新的JAX-WS RI（Reference Implementation）版本，该版本支持模块化，并提供了更好的集成方式。
也可以使用`jaxws-maven-plugin`maven插件代替`wsimport`生成webservice客户端代码
`wsimport` 只支持（SOAP 1.1/1.2 + literal 风格），如果WSDL是Axis 1.x生成的 RPC/encoded（use="encoded"），两者不兼容，需要手动去掉encoded

### 3.2.1 WSDL2Java说明

命令行：

```shell
java org.apache.axis.wsdl.WSDL2Java -o generated -p example.client HelloWorld.xml
```

WSDL To Java，详见测试用例`example.ClientTest.generate`

备注：`src/test/java`文件夹下的`example.client`包及内部文件由生成的`generated`文件夹拷贝过来



