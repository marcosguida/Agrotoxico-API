-- Fabricante data
INSERT INTO fabricante (nome, cnpj) VALUES ('Bayer', '12.345.678/0001-90');
INSERT INTO fabricante (nome, cnpj) VALUES ('Syngenta', '98.765.432/0001-10');

INSERT INTO agrotoxico (nomeComercial, tipoFormulacao, fabricante_id) VALUES ('Glifosato', 'SOLUCAO', 1);
INSERT INTO agrotoxico (nomeComercial, tipoFormulacao, fabricante_id) VALUES ('Mancozeb', 'SUSPENSAO', 2);
INSERT INTO agrotoxico (nomeComercial, tipoFormulacao, fabricante_id) VALUES ('Deltametrina', 'EMULSAO', 1);
INSERT INTO agrotoxico (nomeComercial, tipoFormulacao, fabricante_id) VALUES ('Carbofurano', 'GRANULADO', 2);