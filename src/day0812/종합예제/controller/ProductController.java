package day0812.종합예제.controller;

import java.util.ArrayList;

import day0812.종합예제.model.dao.IBaseDao;
import day0812.종합예제.model.dao.ProductDao;
import day0812.종합예제.model.dto.ProductDto;

public class ProductController {
    private ProductController() {}
    private static final ProductController instance = new ProductController();
    public static ProductController getInstance() { return instance; }

    private IBaseDao ib = ProductDao.getInstance();

    public boolean save(ProductDto productDto) {
        // TODO 1: productDto 전달받아 DAO의 save()를 호출하고 결과 반환
        Object obj1 = productDto;
        boolean result = ib.save(obj1);
        return result;
    }

    // 반환
    public ArrayList<ProductDto> findAll() {
    //Object -> ProductDto
    ArrayList<Object> list = ib.findAll();
    ArrayList<ProductDto> result = new ArrayList<>();
    //ArrayList 끼리는 상속관계 아니므로
    //변환할 타입의 새로운 배열에 하나씩 옮겨 담는다.
    for(Object item : list){
        result.add((ProductDto)item);
    }
        return result;
    }
}