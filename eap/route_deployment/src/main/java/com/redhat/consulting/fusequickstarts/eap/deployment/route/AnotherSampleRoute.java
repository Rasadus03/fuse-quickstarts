package com.redhat.consulting.fusequickstarts.eap.deployment.route;

import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.cdi.ContextName;

/*
 * The Annotations below are required for EAP to find and start the Camel Route.
 */
@Startup
@ApplicationScoped
@ContextName("route-deployment")
public class AnotherSampleRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        // Logs Goodbye World every 2000 milliseconds
        from("timer://myEapTimer?fixedRate=true&period=2000").log(LoggingLevel.INFO, "com.redhat.consulting.fusequickstarts.eap.deployment.route", "Goodbye World").to(
            "log:GoodbyeWorldLog?level=INFO");

    }

}
