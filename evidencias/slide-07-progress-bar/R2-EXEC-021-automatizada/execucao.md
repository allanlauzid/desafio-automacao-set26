# R2-EXEC-021 — Slide 7 / UI-04

- Data e término: 2026-09-19 00:24:42 -03:00
- Tipo: automatizada planejada
- Executor: Assistente
- Resultado: Bloqueado
- Classificação da ocorrência: Configuração

## Objetivo

Executar o cenário da Progress Bar, parando antes de 25%, retomando até 100% e resetando para 0%.

## Obtido

O cenário não foi iniciado. O parâmetro usado para identificar a pasta da execução não chegou íntegro ao Maven. O executor recebeu `.id=R2-EXEC-021` como uma fase do ciclo de vida inexistente e encerrou antes da compilação dos testes.

Nenhuma interação com o DemoQA ocorreu e nenhum resultado funcional foi produzido.

## Evidências e limitação

- Evidência disponível: mensagem do Maven informando `Unknown lifecycle phase ".id=R2-EXEC-021"`.
- Relatórios Cucumber e screenshots: não produzidos, pois o teste não iniciou.
- Correção adotada para a tentativa seguinte: passar os argumentos `-D` entre aspas na chamada do Maven.
- Revisão de dados sensíveis: concluída.
