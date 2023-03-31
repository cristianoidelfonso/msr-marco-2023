CREATE TABLE tb_ocorrencias (
		id BIGINT NOT NULL AUTO_INCREMENT,
        entrega_id BIGINT NOT NULL,
        descricao TEXT NOT NULL,
        data_registro DATETIME NOT NULL,
        primary key (id)
    ) engine=InnoDB;
    
ALTER TABLE tb_ocorrencias 
       ADD  CONSTRAINT FK_ocorrencia_entrega
       FOREIGN KEY (entrega_id) 
       REFERENCES tb_entregas (id);   