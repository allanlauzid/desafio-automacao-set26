# R2-EXEC-014 — Slide 6 / UI-03

- Data e término: 2026-09-18 23:50:08 -03:00
- Tipo: automatizada
- Executor: Assistente
- Resultado: Reprovado
- Classificação: falha da automação

## Esperado

Criar um registro único em Web Tables, confirmar seus valores, editar o mesmo registro, confirmar os valores atualizados, excluí-lo e comprovar sua ausência.

## Obtido

A linha foi novamente criada e apareceu na captura, mas a validação expirou porque o localizador ainda procurava classes da implementação anterior da tabela. Os passos posteriores ficaram ignorados e a limpeza falhou pelo mesmo motivo.

O resumo Surefire registrou 2 testes do mecanismo Cucumber: 1 erro e 1 ignorado. O cenário obrigatório terminou com erro em 43,54 segundos.

## Dados da execução

- Seed: `1789786173881`
- Nome: `Ana Teste`
- E-mail fictício: `qa.webtable.1789786173881@example.com`
- Idade: `27`
- Salário: `4800`
- Departamento: `Quality Assurance`

## Investigação

A inspeção do DOM atual confirmou que Web Tables usa elementos semânticos `table`, `tbody`, `tr` e `td`. Os seletores esperavam a estrutura antiga baseada em `.rt-tr` e `.rt-td`. A próxima tentativa usará a célula `td` com o e-mail exato e a respectiva linha `tr`.

Não há evidência de defeito do DemoQA nesta tentativa.
