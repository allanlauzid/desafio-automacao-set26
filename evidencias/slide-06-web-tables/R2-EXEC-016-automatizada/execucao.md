# R2-EXEC-016 — Slide 6 / UI-BONUS-01

- Data e término: 2026-09-18 23:54:02 -03:00
- Tipo: automatizada
- Executor: Assistente
- Resultado: Reprovado
- Classificação: falha da automação

## Esperado

Criar dinamicamente 12 registros únicos por meio do cenário Cucumber, confirmar os 12, excluir todos e comprovar que nenhum permaneceu.

## Obtido

Os 12 registros foram criados e seus seis campos foram comparados individualmente com sucesso. A primeira exclusão terminou, mas a automação não encontrou o segundo registro durante a exclusão sequencial e expirou após 15 segundos. O step de confirmação final ficou ignorado.

O resumo Surefire registrou 2 testes do mecanismo Cucumber: 1 erro e 1 ignorado. O cenário de bônus terminou com erro em 68,32 segundos.

## Dados da execução

- Seed: `1789786382565`
- Quantidade criada e validada: `12`
- E-mails fictícios: prefixo `qa.webtable.1789786382565`, índices de `0` a `11`

## Investigação

As validações anteriores à exclusão comprovam que os 12 registros existiam. A falha ocorreu porque cada exclusão filtrava a tabela antes de acionar o botão. Para evitar alterações de índice ou estado na visão filtrada, a próxima tentativa manterá as 15 linhas visíveis, localizará cada registro por e-mail na tabela completa e excluirá sua própria linha.

O requisito obrigatório `UI-03` permanece Aprovado em `R2-EXEC-015`; esta falha pertence somente ao bônus.
