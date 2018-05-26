<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="br.com.daniel.avaliacao.modelo.Processo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <%@ page isELIgnored="false" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

	<script src="../js/script.js"  charset="UTF-8"></script>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<title>Pesquisar Processo</title>
</head>
<body>


	<div class="linha divMenuTabela margemDivPrincipal">
		<div class="divTabelaCelula divMenuTamanho">

			<div class="menu-vertical">
				<a href="../index.jsp" class="active">HOME</a>
				<a href="cadastrar.jsp">Cadastrar</a>
				<a href="pesquisar.jsp">Pesquisar</a> 
				
			</div>

		</div>

		<div class="divTabelaCelula">
			
			<div id="idDivResultado" class="divMenuTabela" >
				
				<div class="divTabelaCelula divMenuLabelTamanho margemElementos">
					<label class="margemElementos">Número do Processo:</label> <br/>
					<label >Requerente:</label>
				</div>
				
				<div class="divTabelaCelula tamanhoEntradaTexto">
					<input type="text" name="pesquisaNumPub" id="pesquisaNumPub" class="tamanhoEntradaTexto margemElementos"/> <br/>
					<input type="text" name="pesquisaRequerente" id="pesquisaRequerente" class="tamanhoEntradaTexto"/>
				</div>
				
			</div>
			<div class="divMenuLabelTamanho" style="margin-top: 40px">
				<input type="button" value="Pesquisar" class="button" id="btnProcessoFiltro"/>
			</div>
		
			<div id="divTabelaPesquisa" style="display: none; margin-top: 40px" class="linha" >

				
				<% List<Processo> processos = (List<Processo>) request.getSession().getAttribute("processos"); %>
				
					<%if (processos != null) { %>
					
				<table id="tabelaFiltro" class="tabelaFiltro">
				
					<thead>
						<tr>
							<th >Título </th>
							<th style="width: 10%">Número de Publicação</th>
							<th style="width: 12%">Número de Pedido Internacional </th>
							<th style="width: 10%">Data da Publição </th>
							<th>Requerentes </th>				
						</tr>
					</thead>
					<% for (Processo p : processos) { %>
					<tr> 
						<td> <%= p.getTitulo() %> </td>
						<td> <%= p.getNumeroPub() %> </td>
						<td> <%= p.getNumeroPedidoIntl() %> </td>
						<td> <%= p.getDataString() %> </td>
						<td> <%= p.getNomesRequerentes() %> </td>					
					</tr>
					
					<%}  %>
				</table>
				<% } %>
			</div>
			
		</div>
	</div>





</body>
</html>