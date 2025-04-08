package br.agrotoxico.model;

/**
 * Enum que representa os tipos de operações para auditoria no sistema.
 * Utilizado pela classe LogAuditoria para registrar o tipo de operação realizada.
 * 
 * A Classe LogAuditoria é responsável por registrar as operações realizadas no sistema
 * A classe de auditoria será implementada em um futuro commit.
 * 
 * @author Marcos Ribeiro
 */
public enum TipoOperacao {
    INSERCAO,
    ATUALIZACAO,
    EXCLUSAO,
    CONSULTA
} 

