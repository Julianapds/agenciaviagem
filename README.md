# Back-end do site Rotas do Sol

Rotas do Sol é um site de viagens. Ele foi desenvolvido como atividade integrada do curso de Desenvolvimento Web Full Stack da Recode.

Para detalhes como modelos, acesse o repositório da primeira versão do projeto: https://github.com/Julianapds/backend-site-viagens

## Funcionalidades implementadas
Em relação ao projeto anterior, desenvolvido com jdbc apenas, a atividade pede que utilizemos o padrão MVC e integre front com back através de servlets. Dessa maneira, pude implementar:

- Consultar voos, hospedagens e pacotes por destino na página principal
- Cadastro de novos clientes
- Login de clientes

## Script de tabelas

```
CREATE DATABASE IF NOT EXISTS db_rotasdosol;
USE db_rotasdosol;

CREATE TABLE Cliente (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) UNIQUE,
    cpf VARCHAR(11) UNIQUE,
    telefone VARCHAR(15),
    endereco VARCHAR(255),
    senha VARCHAR(255) -- Coluna de senha adicionada
);

CREATE TABLE Destino (
    id_destino INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    pais VARCHAR(255),
    cidade VARCHAR(255)
);

CREATE TABLE Hospedagem (
    id_hospedagem INT AUTO_INCREMENT PRIMARY KEY,
    nome_hotel VARCHAR(255),
    tipo_quarto VARCHAR(255),
    data_checkin DATE,
    data_checkout DATE,
    valor_pernoite DOUBLE,
    id_destino INT,
    FOREIGN KEY (id_destino) REFERENCES Destino(id_destino)
);

CREATE TABLE Voo (
    id_voo INT AUTO_INCREMENT PRIMARY KEY,
    companhia_aerea VARCHAR(255),
    data_partida DATE,
    data_chegada DATE,
    valor_preco DOUBLE,
    id_destino INT,
    FOREIGN KEY (id_destino) REFERENCES Destino(id_destino)
);

CREATE TABLE Pacote (
    id_pacote INT AUTO_INCREMENT PRIMARY KEY,
    valor_preco DOUBLE,
    id_hospedagem INT,
    id_voo INT,
    FOREIGN KEY (id_hospedagem) REFERENCES Hospedagem(id_hospedagem),
    FOREIGN KEY (id_voo) REFERENCES Voo(id_voo)
);

CREATE TABLE StatusReserva (
    id_status INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    data_criacao DATE
);

CREATE TABLE Reserva (
    id_reserva INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT,
    id_pacote INT,
    id_hospedagem INT,
    id_voo INT,
    data_reserva DATE,
    id_status INT,
    FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente),
    FOREIGN KEY (id_pacote) REFERENCES Pacote(id_pacote),
    FOREIGN KEY (id_hospedagem) REFERENCES Hospedagem(id_hospedagem),
    FOREIGN KEY (id_voo) REFERENCES Voo(id_voo),
    FOREIGN KEY (id_status) REFERENCES StatusReserva(id_status)
);
```

## Dados para validar tabelas 

```
USE db_rotasdosol;

-- Inserindo dados na tabela Cliente
INSERT INTO Cliente (email, cpf, telefone, endereco, senha) VALUES
('joao.silva@example.com', '12345678901', '11987654321', 'Rua das Flores, 123, São Paulo', SHA2('senha123', 256)),
('maria.oliveira@example.com', '23456789012', '21987654321', 'Avenida Brasil, 456, Rio de Janeiro', SHA2('senhaabc', 256)),
('carlos.pereira@example.com', '34567890123', '31987654321', 'Praça da Sé, 789, Belo Horizonte', SHA2('senhaxyz', 256));

-- Inserindo dados na tabela Destino
INSERT INTO Destino (nome, pais, cidade) VALUES
('Praia do Forte', 'Brasil', 'Mata de São João'),
('Torres del Paine', 'Chile', 'Puerto Natales'),
('Machu Picchu', 'Peru', 'Cusco');

-- Inserindo dados na tabela Hospedagem
INSERT INTO Hospedagem (nome_hotel, tipo_quarto, data_checkin, data_checkout, valor_pernoite, id_destino) VALUES
('Hotel da Praia', 'Luxo', '2023-12-20', '2023-12-27', 300.00, 1),
('Refúgio Patagônico', 'Standard', '2023-01-15', '2023-01-22', 150.00, 2),
('Hospedaria Inca', 'Suite', '2023-07-10', '2023-07-17', 500.00, 3);

-- Inserindo dados na tabela Voo
INSERT INTO Voo (companhia_aerea, data_partida, data_chegada, valor_preco, id_destino) VALUES
('Air Brasil', '2023-12-20', '2023-12-20', 1200.00, 1),
('Chilean Skies', '2023-01-15', '2023-01-15', 800.00, 2),
('Peru Flights', '2023-07-10', '2023-07-10', 900.00, 3);

-- Inserindo dados na tabela Pacote
INSERT INTO Pacote (valor_preco, id_hospedagem, id_voo) VALUES
(1500.00, 1, 1),
(950.00, 2, 2),
(1400.00, 3, 3);

-- Inserindo dados na tabela StatusReserva
INSERT INTO StatusReserva (nome, data_criacao) VALUES
('Confirmada', '2023-01-01'),
('Pendente', '2023-01-02'),
('Cancelada', '2023-01-03');

-- Inserindo dados na tabela Reserva
INSERT INTO Reserva (id_cliente, id_pacote, id_hospedagem, id_voo, data_reserva, id_status) VALUES
(1, 1, 1, 1, '2023-11-01', 1),
(2, 2, 2, 2, '2023-11-02', 2),
(3, 3, 3, 3, '2023-11-03', 3);

```