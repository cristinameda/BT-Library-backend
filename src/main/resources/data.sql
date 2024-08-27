-- Books
INSERT INTO books (title, author, genre, description, publisher, publication_year, total_copies)
VALUES ('The Catcher in the Rye', 'J.D. Salinger', 'Fiction', 'A story about a young man named Holden Caulfield',
        'Little, Brown and Company', '1951', 10);


INSERT INTO books (title, author, genre, description, publisher, publication_year, total_copies)
VALUES ('To Kill a Mockingbird', 'Harper Lee', 'Fiction', 'A novel about racial injustice in the Deep South',
        'J.B. Lippincott & Co', '1960', 8);


INSERT INTO books (title, author, genre, description, publisher, publication_year, total_copies)
VALUES ('1984', 'George Orwell', 'Dystopian', 'A novel about a totalitarian regime and surveillance',
        'Secker & Warburg', '1949', 12);


INSERT INTO books (title, author, genre, description, publisher, publication_year, total_copies)
VALUES ('Moby-Dick', 'Herman Melville', 'Adventure', 'The quest of Captain Ahab to seek revenge on Moby Dick',
        'Harper & Brothers', '1851', 5);


INSERT INTO books (title, author, genre, description, publisher, publication_year, total_copies)
VALUES ('Pride and Prejudice', 'Jane Austen', 'Romance', 'A classic novel about love and social standing', 'T. Egerton',
        '1813', 7);


INSERT INTO books (title, author, genre, description, publisher, publication_year, total_copies)
VALUES ('Brave New World', 'Aldous Huxley', 'Dystopian', 'A novel depicting a technologically advanced society',
        'Chatto & Windus', '1932', 15);


INSERT INTO books (title, author, genre, description, publisher, publication_year, total_copies)
VALUES ('The Great Gatsby', 'F. Scott Fitzgerald', 'Classic', 'A story of the American Dream and its discontents',
        'Scribner', '1925', 9);


INSERT INTO books (title, author, genre, description, publisher, publication_year, total_copies)
VALUES ('War and Peace', 'Leo Tolstoy', 'Historical Fiction', 'An epic novel about the Napoleonic Wars',
        'The Russian Messenger', '1869', 6);


INSERT INTO books (title, author, genre, description, publisher, publication_year, total_copies)
VALUES ('The Hobbit', 'J.R.R. Tolkien', 'Fantasy', 'A prelude to the Lord of the Rings series', 'George Allen & Unwin',
        '1937', 11);


INSERT INTO books (title, author, genre, description, publisher, publication_year, total_copies)
VALUES ('The Da Vinci Code', 'Dan Brown', 'Mystery', 'A thriller that explores art, history, and religion', 'Doubleday',
        '2003', 20);


INSERT INTO books (title, author, genre, description, publisher, publication_year, total_copies)
VALUES ('The Alchemist', 'Paulo Coelho', 'Adventure', 'A philosophical story about following your dreams', 'HarperOne',
        '1988', 18);


INSERT INTO books (title, author, genre, description, publisher, publication_year, total_copies)
VALUES ('The Lord of the Rings', 'J.R.R. Tolkien', 'Fantasy', 'An epic fantasy trilogy about the struggle against evil',
        'George Allen & Unwin', '1954', 13);


INSERT INTO books (title, author, genre, description, publisher, publication_year, total_copies)
VALUES ('Catch-22', 'Joseph Heller', 'Satire', 'A darkly comedic novel about the absurdities of war',
        'Simon & Schuster', '1961', 14);


INSERT INTO books (title, author, genre, description, publisher, publication_year, total_copies)
VALUES ('Fahrenheit 451', 'Ray Bradbury', 'Dystopian', 'A novel about a future where books are banned',
        'Ballantine Books', '1953', 10);


INSERT INTO books (title, author, genre, description, publisher, publication_year, total_copies)
VALUES ('The Shining', 'Stephen King', 'Horror', 'A chilling story about isolation and madness', 'Doubleday', '1977',
        8);


