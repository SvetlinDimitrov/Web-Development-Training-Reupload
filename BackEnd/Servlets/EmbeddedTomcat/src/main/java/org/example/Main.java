package org.example;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.util.scan.StandardJarScanner;

import java.io.File;

public class Main {
    public static void main(String[] args) throws LifecycleException {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        Context context = tomcat.addWebapp("", new File(".").getAbsolutePath());
        tomcat.addServlet("" , "Hello-world" , new HelloWorld());
        context.addServletMappingDecoded("/hello" , "Hello-world");
        ((StandardJarScanner) context.getJarScanner()).setScanManifest(false);

        tomcat.start();
        tomcat.getConnector();
        tomcat.getServer().await();
    }
}