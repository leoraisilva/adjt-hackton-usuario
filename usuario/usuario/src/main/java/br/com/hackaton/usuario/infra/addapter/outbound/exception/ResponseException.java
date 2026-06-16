package br.com.hackaton.usuario.infra.addapter.outbound.exception;

public record ResponseException(String type, String title, int status, String detail, String instance) {
}
