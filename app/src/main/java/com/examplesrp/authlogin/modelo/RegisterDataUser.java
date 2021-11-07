package com.examplesrp.authlogin.modelo;

public class RegisterDataUser {

    public RegisterDataUser(){

    }

    public RegisterDataUser(String correoPersonal, String contrasenaAsignada, String nombreCompleto, String fechaNacimiento, String ciudadActual, String sexo) {
        this.correoPersonal = correoPersonal;
        this.contrasenaAsignada = contrasenaAsignada;
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.ciudadActual = ciudadActual;
        this.sexo = sexo;
    }

    private String correoPersonal;

    public String getCorreoPersonal() {
        return correoPersonal;
    }

    public void setCorreoPersonal(String correoPersonal) {
        this.correoPersonal = correoPersonal;
    }

    public String getContrasenaAsignada() {
        return contrasenaAsignada;
    }

    public void setContrasenaAsignada(String contrasenaAsignada) {
        this.contrasenaAsignada = contrasenaAsignada;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCiudadActual() {
        return ciudadActual;
    }

    public void setCiudadActual(String ciudadActual) {
        this.ciudadActual = ciudadActual;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    private String contrasenaAsignada;
    private String nombreCompleto;
    private String fechaNacimiento;
    private String ciudadActual;
    private String sexo;

}
