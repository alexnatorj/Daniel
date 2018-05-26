
$(document).on("click", "#btnPesquisa", function() {
	var valorNumProc = $('#numeroProcesso').val();

	if (valorNumProc.length == 0) {
		alert('Preencha o campo Número de Processo');
		return;
	}

	$.ajax({
		type : "GET",
		url : "../Processo?processo=" + valorNumProc,
		success: function(r) {

		var numProc = $(r).find('#detailPCTtableWO').text();
		var pedidoIntl = $(r).find('#detailPCTtableAN').text();
		var data = $(r).find('#detailPCTtablePubDate').text();
		var requerentes = $(r).find('#PCTapplicants').text();
		var titulo = $(r).find('.PCTtitle:first').text();

		$('#numProc').text(numProc);
		$('#pedidoIntl').text(pedidoIntl);
		$('#data').text(data);
		$('#requerentes').text(requerentes);
		$('#titulo').text(titulo);

		$('#resultadoPesquisa').show();
		$('#numeroProcesso').val("");
	},
	error: function(request, status, error) {
		$('#numeroProcesso').val("");
		alert(request.responseText);
	}
	
	});
});

$(document).on("click", "#btnSalvarProcesso", function() {
	$.ajax({
		type : "POST",
		url : "../Processo?cmd=salvar",
		data : {
			"numProc" : $('#numProc').text(),
			"pedidoIntl" : $('#pedidoIntl').text(),
			"data" : $('#data').text(),
			"requerentes" : $('#requerentes').text(),
			"titulo" : $('#titulo').text()
		},

		success : function(msg) {
			$('#numProc').text("");
			$('#pedidoIntl').text("");
			$('#data').text("");
			$('#requerentes').text("");
			$('#titulo').text("");
			$('#resultadoPesquisa').hide();
			$('#numeroProcesso').val("");
			alert(msg);
		},
		error : function(e) {
			alert(e);
		}

	});
});

$(document).on("click", "#btnProcessoFiltro", function() {
	$.ajax({
		type : "POST",
		url : "../Processo?cmd=filtro",
		data : {
			"pesquisaNumPub" : $('#pesquisaNumPub').val(),
			"pesquisaRequerente" : $('#pesquisaRequerente').val(),
		},

		success : function(msg) {
			$('#pesquisaNumPub').val("");
			$('#pesquisaRequerente').val("");
				
			$('#divTabelaPesquisa').load('pesquisar.jsp #tabelaFiltro');
				
			
			onComplete();

		},
		error : function(request, status, error) {
			$('#divTabelaPesquisa').hide();
			alert(request.responseText);
		}

	});
});

function onComplete() {
	$( document ).ajaxComplete(function( event, xhr, settings ) {
		$('#divTabelaPesquisa').show();
	
		});
}

function enterPressionado(source, btn) {
	document.getElementById(source).onkeypress=function(e) {
		if (e.keyCode == 13) {
			document.getElementById(btn).click();
		}
	}
}
