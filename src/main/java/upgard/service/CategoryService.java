package upgard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upgard.Model.Categories;
import upgard.repository.CategoryRepository;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public Categories create(Categories category){
        return categoryRepository.create(category);
    }

    public Categories getCategory(String name){
       return categoryRepository.getCategory(name);
    }
}
