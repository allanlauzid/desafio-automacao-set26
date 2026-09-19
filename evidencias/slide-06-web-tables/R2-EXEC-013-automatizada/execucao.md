# R2-EXEC-013 — Slide 6 / UI-03

- Data e término: 2026-09-18 23:47:01 -03:00
- Tipo: automatizada
- Executor: Assistente
- Resultado: Reprovado
- Classificação: falha da automação

## Esperado

Criar um registro único em Web Tables, confirmar seus valores, editar o mesmo registro, confirmar os valores atualizados, excluí-lo e comprovar sua ausência.

## Obtido

O cadastro foi enviado e a captura de falha mostra a linha criada com os valores esperados. A validação, porém, expirou após 15 segundos porque o seletor usado pela automação não encontrou a estrutura real da linha. Os passos de edição e exclusão não foram executados. A limpeza tentou localizar o mesmo e-mail, mas falhou pelo mesmo seletor.

O resumo Surefire registrou 2 testes do mecanismo Cucumber: 1 erro e 1 ignorado. O cenário obrigatório terminou com erro, sem falha de asserção, em 42,61 segundos.

## Dados da execução

- Seed: `1789785986380`
- Nome: `Ana Teste`
- E-mail fictício: `qa.webtable.1789785986380@example.com`
- Idade: `27`
- Salário: `4800`
- Departamento: `Quality Assurance`

## Investigação

A evidência visual confirma que o DemoQA criou o registro. A ocorrência não demonstra defeito do produto. O localizador baseado em `.rt-tr-group .rt-tr` não correspondeu de forma confiável à árvore atual. A correção localizará a célula pelo e-mail exato e subirá até a linha ancestral, preservando o e-mail como chave do teste.

Os dados do Web Tables pertencem à sessão do navegador. O encerramento do WebDriver eliminou a sessão, apesar de a rotina de limpeza pela interface não ter localizado a linha.
