CREATE TABLE consertos (
    id bigint AUTO_INCREMENT PRIMARY KEY,
    dataEntrada DATE NOT NULL,
    dataSaida DATE NOT NULL,
    marca VARCHAR(255) NOT NULL,
    modelo VARCHAR(255) NOT NULL,
    ano INT NOT NULL,
    nome VARCHAR(255) NOT NULL,
    anosExperiencia INT NOT NULL
);