INSERT INTO books (title, author, genre, description, publisher, publication_year, total_copies)
VALUES ('The Little Prince', 'Antoine de Saint-Exupéry', 'Children\s',
        'A story about a young prince and his adventures', 'Reynal & Hitchcock', '1943', 17);


INSERT INTO books (title, author, genre, description, publisher, publication_year, total_copies)
VALUES ('One Hundred Years of Solitude', 'Gabriel García Márquez', 'Magical Realism',
        'A multi-generational tale of the Buendía family', 'Harper & Row', '1967', 12);


INSERT INTO books (title, author, genre, description, publisher, publication_year, total_copies)
VALUES ('Life of Pi', 'Yann Martel', 'Adventure', 'A novel about survival and faith on the high seas', 'Knopf', '2001',
        9);


INSERT INTO books (title, author, genre, description, publisher, publication_year, total_copies)
VALUES ('Gone with the Wind', 'Margaret Mitchell', 'Historical Fiction',
        'A story of the American South during the Civil War', 'Macmillan', '1936', 11);


INSERT INTO books (title, author, genre, description, publisher, publication_year, total_copies)
VALUES ('The Kite Runner', 'Khaled Hosseini', 'Drama', 'A story of friendship and redemption set in Afghanistan',
        'Riverhead Books', '2003', 15);


INSERT INTO books (title, author, genre, description, publisher, publication_year, total_copies)
VALUES ('Memoirs of a Geisha', 'Arthur Golden', 'Historical Fiction', 'A tale of a young girl who becomes a geisha',
        'Knopf', '1997', 10);


INSERT INTO books (title, author, genre, description, publisher, publication_year, total_copies)
VALUES ('The Girl with the Dragon Tattoo', 'Stieg Larsson', 'Thriller',
        'A gripping mystery involving a journalist and a hacker', 'Norstedts Förlag', '2005', 14);


INSERT INTO books (title, author, genre, description, publisher, publication_year, total_copies)
VALUES ('A Game of Thrones', 'George R.R. Martin', 'Fantasy',
        'The first book in the epic series A Song of Ice and Fire', 'Bantam Books', '1996', 18);

-- Users
INSERT INTO users (first_name, last_name, username, email, phone_number, role, password)
VALUES ('John', 'Doe', 'johnd', 'john.doe@gmail.com', '0745123991', 'CUSTOMER',
        '$2a$10$HmQiDNc4sUUFZvb7lAPGSuRxNwlHE1fki5ViBDbKnYu0gbfCXQMJy');


INSERT INTO users (first_name, last_name, username, email, phone_number, role, password)
VALUES ('Jane', 'Smith', 'janes', 'jane.smith@gmail.com', '0768743910', 'CUSTOMER',
        '$2a$10$HmQiDNc4sUUFZvb7lAPGSuRxNwlHE1fki5ViBDbKnYu0gbfCXQMJy');


INSERT INTO users (first_name, last_name, username, email, phone_number, role, password)
VALUES ('Alice', 'Johnson', 'alicej', 'alice.johnson@gmail.com', '0770546110', 'CUSTOMER',
        '$2a$10$HmQiDNc4sUUFZvb7lAPGSuRxNwlHE1fki5ViBDbKnYu0gbfCXQMJy');


INSERT INTO users (first_name, last_name, username, email, phone_number, role, password)
VALUES ('Bob', 'Brown', 'bobb', 'bob.brown@gmail.com', '0769193525', 'CUSTOMER',
        '$2a$10$HmQiDNc4sUUFZvb7lAPGSuRxNwlHE1fki5ViBDbKnYu0gbfCXQMJy');


INSERT INTO users (first_name, last_name, username, email, phone_number, role, password)
VALUES ('Charlie', 'Davis', 'charlied', 'charlie.davis@gmail.com', '0760895206', 'CUSTOMER',
        '$2a$10$HmQiDNc4sUUFZvb7lAPGSuRxNwlHE1fki5ViBDbKnYu0gbfCXQMJy');


