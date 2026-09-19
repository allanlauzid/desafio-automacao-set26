# R2-EXEC-023 — Slide 7 / UI-04

- Data e término: 2026-09-19 00:30:04 -03:00
- Tipo: regressão automatizada
- Executor: Assistente
- Resultado: Aprovado

## Objetivo

Confirmar o fluxo da Progress Bar depois de restringir o hook compartilhado dos Slides 4 e 5, eliminando a abertura de um segundo navegador que não participava do cenário.

## Obtido

Somente o hook de `ProgressBarSteps` iniciou um navegador. O clique em `Stop` foi solicitado quando a leitura imediatamente anterior indicava 10%. A barra estabilizou em 12%, foi retomada até exatamente 100% e retornou exatamente a 0% depois do `Reset`.

O cenário terminou com 1 teste executado, 0 falhas, 0 erros e 0 ignorados, em 20,78 segundos.

## Evidências

- `screenshots/01-barra-parada-ate-25.png`: barra parada em 12% e botão `Start` disponível.
- `screenshots/02-barra-em-100.png`: barra completa em 100% e botão `Reset` disponível.
- `screenshots/03-barra-resetada-em-0.png`: barra em 0% e botão `Start` disponível.
- `relatorios/ui-04.html` e `relatorios/ui-04.json`: cenário Cucumber, valores registrados e capturas anexadas.
- `relatorios/TEST-com.accenture.challenge.ProgressBarTest.xml` e `relatorios/com.accenture.challenge.ProgressBarTest.txt`: resultado do executor.
- Revisão de dados sensíveis: concluída. As imagens mostram somente a interface pública do DemoQA.

## Investigação e limitação

O relatório de `R2-EXEC-022` mostrou dois hooks `Before` e dois hooks `After`: o hook genérico `@ui` e o hook específico `@progress-bar`. O segundo navegador permaneceu sem uso e não alterou as verificações daquela execução. O hook genérico passou a excluir cenários com `@web-tables` e `@progress-bar`.

Continua existindo uma diferença temporal entre a leitura e a efetivação do clique. A aprovação exige que o valor estabilizado permaneça menor ou igual a 25%.

O Selenium 4.47.0 emitiu aviso de correspondência aproximada CDP 151 para Chrome 153. O cenário não usa comandos CDP e foi concluído.
