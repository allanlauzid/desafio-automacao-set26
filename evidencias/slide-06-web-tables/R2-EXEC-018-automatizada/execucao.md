# R2-EXEC-018 — Slide 6 / UI-BONUS-01

- Data e término: 2026-09-19 00:00:07 -03:00
- Tipo: automatizada
- Executor: Assistente
- Resultado: Reprovado
- Classificação: comportamento do produto detectado por uma asserção técnica adicional

## Esperado

Após criar e validar 12 registros, cada clique de exclusão deveria reduzir a tabela em exatamente uma linha até remover todos os registros criados.

## Obtido

Os 12 registros foram criados e comparados com sucesso. No primeiro clique de exclusão, os 12 registros desapareceram simultaneamente e somente os três registros padrão permaneceram. A espera que exigia redução exata de uma linha expirou após 15 segundos. O step de confirmação final ficou ignorado.

O resumo Surefire registrou 2 testes do mecanismo Cucumber: 1 erro e 1 ignorado. O cenário de bônus terminou com erro em 72,04 segundos.

## Dados da execução

- Seed: `1789786743203`
- Quantidade criada e validada: `12`
- Quantidade de registros do teste após o primeiro clique: `0`
- Registros padrão preservados visualmente: `3`

## Investigação

A captura de falha comprova que o primeiro clique removeu todos os registros criados e preservou os registros padrão. Isso é compatível com identificadores internos duplicados atribuídos pelo DemoQA. A próxima tentativa registrará os IDs de ação antes da exclusão e avaliará o critério obrigatório do bônus pela ausência final dos 12 registros.

O requisito obrigatório `UI-03` permanece Aprovado em `R2-EXEC-015`.
