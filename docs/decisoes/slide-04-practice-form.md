# Slide 4 — UI-01 / Practice Form

## Decisão aprovada

- Um cenário Cucumber cobre a navegação, o preenchimento completo, o upload, o envio, a conferência do popup e o fechamento.
- Os dados válidos são fictícios e aleatórios; a seed de cada tentativa é registrada para reprodução.
- O arquivo `practice-form-upload.txt` faz parte do projeto, conforme exigido pelo slide.
- Os Page Objects executam ações e leem o estado; as comparações permanecem nos steps.
- A captura do popup é anexada ao relatório antes do fechamento.
- O clique no botão `Close` é tentado primeiro. No ambiente headless observado, a contingência com `Escape` foi necessária; a aprovação exige invisibilidade real ao fim da animação.
