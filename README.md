# Desafio de QA Automation — Java

Projeto de estudos e entrega para o desafio de QA Automation descrito no arquivo `Desafio_QA (004).pptx`. O objetivo é automatizar os fluxos de API e interface solicitados, mantendo casos de teste rastreáveis, resultados verificáveis e um histórico fiel da evolução do trabalho.

## Abordagem de teste

O trabalho seguirá práticas do [ISTQB Foundation Level](https://istqb.org/wp-content/uploads/2024/11/ISTQB_CTFL_Syllabus_v4.0.1.pdf): analisar o enunciado, definir resultados esperados antes de automatizar, priorizar por risco, relacionar requisitos a casos de teste e comparar resultados reais com os esperados. Falhas serão investigadas antes de serem registradas como defeitos do sistema.

Cada caso executado terá um estado claro: **passou**, **falhou**, **bloqueado** ou **não executado**. O relatório final indicará a cobertura alcançada e as limitações encontradas. A aprovação dos casos executados não será apresentada como prova de ausência de defeitos.

## Execução

As instruções e o comando de execução serão adicionados após a configuração do projeto Maven. Este README não declara testes prontos ou resultados ainda não obtidos.

## Método de desenvolvimento

O projeto será desenvolvido de forma incremental, um fluxo de teste por vez. Um Kanban simples acompanhará cada fluxo nas etapas **a fazer**, **em desenvolvimento**, **em validação** e **concluído**.

Para cada fluxo, serão definidos o resultado esperado e os dados necessários antes da automação. Depois da implementação em Java, o teste será executado, as falhas serão investigadas e o resultado será registrado. A conclusão de um fluxo dependerá de validação real e documentação atualizada; cada mudança concluída será versionada em um commit relacionado ao trabalho realizado.

## Estado atual

**Preparação.** Este primeiro commit documenta o escopo e a abordagem. Ainda não há testes implementados ou executados; os resultados serão registrados conforme cada fluxo for concluído.

## Escopo do enunciado

### Parte 1 — API

1. Criar um usuário.
2. Gerar um token de acesso.
3. Confirmar a autorização do usuário.
4. Listar os livros disponíveis.
5. Associar dois livros escolhidos ao usuário, conforme a operação disponível na API.
6. Consultar os detalhes do usuário e conferir os dois livros.

Referência de contrato indicada no desafio: [Swagger do DemoQA](https://demoqa.com/swagger/). Métodos, dados e respostas esperadas serão conferidos no contrato atual antes da implementação.

### Parte 2 — interface

- **Practice Form:** preencher o formulário, enviar um arquivo `.txt` incluído no projeto, validar o popup de confirmação e fechá-lo.
- **Browser Windows:** abrir uma nova janela, validar a mensagem exibida e fechá-la.
- **Web Tables:** criar, editar e excluir um registro, conferindo o resultado de cada operação.
- **Progress Bar:** parar antes de 25%, validar o valor observado, continuar até 100% e reiniciar a barra.
- **Sortable:** reordenar os itens por arrastar e soltar e validar a ordem final.

**Bônus do enunciado:** criar 12 registros dinamicamente em Web Tables por meio de Cucumber e excluí-los ao final.

## Tecnologias planejadas

- Java e Maven para o projeto.
- JUnit para execução e asserções dos testes.
- REST Assured para os testes de API.
- Selenium WebDriver para os testes de interface.
- Page Object para organizar a interação com as páginas, quando os fluxos de interface forem implementados.
- Cucumber-JVM para o bônus, após os fluxos principais estarem estáveis.

As versões das ferramentas e o navegador de execução serão registrados quando o ambiente estiver configurado.

## Kanban do projeto

Este quadro acompanha as entregas do desafio. Cada item avança por **A fazer → Em desenvolvimento → Em validação → Concluído**. Mantenho um fluxo de automação em desenvolvimento por vez e atualizo a posição dos itens conforme o trabalho real.

**Concluído** significa que a atividade foi executada e documentada; um teste pode ter resultado **passou** ou **falhou**. Se a execução estiver bloqueada, o item permanece **em validação**, com a causa registrada.

### A fazer

- Conferir o Swagger e as páginas atuais do DemoQA; registrar ambiguidades e resultados esperados.
- Configurar Java, Maven e um primeiro teste executável.
- Implementar e validar o fluxo completo de API.
- Automatizar e validar Practice Form.
- Automatizar e validar Browser Windows.
- Automatizar e validar Web Tables: criar, editar e excluir.
- Automatizar e validar Progress Bar.
- Automatizar e validar Sortable.
- Registrar resultados, revisar a cobertura e preparar a entrega no GitHub.
- **Bônus:** criar e excluir 12 registros em Web Tables com Cucumber.

### Em desenvolvimento

Nenhum item no momento.

### Em validação

Nenhum item no momento.

### Concluído

Nenhuma etapa do quadro concluída no momento.
