
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
 
@ManagedBean
@ViewScoped
public class DataGridView implements Serializable {
     
    private List<Produto> cars;
     
    private Produto selectedCar;
     
    @ManagedProperty("#{carService}")
    private CarService service;
     
    @PostConstruct
    public void init() {
        cars = service.createCars(12);
    }
 
    public List<Produto> getCars() {
        return cars;
    }
 
    public void setService(CarService service) {
        this.service = service;
    }
 
    public Produto getSelectedCar() {
        return selectedCar;
    }
 
    public void setSelectedCar(Produto selectedCar) {
        this.selectedCar = selectedCar;
    }
}
