## Dezembro de 2017 - Trabalho 2 - DCC171
##### Aluno: Rian das Dores Alves
##### Matrícula: 201676040
##### Curso: Sistemas de Informação

## Apresentação do Sistema
O sistema foi desenvolvido para um restaurante de pequeno porte, onde o garçom poderá escolher entre as nove mesas pertencentes ao estabelecimento; as mesas estão enumeradas de 1 a 9. Apresentamos no software uma tela onde constam todas as mesas disponíveis para a escolha; as mesas em verde estarão livres e as vermelhas estarão ocupadas; mesmo ocupadas, poderão ser acrescentados mais pedidos na mesa escolhida. Para o encerramento da mesa e sua liberação, o garçom deverá acionar o botão Encerrar Pedido; retornando para a tela de escolha de mesas. 

## Objetivo do Sistema
O software tem o objetivo de gerenciar os pedidos de um restaurante usando a persistência de dados por meio de arquivos texto. Assim, mesmo que o software se encerre, teremos nos arquivos de texto todos os dados referentes aos pedidos e das mesas atreladas a esses pedidos. 


## Pontos importantes do funcionamento da interface
Para a realização de um pedido o usuário deverá estar em uma mesa, para isso ele poderá escolher entre as 9 mesas do estabelecimento. Estas mesas foram representadas na Interface através de botões (JButtons). Se o botão (Mesa) estiver verde, a mesa estará vazia e se estiver vermelho a mesa estará ocupada. 
Escolhendo a Mesa, será aberto um novo Pedido. Nesta nova tela, será carregada uma JcomboBox com todos os itens disponíveis no restaurante para servir seus clientes. O usuário deverá selecionar o item na combo e acionar o botão Adicionar, onde o item selecionado será copiado para a JList abaixo e será armazenado também em um ArrayList para poder ser gerenciado posteriormente.  Há também um JButton chamado Voltar, nele o usuário poderá voltar a tela de escolhas de mesa e abrir um outro pedido em uma mesa livre qualquer.
Para realizar o fechamento do Pedido, o usuário deverá abrir a mesa em que deseja encerrar a conta e acionar o botão Encerrar Pedido. Serão calculados o valor total e serão apresentados em uma caixa de diálogo todos os itens do pedido, seus valores e as datas de abertura e fechamento do Pedido. 

## Persistência de Dados
Cada Mesa dispõe de um arquivo correspondente, neste arquivo serão gravados os dados referentes a um Pedido realizado na Mesa em questão. Em nossa aplicação, quando uma mesa estiver ocupada ela estará com um pedido, neste pedido poderá haver vários itens, que serão os nomes dos pratos e bebidas que são disponibilizadas pelo restaurante. As identificações das mesas ocupadas serão gravadas em outro arquivo, para que saibamos quais mesas estão ocupadas para gerenciamento das cores dos botões e de novos pedidos.  

## Pontos onde podem ser realizadas melhorias futuras

Podem ser realizadas melhorias no que se refere a inserção de novos itens, apesar do menu Cardápio. 
E também melhorias quanto ao Layout das telas de Pedido, onde deve ser inserido um botão de remoção do Pedido.Podemos implementar também um histórico de todos os pedidos realizados em cada mesa, por meio da persistência de dados. 
