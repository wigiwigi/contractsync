IF EXISTS (SELECT 1 FROM sys.objects WHERE type = 'P' AND name = 'syncContractsGet')
DROP PROCEDURE syncContractsGet
GO
/*
достает одну запись из syncContractsGet со статусом 'R' и переводит её в статус 'P'
 */

CREATE PROCEDURE dbo.syncContractsGet
AS

SET NOCOUNT ON

BEGIN

  declare @ID table (ID int);

  update top(1) syncContracts
  set SyncStatus = 'P'
  output inserted.ID into @ID
  where SyncStatus = 'R'

  select c.* from syncContracts c join @ID id on id.ID = c.ID

END