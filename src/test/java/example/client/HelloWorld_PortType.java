/**
 * HelloWorld_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package example.client;

public interface HelloWorld_PortType extends java.rmi.Remote {
    public String getName(String name) throws java.rmi.RemoteException;
    public int sum(int a, int b) throws java.rmi.RemoteException;
    public String getNameList() throws java.rmi.RemoteException;
    public String sayHelloWorldFrom(String from) throws java.rmi.RemoteException;
}
