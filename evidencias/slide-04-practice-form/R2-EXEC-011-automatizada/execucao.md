# R2-EXEC-011 — Slide 4 / UI-01

- Data e término: 2026-09-18 23:15:28 -03:00
- Tipo: automatizada
- Executor: Assistente
- Resultado: Aprovado

## Esperado

Acessar o DemoQA, abrir `Forms > Practice Form`, preencher todos os campos com dados fictícios válidos, anexar o TXT versionado, submeter, validar no popup os dados enviados e fechá-lo.

## Obtido

O cenário concluiu todos os steps. O popup apresentou o nome, e-mail, gênero, celular, nascimento, matéria, hobby, nome do arquivo, endereço, estado e cidade esperados. A captura `popup-practice-form` foi anexada ao relatório Cucumber. Depois do fechamento, o modal deixou de ser exibido.

O relatório registrou 1 cenário, 0 falhas, 0 erros e 0 ignorados, com duração de 15,48 segundos. O build terminou com sucesso.

## Dados da execução

- Seed: `1789784120585`
- Nome: `Diana Vieira`
- E-mail: `qa17897841205857044@example.com`
- Gênero: `Female`
- Celular: `6651064615`
- Nascimento: `1995-03-17`
- Matéria: `English`
- Hobby: `Music`
- Arquivo: `practice-form-upload.txt`
- Endereço: `Rua de Teste, 576`
- Estado/cidade: `Rajasthan / Jaipur`

## Observações técnicas

- O clique nativo no botão `Close` não fechou o popup no Chrome headless desta máquina. A contingência acessível com `Escape` fechou o modal; a automação aguardou explicitamente o fim da transição visual antes de verificar o resultado.
- O Selenium Manager provisionou ChromeDriver `153.0.8010.52` para Chrome `153.0.8010.47`.
- O Selenium emitiu aviso de que usou CDP 151 como correspondência mais próxima para o Chrome 153. O cenário não usa comandos CDP e o aviso não impediu a execução.
- Não há dados pessoais reais ou segredos na evidência.
