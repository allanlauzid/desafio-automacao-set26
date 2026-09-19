# R2-EXEC-002 — API-01

- Executor: Assistente
- Forma de operação: automatizada, Maven com Cucumber, JUnit Platform e REST Assured
- Data e hora: 2026-09-18 21:43:41 -03:00
- Ambiente: Windows 11, Java 23.0.1, Maven 3.9.11
- Comando: `mvn -Dtest=ApiFlowTest test`
- Esperado: concluir os seis passos no mesmo cenário e consultar o usuário com os dois livros escolhidos
- Obtido: os seis steps concluíram e a consulta final apresentou exatamente os dois ISBNs escolhidos
- Status: Aprovado
- Código de saída do processo: 0
- Resumo do executor: 1 teste, 0 falhas, 0 erros e 0 ignorados
- Revisão de dados sensíveis: concluída

## Resultado por passo

1. Criar usuário: HTTP 201, identificador preenchido e nome correspondente.
2. Gerar token: HTTP 200, estado de sucesso e token não vazio.
3. Confirmar autorização: HTTP 200 e resposta verdadeira.
4. Consultar catálogo: HTTP 200 e seleção de dois ISBNs distintos.
5. Associar dois livros: HTTP 201 e resposta com os dois ISBNs escolhidos.
6. Consultar usuário: HTTP 200, usuário correspondente e exatamente os dois ISBNs escolhidos.

## Evidências

- [Relatório Cucumber JSON](relatorios/api-01.json)
- [Relatório Cucumber HTML](relatorios/api-01.html)
- [Relatório Surefire](relatorios/com.accenture.challenge.ApiFlowTest.txt)
- [Relatório Surefire XML](relatorios/TEST-com.accenture.challenge.ApiFlowTest.xml)

Os relatórios foram pesquisados por padrões de usuário, senha, token Bearer e JWT. Nenhum valor sensível correspondente foi encontrado.

## Limitação

Esta execução cobre somente o caminho principal. Não cobre entradas inválidas, segurança, desempenho, concorrência nem limpeza posterior do usuário criado.
