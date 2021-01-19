package ru.sberbank.contractsync.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class SyncStatusConverter implements AttributeConverter<SyncStatus, Character> {

    public Character convertToDatabaseColumn(SyncStatus syncStatus) {
        if (syncStatus == null) {
            return null;
        }
        return syncStatus.getCode();
    }

    @Override
    public SyncStatus convertToEntityAttribute(Character code) {
        if (code == null) {
            return null;
        }

        return Stream.of(SyncStatus.values())
                .filter(c -> c.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
