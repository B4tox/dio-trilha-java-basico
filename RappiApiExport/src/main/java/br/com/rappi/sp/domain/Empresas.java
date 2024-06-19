package br.com.rappi.sp.domain;

import lombok.Data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="EMPRESAS")
public class Empresas implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="ID_EMPRESA", insertable=false, updatable=false)
    private String idEmpresa;

    @Column(name="ID_ORGANIZACAO", insertable=false, updatable=false)
    private long idOrganizacao;

    @Column(name="RAZAO_SOCIAL", insertable=false, updatable=false)
    private String razaoSocial;

    @Column(name="NOME_FANTASIA", insertable=false, updatable=false)
    private String nomeFantasia;

    @Column(name="SIGLA", insertable=false, updatable=false)
    private String sigla;

    @Column(name="CNPJ", insertable=false, updatable=false)
    private String cnpj;

    @Column(name="INSCRICAO_ESTADUAL", insertable=false, updatable=false)
    private String inscricaoEstadual;

    @Column(name="INSCRICAO_MUNICIPAL", insertable=false, updatable=false)
    private String inscricaoMunicipal;

    @Column(name="ID_LOGRADOURO", insertable=false, updatable=false)
    private long   idLogradouro;

    @Column(name="NUMERO", insertable=false, updatable=false)
    private String numero;

    @Column(name="COMPLEMENTO_ENDERECO", insertable=false, updatable=false)
    private String complementoEndereco;

    @Column(name="CEP", insertable=false, updatable=false)
    private String cep;

    @Column(name="DDD_TELEFONE_01", insertable=false, updatable=false)
    private String dddTelefone01;

    @Column(name="TELEFONE_01", insertable=false, updatable=false)
    private String telefone01;

    @Column(name="DDD_TELEFONE_02", insertable=false, updatable=false)
    private String dddTelefone02;

    @Column(name="TELEFONE_02", insertable=false, updatable=false)
    private String telefone02;

    @Column(name="DDD_FAX", insertable=false, updatable=false)
    private String dddFAx;

    @Column(name="FAX", insertable=false, updatable=false)
    private String fax;

    @Column(name="EMAIL", insertable=false, updatable=false)
    private String email;

    @Column(name="ID_MATRIZ", insertable=false, updatable=false)
    private long   idMatriz;

    @Column(name="CNAE", insertable=false, updatable=false)
    private String cnae;

    @Column(name="SUFRAMA", insertable=false, updatable=false)
    private String suframa;

    @Column(name="ID_CLASSE", insertable=false, updatable=false)
    private String idClasse;

    @Column(name="CNAE2", insertable=false, updatable=false)
    private String cnae2;

    @Column(name="ATIVO", insertable=false, updatable=false)
    private String ativo;

    @Column(name="COD_NAT_JURIDICA", insertable=false, updatable=false)
    private String codNatJuridica;

    @Column(name="DESMEMBRAMENTO_CNAE", insertable=false, updatable=false)
    private String desmebramentoCnae;

    @Column(name="IDENTIFICACAO_EXTERIOR", insertable=false, updatable=false)
    private String identificacaoExterior;


}
