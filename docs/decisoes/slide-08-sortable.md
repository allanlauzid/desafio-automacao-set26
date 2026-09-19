# Slide 8 — UI-05 / Sortable

## Decisão aprovada

- Um cenário Cucumber cobre navegação, criação de uma ordem não crescente, ordenação e validação final.
- A preparação também usa drag and drop porque a lista padrão já começa crescente; assim, o teste comprova que o gesto realmente alterou o estado.
- A automação lê a sequência completa do DOM antes e depois da ordenação e exige exatamente `One`, `Two`, `Three`, `Four`, `Five`, `Six` no final.
- O Page Object executa as ações de ponteiro e lê a ordem; as comparações permanecem nos steps.
- O cenário usa Selenium Actions e não altera a ordem diretamente com JavaScript.
- Capturas documentam a ordem não crescente criada e a ordem crescente final.

## Risco considerado

O teste poderia apresentar falso positivo se apenas confirmasse a ordem padrão já crescente, sem provar a execução do drag and drop.

## Limite conhecido

O caso cobre somente a aba `List`, em Chrome, resolução desktop e uma sequência conhecida. `Grid`, dispositivos móveis, outros navegadores, acessibilidade e desempenho ficam fora do escopo.
