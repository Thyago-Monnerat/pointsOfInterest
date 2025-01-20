![image](https://th.bing.com/th/id/OIP.lwDa90HV9bdav2987iyL6QHaHa?w=200&h=200&rs=1&pid=ImgDetMain)

# Points Of Interest API

### Requisições:
![Static Badge](https://img.shields.io/badge/POST-yellow?style=for-the-badge)
* O usuário faz uma requisição para o endpoint /locations/add com os seguintes campos no corpo da requisição:
    ~~~ 
    {
        "name": "name",
        "xcoord": 30,
        "ycoord": 44
    }
    ~~~
* O controlador do endpoint chama a função saveLocation do LocationService, que possui uma função utilitária para validar os campos.
    * Se já houver um local com o mesmo nome, uma exceção é lançada.
    * Se uma das coordenadas for menor que 0, uma exceção é lançada.
    * Por fim, são selecionados os 8 primeiros dígitos desse código.
* Com tudo validado, o serviço salva o local.
#
![Static Badge](https://img.shields.io/badge/GET-green?style=for-the-badge)
* O usuário faz uma requisição para o endpoint /locations/nearby com os seguintes campos na query:
    ~~~ 
    url/locations/nearby?userX=0&userY=101&distance=0
    ~~~
* O controlador do endpoint chama a função calculateDistance, passando os campos como um UserReference do LocationService, que valida as coordenadas, a distância e calcula a distância do usuário até os pontos salvos através da fórmula da distância euclidiana.
* O método, então, retorna uma lista com os locais que estão a uma distância equivalente à passada como argumento pelo usuário.
#
![Static Badge](https://img.shields.io/badge/GET-green?style=for-the-badge)
* O usuário faz uma requisição para o endpoint /locations/all, recebendo como resposta uma lista de todas as localizações salvas no formato LocationModel.
#
Utilizei H2 para persistência de dados em memória, Mockito e JUnit para executar testes nos métodos e um ControllerAdvice para lidar com as exceções globalmente.

Projeto baseado no desafio: https://github.com/backend-br/desafios/blob/master/points-of-interest/PROBLEM.md

No mais, é isso <3

    - Maven
    - Java 23
    - Spring Boot 3.4.1
    - H2
    - Spring Web
    - Spring JPA
    - Lombok
    - Mockito
    - JUnit
