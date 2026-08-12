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

    public boolean save(Object obj) {
        // TODO 1: productDto 전달받아 DAO의 save()를 호출하고 결과 반환
        Object obj1 = obj;
        boolean result = ib.save(obj1);
        return result;
    }

    public ArrayList<ProductDto> findAll() {
    // <ProductDto> -> <Object> 업캐스팅?
    // 새로운 하위 타입의 배열을 하나 더 만들어서 그걸 전달한다.
    ArrayList<Object> list = ib.findAll();
    ArrayList<ProductDto> result = new ArrayList<>();
    for(Object item : list){
        result.add((ProductDto)item);
    }
        return result;
    }
}