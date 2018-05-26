# Daniel

Após importar o projeto, o arquivo hibernate.cfg.xml deverá ser configurado de acordo com as informações do banco de dados utilizado.
O arquivo está configurado para o PostgreSQL, caso use o mesmo, preencher apenas usuário e senha. Caso contrário, 
indicar o dialect, driver e url apropriados.

Para a criação das tabelas do banco de dados existem duas opções:
 - Rodar os scripts do arquivo createTables.sql localizado na pasta "script_bancodados".
 - Executar como Java Application a classe MainBD localizada no pacote "br.com.daniel.avaliacao.hibernate". Atente-se, pois antes de 
 executá-la, o schema 'daniel' deverá ser criado.
 
 
