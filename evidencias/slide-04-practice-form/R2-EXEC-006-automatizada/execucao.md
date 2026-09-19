# R2-EXEC-006 — Slide 4 / UI-01

- Data e término: 2026-09-18 23:04:27 -03:00
- Tipo: automatizada
- Executor: Assistente
- Resultado: Reprovado
- Classificação: falha da automação

## Esperado

Executar o cenário completo do Practice Form, comparar os dados do popup e confirmar seu fechamento.

## Obtido

O Chrome e o ChromeDriver foram iniciados, mas o primeiro step terminou com `TimeoutException` após 15 segundos. A automação esperava que o título contivesse `DEMOQA`; a página atual apresentou o título `demosite`.

Os demais steps não foram executados. O relatório registrou 1 cenário, 0 falhas de asserção, 1 erro e 0 ignorados no resumo do runner, com duração de 23,20 segundos.

## Investigação

A ocorrência não demonstra defeito do DemoQA. O oráculo de carregamento usava um título desatualizado. A correção substitui essa expectativa pela presença observável do cartão `Forms`, necessário ao próximo passo.

O relatório Cucumber contém a captura automática da falha. Não há dados pessoais ou segredos na evidência.
