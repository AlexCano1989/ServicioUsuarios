package com.misusuarios.usuarios.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "API para el servicio de CompraTodo usuarios", version = "1.0",
        description = "API que expone los endpoints para las entidades de Usuario y Administrador de la solucion CompraTodo (Servicio de Usuarios)"))
public class SwaggerConfig {
}
