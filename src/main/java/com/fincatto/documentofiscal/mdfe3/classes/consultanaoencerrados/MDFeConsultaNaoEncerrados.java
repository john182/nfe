package com.fincatto.documentofiscal.mdfe3.classes.consultanaoencerrados;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.validadores.BigDecimalParser;
import com.fincatto.documentofiscal.validadores.StringValidador;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;

/**
 * Created by Eldevan Nery Junior on 22/11/17.
 *
 * Tipo Pedido de Consulta MDF-e Não Encerrados.
 *
 */
@Root(name = "consMDFeNaoEnc")
@Namespace(reference = "http://www.portalfiscal.inf.br/mdfe")
public class MDFeConsultaNaoEncerrados extends DFBase {

    @Attribute(name = "versao")
    private String versao;

    @Element(name = "tpAmb")
    private DFAmbiente ambiente;

    @Element(name = "xServ")
    private String servico = "CONSULTAR NÃO ENCERRADOS" ;

    /**
     * CNPJ do Emitente do MDF-e.
     */
    @Element(name = "CNPJ")
    private String cnpj;

    public void setVersao(final BigDecimal versao) {
        this.versao = BigDecimalParser.tamanho4Com2CasasDecimais(versao, "Versao Nota Consulta");
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public void setAmbiente(final DFAmbiente ambiente) {
        this.ambiente = ambiente;
    }

    public void setServico(final String servico) {
        StringValidador.equals("CONSULTAR NÃO ENCERRADOS", servico);
        this.servico = servico;
    }

    public String getVersao() {
        return this.versao;
    }

    public DFAmbiente getAmbiente() {
        return this.ambiente;
    }

    public String getServico() {
        return this.servico;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = StringValidador.cnpj(cnpj, "CNPJ do emitente");
    }
}