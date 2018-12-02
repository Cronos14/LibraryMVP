package com.javatar.basemvp.proyectobase.models.data;

import com.google.gson.annotations.SerializedName;

public class Response {
    @SerializedName(value="code", alternate={"codigo","codigoGeneral"})
    private String code;
    @SerializedName(value="resultadoOperacion", alternate={"result"})
    private int resultadoOperacion;
    @SerializedName(value="descripcion", alternate={"description","descripcionGeneral"})
    private String descripcion;
    private String idException;
    private String correlationId;
    private int codeHttp;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getResultadoOperacion() {
        return resultadoOperacion;
    }

    public void setResultadoOperacion(int resultadoOperacion) {
        this.resultadoOperacion = resultadoOperacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIdException() {
        return idException;
    }

    public void setIdException(String idException) {
        this.idException = idException;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    public int getCodeHttp() {
        return codeHttp;
    }

    public void setCodeHttp(int codeHttp) {
        this.codeHttp = codeHttp;
    }
}
