INSERT INTO pessoa (data_nascimento, email, nome) VALUES ('1990-05-15', 'joao.silva@example.com', 'João da Silva'), ('1985-09-20', 'maria.souza@example.com', 'Maria Souza'), ('2000-12-01', 'carlos.oliveira@example.com', 'Carlos Oliveira'), ('1995-07-08', 'ana.pereira@example.com', 'Ana Pereira');

INSERT INTO documento (tipo, pessoa_id, numero) VALUES ('CPF', 1, '123.456.789-00'), ('RG', 1, 'MG-12.345.678'), ('CPF', 2, '987.654.321-00'), ('RG', 3, '456.123.789-00'), ('RG', 4, 'SP-98.765.432');

INSERT INTO endereco (pessoa_id, bairro, cep, cidade, complemento, estado, logradouro, numero) VALUES (1, 'Centro', '30123-456', 'Belo Horizonte', 'Apto 101', 'MG', 'Rua das Flores', '123'), (2, 'Jardim Paulista', '01415-000', 'São Paulo', NULL, 'SP', 'Av. Paulista', '1000'), (3, 'Copacabana', '22041-001', 'Rio de Janeiro', 'Bloco B', 'RJ', 'Rua Atlântica', '456'), (4, 'Boa Viagem', '51020-010', 'Recife', 'Casa 2', 'PE', 'Rua dos Navegantes', '789');

INSERT INTO telefone (pessoa_id, ddd, numero, tipo) VALUES (1, '31', '999999999', 'CELULAR'), (1, '31', '32323232', 'RESIDENCIAL'), (2, '11', '988888888', 'CELULAR'), (3, '21', '22223333', 'COMERCIAL'), (4, '81', '977777777', 'CELULAR');