INSERT INTO users (first_name, last_name, username, email, phone_number, role, password)
VALUES ('Cristina', 'Titu', 'cristinat', 'cristina.titu@btrl.ro', '0778809031', 'LIBRARIAN',
        '$2a$10$HmQiDNc4sUUFZvb7lAPGSuRxNwlHE1fki5ViBDbKnYu0gbfCXQMJy');


INSERT INTO users (first_name, last_name, username, email, phone_number, role, password)
VALUES ('Adelina', 'Mihu', 'adem', 'adelina.mihu@btrl.ro', '0770427491', 'LIBRARIAN',
        '$2a$10$HmQiDNc4sUUFZvb7lAPGSuRxNwlHE1fki5ViBDbKnYu0gbfCXQMJy');


INSERT INTO users (first_name, last_name, username, email, phone_number, role, password)
VALUES ('Marian', 'Cap', 'marianc', 'marian.cap@btrl.ro', '0790226350', 'LIBRARIAN',
        '$2a$10$HmQiDNc4sUUFZvb7lAPGSuRxNwlHE1fki5ViBDbKnYu0gbfCXQMJy');


INSERT INTO users (first_name, last_name, username, email, phone_number, role, password)
VALUES ('Claudiu', 'Marian', 'cladium', 'claudiu.marian@btrl.ro', '0742043896', 'LIBRARIAN',
        '$2a$10$HmQiDNc4sUUFZvb7lAPGSuRxNwlHE1fki5ViBDbKnYu0gbfCXQMJy');


INSERT INTO users (first_name, last_name, username, email, phone_number, role, password)
VALUES ('Patricia', 'Mot', 'patriciam', 'patricia.mot@btrl.ro', '0748947454', 'LIBRARIAN',
        '$2a$10$HmQiDNc4sUUFZvb7lAPGSuRxNwlHE1fki5ViBDbKnYu0gbfCXQMJy');

-- Insertion for the BORROWED status (no return_date, no fee)
INSERT INTO borrows (user_id, book_id, borrow_date, due_date, return_date, status, fee)
VALUES (1, 1, '2024-07-20', '2024-08-19', NULL, 'BORROWED', 0);

INSERT INTO borrows (user_id, book_id, borrow_date, due_date, return_date, status, fee)
VALUES (2, 2, '2023-07-25', '2023-08-24', NULL, 'BORROWED', 0);

INSERT INTO borrows (user_id, book_id, borrow_date, due_date, return_date, status, fee)
VALUES (3, 3, '2023-07-30', '2023-08-29', NULL, 'BORROWED', 0);

INSERT INTO borrows (user_id, book_id, borrow_date, due_date, return_date, status, fee)
VALUES (4, 4, '2024-08-05', '2024-09-04', NULL, 'BORROWED', 0);

INSERT INTO borrows (user_id, book_id, borrow_date, due_date, return_date, status, fee)
VALUES (5, 5, '2024-08-10', '2024-09-09', NULL, 'BORROWED', 0);

-- Insertion for the RETURNED status (with return_date and fee)
INSERT INTO borrows (user_id, book_id, borrow_date, due_date, return_date, status, fee)
VALUES (1, 6, '2023-06-01', '2023-06-30', '2023-07-02', 'RETURNED', 1.0);

INSERT INTO borrows (user_id, book_id, borrow_date, due_date, return_date, status, fee)
VALUES (2, 7, '2023-05-10', '2023-06-10', '2023-06-20', 'RETURNED', 5.0);

INSERT INTO borrows (user_id, book_id, borrow_date, due_date, return_date, status, fee)
VALUES (3, 8, '2023-03-15', '2023-04-14', '2023-04-18', 'RETURNED', 2.0);

-- Insertion for the RETURNED status (with return_date and no fee)
INSERT INTO borrows (user_id, book_id, borrow_date, due_date, return_date, status, fee)
VALUES (4, 9, '2023-07-01', '2023-07-30', '2023-07-28', 'RETURNED', 0);

INSERT INTO borrows (user_id, book_id, borrow_date, due_date, return_date, status, fee)
VALUES (5, 10, '2023-04-01', '2023-05-01', '2023-05-01', 'RETURNED', 0);
