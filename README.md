# Spring-Boot CXF JAXWS SapWS

This project demonstrates how to use Apache CXF with Spring Boot to create a simple SOAP web service.

Use the following command to run the app locally wihtout deploying to Openshift:

    mvn spring-boot:run

Use the following command to deploy to OpenShift:

    mvn fabric8:deploy

To list all the running pods:

    oc get pods

Then find the name of the pod that runs this app, and output the logs from the running pods with:

    oc logs <name of pod>

You can also use the OpenShift web console to manage the running pods, and view logs and much more.

### Running via an S2I Application Template

Application templates allow you deploy applications to OpenShift by filling out a form in the OpenShift console that allows you to adjust deployment parameters.  This template uses an S2I source build so that it handle building and deploying the application for you.

First, import the Fuse image streams:

    oc create -f https://raw.githubusercontent.com/jboss-fuse/application-templates/GA/fis-image-streams.json

Then create the quickstart template:

    oc create -f https://raw.githubusercontent.com/jboss-fuse/application-templates/GA/quickstarts/spring-boot-cxf-jaxws-template.json

Now when you use "Add to Project" button in the OpenShift console, you should see a template for this quickstart. 

### Accessing the Endpoints

To access the endpoint you first need to create an OpenShift route for the service so that it can be exposed externally.  You can use the 'oc create route' command to create the route and the 'oc get routes' to get the host name for
the route that you created.  Example:


    $ oc create route edge example1 --service=spring-boot-cxf-jaxws
    route "example1" created
    
    $ oc get routes example1
    NAME       HOST/PORT                                PATH      SERVICES                PORT      TERMINATION
    example1   example1-myproject.example.com                     spring-boot-cxf-jaxws   http      edge

You can then use the host report to access the service:

    https://example1-myproject.example.com /service/hello?wsdl
    
... will now display the generated WSDL.


