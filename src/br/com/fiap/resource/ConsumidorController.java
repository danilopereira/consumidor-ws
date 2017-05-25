package br.com.fiap.resource;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.github.dsaouda.fiap.webservice.loja.client.EfetuarCompraClient;
import com.github.dsaouda.fiap.webservice.loja.client.ProdutoClient;
import com.github.dsaouda.fiap.webservice.loja.client.SimularCompraClient;
import com.github.dsaouda.fiap.webservice.loja.client.builder.PedidoBuilder;
import com.github.dsaouda.fiap.webservice.loja.client.model.Pedido;
import com.github.dsaouda.fiap.webservice.loja.client.model.Produto;
import com.github.dsaouda.fiap.webservice.loja.client.model.SimularCompra;

import br.com.fiap.financeira.ws.client.CadastroCliente;
import br.com.fiap.financeira.ws.client.CadastroClientePortType;
import br.com.fiap.financeira.ws.client.Cliente;
import br.com.fiap.financeira.ws.client.Login;
import br.com.fiap.model.Compra;
import br.com.fiap.model.Consumidor;
import br.com.fiap.model.ProdutoResponse;

@WebService
public class ConsumidorController {
	
	private List<Consumidor> consumidores = new ArrayList<>();
	
	@WebMethod
	public String cadastrarConsumidor(@WebParam(name="cpf") String cpf,
			@WebParam(name="nome") String nome,
			@WebParam(name="valor") Double valor,
			@WebParam(header=true, name="username")String username, 
			@WebParam(header=true, name="password") String password) {
		if(autenticado(username, password)){
			Consumidor consumidor = new Consumidor();
			CadastroClientePortType cadastroClienteWS = new CadastroCliente().getCadastroClienteHttpSoap11Endpoint();

			Cliente cliente = new Cliente();
			cliente.setCpfCnpj(Integer.valueOf(cpf));
			cliente.setNome(nome);
			cliente.setSaldo(valor);
			
			Login login = cadastroClienteWS.cadastrarCliente(cliente);
			
			consumidor.setNome(nome);
			consumidor.setCpf(cpf);
			consumidor.setUsuario(login.getUsuario().getValue());
			consumidor.setSenha(login.getSenha().getValue());
			
			consumidores.add(consumidor);
			return "Usuário ".concat(nome).concat(" cadastrado com sucesso");
		}
		else{
			return "Acesso Negado";
		}
	}

	@WebMethod
	public List<ProdutoResponse> listarProdutos(@WebParam(header=true, name="username")String username, 
			@WebParam(header=true, name="password") String password) throws Exception {
		if(autenticado(username, password)){
			ProdutoClient produtoClient = new ProdutoClient();
			List<Produto> produtos = produtoClient.todos();
			
			return produtoToProdutoResponse(produtos);
		}else{
			throw new Exception("Acesso Negado");
		}

	}

	@WebMethod
	public Compra simularCompra(@WebParam(name="cpf")String cpf,
			@WebParam(name="produtos")List<ProdutoResponse> produtos,
			@WebParam(header=true, name="username")String username, 
			@WebParam(header=true, name="password") String password) throws Exception {
		if(autenticado(username, password)){
			
			SimularCompraClient client = new SimularCompraClient();
			
			SimularCompra simular = client.simular(produtosResponseToProdutos(produtos));
			
			Compra compra = new Compra();
			compra.setValorFrete(simular.getValorFrete());
			compra.setValorImpostos(simular.getValorImpostos());
			compra.setValorProdutos(simular.getValorTotalProdutos());
			compra.setValorTotal(simular.getValorTotal());
			
			return compra;
		}else{
			throw new Exception("Acesso Negado");
		}
	}

	@WebMethod
	public boolean confirmarCompra(
			@WebParam(name="produtos")List<ProdutoResponse> produtos,
			@WebParam(header=true, name="username")String username, 
			@WebParam(header=true, name="password") String password) throws Exception {
		if(autenticado(username, password)){
			EfetuarCompraClient client = new EfetuarCompraClient();
			
			Pedido pedido = gerarPedido(produtos);
			
			return client.comprar(pedido);
		}
		else{
			throw new Exception("Acesso Negado");
		}
		
		
	}
	
	private Pedido gerarPedido(List<ProdutoResponse> produtos) {
		PedidoBuilder pedidoBuilder = new PedidoBuilder();
		
		produtos.forEach(produto->{
			pedidoBuilder.adicionarProduto(produtoResponseToProduto(produto));
		});
		
		return pedidoBuilder.build();
	}

	private Produto produtoResponseToProduto(ProdutoResponse response) {
		Produto produto = new Produto();
		
		produto.setCodigo(response.getCodigo());
		produto.setDescricao(response.getDescricao());
		produto.setQuantidadeEstoque(response.getQtdEstoque());
		produto.setValorUnitario(response.getValorUnitario());
		
		return produto;
	}
	
	private List<Produto> produtosResponseToProdutos(List<ProdutoResponse> produtos) {
		List<Produto> produtoList = new ArrayList<>();
		
		produtos.forEach(response->{
			Produto produto = produtoResponseToProduto(response);
			
			produtoList.add(produto);
		});
		
		return produtoList;
	}

	@WebMethod(exclude=true)
	private boolean autenticado(String usuario, String senha){
		if("fiap".equals(usuario) && "1234".equals(senha)){
			return true;
		}
		return false;
	}
	
	private List<ProdutoResponse> produtoToProdutoResponse(List<Produto> produtos) {
		List<ProdutoResponse> produtosResponse = new ArrayList<>();
		produtos.forEach(produto->{
			ProdutoResponse response = new ProdutoResponse();
			response.setCodigo(produto.getCodigo());
			response.setDescricao(produto.getDescricao());
			response.setQtdEstoque(produto.getQuantidadeEstoque());
			response.setValorUnitario(produto.getValorUnitario());
			
			produtosResponse.add(response);
		});
		return produtosResponse;
	}

}
