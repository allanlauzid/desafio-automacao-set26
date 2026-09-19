# language: pt
@slide-06 @web-tables
Funcionalidade: Manutenção de registros em Web Tables

  @ui-03
  Cenário: Criar, editar e excluir o mesmo registro
    Dado que acesso Elements e Web Tables
    Quando crio um registro com dados fictícios únicos
    Então o registro apresenta os dados cadastrados
    Quando edito o mesmo registro
    Então o registro apresenta os dados atualizados
    Quando excluo o registro criado
    Então o registro não aparece mais na tabela

  @ui-bonus-01
  Cenário: Criar e excluir doze registros dinâmicos
    Dado que acesso Elements e Web Tables
    Quando crio 12 registros com dados únicos
    Então os 12 registros aparecem na tabela
    Quando excluo todos os registros criados
    Então nenhum dos 12 registros permanece na tabela
