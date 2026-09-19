# language: pt
@slide-07 @ui @ui-04 @progress-bar
Funcionalidade: Controle da Progress Bar

  Cenário: Parar antes de 25 por cento, concluir e resetar
    Dado que acesso Widgets e Progress Bar
    Quando inicio a barra e solicito a parada antes de 25%
    Então a barra permanece parada com valor maior que 0% e menor ou igual a 25%
    Quando inicio a barra novamente e aguardo chegar a 100%
    E reseto a barra
    Então a barra retorna a 0%
