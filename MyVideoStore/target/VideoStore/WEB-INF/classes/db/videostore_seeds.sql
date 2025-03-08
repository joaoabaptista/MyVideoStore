-- Inserir o usuário admin123, mas não falhar se ele já existir
INSERT INTO customers (user_name, email, "password", password_confirm)
VALUES ('admin123', 'admin@example.com', 'qwerty', 'qwerty')
    ON CONFLICT (user_name) DO NOTHING;

-- Inserir o usuário Ramadan1, mas não falhar se ele já existir
INSERT INTO customers (user_name, email, "password", password_confirm)
VALUES ('Ramadan1', 'ramadan@example.com', '123456789', '123456789')
    ON CONFLICT (user_name) DO NOTHING;
