
package br.com.fiap.financeira.ws.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "CadastroClientePortType", targetNamespace = "http://finCliente.com.br")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface CadastroClientePortType {


    /**
     * 
     * @param cliente
     * @return
     *     returns br.com.fiap.financeira.ws.client.Login
     */
    @WebMethod(action = "urn:cadastrarCliente")
    @WebResult(targetNamespace = "http://finCliente.com.br")
    @RequestWrapper(localName = "cadastrarCliente", targetNamespace = "http://finCliente.com.br", className = "br.com.fiap.financeira.ws.client.CadastrarCliente")
    @ResponseWrapper(localName = "cadastrarClienteResponse", targetNamespace = "http://finCliente.com.br", className = "br.com.fiap.financeira.ws.client.CadastrarClienteResponse")
    public Login cadastrarCliente(
        @WebParam(name = "cliente", targetNamespace = "http://finCliente.com.br")
        Cliente cliente);

}