package ru.sberbank.contractsync.entity;

public enum SyncStatus {
    READY('R'), PROCESSING('P'), COMPLETED('C'), ERROR('E');

    private Character code;

    private SyncStatus(Character code) {
        this.code = code;
    }

    public Character getCode() {
        return code;
    }
}
