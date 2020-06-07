Feature: Title of your feature
  I want to use this template for my feature file


  @tag1
  Scenario Outline: Pesquisar e colocar em ordem
    Given o usuario acessa o site <url>
    When o usuario digitar no campo de pesquisa 
    And clicar no botao de pesquisa
    Then ordem de roupa
    And fecha broser do teste
    
    Examples: 
      |url  																	|
      |http://automationpractice.com/index.php|

      
  @tag2
  Scenario Outline: acesso atraves link 
    Given o usuario acessa o site <url>
    When o usuario clica aleatóriamente estilo de roupa
    And fecha broser do teste
    
    Examples: 
      |url  																	|
      |http://automationpractice.com/index.php|
      
  @tag3
  Scenario Outline: realiza compra 
    Given o usuario acessa o site <url>
    When o usuario clica aleatóriamente estilo de roupa
    And  o usuario digita a quantidade de roupa <quantidade>
    And clica no botao Add to card
    And clica no botao Proceed To Checkout
    And clica no botao Proceed To Checkout
    And fecha broser do teste
    
    Examples: 
      |url  																	|quantidade|
      |http://automationpractice.com/index.php|5				 |