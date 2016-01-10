package com.epam.cp.rest.rest;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/rest")
@RequestScoped
public class CpRestApplicationRoot extends Application{
}
