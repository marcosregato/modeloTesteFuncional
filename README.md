# ModeloTesteFuncional

> ModeloTeste, faz parte de arquitetura de sistema para testa sistemas web.</br> 

![Semantic description of image](./diagrama.png)</p>
<h3> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 Arquitetura do projeto </h3>

> ** Ferramentas usadas no desenvolvimento ** </br>
> * Java
> * Junit
> * Selenium (Webdriver)
> * Sonarqube
> * OpenCSV </br>

> Os testes podem ser executados ou no Cucumber ou no Junit. </br>
> Na pasta config, temos 2 classes que são :

> __RunnerTestCucumber__ </br>

> 	Os teste serão executados na forma tradicional da execucão do Cucumber.
> 	Colocando o caminho da pasta steps do seu projeto.
	
> ** RunnerTestJunit ** </br>

> 	Os testes serão executados pelo Junit, colocando no nome da classe.
> 	No caso desse projeto o nome e TC_001_PaginaPrincipal.class, que fica no pacote cenarioTeste.

# Evidência de teste

> Na execução do sistema, o script para construir uma estrutura de pastas

> 	FERRAMENTA_TESTE/
> 	├── logsCSV
> 	├── prints (EM DESENVOLVIMENTO)
> 	└── relatorio (EM DESENVOLVIMENTO)

> Na pasta script contem 2 scripts criarEstruturaDiretorioLinux.sh (Linux) e criarEstruturaDiretorioWindows.bat (Windows) </br>
> São elas que contrui a estruturas de pastas para as evidências 

> __Descrição dos pastas__ </b>

> O diretorio logCSV, e gerado arquivo no formato CSV com o resultados dos steps do teste.</br>
> Exemplo :

> 	Status,Data,Hora,Nome Metodo, Mensagem Erro
> 	OK,23-02-2020,01:32,setTxtPesquisar  

> Nesse exemplo a coluna Mensagem ERRO está vazia, porquê, não deu erro na execução do teste.
> Caso tenha dado errado, será preenchido com uma mensagem. </br>
> Exemplo : 

> 	Status,Data,Hora,Nome Metodo, Mensagem Erro
> 	ERRO,23-02-2020,01:32,cenarioTestePesquisarComTexto,Tried to run command without establishing a connection.


# Linha de comandos

> __Sonarqube__ </br>

> 	mvn sonar:sonar -Dsonar.host.url=http://localhost:9000
> 	ou
> 	mvn clean verify sonar:sonar

# Como executar os teste.

> Na raiz do projeto, o arquivo config.properties, tem as configurações para a execução do teste.


# Links dos projetos da arquitetura
> __Modelo Teste Funcional__
> [GitHub Pages](https://github.com/marcosregato/modeloTesteFuncional).</br>

> __Painel Controle Teste__
> [GitHub Pages](https://github.com/marcosregato/painelControleTeste).</br>

> __ServiceTeste__
[GitHub Pages](https://github.com/marcosregato/serviceTeste).</br>
