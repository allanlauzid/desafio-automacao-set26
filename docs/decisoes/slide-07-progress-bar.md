# Slide 7 — UI-04 / Progress Bar

## Decisão aprovada

- Um cenário Cucumber cobre navegação, início, parada, validação do limite, retomada, conclusão e reset.
- A ação e o oráculo permanecem distintos: o clique é solicitado com uma leitura abaixo de 25% e a aprovação exige valor estabilizado menor ou igual a 25%.
- O gatilho técnico em 10% cria margem para o avanço ocorrido entre a leitura e o clique; ele não altera o limite exigido pelo slide.
- O Page Object controla a interface e lê o percentual; as comparações ficam nos steps.
- Capturas documentam a barra parada, o estado em 100% e o estado depois do reset.
