package edu.bu.cs622.bestpurchase.interfaces;

import edu.bu.cs622.bestpurchase.entities.IdType;
import edu.bu.cs622.bestpurchase.entities.Item;

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
