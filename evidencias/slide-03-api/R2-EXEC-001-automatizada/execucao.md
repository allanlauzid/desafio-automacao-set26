# R2-EXEC-001 — API-01

- Executor: Assistente
- Forma de operação: automatizada, Maven com Cucumber, JUnit Platform e REST Assured
- Data e hora: 2026-09-18 21:41:39 -03:00
- Ambiente: Windows 11, Java 23.0.1, Maven 3.9.11
- Comando: `mvn -Dtest=ApiFlowTest test`
- Esperado: concluir os seis passos no mesmo cenário e consultar o usuário com os dois livros escolhidos
- Obtido: o primeiro step foi interrompido antes do envio da requisição porque o REST Assured não encontrou um serializador JSON no classpath
- Status: Bloqueado
- Classificação da ocorrência: Configuração
- Revisão de dados sensíveis: concluída

## Resultado por passo

1. Criar usuário: bloqueado antes da chamada HTTP.
2. Gerar token: não alcançado.
3. Confirmar autorização: não alcançado.
4. Consultar catálogo: não alcançado.
5. Associar dois livros: não alcançado.
6. Consultar usuário: não alcançado.

## Investigação

O corpo da requisição usa um objeto Java. O REST Assured informou que não havia Jackson, Gson, Johnzon ou Yasson disponível para serializá-lo. A ocorrência pertence à configuração da automação e não representa falha funcional do DemoQA.

## Ajuste definido

Adicionar `jackson-databind` como dependência de teste e realizar uma nova tentativa com outro ID, preservando esta tentativa.

## Evidências

- [Relatório Cucumber JSON](relatorios/api-01.json)
- [Relatório Surefire](relatorios/com.accenture.challenge.ApiFlowTest.txt)
- [Relatório Surefire XML](relatorios/TEST-com.accenture.challenge.ApiFlowTest.xml)

## Limitação

Nenhuma chamada chegou ao serviço. Esta tentativa não fornece evidência sobre o comportamento da API.
