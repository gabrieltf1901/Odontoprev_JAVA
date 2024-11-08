--> Toda a documentação referente ao projeto encontra-se na pasta DOCUMENTAÇÃO, inclusive os "responses" ou testes.

NOME ALUNO: GABRIEL TORRES FERNANDES
RM: 553635

O aluno Gabriel Torres Fernandes ficou responsável por todo o desenvolvimento do projeto.




Projeto Java para Redução de Sinistro com Análise Preditiva de Atendimento

1. Descrição Geral

Este projeto consiste em uma aplicação Java utilizando Spring Boot com Gradle para a Odontoprev. A solução busca melhorar a eficiência e reduzir os custos operacionais por meio de uma análise preditiva de atendimento, proporcionando uma experiência aprimorada aos pacientes e contribuindo para a sustentabilidade do negócio.

2. Objetivos da Primeira Sprint

Implementar uma API RESTful seguindo o modelo de maturidade nível 1.

Mapear as classes de entidade utilizando JPA.

Criar repositórios utilizando o padrão Repository com Generics.

Implementar DTOs e aplicação da Bean Validation para validação dos dados.

Incluir testes para os endpoints utilizando Postman ou Insomnia.

3. Evolução na Segunda Sprint

Refatoração do código para melhoria da qualidade e eficiência.

Implementação de HATEOAS para alcançar o nível 3 de maturidade REST.

Otimização do código com o uso de Lombok para reduzir boilerplate.

Melhorias nos testes de endpoints e adição de novos cenários de teste.

4. Classes de Entidade
- PACIENTE
- PROFISSIONAL
- CONSULTA

5. Arquitetura do Projeto

O projeto utiliza uma arquitetura baseada em camadas:

Camada de Aplicação: Controladores REST para exposição de endpoints com HATEOAS.

6. Testando o Projeto

Para garantir que o projeto funcione corretamente, siga os seguintes passos para testá-lo:

6.1. Pré-requisitos

Java 17: Certifique-se de que o Java 17 ou uma versão compatível esteja instalada.

Gradle: Verifique se o Gradle está instalado ou utilize o wrapper incluído (./gradlew).

Banco de Dados Oracle: Certifique-se de que o Oracle Database esteja configurado e acessível.

Postman ou Insomnia: Para testar os endpoints da API.

6.2. Executando o Projeto

Clone o Repositório:
- git clone https://github.com/gabrieltf1901/Odontoprev-JAVA.git

Configure o Banco de Dados:
Verifique o arquivo application.properties para configurar as credenciais do banco de dados:

spring.datasource.url=jdbc:oracle:thin:@oracle.fiap.com.br:1521/orcl
spring.datasource.username=rm553635
spring.datasource.password=190101
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.hateoas.use-hal-as-default-json-media-type=false   


6.3. Testando com Postman ou Insomnia

Autenticação (se aplicável):
Se a aplicação exigir autenticação HTTP básica, use o username user e a senha gerada no console ou definida no application.properties.

Endpoints para Testar:

GET /pacientes_op: Retorna todos os pacientes.

GET /pacientes_op/{id}: Retorna um paciente específico.

POST /pacientes_op: Cria um novo paciente.

GET /profissional_op: Retorna todos os profissionais.

GET /profissional_op/{id}: Retorna um profissional específico.

POST /profissional_op: Cria um novo profissional.

GET /consulta_op: Retorna todas as consultas.

GET /consulta_op/{id}: Retorna uma consulta específica.

POST /consulta_op: Cria uma nova consulta.

Configurar Requisições:

Para endpoints POST, envie o corpo da requisição em JSON, por exemplo:
{
  "nomeCompleto": "João da Silva",
  "dataNascimento": "1990-01-01",
  "contato": "(11) 99999-9999",
  "planoDeSaude": "Plano X",
  "historicoMedico": "Sem alergias"
}

Verifique Respostas:

Respostas de sucesso devem retornar códigos HTTP como 200 OK ou 201 Created.


Diagrama de entidades

![Diagrama-Entidades_JAVA](https://github.com/user-attachments/assets/1e01adee-933a-41c2-ac12-adad87b6b2bf)



