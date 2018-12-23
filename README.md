### Magneto REST API ###

* How to run locally? (u do not need to install anything)

``./mvnw spring-boot:run``

* REST APIs exposed
- URLs
   * `localhost:8080/api/mutant`
   * `localhost:8080/api/stats`

- POST localhost:8080/api/mutant 
    * ``curl -X POST http://localhost:8080/api/mutant -H "Content-Type: application/json" -d '{
    "dna": [ "ATGCGA", "CAGTGC", "TCATGT", "AGCAGG", "CCCCTA", "TCACTG"]}'``    
    
    API response:
    
    - 200 if is a mutant.
    
    - 403 if is a human.

    
- GET localhost:8080/api/stats    
    * ``curl http://localhost:8080/api/stats``
    
    API response:
    
    ```
    {
        "ratio": 0.4, 
        "count_human_dna": 100,
        "count_mutant_dna": 40
    }
    ```
