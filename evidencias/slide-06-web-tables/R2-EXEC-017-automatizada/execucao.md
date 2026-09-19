# R2-EXEC-017 — Slide 6 / UI-BONUS-01

- Data e término: 2026-09-18 23:57:32 -03:00
- Tipo: automatizada
- Executor: Assistente
- Resultado: Reprovado
- Classificação: falha da automação

## Esperado

Criar dinamicamente 12 registros únicos, confirmar que todos coexistem, excluir cada um e comprovar que nenhum permaneceu.

## Obtido

Os 12 registros foram criados e comparados com sucesso. A automação excluiu o registro de índice 0. Ao iniciar a exclusão do índice 1, a linha já não estava presente e a espera expirou. O step de confirmação final ficou ignorado.

O resumo Surefire registrou 2 testes do mecanismo Cucumber: 1 erro e 1 ignorado. O cenário de bônus terminou com erro em 68,27 segundos.

## Dados da execução

- Seed: `1789786591519`
- Quantidade criada e validada: `12`
- Primeiro registro acionado para exclusão: índice `0`
- Segundo registro não encontrado: índice `1`

## Investigação

A repetição sem filtro elimina a busca como causa. A hipótese técnica é que criações consecutivas começaram antes de a tabela estabilizar cada novo estado, permitindo identificadores internos repetidos no DemoQA. Essa hipótese ainda não constitui defeito confirmado do produto.

A próxima tentativa aguardará o aumento exato de uma linha após cada cadastro. Cada exclusão também exigirá a redução exata de uma linha, além da ausência do e-mail acionado.

O requisito obrigatório `UI-03` permanece Aprovado em `R2-EXEC-015`.
