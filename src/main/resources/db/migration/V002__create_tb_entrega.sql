CREATE TABLE tb_entregas (
		id BIGINT NOT NULL AUTO_INCREMENT,
        data_finalizacao DATETIME(6),
        data_pedido DATETIME(6) NOT NULL,
        destinatario_bairro VARCHAR(64) NOT NULL,
        destinatario_complemento VARCHAR(64) NOT NULL,
        destinatario_logradouro VARCHAR(64) NOT NULL,
        destinatario_nome VARCHAR(64) NOT NULL,
        destinatario_numero VARCHAR(64) NOT NULL,
        status VARCHAR(32) NOT NULL,
        taxa DECIMAL(10,2) NOT NULL,
        cliente_id BIGINT NOT NULL,
        primary key (id)
    ) engine=InnoDB;
    
ALTER TABLE tb_entregas 
       ADD  CONSTRAINT FK_entrega_cliente
       FOREIGN KEY (cliente_id) 
       REFERENCES tb_clientes (id);   