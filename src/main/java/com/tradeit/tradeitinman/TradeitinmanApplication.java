package com.tradeit.tradeitinman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TradeitinmanApplication {

    public static void main(String[] args) {

        /**
         * security configs can be found in security/WebSecurityConfig (username:password)
         *
         * to test this project application.properties might needs to be changed
         *
         * since when starting, no data is available here's a recommendation from dev side
         * go for localhost:8080/dataloader to init some data
         * for another record execute localhost:8080/dataloader2
         *
         * another possibility would be to run the junit tests (which have to be run with an
         * empty db to pass successfully) -> the junit tests execute those two dataloaders
         * and test data will be accessable form rest services
         *
         * the whole mapping for the web api had beed done in security/MvcConfig
         *
         *
         * general information:
         *
         * N:M relationship: Titel -> Aktienhandel <- User || N:M -> 1:N Aktienhandel N:1
         *
         * Inheritance had been made with Aktie and Titel -> e.g. ETF would be a child form Titel
         * as well
         *
         * Additional generated queries: Aktienhandelrepo, Artrepo, Boersenplatzrepo, Titelrepo
         *
         * Additional native queries: Userrepo, Aktienhandelrepo, Artrepo
         *
         * Compelx queries: Userrepo
         *
         * Use of additional libraries: junit library for smoke testing, spring boot security
         *
         * Integration of web api: integration of front end points (config in /security/MvcConfig)
         *
         * Security: Implementation of spring boot security (security/websecurityconfig)
         */


        SpringApplication.run(TradeitinmanApplication.class, args);
    }

}
