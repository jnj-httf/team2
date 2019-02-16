package jj.ubs.domain.infra;


import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "vlr_latitude",
    "vlr_longitude",
    "cod_munic",
    "cod_cnes",
    "nom_estab",
    "dsc_endereco",
    "dsc_bairro",
    "dsc_cidade",
    "dsc_telefone",
    "dsc_estrut_fisic_ambiencia",
    "dsc_adap_defic_fisic_idosos",
    "dsc_equipamentos",
    "dsc_medicamentos",
    "co_cep"
})
public class Record {

    @JsonProperty("vlr_latitude")
    private String vlrLatitude;
    @JsonProperty("vlr_longitude")
    private String vlrLongitude;
    @JsonProperty("cod_munic")
    private String codMunic;
    @JsonProperty("cod_cnes")
    private String codCnes;
    @JsonProperty("nom_estab")
    private String nomEstab;
    @JsonProperty("dsc_endereco")
    private String dscEndereco;
    @JsonProperty("dsc_bairro")
    private String dscBairro;
    @JsonProperty("dsc_cidade")
    private String dscCidade;
    @JsonProperty("dsc_telefone")
    private String dscTelefone;
    @JsonProperty("dsc_estrut_fisic_ambiencia")
    private String dscEstrutFisicAmbiencia;
    @JsonProperty("dsc_adap_defic_fisic_idosos")
    private String dscAdapDeficFisicIdosos;
    @JsonProperty("dsc_equipamentos")
    private String dscEquipamentos;
    @JsonProperty("dsc_medicamentos")
    private String dscMedicamentos;
    @JsonProperty("co_cep")
    private String coCep;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("vlr_latitude")
    public String getVlrLatitude() {
        return vlrLatitude;
    }

    @JsonProperty("vlr_latitude")
    public void setVlrLatitude(String vlrLatitude) {
        this.vlrLatitude = vlrLatitude;
    }

    @JsonProperty("vlr_longitude")
    public String getVlrLongitude() {
        return vlrLongitude;
    }

    @JsonProperty("vlr_longitude")
    public void setVlrLongitude(String vlrLongitude) {
        this.vlrLongitude = vlrLongitude;
    }

    @JsonProperty("cod_munic")
    public String getCodMunic() {
        return codMunic;
    }

    @JsonProperty("cod_munic")
    public void setCodMunic(String codMunic) {
        this.codMunic = codMunic;
    }

    @JsonProperty("cod_cnes")
    public String getCodCnes() {
        return codCnes;
    }

    @JsonProperty("cod_cnes")
    public void setCodCnes(String codCnes) {
        this.codCnes = codCnes;
    }

    @JsonProperty("nom_estab")
    public String getNomEstab() {
        return nomEstab;
    }

    @JsonProperty("nom_estab")
    public void setNomEstab(String nomEstab) {
        this.nomEstab = nomEstab;
    }

    @JsonProperty("dsc_endereco")
    public String getDscEndereco() {
        return dscEndereco;
    }

    @JsonProperty("dsc_endereco")
    public void setDscEndereco(String dscEndereco) {
        this.dscEndereco = dscEndereco;
    }

    @JsonProperty("dsc_bairro")
    public String getDscBairro() {
        return dscBairro;
    }

    @JsonProperty("dsc_bairro")
    public void setDscBairro(String dscBairro) {
        this.dscBairro = dscBairro;
    }

    @JsonProperty("dsc_cidade")
    public String getDscCidade() {
        return dscCidade;
    }

    @JsonProperty("dsc_cidade")
    public void setDscCidade(String dscCidade) {
        this.dscCidade = dscCidade;
    }

    @JsonProperty("dsc_telefone")
    public String getDscTelefone() {
        return dscTelefone;
    }

    @JsonProperty("dsc_telefone")
    public void setDscTelefone(String dscTelefone) {
        this.dscTelefone = dscTelefone;
    }

    @JsonProperty("dsc_estrut_fisic_ambiencia")
    public String getDscEstrutFisicAmbiencia() {
        return dscEstrutFisicAmbiencia;
    }

    @JsonProperty("dsc_estrut_fisic_ambiencia")
    public void setDscEstrutFisicAmbiencia(String dscEstrutFisicAmbiencia) {
        this.dscEstrutFisicAmbiencia = dscEstrutFisicAmbiencia;
    }

    @JsonProperty("dsc_adap_defic_fisic_idosos")
    public String getDscAdapDeficFisicIdosos() {
        return dscAdapDeficFisicIdosos;
    }

    @JsonProperty("dsc_adap_defic_fisic_idosos")
    public void setDscAdapDeficFisicIdosos(String dscAdapDeficFisicIdosos) {
        this.dscAdapDeficFisicIdosos = dscAdapDeficFisicIdosos;
    }

    @JsonProperty("dsc_equipamentos")
    public String getDscEquipamentos() {
        return dscEquipamentos;
    }

    @JsonProperty("dsc_equipamentos")
    public void setDscEquipamentos(String dscEquipamentos) {
        this.dscEquipamentos = dscEquipamentos;
    }

    @JsonProperty("dsc_medicamentos")
    public String getDscMedicamentos() {
        return dscMedicamentos;
    }

    @JsonProperty("dsc_medicamentos")
    public void setDscMedicamentos(String dscMedicamentos) {
        this.dscMedicamentos = dscMedicamentos;
    }

    @JsonProperty("co_cep")
    public String getCoCep() {
        return coCep;
    }

    @JsonProperty("co_cep")
    public void setCoCep(String coCep) {
        this.coCep = coCep;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
