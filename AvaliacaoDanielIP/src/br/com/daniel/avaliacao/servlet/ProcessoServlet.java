package br.com.daniel.avaliacao.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import br.com.daniel.avaliacao.controle.ControleProcesso;
import br.com.daniel.avaliacao.modelo.Processo;
import br.com.daniel.avaliacao.modelo.filtro.ProcessoFiltro;

@WebServlet("/Processo")
public class ProcessoServlet extends HttpServlet {

	
	private static final long serialVersionUID = -3672558197658366953L;

	private final String addr = "https://patentscope.wipo.int/search/pt/detail.jsf?docId=#&redirectedID=true";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String numPub = req.getParameter("processo");
		
		ControleProcesso controle = new ControleProcesso();
		Processo p = null;
		try {
			p = controle.consultarPorProcesso(numPub);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (p != null) {
			resp.setStatus(Response.SC_NOT_ACCEPTABLE);
			resp.setContentType("text/plain");
		    resp.setCharacterEncoding("UTF-8");
		    resp.getWriter().write("Este processo já existe.");
		} else {
		
			String url = addr.replace("#", numPub);
	
			HttpClient httpclient = HttpClients.createDefault();
			HttpGet httpget = new HttpGet(url);
	
			HttpResponse response = httpclient.execute(httpget);
		    response.getEntity().getContentType().getValue();
		    InputStream in = response.getEntity().getContent();
		    byte[] bytes = IOUtils.toByteArray(in);
		    
		    String pagina = new String(bytes, "UTF-8");
		    resp.setContentType("text/html");
		    resp.setCharacterEncoding("UTF-8");
		    resp.getWriter().write(pagina);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String cmd = req.getParameter("cmd");
		req.getSession().removeAttribute("processos");
		if ("salvar".equals(cmd)) {		
			ControleProcesso controle = new ControleProcesso();
			
			String numProc 		= req.getParameter("numProc");
			String pedidoIntl 	= req.getParameter("pedidoIntl");
			String data 		= req.getParameter("data");
			String requerentes 	= req.getParameter("requerentes");
			String titulo 		= req.getParameter("titulo");
			
			String msg = "";
			try {
				controle.salvarProcesso(numProc, pedidoIntl, data, requerentes, titulo);
				msg = "O processo " + numProc + " foi salvo com sucesso";
			} catch (Exception e) {
				resp.setStatus(Response.SC_NOT_ACCEPTABLE);
				msg = "Ocorreu um erro ao tentar salvar um processo.";
				e.printStackTrace();
			} finally {
				resp.getWriter().print(msg);
			}	
		}
		if ("filtro".equals(cmd)) {
			String numPub 		= req.getParameter("pesquisaNumPub");
			String requerente 	= req.getParameter("pesquisaRequerente");
			ProcessoFiltro filtro = new ProcessoFiltro(numPub, requerente);
			ControleProcesso controle = new ControleProcesso();
			List<Processo> processos = controle.pesquisarPorFiltro(filtro);
			
			if (processos == null || processos.isEmpty()) {
				resp.setStatus(Response.SC_NOT_ACCEPTABLE);
				resp.getWriter().print("Nenhum dado foi encontrado");
			} else {
				resp.setStatus(200);
				
				req.getSession().setAttribute("processos", processos);
				req.getRequestDispatcher("paginas/pesquisar.jsp").forward(req, resp);
			}
			
		
		}
		
	}

	
	
}
