package com.logonedigital.pi_mentorat_virtuel.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "LOGONEDIGITAL TEKHUB ACADEMY",
                        email = "contact@logonedigital.com",
                        url = "https://logonedigital.com"
                ),
                title = "PI MENTORAT VIRTUEL",
                description = "Mentorat Virtuelle App APIs ",
                termsOfService = "&copy; LOGONEDIGITAL",
                version = "v1"
        )
)
public class OpenApiConfiguration {
}
