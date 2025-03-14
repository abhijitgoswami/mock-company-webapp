package com.mockcompany.webapp.service;

import com.mockcompany.webapp.data.ProductItemRepository;
import com.mockcompany.webapp.model.ProductItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SearchService {

    private final ProductItemRepository productItemRepository;

    @Autowired
    public SearchService(ProductItemRepository productItemRepository) {
        this.productItemRepository = productItemRepository;
    }

    public List<ProductItem> getProductItems(String query) {

        Iterable<ProductItem> allItems = this.productItemRepository.findAll();
        List<ProductItem> itemList = new ArrayList<>();

        // This is a loop that the code inside will execute on each of the items from the database.
        for (ProductItem item : allItems) {
            // TODO: Figure out if the item should be returned based on the query parameter!
            boolean matchesSearch = true;
            if((query.startsWith("\"") && query.endsWith("\"")) && (item.getName().equalsIgnoreCase(query.substring(1, query.length() - 1)) || item.getDescription().equalsIgnoreCase(query.substring(1, query.length() - 1)))) {
                itemList.add(item);
            }
            else if(item.getName().toLowerCase().contains(query.toLowerCase()) || item.getDescription().toLowerCase().contains(query.toLowerCase())) {
                itemList.add(item);
            }
        }
        return itemList;
    }

    public List<Number> getProductID(String query) {

        Iterable<ProductItem> allItems = this.productItemRepository.findAll();
        List<Number> Ids = new ArrayList<>();

        // This is a loop that the code inside will execute on each of the items from the database.
        for (ProductItem item : allItems) {
            // TODO: Figure out if the item should be returned based on the query parameter!
            boolean matchesSearch = true;
            if((query.startsWith("\"") && query.endsWith("\"")) && (item.getName().equalsIgnoreCase(query.substring(1, query.length() - 1)) || item.getDescription().equalsIgnoreCase(query.substring(1, query.length() - 1)))) {
                Ids.add(item.getId());
            }
            else if(item.getName().toLowerCase().contains(query.toLowerCase()) || item.getDescription().toLowerCase().contains(query.toLowerCase())) {
                Ids.add(item.getId());
            }
        }
        return Ids;
    }
}
