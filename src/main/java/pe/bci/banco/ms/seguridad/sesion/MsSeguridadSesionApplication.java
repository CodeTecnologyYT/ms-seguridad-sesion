package pe.bci.banco.ms.seguridad.sesion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:ms-seguridad-sesion-1.0.properties")
@PropertySource("classpath:redis.properties")
@PropertySource("classpath:security.properties")
public class MsSeguridadSesionApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsSeguridadSesionApplication.class, args);
    }

}
