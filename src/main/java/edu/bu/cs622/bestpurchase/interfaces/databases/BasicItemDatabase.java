package edu.bu.cs622.bestpurchase.interfaces.databases;

import edu.bu.cs622.bestpurchase.entities.ids.IdType;
import edu.bu.cs622.bestpurchase.entities.store.Item;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class BasicItemDatabase extends AbstractBasicDatabase<IdType, Item> implements ItemDatabase {

    @Inject
    public BasicItemDatabase() {
        super();
    }

    @Override
    IdType getPrimaryKey(Item entity) {
        return entity.getId();
    }
}