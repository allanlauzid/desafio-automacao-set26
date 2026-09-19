# R2-EXEC-022 — Slide 7 / UI-04

- Data e término: 2026-09-19 00:25:34 -03:00
- Tipo: automatizada
- Executor: Assistente
- Resultado: Aprovado

## Objetivo

Executar o cenário da Progress Bar, distinguindo a solicitação de parada antes de 25% da validação do valor estabilizado menor ou igual a 25%, retomando até 100% e resetando para 0%.

## Obtido

O clique em `Stop` foi solicitado quando a leitura imediatamente anterior indicava 10%. Depois do clique, a barra estabilizou em 14%, dentro do limite de até 25%. A execução foi retomada, chegou exatamente a 100% e, depois do `Reset`, retornou exatamente a 0%.

O cenário terminou com 1 teste executado, 0 falhas, 0 erros e 0 ignorados, em 23,66 segundos.

## Evidências

- `screenshots/01-barra-parada-ate-25.png`: barra parada em 14% e botão novamente identificado como `Start`.
- `screenshots/02-barra-em-100.png`: barra completa em 100% e botão `Reset` disponível.
- `screenshots/03-barra-resetada-em-0.png`: barra em 0% e botão `Start` disponível.
- `relatorios/ui-04.html` e `relatorios/ui-04.json`: cenário Cucumber, valores registrados e capturas anexadas.
- `relatorios/TEST-com.accenture.challenge.ProgressBarTest.xml` e `relatorios/com.accenture.challenge.ProgressBarTest.txt`: resultado do executor.
- Revisão de dados sensíveis: concluída. As imagens mostram somente a interface pública do DemoQA.

## Limitação

Existe uma diferença temporal entre a última leitura e a efetivação do clique. A margem de 10% reduziu esse risco, mas o teste continuou exigindo que o valor estabilizado permanecesse menor ou igual a 25%.

O Selenium 4.47.0 emitiu aviso de correspondência aproximada CDP 151 para Chrome 153. O cenário não usa comandos CDP e foi concluído.
