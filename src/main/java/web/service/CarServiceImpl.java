package web.service;

import web.dao.CarDao;
import web.dao.CarDaoImpl;
import model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class CarServiceImpl implements CarService{
    private final CarDao carDao;
    @Autowired
    public CarServiceImpl(CarDao carDao) {
        this.carDao = carDao;
    }

   // @Override
//    public List<Car> showCars() {
//        return carDao.showCars();
//    }
    @Override
    public List<Car> showCars(String count) throws IOException {

        if (count != null) {
            int carCounter = Integer.parseInt(count);
            if (carCounter < 0){
                throw new IOException();
            }
        return carDao.showCars(carCounter);
        }
        return carDao.showCars();
    }

}
