package com.logonedigital.pi_mentorat_virtuel;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

        @Override
        public void configureMessageBroker(MessageBrokerRegistry config) {
            // Le serveur va diffuser des messages sur les destinations qui commencent par /topic
            config.enableSimpleBroker("/topic");
            // Le préfixe pour les destinations des messages entrants
            config.setApplicationDestinationPrefixes("/app");
        }

        @Override
        public void registerStompEndpoints(StompEndpointRegistry registry) {
            // Le client va se connecter via ce point d'entrée /ws
            registry.addEndpoint("/ws").withSockJS();

        }
}
