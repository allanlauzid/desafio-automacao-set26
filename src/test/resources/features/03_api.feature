# language: pt
@slide-03 @api-01
Funcionalidade: Reserva de livros pela API

  Cenário: Associar dois livros distintos a um usuário autorizado
    Dado que crio um usuário exclusivo
    Quando gero um token para o usuário
    Então o usuário está autorizado
    Quando consulto o catálogo de livros
    E associo dois livros distintos do catálogo ao usuário
    Então a consulta do usuário apresenta os dois livros escolhidos
