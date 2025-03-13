-- Inserir o usuário admin123, mas não falhar se ele já existir
INSERT INTO customers (user_name, email, "password", password_confirm)
VALUES ('admin123', 'admin@example.com', 'qwerty', 'qwerty')
    ON CONFLICT (user_name) DO NOTHING;

-- Inserir o usuário Ramadan1, mas não falhar se ele já existir
INSERT INTO customers (user_name, email, "password", password_confirm)
VALUES ('Ramadan1', 'ramadan@example.com', '123456789', '123456789')
    ON CONFLICT (user_name) DO NOTHING;


INSERT INTO movies (title, duration, year, price) VALUES
      ('The Matrix', 136, 1999, 9.99),
      ('Inception', 148, 2010, 12.99),
      ('Interstellar', 169, 2014, 14.99),
      ('The Godfather', 175, 1972, 8.99),
      ('Pulp Fiction', 154, 1994, 10.99),
      ('The Dark Knight', 152, 2008, 11.99),
      ('Forrest Gump', 142, 1994, 7.99),
      ('The Shawshank Redemption', 142, 1994, 9.49),
      ('Gladiator', 155, 2000, 10.49),
      ('Titanic', 195, 1997, 11.99),
      ('Avatar', 162, 2009, 13.99);
