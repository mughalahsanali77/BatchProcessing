package com.batchprocessing.configuration;

import com.batchprocessing.model.Record;
import org.springframework.batch.item.ItemProcessor;

public class CustomItemProcessor implements ItemProcessor<Record, Record> {
  @Override
  public Record process(Record item) throws Exception {
    try {
      int discountPercentage=Integer.parseInt(item.getDiscount().trim());
      double originalPrice=Double.parseDouble(item.getPrice().trim());
      double discount=(discountPercentage/100)*originalPrice;
      double finalPrice=originalPrice-discount;
      item.setDiscountedPrice(String.valueOf(finalPrice));
    }catch (NumberFormatException e){
      e.printStackTrace();
    }
    return item;
  }
}
