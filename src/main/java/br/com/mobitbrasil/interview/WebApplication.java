package br.com.mobitbrasil.interview;

import javax.ejb.Stateless;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;


@Stateless
@ApplicationPath("/api/v1")
public class WebApplication extends Application {
}
