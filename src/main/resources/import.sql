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

-- FORNECEDORES
INSERT INTO fornecedor (nome, cnpj, telefone, email, website, data_criacao) 
VALUES ('Agro Distribuidora', '56.789.012/0001-56', '(11) 7890-1234', 'contato@agrodist.com.br', 'www.agrodist.com.br', CURRENT_TIMESTAMP);

INSERT INTO fornecedor (nome, cnpj, telefone, email, website, data_criacao) 
VALUES ('Agroquímica BR', '67.890.123/0001-67', '(11) 8901-2345', 'vendas@agroquimicabr.com.br', 'www.agroquimicabr.com.br', CURRENT_TIMESTAMP);

INSERT INTO fornecedor (nome, cnpj, telefone, email, website, data_criacao) 
VALUES ('Rural Suprimentos', '78.901.234/0001-78', '(11) 9012-3456', 'contato@ruralsuprimentos.com.br', 'www.ruralsuprimentos.com.br', CURRENT_TIMESTAMP);

INSERT INTO fornecedor (nome, cnpj, telefone, email, website, data_criacao) 
VALUES ('AgroTech Distribuidora', '89.012.345/0001-89', '(11) 0123-4567', 'vendas@agrotech.com.br', 'www.agrotech.com.br', CURRENT_TIMESTAMP);

-- RELACIONAMENTO FORNECEDOR_AGROTOXICO
INSERT INTO fornecedor_agrotoxico (fornecedor_id, agrotoxico_id) VALUES (1, 1);
INSERT INTO fornecedor_agrotoxico (fornecedor_id, agrotoxico_id) VALUES (1, 2);
INSERT INTO fornecedor_agrotoxico (fornecedor_id, agrotoxico_id) VALUES (2, 1);
INSERT INTO fornecedor_agrotoxico (fornecedor_id, agrotoxico_id) VALUES (2, 3);
INSERT INTO fornecedor_agrotoxico (fornecedor_id, agrotoxico_id) VALUES (3, 2);
INSERT INTO fornecedor_agrotoxico (fornecedor_id, agrotoxico_id) VALUES (3, 4);
INSERT INTO fornecedor_agrotoxico (fornecedor_id, agrotoxico_id) VALUES (4, 3);
INSERT INTO fornecedor_agrotoxico (fornecedor_id, agrotoxico_id) VALUES (4, 4);

-- ESTOQUE
INSERT INTO estoque (quantidade, data_entrada, data_validade, lote, preco_compra, preco_venda, agrotoxico_id, fornecedor_id, data_criacao) 
VALUES (100, '2025-01-10', '2027-01-10', 'GLI2025-001', 150.50, 230.75, 1, 1, CURRENT_TIMESTAMP);

INSERT INTO estoque (quantidade, data_entrada, data_validade, lote, preco_compra, preco_venda, agrotoxico_id, fornecedor_id, data_criacao) 
VALUES (75, '2025-01-15', '2026-07-15', 'MAN2025-001', 125.30, 195.60, 2, 1, CURRENT_TIMESTAMP);

INSERT INTO estoque (quantidade, data_entrada, data_validade, lote, preco_compra, preco_venda, agrotoxico_id, fornecedor_id, data_criacao) 
VALUES (50, '2025-02-01', '2027-02-01', 'GLI2025-002', 152.75, 235.40, 1, 2, CURRENT_TIMESTAMP);

INSERT INTO estoque (quantidade, data_entrada, data_validade, lote, preco_compra, preco_venda, agrotoxico_id, fornecedor_id, data_criacao) 
VALUES (120, '2025-02-05', '2026-08-05', 'DEL2025-001', 180.25, 275.90, 3, 2, CURRENT_TIMESTAMP);

INSERT INTO estoque (quantidade, data_entrada, data_validade, lote, preco_compra, preco_venda, agrotoxico_id, fornecedor_id, data_criacao) 
VALUES (80, '2025-02-10', '2026-06-10', 'MAN2025-002', 124.50, 192.80, 2, 3, CURRENT_TIMESTAMP);

INSERT INTO estoque (quantidade, data_entrada, data_validade, lote, preco_compra, preco_venda, agrotoxico_id, fornecedor_id, data_criacao) 
VALUES (60, '2025-02-15', '2026-08-15', 'CAR2025-001', 200.75, 310.50, 4, 3, CURRENT_TIMESTAMP);

INSERT INTO estoque (quantidade, data_entrada, data_validade, lote, preco_compra, preco_venda, agrotoxico_id, fornecedor_id, data_criacao) 
VALUES (90, '2025-03-01', '2026-09-01', 'DEL2025-002', 178.90, 270.30, 3, 4, CURRENT_TIMESTAMP);

INSERT INTO estoque (quantidade, data_entrada, data_validade, lote, preco_compra, preco_venda, agrotoxico_id, fornecedor_id, data_criacao) 
VALUES (70, '2025-03-05', '2026-09-05', 'CAR2025-002', 198.25, 305.75, 4, 4, CURRENT_TIMESTAMP);