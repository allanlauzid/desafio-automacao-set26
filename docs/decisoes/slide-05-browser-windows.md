# Slide 5 — UI-02 / Browser Windows

## Decisão aprovada

- Um cenário Cucumber cobre navegação, abertura, validação e fechamento da nova janela.
- O identificador novo é obtido pela diferença entre os conjuntos observados antes e depois do clique.
- A mensagem é comparada na janela secundária e a captura é anexada antes do fechamento.
- A validação final confirma o conjunto original de janelas, o foco original e a disponibilidade da página `Browser Windows`.
- O encerramento do WebDriver no `@After` evita janelas órfãs mesmo em caso de falha.
