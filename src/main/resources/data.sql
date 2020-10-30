INSERT INTO app_user (email, password,user_type)
SELECT 'admin@appcal.com', 'nimda', 1
WHERE NOT EXISTS (SELECT * FROM app_user WHERE email='admin@appcal.com');