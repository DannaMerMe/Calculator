package co.edu.uptc.animals_rest.services;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.Date;
import java.util.List;

import co.edu.uptc.animals_rest.models.Category;
import org.springframework.stereotype.Service;

import co.edu.uptc.animals_rest.exception.InvalidRangeException;
import co.edu.uptc.animals_rest.models.Animal;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
@Service
public class AnimalService {
     private static final Logger logger = LoggerFactory.getLogger(AnimalService.class);
    @Value("${animal.file.path}")
    private String filePath;

    
    public List<Animal> getAnimalInRange(int from, int to) throws IOException {
        List<String> listAnimal = Files.readAllLines(Paths.get(filePath));
        List<Animal> animales = new ArrayList<>();
        
        if (from < 0 || to >= listAnimal.size() || from > to) {
            logger.warn("Invalid range: Please check the provided indices. Range: 0 to {}",listAnimal.size());
             throw new InvalidRangeException("Invalid range: Please check the provided indices.");
        }

        for (String line : listAnimal) {
            String[] parts = line.split(",");
            if (parts.length == 2) {
                String categoria = parts[0].trim();
                String nombre = parts[1].trim();                
                animales.add(new Animal(nombre, categoria,nameHost(),String.valueOf(Date.from(Instant.now()))));
            }
        }
    
        return animales.subList(from, to + 1);
    }

    public List<Animal> getAnimalAll() throws IOException {
        List<String> listAnimal = Files.readAllLines(Paths.get(filePath));
        List<Animal> animales = new ArrayList<>();
        

        for (String line : listAnimal) {
            String[] parts = line.split(",");
            if (parts.length == 2) {
                String category = parts[0].trim();
                String name = parts[1].trim();                
                animales.add(new Animal(name, category,nameHost(),String.valueOf(Date.from(Instant.now()))));
            }
        }
    
        return animales;
    }

    public List<Category> getCantAnimalForCategory() throws IOException {
        List<String> listAnimal = Files.readAllLines(Paths.get(filePath));
        List<Category> categories = new ArrayList<>();
        for (String line: listAnimal){
            String [] parts = line.split(",");
            if (parts.length == 2){
                String category = parts[0].trim();
                String name = parts[1].trim();
                Category aux = searchCategories(categories,category);
                if (aux.getCategory().isEmpty()){
                    categories.add(new Category(category,1,nameHost(),String.valueOf(Date.from(Instant.now()))));
                }else{
                    int x = aux.getNumber();
                    aux.setNumber(x+1);
                }
            }
        }
        return categories;
    }

    private Category searchCategories(List<Category> tmp,String nameCategory){
        Category category = new Category("",0,nameHost(),String.valueOf(Date.from(Instant.now())));
        for (Category aux: tmp){
            if (aux.getCategory().compareToIgnoreCase(nameCategory)==0){
                category = aux;
            }
        }
        return category;
    }

    private String nameHost(){
        InetAddress inetAddress = null;
        try {
            inetAddress = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        return inetAddress.getHostName();
    }

}

