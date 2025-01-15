-- Create the database
IF NOT EXISTS (SELECT * FROM sys.databases WHERE name = 'TodoListDB')
BEGIN
    CREATE DATABASE TodoListDB;
END
GO

USE TodoListDB;
GO

-- Create Users table
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[user]') AND type in (N'U'))
BEGIN
	CREATE TABLE TodoListDB.dbo.todo_user (
		user_id bigint IDENTITY(1,1) NOT NULL,
		username varchar(50) NOT NULL,
		email varchar(100) NOT NULL,
		password varchar(100) NOT NULL,
		updated_date datetime2(6) NOT NULL,

		CONSTRAINT PK__todo_use__B9BE370F116677F8 PRIMARY KEY (user_id),
		CONSTRAINT UKa87ptdjn6xs9wxsofa7f2ui4b UNIQUE (email),
		CONSTRAINT UKhlxrl33a7px5wmvgm5o1abx3r UNIQUE (username)
	);
END
GO

-- Create TodoLists table
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[TodoList]') AND type in (N'U'))
BEGIN
	CREATE TABLE TodoListDB.dbo.todo_list (
		list_id bigint IDENTITY(1,1) NOT NULL,
		description varchar(500)  NULL,
		title varchar(100) NOT NULL,
		updated_date datetime2(6) NOT NULL,
		user_id bigint NOT NULL,
		CONSTRAINT PK__todo_lis__7B9EF135E0656893 PRIMARY KEY (list_id),
		CONSTRAINT FKg8dil33hvmx3oiep445vejvab FOREIGN KEY (user_id) REFERENCES TodoListDB.dbo.todo_user(user_id)
	);
END
GO

-- Create TodoItems table
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[TodoItem]') AND type in (N'U'))
BEGIN
	CREATE TABLE TodoListDB.dbo.todo_item (
		item_id bigint IDENTITY(1,1) NOT NULL,
		description varchar(500)  NULL,
		due_date datetime2(6) NULL,
		is_completed bit NOT NULL,
		priority int NULL,
		title varchar(100) NOT NULL,
		updated_date datetime2(6) NOT NULL,
		list_id bigint NOT NULL,
		CONSTRAINT PK__todo_ite__52020FDD346724D9 PRIMARY KEY (item_id),
		CONSTRAINT FK8ugl4ng70y2cbc3926pu0h9hw FOREIGN KEY (list_id) REFERENCES TodoListDB.dbo.todo_list(list_id)
	);
	 CREATE NONCLUSTERED INDEX ix_todo_item_list_id ON dbo.todo_item (  list_id ASC  )  
		 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
		 ON [PRIMARY ] ;
END
GO


-- Create index for faster queries
IF NOT EXISTS (SELECT * FROM sys.indexes WHERE name = 'ix_todo_item_list_id' AND object_id = OBJECT_ID('todo_item'))
BEGIN
    CREATE INDEX ix_todo_item_list_id ON todo_item(list_id);
END
GO