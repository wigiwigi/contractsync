
if not exists
(select 1
   from INFORMATION_SCHEMA.TABLES
  where TABLE_SCHEMA = 'dbo'
    and TABLE_NAME = 'syncContracts'
)
  create table dbo.syncContracts
  (
    ID int IDENTITY, CONSTRAINT PK_syncContracts_ID PRIMARY KEY CLUSTERED (ID),
    SyncStatus char default 'R', --R - ready, P - processing, C - completed, E - error
    IsNewContract bit default 1,
    ErrorMes varchar(255) null,
    ContractData xml
  );