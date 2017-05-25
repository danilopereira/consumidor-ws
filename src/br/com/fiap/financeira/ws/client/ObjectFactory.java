
package br.com.fiap.financeira.ws.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.com.fiap.financeira.ws.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CadastrarClienteResponseReturn_QNAME = new QName("http://finCliente.com.br", "return");
    private final static QName _ClienteNome_QNAME = new QName("http://finCliente.com.br/xsd", "nome");
    private final static QName _ClienteUsuario_QNAME = new QName("http://finCliente.com.br/xsd", "usuario");
    private final static QName _ClienteSenha_QNAME = new QName("http://finCliente.com.br/xsd", "senha");
    private final static QName _CadastrarClienteCliente_QNAME = new QName("http://finCliente.com.br", "cliente");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.com.fiap.financeira.ws.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Login }
     * 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link Cliente }
     * 
     */
    public Cliente createCliente() {
        return new Cliente();
    }

    /**
     * Create an instance of {@link CadastrarClienteResponse }
     * 
     */
    public CadastrarClienteResponse createCadastrarClienteResponse() {
        return new CadastrarClienteResponse();
    }

    /**
     * Create an instance of {@link CadastrarCliente }
     * 
     */
    public CadastrarCliente createCadastrarCliente() {
        return new CadastrarCliente();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Login }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://finCliente.com.br", name = "return", scope = CadastrarClienteResponse.class)
    public JAXBElement<Login> createCadastrarClienteResponseReturn(Login value) {
        return new JAXBElement<Login>(_CadastrarClienteResponseReturn_QNAME, Login.class, CadastrarClienteResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://finCliente.com.br/xsd", name = "nome", scope = Cliente.class)
    public JAXBElement<String> createClienteNome(String value) {
        return new JAXBElement<String>(_ClienteNome_QNAME, String.class, Cliente.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://finCliente.com.br/xsd", name = "usuario", scope = Cliente.class)
    public JAXBElement<String> createClienteUsuario(String value) {
        return new JAXBElement<String>(_ClienteUsuario_QNAME, String.class, Cliente.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://finCliente.com.br/xsd", name = "senha", scope = Cliente.class)
    public JAXBElement<String> createClienteSenha(String value) {
        return new JAXBElement<String>(_ClienteSenha_QNAME, String.class, Cliente.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://finCliente.com.br/xsd", name = "usuario", scope = Login.class)
    public JAXBElement<String> createLoginUsuario(String value) {
        return new JAXBElement<String>(_ClienteUsuario_QNAME, String.class, Login.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://finCliente.com.br/xsd", name = "senha", scope = Login.class)
    public JAXBElement<String> createLoginSenha(String value) {
        return new JAXBElement<String>(_ClienteSenha_QNAME, String.class, Login.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Cliente }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://finCliente.com.br", name = "cliente", scope = CadastrarCliente.class)
    public JAXBElement<Cliente> createCadastrarClienteCliente(Cliente value) {
        return new JAXBElement<Cliente>(_CadastrarClienteCliente_QNAME, Cliente.class, CadastrarCliente.class, value);
    }

}
