-- FABRICANTES
INSERT INTO fabricante (nome, cnpj, telefone, email, data_criacao) 
VALUES ('Bayer', '12.345.678/0001-90', '(11) 3456-7890', 'contato@bayer.com.br', CURRENT_TIMESTAMP);

INSERT INTO fabricante (nome, cnpj, telefone, email, data_criacao) 
VALUES ('Syngenta', '98.765.432/0001-10', '(11) 2345-6789', 'contato@syngenta.com.br', CURRENT_TIMESTAMP);

INSERT INTO fabricante (nome, cnpj, telefone, email, data_criacao) 
VALUES ('BASF', '23.456.789/0001-23', '(11) 4567-8901', 'contato@basf.com.br', CURRENT_TIMESTAMP);

INSERT INTO fabricante (nome, cnpj, telefone, email, data_criacao) 
VALUES ('Dow AgroSciences', '34.567.890/0001-34', '(11) 5678-9012', 'contato@dowagro.com.br', CURRENT_TIMESTAMP);

INSERT INTO fabricante (nome, cnpj, telefone, email, data_criacao) 
VALUES ('FMC', '45.678.901/0001-45', '(11) 6789-0123', 'contato@fmc.com.br', CURRENT_TIMESTAMP);

-- AGROTOXICOS
INSERT INTO agrotoxico (nomeComercial, descricao, codigo_barras, tipoFormulacao, fabricante_id, data_criacao) 
VALUES ('Glifosato', 'Herbicida sistêmico não seletivo', '789123456789', 'SOLUCAO', 1, CURRENT_TIMESTAMP);

INSERT INTO agrotoxico (nomeComercial, tipoFormulacao, fabricante_id, data_criacao) 
VALUES ('Mancozeb', 'SUSPENSAO', 2, CURRENT_TIMESTAMP);

INSERT INTO agrotoxico (nomeComercial, tipoFormulacao, fabricante_id, data_criacao) 
VALUES ('Deltametrina', 'EMULSAO', 1, CURRENT_TIMESTAMP);

INSERT INTO agrotoxico (nomeComercial, tipoFormulacao, fabricante_id, data_criacao) 
VALUES ('Carbofurano', 'GRANULADO', 2, CURRENT_TIMESTAMP);