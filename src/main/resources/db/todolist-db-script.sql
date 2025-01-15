-- Create the database
IF NOT EXISTS (SELECT * FROM sys.databases WHERE name = 'TodoListDB')
BEGIN
    CREATE DATABASE TodoListDB;
END
GO

USE TodoListDB;
GO

-- Create Users table
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[User]') AND type in (N'U'))
BEGIN
    CREATE TABLE Users (
        UserId INT IDENTITY(1,1) PRIMARY KEY,
        Username NVARCHAR(50) NOT NULL UNIQUE,
        Email NVARCHAR(100) NOT NULL UNIQUE,
        Password NVARCHAR(100) NOT NULL,
        UpdatedDate DATETIME DEFAULT GETDATE()
    );
END
GO

-- Create TodoLists table
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[TodoList]') AND type in (N'U'))
BEGIN
    CREATE TABLE TodoLists (
        ListId INT IDENTITY(1,1) PRIMARY KEY,
        UserId INT NOT NULL,
        Title NVARCHAR(100) NOT NULL,
        Description NVARCHAR(500),
        UpdatedDate DATETIME DEFAULT GETDATE(),
        FOREIGN KEY (UserId) REFERENCES Users(UserId)
    );
END
GO

-- Create TodoItems table
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[TodoItem]') AND type in (N'U'))
BEGIN
    CREATE TABLE TodoItems (
        ItemId INT IDENTITY(1,1) PRIMARY KEY,
        ListId INT NOT NULL,
        Title NVARCHAR(100) NOT NULL,
        Description NVARCHAR(500),
        DueDate DATETIME,
        Priority INT DEFAULT 0,
        IsCompleted BIT DEFAULT 0,
        UpdatedDate DATETIME DEFAULT GETDATE(),
        FOREIGN KEY (ListId) REFERENCES TodoLists(ListId)
    );
END
GO


-- Create index for faster queries
IF NOT EXISTS (SELECT * FROM sys.indexes WHERE name = 'IX_TodoItems_ListId' AND object_id = OBJECT_ID('TodoItems'))
BEGIN
    CREATE INDEX IX_TodoItems_ListId ON TodoItems(ListId);
END
GO