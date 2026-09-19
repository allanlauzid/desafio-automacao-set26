# R2-EXEC-012 — Slide 5 / UI-02

- Data e término: 2026-09-18 23:26:44 -03:00
- Tipo: automatizada
- Executor: Assistente
- Resultado: Aprovado

## Esperado

Acessar o DemoQA, abrir `Alerts, Frame & Windows > Browser Windows`, clicar em `New Window`, confirmar que surgiu uma nova janela, validar a mensagem `This is a sample page`, fechar a janela secundária e confirmar que somente a original permaneceu aberta.

## Obtido

O cenário concluiu todos os steps. A automação comparou os identificadores antes e depois do clique, encontrou exatamente uma nova janela e mudou o foco para ela. A mensagem correspondeu exatamente ao esperado e uma captura foi anexada ao relatório Cucumber. Após o fechamento, o conjunto de identificadores voltou a conter somente a janela original, com a página `Browser Windows` disponível.

O relatório registrou 1 cenário, 0 falhas, 0 erros e 0 ignorados, com duração de 9,207 segundos. O build terminou com sucesso.

## Observações técnicas

- A nova janela foi identificada pela diferença entre conjuntos de identificadores, sem depender da ordem retornada pelo navegador.
- O `@After` encerra o WebDriver e todas as janelas mesmo se um step falhar.
- O Selenium emitiu o aviso já conhecido de correspondência CDP 151 para Chrome 153. O cenário não usa comandos CDP e o aviso não impediu a execução.
- O resultado histórico do projeto anterior não foi herdado. Esta evidência pertence somente à nova rodada.
- Não há dados pessoais reais ou segredos na evidência.
