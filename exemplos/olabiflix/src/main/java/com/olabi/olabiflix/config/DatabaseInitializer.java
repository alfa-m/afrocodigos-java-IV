package com.olabi.olabiflix.config;

import java.util.logging.Logger;

@Configuration
public class DatabaseInitializer implements CommandLineRunner{
    private static final Logger log = LoggerFactory.getLogger(DatabaseInitializer.class);
    @Override
    public void run(String... args) throws Exception {
        log.info("Alô Pepe Moreno? O banco tá conectado");
        filmRepository.saveAll(filmes);
        filmRepository.findAll().for
    }
}
