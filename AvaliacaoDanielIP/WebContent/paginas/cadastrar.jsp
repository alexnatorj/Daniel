<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="../js/script.js" charset="UTF-8"></script>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastrar Processo</title>
</head>
<body>

<div class="linha divMenuTabela margemDivPrincipal "  style="height: -webkit-fill-available">
		<div class="divTabelaCelula divMenuTamanho">
		
			<div class="menu-vertical">
				<a href="../index.jsp" class="active">HOME</a> 
				<a href="cadastrar.jsp">Cadastrar</a>
				<a href="pesquisar.jsp">Pesquisar</a> 					
			</div>

		</div>

		<div class="divTabelaCelula">
			<div id="pesquisaProcesso" style="margin-bottom: 30px">
			<div style="margin-bottom: 30px">
				<label>Número do Processo:</label> 
				<input type="text" id="numeroProcesso" onkeypress="enterPressionado('numeroProcesso', 'btnPesquisa')" />
			</div>
				<input type="button" value="Pesquisar" id="btnPesquisa"  class="button"/>
			</div>

			<div id="resultadoPesquisa" style="display: none">
				<b><label class="margemElementos" > Número de Publicação</label></b> 
					<label class="margemElementos" id="numProc"> </label> <br /> 
				<b><label class="margemElementos" > Número de Pedido Internacional</label></b>
					<label class="margemElementos" id="pedidoIntl"> </label><br /> 
				<b><label class="margemElementos" > Data de Publicação</label></b>
					<label class="margemElementos" id="data"> </label><br /> 
				<b><label class="margemElementos" > Requerentes</label></b>
					<label class="margemElementos" id="requerentes"> </label><br /> 
				<b><label class="margemElementos" > Título</label></b>
					<label class="margemElementos" id="titulo"> </label><br /> 
				
				<input type="button" value="Salvar" id="btnSalvarProcesso" class="button"/>
			</div>

		</div>

	</div>
</body>
</html>