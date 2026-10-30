package org.example.altasbajasfiee.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration //marca la clase como de ajustes
//implemetna la interfaz WebMvcConfigurer, trae metodos para personalizar la parte web
public class CorsConfig implements WebMvcConfigurer {

    //aqui se esta reemplazando el metodo addCorsMapping de la interfaz
    @Override
    //CorsRegistry es un obj que spring entrega para registrar a quien das permiso
    public void addCorsMappings(CorsRegistry registry){
        //addmapping es a que rutas se aplica el permiso
        registry.addMapping("/api/**")
                //allowedOrigins es que origne pueden pedir datos, solo la paginade de react
                .allowedOrigins("http://localhost:5173")
                //que tipos de peticion acpeta, solo get, o sea solo consultar
                .allowedMethods("GET");
    }
}
